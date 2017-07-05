package com.wings.web.struts.actions;

import com.wings.persistence.Transactionacc;
import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.MonthYearForm;
import com.wings.web.struts.forms.TransactionaccForm;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.joda.time.DateTime;


public final class InsertTransactionaccAction extends Action {
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      MonthYearForm monthYearForm = new MonthYearForm(); 
      HttpSession sess = request.getSession();
      
      try {
          
            if (request.getParameter("action").equalsIgnoreCase("Save")) {
          
              GenerateDate generateDate = new GenerateDate();

              java.util.Date now = Calendar.getInstance().getTime();          
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
              TransactionaccForm transactionaccForm = (TransactionaccForm)form;
              java.sql.Date tutupBuku = null;
             
              try {
                 tutupBuku = new java.sql.Date(FORMAT.parse(sdate).getTime());
              } catch (ParseException pe) {
                 tutupBuku = new java.sql.Date((new java.util.Date()).getTime());
              }
                        
              transactionaccForm.setTglTutupBuku(tutupBuku); 
            
              List transAcc = populateTransactionAcc(transactionaccForm, request);
              request.getSession().setAttribute("transactionAccList",transAcc);                        
            
              TransactionaccForm transactionaccForm2 = com.wings.adapter.StrutsTransactionaccDelegate.selectTotalByDateAndBatchNo(monthYearForm);                    
              request.setAttribute("totalDebit", moneyFormat.format(transactionaccForm2.getDebit().doubleValue()));
              request.setAttribute("totalKredit", moneyFormat.format(transactionaccForm2.getKredit().doubleValue()));
            
              request.setAttribute("transactionacc", transactionaccForm);         
              request.setAttribute("action", "insert");

              return mapping.findForward("form");
          } else {
              processTransactionAcc(request);  
              request.getSession().removeAttribute("transactionAccList");
              return mapping.findForward("view");
          }
      
      } catch (Exception e) {
             ActionErrors errors = new ActionErrors();
             errors.add("errors", new ActionError("err.message","Error while inserting data, perhaps you were input the existing data, "+e.getLocalizedMessage()));
             saveErrors(request, errors);  
             request.setAttribute("action", "insert");
             return mapping.findForward("form");         
      }      
   }
   public void processTransactionAcc(HttpServletRequest request) throws Exception {
       List transAcc = (List)request.getSession().getAttribute("transactionAccList");
       KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
       TransactionaccForm transactionaccForm = null;
       
       String uuid = String.valueOf(new AtomicInteger().incrementAndGet());
       Transactionacc transactionacc = null;
       for (int i=0; i<transAcc.size();i++) {
            try {
                transactionacc = (Transactionacc)transAcc.get(i);
                transactionaccForm = new TransactionaccForm();
                BeanUtils.copyProperties(transactionaccForm, transactionacc);
                transactionaccForm.setGroupid(uuid);
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);            
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),3,"0"));                        
                transactionaccForm.setKursValue(kursdollarForm.getValue());            
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            } catch (Exception e) {
                
            }
       }
   }
   public List populateTransactionAcc(TransactionaccForm transactionaccForm, HttpServletRequest request) throws Exception {
        List transAcc = (List)request.getSession().getAttribute("transactionAccList");
        Transactionacc transactionacc = new Transactionacc();
        BeanUtils.copyProperties(transactionacc, transactionaccForm);
        if (transAcc==null) {
            transAcc = new ArrayList();            
            transAcc.add(transactionacc);
        } else {
            transAcc.add(transactionacc);
        }        
        return transAcc;
   }
}
