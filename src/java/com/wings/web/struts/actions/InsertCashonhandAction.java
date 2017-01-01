package com.wings.web.struts.actions;

import com.wings.adapter.StrutsCashonhandDelegate;
import com.wings.web.struts.forms.CashonhandForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class InsertCashonhandAction extends Action {


   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         CashonhandForm cashonhandForm = (CashonhandForm)form;
         cashonhandForm = StrutsCashonhandDelegate.create(cashonhandForm);
         // Set the newly created vo as a request attribute to be picked up
         request.setAttribute("cashonhand", cashonhandForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Cashonhand");
         return mapping.findForward("ejb-create-exception");
      }
   }
}
