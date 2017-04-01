package com.wings.web.struts.actions;

import com.wings.persistence.Debit;
import com.wings.persistence.Invoice;
import com.wings.persistence.Transactionacc;
import com.wings.web.struts.forms.PaymentForm;
import com.wings.web.struts.forms.TransactionaccForm;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class InsertPaymentAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      try {
         PaymentForm paymentForm = (PaymentForm)form;
         List paymentList = generatePayment(request);
         List jurnalList = generateJurnal(request);
         
         insertPayment(paymentList, jurnalList);
         
         request.setAttribute("payment", paymentForm);
         return mapping.findForward("view");
      } catch (Exception e) {
         getServlet().log("Create error", e);
         request.setAttribute("name", "Payment");
         return mapping.findForward("ejb-create-exception");
      }
   }
   
   public void insertPayment(List paymentList, List jurnalList) throws Exception {
       TransactionaccForm transactionaccForm = null;
       PaymentForm paymentForm = null;
       
       for (int i=0; i<paymentList.size();i++) {
           paymentForm = (PaymentForm)paymentList.get(i);
           transactionaccForm = (TransactionaccForm) jurnalList.get(i);
           try {
               paymentForm = com.wings.adapter.StrutsPaymentDelegate.create(paymentForm);
               transactionaccForm.setJobNo(paymentForm.getInvoiceNumber());
               com.wings.adapter.StrutsTransactionaccDelegate.removeByJobNo(transactionaccForm);               
           } catch (Exception e) {               
               System.out.println(e);
           }           
       }
       
       for (int i=0; i<paymentList.size();i++) {
           paymentForm = (PaymentForm)paymentList.get(i);
           transactionaccForm = (TransactionaccForm) jurnalList.get(i);
           try {
               paymentForm = com.wings.adapter.StrutsPaymentDelegate.create(paymentForm);
               if (paymentForm.getInvoiceNumber().substring(0,1).equalsIgnoreCase("D")) {
                    Debit debit = new Debit();
                    debit.setDebitNumber(paymentForm.getInvoiceNumber());                         
                    debit = com.wings.adapter.StrutsDebitDelegate.updatePayableStatusByDebitNumber(debit);
               } else {
                    Invoice invoice = new Invoice();
                    invoice.setInvoiceNumber(paymentForm.getInvoiceNumber());              
                    invoice = com.wings.adapter.StrutsInvoiceDelegate.updatePayableStatusByInvoiceNumber(invoice);
               }
               //kredit
               com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
               transactionaccForm.setIdAccount(paymentForm.getBank());
               transactionaccForm.setDebit(transactionaccForm.getKredit());
               transactionaccForm.setKredit(new Double(0.0));
               //debit               
               com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
           } catch (Exception e) {               
               System.out.println(e);
           }           
       }
   }
   public List generatePayment(HttpServletRequest request) {
       SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy"); 
       String hidRow = request.getParameter("hidRow");
       int ihidRow = 0;
       try {
           ihidRow = Integer.parseInt(hidRow);
       } catch (Exception e) {           
       }
       double decchargeUSD = 0.0;
       double decchargeIDR = 0.0;
       double decbillUSD = 0.0;
       double decbillIDR = 0.0;
       String accUSD = "accUSD";
       String accIDR = "accIDR";
       String chargeUSD = "chargeUSD";
       String chargeIDR = "chargeIDR";
       String billUSD = "billUSD";
       String billIDR = "billIDR";
       String kurs = "kurs";
       String bank = "bank";
       String idNumber = "idNumber";
       String name = "name";
       String datte = "datte";
       PaymentForm payment = null;
       List paymentList = new ArrayList();
       
       for (int i=1; i<=ihidRow; i++) {
            chargeUSD = "chargeUSD"+i;
            chargeIDR = "chargeIDR"+i;
            accUSD = "accUSD"+i;
            accIDR = "accIDR"+i;
            billUSD = "billUSD"+i;
            billIDR = "billIDR"+i;
            kurs = "kurs"+i;
            bank = "bank"+i;
            name = "name"+i;
            idNumber = "idNumber"+i;
            datte = "datte"+i;
            decchargeUSD = 0.0;
            decchargeIDR = 0.0;
            decbillUSD = 0.0;
            decbillIDR = 0.0;
            accUSD = request.getParameter(accUSD);
            accIDR = request.getParameter(accIDR);
            chargeUSD = request.getParameter(chargeUSD);
            chargeIDR = request.getParameter(chargeIDR);
            billUSD = request.getParameter(billUSD);
            billIDR = request.getParameter(billIDR);
            kurs = request.getParameter(kurs);
            bank = request.getParameter(bank);
            datte = request.getParameter(datte);
            idNumber = request.getParameter(idNumber);
            name = request.getParameter(name);
            payment = new PaymentForm();
            payment.setIdCostomer(name);
            payment.setBank(bank);
            payment.setInvoiceNumber(idNumber);                                 

            try {
                payment.setPaymentDate(new java.util.Date(FORMAT.parse(datte).getTime()));
            } catch (Exception e) {
                payment.setPaymentDate(new java.util.Date((new java.util.Date()).getTime()));
            }
            try {
                decchargeUSD = Double.parseDouble(chargeUSD.replaceAll(",",""));
            } catch (Exception e) {                
            }                        
            try {
                decchargeIDR = Double.parseDouble(chargeIDR.replaceAll(",",""));
            } catch (Exception e) {                
            }                  
            try {
                decbillUSD = Double.parseDouble(billUSD.replaceAll(",",""));
            } catch (Exception e) {                
            }                  
            try {
                decbillIDR = Double.parseDouble(billIDR.replaceAll(",",""));
            } catch (Exception e) {                
            }
            
            if (kurs!=null && kurs.equalsIgnoreCase("USD")) {
                if ((decbillUSD>=decchargeUSD) && (decbillUSD>0.0)) {
                    payment.setKurs(kurs);
                    payment.setAmount(new Double(decbillUSD));
                    paymentList.add(payment);
                }
            } else {
                if ((decbillIDR>=decchargeIDR) && (decbillIDR>0.0)) {
                    payment.setKurs(kurs);
                    payment.setAmount(new Double(decchargeIDR));
                    paymentList.add(payment);
                }
            }                                    
       }
       return paymentList;
   }
   
   public List generateJurnal(HttpServletRequest request) throws Exception {
       SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy"); 
       String hidRow = request.getParameter("hidRow");
       int ihidRow = 0;
       try {
           ihidRow = Integer.parseInt(hidRow);
       } catch (Exception e) {           
       }
       
       TransactionaccForm transactionaccForm = new TransactionaccForm();
      
              
       double decchargeUSD = 0.0;
       double decchargeIDR = 0.0;
       double decbillUSD = 0.0;
       double decbillIDR = 0.0;
       String accUSD = "accUSD";
       String accIDR = "accIDR";
       String chargeUSD = "chargeUSD";
       String chargeIDR = "chargeIDR";
       String billUSD = "billUSD";
       String billIDR = "billIDR";
       String kurs = "kurs";
       String kursvalue = "kursvalue";
       String bank = "bank";
       String idNumber = "idNumber";
       String name = "name";
       String datte = "datte";
       PaymentForm payment = null;
       List accList = new ArrayList();
       
       for (int i=1; i<=ihidRow; i++) {
            chargeUSD = "chargeUSD"+i;
            chargeIDR = "chargeIDR"+i;
            accUSD = "accUSD"+i;
            accIDR = "accIDR"+i;
            billUSD = "billUSD"+i;
            billIDR = "billIDR"+i;
            kurs = "kurs"+i;
            kursvalue = "kursvalue"+i;
            bank = "bank"+i;
            name = "name"+i;
            idNumber = "idNumber"+i;
            datte = "datte"+i;
            decchargeUSD = 0.0;
            decchargeIDR = 0.0;
            decbillUSD = 0.0;
            decbillIDR = 0.0;
            accUSD = request.getParameter(accUSD);
            accIDR = request.getParameter(accIDR);
            chargeUSD = request.getParameter(chargeUSD);
            chargeIDR = request.getParameter(chargeIDR);
            billUSD = request.getParameter(billUSD);
            billIDR = request.getParameter(billIDR);
            kurs = request.getParameter(kurs);
            kursvalue = request.getParameter(kursvalue);
            bank = request.getParameter(bank);
            datte = request.getParameter(datte);
            idNumber = request.getParameter(idNumber);
            name = request.getParameter(name);
            payment = new PaymentForm();
            payment.setIdCostomer(name);
            payment.setBank(bank);
            payment.setInvoiceNumber(idNumber);                                 

            java.sql.Date tutupBuku = null;
              
            try {
                 tutupBuku = new java.sql.Date(FORMAT.parse(datte).getTime());
            } catch (ParseException pe) {
                 tutupBuku = new java.sql.Date((new java.util.Date()).getTime());
            }
            if (kurs!=null && kurs.equalsIgnoreCase("USD")) {
                transactionaccForm.setIdAccount(accUSD);   
                try {
                    double dkurs = Double.parseDouble(kursvalue);                    
                    transactionaccForm.setKursValue(new Double(dkurs));   
                } catch (Exception e) {}                
                
            } else {
                transactionaccForm.setIdAccount(accIDR);   
                try {
                    double dkurs = Double.parseDouble(kursvalue);                    
                    transactionaccForm.setKursValue(new Double(dkurs));   
                } catch (Exception e) {}    
            }                
                            
            transactionaccForm.setTglTutupBuku(tutupBuku);             
            transactionaccForm.setNoBatch("009");
            Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);            
            transactionaccForm.setInUrut(inUrut);
            transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),3,"0"));      
            transactionaccForm.setJobNo(idNumber);      
            transactionaccForm.setKurs(kurs);
            
            try {
                transactionaccForm.setTglTutupBuku(new java.sql.Date(FORMAT.parse(datte).getTime()));
            } catch (Exception e) {
                transactionaccForm.setTglTutupBuku(new java.sql.Date((new java.util.Date()).getTime()));
            }
            
            try {
                transactionaccForm.setTransactionDate(new java.sql.Date(FORMAT.parse(datte).getTime()));
            } catch (Exception e) {
                transactionaccForm.setTransactionDate(new java.sql.Date((new java.util.Date()).getTime()));
            }
            
            
            try {
                decchargeUSD = Double.parseDouble(chargeUSD.replaceAll(",",""));
            } catch (Exception e) {                
            }                        
            try {
                decchargeIDR = Double.parseDouble(chargeIDR.replaceAll(",",""));
            } catch (Exception e) {                
            }                  
            try {
                decbillUSD = Double.parseDouble(billUSD.replaceAll(",",""));
                if (decbillUSD>0.0) {
                    transactionaccForm.setKredit(Double.valueOf(decbillUSD));
                }                
            } catch (Exception e) {                
            }                  
            try {
                decbillIDR = Double.parseDouble(billIDR.replaceAll(",",""));
                if (decbillIDR>0.0) {
                    transactionaccForm.setKredit(Double.valueOf(decbillIDR));
                }                
            } catch (Exception e) {                
            }
            if (kurs!=null && kurs.equalsIgnoreCase("USD")) {
                transactionaccForm.setDescription("Payment " + name + " (" + idNumber + ")" + " $ " + billUSD);                  
            } else {
                transactionaccForm.setDescription("Payment " + name + " (" + idNumber + ")" + " IDR " + billIDR);                  
            }
            transactionaccForm.setNoVoucher("10067");
            transactionaccForm.setVoucherDesc("KM");
            
            accList.add(transactionaccForm);
            
       }
       return accList;
   }
   
   public List populateTransactionAcc(TransactionaccForm transactionaccForm, HttpServletRequest request) throws Exception {
        List transAcc = (List)request.getSession().getAttribute("transactionAccList");
        Transactionacc transactionacc = new Transactionacc();
        BeanUtils.copyProperties(transactionacc, transactionaccForm);
        if (transAcc==null) {
            transAcc = new ArrayList();            
            transAcc.add(transactionacc);
        } else {
            transAcc.add(transactionacc);
        }        
        return transAcc;
   }
   
   
}
