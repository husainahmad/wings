
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for cashonhand.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="cashonhandForm"
 */
public class CashonhandForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idCashOnHand = null;
   private java.lang.Integer _idAccount = null;
   private java.lang.String _type = null;
   private java.lang.String _description = null;
   private java.lang.Double _amtIdr = null;
   private java.lang.Double _amtUsd = null;
   private java.lang.Double _amt2usd = null;
   private java.lang.Double _amt2idr = null;
   private java.lang.String _remark = null;
   private java.sql.Timestamp _transDate = null;

   /**
    * Standard constructor.
    */
   public CashonhandForm() {
   }

   /**
    * Returns the idCashOnHand
    *
    * @return the idCashOnHand
    */
   public java.lang.Integer getIdCashOnHand() {
      return _idCashOnHand;
   }

   /**
    * Sets the idCashOnHand
    *
    * @param idCashOnHand the new idCashOnHand value
    */
   public void setIdCashOnHand(java.lang.Integer idCashOnHand) {
      _idCashOnHand = idCashOnHand;
   }
   public java.lang.String getType() {
      return _type;
   }

   /**
    * Sets the type
    *
    * @param type the new type value
    */
   public void setType(java.lang.String type) {
      _type = type;
   }
   /**
    * Returns the description
    *
    * @return the description
    */
   public java.lang.String getDescription() {
      return _description;
   }

   /**
    * Sets the description
    *
    * @param description the new description value
    */
   public void setDescription(java.lang.String description) {
      _description = description;
   }
   /**
    * Returns the amtIdr
    *
    * @return the amtIdr
    */
   public java.lang.Double getAmtIdr() {
      return _amtIdr;
   }

   /**
    * Sets the amtIdr
    *
    * @param amtIdr the new amtIdr value
    */
   public void setAmtIdr(java.lang.Double amtIdr) {
      _amtIdr = amtIdr;
   }
   /**
    * Returns the amtUsd
    *
    * @return the amtUsd
    */
   public java.lang.Double getAmtUsd() {
      return _amtUsd;
   }

   /**
    * Sets the amtUsd
    *
    * @param amtUsd the new amtUsd value
    */
   public void setAmtUsd(java.lang.Double amtUsd) {
      _amtUsd = amtUsd;
   }
   /**
    * Returns the amt2usd
    *
    * @return the amt2usd
    */
   public java.lang.Double getAmt2usd() {
      return _amt2usd;
   }

   /**
    * Sets the amt2usd
    *
    * @param amt2usd the new amt2usd value
    */
   public void setAmt2usd(java.lang.Double amt2usd) {
      _amt2usd = amt2usd;
   }
   /**
    * Returns the amt2idr
    *
    * @return the amt2idr
    */
   public java.lang.Double getAmt2idr() {
      return _amt2idr;
   }

   /**
    * Sets the amt2idr
    *
    * @param amt2idr the new amt2idr value
    */
   public void setAmt2idr(java.lang.Double amt2idr) {
      _amt2idr = amt2idr;
   }
   /**
    * Returns the remark
    *
    * @return the remark
    */
   public java.lang.String getRemark() {
      return _remark;
   }

   /**
    * Sets the remark
    *
    * @param remark the new remark value
    */
   public void setRemark(java.lang.String remark) {
      _remark = remark;
   }
   /**
    * Returns the transDate
    *
    * @return the transDate
    */
   public java.sql.Timestamp getTransDate() {
      return _transDate;
   }

   /**
    * Returns the transDate as a String
    *
    * @return the transDate as a String
    */
   public String getTransDateAsString() {
      if( _transDate != null ) {
         return FORMAT.format(_transDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the transDate
    *
    * @param transDate the new transDate value
    */
   public void setTransDate(java.sql.Timestamp transDate) {
      _transDate = transDate;
   }

   /**
    * Sets the transDate as a String.
    *
    * @param transDate the new transDate value as a String
    */
   public void setTransDateAsString(String transDate) {
      try {
         _transDate = new java.sql.Timestamp(FORMAT.parse(transDate).getTime());
      } catch (ParseException pe) {
         _transDate = new java.sql.Timestamp((new java.util.Date()).getTime());
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
      if(getIdCashOnHand() == null) {
         errors.add("idCashOnHand", new ActionError("error.idCashOnHand.required"));
      }
      if(getType() == null) {
         errors.add("type", new ActionError("error.type.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.Integer getIdAccount() {
        return _idAccount;
    }

    public void setIdAccount(java.lang.Integer idAccount) {
        this._idAccount = idAccount;
    }
}
