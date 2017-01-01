package com.wings.web.struts.actions;

import com.wings.web.struts.forms.DebitForm;
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
 * Find a debit and forward to the form jsp, with select action.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/findDebit"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formDebit.jsp"
 *    redirect="false"
 *

 */
public final class FindDebitAction extends Action {
   Logger log = Logger.getLogger(FindDebitAction.class.getName());          
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "select");
		
      request.getSession().setAttribute("debitForm", new DebitForm());

      return mapping.findForward("form");
   }
}
