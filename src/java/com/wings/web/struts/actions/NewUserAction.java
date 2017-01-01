package com.wings.web.struts.actions;

import com.wings.adapter.StrutsAuthorityDelegate;
import com.wings.web.struts.forms.UserForm;
import java.io.IOException;
import java.util.List;

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


public final class NewUserAction extends Action {
   Logger log = Logger.getLogger(NewUserAction.class.getName());        
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
          List authorityList = StrutsAuthorityDelegate.findAll();
          request.setAttribute("authorityList", authorityList);             
          
          request.setAttribute("action", "insert");      
          request.getSession().setAttribute("userForm", new UserForm());
      } catch (Exception e) {
          log.info(e);
          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
          saveErrors(request, errors);   
      }      
      return mapping.findForward("form");
   }
}
