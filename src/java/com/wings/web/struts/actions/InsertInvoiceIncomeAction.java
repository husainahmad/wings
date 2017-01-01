package com.wings.web.struts.actions;

import com.wings.adapter.StrutsInvoiceKreditDelegate;
import com.wings.persistence.Income;
import com.wings.persistence.IncomeKey;
import com.wings.persistence.Invoice;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.Invoicekredit;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.InvoiceForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class InsertInvoiceIncomeAction extends Action {
    
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
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
            
            Invoice invoice = new Invoice();  
            invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.edit(invoiceForm);
            BeanUtils.copyProperties(invoice,invoiceForm);
            
            double totalUSD = 0.0;
            try {
                totalUSD = Double.valueOf(request.getParameter("totalUSD")).doubleValue();
            } catch (Exception e) {                
            }
            
            double totalIDR = 0.0;
            try {
                totalIDR = Double.valueOf(request.getParameter("totalIDR")).doubleValue();
            } catch (Exception e) {                
            }
            
            List invoiceKreditList = populateKredit(request, invoiceKey.getIdInvoice());
            Invoicekredit invoicekredit = new Invoicekredit();
            invoicekredit.setIdInvoice(invoice.getIdInvoice());
            
            StrutsInvoiceKreditDelegate.removeByIdInvoice(invoicekredit); 
            
            double totalIncome = 0.0;
            double totalKreditIDR = 0.0;
            double totalKreditUSD = 0.0;
            
            for (int i=0; i<invoiceKreditList.size(); i++) {
                 invoicekredit = (Invoicekredit)invoiceKreditList.get(i);
                 invoicekredit = com.wings.adapter.StrutsInvoiceKreditDelegate.create(invoicekredit);    
                 if (invoicekredit.getKurs().equalsIgnoreCase("IDR")) {
                     totalKreditIDR+=invoicekredit.getValue().doubleValue();
                 } else if (invoicekredit.getKurs().equalsIgnoreCase("USD")) {
                     totalKreditUSD+=invoicekredit.getValue().doubleValue();
                 }
                 
                 //totalIncome+=invoicekredit.getValue().doubleValue();
            }
            
            
            Income income = new Income();
            income.setRefId(invoice.getInvoiceNumber());
            
            com.wings.adapter.StrutsIncomeDelegate.removeByRefId(income);
            // for IDR
            income.setRevenu(new Double(totalKreditIDR));
            income.setKurs("IDR");                        
            
            if (totalKreditIDR>0.0) {
                income = com.wings.adapter.StrutsIncomeDelegate.create(income);
            }
            // for USD
            income.setRevenu(new Double(totalKreditUSD));
            income.setKurs("USD");
            
            if (totalKreditUSD>0.0) {
                income = com.wings.adapter.StrutsIncomeDelegate.create(income);
            }
            //IncomeKey incomeKey = com.wings.adapter.StrutsIncomeDelegate.lastId();
            
            //invoice.setIdIncome(incomeKey.getIdIncome());
                                    
            if ((totalIDR<=totalKreditIDR) & (totalUSD<=totalKreditUSD)) {
                invoice.setIsPayable("Y");
                invoice = com.wings.adapter.StrutsInvoiceDelegate.updatePayableStatus(invoice);
            }            
            
            return mapping.findForward("view");
            
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
      
   private List populateKredit(HttpServletRequest request, Integer idInvoice) {
       
      int countInvoiceKredit = Integer.parseInt(request.getParameter("countInvoiceKredit"));          
      List invoiceKreditList = new ArrayList();
      
      String value = null;
      String kurs = null;   
      String kreditDate = null;
      Invoicekredit invoicekredit = null;
     
      
      for (int i=1; i<countInvoiceKredit+1; i++) {
          
            kreditDate = "invoiceKreditDate" + i;
            value = "invoiceKreditValue" + i;
            kurs = "invoiceKreditKurs" + i;
            invoicekredit = new Invoicekredit();
            invoicekredit.setIdInvoice(idInvoice);
            invoicekredit.setKurs(request.getParameter(kurs));
            
            try {
                invoicekredit.setValue(Double.valueOf(request.getParameter(value)));
            } catch (Exception e) {
                invoicekredit.setValue(new Double(0.0));
            }
            
            try {
                invoicekredit.setKreditDate(new java.sql.Date(FORMAT.parse(request.getParameter(kreditDate)).getTime()));
            } catch (Exception e) {
                invoicekredit.setKreditDate(new java.sql.Date((new java.util.Date()).getTime()));
            }
            
            invoiceKreditList.add(invoicekredit);
            
      }
      
      return invoiceKreditList;
      
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
