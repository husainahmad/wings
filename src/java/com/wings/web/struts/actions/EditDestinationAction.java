package com.wings.web.struts.actions;

import com.wings.web.struts.forms.DestinationForm;
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


public final class EditDestinationAction extends Action {

 
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      DestinationForm destinationForm = new DestinationForm();

      // Now set the form members with request values 
      RequestUtils.populate(destinationForm, request);
      try {
         destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
         session.setAttribute("destinationForm", destinationForm);
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Destination");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("form");
   }     
}
