package com.wings.web.struts.actions;

import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetDetail;
import com.wings.persistence.Transactionacc;
import com.wings.reports.datasource.MonthlySalaryAIDataSource;
import com.wings.reports.datasource.StatementOfAccountDatasource;
import com.wings.reports.datasource.SummaryJobsheetDataSource;
import com.wings.reports.datasource.TransactionDataSource;
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

public final class PrintBBAction extends Action {       
   
   public ActionForward execute(
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
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/accreports/BBReport.jrxml"));
            String reportFileName = context.getRealPath("/accreports/BBReport.jasper");
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
                            new TransactionDataSource(dtReport)
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

        monthYearForm.setStrYearMonthDate(monthYearForm.getYear() + "-" + StringUtils.leftPad(String.valueOf(monthYearForm.getMonth()), 2, "0") + "-" + "01");
        monthYearForm.setIdAccount(monthYearForm.getIdAccount()+"%");
        List list = com.wings.adapter.StrutsTransactionaccDelegate.selectReportBB(monthYearForm);        
        return list;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
        Transactionacc transactionacc = null;     
        Double tax = null;
        Double totalExpensesIDR = null;
        String idAccount = "";
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               transactionacc = (Transactionacc)list.get(i);
               
               valueOfTable[i][0] = transactionacc.getNoBatch();
               valueOfTable[i][1] = transactionacc.getNoUrut();
               valueOfTable[i][2] = transactionacc.getTransactionDate();
               valueOfTable[i][3] = transactionacc.getVoucherDesc() + transactionacc.getNoVoucher();
               valueOfTable[i][4] = transactionacc.getDescription();
               valueOfTable[i][5] = transactionacc.getDebit();
               valueOfTable[i][6] = transactionacc.getKredit();  
               valueOfTable[i][7] = transactionacc.getIdAccount();
               
               if (transactionacc.getIdAccount().equalsIgnoreCase(idAccount)) {
                   valueOfTable[i][8] = new Double(0.0); 
               } else {
                   valueOfTable[i][8] = transactionacc.getSaldoAkhir();
                   idAccount = transactionacc.getIdAccount(); 
               }
            }
        } catch (Exception e) {
           System.out.println(e);
        }
        return valueOfTable;  
    }  
}
