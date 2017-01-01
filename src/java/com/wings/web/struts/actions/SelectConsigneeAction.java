package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ConsigneeForm;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class SelectConsigneeAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		ConsigneeForm consigneeForm = (ConsigneeForm)form;
		try {
                    List consignees = com.wings.adapter.StrutsConsigneeDelegate.findAll(consigneeForm);	
                    request.setAttribute("consigneeList", consignees);
                    return mapping.findForward("list");			
		} catch (Exception e) {
                    getServlet().log("Create error", e);
                    return mapping.findForward("ejb-finder-exception");
		}
	}
}
