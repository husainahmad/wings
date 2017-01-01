package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentForm;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class SelectAgentAction extends Action {

	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		AgentForm agentForm = (AgentForm)form;
                AgentForm agentForm2 = new AgentForm();
                if (agentForm.getName()!=null) {
                    agentForm2.setName(agentForm.getName()+"%");
                } else {
                    agentForm2.setName("%");
                }
                
		try {
                    List agents = com.wings.adapter.StrutsAgentDelegate.findAll(agentForm2);
                    request.setAttribute("agentsList", agents);
                    return mapping.findForward("list");			
		} catch (Exception e) {
                    getServlet().log("Create error", e);
                    return mapping.findForward("ejb-finder-exception");
		}
	}
}
