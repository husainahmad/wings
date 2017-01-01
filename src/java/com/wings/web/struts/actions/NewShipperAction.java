package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperForm;
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
 * Open form for new shipper.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/">Middlegen</a>
 *
 * @struts.action
 *    path="/struts/newShipper"
 *
 * @struts.action-forward
 *    name="form"
 *    path="/struts/formShipper.jsp"
 *    redirect="false"
 *

 */
public final class NewShipperAction extends Action {

   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "insert");
      
      request.getSession().setAttribute("shipperForm", new ShipperForm());

      return mapping.findForward("form");
   }
}
