package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Find a shipper and forward to the form jsp, with select action.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/findShipper"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formShipper.jsp"
 *    redirect="false"
 *

 */
public final class FindShipperAction extends Action {

  
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      ShipperForm shipperForm = (ShipperForm)form;
      try {
          String idShipper = request.getParameter("idShipper");
          shipperForm.setIdShipper(idShipper);
          shipperForm = com.wings.adapter.StrutsShipperDelegate.edit(shipperForm);
          request.getSession().setAttribute("shipperForm", shipperForm);
          
          return mapping.findForward("form");
      } catch (Exception e) {
          return mapping.findForward("form");
      }            
   }
}
