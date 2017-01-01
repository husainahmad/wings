package com.wings.web.struts.actions;

import com.wings.web.struts.forms.TransactionaccForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class EditTransactionaccAction extends Action {


   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      TransactionaccForm transactionaccForm = (TransactionaccForm)form;

      // Now set the form members with request values 
      RequestUtils.populate(transactionaccForm, request);
      try {
         transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.edit(transactionaccForm);         
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);  
      }

      return mapping.findForward("form");
   }
   
   
}
