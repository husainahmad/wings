package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetDetail;
import com.wings.reports.datasource.FakturLapReportDataSource;
import com.wings.reports.datasource.InvoiceAIDataSource;
import com.wings.web.struts.forms.DateSelection;
import java.io.File;
import java.io.IOException;
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

public final class PrintFakturPajakAction extends Action {       
   
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
            
            ds.setJobType(request.getParameter("idJobType"));
            List list = com.wings.adapter.StrutsJobsheetDelegate.selectReportFakturPajak(ds);  
            
            Object[][] dtReport = parseListToArray(list);
            
            JasperCompileManager.compileReportToFile(context.getRealPath("/tax/ListFakturPajak.jrxml"));
            String reportFileName = context.getRealPath("/tax/ListFakturPajak.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();                        
            parameters.put("jobType", request.getParameter("idJobType"));                                              
            parameters.put("periode", "Periode : " + request.getParameter("from") + " - " + request.getParameter("to"));                                       
                      
            JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new FakturLapReportDataSource(dtReport)
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
   
   private Object[][] parseListToArray(List list) {
        
        Object[][] valueOfTable = new Object[list.size()][8];
        
        try {
            JobsheetDetail jobsheetDetail;
            for (int i = 0; i < list.size(); i++) {
                jobsheetDetail = (JobsheetDetail)list.get(i);
                valueOfTable[i][0] = jobsheetDetail.getShippeddate();
                valueOfTable[i][1] = jobsheetDetail.getInvoiceNumber();
                valueOfTable[i][2] = jobsheetDetail.getJobNo();
                
                if (jobsheetDetail.getBillTo()!=null) {
                    if (jobsheetDetail.getBillTo().equalsIgnoreCase("1")) {
                        valueOfTable[i][3] = jobsheetDetail.getIdConsignee();                         
                    }
                    if (jobsheetDetail.getBillTo().equalsIgnoreCase("2")) {
                        valueOfTable[i][3] = jobsheetDetail.getIdConsignee();                         
                    } 
                    if (jobsheetDetail.getBillTo().equalsIgnoreCase("3")) {
                        valueOfTable[i][3] = jobsheetDetail.getIdShipper();
                    }
                    if (jobsheetDetail.getBillTo().equalsIgnoreCase("4")) {
                        valueOfTable[i][3] = jobsheetDetail.getIdConsignee();     
                    }
                }                
                valueOfTable[i][4] = jobsheetDetail.getVatIDR();
                valueOfTable[i][5] = jobsheetDetail.getVatIDR2();
                valueOfTable[i][6] = jobsheetDetail.getPphIDR();
                valueOfTable[i][7] = jobsheetDetail.getTotalBillingIDR();                                                                
            }
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;
    }    
   
}
