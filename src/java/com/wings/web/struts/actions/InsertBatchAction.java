package com.wings.web.struts.actions;

import com.wings.web.struts.forms.BatchForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class InsertBatchAction extends Action {
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         BatchForm batchForm = (BatchForm)form;
         batchForm = com.wings.adapter.StrutsBatchDelegate.create(batchForm);
         // Set the newly created vo as a request attribute to be picked up
         request.setAttribute("batch", batchForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Batch");
         return mapping.findForward("ejb-create-exception");
      }
   }
}
