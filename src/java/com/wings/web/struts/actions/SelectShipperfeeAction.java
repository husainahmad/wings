package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperfeeForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class SelectShipperfeeAction extends Action {
	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		ShipperfeeForm shipperfeeForm = (ShipperfeeForm)form;

		try {
                    
                    List shipperfees = com.wings.adapter.StrutsShipperfeeDelegate.findAll(shipperfeeForm);
                    
                    if (shipperfeeForm.getIdJobType()!=null) {
                        if (shipperfeeForm.getIdJobType().equalsIgnoreCase("AI")) {
                            com.wings.adapter.StrutsShipperfeeDelegate.findAllAI(shipperfeeForm);
                        } else if (shipperfeeForm.getIdJobType().equalsIgnoreCase("AO")) {
                            com.wings.adapter.StrutsShipperfeeDelegate.findAllAO(shipperfeeForm);
                        } else if (shipperfeeForm.getIdJobType().equalsIgnoreCase("SI")) {
                            com.wings.adapter.StrutsShipperfeeDelegate.findAllSI(shipperfeeForm);
                        } else if (shipperfeeForm.getIdJobType().equalsIgnoreCase("SO")) {
                            com.wings.adapter.StrutsShipperfeeDelegate.findAllSO(shipperfeeForm);
                        }
                    }
                    

                    request.setAttribute("shipperfeeList", shipperfees);
                    return mapping.findForward("list");
			
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
