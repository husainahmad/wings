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
import org.apache.struts.util.RequestUtils;

public final class FindPerkiraanAction extends Action {

   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      
      try {
          PerkiraanForm perkiraanForm = (PerkiraanForm)form;
          RequestUtils.populate(perkiraanForm, request);
          perkiraanForm = com.wings.adapter.StrutsPerkiraanDelegate.edit(perkiraanForm);          
      } catch (Exception e) {
          
      }      
      return mapping.findForward("form");
   }
}
