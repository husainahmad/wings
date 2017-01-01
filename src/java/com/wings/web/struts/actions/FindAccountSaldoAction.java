package com.wings.web.struts.actions;

import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.AccountForm;
import com.wings.web.struts.forms.AccountSaldoForm;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import org.joda.time.DateTime;


public final class FindAccountSaldoAction extends Action {
   
   Logger log = Logger.getLogger(FindAccountAction.class.getName());          
   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "update");
      try {
          
          GenerateDate generateDate = new GenerateDate();
           
          Date now = Calendar.getInstance().getTime();          
          DateTime dateTime = new DateTime(now);       
          int iyear = dateTime.getYear();
          int imonth = dateTime.getMonthOfYear();
                    
               
          List yearList = generateDate.getTahun(iyear);
          List monthList = generateDate.getBulans();
          request.setAttribute("yearList", yearList);                
          request.setAttribute("monthList", monthList); 
           
          
          AccountSaldoForm accountSaldoForm = (AccountSaldoForm)form;
          RequestUtils.populate(accountSaldoForm, request);
          accountSaldoForm = com.wings.adapter.StrutsAccountSaldoDelegate.edit(accountSaldoForm);
          request.getSession().setAttribute("accountSaldoForm", accountSaldoForm);     
      } catch (Exception e) {
         log.info(e); 
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
         saveErrors(request, errors);         
      }
      return mapping.findForward("form");
   }
}
