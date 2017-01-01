package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ExpensesagentForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class DeleteExpensesagentAction extends Action {

   Logger log = Logger.getLogger(DeleteExpensesagentAction.class.getName());          
   
    
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      ExpensesagentForm expensesagentForm = new ExpensesagentForm();

      // Now set the form members with request values 
      RequestUtils.populate(expensesagentForm, request);
      try {
         com.wings.adapter.StrutsExpensesagentDelegate.remove(expensesagentForm);
      } catch (Exception e) {
         log.info(e);
         getServlet().log("Remove error", e);
         request.setAttribute("name", "Expensesagent");
         return mapping.findForward("ejb-remove-exception");
      }

      return mapping.findForward("all");
   }
   
}
