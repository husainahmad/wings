package com.wings.web.struts.actions;


import com.wings.web.struts.forms.UserForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class Login extends Action {

   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
        
        UserForm userForm = (UserForm)form;
               
        return mapping.findForward("form");    
        
   }
}
