package com.wings.web.struts.actions;

import com.wings.persistence.Billingagent;
import com.wings.persistence.Billingshipper;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DebitForm;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.TaxForm;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class FindTaxAction extends Action {

   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
      
      request.setAttribute("action", "update");
            
      ServletContext context = this.getServlet().getServletConfig().getServletContext();
            
      try {
          TaxForm taxForm =  (TaxForm)form;
          RequestUtils.populate(taxForm, request);
          taxForm = com.wings.adapter.StrutsTaxDelegate.edit(taxForm);
          
          Integer intJobSheet = Integer.valueOf(taxForm.getIdJobSheet());
          JobsheetForm jobsheetForm = new JobsheetForm();
          jobsheetForm.setIdJobSheet(intJobSheet);
          
          InvoiceForm invoiceForm = new InvoiceForm();
          invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
          
          invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.findByIdJobsheet(invoiceForm);
          
          InvoiceKey invoiceKey = new InvoiceKey();
          invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
          
          DebitForm debitForm = new DebitForm();
          debitForm.setIdJobSheet(jobsheetForm.getIdJobSheet());                    
          
          debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
          DebitKey debitKey = new DebitKey();
          debitKey.setIdDebit(debitForm.getIdDebit());
          
          JobsheetKey jobsheetKey = new JobsheetKey();
          jobsheetKey.setIdJobSheet(debitForm.getIdJobSheet());
          
          List billingAgent = com.wings.adapter.StrutsBillingagentDelegate.selectTaxByIdJobSheet(jobsheetKey);
          List billingShipper = com.wings.adapter.StrutsBillingshipperDelegate.selectTaxByIdJobSheet(jobsheetKey);
          
          double totaltax = 0.0;
          Billingagent billingagent = null;
          for (int i=0; i<billingAgent.size(); i++) {
              billingagent = (Billingagent)billingAgent.get(i);
              totaltax+=billingagent.getCharge().doubleValue();
          }
          Billingshipper billingshipper = null;
          for (int i=0; i<billingShipper.size(); i++) {
              billingshipper = (Billingshipper)billingShipper.get(i);
              totaltax+=billingshipper.getCharge().doubleValue();
          }
          taxForm.setDpp(new Double(totaltax));
          
          String jobType = com.wings.adapter.StrutsInvoiceDelegate.selectJobTypeByInvoiceKey(invoiceKey);
                        
          if (jobType.equalsIgnoreCase("AI")) {
                executeAIReport(request, invoiceKey, context);
          } else if (jobType.equalsIgnoreCase("AO")) {
                executeAOReport(request, invoiceKey, context);
          } else if (jobType.equalsIgnoreCase("SI")) {
                executeSIReport(request, invoiceKey, context);
          } else if (jobType.equalsIgnoreCase("SO")) {
                executeSOReport(request, invoiceKey, context);
          }
          
      } catch (Exception e) {
          
      }            

      return mapping.findForward("form");
   }
    private void executeAIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {
        InvoiceAIDetail invoiceAIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAIDetailByInvoiceKey(invoiceKey);        
        request.setAttribute("jobType", "AI");
        request.setAttribute("InvoiceAIDetail", invoiceAIDetail);
        request.setAttribute("action", "update");
        return;                
   }
    
   private void executeAOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {       
        InvoiceAODetail invoiceAODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAODetailByInvoiceKey(invoiceKey);        
        request.setAttribute("jobType", "AO");
        request.setAttribute("InvoiceAODetail", invoiceAODetail);
        request.setAttribute("action", "update");                  
        return;                
   }
   
   private void executeSIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {       
        InvoiceSIDetail invoiceSIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSIDetailByInvoiceKey(invoiceKey);
        request.setAttribute("jobType", "SI");
        request.setAttribute("InvoiceSIDetail", invoiceSIDetail);
        request.setAttribute("action", "update");                   
        return;                
   }
   private void executeSOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {       
        InvoiceSODetail invoiceSODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSODetailByInvoiceKey(invoiceKey);
        request.setAttribute("jobType", "SO");
        request.setAttribute("InvoiceSODetail", invoiceSODetail);
        request.setAttribute("action", "update");
        return;                
   } 
}
