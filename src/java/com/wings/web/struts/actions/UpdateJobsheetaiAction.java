package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.utils.PopulateJobsheetDetail;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.BillingagentForm;
import com.wings.web.struts.forms.BillingshipperForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.ExpensesagentForm;
import com.wings.web.struts.forms.ExpensesshipperForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaiDetailForm;
import com.wings.web.struts.forms.JobsheetaiForm;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransactionaccForm;
import com.wings.web.struts.forms.TransporterForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;

public final class UpdateJobsheetaiAction extends Action {
 
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private double totalBillingIDR = 0.0;
   private double totalBillingUSD = 0.0;
   private double totalExpensesIDR = 0.0;
   private double totalExpensesUSD = 0.0;
   
   public ActionForward execute(
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
      JobsheetaiDetailForm jobsheetaiDetailForm = new JobsheetaiDetailForm();
      try {
        
         RequestUtils.populate(jobsheetaiDetailForm, request);
                  
         jobsheetaiDetailForm = this.checkForAvailableMaster(jobsheetaiDetailForm);
     
         List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
         request.setAttribute("agentfees", agentfeeList); 
          
         List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
         request.setAttribute("shipperfees", shipperfeeList); 
          
         JobsheetKey jobsheetKey = new JobsheetKey();
         jobsheetKey.setIdJobSheet(jobsheetaiDetailForm.getIdJobSheet());
         JobsheetForm jobsheetForm = new JobsheetForm();
         BeanUtils.copyProperties(jobsheetForm, jobsheetaiDetailForm);
         jobsheetForm.setIdJobType("AI");
         
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
         
         JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();
         BeanUtils.copyProperties(jobsheetaiForm, jobsheetaiDetailForm);
         
         jobsheetaiForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         JobsheetaiForm jobsheetaiForm2 = new JobsheetaiForm();
         jobsheetaiForm2.setIdJobSheet(jobsheetKey.getIdJobSheet());
         
         jobsheetaiForm2 = com.wings.adapter.StrutsJobsheetaiDelegate.editByIdJobsheet(jobsheetaiForm2);
         
         if (jobsheetaiForm2.getIdJobSheetAi()==null) {
             com.wings.adapter.StrutsJobsheetaiDelegate.removeByIdJobSheet(jobsheetKey);
             jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.create(jobsheetaiForm);
         } else {
             if (jobsheetaiForm2.getIdJobSheetAi().intValue()>0) {
                 jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.update(jobsheetaiForm);
             } else {
                 com.wings.adapter.StrutsJobsheetaiDelegate.removeByIdJobSheet(jobsheetKey);
                 jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.create(jobsheetaiForm);
             }         
         }
         
         com.wings.adapter.StrutsBillingagentDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsBillingshipperDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsExpensesagentDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsExpensesshipperDelegate.removeByJobsheetKey(jobsheetKey);
         
         ConsigneeForm consigneeForm = new ConsigneeForm();
         consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
         consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
         
         //String newKey = com.wings.adapter.StrutsJobnumberDelegate.selectNext();
         DateTime atddate = new DateTime(jobsheetForm.getShippeddate());                  
         
         try {
            com.wings.utils.PopulateInvoiceAndDebit.generateInvoiceAndDebit(request, jobsheetForm, atddate, jobsheetKey);                   
            PopulateJobsheetDetail.processingPopulatedDetailItem(request, jobsheetKey, agentfeeList, shipperfeeList, 
                                        jobsheetForm);
         } catch (Exception e) {             
         }   
                  
         request.setAttribute("jobsheetai", jobsheetaiDetailForm);
         String MAPPING = "";
          if (request.getParameter("action").equalsIgnoreCase("Update")) {
             MAPPING = "view";
          } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             response.sendRedirect("printJobsheetai.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
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
   
   private JobsheetaiDetailForm  checkForAvailableMaster(JobsheetaiDetailForm jobsheetaiDetailForm) throws Exception {
                  
       return jobsheetaiDetailForm;
   }
   
  
}
