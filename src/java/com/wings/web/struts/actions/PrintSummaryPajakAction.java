package com.wings.web.struts.actions;

import com.wings.persistence.TaxJobSheetDetail;
import com.wings.reports.datasource.TaxReportDataSource;
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

public final class PrintSummaryPajakAction extends Action {       
   
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
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/reports/MonthlyTax.jrxml"));
            String reportFileName = context.getRealPath("/reports/MonthlyTax.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            
            parameters.put("perConsignee", request.getParameter("perConsignee"));            
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("dateFromTo", "Period : " + request.getParameter("from") + " - " + request.getParameter("to"));               
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new TaxReportDataSource(dtReport)
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
        String idConsignee = request.getParameter("idConsignee");
        ds.setIdConsignee(idConsignee);
        
        List list = null;
        if (idConsignee.equalsIgnoreCase("All")) {
            list = com.wings.adapter.StrutsJobsheetDelegate.selectReportSummaryTax(ds);  
        } else {
            list = com.wings.adapter.StrutsJobsheetDelegate.selectReportSummaryTaxByCustomer(ds);  
        }                    
        return list;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][10];  
        TaxJobSheetDetail taxJobSheetDetail = null;     
        int j = 1;
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               taxJobSheetDetail = (TaxJobSheetDetail)list.get(i);
               valueOfTable[i][0] = new Integer(j++);
               if ((taxJobSheetDetail.getJobNo().endsWith("AI")) || (taxJobSheetDetail.getJobNo().endsWith("SI"))) {
                    valueOfTable[i][1] = taxJobSheetDetail.getIdConsignee(); 
               } else {
                   valueOfTable[i][1] = taxJobSheetDetail.getIdShipper();
               }               
               valueOfTable[i][2] = taxJobSheetDetail.getNpwp();
               valueOfTable[i][3] = taxJobSheetDetail.getInvoiceNumber();
               valueOfTable[i][4] = taxJobSheetDetail.getInvoiceDate();
               valueOfTable[i][5] = taxJobSheetDetail.getJobNo();
               valueOfTable[i][6] = taxJobSheetDetail.getVolumeDesc();
               valueOfTable[i][7] = taxJobSheetDetail.getInvoiceDate();
               valueOfTable[i][8] = taxJobSheetDetail.getDpp();               
               valueOfTable[i][9] = taxJobSheetDetail.getNoFaktur();               
            }
        } catch (Exception e) {
           
        }
        return valueOfTable;  
    }  
}
