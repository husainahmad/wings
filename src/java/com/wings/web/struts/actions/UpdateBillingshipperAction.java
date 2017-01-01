package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BillingshipperForm;
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

/**
 * Updates a billingshipper.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/updateBillingshipper"
 *    name="billingshipperForm"
 *    scope="session"
 *    validate="false"
 *
 * @struts.action-forward
 *    name="view"
 *    path="/struts/viewBillingshipper.do"
 *    redirect="false"
 *

 */
public final class UpdateBillingshipperAction extends Action {

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

      BillingshipperForm billingshipperForm = (BillingshipperForm)form;

      try {
         billingshipperForm = com.wings.adapter.StrutsBillingshipperDelegate.update(billingshipperForm);
         request.setAttribute("billingshipper", billingshipperForm);
      } catch (Exception e) {
         getServlet().log("Find error", e);
         request.setAttribute("name", "Billingshipper");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("view");
   }
}
