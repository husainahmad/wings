package com.wings.web.struts.actions;

import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.MonthYearForm;
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


public final class SelectInvoiceAction extends Action {

	
	public ActionForward execute(
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

                    List invoices = com.wings.adapter.StrutsInvoiceDelegate.findAll(monthYearForm);

                    request.setAttribute("invoices", invoices);
                    return mapping.findForward("list");
			
		} catch (Exception e) {
			getServlet().log("Create error", e);
			return mapping.findForward("list");
		}
	}
       
}
