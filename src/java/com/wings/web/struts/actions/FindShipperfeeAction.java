package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperfeeForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class FindShipperfeeAction extends Action {

   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      ShipperfeeForm shipperfeeForm = (ShipperfeeForm) form;
      try {          
          String idShipperFee = request.getParameter("idShipperFee");
          Integer intidShipperFee = Integer.valueOf(idShipperFee);
          shipperfeeForm.setIdShipperFee(intidShipperFee);
          shipperfeeForm = com.wings.adapter.StrutsShipperfeeDelegate.edit(shipperfeeForm);
      } catch (Exception e) {
          
      }
      request.getSession().setAttribute("shipperfeeForm", shipperfeeForm);

      return mapping.findForward("form");
   }
}
