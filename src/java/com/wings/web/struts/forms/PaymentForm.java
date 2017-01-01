
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for payment.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="paymentForm"
 */
public class PaymentForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idPayment = null;
   private java.lang.String _idCostomer = null;
   private java.lang.String _billTo = null;
   private java.lang.String _billToDebit = null;
   private java.lang.String _invoiceNumber = null;
   private java.lang.String _isInvoice = null;
   private java.util.Date _paymentDate = null;
   private java.lang.String _bank = null;
   private java.lang.Double _amount = null;
   private java.lang.String _kurs = null;

   /**
    * Standard constructor.
    */
   public PaymentForm() {
   }

   /**
    * Returns the idPayment
    *
    * @return the idPayment
    */
   public java.lang.Integer getIdPayment() {
      return _idPayment;
   }

   /**
    * Sets the idPayment
    *
    * @param idPayment the new idPayment value
    */
   public void setIdPayment(java.lang.Integer idPayment) {
      _idPayment = idPayment;
   }
   /**
    * Returns the idCostomer
    *
    * @return the idCostomer
    */
   public java.lang.String getIdCostomer() {
      return _idCostomer;
   }

   /**
    * Sets the idCostomer
    *
    * @param idCostomer the new idCostomer value
    */
   public void setIdCostomer(java.lang.String idCostomer) {
      _idCostomer = idCostomer;
   }
   /**
    * Returns the billTo
    *
    * @return the billTo
    */
   public java.lang.String getBillTo() {
      return _billTo;
   }

   /**
    * Sets the billTo
    *
    * @param billTo the new billTo value
    */
   public void setBillTo(java.lang.String billTo) {
      _billTo = billTo;
   }
   /**
    * Returns the billToDebit
    *
    * @return the billToDebit
    */
   public java.lang.String getBillToDebit() {
      return _billToDebit;
   }

   /**
    * Sets the billToDebit
    *
    * @param billToDebit the new billToDebit value
    */
   public void setBillToDebit(java.lang.String billToDebit) {
      _billToDebit = billToDebit;
   }
   /**
    * Returns the invoiceNumber
    *
    * @return the invoiceNumber
    */
   public java.lang.String getInvoiceNumber() {
      return _invoiceNumber;
   }

   /**
    * Sets the invoiceNumber
    *
    * @param invoiceNumber the new invoiceNumber value
    */
   public void setInvoiceNumber(java.lang.String invoiceNumber) {
      _invoiceNumber = invoiceNumber;
   }
   /**
    * Returns the isInvoice
    *
    * @return the isInvoice
    */
   public java.lang.String getIsInvoice() {
      return _isInvoice;
   }

   /**
    * Sets the isInvoice
    *
    * @param isInvoice the new isInvoice value
    */
   public void setIsInvoice(java.lang.String isInvoice) {
      _isInvoice = isInvoice;
   }
   /**
    * Returns the paymentDate
    *
    * @return the paymentDate
    */
   public java.util.Date getPaymentDate() {
      return _paymentDate;
   }

   /**
    * Returns the paymentDate as a String
    *
    * @return the paymentDate as a String
    */
   public String getPaymentDateAsString() {
      if( _paymentDate != null ) {
         return FORMAT.format(_paymentDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the paymentDate
    *
    * @param paymentDate the new paymentDate value
    */
   public void setPaymentDate(java.util.Date paymentDate) {
      _paymentDate = paymentDate;
   }

   /**
    * Sets the paymentDate as a String.
    *
    * @param paymentDate the new paymentDate value as a String
    */
   public void setPaymentDateAsString(String paymentDate) {
      try {
         _paymentDate = new java.util.Date(FORMAT.parse(paymentDate).getTime());
      } catch (ParseException pe) {
         _paymentDate = new java.util.Date((new java.util.Date()).getTime());
      }
   }

   /**
    * Returns the bank
    *
    * @return the bank
    */
   public java.lang.String getBank() {
      return _bank;
   }

   /**
    * Sets the bank
    *
    * @param bank the new bank value
    */
   public void setBank(java.lang.String bank) {
      _bank = bank;
   }
   /**
    * Returns the amount
    *
    * @return the amount
    */
   public java.lang.Double getAmount() {
      return _amount;
   }

   /**
    * Sets the amount
    *
    * @param amount the new amount value
    */
   public void setAmount(java.lang.Double amount) {
      _amount = amount;
   }
   /**
    * Returns the kurs
    *
    * @return the kurs
    */
   public java.lang.String getKurs() {
      return _kurs;
   }

   /**
    * Sets the kurs
    *
    * @param kurs the new kurs value
    */
   public void setKurs(java.lang.String kurs) {
      _kurs = kurs;
   }


   /**
    * Validate the properties that have been set from this HTTP request,
    * and return an <code>ActionErrors</code> object that encapsulates any
    * validation errors that have been found.  If no errors are found, return
    * <code>null</code> or an <code>ActionErrors</code> object with no
    * recorded error messages.
    *
    * @param mapping The mapping used to select this instance
    * @param request The servlet request we are processing
    */
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
      ActionErrors errors = new ActionErrors();
      // test for nullity
      if(getIdPayment() == null) {
         errors.add("idPayment", new ActionError("error.idPayment.required"));
      }
      // TODO test format/data
      return errors;
   }
}
