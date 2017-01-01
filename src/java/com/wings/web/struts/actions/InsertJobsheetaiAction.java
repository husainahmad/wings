package com.wings.web.struts.actions;

import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.utils.PopulateJobsheetDetail;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaiDetailForm;
import com.wings.web.struts.forms.JobsheetaiForm;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransactionaccForm;
import com.wings.web.struts.forms.TransporterForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;


public final class InsertJobsheetaiAction extends Action {
   Logger log = Logger.getLogger(InsertJobsheetaiAction.class.getName());   
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
      try {
         DynaActionForm dform = (DynaActionForm) form;
         
         List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
         request.setAttribute("agentfees", agentfeeList); 

         List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
         request.setAttribute("shipperfees", shipperfeeList); 

         JobsheetaiDetailForm jobsheetaiDetailForm = new JobsheetaiDetailForm();
         RequestUtils.populate(jobsheetaiDetailForm, request);
                  
         JobsheetForm jobsheetForm = new JobsheetForm();
         BeanUtils.copyProperties(jobsheetForm, jobsheetaiDetailForm);
         jobsheetForm.setIdJobType("AI");         
                  
         DateTime atddate = new DateTime(jobsheetForm.getShippeddate());
         
         // create jobno
         Jobsheet jobsheet = new Jobsheet();
         jobsheet.setIdJobType(jobsheetForm.getIdJobType());
         jobsheet.setShippeddate(jobsheetForm.getShippeddate());
         jobsheet = com.wings.adapter.StrutsJobsheetDelegate.selectMaxJobNo(jobsheet);                           
         
         String finalKey = "WGL-" + String.valueOf(atddate.getYear()).substring(2) + StringUtils.leftPad(String.valueOf(atddate.getMonthOfYear()), 2, "0") + StringUtils.leftPad(jobsheet.getJobNo(),4,"0") + " AI";         
         jobsheetForm.setJobNo(finalKey);                           
                  
         //this line will return a new key        
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.create(jobsheetForm);         
         
         JobsheetKey jobsheetKey = new JobsheetKey();//com.wings.adapter.StrutsJobsheetDelegate.findLastJobsheetKey();
         jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());         
         
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
         
         JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();         
         BeanUtils.copyProperties(jobsheetaiForm, jobsheetaiDetailForm);
                          
         jobsheetaiForm.setIdJobSheet(jobsheetKey.getIdJobSheet());         
         jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.create(jobsheetaiForm);                           
                 
                                   
         try {
             // Generate Invoice and debit
            com.wings.utils.PopulateInvoiceAndDebit.generateInvoiceAndDebit(request, jobsheetForm, atddate, jobsheetKey);  
            
            PopulateJobsheetDetail.processingPopulatedDetailItem(request, jobsheetKey, agentfeeList, shipperfeeList, 
                                        jobsheetForm);          
         } catch (Exception e) {
             log.info(e);
         }
         
         com.wings.utils.PopulateTax.generateTax(jobsheetKey, jobsheetForm);
         
         request.setAttribute("jobsheetai", jobsheetaiDetailForm);
                  
         String MAPPING = "view";
          if (request.getParameter("action").equalsIgnoreCase("Save")) {
             MAPPING = "view";
          } else  if (request.getParameter("action").equalsIgnoreCase("copy")) {
             MAPPING = "view";   
          } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             // do print
             response.sendRedirect("printJobsheetai.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
          }
          return mapping.findForward(MAPPING);   
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "insert");      
         return mapping.findForward("form");
      }
   }
   private JobsheetaiDetailForm  checkForAvailableMaster(JobsheetaiDetailForm jobsheetaiDetailForm) throws Exception {
            
       return jobsheetaiDetailForm;
   }
   
         
}
