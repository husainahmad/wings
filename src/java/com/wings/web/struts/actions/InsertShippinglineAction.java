package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShippinglineForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertShippinglineAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         ShippinglineForm shippinglineForm = (ShippinglineForm)form;
         shippinglineForm = com.wings.adapter.StrutsShippinglineDelegate.create(shippinglineForm);
         request.setAttribute("shippingline", shippinglineForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Shippingline");
         return mapping.findForward("form");
      }
   }
}
