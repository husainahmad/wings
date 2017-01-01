
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for tax.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="taxForm"
 */
public class TaxForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idTax = null;
   private java.lang.String _idJobSheet = null;
   private java.lang.String _noFaktur = null;
   private java.sql.Date _fakturDate = null;
   private java.lang.Double _dpp = null;
   private java.lang.Double _ppn = null;
   private java.sql.Date _pkpDate = null;

   /**
    * Standard constructor.
    */
   public TaxForm() {
   }

   /**
    * Returns the idTax
    *
    * @return the idTax
    */
   public java.lang.Integer getIdTax() {
      return _idTax;
   }

   /**
    * Sets the idTax
    *
    * @param idTax the new idTax value
    */
   public void setIdTax(java.lang.Integer idTax) {
      _idTax = idTax;
   }
   /**
    * Returns the idJobSheet
    *
    * @return the idJobSheet
    */
   public java.lang.String getIdJobSheet() {
      return _idJobSheet;
   }

   /**
    * Sets the idJobSheet
    *
    * @param idJobSheet the new idJobSheet value
    */
   public void setIdJobSheet(java.lang.String idJobSheet) {
      _idJobSheet = idJobSheet;
   }
   /**
    * Returns the noFaktur
    *
    * @return the noFaktur
    */
   public java.lang.String getNoFaktur() {
      return _noFaktur;
   }

   /**
    * Sets the noFaktur
    *
    * @param noFaktur the new noFaktur value
    */
   public void setNoFaktur(java.lang.String noFaktur) {
      _noFaktur = noFaktur;
   }
   /**
    * Returns the fakturDate
    *
    * @return the fakturDate
    */
   public java.sql.Date getFakturDate() {
      return _fakturDate;
   }

   /**
    * Returns the fakturDate as a String
    *
    * @return the fakturDate as a String
    */
   public String getFakturDateAsString() {
      if( _fakturDate != null ) {
         return FORMAT.format(_fakturDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the fakturDate
    *
    * @param fakturDate the new fakturDate value
    */
   public void setFakturDate(java.sql.Date fakturDate) {
      _fakturDate = fakturDate;
   }

   /**
    * Sets the fakturDate as a String.
    *
    * @param fakturDate the new fakturDate value as a String
    */
   public void setFakturDateAsString(String fakturDate) {
      try {
         _fakturDate = new java.sql.Date(FORMAT.parse(fakturDate).getTime());
      } catch (ParseException pe) {
         _fakturDate = new java.sql.Date((new java.util.Date()).getTime());
      }
   }

   /**
    * Returns the dpp
    *
    * @return the dpp
    */
   public java.lang.Double getDpp() {
      return _dpp;
   }

   /**
    * Sets the dpp
    *
    * @param dpp the new dpp value
    */
   public void setDpp(java.lang.Double dpp) {
      _dpp = dpp;
   }
   /**
    * Returns the ppn
    *
    * @return the ppn
    */
   public java.lang.Double getPpn() {
      return _ppn;
   }

   /**
    * Sets the ppn
    *
    * @param ppn the new ppn value
    */
   public void setPpn(java.lang.Double ppn) {
      _ppn = ppn;
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
      if(getIdTax() == null) {
         errors.add("idTax", new ActionError("error.idTax.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.sql.Date getPkpDate() {
        return _pkpDate;
    }

    public void setPkpDate(java.sql.Date pkpDate) {
        this._pkpDate = pkpDate;
    }
    
    public String getPkpDateAsString() {
      if( _pkpDate != null ) {
         return FORMAT.format(_pkpDate);
      }
      else {
         return "";
      }
   }
    
   public void setPkpDateAsString(String pkpDate) {
      try {
         _pkpDate = new java.sql.Date(FORMAT.parse(pkpDate).getTime());
      } catch (ParseException pe) {
         _pkpDate = new java.sql.Date((new java.util.Date()).getTime());
      }
   }

}
