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
import com.wings.web.struts.forms.JobsheetsoDetailForm;
import com.wings.web.struts.forms.JobsheetsoForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransporterForm;
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

public final class InsertAsNewJobsheetsoAction extends Action {
   Logger log = Logger.getLogger(InsertAsNewJobsheetsoAction.class.getName());   
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
         
         DateTime atddate = new DateTime(jobsheetForm.getShippeddate());
         
        //this line will return a new key        
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.create(jobsheetForm);         
         
         JobsheetKey jobsheetKey = new JobsheetKey();//com.wings.adapter.StrutsJobsheetDelegate.findLastJobsheetKey();
         jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());         
         
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
         
         JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
         BeanUtils.copyProperties(jobsheetsoForm, jobsheetsoDetailForm);
         
         try {
             jobsheetsoForm.setEtadestination(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getEtadestinationAsString()).getTime()));
         } catch (ParseException pe) {
             jobsheetsoForm.setEtadestination(new java.util.Date((new java.util.Date()).getTime()));
         }
         
         try {
             jobsheetsoForm.setEtdorigin(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getEtdoriginAsString()).getTime()));
         } catch (ParseException pe) {
             jobsheetsoForm.setEtdorigin(new java.util.Date((new java.util.Date()).getTime()));
         }
         
         try {
             jobsheetsoForm.setSinDate(new java.util.Date(FORMAT.parse(jobsheetsoDetailForm.getSinDateAsString()).getTime()));
         } catch (ParseException pe) {
             jobsheetsoForm.setSinDate(new java.util.Date((new java.util.Date()).getTime()));
         }
         jobsheetsoForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.create(jobsheetsoForm);
                  
         // account process         
         com.wings.adapter.StrutsTransactionaccDelegate.insertJobsheetTransaction(jobsheetForm);
                  
         ConsigneeForm consigneeForm = new ConsigneeForm();
         consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
         consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
         
         try {
             com.wings.utils.PopulateInvoiceAndDebit.generateInvoiceAndDebit(request, jobsheetForm, atddate, jobsheetKey);                  
             PopulateJobsheetDetail.processingPopulatedDetailItem(request, jobsheetKey, agentfeeList, shipperfeeList, 
                                            jobsheetForm);
         } catch (Exception e) {             
         }         
         
         com.wings.utils.PopulateTax.generateTax(jobsheetKey, jobsheetForm);
         
         request.setAttribute("jobsheetso", jobsheetsoDetailForm);
                  
         String MAPPING = "";
         if (request.getParameter("action").equalsIgnoreCase("Save")) {
             MAPPING = "view";
         } else if (request.getParameter("action").equalsIgnoreCase("Print")) {
             // do print
             response.sendRedirect("printJobsheetso.do?idJobSheet="+jobsheetKey.getIdJobSheet());             
         }
         return mapping.findForward(MAPPING);
      } catch (Exception e) {
         log.error(e);
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "insert");      
         return mapping.findForward("form");
      }
   }
   
   private JobsheetsoDetailForm  checkForAvailableMaster(JobsheetsoDetailForm jobsheetsoDetailForm) throws Exception {
                    
       return jobsheetsoDetailForm;
   }
      
   //AgentDebit = BillingAgent
   private List populateBillingAgentDebit(HttpServletRequest request, Integer idJobSheet) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaDebit"));          
      List baDebitList = new ArrayList();
      BillingagentForm billingagent = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;      
      String kurs = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "billingidAgentFeeDebit"+i;
          charge = "billingAgentChargeDebit"+i;
          desc = "billingAgentDescDebit"+i;
          kurs = "billingAgentKursDebit"+i;
          billingagent = new BillingagentForm();
          billingagent.setIdJobSheet(idJobSheet);
          billingagent.setIdAgentFee(Integer.valueOf(request.getParameter(idAgentFee)));
          try {
              billingagent.setCharge(Double.valueOf(request.getParameter(charge)));
          } catch (Exception e) {
              billingagent.setCharge(new Double(0.0));
          }          
          billingagent.setDescription(request.getParameter(desc));
          billingagent.setKurs(request.getParameter(kurs));
          baDebitList.add(billingagent);
      }
      return baDebitList;
   }
   //AgentInvoice = BillingShipper
   private List populateBillingAgentInvoice(HttpServletRequest request, Integer idJobSheet) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaInvoice"));          
      List baDebitList = new ArrayList();
      BillingshipperForm billingshipper = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;      
      String kurs = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "billingidAgentFeeInvoice"+i;
          charge = "billingAgentChargeInvoice"+i;
          desc = "billingAgentDescInvoice"+i;
          kurs = "billingAgentKursInvoice"+i;
          billingshipper = new BillingshipperForm();
          billingshipper.setIdJobSheet(idJobSheet);
          billingshipper.setIdShipperFee(Integer.valueOf(request.getParameter(idAgentFee)));
          try {
              billingshipper.setCharge(Double.valueOf(request.getParameter(charge)));
          } catch (Exception e) {
              billingshipper.setCharge(new Double(0.0));
          }
          billingshipper.setDescription(request.getParameter(desc));
          billingshipper.setKurs(request.getParameter(kurs));
          baDebitList.add(billingshipper);
      }
      return baDebitList;
   }
    //CostDebit = ExpensesAgent
   private List populateExpensesAgentDebit(HttpServletRequest request, Integer idJobSheet) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountexpensesagentDebit"));          
      List baDebitList = new ArrayList();
      ExpensesagentForm expensesagent = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;     
      String kurs = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "expensesidAgentFeeDebit"+i;
          charge = "expensesAgentChargeDebit"+i;
          desc = "expensesAgentDescDebit"+i;
          kurs = "expensesAgentKursDebit"+i;
          expensesagent = new ExpensesagentForm();
          expensesagent.setIdJobSheet(idJobSheet);
          expensesagent.setIdAgentFee(Integer.valueOf(request.getParameter(idAgentFee)));
          try {
              expensesagent.setCharge(Double.valueOf(request.getParameter(charge)));
          } catch (Exception e) {
              expensesagent.setCharge(new Double(0.0));
          }
          expensesagent.setDescription(request.getParameter(desc));
          expensesagent.setKurs(request.getParameter(kurs));
          baDebitList.add(expensesagent);
      }
      return baDebitList;
   }
   //CostInvoice = expensesShipper
   private List populateExpensesAgentInvoice(HttpServletRequest request, Integer idJobSheet) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountexpensesagentInvoice"));          
      List baDebitList = new ArrayList();
      ExpensesshipperForm expensesshipper = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;     
      String kurs = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "expensesidAgentFeeInvoice"+i;
          charge = "expensesAgentChargeInvoice"+i;
          desc = "expensesAgentDescInvoice"+i;
          kurs = "expensesAgentKursInvoice"+i;
          expensesshipper = new ExpensesshipperForm();
          expensesshipper.setIdJobSheet(idJobSheet);
          expensesshipper.setIdShipperFee(Integer.valueOf(request.getParameter(idAgentFee)));
          try {
              expensesshipper.setCharge(Double.valueOf(request.getParameter(charge)));
          } catch (Exception e) {
              expensesshipper.setCharge(new Double(0.0));
          }          
          expensesshipper.setDescription(request.getParameter(desc));
          expensesshipper.setKurs(request.getParameter(kurs));
          baDebitList.add(expensesshipper);
      }
      return baDebitList;
   }
}
