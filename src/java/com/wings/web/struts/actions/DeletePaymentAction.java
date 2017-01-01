package com.wings.web.struts.actions;

import com.wings.web.struts.forms.PaymentForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class DeletePaymentAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      PaymentForm paymentForm = new PaymentForm();
      
      RequestUtils.populate(paymentForm, request);
      try {
         com.wings.adapter.StrutsPaymentDelegate.remove(paymentForm);
      } catch (Exception e) {
         getServlet().log("Remove error", e);
         request.setAttribute("name", "Payment");
         return mapping.findForward("ejb-remove-exception");
      }
      return mapping.findForward("all");
   }   
}
