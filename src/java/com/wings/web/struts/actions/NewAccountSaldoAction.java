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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.joda.time.DateTime;

public final class NewAccountSaldoAction extends Action {
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "insert");
      AccountSaldoForm accSaldoForm = new AccountSaldoForm();
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
           
           accSaldoForm.setBulan(new Integer(imonth));
           accSaldoForm.setTahun(new Integer(iyear));
      } catch (Exception e) {          
      }
      
      request.setAttribute("accountSaldoForm", accSaldoForm);

      return mapping.findForward("form");
   }
}
