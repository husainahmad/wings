/*
 * PopulateInvoiceAndDebit.java
 *
 * Created on July 29, 2008, 7:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import com.wings.persistence.Invoice;
import com.wings.persistence.JobnumberKey;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DebitForm;
import com.wings.web.struts.forms.InvoiceForm;
import com.wings.web.struts.forms.JobsheetForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author Ahmad Husain
 */
public class PopulateInvoiceAndDebit {
    Logger log = Logger.getLogger(PopulateInvoiceAndDebit.class.getName());   
    /**
     * Creates a new instance of PopulateInvoiceAndDebit
     */
    public PopulateInvoiceAndDebit() {
    }
    
    public static void generateInvoiceAndDebit(HttpServletRequest request, JobsheetForm jobsheetForm,
                                                DateTime atddate, JobsheetKey jobsheetKey) throws Exception {
         boolean isKeyGenerate = false;
         
         JobnumberKey jobnumberKey = com.wings.adapter.StrutsJobnumberDelegate.selectMax();
         int asint = jobnumberKey.getIdJobNumber().intValue();
         asint++;
         jobnumberKey.setIdJobNumber(new Integer(asint));         
         
         String newKey = null;
         String strKey = "";                  
         
         if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
             strKey = "WGL/2";            
         } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
             strKey = "WGL/1";
         } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
             strKey = "WGL/3";
         } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
             strKey = "WGL/4";
         }
         
         // create invoice
         InvoiceForm invoiceForm = new InvoiceForm();
         invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
                           
         if (PopulateJobsheetDetail.checkInvoice(request)) {
             invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.editByJobsheet(invoiceForm);
             if (invoiceForm.getIdInvoice()==null) {
                 try {
                    invoiceForm.setInvoiceDate(new java.sql.Date(jobsheetForm.getShippeddate().getTime()));
                 } catch (Exception ex) {
                    invoiceForm.setInvoiceDate(new java.sql.Date((new java.util.Date()).getTime()));
                 }

                 isKeyGenerate = true;
                 List invoiceList = null;
                 if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                     invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberAI(invoiceForm);            
                     invoiceList = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberAIList(invoiceForm);
                     invoiceForm = getInvoiceNumber(invoiceList, invoiceForm);
                 } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                     invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberAO(invoiceForm);
                     invoiceList = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberAOList(invoiceForm);
                     invoiceForm = getInvoiceNumber(invoiceList, invoiceForm);
                 } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                     invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberSI(invoiceForm);
                     invoiceList = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberSIList(invoiceForm);
                     invoiceForm = getInvoiceNumber(invoiceList, invoiceForm);
                 } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                     invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberSO(invoiceForm);
                     invoiceList = com.wings.adapter.StrutsInvoiceDelegate.selectMaxInvoiceNumberSOList(invoiceForm);
                     invoiceForm = getInvoiceNumber(invoiceList, invoiceForm);
                 }
                 
                 String invnum = strKey + StringUtils.leftPad(invoiceForm.getInvoiceNumber(),5,"0") + "/" + StringUtils.leftPad(String.valueOf(atddate.getMonthOfYear()), 2, "0") + "/" + String.valueOf(atddate.getYear()).substring(2);            
		     invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
                 invoiceForm.setInvoiceNumber(invnum);
                 invoiceForm.setIsPayable("U");
                 invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.create(invoiceForm);            
                 jobsheetForm.setInvoiceNoUsd(invnum);
                 jobsheetForm.setInvoiceStatus("I");                                                          
                 jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.updateInvoiceNoAndStatus(jobsheetForm);
             } else {
		 try {
                    invoiceForm.setInvoiceDate(new java.sql.Date(jobsheetForm.getShippeddate().getTime()));
                 } catch (Exception ex) {
                    invoiceForm.setInvoiceDate(new java.sql.Date((new java.util.Date()).getTime()));
                 }
                 invoiceForm.setIsPayable("U");
                 com.wings.adapter.StrutsInvoiceDelegate.update(invoiceForm);
	     }             
         } else {
             com.wings.adapter.StrutsInvoiceDelegate.removeByIdJobsheet(jobsheetKey);
             jobsheetForm.setInvoiceNoUsd("");
             jobsheetForm.setInvoiceStatus("");                                                          
             jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.updateInvoiceNoAndStatus(jobsheetForm);
         }         
         
         // create debit
         DebitForm debitForm = new DebitForm();
         debitForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
                          
         if (PopulateJobsheetDetail.checkDebit(request)) {
            debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
            if (debitForm.getIdDebit()==null) {
                if (!isKeyGenerate) {
//                    jobnumberKey = com.wings.adapter.StrutsJobnumberDelegate.create(jobnumberKey);
//                    newKey = com.wings.adapter.StrutsJobnumberDelegate.selectNext();                    
                } 
                try {
                     debitForm.setDebitDate(new java.sql.Date(jobsheetForm.getShippeddate().getTime()));                     
                } catch (Exception ex) {
                     debitForm.setDebitDate(new java.sql.Date((new java.util.Date()).getTime()));
                }
                debitForm = com.wings.adapter.StrutsDebitDelegate.selectMaxDebitNumber(debitForm);
                String debnum = "DN/" + StringUtils.leftPad(debitForm.getDebitNumber(),5,"0") + "/" + StringUtils.leftPad(String.valueOf(atddate.getMonthOfYear()), 2, "0") + "/" + String.valueOf(atddate.getYear()).substring(2);
		    debitForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
                debitForm.setDebitNumber(debnum);
                debitForm.setIsPayable("U");
                debitForm = com.wings.adapter.StrutsDebitDelegate.create(debitForm);      
                jobsheetForm.setDebitNo(debnum);
                jobsheetForm.setDebitStatus("D");
                jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.updateDebitNoAndStatus(jobsheetForm); 
            } else {
		try {
                     debitForm.setDebitDate(new java.sql.Date(jobsheetForm.getShippeddate().getTime()));                     
                } catch (Exception ex) {
                     debitForm.setDebitDate(new java.sql.Date((new java.util.Date()).getTime()));
                }
                debitForm.setIsPayable("U");
                com.wings.adapter.StrutsDebitDelegate.update(debitForm);
            }            
         } else {
             com.wings.adapter.StrutsDebitDelegate.removeByIdJobsheet(jobsheetKey);
             jobsheetForm.setDebitNo("");
             jobsheetForm.setDebitStatus("");
             jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.updateDebitNoAndStatus(jobsheetForm);
         }
    }
    
    public static InvoiceForm getInvoiceNumber(List invoiceList, InvoiceForm invoiceForm) {
        Invoice invoice = null;
        int invo1, invo2;
        int lastIn = 0;
        try {
            invo1 = Integer.valueOf(invoiceForm.getInvoiceNumber()).intValue();
        } catch (Exception e) {
            invo1 = 0;
        }
        for (int i=1; i<invo1; i++) {
            try {
                invoice = (Invoice)invoiceList.get(i-1); 
                invo2 = Integer.valueOf(invoice.getInvoiceNumber()).intValue();
                if (invo2==i) {                        
                        // nothing to do
                } else {                    
                    invoiceForm.setInvoiceNumber(String.valueOf(i));
                    break;                    
                }
            } catch (Exception e) {                
            }
        }
        
        return invoiceForm;
    }
}
