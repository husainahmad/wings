package com.wings.web.struts.actions;


import com.wings.adapter.StrutsUserDelegate;
import com.wings.persistence.Users;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.UserForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class GetLogin extends Action {
    
   Logger log = Logger.getLogger(GetLogin.class.getName());
   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
        
        UserForm userForm = (UserForm)form;
        try {                     
            if (userForm!=null) {               
                Users user = new Users();
                BeanUtils.copyProperties(user, userForm);            
                user = StrutsUserDelegate.findUserByUserIdAndPassword(user);
                if (user!=null) {

                    request.getSession().setAttribute("userAuthorityId", user.getAuthorityId());
                    request.getSession().setAttribute("userName", user.getName());

                    request.getSession().setAttribute("userId",user.getUserId());
                    request.getSession().setAttribute("password",user.getPassword());               
                    
                    KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
                    request.getSession().setAttribute("kursdollarForm",kursdollarForm);               
                    
                    return mapping.findForward("success");    
                } else {
                    ActionErrors errors = new ActionErrors();
                    errors.add("userId", new ActionError("userForm.password.wrong","Password"));
                    saveErrors(request, errors);
                    return mapping.findForward("failed");    
                }
            } else {
                ActionErrors errors = new ActionErrors();
                errors.add("user", new ActionError("userForm.userId.notfound","User Id"));
                saveErrors(request, errors);
                return mapping.findForward("failed");    
            }            
        } catch (Exception e) {
            log.info(e);
            ActionErrors errors = new ActionErrors();
            errors.add("user", new ActionError("err.message",e.getLocalizedMessage()));
            saveErrors(request, errors);
            return mapping.findForward("failed");    
        }        
   }
}
