package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShippinglineForm;
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

public final class SelectShippinglineAction extends Action {


	public ActionForward execute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		ShippinglineForm shippinglineForm = (ShippinglineForm)form;


		try {
                    List shippinglines = com.wings.adapter.StrutsShippinglineDelegate.select(shippinglineForm);
                    request.setAttribute("shippinglines", shippinglines);
                    return mapping.findForward("list");

		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("list");
		}
	}
}
