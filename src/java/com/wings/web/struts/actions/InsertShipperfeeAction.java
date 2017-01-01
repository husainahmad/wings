package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperfeeForm;
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


public final class InsertShipperfeeAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         ShipperfeeForm shipperfeeForm = (ShipperfeeForm)form;
         ShipperfeeForm shipperfeeForm2 = shipperfeeForm;
         shipperfeeForm2 = com.wings.adapter.StrutsShipperfeeDelegate.findByName(shipperfeeForm2);
         if (shipperfeeForm2!=null) {
             ActionErrors errors = new ActionErrors();
             errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data"));
             saveErrors(request, errors);
             request.setAttribute("action", "insert");      
             return mapping.findForward("form");
         } else {
             shipperfeeForm = com.wings.adapter.StrutsShipperfeeDelegate.create(shipperfeeForm);
             // Set the newly created vo as a request attribute to be picked up
             request.setAttribute("shipperfee", shipperfeeForm);
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
