package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BatchForm;
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


public final class DeleteBatchAction extends Action {

   Logger log = Logger.getLogger(DeleteBatchAction.class.getName());          
   
    
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      BatchForm batchForm = new BatchForm();

      // Now set the form members with request values 
      RequestUtils.populate(batchForm, request);
      try {
         com.wings.adapter.StrutsBatchDelegate.remove(batchForm);
      } catch (Exception e) {
          log.info(e);
         getServlet().log("Remove error", e);
         request.setAttribute("name", "Batch");
         return mapping.findForward("ejb-remove-exception");
      }

      return mapping.findForward("view");
   }
   
   /**
    * Get the named value as a string from the request parameter, or from the
    * request obj if not found.
    * 
    * @param req The request object.
    * @param name The name of the parameter.
    *
    * @return The value of the parameter as a String.
    */
   private String getParameter(HttpServletRequest req, String name) {
      String value = req.getParameter(name);
      if (value == null) {
         value = (String)req.getAttribute(name);
      }
      return value;
   }
}
