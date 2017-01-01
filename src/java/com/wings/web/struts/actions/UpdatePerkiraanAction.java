package com.wings.web.struts.actions;

import com.wings.web.struts.forms.PerkiraanForm;
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


public final class UpdatePerkiraanAction extends Action {

 
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      PerkiraanForm perkiraanForm = (PerkiraanForm)form;

      try {
         perkiraanForm = com.wings.adapter.StrutsPerkiraanDelegate.update(perkiraanForm);
         request.setAttribute("perkiraan", perkiraanForm);
      } catch (Exception e) {
         getServlet().log("Find error", e);
         request.setAttribute("name", "Perkiraan");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("view");
   }
}
