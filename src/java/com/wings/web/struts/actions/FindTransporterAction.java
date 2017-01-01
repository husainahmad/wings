package com.wings.web.struts.actions;

import com.wings.web.struts.forms.TransporterForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class FindTransporterAction extends Action {

   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      TransporterForm transporterForm = (TransporterForm)form;
      try {
          RequestUtils.populate(transporterForm, request);
          transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
      } catch (Exception e) {
          
      }
      request.getSession().setAttribute("transporterForm", transporterForm);
      return mapping.findForward("form");
   }
}
