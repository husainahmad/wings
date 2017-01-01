package com.wings.web.struts.actions;

import com.wings.persistence.Jobsheet;
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

public final class SelectJobsheetsoAction extends Action {
	
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
                    
                    monthYearForm.setIdJobType("SO");

                    try {
                        int act = Integer.valueOf(monthYearForm.getQuery()).intValue();
                        switch  (act) {
                            case 0:
                            case 4:
                            case 6:
                            case 7:
                                monthYearForm.setIdShipper(null);
                                monthYearForm.setIdConsignee(null);
                                monthYearForm.setIdAgent(null);

                                monthYearForm.setJobNo(null);
                                monthYearForm.setTermHbl(null);
                                monthYearForm.setTermMbl(null);
                                monthYearForm.setShippingLine(null);

                                monthYearForm.setFeederVessel(null);
                                break;
                            case 1:
                                monthYearForm.setIdShipper("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 2:
                                 monthYearForm.setIdConsignee("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 3:
                                 monthYearForm.setIdAgent("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 5:
                                 monthYearForm.setJobNo("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 10:
                                 monthYearForm.setTermHbl("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 11:
                                 monthYearForm.setTermMbl("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 8:
                                 monthYearForm.setShippingLine("%"+monthYearForm.getTxtSearch()+"%");
                                break;
                            case 9:
                                 monthYearForm.setFeederVessel("%"+monthYearForm.getTxtSearch()+"%");
                                break;

                        }
                    } catch (Exception e) {
                    }

                    List jobsheetaos = com.wings.adapter.StrutsJobsheetDelegate.selectByidJobTypeSO(monthYearForm);
			
                    request.setAttribute("jobsheetsos", jobsheetaos);
                    return mapping.findForward("list");
			
		} catch (Exception e) {
                    getServlet().log("Create error", e);
                    return mapping.findForward("ejb-finder-exception");
		}
	}
}
