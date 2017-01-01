package com.wings.web.struts.actions;

import com.wings.web.struts.forms.DestinationForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class FindDestinationAction extends Action {

   Logger log = Logger.getLogger(FindDestinationAction.class.getName());          
   
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      
      DestinationForm destinationForm = (DestinationForm)form;
      
      try {
          
          RequestUtils.populate(destinationForm, request);
          destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
          
      } catch (Exception e) {
          log.info(e);
      }
      request.getSession().setAttribute("destinationForm", destinationForm);
      return mapping.findForward("form");
   }
}
