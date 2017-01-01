package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertShipperAction extends Action {

  
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         ShipperForm shipperForm = (ShipperForm)form;
         ShipperForm shipperForm2 = new ShipperForm();
         shipperForm2.setName(shipperForm.getName());
         shipperForm2 = com.wings.adapter.StrutsShipperDelegate.findByName(shipperForm2);
         if (shipperForm2.getIdShipper()!=null) {
             ActionErrors errors = new ActionErrors();
             errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data"));
             saveErrors(request, errors);
             request.setAttribute("action", "insert");      
             return mapping.findForward("form");
         } else {
             shipperForm = com.wings.adapter.StrutsShipperDelegate.create(shipperForm);
             // Set the newly created vo as a request attribute to be picked up
             request.setAttribute("shipper", shipperForm);
             return mapping.findForward("view");
         }
         
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "insert");      
         return mapping.findForward("form");
      }
   }
}
