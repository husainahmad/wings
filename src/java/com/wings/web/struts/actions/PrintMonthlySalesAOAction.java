package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetDetailAO;
import com.wings.persistence.MonthlySales;
import com.wings.reports.datasource.MonthlySalaryAIDataSource;
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

public final class PrintMonthlySalesAOAction extends Action {       
   
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
            Object[][] dtReport = this.parseListToArray(list);
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/reports/MonthlySalesAO.jrxml"));
            String reportFileName = context.getRealPath("/reports/MonthlySalesAO.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists()) {
                JasperCompileManager.compileReportToFile(context.getRealPath("/reports/MonthlySalesAO.jrxml"));
                reportFile = new File(reportFileName);
            }                    

            Map parameters = new HashMap();            
            
            //parameters.put("ConsigneeName", request.getParameter("perConsignee"));            
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("Periode", request.getParameter("from") + " - " + request.getParameter("to"));               
            
            double kursBI = 0.0;
            try {
                kursBI = Double.parseDouble(request.getParameter("kursBI").toString());
            } catch (Exception e) {                
            }            
            parameters.put("Kurs", new Double(kursBI));
            
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new MonthlySalaryAIDataSource(dtReport)
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
        ds.setJobType("AO");
        List globalList = null;
        globalList = com.wings.adapter.StrutsJobsheetDelegate.selectReportMonthlySalesAO(ds);  
        List iList = com.wings.adapter.StrutsJobsheetDelegate.selectReportMonthlySalesInvoiceAO(ds);
        
        List finalList = new ArrayList();
        try {
            Query q = new Query ();            
            for (int i=0; i<globalList.size(); i++) {
                try {
                    JobsheetDetailAO jobDetail = (JobsheetDetailAO)globalList.get(i);
                    q.parse("select distinct inumber, totalIDR, totalUSD, shipper, consignee, agent, billTo, billToDebit, vatIDR, pphIDR, vatIDR2  from com.wings.persistence.JobsheetDetail where jobNo = '"+jobDetail.getJobNo()+"' ");
                    QueryResults qr2 = q.execute (iList);            
                    List qrList = qr2.getResults();
                    MonthlySales ms = null;
                    String[] remark = null;
                    
                    double vat1 = 0.0;
                    double vat2 = 0.0;
                    double pph = 0.0;
                    
                    for (int j=0;j<qrList.size();j++) {
                        try {
                            List nList = (List)qrList.get(j);
                            try {
                                vat1+=new Double(nList.get(8).toString()).doubleValue();
                            } catch (Exception ex) {                                
                            }
                            try {
                                pph+=new Double(nList.get(9).toString()).doubleValue();
                            } catch (Exception ex) {                                
                            }
                            try {
                                vat2+=new Double(nList.get(10).toString()).doubleValue();
                            } catch (Exception ex) {                                
                            }
                            ms = new MonthlySales();
                            ms.setFlights(jobDetail.getFlights());
                            ms.setGroupingBy(jobDetail.getFlights()+jobDetail.getJobNo());
                            Double totalIncomingIDR = new Double(0.0);
                            
                            Double totalOutgoingIDR = new Double(0.0);
                            if (nList.get(0).toString().contains("DN/")) {
                                if (nList.get(7).toString().equalsIgnoreCase("1")) {
                                    ms.setCustomer(nList.get(5).toString());
                                }
                                if (nList.get(7).toString().equalsIgnoreCase("2")) {
                                    ms.setCustomer(nList.get(4).toString());
                                } 
                                if (nList.get(7).toString().equalsIgnoreCase("3")) {
                                    ms.setCustomer(nList.get(3).toString());
                                }
                                if (nList.get(7).toString().equalsIgnoreCase("4")) {
                                    ms.setCustomer(jobDetail.getFlights());
                                }

                            } else {
                                if (nList.get(6).toString().equalsIgnoreCase("1")) {
                                    ms.setCustomer(nList.get(5).toString());
                                }
                                if (nList.get(6).toString().equalsIgnoreCase("2")) {
                                    ms.setCustomer(nList.get(4).toString());
                                } 
                                if (nList.get(6).toString().equalsIgnoreCase("3")) {
                                    ms.setCustomer(nList.get(3).toString());
                                }
                                if (nList.get(6).toString().equalsIgnoreCase("4")) {
                                    ms.setCustomer(jobDetail.getFlights());
                                }
                            }
                            
                            if (j==0) {
                                ms.setIrow("1");
                                ms.setShippedDate(jobDetail.getShippeddate());
                                ms.setJobNo(jobDetail.getJobNo());
                               
                                ms.setGwt(jobDetail.getWeightDesc());
                                ms.setMawb(jobDetail.getMawb());
                                ms.setVwt(jobDetail.getVolumeDesc());
                                ms.setOrigin(jobDetail.getDestination());
                                remark = jobDetail.getRemark().split(",");
                                try {
                                    if (jobDetail.getRemark().split(",").length>j) {
                                       ms.setRemark(remark[j]); 
                                    }
                                } catch (Exception ex) {
                                    ms.setRemark(jobDetail.getRemark());
                                }                                
                                ms.setPag(jobDetail.getPag());

                                ms.setInumber(nList.get(0).toString());
                                totalIncomingIDR = new Double(0.0);
                                totalIncomingIDR = new Double(new Double(nList.get(1).toString()).doubleValue() + 
                                                                    new Double(nList.get(8).toString()).doubleValue() +
                                                                    new Double(nList.get(10).toString()).doubleValue());
                                ms.setIncomingIDR(totalIncomingIDR);
                                ms.setIncomingUSD(new Double(nList.get(2).toString()));
                                if (j==qrList.size()-1) {
                                    ms.setIrow("N");
                                    ms.setInumber(nList.get(0).toString());
                                   totalIncomingIDR = new Double(0.0);
                                    totalIncomingIDR = new Double(new Double(nList.get(1).toString()).doubleValue() + 
                                                                        new Double(nList.get(8).toString()).doubleValue() +
                                                                        new Double(nList.get(10).toString()).doubleValue());
                                    ms.setIncomingIDR(totalIncomingIDR);
                                    ms.setIncomingUSD(new Double(nList.get(2).toString()));
                                    ms.setOutgoingIDR(new Double(jobDetail.getTotalExpensesIDR().doubleValue()));
                                    ms.setOutgoingUSD(jobDetail.getTotalExpensesUSD());
                                    
                                    ms.setOutgoingRefund(jobDetail.getRefund());
                                    ms.setOutgoingRefundUS(jobDetail.getRefundUS());
                                    ms.setOutgoingRefundIDR(jobDetail.getRefundIDR());
                                    ms.setOutgoingRefundUSD(jobDetail.getRefundUSD());                                    
                                    ms.setRefundAgentIDR(jobDetail.getRefundIDR());
                                    ms.setRefundAgentUSD(jobDetail.getRefundUSD());   
                                    ms.setPag(jobDetail.getPag());
                                    ms.setOutgoingTax(Double.valueOf(vat1));
                                    ms.setBsPPH(Double.valueOf(pph));    
                                    ms.setVatIDR2(Double.valueOf(vat2));
                                }                                 
                            } else if (j==qrList.size()-1) {
                                ms.setIrow("N");
                                ms.setInumber(nList.get(0).toString());
                                totalIncomingIDR = new Double(0.0);
                                totalIncomingIDR = new Double(new Double(nList.get(1).toString()).doubleValue() + 
                                                                    new Double(nList.get(8).toString()).doubleValue() +
                                                                    new Double(nList.get(10).toString()).doubleValue());
                                ms.setIncomingIDR(totalIncomingIDR);
                                ms.setIncomingUSD(new Double(nList.get(2).toString()));
                                ms.setOutgoingIDR(new Double(jobDetail.getTotalExpensesIDR().doubleValue()));
                                ms.setOutgoingUSD(jobDetail.getTotalExpensesUSD());
                                
                                ms.setOutgoingRefund(jobDetail.getRefund());
                                
                                ms.setOutgoingRefundUS(jobDetail.getRefundUS());
                                ms.setOutgoingRefundIDR(jobDetail.getRefundIDR());
                                ms.setOutgoingRefundUSD(jobDetail.getRefundUSD());  
                                
                                ms.setRefundAgentIDR(jobDetail.getRefundIDR());
                                ms.setRefundAgentUSD(jobDetail.getRefundUSD());
                                
                                ms.setPag(jobDetail.getPag());
                                remark = jobDetail.getRemark().split(",");
                                try {
                                    if (jobDetail.getRemark().split(",").length>j) {
                                        ms.setRemark(remark[j]);
                                        if (jobDetail.getRemark().split(",").length>j+1) {
                                            ms.setRemark(ms.getRemark()+" "+remark[j+1]);
                                        }                                                                      
                                    }
                                } catch (Exception ex) {
                                    ms.setRemark(jobDetail.getRemark());
                                }
                                ms.setPag(jobDetail.getPag());
                                
                                ms.setOutgoingTax(Double.valueOf(vat1));
                                ms.setBsPPH(Double.valueOf(pph));    
                                ms.setVatIDR2(Double.valueOf(vat2));
                            } else {
                                ms.setIrow("2");
                                ms.setInumber(nList.get(0).toString());
                                ms.setIncomingIDR(new Double(nList.get(1).toString()));
                                ms.setIncomingUSD(new Double(nList.get(2).toString()));
                                remark = jobDetail.getRemark().split(",");
                                try {
                                    if (jobDetail.getRemark().split(",").length>j) {
                                        ms.setRemark(remark[j]);
                                        if (jobDetail.getRemark().split(",").length>j+1) {
                                            ms.setRemark(ms.getRemark()+" "+remark[j+1]);
                                        }                                                                      
                                    }
                                } catch (Exception ex) {
                                    ms.setRemark(jobDetail.getRemark());
                                }
                                ms.setPag(jobDetail.getPag());
                            }
                            finalList.add(ms); 
                        } catch (Exception ex2) {      
                            System.out.println(ex2.getMessage());
                        }                        
                    }
                    if ((jobDetail.getCnNo()!=null)&&(jobDetail.getCnNo().length()>0)) {
                        MonthlySales ms2 = new MonthlySales();
                        ms2.setFlights(jobDetail.getFlights());
                        ms2.setGroupingBy(jobDetail.getFlights()+jobDetail.getJobNo());
                        ms2.setInumber(jobDetail.getCnNo());
                        ms2.setIrow("K"); // row id for kredit note
                        ms2.setCreditNoteIDR(jobDetail.getCreditNoteIDR());
                        ms2.setCreditNoteUSD(jobDetail.getCreditNoteUSD());
                        ms2.setCustomer(jobDetail.getIdAgent());
                        ms2.setOutgoingIDR(new Double(0.0));
                        ms2.setOutgoingUSD(new Double(0.0));
                        ms2.setOutgoingRefund(new Double(0.0));
                        ms2.setOutgoingRefundUS(new Double(0.0));
                        ms2.setRefundAgentIDR(new Double(0.0));
                        ms2.setRefundAgentUSD(new Double(0.0));
                                               
                        finalList.add(ms2); 
                    }
                } catch (Exception ex) {        
                    System.out.println(ex.getMessage());
                }
                
            }                        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return finalList;
    }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][29];  
        MonthlySales ms = null;     
        Double tax = null;
        Double totalExpensesIDR = null;
        try {            
            for (int i = 0; i < list.size(); i++) {                                
               ms = (MonthlySales)list.get(i);
               valueOfTable[i][0] = ms.getShippedDate();
               valueOfTable[i][1] = ms.getCustomer();
               valueOfTable[i][2] = ms.getInumber();//jobsheetDetail.getInvoiceNumber();
               valueOfTable[i][3] = ms.getJobNo();//jobsheetDetail.getJobNo();
               valueOfTable[i][4] = ms.getMawb();//jobsheetDetail.getMawb();
               valueOfTable[i][5] = ms.getOrigin();//jobsheetDetail.getDestination(); // origin ??
               valueOfTable[i][6] = ms.getGwt();//jobsheetDetail.getWeightDesc();// gwt ??
               valueOfTable[i][7] = ms.getVwt();//jobsheetDetail.getVolumeDesc();  // vwt ??
               valueOfTable[i][8] = ms.getIncomingIDR();
               valueOfTable[i][9] = ms.getIncomingUSD();//jobsheetDetail.getTotalBillingUSD();
//               tax = new Double(jobsheetDetail.getBaTax().doubleValue()+ jobsheetDetail.getBsTax().doubleValue());
//               totalExpensesIDR = new Double(jobsheetDetail.getTotalExpensesIDR().doubleValue()-jobsheetDetail.getRefund().doubleValue()-tax.doubleValue());
               if (ms.getIrow().equalsIgnoreCase("N")) {
                   
                   valueOfTable[i][10] = ms.getOutgoingUSD();//ms.getOutgoingUSD();//ms.get;
                   valueOfTable[i][11] = null;//ms.getOutgoingIDR();//jobsheetDetail.getTotalExpensesUSD();   
                   valueOfTable[i][12] = null;//ms.get
                   valueOfTable[i][13] = null;//ms.get; 
                   valueOfTable[i][14] = ms.getRemark(); // remark               
                   valueOfTable[i][15] = ms.getGroupingBy();
                   valueOfTable[i][16] = ms.getOutgoingIDR();
                   valueOfTable[i][17] = ms.getOutgoingUSD();
                   valueOfTable[i][18] = ms.getOutgoingRefund();
                   valueOfTable[i][19] = ms.getOutgoingTax();
                   valueOfTable[i][20] = ms.getPag(); 
                   valueOfTable[i][21] = ms.getFlights();
                   valueOfTable[i][22] = ms.getRefundAgentIDR();
                   valueOfTable[i][23] = ms.getRefundAgentUSD();
                   valueOfTable[i][24] = new Double(0.0);
                   valueOfTable[i][25] = new Double(0.0);
                   valueOfTable[i][26] = ms.getOutgoingRefundUS();
                   valueOfTable[i][27] = ms.getBsPPH();
                   valueOfTable[i][28] = ms.getVatIDR2();
                   
               } else if (ms.getIrow().equalsIgnoreCase("K")) {                   
                   valueOfTable[i][8] = null;
                   valueOfTable[i][9] = null;//jobsheetDetail.getTotalBillingUSD();
                   valueOfTable[i][10] = null;//ms.getOutgoingUSD();//ms.get;
                   valueOfTable[i][11] = null;//ms.getOutgoingIDR();//jobsheetDetail.getTotalExpensesUSD();   
                   valueOfTable[i][12] = null;//ms.get
                   valueOfTable[i][13] = null;//ms.get; 
                   valueOfTable[i][14] = null; // remark               
                   valueOfTable[i][15] = ms.getGroupingBy();
                   valueOfTable[i][16] = null;
                   valueOfTable[i][17] = null;
                   valueOfTable[i][18] = null;
                   valueOfTable[i][19] = null;
                   valueOfTable[i][20] = null; 
                   valueOfTable[i][21] = ms.getFlights();
                   valueOfTable[i][22] = null;
                   valueOfTable[i][23] = null;
                   valueOfTable[i][24] = ms.getCreditNoteIDR();
                   valueOfTable[i][25] = ms.getCreditNoteUSD();
                   valueOfTable[i][26] = null;    
                   valueOfTable[i][27] = null;
                   valueOfTable[i][28] = new Double(0.0);
               } else {
                   valueOfTable[i][10] = null;//ms.getOutgoingUSD();//ms.get;
                   valueOfTable[i][11] = null;//ms.getOutgoingIDR();//jobsheetDetail.getTotalExpensesUSD();   
                   valueOfTable[i][12] = null;//ms.get
                   valueOfTable[i][13] = null;//ms.get; 
                   valueOfTable[i][14] = ms.getRemark(); // remark    
                   valueOfTable[i][15] = ms.getGroupingBy();
                   valueOfTable[i][16] = null;
                   valueOfTable[i][17] = null;
                   valueOfTable[i][18] = null;
                   valueOfTable[i][19] = null;
                   valueOfTable[i][20] = null; 
                   valueOfTable[i][21] = ms.getFlights();
                   valueOfTable[i][22] = null;
                   valueOfTable[i][23] = null;
                   valueOfTable[i][24] = new Double(0.0);
                   valueOfTable[i][25] = new Double(0.0);
                   valueOfTable[i][26] = null;
                   valueOfTable[i][27] = null;
                   valueOfTable[i][28] = new Double(0.0);
               }                                             
            }
        } catch (Exception e) {
           System.out.println(e);
        }
        return valueOfTable;  
    }  
}
