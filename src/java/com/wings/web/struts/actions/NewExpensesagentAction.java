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
 * Open form for new expensesagent.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/newExpensesagent"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formExpensesagent.jsp"
 *    redirect="false"
 *

 */
public final class NewExpensesagentAction extends Action {

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

      request.setAttribute("action", "insert");
      
      request.getSession().setAttribute("expensesagentForm", new ExpensesagentForm());

      return mapping.findForward("form");
   }
}
