package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class FindAgentAction extends Action {

   Logger log = Logger.getLogger(FindAgentAction.class.getName());          
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
       
       try {
           request.setAttribute("action", "update");     
           AgentForm agentForm = (AgentForm)form;
           String idAgent = request.getParameter("idAgent");
           agentForm.setIdAgent(idAgent);
           agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm);        
           request.getSession().setAttribute("agentForm", agentForm);
           return mapping.findForward("form");
       } catch (Exception e) {
           log.info(e);
           return mapping.findForward("form");
       }      
       
   }
}
