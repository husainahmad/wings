package com.wings.web.struts.actions;

import com.wings.persistence.Transactionacc;
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


public final class SelectTransactionaccAction extends Action {

	DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
        
	public ActionForward execute (
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response
	)
		throws IOException, ServletException {

		MonthYearForm monthYearForm = (MonthYearForm)form; 
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

                    if (monthYearForm.getYear()==null)  {
                        monthYearForm.setYear(new Integer(iyear));
                    }
                    if (monthYearForm.getMonth()==null) {
                        monthYearForm.setMonth(new Integer(imonth));
                    }
                    if (monthYearForm.getNoBatch()==null) {
                        monthYearForm.setNoBatch("%");
                    }
                    
                    HttpSession sess = request.getSession();
                    sess.setAttribute("monthYear", monthYearForm);
                    
                    List transactionaccs = com.wings.adapter.StrutsTransactionaccDelegate.findAll(monthYearForm);
                    request.setAttribute("transactionaccs", transactionaccs);
                    
                    double totalDebit = 0.0;
                    double totalKredit = 0.0;
                    
                    Transactionacc transactionacc = null;
                    for (int i=0; i<transactionaccs.size(); i++) {
                        transactionacc = (Transactionacc) transactionaccs.get(i);
                        try {
                            totalDebit+=transactionacc.getDebit().doubleValue();
                        } catch (Exception e) {                            
                        }
                        
                        try {
                            totalKredit+=transactionacc.getKredit().doubleValue();
                        } catch (Exception e) {                            
                        }                        
                    }
                    
                    request.setAttribute("totalDebit", moneyFormat.format(totalDebit));
                    request.setAttribute("totalKredit", moneyFormat.format(totalKredit)); 
                                        
                    List listBatch = com.wings.adapter.StrutsBatchDelegate.findAll();
                    request.setAttribute("batchs", listBatch);
                    
                    return mapping.findForward("list");

		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("ejb-finder-exception");
		}
	}
}
