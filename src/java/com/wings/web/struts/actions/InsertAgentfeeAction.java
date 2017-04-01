package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentfeeForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertAgentfeeAction extends Action {
   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         AgentfeeForm agentfeeForm = (AgentfeeForm)form;
         agentfeeForm.setIsTax("0"); 
         agentfeeForm.setJobType("0"); 
         AgentfeeForm agentfeeForm2 = agentfeeForm;
         
         agentfeeForm2 = com.wings.adapter.StrutsAgentfeeDelegate.findByName(agentfeeForm2);
         if (agentfeeForm2!=null) {
             ActionErrors errors = new ActionErrors();
             errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data"));
             saveErrors(request, errors);
             request.setAttribute("action", "insert");      
             return mapping.findForward("form");
         } else {
            agentfeeForm = com.wings.adapter.StrutsAgentfeeDelegate.create(agentfeeForm);
            // Set the newly created vo as a request attribute to be picked up
            request.setAttribute("agentfee", agentfeeForm);
            return mapping.findForward("view"); 
         }
         
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "insert");      
         return mapping.findForward("form");
      }
   }
}
