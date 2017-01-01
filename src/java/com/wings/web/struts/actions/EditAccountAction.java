package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AccountForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class EditAccountAction extends Action {
   
   Logger log = Logger.getLogger(EditAccountAction.class.getName());           

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      AccountForm accountForm = new AccountForm();

      // Now set the form members with request values 
      RequestUtils.populate(accountForm, request);
      try {
         accountForm = com.wings.adapter.StrutsAccountDelegate.edit(accountForm);
         session.setAttribute("accountForm", accountForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Account");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
   }
   
  
}
