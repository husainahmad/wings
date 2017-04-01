package com.wings.web.struts.actions;

import com.wings.persistence.InvoiceAIDetail;
import com.wings.reports.datasource.JaminanDataSource;
import com.wings.reports.datasource.TruckingDataSource;
import com.wings.web.struts.forms.DateSelection;
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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class PrintJaminanAction extends Action {       
   
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
            List list = this.getHandlingReportDetailSummary(request);
            Object[][] dtReport = this.parseListToArray(list);
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/reports/JaminanKontainer.jrxml"));
            String reportFileName = context.getRealPath("/reports/JaminanKontainer.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("month_year", request.getParameter("from") + " - " + request.getParameter("to"));               
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new JaminanDataSource(dtReport)
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
   private List getHandlingReportDetailSummary(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, Exception {
        SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");        
        DateSelection ds = new DateSelection();
        
        try {
             ds.setFrom(new java.sql.Timestamp(FORMAT.parse(request.getParameter("from") + " 00:00").getTime()));               
        } catch (ParseException pe) {
             ds.setFrom(new java.sql.Timestamp(new Date().getTime()));  
        }
        try {
             ds.setTo(new java.sql.Timestamp(FORMAT.parse(request.getParameter("to") + " 23:59").getTime()));               
        } catch (ParseException pe) {
             ds.setTo(new java.sql.Timestamp(new Date().getTime()));  
        }
        List list = com.wings.adapter.StrutsJobsheetDelegate.selectReportJaminan(ds);  
        return list;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
        InvoiceAIDetail invoiceAIDetail = null;     
        int j = 0;
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               invoiceAIDetail = (InvoiceAIDetail)list.get(i);
               valueOfTable[i][0] = invoiceAIDetail.getJobNo();
               valueOfTable[i][1] = invoiceAIDetail.getIdConsignee();
               valueOfTable[i][2] = invoiceAIDetail.getShippingLine();
               valueOfTable[i][3] = invoiceAIDetail.getHawb();               
               valueOfTable[i][4] = invoiceAIDetail.getIdNumber();
               valueOfTable[i][5] = invoiceAIDetail.getVolumeDesc();
               valueOfTable[i][6] = new Double(invoiceAIDetail.getJaminan().doubleValue());
               valueOfTable[i][7] = new Double(0.0);
               
            }
        } catch (Exception e) {
           
        }
        return valueOfTable;  
    }  
}
