package com.wings.web.struts.actions;

import com.wings.adapter.StrutsPaymentDelegate;
import com.wings.web.struts.forms.PaymentForm;
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

public final class EditPaymentAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      PaymentForm paymentForm = new PaymentForm();
      
      RequestUtils.populate(paymentForm, request);
      try {
         paymentForm = StrutsPaymentDelegate.edit(paymentForm);
         session.setAttribute("paymentForm", paymentForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Payment");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
   }   
}
