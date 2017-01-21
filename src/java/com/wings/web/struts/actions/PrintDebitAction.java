package com.wings.web.struts.actions;

import com.wings.persistence.BillingagentDetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.JobsheetKey;
import com.wings.reports.datasource.DebitAIDataSource;
import com.wings.utils.EnglishDecimalFormat;
import com.wings.utils.IndonesianDecimalFormat;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.DebitForm;
import com.wings.web.struts.forms.DestinationForm;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.Destination;
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

public final class PrintDebitAction extends Action {
    
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private double totalBillingIDR = 0.0;
   private double totalBillingUSD = 0.0;
   private double totalExpensesIDR = 0.0;
   private double totalExpensesUSD = 0.0; 
   
   private double totalTax = 0.0;
   private double totalTax2 = 0.0;
   private double totalPPH = 0.0;
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        totalBillingIDR = 0.0;
        totalBillingUSD = 0.0;
        totalExpensesIDR = 0.0;
        totalExpensesUSD = 0.0; 
        totalTax = 0.0;
        totalTax2 = 0.0;
        totalPPH = 0.0;
        
        try                        
        {
            DebitForm debitForm = new DebitForm();
            RequestUtils.populate(debitForm, request);
                        
            DebitKey debitKey = new DebitKey();  
            debitKey.setIdDebit(debitForm.getIdDebit());
                                    
            String jobType = com.wings.adapter.StrutsDebitDelegate.selectJobTypeByDebitKey(debitKey);
            
            String mapp = "";
            if (jobType.equalsIgnoreCase("AI")) {
                mapp = executeAIReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("AO")) {
                mapp = executeAOReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("SI")) {
                mapp = executeSIReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("SO")) {
                mapp = executeSOReport(request, debitKey, context);
            }
            return mapping.findForward("view");
            
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   private Map countTotal(Map parameters) {
       EnglishDecimalFormat f = new EnglishDecimalFormat();
        IndonesianDecimalFormat i = new IndonesianDecimalFormat();
//        DecimalFormat moneyFormat = new DecimalFormat("###.##");
        DecimalFormat indMoneyFormat = new DecimalFormat("###,###");
        parameters.put("subTotalBillingIDR", indMoneyFormat.format(totalBillingIDR));
        
        totalPPH = totalPPH * 0.02;
        parameters.put("totalPPH", indMoneyFormat.format(totalPPH));
                
        totalTax = totalTax * 0.10;
        totalTax2 = totalTax2 * 0.01;
        parameters.put("totalTax", indMoneyFormat.format(totalTax));
        parameters.put("totalTax2", indMoneyFormat.format(totalTax2));
        totalBillingIDR += (totalTax+totalTax2);
        
        parameters.put("totalBillingIDRAfterVat", indMoneyFormat.format(totalBillingIDR));
        
        totalBillingIDR = totalBillingIDR-totalPPH;
        parameters.put("grandTotal", indMoneyFormat.format(totalBillingIDR));
        
        parameters.put("strTotalBillingIDR", i.convert(String.valueOf(totalBillingIDR)).toUpperCase() + " RUPIAH");

        return parameters;
   }
   private String executeAIReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitAIDetail debitAIDetail = com.wings.adapter.StrutsDebitDelegate.selectDebitAIDetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitAIDetail.getIdJobSheet());
        
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
        //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm);
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = this.parseListToArray(list);

        JasperCompileManager.compileReportToFile(context.getRealPath("/debit/DebitAI.jrxml"));
        String reportFileName = context.getRealPath("/debit/DebitAI.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();  
        InputStream imgInputStream = this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", debitAIDetail.getDebitNumber());
        parameters.put("ShipperName", debitAIDetail.getShipperName());
        parameters.put("ConsigneeName", debitAIDetail.getConsigneeName());
        
        
        if (jobsheetaiForm.getBillToDebit()!=null) {
           if (jobsheetaiForm.getBillToDebit().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeNameDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetaiForm.getBillToDebit().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeNameDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetaiForm.getBillToDebit().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeNameDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetaiForm.getBillToDebit().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeDetail", "");
                parameters.put("ConsigneeFax", "");
                parameters.put("ConsigneeAddress1", "");
                parameters.put("ConsigneeAddress2", "");
           }
        }
        
        parameters.put("MAWB", debitAIDetail.getMawb());
        parameters.put("HAWB", debitAIDetail.getHawb());
        parameters.put("JobNo", debitAIDetail.getJobNo());
        parameters.put("FlightNo", debitAIDetail.getFlights());
        parameters.put("Origin", debitAIDetail.getDestination());
        parameters.put("JobDesc", "Air Import".toUpperCase());
        
        parameters.put("Weight", debitAIDetail.getQtyDesc() + " / " + debitAIDetail.getWeightDesc());
        parameters.put("Volume", debitAIDetail.getVolumeDesc());
        parameters.put("Commodity", debitAIDetail.getCommodity());
        try {
            parameters.put("dueDate", FORMAT.format(debitAIDetail.getDueDate()));
        } catch (Exception e) {            
        }
        try {
            parameters.put("debitDate", FORMAT.format(debitAIDetail.getDebitDate()));
        } catch (Exception e) {            
        }
        parameters = countTotal(parameters);                              

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new DebitAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   private String executeAOReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitAODetail debitAODetail = com.wings.adapter.StrutsDebitDelegate.selectDebitAODetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitAODetail.getIdJobSheet());
        
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
        
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = this.parseListToArray(list);

        JasperCompileManager.compileReportToFile(context.getRealPath("/debit/DebitAO.jrxml"));
        String reportFileName = context.getRealPath("/debit/DebitAO.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();          
        InputStream imgInputStream = this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", debitAODetail.getDebitNumber());
        parameters.put("ShipperName", debitAODetail.getShipperName());
        parameters.put("ConsigneeName", debitAODetail.getConsigneeName());
        parameters.put("MAWB", debitAODetail.getMawb());
        parameters.put("HAWB", debitAODetail.getHawb());
        parameters.put("JobNo", debitAODetail.getJobNo());
        parameters.put("FlightNo", debitAODetail.getFlights());       
        parameters.put("Destination", debitAODetail.getDestination());        
        parameters.put("JobDesc", "Air Export".toUpperCase());
        
        
        if (jobsheetaoForm.getBillToDebit()!=null) {
           if (jobsheetaoForm.getBillToDebit().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeNameDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetaoForm.getBillToDebit().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeNameDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetaoForm.getBillToDebit().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeNameDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:" + shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetaoForm.getBillToDebit().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeDetail", "");
                parameters.put("ConsigneeFax", "");
                parameters.put("ConsigneeAddress1", "");
                parameters.put("ConsigneeAddress2", "");
           }
        }        
        
        parameters.put("Weight", debitAODetail.getWeightDesc() + " / " + debitAODetail.getQtyDesc());
        parameters.put("Volume", debitAODetail.getVolumeDesc());
        parameters.put("Commodity", debitAODetail.getCommodity());
        
        try {
            parameters.put("dueDate", FORMAT.format(debitAODetail.getDueDate()));
        } catch (Exception e) {
            
        }
        try {
            parameters.put("debitDate", FORMAT.format(debitAODetail.getDebitDate()));
        } catch (Exception e) {            
        }        
        
        parameters = countTotal(parameters);                                   

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new DebitAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   private String executeSIReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitSIDetail debitSIDetail = com.wings.adapter.StrutsDebitDelegate.selectDebitSIDetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitSIDetail.getIdJobSheet());        
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
        jobsheetsiForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
        
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = this.parseListToArray(list);

        JasperCompileManager.compileReportToFile(context.getRealPath("/debit/DebitSI.jrxml"));
        String reportFileName = context.getRealPath("/debit/DebitSI.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();      
        InputStream imgInputStream = this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", debitSIDetail.getDebitNumber());
        parameters.put("ShipperName", debitSIDetail.getShipperName());
        parameters.put("ConsigneeName", debitSIDetail.getConsigneeName());
        
        if (jobsheetsiForm.getBillToDebit()!=null) {
           if (jobsheetsiForm.getBillToDebit().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetsiForm.getBillToDebit().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetsiForm.getBillToDebit().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetsiForm.getBillToDebit().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeDetail", consigneeAsShippingLineForm.getDescription2());
                parameters.put("ConsigneeFax", consigneeAsShippingLineForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeAsShippingLineForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeAsShippingLineForm.getAddress2() + " " +
                        consigneeAsShippingLineForm.getPostalCode() + " " +consigneeAsShippingLineForm.getCity() + " "+consigneeAsShippingLineForm.getRegion());
           }
        }
        
        parameters.put("HBLNO", debitSIDetail.getTermHBL());
        parameters.put("VESSEL", debitSIDetail.getFeederVessel());
        parameters.put("JobNo", debitSIDetail.getJobNo());        
        parameters.put("Origin", debitSIDetail.getOrigin());        
        parameters.put("JobDesc", "Sea Import".toUpperCase());
        
        parameters.put("Weight", debitSIDetail.getQtyDesc() + " / " + debitSIDetail.getWeightDesc());
        parameters.put("Volume", debitSIDetail.getVolumeDesc());
        parameters.put("Commodity", debitSIDetail.getCommodity());
        
        try {
            parameters.put("dueDate", FORMAT.format(debitSIDetail.getDueDate()));
        } catch (Exception e) {
            
        }
        try {
            parameters.put("debitDate", FORMAT.format(debitSIDetail.getDebitDate()));
        } catch (Exception e) {            
        }   
        
        parameters = countTotal(parameters);   
                
        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new DebitAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   private String executeSOReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitSODetail debitSODetail = com.wings.adapter.StrutsDebitDelegate.selectDebitSODetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitSODetail.getIdJobSheet());
        
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
        
        JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
        jobsheetsoForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
        
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
        destinationForm.setIdDestination(debitSODetail.getDestination());
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);

        Object[][] dtReport = this.parseListToArray(list);

        JasperCompileManager.compileReportToFile(context.getRealPath("/debit/DebitSO.jrxml"));
        String reportFileName = context.getRealPath("/debit/DebitSO.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();
        InputStream imgInputStream = this.getClass().getResourceAsStream("/com/wings/images/logo.png"); 
        parameters.put("IMAGE", imgInputStream);
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("No", debitSODetail.getDebitNumber());
        parameters.put("ShipperName", debitSODetail.getShipperName());
        parameters.put("ConsigneeName", debitSODetail.getConsigneeName());
        
        if (jobsheetsoForm.getBillToDebit()!=null) {
           if (jobsheetsoForm.getBillToDebit().equalsIgnoreCase("1")) {
                parameters.put("ConsigneeDetail", agentForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+agentForm.getTelp());
                parameters.put("ConsigneeAddress1", agentForm.getAddress1());
                parameters.put("ConsigneeAddress2", agentForm.getAddress2() + " " +
                        agentForm.getPostalCode() + " " +agentForm.getCity() + " "+agentForm.getRegion());
           }
           if (jobsheetsoForm.getBillToDebit().equalsIgnoreCase("2")) {
                parameters.put("ConsigneeDetail", consigneeForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+consigneeForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeForm.getAddress2() + " " +
                        consigneeForm.getPostalCode() + " " +consigneeForm.getCity() + " "+consigneeForm.getRegion());
           } 
           if (jobsheetsoForm.getBillToDebit().equalsIgnoreCase("3")) {
                parameters.put("ConsigneeDetail", shipperForm.getDescription2());
                parameters.put("ConsigneeFax", "PH:"+shipperForm.getTelp());
                parameters.put("ConsigneeAddress1", shipperForm.getAddress1());
                parameters.put("ConsigneeAddress2", shipperForm.getAddress2() + " " +
                        shipperForm.getPostalCode() + " " +shipperForm.getCity() + " "+shipperForm.getRegion());
           }
           if (jobsheetsoForm.getBillToDebit().equalsIgnoreCase("4")) {
                parameters.put("ConsigneeDetail", consigneeAsShippingLineForm.getDescription2());
                parameters.put("ConsigneeFax", consigneeAsShippingLineForm.getTelp());
                parameters.put("ConsigneeAddress1", consigneeAsShippingLineForm.getAddress1());
                parameters.put("ConsigneeAddress2", consigneeAsShippingLineForm.getAddress2() + " " +
                        consigneeAsShippingLineForm.getPostalCode() + " " +consigneeAsShippingLineForm.getCity() + " "+consigneeAsShippingLineForm.getRegion());
           }
        }
        
        
        parameters.put("HBLNO", debitSODetail.getTermHBL());
        parameters.put("VESSEL", debitSODetail.getFeederVessel());
        parameters.put("JobNo", debitSODetail.getJobNo());        
        parameters.put("Destination", destinationForm.getName());        
        parameters.put("JobDesc", "Sea Export".toUpperCase());
        parameters.put("Weight", debitSODetail.getQtyDesc() + " / " + debitSODetail.getWeightDesc());
        parameters.put("Volume", debitSODetail.getVolumeDesc());
        parameters.put("Commodity", debitSODetail.getCommodity());
        
        try {
            parameters.put("dueDate", FORMAT.format(debitSODetail.getDueDate()));
        } catch (Exception e) {
            
        }
        try {
            parameters.put("debitDate", FORMAT.format(debitSODetail.getDebitDate()));
        } catch (Exception e) {            
        }  
        
        parameters = countTotal(parameters);          
        
        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new DebitAIDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return null;         
       
   }
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][7];          
                
        try {            
            for (int i = 0; i < list.size(); i++) {                
                BillingagentDetail ba = (BillingagentDetail)list.get(i);
                valueOfTable[i][0] = String.valueOf(ba.getDescriptionFee());
                valueOfTable[i][1] = ba.getDescriptionInvoice();
                
                if (ba.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][2] = new Double(0.0);
                    valueOfTable[i][3] = ba.getCharge();
                    totalBillingIDR=totalBillingIDR+ba.getCharge().doubleValue();
                } else {
                    valueOfTable[i][2] = ba.getCharge();
                    valueOfTable[i][3] = new Double(0.0);
                    totalBillingUSD=totalBillingUSD+ba.getCharge().doubleValue();
                }                                                      
                
                if (ba.getIsTax().intValue()>0) {
                    totalTax+=ba.getCharge().doubleValue();
                }
                if (ba.getIsTax2().intValue()>0) {
                    totalTax2+=ba.getCharge().doubleValue();
                }
                if (ba.getIsVat().intValue()>0) {
                    totalPPH+=ba.getCharge().doubleValue();
                }    
                
                valueOfTable[i][4] = ba.getDescriptionFee();
                valueOfTable[i][5] = ba.getCategory();
            }
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;  
    }     
}
