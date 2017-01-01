package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShippinglineForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class FindShippinglineAction extends Action {

    public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

        try {
           request.setAttribute("action", "update");     
           ShippinglineForm shippinglineForm = (ShippinglineForm)form;
           String idShippingline = request.getParameter("idShippingLine");
           shippinglineForm.setIdShippingLine(idShippingline);
           shippinglineForm = com.wings.adapter.StrutsShippinglineDelegate.edit(shippinglineForm);
           
           request.getSession().setAttribute("shippinglineForm", shippinglineForm);
           return mapping.findForward("form");
       } catch (Exception e) {
           
           return mapping.findForward("form");
       }        
   }
}
