package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShipperForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;


public final class DeleteShipperAction extends Action {
  
   Logger log = Logger.getLogger(DeleteShipperAction.class.getName());           
   
   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      ShipperForm shipperForm = new ShipperForm();

      // Now set the form members with request values 
      RequestUtils.populate(shipperForm, request);
      try {
         com.wings.adapter.StrutsShipperDelegate.remove(shipperForm);
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while deleting data, "+e.getMessage()));
         saveErrors(request, errors); 
      }

      return mapping.findForward("view");
   }
   
   
}
