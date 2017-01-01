package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentfeeForm;
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


public final class SelectAgentfeeAction extends Action {

	
	public ActionForward execute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		AgentfeeForm agentfeeForm = (AgentfeeForm)form;

		try {
                        List agentfees = com.wings.adapter.StrutsAgentfeeDelegate.findAll(agentfeeForm);
                        if (agentfeeForm.getIdJobType()!=null) {
                            if (agentfeeForm.getIdJobType().equalsIgnoreCase("AI")) {
                                agentfees = com.wings.adapter.StrutsAgentfeeDelegate.findAllAI(agentfeeForm);
                            } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("AO")) {
                                agentfees = com.wings.adapter.StrutsAgentfeeDelegate.findAllAO(agentfeeForm);			
                            } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("SI")) {
                                agentfees = com.wings.adapter.StrutsAgentfeeDelegate.findAllSI(agentfeeForm);			
                            } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("SO")) {
                                agentfees = com.wings.adapter.StrutsAgentfeeDelegate.findAllSO(agentfeeForm);			
                            } 
                        }          		
			request.setAttribute("agentfeeList", agentfees);
			return mapping.findForward("list");
	
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
