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


public final class UpdateKursdollarAction extends Action {

    public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      KursdollarForm kursdollarForm = (KursdollarForm)form;

      try {
         kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.update(kursdollarForm);
         request.setAttribute("kursdollar", kursdollarForm);
      } catch (Exception e) {
         getServlet().log("Find error", e);
         request.setAttribute("name", "Kursdollar");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("view");
   }
}
