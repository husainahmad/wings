package com.wings.web.struts.actions;

import com.wings.persistence.InvoiceAIDetail;
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

public final class PrintStatementOfAccountAction extends Action {       
   
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
            List list = this.getHandlingReportDetailSummary(request);
            list = this.clearUnusedData(list, request);
            Object[][] dtReport = this.parseListToArray(list);
                        
            JasperCompileManager.compileReportToFile(context.getRealPath("/reports/StatementOfAccountAll.jrxml"));
            String reportFileName = context.getRealPath("/reports/StatementOfAccountAll.jasper");
            
            if(request.getParameter("idConsignee")!=null) {
               if (!request.getParameter("idConsignee").equalsIgnoreCase("")) {
                   JasperCompileManager.compileReportToFile(context.getRealPath("/reports/StatementOfAccount.jrxml"));
                   reportFileName = context.getRealPath("/reports/StatementOfAccount.jasper");
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
            parameters.put("period", request.getParameter("from") + " s/d " + request.getParameter("to"));                        
            
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new StatementOfAccountDatasource(dtReport)
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
   
   private List clearUnusedData(List repList, HttpServletRequest request) {
       
       List reportList = new ArrayList();
       List newRepList = new ArrayList();
       InvoiceAIDetail invoiceAIDetail = null;
       InvoiceAIDetail newInvoiceAIDetail = null;
       
       for (int i=0;i<repList.size();i++) {
            invoiceAIDetail = (InvoiceAIDetail)repList.get(i);
            if (invoiceAIDetail.getIdNumber().substring(0,1).equalsIgnoreCase("D")) { // means Debit
                newInvoiceAIDetail = (InvoiceAIDetail)invoiceAIDetail;
                if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("1")) {
                    // 1:agent
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdAgent());                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("2")) {
                    // 2:Consignee
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdConsignee());                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("3")) {
                    // 3:Shipper
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdShipper());                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("4")) {
                    // 4:ShippingLine
                    newInvoiceAIDetail.setName(invoiceAIDetail.getShippingLine());                    
                } 
            } else {
                newInvoiceAIDetail = (InvoiceAIDetail)invoiceAIDetail;
                if (invoiceAIDetail.getBillTo().equalsIgnoreCase("1")) {
                    // 1:agent
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdAgent());                    
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("2")) {
                    // 2:Consignee
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdConsignee());                    
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("3")) {
                    // 3:Shipper
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdShipper());                    
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("4")) {
                    // 4:ShippingLine
                    newInvoiceAIDetail.setName(invoiceAIDetail.getShippingLine());                    
                }
            }
            
            newRepList.add(newInvoiceAIDetail);
       }
       
       reportList = newRepList;
       
       if(request.getParameter("idConsignee")!=null) {
           if (!request.getParameter("idConsignee").equalsIgnoreCase("")) {
               reportList = new ArrayList();
               invoiceAIDetail = null;
               try {
                    for (int i=0;i<newRepList.size();i++) {
                        invoiceAIDetail = (InvoiceAIDetail)repList.get(i);
                        if (invoiceAIDetail.getName()!=null) {
                            if (invoiceAIDetail.getName().contentEquals(request.getParameter("idConsignee").toString())) {
                                reportList.add(invoiceAIDetail);
                            }
                        }                        
                   }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }               
           } 
       }
       
       List realList = new ArrayList();
       try {            
            Query q = new Query ();            
            q.parse ("SELECT * FROM com.wings.persistence.InvoiceAIDetail order by name");

            // Execute the query.
            QueryResults qr = q.execute (reportList);

            // Cycle over the query results.
            List res = qr.getResults ();

            for (int i = 0; i < res.size (); i++)
            {
                invoiceAIDetail = (InvoiceAIDetail)res.get (i);                                
                realList.add(invoiceAIDetail);
            }

        } catch (Exception e) {
            
        }
       
       //Collections.sort(reportList,); 
       return realList;
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
        if (ds.getIdConsignee().equalsIgnoreCase("All")) {            
            list = com.wings.adapter.StrutsJobsheetDelegate.selectReportStatementOfAccount(ds);  
        } else {
            list = com.wings.adapter.StrutsJobsheetDelegate.selectReportStatementOfAccountByIdConsignee(ds);  
        }                     
        return list;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
                
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               InvoiceAIDetail invoiceAIDetail = (InvoiceAIDetail)list.get(i);
               valueOfTable[i][0] = invoiceAIDetail.getInvoiceDate();
               valueOfTable[i][1] = invoiceAIDetail.getJobNo();
               valueOfTable[i][2] = invoiceAIDetail.getInvoiceNumber();
               valueOfTable[i][3] = invoiceAIDetail.getHawb();
               valueOfTable[i][4] = invoiceAIDetail.getDestination();
               valueOfTable[i][5] = invoiceAIDetail.getTotalBillingUSD();
               valueOfTable[i][6] = invoiceAIDetail.getTotalBillingIDR();               
               valueOfTable[i][7] = invoiceAIDetail.getDDate();
               valueOfTable[i][8] = invoiceAIDetail.getIdNumber();               
               valueOfTable[i][9] = invoiceAIDetail.getName();
               valueOfTable[i][10] = invoiceAIDetail.getVatIDR();
               valueOfTable[i][11] = invoiceAIDetail.getVatIDR2();
               valueOfTable[i][12] = invoiceAIDetail.getPphIDR();
            }
        } catch (Exception e) {
           
        }
        return valueOfTable;  
    }  
}
