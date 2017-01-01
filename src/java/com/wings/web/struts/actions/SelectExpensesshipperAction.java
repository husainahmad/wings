package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ExpensesshipperForm;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Finds a expensesshipper
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/selectExpensesshipper"
 *    name="expensesshipperForm"
 *    scope="session"
 *    validate="false"
 *
 * @struts.action-forward
 *    name="none"
 *    path="/struts/findExpensesshipper.do"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="one"
 *    path="/struts/viewExpensesshipper.jsp"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="many"
 *    path="/struts/listExpensesshipper.jsp"
 *    redirect="false"
 *

 */
public final class SelectExpensesshipperAction extends Action {

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

		ExpensesshipperForm expensesshipperForm = (ExpensesshipperForm)form;


		try {
  		List expensesshippers = com.wings.adapter.StrutsExpensesshipperDelegate.select(expensesshipperForm);

			if( expensesshippers.size() == 0 ) {
				return mapping.findForward("none");
			} else if( expensesshippers.size() == 1 ) {
				// Found one. Display it.
				ExpensesshipperForm expensesshipperFormTemp = (ExpensesshipperForm) expensesshippers.get(0);
				request.setAttribute("expensesshipper", expensesshipperFormTemp);

				return mapping.findForward("one");
			} else {
				// Found many. Display all.
				request.setAttribute("expensesshippers", expensesshippers);
				return mapping.findForward("many");
			}
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
