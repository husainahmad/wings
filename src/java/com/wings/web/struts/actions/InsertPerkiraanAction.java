package com.wings.web.struts.actions;

import com.wings.web.struts.forms.PerkiraanForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class InsertPerkiraanAction extends Action {


   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
          
         PerkiraanForm perkiraanForm = (PerkiraanForm)form;
         perkiraanForm = com.wings.adapter.StrutsPerkiraanDelegate.create(perkiraanForm);
         // Set the newly created vo as a request attribute to be picked up
         request.setAttribute("perkiraan", perkiraanForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Perkiraan");
         request.setAttribute("action", "insert");
         return mapping.findForward("form");
      }
   }
}
