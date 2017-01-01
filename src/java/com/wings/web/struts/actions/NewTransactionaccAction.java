package com.wings.web.struts.actions;

import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.MonthYearForm;
import com.wings.web.struts.forms.TransactionaccForm;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.joda.time.DateTime;


public final class NewTransactionaccAction extends Action {

   DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
      
      request.setAttribute("action", "insert");
      MonthYearForm monthYearForm = new MonthYearForm(); 
      HttpSession sess = request.getSession();
      
      try {
            GenerateDate generateDate = new GenerateDate();

            Date now = Calendar.getInstance().getTime();          
            DateTime dateTime = new DateTime(now);       
            int iyear = dateTime.getYear();
            int imonth = dateTime.getMonthOfYear();

            List yearList = generateDate.getYears(iyear);
            List monthList = generateDate.getMonths();
            request.setAttribute("yearList", yearList);                
            request.setAttribute("monthList", monthList);  
            
            try {
                monthYearForm = (MonthYearForm)sess.getAttribute("monthYear");
            } catch (Exception e) {
                
            }
            
            if (monthYearForm.getYear()==null)  {                
                monthYearForm.setYear(new Integer(iyear));                               
            }
            if (monthYearForm.getMonth()==null) {
                monthYearForm.setMonth(new Integer(imonth));                                
            }
            
            List transactionaccs = com.wings.adapter.StrutsTransactionaccDelegate.findAll(monthYearForm);			
            request.setAttribute("transactionaccs", transactionaccs); 
            
            request.getSession().removeAttribute("transactionAccList");
            
            TransactionaccForm transactionaccForm2 = com.wings.adapter.StrutsTransactionaccDelegate.selectTotalByDateAndBatchNo(monthYearForm);                    
            request.setAttribute("totalDebit", moneyFormat.format(transactionaccForm2.getDebit().doubleValue()));
            request.setAttribute("totalKredit", moneyFormat.format(transactionaccForm2.getKredit().doubleValue()));
            
      } catch (Exception e) {
          
      }               
      request.getSession().setAttribute("transactionaccForm", new TransactionaccForm());

      return mapping.findForward("form");
   }
}
