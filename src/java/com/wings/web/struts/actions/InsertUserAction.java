package com.wings.web.struts.actions;

import com.wings.adapter.StrutsUserDelegate;
import com.wings.web.struts.forms.UserForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertUserAction extends Action {
   Logger log = Logger.getLogger(InsertUserAction.class.getName());     
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
      UserForm userForm = (UserForm)form;
      try {
        
         userForm = StrutsUserDelegate.create(userForm);
         // Set the newly created vo as a request attribute to be picked up
         request.setAttribute("user", userForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "insert");
         return mapping.findForward("form");
      }
   }
}
