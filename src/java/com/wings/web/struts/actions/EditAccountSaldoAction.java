package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AccountForm;
import com.wings.web.struts.forms.AccountSaldoForm;
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


public final class EditAccountSaldoAction extends Action {
   
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

       AccountSaldoForm accountSaldoForm = new AccountSaldoForm();

      // Now set the form members with request values 
      RequestUtils.populate(accountSaldoForm, request);
      try {
         accountSaldoForm = com.wings.adapter.StrutsAccountSaldoDelegate.edit(accountSaldoForm);
         session.setAttribute("accountSaldoForm", accountSaldoForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Account");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
   }
   
  
}
