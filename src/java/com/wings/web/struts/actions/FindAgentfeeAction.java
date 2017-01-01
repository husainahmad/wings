package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentfeeForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class FindAgentfeeAction extends Action {
  
   Logger log = Logger.getLogger(FindAgentfeeAction.class.getName());          
  
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      AgentfeeForm agentfeeForm = (AgentfeeForm)form;
      try {
          Integer idAgentfeeFee = Integer.valueOf(request.getParameter("idAgentFee"));
          agentfeeForm.setIdAgentFee(idAgentfeeFee);
          agentfeeForm = com.wings.adapter.StrutsAgentfeeDelegate.edit(agentfeeForm);
      } catch (Exception e) {
          log.info(e);
      }
      request.getSession().setAttribute("agentfeeForm", agentfeeForm);

      return mapping.findForward("form");
   }
}
