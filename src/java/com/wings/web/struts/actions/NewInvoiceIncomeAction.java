package com.wings.web.struts.actions;

import com.wings.adapter.StrutsInvoiceKreditDelegate;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.Invoicekredit;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.InvoiceForm;
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

public final class NewInvoiceIncomeAction extends Action {
    
   
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        try                        
        {
            InvoiceForm invoiceForm = new InvoiceForm();
            RequestUtils.populate(invoiceForm, request);
            
            InvoiceKey invoiceKey = new InvoiceKey();  
            invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
            
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
            Invoicekredit invoiceKredit = new Invoicekredit();
            invoiceKredit.setIdInvoice(invoiceKey.getIdInvoice());
            
            List invoiceKreditList = StrutsInvoiceKreditDelegate.findAllByIdInvoice(invoiceKredit);
            request.setAttribute("invoiceKreditList", invoiceKreditList);
            
            return mapping.findForward("form");
            
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   private void executeAIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {
       
        InvoiceAIDetail invoiceAIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAIDetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceAIDetail.getIdJobSheet());        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);        
        request.setAttribute("jobType", "AI");
        request.setAttribute("InvoiceAIDetail", invoiceAIDetail);
        request.setAttribute("Billingshippers", list);
        request.setAttribute("action", "insert");
        return;         
       
   }
   private void executeAOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {
       
        InvoiceAODetail invoiceAODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAODetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceAODetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "AO");
        request.setAttribute("InvoiceAODetail", invoiceAODetail);
        request.setAttribute("Billingshippers", list);
        request.setAttribute("action", "insert");
                  
        return;         
       
   }
   private void executeSIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {
       
        InvoiceSIDetail invoiceSIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSIDetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceSIDetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "SI");
        request.setAttribute("InvoiceSIDetail", invoiceSIDetail);
        request.setAttribute("Billingshippers", list);
        request.setAttribute("action", "insert");
                   
        return;         
       
   }
   private void executeSOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context) throws Exception {
       
        InvoiceSODetail invoiceSODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSODetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceSODetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "SO");
        request.setAttribute("InvoiceSODetail", invoiceSODetail);
        request.setAttribute("Billingshippers", list);   
        request.setAttribute("action", "insert");
        return;         
       
   }   
}
