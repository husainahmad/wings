package com.wings.web.struts.actions;

import com.wings.web.struts.forms.TaxForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertTaxAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         TaxForm taxForm = (TaxForm)form;
         taxForm = com.wings.adapter.StrutsTaxDelegate.create(taxForm);
         // Set the newly created vo as a request attribute to be picked up
         request.setAttribute("tax", taxForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Tax");
         return mapping.findForward("ejb-create-exception");
      }
   }
}
