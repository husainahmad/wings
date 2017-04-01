package com.wings.web.struts.actions;

import com.wings.persistence.InvoiceKey;
import com.wings.web.struts.forms.InvoiceForm;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintKwitansiAction extends Action {
    
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        InputStream imgInputStream = PrintKwitansiAction.this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
   
        try                        
        {
            InvoiceForm invoiceForm = new InvoiceForm();
            RequestUtils.populate(invoiceForm, request);
            
            InvoiceKey invoiceKey = new InvoiceKey();  
            invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
            
            String jobType = com.wings.adapter.StrutsInvoiceDelegate.selectJobTypeByInvoiceKey(invoiceKey);
            
            String mapp = "";
            if (jobType.equalsIgnoreCase("AI")) {
                mapp = PrintInvoiceAction.executeAIReport(request, invoiceKey, context, true, imgInputStream, "KwitansiAI");
            } else if (jobType.equalsIgnoreCase("AO")) {
                mapp = PrintInvoiceAction.executeAOReport(request, invoiceKey, context, true, imgInputStream, "KwitansiAO");
            } else if (jobType.equalsIgnoreCase("SI")) {
                mapp = PrintInvoiceAction.executeSIReport(request, invoiceKey, context, true, imgInputStream, "KwitansiSI");
            } else if (jobType.equalsIgnoreCase("SO")) {
                mapp = PrintInvoiceAction.executeSOReport(request, invoiceKey, context, true, imgInputStream, "KwitansiSO");
            }
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }         
}
