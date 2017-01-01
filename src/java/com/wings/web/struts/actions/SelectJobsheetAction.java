package com.wings.web.struts.actions;

import com.wings.web.struts.forms.JobsheetForm;
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
 * Finds a jobsheet
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/selectJobsheet"
 *    name="jobsheetForm"
 *    scope="session"
 *    validate="false"
 *
 * @struts.action-forward
 *    name="none"
 *    path="/struts/findJobsheet.do"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="one"
 *    path="/struts/viewJobsheet.jsp"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="many"
 *    path="/struts/listJobsheet.jsp"
 *    redirect="false"
 *

 */
public final class SelectJobsheetAction extends Action {

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

		JobsheetForm jobsheetForm = (JobsheetForm)form;


		try {
  		List jobsheets = com.wings.adapter.StrutsJobsheetDelegate.select(jobsheetForm);

			if( jobsheets.size() == 0 ) {
				return mapping.findForward("none");
			} else if( jobsheets.size() == 1 ) {
				// Found one. Display it.
				JobsheetForm jobsheetFormTemp = (JobsheetForm) jobsheets.get(0);
				request.setAttribute("jobsheet", jobsheetFormTemp);

				return mapping.findForward("one");
			} else {
				// Found many. Display all.
				request.setAttribute("jobsheets", jobsheets);
				return mapping.findForward("many");
			}
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
