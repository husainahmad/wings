package com.wings.web.struts.actions;

import com.wings.web.struts.forms.JobtypeForm;
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


public final class UpdateJobtypeAction extends Action {

 
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      JobtypeForm jobtypeForm = (JobtypeForm)form;

      try {
         jobtypeForm = com.wings.adapter.StrutsJobtypeDelegate.update(jobtypeForm);
         request.setAttribute("jobtype", jobtypeForm);
      } catch (Exception e) {
         getServlet().log("Find error", e);
         request.setAttribute("name", "Jobtype");
         return mapping.findForward("ejb-finder-exception");
      }

      return mapping.findForward("view");
   }
}
