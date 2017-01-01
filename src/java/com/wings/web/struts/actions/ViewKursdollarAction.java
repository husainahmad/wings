package com.wings.web.struts.actions;

import com.wings.web.struts.forms.KursdollarForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class ViewKursdollarAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      // First see if there is a vo as request attribute.
      KursdollarForm kursdollarForm = (KursdollarForm)request.getAttribute("kursdollar");
      if( kursdollarForm == null ) {
         // The vo wasn't on the request. We came via a direct link.
         // Get pk data from request object and use delegate to lookup
         try {
            kursdollarForm = new KursdollarForm();
            // Now set the form members with request values 
            RequestUtils.populate(kursdollarForm, request);

            kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.edit(kursdollarForm);
            request.setAttribute("kursdollar", kursdollarForm);
         } catch (Exception e) {
            getServlet().log("Create error", e);
            request.setAttribute("name", "Kursdollar");
            return mapping.findForward("ejb-finder-exception");
         }
      }

      
      return mapping.findForward("view");
   }
   
   
}
