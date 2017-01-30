package com.wings.web.struts.actions;

import com.wings.persistence.BillingagentDetail;
import com.wings.persistence.BillingshipperDetail;
import com.wings.persistence.JobsheetKey;
import com.wings.reports.datasource.TaxDataSource;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TaxForm;
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
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintTaxAction extends Action {
    
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
            TaxForm taxForm = new TaxForm();
            RequestUtils.populate(taxForm, request);
            
            TaxForm taxFormNew = com.wings.adapter.StrutsTaxDelegate.edit(taxForm);         
            
            JobsheetForm jobsheetForm = new JobsheetForm();
            jobsheetForm.setIdJobSheet(Integer.valueOf(taxFormNew.getIdJobSheet()));            
            jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
            
            JobsheetKey jobsheetKey = new JobsheetKey();
            jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
            
            InvoiceForm invoiceForm = new InvoiceForm();
            invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.editByJobsheet(invoiceForm);
            
            List billingShipperList = com.wings.adapter.StrutsBillingshipperDelegate.selectTaxByIdJobSheet(jobsheetKey);
            
            Object[][] dtReport = this.parseListToArray(billingShipperList);

            JasperCompileManager.compileReportToFile(context.getRealPath("/tax/FakturPajak.jrxml"));
            String reportFileName = context.getRealPath("/tax/FakturPajak.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = this.setParameters(jobsheetForm);            
            parameters.put("BaseDir", reportFile.getParentFile());          
            parameters.put("noJob", invoiceForm.getInvoiceNumber());
            parameters.put("noFaktur", taxForm.getNoFaktur());
            parameters.put("invoiceDate", invoiceForm.getInvoiceDate());
            
            String perDistrict = null;                   

            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new TaxDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);    
            
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }               
   }
   
   private Map setParameters(JobsheetForm jobsheetForm) throws Exception {
        Map parameters = new HashMap();            
        if ((jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) || (jobsheetForm.getIdJobType().equalsIgnoreCase("AI"))) {
            ConsigneeForm consigneeForm = new ConsigneeForm();
            consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);                                  
            parameters.put("consigneeName", consigneeForm.getName());
            parameters.put("address1", consigneeForm.getAddress1());
            parameters.put("address2", consigneeForm.getAddress2());
            parameters.put("consigneeNPWP", consigneeForm.getNpwp());                       
            parameters.put("consigneePPKP", consigneeForm.getNpwp());               
        } else
        if ((jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) || (jobsheetForm.getIdJobType().equalsIgnoreCase("AO"))) {
            ShipperForm shipperForm = new ShipperForm();          
            ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
            consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
            shipperForm.setIdShipper(jobsheetForm.getIdShipper());
            try {
                consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
                BeanUtils.copyProperties(shipperForm, consigneeAsShipperForm);
            } catch (Exception e) {
            }    
            parameters.put("consigneeName", shipperForm.getName());
            parameters.put("address1", shipperForm.getAddress1());
            parameters.put("address2", shipperForm.getAddress2());
            parameters.put("consigneeNPWP", shipperForm.getNpwp());                       
            parameters.put("consigneePPKP", shipperForm.getNpwp());   
            
        }
        return parameters;                
   }
   
   private Object[][] parseListToArray(List secondList) {        
        
        Object[][] valueOfTable = new Object[secondList.size()][7];          
        int j = 0;    
        double totalTax = 0.0;
        try {                        
            for (int i=0; i < secondList.size(); i++) {     
                j++;
                BillingshipperDetail bs = (BillingshipperDetail)secondList.get(i);                                
                totalTax = totalTax + bs.getCharge().doubleValue();                
                
                valueOfTable[i][0] = j +"";
                valueOfTable[i][1] = bs.getDescriptionFee();
                valueOfTable[i][2] = new Double(bs.getCharge().doubleValue());              

            }            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return valueOfTable;  
    }     
}
