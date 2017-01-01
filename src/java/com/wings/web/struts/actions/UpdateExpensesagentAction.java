package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ExpensesagentForm;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Updates a expensesagent.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/updateExpensesagent"
 *    name="expensesagentForm"
 *    scope="session"
 *    validate="false"
 *
 * @struts.action-forward
 *    name="view"
 *    path="/struts/viewExpensesagent.do"
 *    redirect="false"
 *

 */
public final class UpdateExpensesagentAction extends Action {

   /**
    * Performs action.
    * @param mapping Action mapping.
    * @param form Action form.
    * @param request HTTP request.
    * @param response HTTP response.
    * @exception IOException if an input/output error occurs
    * @exception ServletException if a servlet exception occurs
    */
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      ExpensesagentForm expensesagentForm = (ExpensesagentForm)form;

      try {
         expensesagentForm = com.wings.adapter.StrutsExpensesagentDelegate.update(expensesagentForm);
         request.setAttribute("expensesagent", expensesagentForm);
      } catch (Exception e) {
         getServlet().log("Find error", e);
         request.setAttribute("name", "Expensesagent");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("view");
   }
}
