package com.wings.web.struts.actions;

import com.wings.persistence.Account;
import com.wings.reports.datasource.AccountDataSource;
import java.io.File;
import java.io.IOException;
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

public final class PrintAccountAction extends Action {
    
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
            
            List accountList = com.wings.adapter.StrutsAccountDelegate.findAll(null);
            
            Object[][] dtReport = this.parseListToArray(accountList);

            JasperCompileManager.compileReportToFile(context.getRealPath("/account/ListAccount.jrxml"));
            String reportFileName = context.getRealPath("/account/ListAccount.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            parameters.put("BaseDir", reportFile.getParentFile());          
               
            String perDistrict = null;                   

            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new AccountDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);    
            
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][7];          
                    
        try {            
            for (int i = 0; i < list.size(); i++) {                
                Account account = (Account)list.get(i);
                valueOfTable[i][0] = account.getIdAccount();
                valueOfTable[i][1] = account.getAccountName();
                valueOfTable[i][2] = account.getCategory();      
                valueOfTable[i][3] = account.getType();
                valueOfTable[i][4] = account.getSaldoAwal();
            }
            
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;  
    }     
}
