package com.wings.web.struts.actions;

import com.wings.persistence.BillingshipperDetail;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.JobsheetKey;
import com.wings.reports.datasource.InvoiceAIDataSource;
import com.wings.utils.EnglishDecimalFormat;
import com.wings.utils.IndonesianDecimalFormat;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.DestinationForm;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaiForm;
import com.wings.web.struts.forms.JobsheetaoForm;
import com.wings.web.struts.forms.JobsheetsiForm;
import com.wings.web.struts.forms.JobsheetsoForm;
import com.wings.web.struts.forms.ShipperForm;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintInvoiceAction extends Action {
    
   public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
   public static double totalBillingIDR = 0.0;
    public static  double totalBillingUSD = 0.0;
    public static  double totalExpensesIDR = 0.0;
    public static  double totalExpensesUSD = 0.0; 
    public static  double totalDPP = 0.0;
    public static  double totalDPP2 = 0.0;
    public static  double totalPPH = 0.0;
   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        InputStream imgInputStream = this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
        
        totalBillingIDR = 0.0;
        totalBillingUSD = 0.0;
        totalExpensesIDR = 0.0;
        totalExpensesUSD = 0.0; 
        totalDPP = 0.0;
        totalDPP2 = 0.0;
        totalPPH = 0.0;
        
        try                        
        {
            InvoiceForm invoiceForm = new InvoiceForm();
            RequestUtils.populate(invoiceForm, request);
            
            InvoiceKey invoiceKey = new InvoiceKey();  
            invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
            
            String jobType = com.wings.adapter.StrutsInvoiceDelegate.selectJobTypeByInvoiceKey(invoiceKey);
            
            String mapp = "";
            if (jobType.equalsIgnoreCase("AI")) {
                mapp = executeAIReport(request, invoiceKey, context, false, imgInputStream, "InvoiceAI");
            } else if (jobType.equalsIgnoreCase("AO")) {
                mapp = executeAOReport(request, invoiceKey, context, false, imgInputStream, "InvoiceAO");
            } else if (jobType.equalsIgnoreCase("SI")) {
                mapp = executeSIReport(request, invoiceKey, context, false, imgInputStream, "InvoiceSI");
            } else if (jobType.equalsIgnoreCase("SO")) {
                mapp = executeSOReport(request, invoiceKey, context, false, imgInputStream, "InvoiceSO");
            }
            
            
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   
   public static void resetValue() {
        totalBillingIDR = 0.0;
        totalBillingUSD = 0.0;
        totalExpensesIDR = 0.0;
        totalExpensesUSD = 0.0; 
        totalDPP = 0.0;
        totalDPP2 = 0.0;
        totalPPH = 0.0;
   }
   public static String executeAIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context, 
                                        boolean isservis, InputStream imgInputStream, String fileName) throws Exception {
                                        
        InvoiceAIDetail invoiceAIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAIDetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceAIDetail.getIdJobSheet());
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();
        jobsheetaiForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
        
        jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.editByIdJobsheet(jobsheetaiForm);
        
        ConsigneeForm consigneeForm = new ConsigneeForm();
        consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
        
        try {
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
        } catch (Exception e) {            
        }                
        
        AgentForm agentForm = new AgentForm();
        ConsigneeForm consigneeAsAgent = new ConsigneeForm();
        consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
        agentForm.setIdAgent(jobsheetForm.getIdAgent());
        try {
            consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
           BeanUtils.copyProperties(agentForm, consigneeAsAgent);
        } catch (Exception e) {
        }
        
        ShipperForm shipperForm = new ShipperForm();          
        ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
        consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
        shipperForm.setIdShipper(jobsheetForm.getIdShipper());
        try {
            consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
            BeanUtils.copyProperties(shipperForm, consigneeAsShipperForm);
            

        } catch (Exception e) {
        }       
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        
        Object[][] dtReport = PrintInvoiceAction.parseListToArray(list, isservis);

        JasperCompileManager.compileReportToFile(context.getRealPath("/invoice/"+fileName+".jrxml"));
        String reportFileName = context.getRealPath("/invoice/"+fileName+".jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();            
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", invoiceAIDetail.getInvoiceNumber());
        parameters.put("ShipperName", invoiceAIDetail.getShipperName());
        parameters.put("ConsigneeName", invoiceAIDetail.getConsigneeName());
        parameters.put("MAWB", invoiceAIDetail.getMawb());
        parameters.put("HAWB", invoiceAIDetail.getHawb());
        parameters.put("JobNo", invoiceAIDetail.getJobNo());
        parameters.put("FlightNo", invoiceAIDetail.getFlights());        
        parameters.put("Origin", invoiceAIDetail.getDestination());
        parameters.put("JobDesc", "Air Import".toUpperCase());
        
        if (jobsheetaiForm.getBillTo()!=null) {
           if (jobsheetaiForm.getBillTo().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeNameDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetaiForm.getBillTo().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeNameDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetaiForm.getBillTo().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeNameDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetaiForm.getBillTo().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeNameDetail", "");
                parameters.put("ConsigneeFax", "");
                parameters.put("ConsigneeAddress1", "");
                parameters.put("ConsigneeAddress2", "");
           }
        }        
        parameters.put("Weight", invoiceAIDetail.getQtyDesc() + " / "+ invoiceAIDetail.getWeightDesc());
        parameters.put("Volume", invoiceAIDetail.getVolumeDesc());
        parameters.put("Commodity", invoiceAIDetail.getCommodity());
        
        try {
            parameters.put("dueDate", FORMAT.format(invoiceAIDetail.getDueDate()));
        } catch (Exception e) {
            
        }
        try {
            parameters.put("invoiceDate", FORMAT.format(invoiceAIDetail.getInvoiceDate()));
        } catch (Exception e) {
            
        }
        
        parameters = countTotal(parameters, isservis);
        
        String perDistrict = null;                   

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new InvoiceAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   
   public static Map countTotal(Map parameters, boolean isservis) {
       EnglishDecimalFormat f = new EnglishDecimalFormat();
        IndonesianDecimalFormat i = new IndonesianDecimalFormat();
//        DecimalFormat moneyFormat = new DecimalFormat("###.##");
        DecimalFormat indMoneyFormat = new DecimalFormat("###,###");
        parameters.put("subTotalBillingIDR", indMoneyFormat.format(totalBillingIDR));
        parameters.put("dppIDR", indMoneyFormat.format(totalDPP));        
        parameters.put("dppIDR2", indMoneyFormat.format(new Double(totalDPP2 * 0.1)));
        
        parameters.put("totalPPH", indMoneyFormat.format(new Double(((totalDPP) + (totalDPP2 * 0.1)) * 0.02)));
                
        parameters.put("totalTax", indMoneyFormat.format(totalDPP * 0.1));
        parameters.put("totalTax2", indMoneyFormat.format(new Double(totalDPP2 * 0.01)));
        
        totalBillingIDR += (new Double(totalDPP * 0.1).doubleValue() + new Double(totalDPP2 * 0.01).doubleValue());
        
        parameters.put("totalBillingIDRAfterVat", indMoneyFormat.format(totalBillingIDR));
        
        totalBillingIDR = totalBillingIDR -new Double(((totalDPP) + (totalDPP2 * 0.1)) * 0.02).doubleValue();            
        
        parameters.put("grandTotal", indMoneyFormat.format(totalBillingIDR));
        
        parameters.put("strTotalBillingIDR", i.convert(String.valueOf(totalBillingIDR)).toUpperCase() + " RUPIAH");

        return parameters;
   }
   
   public static String executeAOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context, 
                                        boolean isservis, InputStream imgInputStream, String fileName) throws Exception {
       
        InvoiceAODetail invoiceAODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceAODetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceAODetail.getIdJobSheet());
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
        jobsheetaoForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
        
        jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
        
        ConsigneeForm consigneeForm = new ConsigneeForm();
        consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
        
        try {
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
        } catch (Exception e) {            
        }                
        
        AgentForm agentForm = new AgentForm();
        ConsigneeForm consigneeAsAgent = new ConsigneeForm();
        consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
        agentForm.setIdAgent(jobsheetForm.getIdAgent());
        try {
            consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
            BeanUtils.copyProperties(agentForm, consigneeAsAgent);
        } catch (Exception e) {
        }
        
        ShipperForm shipperForm = new ShipperForm();          
        ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
        consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
        shipperForm.setIdShipper(jobsheetForm.getIdShipper());
        try {
            consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
            BeanUtils.copyProperties(shipperForm, consigneeAsShipperForm);
            

        } catch (Exception e) {
        }       
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = PrintInvoiceAction.parseListToArray(list, isservis);

        JasperCompileManager.compileReportToFile(context.getRealPath("/invoice/"+fileName+".jrxml"));
        String reportFileName = context.getRealPath("/invoice/"+fileName+".jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();         

        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", invoiceAODetail.getInvoiceNumber());
        parameters.put("ShipperName", invoiceAODetail.getShipperName());
        parameters.put("ConsigneeName", invoiceAODetail.getConsigneeName());
        parameters.put("MAWB", invoiceAODetail.getMawb());
        parameters.put("HAWB", invoiceAODetail.getHawb());
        parameters.put("JobNo", invoiceAODetail.getJobNo());
        parameters.put("FlightNo", invoiceAODetail.getFlights());       
        parameters.put("Destination", invoiceAODetail.getDestination());        
        parameters.put("JobDesc", "Air Export".toUpperCase());
        
        if (jobsheetaoForm.getBillTo()!=null) {
           if (jobsheetaoForm.getBillTo().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeNameDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetaoForm.getBillTo().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeNameDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetaoForm.getBillTo().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeNameDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetaoForm.getBillTo().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeNameDetail", "");
                parameters.put("ConsigneeFax", "");
                parameters.put("ConsigneeAddress1", "");
                parameters.put("ConsigneeAddress2", "");
           }
        }
        
        parameters.put("Weight", invoiceAODetail.getQtyDesc() + " / " + invoiceAODetail.getWeightDesc());
        parameters.put("Volume", invoiceAODetail.getVolumeDesc());
        parameters.put("Commodity", invoiceAODetail.getCommodity());
        try {
            parameters.put("dueDate", FORMAT.format(invoiceAODetail.getDueDate()));
        } catch (Exception e) {            
        }
        try {
            parameters.put("invoiceDate", FORMAT.format(invoiceAODetail.getInvoiceDate()));
        } catch (Exception e) {            
        }
        
        parameters = countTotal(parameters, isservis);                

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new InvoiceAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;                
   }
   
   public static String executeSIReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context, 
                                        boolean isservis, InputStream imgInputStream, String fileName) throws Exception {
       
        InvoiceSIDetail invoiceSIDetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSIDetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceSIDetail.getIdJobSheet());
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
        jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
        jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
        
        ConsigneeForm consigneeForm = new ConsigneeForm();
        consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
        
        try {
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
        } catch (Exception e) {            
        }                
        
        AgentForm agentForm = new AgentForm();
        ConsigneeForm consigneeAsAgent = new ConsigneeForm();
        consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
        agentForm.setIdAgent(jobsheetForm.getIdAgent());
        try {
            consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
            BeanUtils.copyProperties(agentForm, consigneeAsAgent);
        } catch (Exception e) {
        }
        
        ShipperForm shipperForm = new ShipperForm();          
        ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
        consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
        shipperForm.setIdShipper(jobsheetForm.getIdShipper());
        try {
            consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
            BeanUtils.copyProperties(shipperForm, consigneeAsShipperForm);
        } catch (Exception e) {
        }       
        
        ConsigneeForm consigneeAsShippingLineForm = new ConsigneeForm();
        consigneeAsShippingLineForm.setIdConsignee(jobsheetsiForm.getShippingLine());
        try {
            consigneeAsShippingLineForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShippingLineForm);            
        } catch (Exception e) {
        }   
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = PrintInvoiceAction.parseListToArray(list, isservis);

        JasperCompileManager.compileReportToFile(context.getRealPath("/invoice/"+fileName+".jrxml"));
        String reportFileName = context.getRealPath("/invoice/"+fileName+".jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();      
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", invoiceSIDetail.getInvoiceNumber());
        parameters.put("ShipperName", invoiceSIDetail.getShipperName());
        parameters.put("ConsigneeName", invoiceSIDetail.getConsigneeName());
        
        if (jobsheetsiForm.getBillTo()!=null) {
           if (jobsheetsiForm.getBillTo().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetsiForm.getBillTo().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+ consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetsiForm.getBillTo().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetsiForm.getBillTo().equalsIgnoreCase("4")) {
               parameters.put("ConsigneeDetail", consigneeAsShippingLineForm.getDescription2());
                parameters.put("ConsigneeFax", consigneeAsShippingLineForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeAsShippingLineForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeAsShippingLineForm.getAddress2() + " " +
                        consigneeAsShippingLineForm.getPostalCode() + " " +consigneeAsShippingLineForm.getCity() + " "+consigneeAsShippingLineForm.getRegion());
           }
        }
        
        parameters.put("HBLNO", invoiceSIDetail.getTermHBL());
        parameters.put("VESSEL", invoiceSIDetail.getFeederVessel());
        parameters.put("JobNo", invoiceSIDetail.getJobNo());        
        parameters.put("Origin", invoiceSIDetail.getOrigin());        
        parameters.put("JobDesc", "Sea Import".toUpperCase());
        
        parameters.put("Weight", invoiceSIDetail.getQtyDesc() + " / " + invoiceSIDetail.getWeightDesc());
        parameters.put("Volume", invoiceSIDetail.getVolumeDesc());
        parameters.put("Commodity", invoiceSIDetail.getCommodity());
        try {
            parameters.put("dueDate", FORMAT.format(invoiceSIDetail.getDueDate()));
        } catch (Exception e) {            
        }        
        try {
            parameters.put("invoiceDate", FORMAT.format(invoiceSIDetail.getInvoiceDate()));
        } catch (Exception e) {            
        }
        
        parameters = countTotal(parameters, isservis);        
                       
        
        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new InvoiceAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   
   public static String executeSOReport(HttpServletRequest request, InvoiceKey invoiceKey, ServletContext context, 
                                        boolean isservis, InputStream imgInputStream, String fileName) throws Exception {
        
        
        InvoiceSODetail invoiceSODetail = com.wings.adapter.StrutsInvoiceDelegate.selectInvoiceSODetailByInvoiceKey(invoiceKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(invoiceSODetail.getIdJobSheet());
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
        jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
        
        jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
        
        ConsigneeForm consigneeForm = new ConsigneeForm();
        consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
        
        try {
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
        } catch (Exception e) {            
        }                
        
        AgentForm agentForm = new AgentForm();
        ConsigneeForm consigneeAsAgent = new ConsigneeForm();
        consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
        agentForm.setIdAgent(jobsheetForm.getIdAgent());
        try {
            consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
            BeanUtils.copyProperties(agentForm, consigneeAsAgent);
        } catch (Exception e) {
        }
        
        ShipperForm shipperForm = new ShipperForm();          
        ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
        consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
        shipperForm.setIdShipper(jobsheetForm.getIdShipper());
        try {
            consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
            BeanUtils.copyProperties(shipperForm, consigneeAsShipperForm);            
        } catch (Exception e) {
        }       
        DestinationForm destinationForm = new DestinationForm();
        destinationForm.setIdDestination(invoiceSODetail.getDestination());
        try {
            destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
        } catch (Exception e) {
        }
        
        ConsigneeForm consigneeAsShippingLineForm = new ConsigneeForm();
        consigneeAsShippingLineForm.setIdConsignee(jobsheetsoForm.getShippingLine());
        try {
            consigneeAsShippingLineForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShippingLineForm);            
        } catch (Exception e) {
        }    
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = PrintInvoiceAction.parseListToArray(list, isservis);

        JasperCompileManager.compileReportToFile(context.getRealPath("/invoice/"+fileName+".jrxml"));
        String reportFileName = context.getRealPath("/invoice/"+fileName+".jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();      
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", invoiceSODetail.getInvoiceNumber());
        parameters.put("ShipperName", invoiceSODetail.getShipperName());
        parameters.put("ConsigneeName", invoiceSODetail.getConsigneeName());
        
        if (jobsheetsoForm.getBillTo()!=null) {
           if (jobsheetsoForm.getBillTo().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+ agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetsoForm.getBillTo().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetsoForm.getBillTo().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetsoForm.getBillTo().equalsIgnoreCase("4")) {
                 parameters.put("ConsigneeDetail", consigneeAsShippingLineForm.getDescription2());
                parameters.put("ConsigneeFax", consigneeAsShippingLineForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeAsShippingLineForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeAsShippingLineForm.getAddress2() + " " +
                        consigneeAsShippingLineForm.getPostalCode() + " " +consigneeAsShippingLineForm.getCity() + " "+consigneeAsShippingLineForm.getRegion());
           }
        }
                
        parameters.put("HBLNO", invoiceSODetail.getTermHBL());
        parameters.put("VESSEL", invoiceSODetail.getFeederVessel());
        parameters.put("JobNo", invoiceSODetail.getJobNo());        
        parameters.put("Destination", destinationForm.getName());        
        parameters.put("JobDesc", "Sea Export".toUpperCase());
        
        parameters.put("Weight", invoiceSODetail.getQtyDesc() + " / " + invoiceSODetail.getWeightDesc());
        parameters.put("Volume", invoiceSODetail.getVolumeDesc());
        parameters.put("Commodity", invoiceSODetail.getCommodity());
        try {
            parameters.put("dueDate", FORMAT.format(invoiceSODetail.getDueDate()));
        } catch (Exception e) {            
        }
        try {
            parameters.put("invoiceDate", FORMAT.format(invoiceSODetail.getInvoiceDate()));
        } catch (Exception e) {            
        }
        
        parameters = countTotal(parameters, isservis);        
        
        String perDistrict = null;                   

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new InvoiceAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   
   public static Object[][] parseListToArray(List list, boolean service) {
        PrintInvoiceAction.resetValue();
        Object[][] valueOfTable = new Object[list.size()][7];
        if (service) {
             try {
                ArrayList newList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    BillingshipperDetail bs = (BillingshipperDetail)list.get(i);
                    if ((bs.getIsTax().intValue()>0) || (bs.getIsTax2().intValue()>0)) {
                        newList.add(bs);
                    }
                    if (bs.getDescriptionFee().equalsIgnoreCase("MATERAI")) {
                         newList.add(bs);
                    }
                }                
                valueOfTable = new Object[newList.size()][7];
                list = newList;                
             } catch (Exception e) {
                e.printStackTrace();
             }
        }        
        try {
            for (int i = 0; i < list.size(); i++) {
                BillingshipperDetail bs = (BillingshipperDetail)list.get(i);
                valueOfTable[i][0] = String.valueOf(bs.getDescriptionFee());
                valueOfTable[i][1] = bs.getDescriptionInvoice();
                
                valueOfTable[i][5] = "Cost To Cost";
                
                if (bs.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][2] = new Double(0.0);
                    valueOfTable[i][3] = bs.getCharge();                    
                    totalBillingIDR=totalBillingIDR+bs.getCharge().doubleValue();                    
                } else {
                    valueOfTable[i][2] = bs.getCharge();
                    valueOfTable[i][3] = new Double(0.0);
                    totalBillingUSD=totalBillingUSD+bs.getCharge().doubleValue();
                } 
                
                if (bs.getIsTax().intValue()>0) {
                    totalDPP+=bs.getCharge().doubleValue();
                    valueOfTable[i][5] = "Service";                    
                }
                if (bs.getIsTax2().intValue()>0) {
                    totalDPP2+=bs.getCharge().doubleValue();
                    valueOfTable[i][5] = "Service";
                }
                if (bs.getIsVat().intValue()>0) {
                    totalPPH+=bs.getCharge().doubleValue();
                }    
                
                valueOfTable[i][4] = bs.getDescriptionFee();
                
            }
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;
    }     
}
