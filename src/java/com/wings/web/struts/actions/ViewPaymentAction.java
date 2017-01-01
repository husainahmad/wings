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


public final class ViewPaymentAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
      
      PaymentForm paymentForm = (PaymentForm)request.getAttribute("payment");
      if( paymentForm == null ) {
         // The vo wasn't on the request. We came via a direct link.
         // Get pk data from request object and use delegate to lookup
         try {
            paymentForm = new PaymentForm();
            // Now set the form members with request values 
            RequestUtils.populate(paymentForm, request);

            paymentForm = com.wings.adapter.StrutsPaymentDelegate.edit(paymentForm);
            request.setAttribute("payment", paymentForm);
         } catch (Exception e) {
            getServlet().log("Create error", e);
            request.setAttribute("name", "Payment");
            return mapping.findForward("ejb-finder-exception");
         }
      }      
      return mapping.findForward("view");
   }   
}
