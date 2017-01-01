package com.wings.web.struts.actions;

import com.wings.web.struts.forms.TransporterForm;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class SelectTransporterAction extends Action {

	
	public ActionForward execute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		TransporterForm transporterForm = (TransporterForm)form;


		try {
                    List transporters = com.wings.adapter.StrutsTransporterDelegate.findAll(transporterForm);

			
                    request.setAttribute("transporters", transporters);
                    return mapping.findForward("list");
			
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
