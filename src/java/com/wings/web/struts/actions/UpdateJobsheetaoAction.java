package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.utils.PopulateJobsheetDetail;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaoDetailForm;
import com.wings.web.struts.forms.JobsheetaoForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.*;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;


public final class UpdateJobsheetaoAction extends Action {

   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private double totalBillingIDR = 0.0;
   private double totalBillingUSD = 0.0;
   private double totalExpensesIDR = 0.0;
   private double totalExpensesUSD = 0.0;
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
          
    totalBillingIDR = 0.0;
    totalBillingUSD = 0.0;
    totalExpensesIDR = 0.0;
    totalExpensesUSD = 0.0; 
    
       ServletContext context = this.getServlet().getServletConfig().getServletContext();
       DynaActionForm dform = (DynaActionForm) form;
       JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();
       try {
         
         RequestUtils.populate(jobsheetaoDetailForm, request);
         jobsheetaoDetailForm = this.checkForAvailableMaster(jobsheetaoDetailForm);
                    
         List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
         request.setAttribute("agentfees", agentfeeList); 
          
         List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
         request.setAttribute("shipperfees", shipperfeeList); 
                              
         JobsheetForm jobsheetForm = new JobsheetForm();
         BeanUtils.copyProperties(jobsheetForm, jobsheetaoDetailForm);
         jobsheetForm.setIdJobType("AO");
         
         if (request.getParameter("action").equalsIgnoreCase("ACC")) {
            jobsheetForm.setStatus(new Integer(1));
            com.wings.adapter.StrutsJobsheetDelegate.updateStatus(jobsheetForm);         
            return mapping.findForward("view");   
         } else if (request.getParameter("action").equalsIgnoreCase("UNACC")) {
            jobsheetForm.setStatus(new Integer(0));
            com.wings.adapter.StrutsJobsheetDelegate.updateStatus(jobsheetForm);         
            return mapping.findForward("view");   
         }
         
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.update(jobsheetForm);
         JobsheetKey jobsheetKey = new JobsheetKey();
         jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
         
         JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
         BeanUtils.copyProperties(jobsheetaoForm, jobsheetaoDetailForm);                  
         
         jobsheetaoForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         JobsheetaoForm jobsheetaoForm2 = new JobsheetaoForm();
         jobsheetaoForm2.setIdJobSheet(jobsheetKey.getIdJobSheet());
         
         jobsheetaoForm2 = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm2);
         if(jobsheetaoForm2.getIdJobSheetAo()==null) {
             com.wings.adapter.StrutsJobsheetaoDelegate.removeByIdJobSheet(jobsheetKey);
             jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.create(jobsheetaoForm);
         } else {
             if (jobsheetaoForm2.getIdJobSheetAo().intValue()>0) {
                     jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.update(jobsheetaoForm);
             } else {
                 com.wings.adapter.StrutsJobsheetaoDelegate.removeByIdJobSheet(jobsheetKey);
                 jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.create(jobsheetaoForm);
             }         
         }         
         com.wings.adapter.StrutsBillingagentDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsBillingshipperDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesagentDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesshipperDelegate.removeByJobsheetKey(jobsheetKey);                  
         
         DateTime atddate = new DateTime(jobsheetForm.getShippeddate());
         
         try {
            com.wings.utils.PopulateInvoiceAndDebit.generateInvoiceAndDebit(request, jobsheetForm, atddate, jobsheetKey);                                    
            PopulateJobsheetDetail.processingPopulatedDetailItem(request, jobsheetKey, agentfeeList, shipperfeeList, 
                                        jobsheetForm);
         } catch (Exception e) {             
         }
                             
         request.setAttribute("jobsheetao", jobsheetaoDetailForm);
         String MAPPING = "";
          if (request.getParameter("action").equalsIgnoreCase("Update")) {
             MAPPING = "view";
          } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             // do print
             response.sendRedirect("printJobsheetao.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
          }
          return mapping.findForward(MAPPING);  
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while updating data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "update");      
         return mapping.findForward("form");
      }
     
   }
   private JobsheetaoDetailForm  checkForAvailableMaster(JobsheetaoDetailForm jobsheetaoDetailForm) throws Exception {
        
       return jobsheetaoDetailForm;
   }
   
}
