package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperfeeForm;
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


public final class ViewShipperfeeAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
      request.setAttribute("action", "select");
      ShipperfeeForm shipperfeeForm = (ShipperfeeForm) form;
      try {          
          shipperfeeForm.setIdShipperFee(Integer.valueOf(request.getParameter("idShipperFee")));
          shipperfeeForm = com.wings.adapter.StrutsShipperfeeDelegate.edit(shipperfeeForm);
      } catch (Exception e) {
          
      }
      request.getSession().setAttribute("shipperfeeForm", shipperfeeForm);

      return mapping.findForward("form");
   }   
}
