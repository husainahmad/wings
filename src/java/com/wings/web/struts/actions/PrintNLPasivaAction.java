package com.wings.web.struts.actions;

import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetDetail;
import com.wings.persistence.TransactionDetail;
import com.wings.persistence.Transactionacc;
import com.wings.reports.datasource.MonthlySalaryAIDataSource;
import com.wings.reports.datasource.StatementOfAccountDatasource;
import com.wings.reports.datasource.SummaryJobsheetDataSource;
import com.wings.reports.datasource.TransactionDataSource;
import com.wings.reports.datasource.TransactionaccGLDataSource;
import com.wings.web.struts.forms.DateSelection;
import com.wings.web.struts.forms.MonthYearForm;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintNLPasivaAction extends Action {       
   
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
            List list = this.getListData(request);
            Object[][] dtReport = this.parseListToArray(list);
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/accreports/RLReport.jrxml"));
            String reportFileName = context.getRealPath("/accreports/RLReport.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            
            //parameters.put("ConsigneeName", request.getParameter("perConsignee"));            
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("tanggal", "" + request.getParameter("perMonth") + " - " + request.getParameter("year"));               
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new TransactionaccGLDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
            return mapping.findForward("view");      
            
        }
        catch (Exception e)
        {            
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }               
   }
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private List getListData(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, Exception {
       
        MonthYearForm monthYearForm = new MonthYearForm();
        RequestUtils.populate(monthYearForm, request);
        String sdate = "01" + "/" + StringUtils.leftPad(String.valueOf(monthYearForm.getMonth()), 2, "0") + "/" + monthYearForm.getYear();

        Date date = null;
        try {
            date = new java.sql.Date(FORMAT.parse(sdate).getTime());
        } catch (ParseException pe) {
            date = new java.sql.Date((new java.util.Date()).getTime());
        }

        monthYearForm.setDate(date);

        monthYearForm.setIdAccount(monthYearForm.getIdAccount()+"%");
        List list = com.wings.adapter.StrutsTransactionaccDelegate.selectReportRL(monthYearForm);        
        return list;
        
   }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
        TransactionDetail transactionacc = null;     
        Double tax = null;
        Double totalExpensesIDR = null;
        
        
        try {
            
            for (int i = 0; i < list.size(); i++) {                                
               transactionacc = (TransactionDetail)list.get(i);
               
               valueOfTable[i][0] = transactionacc.getIdAccount();
               valueOfTable[i][1] = transactionacc.getSaldoAwal();
               valueOfTable[i][2] = transactionacc.getDebit();
               valueOfTable[i][3] = transactionacc.getKredit();
               valueOfTable[i][4] = transactionacc.getAccountGroup();               
               valueOfTable[i][5] = transactionacc.getAccountSuperGroup();                              
               
            }
        } catch (Exception e) {
           System.out.println(e);
        }
        
        return valueOfTable;  
        
    }  
}
