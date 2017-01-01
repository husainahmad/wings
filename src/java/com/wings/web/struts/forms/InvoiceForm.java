
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for invoice.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="invoiceForm"
 */
public class InvoiceForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idInvoice = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _invoiceNumber = null;
   private java.util.Date _invoiceDate = null;
   private java.lang.String _isPayable = null;
   
   /**
    * Standard constructor.
    */
   public InvoiceForm() {
   }

   /**
    * Returns the idInvoice
    *
    * @return the idInvoice
    */
   public java.lang.Integer getIdInvoice() {
      return _idInvoice;
   }

   /**
    * Sets the idInvoice
    *
    * @param idInvoice the new idInvoice value
    */
   public void setIdInvoice(java.lang.Integer idInvoice) {
      _idInvoice = idInvoice;
   }
   /**
    * Returns the idJobSheet
    *
    * @return the idJobSheet
    */
   public java.lang.Integer getIdJobSheet() {
      return _idJobSheet;
   }

   /**
    * Sets the idJobSheet
    *
    * @param idJobSheet the new idJobSheet value
    */
   public void setIdJobSheet(java.lang.Integer idJobSheet) {
      _idJobSheet = idJobSheet;
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
    * Returns the invoiceDate
    *
    * @return the invoiceDate
    */
   public java.util.Date getInvoiceDate() {
      return _invoiceDate;
   }

   /**
    * Returns the invoiceDate as a String
    *
    * @return the invoiceDate as a String
    */
   public String getInvoiceDateAsString() {
      if( _invoiceDate != null ) {
         return FORMAT.format(_invoiceDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the invoiceDate
    *
    * @param invoiceDate the new invoiceDate value
    */
   public void setInvoiceDate(java.util.Date invoiceDate) {
      _invoiceDate = invoiceDate;
   }

   /**
    * Sets the invoiceDate as a String.
    *
    * @param invoiceDate the new invoiceDate value as a String
    */
   public void setInvoiceDateAsString(String invoiceDate) {
      try {
         _invoiceDate = new java.sql.Timestamp(FORMAT.parse(invoiceDate).getTime());
      } catch (ParseException pe) {
         _invoiceDate = new java.sql.Timestamp((new java.util.Date()).getTime());
      }
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
      if(getIdInvoice() == null) {
         errors.add("idInvoice", new ActionError("error.idInvoice.required"));
      }
      if(getIdJobSheet() == null) {
         errors.add("idJobSheet", new ActionError("error.idJobSheet.required"));
      }
      if(getInvoiceNumber() == null) {
         errors.add("invoiceNumber", new ActionError("error.invoiceNumber.required"));
      }
      if(getInvoiceDate() == null) {
         errors.add("invoiceDate", new ActionError("error.invoiceDate.required"));
      }
      // TODO test format/data
      return errors;
   }

    /**
     * @return the _isPayable
     */
    public java.lang.String getIsPayable() {
        return _isPayable;
    }

    /**
     * @param isPayable the _isPayable to set
     */
    public void setIsPayable(java.lang.String isPayable) {
        this._isPayable = isPayable;
    }
}
