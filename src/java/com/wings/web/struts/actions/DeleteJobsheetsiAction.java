package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
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


public final class DeleteJobsheetsiAction extends Action {
   
   Logger log = Logger.getLogger(DeleteJobsheetsiAction.class.getName());           
   
  
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      JobsheetForm jobsheetForm = new JobsheetForm();
      
      RequestUtils.populate(jobsheetForm, request);
      try {
         JobsheetKey jobsheetKey = new JobsheetKey();  
         jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());     
         com.wings.adapter.StrutsInvoiceDelegate.removeByIdJobsheet(jobsheetKey);
         com.wings.adapter.StrutsDebitDelegate.removeByIdJobsheet(jobsheetKey);
         com.wings.adapter.StrutsBillingagentDelegate.removeByJobsheetKey(jobsheetKey);         
         com.wings.adapter.StrutsBillingshipperDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesagentDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsExpensesshipperDelegate.removeByJobsheetKey(jobsheetKey);
         com.wings.adapter.StrutsJobsheetsiDelegate.removeByIdJobSheet(jobsheetKey);
         com.wings.adapter.StrutsJobsheetDelegate.remove(jobsheetKey);         
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while deleting data, "+e.getMessage()));
         saveErrors(request, errors); 
      }

      return mapping.findForward("view");
      
   }   
  
}
