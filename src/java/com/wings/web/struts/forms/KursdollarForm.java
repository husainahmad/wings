
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for kursdollar.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="kursdollarForm"
 */
public class KursdollarForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idKursDollar = null;
   private java.sql.Date _changeDate = null;
   private java.lang.Double _value = null;

   /**
    * Standard constructor.
    */
   public KursdollarForm() {
   }

   /**
    * Returns the idKursDollar
    *
    * @return the idKursDollar
    */
   public java.lang.Integer getIdKursDollar() {
      return _idKursDollar;
   }

   /**
    * Sets the idKursDollar
    *
    * @param idKursDollar the new idKursDollar value
    */
   public void setIdKursDollar(java.lang.Integer idKursDollar) {
      _idKursDollar = idKursDollar;
   }
   /**
    * Returns the changeDate
    *
    * @return the changeDate
    */
   public java.sql.Date getChangeDate() {
      return _changeDate;
   }

   /**
    * Returns the changeDate as a String
    *
    * @return the changeDate as a String
    */
   public String getChangeDateAsString() {
      if( _changeDate != null ) {
         return FORMAT.format(_changeDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the changeDate
    *
    * @param changeDate the new changeDate value
    */
   public void setChangeDate(java.sql.Date changeDate) {
      _changeDate = changeDate;
   }

   /**
    * Sets the changeDate as a String.
    *
    * @param changeDate the new changeDate value as a String
    */
   public void setChangeDateAsString(String changeDate) {
      try {
         _changeDate = new java.sql.Date(FORMAT.parse(changeDate).getTime());
      } catch (ParseException pe) {
         _changeDate = new java.sql.Date((new java.util.Date()).getTime());
      }
   }

   /**
    * Returns the value
    *
    * @return the value
    */
   public java.lang.Double getValue() {
      return _value;
   }

   /**
    * Sets the value
    *
    * @param value the new value value
    */
   public void setValue(java.lang.Double value) {
      _value = value;
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
      if(getIdKursDollar() == null) {
         errors.add("idKursDollar", new ActionError("error.idKursDollar.required"));
      }
      // TODO test format/data
      return errors;
   }
}
