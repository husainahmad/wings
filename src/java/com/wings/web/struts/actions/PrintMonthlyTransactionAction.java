package com.wings.web.struts.actions;

import com.wings.persistence.Transactionacc;
import com.wings.reports.datasource.MonthlyTransactionDataSource;
import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.MonthYearForm;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;

public final class PrintMonthlyTransactionAction extends Action {
    
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        try                        
        {
            MonthYearForm monthYearForm = new MonthYearForm(); 
            RequestUtils.populate(monthYearForm, request);            
            
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
            
            Object[][] dtReport = this.parseListToArray(transactionaccs);

            JasperCompileManager.compileReportToFile(context.getRealPath("/transactionacc/MonthlyTransactionReport.jrxml"));
            String reportFileName = context.getRealPath("/transactionacc/MonthlyTransactionReport.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();                         
            String perDistrict = null;                   
            parameters.put("Month", monthYearForm.getMonth() + ", " + monthYearForm.getYear());
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new MonthlyTransactionDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);    
            
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }                     
   }
   
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][12];          
        int j = 1;    
        int i = 0;
        try {            
            for (i = 0; i < list.size(); i++) {                
                Transactionacc af = (Transactionacc)list.get(i);
                valueOfTable[i][0] = af.getInUrut();
                valueOfTable[i][1] = af.getTransactionDate();
                valueOfTable[i][2] = af.getVoucherDesc()+String.valueOf(af.getNoVoucher());
                valueOfTable[i][3] = af.getIdAccount();
                valueOfTable[i][4] = af.getKurs();
                valueOfTable[i][5] = af.getDescription();
                valueOfTable[i][6] = af.getDebit();
                valueOfTable[i][7] = af.getKredit();
                valueOfTable[i][8] = af.getNoBatch();                
                j++;
            }                        
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;  
    }
}
