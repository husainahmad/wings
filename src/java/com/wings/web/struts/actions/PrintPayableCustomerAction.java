package com.wings.web.struts.actions;

import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.Payment;
import com.wings.reports.datasource.PayableCustomerDataSource;
import com.wings.reports.datasource.StatementOfAccountDatasource;
import com.wings.web.struts.forms.DateSelection;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.josql.Query;
import org.josql.QueryResults;

public final class PrintPayableCustomerAction extends Action {       
   
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
                        
            JasperCompileManager.compileReportToFile(context.getRealPath("/reports/PayableCustomer.jrxml"));
            String reportFileName = context.getRealPath("/reports/PayableCustomer.jasper");
            
            if(request.getParameter("idConsignee")!=null) {
               if (!request.getParameter("idConsignee").equalsIgnoreCase("")) {
                   JasperCompileManager.compileReportToFile(context.getRealPath("/reports/PayableCustomer.jrxml"));
                   reportFileName = context.getRealPath("/reports/PayableCustomer.jasper");
               } 
            }
            
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            
            if(request.getParameter("idConsignee")!=null) {
               if (!request.getParameter("idConsignee").equalsIgnoreCase("")) {
                   parameters.put("ConsigneeName", request.getParameter("idConsignee"));            
               } 
            } else {
                parameters.put("ConsigneeName", "All");            
            }
            
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("Period", request.getParameter("from") + " s/d " + request.getParameter("to"));                        
            
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new PayableCustomerDataSource(dtReport)
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
        
        if (ds.getIdConsignee()==null) {            
            ds.setIdConsignee("%%");
        } else {
            ds.setIdConsignee("%"+ds.getIdConsignee()+"%");
        }        
        List list = com.wings.adapter.StrutsPaymentDelegate.selectPayableCustomer(ds);
        
        return list;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
                
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               Payment payment = (Payment)list.get(i);
               valueOfTable[i][0] = payment.getPaymentDate();
               valueOfTable[i][1] = payment.getIdCostomer();
               valueOfTable[i][2] = payment.getBank();
               valueOfTable[i][3] = payment.getInvoiceNumber();
               if (payment.getKurs().equalsIgnoreCase("USD")) {
                   valueOfTable[i][4] = payment.getAmount();
                   valueOfTable[i][5] = new Double(0.0);
               } else {
                   valueOfTable[i][4] = new Double(0.0);
                   valueOfTable[i][5] = payment.getAmount();
               }                              
            }
        } catch (Exception e) {
           
        }
        return valueOfTable;  
    }    
}
