package com.wings.web.struts.actions;

import com.wings.web.struts.forms.PerkiraanForm;
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

public final class SelectPerkiraanAction extends Action {

	public ActionForward execute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		PerkiraanForm perkiraanForm = (PerkiraanForm)form;


		try {
                	List perkiraans = com.wings.adapter.StrutsPerkiraanDelegate.findAll();

		
				// Found many. Display all.
				request.setAttribute("perkiraans", perkiraans);
				return mapping.findForward("list");
			
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
