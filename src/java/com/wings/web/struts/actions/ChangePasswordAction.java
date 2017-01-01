package com.wings.web.struts.actions;


import com.wings.adapter.StrutsUserDelegate;
import com.wings.persistence.Users;
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


public final class ChangePasswordAction extends Action {
   
   Logger log = Logger.getLogger(ChangePasswordAction.class.getName());   
   private String strError = "";
   
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
      UserForm userForm = (UserForm)form;
      try {
          if (validateThePassword(userForm)) {
              Users user = new Users();
              user.setUserId((String)request.getSession().getAttribute("userId"));
              user.setPassword(userForm.getPassword());
              user = StrutsUserDelegate.findUserByUserIdAndPassword(user);
              if (user!=null) {
                  user.setPassword(userForm.getNewPassword());
                  StrutsUserDelegate.updatePassword(user);                  
                  userForm.setPassword("");
                  userForm.setNewPassword("");
                  userForm.setAgainNewPassword("");                  
                  request.setAttribute("success", "your password has updated");
              } else {
                  ActionErrors errors = new ActionErrors();
                  errors.add("errors", new ActionError("err.message.pass","your old password is incorrect"));         
                  saveErrors(request, errors);         
              }
          } else {
              ActionErrors errors = new ActionErrors();
              errors.add("errors", new ActionError("err.message.pass",strError));         
              saveErrors(request, errors);         
          }
      } catch (Exception e) {
          log.info(e);
          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));         
          saveErrors(request, errors);         
      }
      return mapping.findForward("form");
      
   }
   private boolean validateThePassword(UserForm userForm) {
       if ((userForm.getNewPassword()==null) || (userForm.getPassword()==null) || (userForm.getAgainNewPassword()==null)) {
           strError = "all password can not be null";
           return false;   
       } else {
           if (("".equals(userForm.getNewPassword())) || ("".equals(userForm.getPassword())) || ("".equals(userForm.getAgainNewPassword()))) {
               strError = "all password can not be empty space";
               return false;   
           } else {
               if (userForm.getNewPassword().equals(userForm.getAgainNewPassword())) {                   
                   return true;
               } else {
                   strError = "your new password is not equals with again new password";
                   return false;
               }
           }
       }        
   }
}
