package com.wings.web.struts.actions;

import com.wings.web.struts.forms.InvoiceForm;
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
 * Open form for editing invoice.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/editInvoice"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formInvoice.jsp"
 *    redirect="false"
 *

 */
public final class EditInvoiceAction extends Action {

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

      InvoiceForm invoiceForm = new InvoiceForm();

      // Now set the form members with request values 
      RequestUtils.populate(invoiceForm, request);
      try {
         invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.edit(invoiceForm);
         session.setAttribute("invoiceForm", invoiceForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Invoice");
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
