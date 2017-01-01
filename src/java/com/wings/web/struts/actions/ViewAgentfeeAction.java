package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentfeeForm;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class ViewAgentfeeAction extends Action {

  
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

       request.setAttribute("action", "select");
      AgentfeeForm agentfeeForm = (AgentfeeForm)form;
      try {
          Integer idAgentfeeFee = Integer.valueOf(request.getParameter("idAgentFee"));
          agentfeeForm.setIdAgentFee(idAgentfeeFee);
          agentfeeForm = com.wings.adapter.StrutsAgentfeeDelegate.edit(agentfeeForm);
      } catch (Exception e) {
          
      }
      request.getSession().setAttribute("agentfeeForm", agentfeeForm);

      return mapping.findForward("form");
   }      
}
