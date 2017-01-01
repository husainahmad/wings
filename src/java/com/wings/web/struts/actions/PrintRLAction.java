package com.wings.web.struts.actions;

import com.wings.persistence.AccountSaldo;
import com.wings.reports.datasource.TransactionaccGLDataSource;
import com.wings.web.struts.forms.MonthYearForm;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
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
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintRLAction extends Action {       
   
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
            parameters.put("tanggal", "" + "31 Desember " + " - " + (monthYearForm.getYear().intValue()-1));        
            parameters.put("tanggal2", "" + "31 Desember " + " - " + request.getParameter("year"));               
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
       
        List list = com.wings.adapter.StrutsAccountSaldoDelegate.selectByRL(monthYearForm);
        return list;
        
   }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][5];  
        AccountSaldo accountSaldo = null;           
        
        try {
            
            for (int i = 0; i < list.size(); i++) {                                
               accountSaldo = (AccountSaldo)list.get(i);
               
               valueOfTable[i][0] = accountSaldo.getAccountName();
               valueOfTable[i][1] = accountSaldo.getSaldoAwal();
               valueOfTable[i][2] = accountSaldo.getSaldoAkhir();
               
               valueOfTable[i][3] = accountSaldo.getCategory();
               valueOfTable[i][4] = "";
               
            }
        } catch (Exception e) {
           System.out.println(e);
        }
        
        return valueOfTable;  
        
    }  
}
