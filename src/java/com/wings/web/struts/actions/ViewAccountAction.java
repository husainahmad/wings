package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AccountForm;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class ViewAccountAction extends Action {


   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      // First see if there is a vo as request attribute.
      AccountForm accountForm = (AccountForm)request.getAttribute("account");
      if( accountForm == null ) {
         // The vo wasn't on the request. We came via a direct link.
         // Get pk data from request object and use delegate to lookup
         try {
            accountForm = new AccountForm();
            // Now set the form members with request values 
            RequestUtils.populate(accountForm, request);

            accountForm = com.wings.adapter.StrutsAccountDelegate.edit(accountForm);
            request.setAttribute("account", accountForm);
         } catch (Exception e) {
            getServlet().log("Create error", e);
            request.setAttribute("name", "Account");
            return mapping.findForward("ejb-finder-exception");
         }
      }

      // Make a map that can be used to identify this Account in any links
      HashMap urlParams = new HashMap();
  urlParams.put("idAccount",accountForm.getIdAccount());
      request.setAttribute("__pk", urlParams);

      return mapping.findForward("view");
   }
   
   
}
