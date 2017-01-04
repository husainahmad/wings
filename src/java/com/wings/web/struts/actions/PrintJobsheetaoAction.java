package com.wings.web.struts.actions;

import com.wings.persistence.BillingagentDetail;
import com.wings.persistence.BillingshipperDetail;
import com.wings.persistence.DetailJobsheet;
import com.wings.persistence.ExpensesagentDetail;
import com.wings.persistence.ExpensesshipperDetail;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.reports.datasource.JobsheetDetailDataSource;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.DebitForm;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaoDetailForm;
import com.wings.web.struts.forms.JobsheetaoForm;
import com.wings.web.struts.forms.KursdollarForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransporterForm;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
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
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;
import org.josql.Query;
import org.josql.QueryResults;


public final class PrintJobsheetaoAction extends Action {
   DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy"); 
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private double totalBillingIDR = 0.0;
   private double totalBillingUSD = 0.0;
   private double totalExpensesIDR = 0.0;
   private double totalExpensesUSD = 0.0;
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
          
    totalBillingIDR = 0.0;
    totalBillingUSD = 0.0;
    totalExpensesIDR = 0.0;
    totalExpensesUSD = 0.0; 
    
       ServletContext context = this.getServlet().getServletConfig().getServletContext();       
       JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();
       
       try {
         
         RequestUtils.populate(jobsheetaoDetailForm, request);
         
         JobsheetKey jobsheetKey = new JobsheetKey();
         jobsheetKey.setIdJobSheet(jobsheetaoDetailForm.getIdJobSheet());
         
         // check for double jobno
         JobsheetForm jobsheetForm = new JobsheetForm();
         jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
         jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
         
         Jobsheet jobsheet = new Jobsheet();
         jobsheet.setJobNo(jobsheetForm.getJobNo());
         
         List jobList = com.wings.adapter.StrutsJobsheetDelegate.selectJobsheetByJobNo(jobsheet);
         
         if (jobList.size()>1) {
             executeAOReportDouble(request, context, jobsheetKey, jobsheetForm, jobList);
         } else {
             executeAOReport(request, context, jobsheetKey);
         }                  
         
         return mapping.findForward("print");  
      } catch (Exception e) {
         ActionErrors errors = new ActionErrors();
         errors.add("errors", new ActionError("err.message","Error while printing data, "+e.getMessage()));
         saveErrors(request, errors);   
         return mapping.findForward("err");
      }
     
   }
   
   private void executeAOReportDouble(HttpServletRequest request, 
            ServletContext context, JobsheetKey jobsheetKey, JobsheetForm jobsheetForm, List jobList) throws Exception {
       
        InvoiceForm invoiceForm = new InvoiceForm();
        ConsigneeForm consigneeForm = new ConsigneeForm();
        AgentForm agentForm = new AgentForm();
        ShipperForm shipperForm = new ShipperForm();
        TransporterForm transporterForm = new TransporterForm();
        JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
        JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();
        DebitForm debitForm = new DebitForm();
        
        for (int i=0; i<jobList.size();i++) {
            Jobsheet jobsheet = (Jobsheet)jobList.get(i);
            
            invoiceForm.setIdJobSheet(jobsheet.getIdJobSheet());       
            try {
                 invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.editByJobsheet(invoiceForm);
            } catch (Exception e) {            
            }

            consigneeForm.setIdConsignee(jobsheet.getIdConsignee());
        
            try {
                consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
            } catch (Exception e) {            
            }                

            ConsigneeForm consigneeAsAgent = new ConsigneeForm();
            consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
            agentForm.setIdAgent(jobsheet.getIdAgent());
            try {
                consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
                agentForm.setName(consigneeAsAgent.getName());
                agentForm.setIdAgent(consigneeAsAgent.getIdConsignee());
                agentForm.setAddress1(consigneeAsAgent.getAddress1());
                agentForm.setAddress2(consigneeAsAgent.getAddress2());
                agentForm.setTelp(consigneeAsAgent.getTelp());
                agentForm.setFax(consigneeAsAgent.getFax());

                //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm);
            } catch (Exception e) {
            }

              
          ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
          consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
          shipperForm.setIdShipper(jobsheetForm.getIdShipper());
          try {
              consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
              shipperForm.setName(consigneeAsShipperForm.getName());
              shipperForm.setIdShipper(consigneeAsShipperForm.getIdConsignee());
              shipperForm.setAddress1(consigneeAsShipperForm.getAddress1());
              shipperForm.setAddress2(consigneeAsShipperForm.getAddress2());
              shipperForm.setTelp(consigneeAsShipperForm.getTelp());
              shipperForm.setFax(consigneeAsShipperForm.getFax());
              
          } catch (Exception e) {
          }   

            transporterForm.setIdTransporter(jobsheet.getIdTransporter());
            try {
                transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
            } catch (Exception e) {            
            }

            
            jobsheetaoForm.setIdJobSheet(jobsheet.getIdJobSheet());
			try 
			{
				jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
				BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetaoForm);
			} 
			catch (Exception e) 
			{            
			}
            
            debitForm.setIdJobSheet(jobsheet.getIdJobSheet());
            try {
                debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
            } catch (Exception e) {            
            }
            
            if (i==0) {
                  jobsheetForm.setIdJobSheet(jobsheet.getIdJobSheet());
                  jobsheetForm.setIdAgent(jobsheet.getIdAgent());
                  jobsheetForm.setIdConsignee(jobsheet.getIdConsignee());
                  jobsheetForm.setIdJobType(jobsheet.getIdJobType());
                  jobsheetForm.setIdShipper(jobsheet.getIdShipper());
                  if (invoiceForm.getInvoiceNumber()!=null) {
                      jobsheetForm.setInvoiceNoUsd(invoiceForm.getInvoiceNumber());  
                  } else {
                      jobsheetForm.setInvoiceNoUsd("");
                  }
                  
                  if (debitForm.getDebitNumber()!=null) {
                     jobsheetForm.setDebitNo(debitForm.getDebitNumber()); 
                  } else {
                      jobsheetForm.setDebitNo("");
                  }                  
                  jobsheetForm.setInvoiceStatus(jobsheet.getInvoiceStatus());
                  jobsheetForm.setJobNo(jobsheet.getJobNo());
                  jobsheetForm.setQty(jobsheet.getQty());
                  jobsheetForm.setQtyDesc(jobsheet.getQtyDesc());
                  jobsheetForm.setRemark(jobsheet.getRemark());

                  jobsheetForm.setShippeddateAsString(formatDate.format(jobsheet.getShippeddate()));
                  jobsheetForm.setTotalBillingIDR(jobsheet.getTotalBillingIDR());
                  jobsheetForm.setTotalExpensesIDR(jobsheet.getTotalExpensesIDR());
                  jobsheetForm.setTotalBillingUSD(jobsheet.getTotalBillingUSD());
                  jobsheetForm.setTotalExpensesUSD(jobsheet.getTotalExpensesUSD());
                  jobsheetForm.setVolume(jobsheet.getVolume());
                  jobsheetForm.setVolumeDesc(jobsheet.getVolumeDesc());
                  jobsheetForm.setWeight(jobsheet.getWeight());
                  jobsheetForm.setWeightDesc(jobsheet.getWeightDesc());
                  jobsheetForm.setIdTransporter(jobsheet.getIdTransporter());
                  jobsheetForm.setTransportCost(jobsheet.getTransportCost());
                  jobsheetForm.setRefundIDR(jobsheet.getRefundIDR());
                  jobsheetForm.setRefundUSD(jobsheet.getRefundUSD());
                  jobsheetForm.setCnNo(jobsheet.getCnNo());      
                  jobsheetForm.setDepart(jobsheet.getDepart());
                  jobsheetForm.setCnKurs(jobsheet.getCnKurs());                  
                  jobsheetForm.setCmb(jobsheet.getCmb());      
                  jobsheetForm.setCreditNoteIDR(jobsheet.getCreditNoteIDR());                  
                  jobsheetForm.setCreditNoteUSD(jobsheet.getCreditNoteUSD());                  
                  
              } else {
                  if (invoiceForm.getInvoiceNumber()!=null) {
                      if (invoiceForm.getInvoiceNumber()!=jobsheetForm.getInvoiceNoUsd()) {
                         jobsheetForm.setInvoiceNoUsd(jobsheetForm.getInvoiceNoUsd()+"," +invoiceForm.getInvoiceNumber().substring(4,10)); 
                      }                      
                  } 
                  
                  if (debitForm.getDebitNumber()!=null) {
                     if (debitForm.getDebitNumber()!=jobsheetForm.getDebitNo()) {
                        jobsheetForm.setDebitNo(jobsheetForm.getDebitNo()+","+debitForm.getDebitNumber().substring(3,8));                  
                     }                     
                  }                   
                  
                  if (jobsheet.getRefundIDR()!=null) {
                      jobsheetForm.setRefundIDR(new Double(jobsheetForm.getRefundIDR().doubleValue()+jobsheet.getRefundIDR().doubleValue()));
                  }
                  if (jobsheet.getRefundUSD()!=null) {
                      jobsheetForm.setRefundUSD(new Double(jobsheetForm.getRefundUSD().doubleValue()+jobsheet.getRefundUSD().doubleValue()));
                  }
                  if (jobsheet.getCreditNoteIDR()!=null) {
                      jobsheetForm.setCreditNoteIDR(new Double(jobsheetForm.getCreditNoteIDR().doubleValue()+jobsheet.getCreditNoteIDR().doubleValue()));
                  }
                  
                  if (jobsheet.getCreditNoteUSD()!=null) {
                      jobsheetForm.setCreditNoteUSD(new Double(jobsheetForm.getCreditNoteUSD().doubleValue()+jobsheet.getCreditNoteUSD().doubleValue()));
                  }

                  if (jobsheet.getDepart()!=null) {
                      jobsheetForm.setDepart(new Double(jobsheetForm.getDepart().doubleValue()+jobsheet.getDepart().doubleValue()));
                  }
                  if (jobsheet.getCmb()!=null) {
                      if (jobsheet.getCmb().equalsIgnoreCase("")) {
                          jobsheetForm.setCmb(jobsheet.getCmb());
                      }
                  }
              }
        } // end for
        
        // load detail biaya       
        Jobsheet jobsheet = new Jobsheet();
        jobsheet.setJobNo(jobsheetForm.getJobNo());
        
        List biayaList = com.wings.adapter.StrutsJobsheetDelegate.selectDetailJobsheetByJobNo(jobsheet);
        Object[][] dtReport = this.parseListToArrayDetailBiaya(biayaList, jobsheetForm);

        JasperCompileManager.compileReportToFile(context.getRealPath("/jobsheet/JobsheetAONew.jrxml"));
        String reportFileName = context.getRealPath("/jobsheet/JobsheetAONew.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();            
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("JobNo", jobsheetForm.getJobNo());
        parameters.put("InvoiceNo", jobsheetForm.getInvoiceNoUsd());
        parameters.put("DebitNo", jobsheetForm.getDebitNo());
        parameters.put("cnNo", jobsheetForm.getCnNo());
        parameters.put("DCNNo", jobsheetForm.getDebitNo());
        parameters.put("Shipper", shipperForm.getName());
        parameters.put("Consignee", consigneeForm.getName());
        parameters.put("Agents", agentForm.getName());
        parameters.put("Destination", jobsheetaoDetailForm.getDestination());
        parameters.put("Flight", jobsheetaoDetailForm.getFlights());
        parameters.put("CntFlight", jobsheetaoDetailForm.getCntFlight());
        parameters.put("FreightTerm", jobsheetaoDetailForm.getFreightTerm());
        parameters.put("BookingTo", jobsheetaoDetailForm.getBookingTo());
        parameters.put("RefundIDR", jobsheetForm.getRefundIDR());
        parameters.put("RefundUSD", jobsheetForm.getRefundUSD());
        parameters.put("Remark", jobsheetForm.getRemark());
        parameters.put("OperationStaff", jobsheetaoDetailForm.getOperationStaff());
        parameters.put("PICColoadeer", jobsheetaoDetailForm.getPicColoader());
        parameters.put("MAWB", jobsheetaoDetailForm.getMawb());
        parameters.put("HAWB", jobsheetaoDetailForm.getHawb());
        parameters.put("Qty", jobsheetForm.getQtyDesc());
        parameters.put("Weight", jobsheetForm.getWeightDesc());
        parameters.put("Volume", jobsheetForm.getVolumeDesc());
        parameters.put("Dimention", jobsheetaoDetailForm.getDimention());
        parameters.put("Commodity", jobsheetaoDetailForm.getCommodity());
        parameters.put("PickUpCargo", jobsheetaoDetailForm.getPickupCargo());
        parameters.put("TransportTo", transporterForm.getName());
        parameters.put("TransportCost", jobsheetForm.getTransportCost());
        parameters.put("totalBillingIDR", new Double(totalBillingIDR));
        parameters.put("totalBillingUSD", new Double(totalBillingUSD));
        parameters.put("totalExpensesIDR", new Double(totalExpensesIDR));
        parameters.put("totalExpensesUSD", new Double(totalExpensesUSD));
        parameters.put("cmb", jobsheetForm.getCmb());
        parameters.put("cnIDR", jobsheetForm.getCreditNoteIDR());
        parameters.put("cnUSD", jobsheetForm.getCreditNoteUSD());
                
        parameters.put("vatIDR", new Double(jobsheetForm.getVatIDR() == null ? 0.0 : jobsheetForm.getVatIDR().doubleValue()));
        parameters.put("pphIDR", new Double(jobsheetForm.getPphIDR() == null ? 0.0 : jobsheetForm.getPphIDR().doubleValue()));
        
        parameters.put("vatUSD", new Double(jobsheetForm.getVatUSD() == null ? 0.0 : jobsheetForm.getVatUSD().doubleValue()));
        parameters.put("pphUSD", new Double(jobsheetForm.getPphUSD() == null ? 0.0 : jobsheetForm.getPphUSD().doubleValue()));        
        
        parameters.put("dppIDR", new Double(jobsheetForm.getDppIDR() == null ? 0.0 : jobsheetForm.getDppIDR().doubleValue()));
        parameters.put("dppUSD", new Double(jobsheetForm.getDppUSD() == null ? 0.0 : jobsheetForm.getDppUSD().doubleValue()));        
        
        parameters.put("dppIDR2", new Double(jobsheetForm.getDppIDR2()== null ? 0.0 : jobsheetForm.getDppIDR2().doubleValue()));
        parameters.put("vatIDR2", new Double(jobsheetForm.getVatIDR2() == null ? 0.0 : jobsheetForm.getVatIDR2().doubleValue()));    
        
        try {
            double refundIDR = 0.0;
            double refundUSD = 0.0;
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            parameters.put("refundIDR", new Double(jobsheetForm.getRefundIDR().doubleValue())); 
            parameters.put("refundUSD", new Double(jobsheetForm.getRefundUSD().doubleValue()));             
            parameters.put("cnIDR", new Double(jobsheetForm.getCreditNoteIDR().doubleValue())); 
            parameters.put("cnUSD",  new Double(jobsheetForm.getCreditNoteUSD().doubleValue())); 
          
        } catch (Exception e) {
            
        }    
        try {
            parameters.put("Date", FORMAT.format(jobsheetForm.getShippeddate()));
        } catch (Exception e) {
            
        }
        
        String perDistrict = null;                   

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new JobsheetDetailDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return;         
       
   }
   
   
   private void executeAOReport(HttpServletRequest request, 
            ServletContext context, JobsheetKey jobsheetKey) throws Exception {
        
        JobsheetForm jobsheetForm = new JobsheetForm();
        jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
        
        jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);        
        
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
            agentForm.setName(consigneeAsAgent.getName());
            agentForm.setIdAgent(consigneeAsAgent.getIdConsignee());
            agentForm.setAddress1(consigneeAsAgent.getAddress1());
            agentForm.setAddress2(consigneeAsAgent.getAddress2());
            agentForm.setTelp(consigneeAsAgent.getTelp());
            agentForm.setFax(consigneeAsAgent.getFax());

        //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm);
        } catch (Exception e) {
        }
        
        ShipperForm shipperForm = new ShipperForm();          
        ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
        consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
        shipperForm.setIdShipper(jobsheetForm.getIdShipper());
        try {
            consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
            shipperForm.setName(consigneeAsShipperForm.getName());
            shipperForm.setIdShipper(consigneeAsShipperForm.getIdConsignee());
            shipperForm.setAddress1(consigneeAsShipperForm.getAddress1());
            shipperForm.setAddress2(consigneeAsShipperForm.getAddress2());
            shipperForm.setTelp(consigneeAsShipperForm.getTelp());
            shipperForm.setFax(consigneeAsShipperForm.getFax());

        } catch (Exception e) {
        }
          
        TransporterForm transporterForm = new TransporterForm();
        transporterForm.setIdTransporter(jobsheetForm.getIdTransporter());
        try {
            transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
        } catch (Exception e) {            
        }
                
        JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
        BeanUtils.copyProperties(jobsheetaoForm, jobsheetForm);
        
        JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();
        
        jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
        BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetaoForm);
                  
        DebitForm debitForm = new DebitForm();
        debitForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
        try {
            debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
        } catch (Exception e) {            
        }
        
        // load detail biaya
        
        List biayaList = com.wings.adapter.StrutsJobsheetDelegate.selectDetailJobsheet(jobsheetKey);
        Object[][] dtReport = this.parseListToArrayDetailBiaya(biayaList, jobsheetForm);

        JasperCompileManager.compileReportToFile(context.getRealPath("/jobsheet/JobsheetAONew.jrxml"));
        String reportFileName = context.getRealPath("/jobsheet/JobsheetAONew.jasper");
        File reportFile = new File(reportFileName);
        if (!reportFile.exists())
                throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

        Map parameters = new HashMap();            
        parameters.put("BaseDir", reportFile.getParentFile());          
        parameters.put("JobNo", jobsheetForm.getJobNo());
        parameters.put("InvoiceNo", jobsheetForm.getInvoiceNoUsd());
        parameters.put("DebitNo", debitForm.getDebitNumber());
        parameters.put("cnNo", jobsheetForm.getCnNo());
        parameters.put("DCNNo", jobsheetForm.getDebitNo());
        parameters.put("Shipper", shipperForm.getName());
        parameters.put("Consignee", consigneeForm.getName());
        parameters.put("Agents", agentForm.getName());
        parameters.put("Destination", jobsheetaoDetailForm.getDestination());
        parameters.put("Flight", jobsheetaoDetailForm.getFlights());
        parameters.put("CntFlight", jobsheetaoDetailForm.getCntFlight());
        parameters.put("FreightTerm", jobsheetaoDetailForm.getFreightTerm());
        parameters.put("BookingTo", jobsheetaoDetailForm.getBookingTo());
        parameters.put("RefundIDR", jobsheetForm.getRefundIDR());
        parameters.put("RefundUSD", jobsheetForm.getRefundUSD());
        parameters.put("Remark", jobsheetForm.getRemark());
        parameters.put("OperationStaff", jobsheetaoDetailForm.getOperationStaff());
        parameters.put("PICColoadeer", jobsheetaoDetailForm.getPicColoader());
        parameters.put("MAWB", jobsheetaoDetailForm.getMawb());
        parameters.put("HAWB", jobsheetaoDetailForm.getHawb());
        parameters.put("Qty", jobsheetForm.getQtyDesc());
        parameters.put("Weight", jobsheetForm.getWeightDesc());
        parameters.put("Volume", jobsheetForm.getVolumeDesc());
        parameters.put("Dimention", jobsheetaoDetailForm.getDimention());
        parameters.put("Commodity", jobsheetaoDetailForm.getCommodity());
        parameters.put("PickUpCargo", jobsheetaoDetailForm.getPickupCargo());
        parameters.put("TransportTo", transporterForm.getName());
        parameters.put("TransportCost", jobsheetForm.getTransportCost());
        parameters.put("totalBillingIDR", new Double(totalBillingIDR));
        parameters.put("totalBillingUSD", new Double(totalBillingUSD));
        parameters.put("totalExpensesIDR", new Double(totalExpensesIDR));
        parameters.put("totalExpensesUSD", new Double(totalExpensesUSD));
        parameters.put("cmb", jobsheetForm.getCmb());
        
        parameters.put("vatIDR", new Double(jobsheetForm.getVatIDR().doubleValue()));
        parameters.put("pphIDR", new Double(jobsheetForm.getPphIDR().doubleValue()));
        
        parameters.put("vatUSD", new Double(jobsheetForm.getVatUSD().doubleValue()));
        parameters.put("pphUSD", new Double(jobsheetForm.getPphUSD().doubleValue()));        
        
        parameters.put("dppIDR", new Double(jobsheetForm.getDppIDR().doubleValue()));
        parameters.put("dppUSD", new Double(jobsheetForm.getDppUSD().doubleValue()));  
        
        try {
            double refundIDR = 0.0;
            double refundUSD = 0.0;
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            parameters.put("refundIDR", new Double(jobsheetForm.getRefundIDR().doubleValue())); 
            parameters.put("refundUSD", new Double(jobsheetForm.getRefundUSD().doubleValue())); 
            
            double cnIDR = 0.0;
            double cnUSD = 0.0;        
            parameters.put("cnIDR", new Double(jobsheetForm.getCreditNoteIDR().doubleValue())); 
            parameters.put("cnUSD",  new Double(jobsheetForm.getCreditNoteUSD().doubleValue())); 
                    
           
        } catch (Exception e) {
            
        }    
        try {
            parameters.put("Date", FORMAT.format(jobsheetForm.getShippeddate()));
        } catch (Exception e) {
            
        }
        
        String perDistrict = null;                   

        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(
                        reportFileName, 
                        parameters, 
                        new JobsheetDetailDataSource(dtReport)
                        );

        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
        return;         
       
   }
   
   private Object[][] parseListToArray(List list, List billShipperList, List expensesShipperList, List expensesAgentList) {        
        int objSize = list.size() + billShipperList.size() + expensesShipperList.size() + expensesAgentList.size();
        
        Object[][] valueOfTable = new Object[objSize][7];          
                
        try {       
            int i = 0;
            for (i = 0; i < list.size(); i++) {                
                BillingagentDetail bs = (BillingagentDetail)list.get(i);
                valueOfTable[i][0] = "Selling Debit Note";
                
                valueOfTable[i][1] = bs.getDescriptionFee();
                
                if (bs.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][3] = new Double(0.0);
                    valueOfTable[i][2] = bs.getCharge();
                    totalBillingIDR=totalBillingIDR+bs.getCharge().doubleValue();
                } else {
                    valueOfTable[i][3] = bs.getCharge();
                    valueOfTable[i][2] = new Double(0.0);
                    totalBillingUSD=totalBillingUSD+bs.getCharge().doubleValue();
                }                       
                valueOfTable[i][4] = bs.getDescription();
            }
            
            for (int j = 0; j < billShipperList.size(); j++) {    
                
                BillingshipperDetail bs = (BillingshipperDetail)billShipperList.get(j);
                valueOfTable[i][0] = "Selling Invoice";
                
                valueOfTable[i][1] = bs.getDescriptionFee();
                
                if (bs.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][3] = new Double(0.0);
                    valueOfTable[i][2] = bs.getCharge();
                    totalBillingIDR=totalBillingIDR+bs.getCharge().doubleValue();
                } else {
                    valueOfTable[i][3] = bs.getCharge();
                    valueOfTable[i][2] = new Double(0.0);
                    totalBillingUSD=totalBillingUSD+bs.getCharge().doubleValue();
                }                       
                valueOfTable[i][4] = bs.getDescription();
                i++;
            }
            
            for (int k = 0; k < expensesAgentList.size(); k++) { 
                
                ExpensesagentDetail bs = (ExpensesagentDetail)expensesAgentList.get(k);
                valueOfTable[i][0] = "Cost Debit Note";
                
                valueOfTable[i][1] = bs.getDescriptionFee();
                
                if (bs.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][3] = new Double(0.0);
                    valueOfTable[i][2] = bs.getCharge();
                    totalExpensesIDR=totalExpensesIDR+bs.getCharge().doubleValue();
                } else {
                    valueOfTable[i][3] = bs.getCharge();
                    valueOfTable[i][2] = new Double(0.0);
                    totalExpensesUSD=totalExpensesUSD+bs.getCharge().doubleValue();
                }                       
                valueOfTable[i][4] = bs.getDescription();
                i++;
            }
            
            for (int l = 0; l < expensesShipperList.size(); l++) {        
               
                ExpensesshipperDetail bs = (ExpensesshipperDetail)expensesShipperList.get(l);
                valueOfTable[i][0] = "Cost Invoice";
                
                valueOfTable[i][1] = bs.getDescriptionFee();
                
                if (bs.getKurs().equalsIgnoreCase("IDR")) {
                    valueOfTable[i][3] = new Double(0.0);
                    valueOfTable[i][2] = bs.getCharge();
                    totalExpensesIDR=totalExpensesIDR+bs.getCharge().doubleValue();
                } else {
                    valueOfTable[i][3] = bs.getCharge();
                    valueOfTable[i][2] = new Double(0.0);
                    totalExpensesUSD=totalExpensesUSD+bs.getCharge().doubleValue();
                }                       
                valueOfTable[i][4] = bs.getDescription();
                 i++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return valueOfTable;  
    }   
   
   private Object[][] parseListToArrayDetailBiaya(List list, JobsheetForm jobsheetForm) throws Exception {        
       List billAgentList = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobNo(jobsheetForm);
        List billShipperList = com.wings.adapter.StrutsBillingshipperDelegate.selectByJobNo(jobsheetForm);
        List expensesShipperList = com.wings.adapter.StrutsExpensesshipperDelegate.selectByJobNo(jobsheetForm);
        List expensesAgentList = com.wings.adapter.StrutsExpensesagentDelegate.selectByJobNo(jobsheetForm);
        
        int objSize = list.size();
        
        try {
            Query q = new Query ();            
            String[] remark = null;
                               
            q.parse("select * from com.wings.persistence.DetailJobsheet order by description");
            QueryResults qr2 = q.execute (list);            
            List qrList = qr2.getResults();           
            list = qrList;
        } catch (Exception e) {
        }
                
        List newList = new ArrayList();
        List comList = new ArrayList();
        comList = list;
        double billingIDR = 0.0;
        double billingUSD = 0.0;
        double expensesIDR = 0.0;
        double expensesUSD = 0.0;
        
        try {
            for (int i=0; i<list.size();i++) {
                billingIDR = 0.0;
                billingUSD = 0.0;
                expensesIDR = 0.0;
                expensesUSD = 0.0;
                DetailJobsheet dj = (DetailJobsheet)list.get(i);                
                billingIDR+=dj.getBillingIDR().doubleValue();
                expensesIDR+=dj.getExpensesIDR().doubleValue();
                billingUSD+=dj.getBillingUSD().doubleValue();
                expensesUSD+=dj.getExpensesUSD().doubleValue();                
                for (int j=i+1;j<list.size();j++) {
                    DetailJobsheet dj2 = (DetailJobsheet)list.get(j);
                    if (dj2.getDescription().replaceAll(" ","").equalsIgnoreCase(dj.getDescription().replaceAll(" ",""))) {
                        billingIDR+=dj2.getBillingIDR().doubleValue();
                        expensesIDR+=dj2.getExpensesIDR().doubleValue();
                        billingUSD+=dj2.getBillingUSD().doubleValue();
                        expensesUSD+=dj2.getExpensesUSD().doubleValue();                
                        dj.setBillingIDR(new Double(billingIDR));
                        dj.setExpensesIDR(new Double(expensesIDR));
                        dj.setBillingUSD(new Double(billingUSD));
                        dj.setExpensesUSD(new Double(expensesUSD));                                                
                        dj.setDescription2(dj.getDescription2()+" "+dj2.getDescription2()+" ");
                        dj.setDescription3(dj.getDescription3()+" "+dj2.getDescription3()+" ");
                        i=j;
                        //comList.remove(j);
                    }
                }
                newList.add(dj);
            }            
        } catch (Exception e) {            
        }
        
        List againList = new ArrayList();
        
        DetailJobsheet dj = null;
        BillingagentDetail ba = null;
        
        for (int i=0; i<billAgentList.size(); i++) {
            ba = (BillingagentDetail)billAgentList.get(i);
            for (int j=0; j<newList.size(); j++) {
                dj = (DetailJobsheet)newList.get(j);
                if (ba.getDescriptionFee().equalsIgnoreCase(dj.getDescription())) {
                    againList.add(dj);
                    newList.remove(j);
                    j=0;
                }
            }
        }
        
        BillingshipperDetail bs = null;
        for (int i=0; i<billShipperList.size(); i++) {
            bs = (BillingshipperDetail)billShipperList.get(i);
            for (int j=0; j<newList.size(); j++) {
                dj = (DetailJobsheet)newList.get(j);
                if (bs.getDescriptionFee().equalsIgnoreCase(dj.getDescription())) {
                    againList.add(dj);
                    newList.remove(j);
                    j=0;
                }
            }
        }
        
        ExpensesagentDetail ea = null;
        DetailJobsheet dj2 = null;
        for (int i=0; i<expensesAgentList.size();i++) {
            ea = (ExpensesagentDetail)expensesAgentList.get(i);
            for (int j=0; j<newList.size(); j++) {
                dj = (DetailJobsheet)newList.get(j);                                
                if (ea.getDescriptionFee().equalsIgnoreCase(dj.getDescription())) {
                    againList.add(dj);
                    newList.remove(j);
                    j=0;             
                }
            }
        }
        
        
        ExpensesshipperDetail es = null;        
        for (int i=0; i<expensesShipperList.size();i++) {
            es = (ExpensesshipperDetail)expensesShipperList.get(i);
            for (int j=0; j<newList.size(); j++) {
                dj = (DetailJobsheet)newList.get(j);                
                if (es.getDescriptionFee().equalsIgnoreCase(dj.getDescription())) {
                    againList.add(dj);
                    newList.remove(j);
                    j=0;                                       
                }
            }
        }
        
        Object[][] valueOfTable = new Object[againList.size()][7];                
                
        try {       
            int i = 0;
            for (i = 0; i < againList.size(); i++) {                
                dj = (DetailJobsheet)againList.get(i);
                valueOfTable[i][0] = dj.getDescription();
                totalBillingIDR+=dj.getBillingIDR().doubleValue();
                totalBillingUSD+=dj.getBillingUSD().doubleValue();
                valueOfTable[i][1] = dj.getBillingIDR();
                valueOfTable[i][2] = dj.getBillingUSD();
                valueOfTable[i][3] = dj.getExpensesIDR();
                valueOfTable[i][4] = dj.getExpensesUSD();                                
                valueOfTable[i][5] = dj.getDescription3();
                valueOfTable[i][6] = dj.getDescription2();
            }            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return valueOfTable;  
   }      
}
