package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class NewAgentAction extends Action {
  
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "insert");
      
      request.getSession().setAttribute("agentForm", new AgentForm());

      return mapping.findForward("form");
   }
}
