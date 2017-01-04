
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for billingshipper.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="billingshipperForm"
 */
public class BillingshipperForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.Integer _idbillingShipper = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.Integer _idShipperFee = null;
   private java.lang.Double _charge = null;
   private java.lang.Double _oriKurs;
   private java.lang.Double _oriWeight;
   private java.lang.String _kurs = null;
   private java.lang.String _description = null;
   private java.lang.String _descriptionInvoice = null;
   private java.lang.String _idAccountAI = null;
   private java.lang.String _idAccountAO = null;
   private java.lang.String _idAccountSI = null;
   private java.lang.String _idAccountSO = null;
   private java.lang.String _idAccountCostAI = null;
   private java.lang.String _idAccountCostAO = null;
   private java.lang.String _idAccountCostSI = null;
   private java.lang.String _idAccountCostSO = null;
   private java.lang.Double _kursValue = null;
   private java.lang.String _forName = null;
   private java.lang.Integer _isTax = new Integer(0);
   private java.lang.Integer _isVat = new Integer(0);
   private java.lang.Double _totalTax = null;
   private java.lang.Double _totalVat = null;
   private java.lang.Integer _isTax2 = new Integer(0);
   private java.lang.Double _totalTax2 = null;
   /**
    * Standard constructor.
    */
   public BillingshipperForm() {
   }

   /**
    * Returns the idbillingShipper
    *
    * @return the idbillingShipper
    */
   public java.lang.Integer getIdbillingShipper() {
      return _idbillingShipper;
   }

   /**
    * Sets the idbillingShipper
    *
    * @param idbillingShipper the new idbillingShipper value
    */
   public void setIdbillingShipper(java.lang.Integer idbillingShipper) {
      _idbillingShipper = idbillingShipper;
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
    * Returns the idShipperFee
    *
    * @return the idShipperFee
    */
   public java.lang.Integer getIdShipperFee() {
      return _idShipperFee;
   }

   /**
    * Sets the idShipperFee
    *
    * @param idShipperFee the new idShipperFee value
    */
   public void setIdShipperFee(java.lang.Integer idShipperFee) {
      _idShipperFee = idShipperFee;
   }
   /**
    * Returns the charge
    *
    * @return the charge
    */
   public java.lang.Double getCharge() {
      return _charge;
   }

   /**
    * Sets the charge
    *
    * @param charge the new charge value
    */
   public void setCharge(java.lang.Double charge) {
      _charge = charge;
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
      if(getIdbillingShipper() == null) {
         errors.add("idbillingShipper", new ActionError("error.idbillingShipper.required"));
      }
      if(getIdJobSheet() == null) {
         errors.add("idJobSheet", new ActionError("error.idJobSheet.required"));
      }
      if(getIdShipperFee() == null) {
         errors.add("idShipperFee", new ActionError("error.idShipperFee.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.String getDescription() {
        return _description;
    }

    public void setDescription(java.lang.String description) {
        this._description = description;
    }

    public java.lang.String getIdAccountAI() {
        return _idAccountAI;
    }

    public void setIdAccountAI(java.lang.String idAccountAI) {
        this._idAccountAI = idAccountAI;
    }

    public java.lang.String getIdAccountAO() {
        return _idAccountAO;
    }

    public void setIdAccountAO(java.lang.String idAccountAO) {
        this._idAccountAO = idAccountAO;
    }

    public java.lang.String getIdAccountSI() {
        return _idAccountSI;
    }

    public void setIdAccountSI(java.lang.String idAccountSI) {
        this._idAccountSI = idAccountSI;
    }

    public java.lang.String getIdAccountSO() {
        return _idAccountSO;
    }

    public void setIdAccountSO(java.lang.String idAccountSO) {
        this._idAccountSO = idAccountSO;
    }

    public java.lang.String getIdAccountCostAI() {
        return _idAccountCostAI;
    }

    public void setIdAccountCostAI(java.lang.String idAccountCostAI) {
        this._idAccountCostAI = idAccountCostAI;
    }

    public java.lang.String getIdAccountCostAO() {
        return _idAccountCostAO;
    }

    public void setIdAccountCostAO(java.lang.String idAccountCostAO) {
        this._idAccountCostAO = idAccountCostAO;
    }

    public java.lang.String getIdAccountCostSI() {
        return _idAccountCostSI;
    }

    public void setIdAccountCostSI(java.lang.String idAccountCostSI) {
        this._idAccountCostSI = idAccountCostSI;
    }

    public java.lang.String getIdAccountCostSO() {
        return _idAccountCostSO;
    }

    public void setIdAccountCostSO(java.lang.String idAccountCostSO) {
        this._idAccountCostSO = idAccountCostSO;
    }

    public java.lang.Double getKursValue() {
        return _kursValue;
    }

    public void setKursValue(java.lang.Double kursValue) {
        this._kursValue = kursValue;
    }

    public java.lang.String getDescriptionInvoice() {
        return _descriptionInvoice;
    }

    public void setDescriptionInvoice(java.lang.String descriptionInvoice) {
        this._descriptionInvoice = descriptionInvoice;
    }

    public java.lang.Double getOriKurs() {
        return _oriKurs;
    }

    public void setOriKurs(java.lang.Double oriKurs) {
        this._oriKurs = oriKurs;
    }

    public java.lang.Double getOriWeight() {
        return _oriWeight;
    }

    public void setOriWeight(java.lang.Double oriWeight) {
        this._oriWeight = oriWeight;
    }

    /**
     * @return the _forName
     */
    public java.lang.String getForName() {
        return _forName;
    }

    /**
     * @param forName the _forName to set
     */
    public void setForName(java.lang.String forName) {
        this._forName = forName;
    }

    /**
     * @return the _isTax
     */
    public java.lang.Integer getIsTax() {
        return _isTax;
    }

    /**
     * @param isTax the _isTax to set
     */
    public void setIsTax(java.lang.Integer isTax) {
        this._isTax = isTax;
    }

    /**
     * @return the _isVat
     */
    public java.lang.Integer getIsVat() {
        return _isVat;
    }

    /**
     * @param isVat the _isVat to set
     */
    public void setIsVat(java.lang.Integer isVat) {
        this._isVat = isVat;
    }

    /**
     * @return the _totalTax
     */
    public java.lang.Double getTotalTax() {
        return _totalTax;
    }

    /**
     * @param totalTax the _totalTax to set
     */
    public void setTotalTax(java.lang.Double totalTax) {
        this._totalTax = totalTax;
    }

    /**
     * @return the _totalVat
     */
    public java.lang.Double getTotalVat() {
        return _totalVat;
    }

    /**
     * @param totalVat the _totalVat to set
     */
    public void setTotalVat(java.lang.Double totalVat) {
        this._totalVat = totalVat;
    }

    /**
     * @return the _isTax2
     */
    public java.lang.Integer getIsTax2() {
        return _isTax2;
    }

    /**
     * @param _isTax2 the _isTax2 to set
     */
    public void setIsTax2(java.lang.Integer _isTax2) {
        this._isTax2 = _isTax2;
    }

    /**
     * @return the _totalTax2
     */
    public java.lang.Double getTotalTax2() {
        return _totalTax2;
    }

    /**
     * @param _totalTax2 the _totalTax2 to set
     */
    public void setTotalTax2(java.lang.Double _totalTax2) {
        this._totalTax2 = _totalTax2;
    }
}
