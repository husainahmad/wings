package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class DeleteInvoiceAction extends Action {

   Logger log = Logger.getLogger(DeleteInvoiceAction.class.getName());          
   
   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      InvoiceForm invoiceForm = new InvoiceForm();

      // Now set the form members with request values 
      RequestUtils.populate(invoiceForm, request);
      try {
         invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.edit(invoiceForm); 
         JobsheetKey jobsheetKey = new JobsheetKey(); 
         jobsheetKey.setIdJobSheet(invoiceForm.getIdJobSheet());
         //com.wings.adapter.StrutsBillingagentDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsBillingshipperDelegate.removeByJobsheetKey(jobsheetKey);
         //com.wings.adapter.StrutsExpensesagentDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesshipperDelegate.removeByJobsheetKey(jobsheetKey);  
         com.wings.adapter.StrutsInvoiceDelegate.remove(invoiceForm);
         JobsheetForm jobsheetForm = new JobsheetForm();
         jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         jobsheetForm.setInvoiceNoUsd("");
         jobsheetForm.setInvoiceStatus("");
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.updateInvoiceNoAndStatus(jobsheetForm);
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while deleting data, "+e.getMessage()));
         saveErrors(request, errors); 
      }

      return mapping.findForward("view");
   }
   
   
}
