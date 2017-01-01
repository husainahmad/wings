package com.wings.web.struts.actions;

import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.MonthYearForm;
import com.wings.web.struts.forms.TransactionaccForm;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.joda.time.DateTime;

public final class UpdateTransactionaccAction extends Action {
    
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      TransactionaccForm transactionaccForm = (TransactionaccForm)form;
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
            
         String sday = "01";
         String smonth = StringUtils.leftPad(monthYearForm.getMonth().toString(),2,"0");
         String syear = monthYearForm.getYear().toString();
         String sdate = sday + "/" + smonth + "/" + syear;
         
         java.sql.Date tutupBuku = null;

         try {
             tutupBuku = new java.sql.Date(FORMAT.parse(sdate).getTime());
         } catch (ParseException pe) {
             tutupBuku = new java.sql.Date((new java.util.Date()).getTime());
         }

         transactionaccForm.setTglTutupBuku(tutupBuku); 
         KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
         transactionaccForm.setKursValue(kursdollarForm.getValue());

         transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.update(transactionaccForm);
         monthYearForm.setNoBatch(transactionaccForm.getNoBatch());
         transactionaccForm.setIdAccount(null);
         transactionaccForm.setDescription(null);
         transactionaccForm.setDebit(null);
         transactionaccForm.setKredit(null);
         transactionaccForm.setNoVoucher(null);
         transactionaccForm.setVoucherDesc(null);             
         transactionaccForm.setJobNo(null);
         sess.setAttribute("monthYear", monthYearForm);
         request.setAttribute("transactionacc", transactionaccForm);
                  
         TransactionaccForm transactionaccForm2 = com.wings.adapter.StrutsTransactionaccDelegate.selectTotalByDateAndBatchNo(monthYearForm);                    
         request.setAttribute("totalDebit", moneyFormat.format(transactionaccForm2.getDebit().doubleValue()));
         request.setAttribute("totalKredit", moneyFormat.format(transactionaccForm2.getKredit().doubleValue()));
         
         List transactionaccs = com.wings.adapter.StrutsTransactionaccDelegate.findAll(monthYearForm);			
         request.setAttribute("transactionaccs", transactionaccs); 
         
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getLocalizedMessage()));
         saveErrors(request, errors);  
         request.setAttribute("action", "update");
         return mapping.findForward("form");
      }

      return mapping.findForward("view");
   }
}
