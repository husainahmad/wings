package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AccountForm;
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

public final class DeleteAccountAction extends Action {
   Logger log = Logger.getLogger(DeleteAccountAction.class.getName());   
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      AccountForm accountForm = new AccountForm();

      // Now set the form members with request values 
      RequestUtils.populate(accountForm, request);
      try {
         com.wings.adapter.StrutsAccountDelegate.remove(accountForm);
      } catch (Exception e) {
          log.info(e);
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);         
      }

      return mapping.findForward("view");
   }
   
   }
