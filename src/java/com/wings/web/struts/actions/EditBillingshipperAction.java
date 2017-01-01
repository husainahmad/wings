package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BillingshipperForm;
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

/**
 * Open form for editing billingshipper.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/editBillingshipper"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formBillingshipper.jsp"
 *    redirect="false"
 *

 */
public final class EditBillingshipperAction extends Action {

   /**
    * Performs action.
    * @param mapping Action mapping.
    * @param form Action form.
    * @param request HTTP request.
    * @param response HTTP response.
    * @exception IOException if an input/output error occurs
    * @exception ServletException if a servlet exception occurs
    */
   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      BillingshipperForm billingshipperForm = new BillingshipperForm();

      // Now set the form members with request values 
      RequestUtils.populate(billingshipperForm, request);
      try {
         billingshipperForm = com.wings.adapter.StrutsBillingshipperDelegate.edit(billingshipperForm);
         session.setAttribute("billingshipperForm", billingshipperForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Billingshipper");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
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
