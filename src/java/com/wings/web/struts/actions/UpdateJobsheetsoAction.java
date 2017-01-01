package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.utils.PopulateJobsheetDetail;
import com.wings.web.struts.forms.BillingagentForm;
import com.wings.web.struts.forms.BillingshipperForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.ExpensesagentForm;
import com.wings.web.struts.forms.ExpensesshipperForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetsoDetailForm;
import com.wings.web.struts.forms.JobsheetsoForm;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;

public final class UpdateJobsheetsoAction extends Action {

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
       
      ServletContext context = this.getServlet().getServletConfig().getServletContext();
       
      totalBillingIDR = 0.0;
      totalBillingUSD = 0.0;
      totalExpensesIDR = 0.0;
      totalExpensesUSD = 0.0; 
      
      try {
         DynaActionForm dform = (DynaActionForm) form;
         
         List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
         request.setAttribute("agentfees", agentfeeList); 
          
         List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
         request.setAttribute("shipperfees", shipperfeeList); 
                    
         JobsheetsoDetailForm jobsheetsoDetailForm = new JobsheetsoDetailForm();
         RequestUtils.populate(jobsheetsoDetailForm, request);
         jobsheetsoDetailForm = this.checkForAvailableMaster(jobsheetsoDetailForm);
         
         JobsheetForm jobsheetForm = new JobsheetForm();
         BeanUtils.copyProperties(jobsheetForm, jobsheetsoDetailForm);
         jobsheetForm.setIdJobType("SO");
         //jobsheetForm.setIdTransporter(jobsheetsoDetailForm.getTrucking());
         
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
         
         JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
         BeanUtils.copyProperties(jobsheetsoForm, jobsheetsoDetailForm);
         
         try {
             jobsheetsoForm.setEtadestination(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getEtadestinationAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsoForm.setEtadestination(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsoForm.setEtadestination(null);
         }
         try {
             jobsheetsoForm.setEtdorigin(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getEtdoriginAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsoForm.setEtdorigin(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsoForm.setEtdorigin(null);
         }
         try {
             jobsheetsoForm.setSinDate(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getSinDateAsString()).getTime()));
         } catch (ParseException pe) {
             //jobsheetsoForm.setSinDate(new java.util.Date((new java.util.Date()).getTime()));
             jobsheetsoForm.setSinDate(null);
         }
         jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
         JobsheetsoForm jobsheetsoForm2 = new JobsheetsoForm();
         jobsheetsoForm2.setIdJobSheet(jobsheetForm.getIdJobSheet());
         
         jobsheetsoForm2 = com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm2);
         
         if (jobsheetsoForm2.getIdJobSheetSo()==null) {
             com.wings.adapter.StrutsJobsheetsoDelegate.removeByIdJobSheet(jobsheetKey);
             jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.create(jobsheetsoForm);
         } else {
             if (jobsheetsoForm2.getIdJobSheetSo().intValue()>0) {
                 jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.update(jobsheetsoForm);                  
             } else {
                 com.wings.adapter.StrutsJobsheetsoDelegate.removeByIdJobSheet(jobsheetKey);
                 jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.create(jobsheetsoForm);
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
         
         request.setAttribute("jobsheetso", jobsheetsoDetailForm);
         String MAPPING = "";
         if (request.getParameter("action").equalsIgnoreCase("Update")) {
             MAPPING = "view";
         } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             // do print
             response.sendRedirect("printJobsheetso.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
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
   private JobsheetsoDetailForm  checkForAvailableMaster(JobsheetsoDetailForm jobsheetsoDetailForm) throws Exception {
                  
       return jobsheetsoDetailForm;
   }   
   
   
}
