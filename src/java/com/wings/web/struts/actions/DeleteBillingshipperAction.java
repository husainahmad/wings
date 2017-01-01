package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BillingshipperForm;
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


public final class DeleteBillingshipperAction extends Action {

   Logger log = Logger.getLogger(DeleteBillingshipperAction.class.getName());          
  
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      BillingshipperForm billingshipperForm = new BillingshipperForm();

      // Now set the form members with request values 
      RequestUtils.populate(billingshipperForm, request);
      try {
         com.wings.adapter.StrutsBillingshipperDelegate.remove(billingshipperForm);
      } catch (Exception e) {
         log.info(e);
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while deleting data, "+e.getMessage()));
         saveErrors(request, errors); 
      }

      return mapping.findForward("view");
   }      
}
