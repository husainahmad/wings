package com.wings.web.struts.actions;

import com.wings.web.struts.forms.TransporterForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class EditTransporterAction extends Action {

   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      TransporterForm transporterForm = new TransporterForm();

      // Now set the form members with request values 
      RequestUtils.populate(transporterForm, request);
      try {
         transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
         session.setAttribute("transporterForm", transporterForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Transporter");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
   }      
}
