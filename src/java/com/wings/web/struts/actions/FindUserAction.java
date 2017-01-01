package com.wings.web.struts.actions;


import com.wings.adapter.StrutsAuthorityDelegate;
import com.wings.adapter.StrutsUserDelegate;
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
import org.apache.struts.util.RequestUtils;


public final class FindUserAction extends Action {

   Logger log = Logger.getLogger(FindUserAction.class.getName());       

   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

        String userId = request.getParameter("userId");
        UserForm userForm = (UserForm)form;
        RequestUtils.populate(userForm, request);
        try {            
            List authorityList = StrutsAuthorityDelegate.findAll();
            request.setAttribute("authorityList", authorityList);               
            
            userForm = StrutsUserDelegate.edit(userForm);
            request.setAttribute("action", "update");       
            
            return mapping.findForward("form");
        } catch (Exception e) {
             log.info(e);   
             ActionErrors errors = new ActionErrors();
             errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
             saveErrors(request, errors);
             return mapping.findForward("form");  
        }  
   }
}
