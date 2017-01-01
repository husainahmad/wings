
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for shipperfee.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="shipperfeeForm"
 */
public class ShipperfeeForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.Integer _idShipperFee = null;
   private java.lang.String _description = null;
   private java.lang.String _isTax = null;
   private java.lang.String _aliasName = null;
   private java.lang.String _idAccountAI = null;
   private java.lang.String _idAccountAO = null;
   private java.lang.String _idAccountSI = null;
   private java.lang.String _idAccountSO = null;
   private java.lang.String _idAccountCostAI = null;
   private java.lang.String _idAccountCostAO = null;
   private java.lang.String _idAccountCostSI = null;
   private java.lang.String _idAccountCostSO = null;
   private java.lang.String _isAI;
   private java.lang.String _isAO;
   private java.lang.String _isSI;
   private java.lang.String _isSO;
   private java.lang.String _idJobType;
   private java.lang.String _category;
   
    private String _jobType;
    private Integer _type;
   /**
    * Standard constructor.
    */
   public ShipperfeeForm() {
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
      if(getIdShipperFee() == null) {
         errors.add("idShipperFee", new ActionError("error.idShipperFee.required"));
      }
      if(getDescription() == null) {
         errors.add("description", new ActionError("error.description.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.String getIsTax() {
        return _isTax;
    }

    public void setIsTax(java.lang.String isTax) {
        this._isTax = isTax;
    }

    public java.lang.String getAliasName() {
        return _aliasName;
    }

    public void setAliasName(java.lang.String aliasName) {
        this._aliasName = aliasName;
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

    public java.lang.String getIsAI() {
        return _isAI;
    }

    public void setIsAI(java.lang.String isAI) {
        this._isAI = isAI;
    }

    public java.lang.String getIsAO() {
        return _isAO;
    }

    public void setIsAO(java.lang.String isAO) {
        this._isAO = isAO;
    }

    public java.lang.String getIsSI() {
        return _isSI;
    }

    public void setIsSI(java.lang.String isSI) {
        this._isSI = isSI;
    }

    public java.lang.String getIsSO() {
        return _isSO;
    }

    public void setIsSO(java.lang.String isSO) {
        this._isSO = isSO;
    }

    public java.lang.String getIdJobType() {
        return _idJobType;
    }

    public void setIdJobType(java.lang.String idJobType) {
        this._idJobType = idJobType;
    }

    /**
     * @return the _category
     */
    public java.lang.String getCategory() {
        return _category;
    }

    /**
     * @param category the _category to set
     */
    public void setCategory(java.lang.String category) {
        this._category = category;
    }

    /**
     * @return the _jobType
     */
    public String getJobType() {
        return _jobType;
    }

    /**
     * @param jobType the _jobType to set
     */
    public void setJobType(String jobType) {
        this._jobType = jobType;
    }

    /**
     * @return the _type
     */
    public Integer getType() {
        return _type;
    }

    /**
     * @param type the _type to set
     */
    public void setType(Integer type) {
        this._type = type;
    }
}
