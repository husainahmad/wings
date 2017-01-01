package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BillingshipperForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class FindBillingshipperAction extends Action {
   Logger log = Logger.getLogger(FindBillingshipperAction.class.getName());          
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "select");
		
      request.getSession().setAttribute("billingshipperForm", new BillingshipperForm());

      return mapping.findForward("form");
   }
}
