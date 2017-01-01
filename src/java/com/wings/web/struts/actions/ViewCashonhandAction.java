package com.wings.web.struts.actions;

import com.wings.adapter.StrutsCashonhandDelegate;
import com.wings.web.struts.forms.CashonhandForm;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class ViewCashonhandAction extends Action {


   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      // First see if there is a vo as request attribute.
      CashonhandForm cashonhandForm = (CashonhandForm)request.getAttribute("cashonhand");
      if( cashonhandForm == null ) {
         // The vo wasn't on the request. We came via a direct link.
         // Get pk data from request object and use delegate to lookup
         try {
            cashonhandForm = new CashonhandForm();
            // Now set the form members with request values 
            RequestUtils.populate(cashonhandForm, request);

            cashonhandForm = StrutsCashonhandDelegate.edit(cashonhandForm);
            request.setAttribute("cashonhand", cashonhandForm);
         } catch (Exception e) {
            getServlet().log("Create error", e);
            request.setAttribute("name", "Cashonhand");
            return mapping.findForward("ejb-finder-exception");
         }
      }

      // Make a map that can be used to identify this Cashonhand in any links
      HashMap urlParams = new HashMap();
  urlParams.put("idCashOnHand",cashonhandForm.getIdCashOnHand());
      request.setAttribute("__pk", urlParams);

      return mapping.findForward("view");
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
         value = req.getAttribute(name).toString();
      }
      return value;
   }
}
