package com.wings.web.struts.actions;

import com.wings.adapter.StrutsCashonhandDelegate;
import com.wings.web.struts.forms.CashonhandForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class DeleteCashonhandAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      CashonhandForm cashonhandForm = new CashonhandForm();

      // Now set the form members with request values 
      RequestUtils.populate(cashonhandForm, request);
      try {
         StrutsCashonhandDelegate.remove(cashonhandForm);
      } catch (Exception e) {
         getServlet().log("Remove error", e);
         request.setAttribute("name", "Cashonhand");
         return mapping.findForward("ejb-remove-exception");
      }

      return mapping.findForward("all");
   }
   
   /**
    * Get the named value as a string from the request parameter, or from the
    * request obj if not found.
    * 
    * @param req The request object.
    * @param name The name of the parameter.
    *
    * @return The value of the parameter as a String.
    */
   private String getParameter(HttpServletRequest req, String name) {
      String value = req.getParameter(name);
      if (value == null) {
         value = (String)req.getAttribute(name);
      }
      return value;
   }
}
