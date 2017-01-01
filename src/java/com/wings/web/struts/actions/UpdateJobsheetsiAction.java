package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.utils.PopulateJobsheetDetail;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetsiDetailForm;
import com.wings.web.struts.forms.JobsheetsiForm;
import java.io.IOException;
import java.text.ParseException;
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

public final class UpdateJobsheetsiAction extends Action {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy"); 
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
      try {
         DynaActionForm dform = (DynaActionForm) form;
         
         List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
         request.setAttribute("agentfees", agentfeeList); 
          
         List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
         request.setAttribute("shipperfees", shipperfeeList); 
                    
         JobsheetsiDetailForm jobsheetsiDetailForm = new JobsheetsiDetailForm();
         RequestUtils.populate(jobsheetsiDetailForm, request);
         jobsheetsiDetailForm = this.checkForAvailableMaster(jobsheetsiDetailForm);
         
         JobsheetForm jobsheetForm = new JobsheetForm();
         BeanUtils.copyProperties(jobsheetForm, jobsheetsiDetailForm);
         jobsheetForm.setIdJobType("SI");
         
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
         
         JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
         BeanUtils.copyProperties(jobsheetsiForm, jobsheetsiDetailForm);
         try {
             jobsheetsiForm.setEtaorigin(new java.util.Date(FORMAT.parse(jobsheetsiDetailForm.getEtaoriginAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsiForm.setEtaorigin(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsiForm.setEtaorigin(null);
         }
         try {
             jobsheetsiForm.setEtdorigin(new java.util.Date(FORMAT.parse(jobsheetsiDetailForm.getEtdoriginAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsiForm.setEtdorigin(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsiForm.setEtdorigin(null);
         }
         try {
             jobsheetsiForm.setCustomeDate(new java.util.Date(FORMAT.parse(jobsheetsiDetailForm.getCustomDateAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsiForm.setCustomeDate(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsiForm.setCustomeDate(null);
         }
         jobsheetsiForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         JobsheetsiForm jobsheetsiForm2 = new JobsheetsiForm();
         jobsheetsiForm2.setIdJobSheet(jobsheetKey.getIdJobSheet());
         jobsheetsiForm2 = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm2);
         if (jobsheetsiForm2.getIdJobSheetSi()==null) {
             com.wings.adapter.StrutsJobsheetsiDelegate.removeByIdJobSheet(jobsheetKey);
             jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.create(jobsheetsiForm);
         } else {
             if (jobsheetsiForm2.getIdJobSheetSi().intValue()>0) {             
                 jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.update(jobsheetsiForm);                               
             } else {
                 com.wings.adapter.StrutsJobsheetsiDelegate.removeByIdJobSheet(jobsheetKey);
                 jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.create(jobsheetsiForm);
             }
         }         
       
         com.wings.adapter.StrutsBillingagentDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsBillingshipperDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesagentDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesshipperDelegate.removeByJobsheetKey(jobsheetKey);
         
 
         ConsigneeForm consigneeForm = new ConsigneeForm();
         consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
         consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
         
         DateTime atddate = new DateTime(jobsheetForm.getShippeddate());

         try {
            com.wings.utils.PopulateInvoiceAndDebit.generateInvoiceAndDebit(request, jobsheetForm, atddate, jobsheetKey);         
            PopulateJobsheetDetail.processingPopulatedDetailItem(request, jobsheetKey, agentfeeList, shipperfeeList, 
                                        jobsheetForm);
         } catch (Exception e) {             
         }
                             
         request.setAttribute("jobsheetsi", jobsheetsiDetailForm);
         String MAPPING = "";
         if (request.getParameter("action").equalsIgnoreCase("Update")) {
             MAPPING = "view";
         } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             // do print
             response.sendRedirect("printJobsheetsi.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
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
   
   private JobsheetsiDetailForm  checkForAvailableMaster(JobsheetsiDetailForm jobsheetsiDetailForm) throws Exception {
                
       return jobsheetsiDetailForm;
   }   
   
   
}
