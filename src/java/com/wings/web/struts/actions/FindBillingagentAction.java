package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BillingagentForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class FindBillingagentAction extends Action {
   Logger log = Logger.getLogger(FindBillingagentAction.class.getName());          
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "select");
		
      request.getSession().setAttribute("billingagentForm", new BillingagentForm());

      return mapping.findForward("form");
   }
}
