package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ConsigneeForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public final class UpdateConsigneeAction extends Action {

   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      ConsigneeForm consigneeForm = (ConsigneeForm)form;

      try {
         consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.update(consigneeForm);
         request.setAttribute("consignee", consigneeForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while updating data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);
         request.setAttribute("action", "update");      
         return mapping.findForward("form");
      }     
   }
}
