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

/**
 * Find a expensesagent and forward to the form jsp, with select action.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/findExpensesagent"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formExpensesagent.jsp"
 *    redirect="false"
 *

 */
public final class FindExpensesagentAction extends Action {

   Logger log = Logger.getLogger(FindExpensesagentAction.class.getName());          
   
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "select");
		
      request.getSession().setAttribute("expensesagentForm", new ExpensesagentForm());

      return mapping.findForward("form");
   }
}
