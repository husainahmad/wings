package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ConsigneeForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class FindConsigneeAction extends Action {

   Logger log = Logger.getLogger(FindConsigneeAction.class.getName());          
   
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
       
      try {
          request.setAttribute("action", "update");
          
          ConsigneeForm consigneeForm = (ConsigneeForm)form;
          consigneeForm.setIdConsignee(request.getParameter("idConsignee"));
          consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);	
          request.getSession().setAttribute("consigneeForm", new ConsigneeForm());

      } catch (Exception e) {
          log.info(e);
      }
      
      return mapping.findForward("form");
   }
}
