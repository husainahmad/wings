
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for debit.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="debitForm"
 */
public class DebitForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idDebit = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _debitNumber = null;
   private java.sql.Date _debitDate = null;
   private java.lang.String _isPayable = null;
   
   /**
    * Standard constructor.
    */
   public DebitForm() {
   }

   /**
    * Returns the idDebit
    *
    * @return the idDebit
    */
   public java.lang.Integer getIdDebit() {
      return _idDebit;
   }

   /**
    * Sets the idDebit
    *
    * @param idDebit the new idDebit value
    */
   public void setIdDebit(java.lang.Integer idDebit) {
      _idDebit = idDebit;
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
    * Returns the debitNumber
    *
    * @return the debitNumber
    */
   public java.lang.String getDebitNumber() {
      return _debitNumber;
   }

   /**
    * Sets the debitNumber
    *
    * @param debitNumber the new debitNumber value
    */
   public void setDebitNumber(java.lang.String debitNumber) {
      _debitNumber = debitNumber;
   }
   /**
    * Returns the debitDate
    *
    * @return the debitDate
    */
   public java.sql.Date getDebitDate() {
      return _debitDate;
   }

   /**
    * Returns the debitDate as a String
    *
    * @return the debitDate as a String
    */
   public String getDebitDateAsString() {
      if( _debitDate != null ) {
         return FORMAT.format(_debitDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the debitDate
    *
    * @param debitDate the new debitDate value
    */
   public void setDebitDate(java.sql.Date debitDate) {
      _debitDate = debitDate;
   }

   /**
    * Sets the debitDate as a String.
    *
    * @param debitDate the new debitDate value as a String
    */
   public void setDebitDateAsString(String debitDate) {
      try {
         _debitDate = new java.sql.Date(FORMAT.parse(debitDate).getTime());
      } catch (ParseException pe) {
         _debitDate = new java.sql.Date((new java.util.Date()).getTime());
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
      if(getIdDebit() == null) {
         errors.add("idDebit", new ActionError("error.idDebit.required"));
      }
      if(getIdJobSheet() == null) {
         errors.add("idJobSheet", new ActionError("error.idJobSheet.required"));
      }
      if(getDebitNumber() == null) {
         errors.add("debitNumber", new ActionError("error.debitNumber.required"));
      }
      if(getDebitDate() == null) {
         errors.add("debitDate", new ActionError("error.debitDate.required"));
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
