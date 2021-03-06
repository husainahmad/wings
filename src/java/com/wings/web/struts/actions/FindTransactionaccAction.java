package com.wings.web.struts.actions;

import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.AccountForm;
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
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;


public final class FindTransactionaccAction extends Action {
    
   DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");        
   
   public ActionForward execute (ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      HttpSession session = request.getSession();
      request.setAttribute("action", "update");

      TransactionaccForm transactionaccForm = (TransactionaccForm)form;

      // Now set the form members with request values 
      RequestUtils.populate(transactionaccForm, request);
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
            
            request.getSession().removeAttribute("transactionAccList");  
            transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.edit(transactionaccForm);         
            AccountForm accountForm = new AccountForm();
            accountForm.setIdAccount(transactionaccForm.getIdAccount());
            accountForm = com.wings.adapter.StrutsAccountDelegate.edit(accountForm);
            request.setAttribute("accountName", accountForm.getAccountName()); 
            TransactionaccForm transactionaccForm2 = com.wings.adapter.StrutsTransactionaccDelegate.selectTotalByDateAndBatchNo(monthYearForm);                    
            request.setAttribute("totalDebit", moneyFormat.format(transactionaccForm2.getDebit().doubleValue()));
            request.setAttribute("totalKredit", moneyFormat.format(transactionaccForm2.getKredit().doubleValue()));

            List transactionaccs = com.wings.adapter.StrutsTransactionaccDelegate.findAll(monthYearForm);			
            request.setAttribute("transactionAccList", transactionaccs); 
         
      } catch (Exception e) {
            ActionErrors errors = new ActionErrors();
            errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getMessage()));
            saveErrors(request, errors);  
      }

      return mapping.findForward("form");
   }
}
