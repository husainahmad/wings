
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for consignee.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="consigneeForm"
 */
public class ConsigneeForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.String _idConsignee = null;
   private java.lang.String _name = null;
   private java.lang.String _description = null;
   private java.lang.String _description2 = null;
   private java.lang.String _contactPerson = null;
   private java.lang.String _telp = null;
   private java.lang.String _fax = null;
   private java.lang.String _email = null;
   private java.lang.String _address1 = null;
   private java.lang.String _address2 = null;
   private java.lang.String _postalCode = null;
   private java.lang.String _city = null;
   private java.lang.String _region = null;
   private java.lang.String _npwp = null;
   private java.lang.String _nppkp = null;
   private String _idAccountIDR = null;
   private String _idAccountUSD = null;
   /**
    * Standard constructor.
    */
   public ConsigneeForm() {
    _idConsignee = "";
    _name = "";
    _description = "";
    _description2 =  "";
    _contactPerson = "";
    _telp = "";
    _fax =  "";
    _email = "";
    _address1 = "";
    _address2 = "";
    _postalCode = "";
    _city = "";
    _region = "";
    _npwp = "";
    _nppkp = "";
    _idAccountIDR = "";
    _idAccountUSD = "";

   }

   /**
    * Returns the idConsignee
    *
    * @return the idConsignee
    */
   public java.lang.String getIdConsignee() {
      return _idConsignee;
   }

   /**
    * Sets the idConsignee
    *
    * @param idConsignee the new idConsignee value
    */
   public void setIdConsignee(java.lang.String idConsignee) {
      _idConsignee = idConsignee;
   }
   /**
    * Returns the name
    *
    * @return the name
    */
   public java.lang.String getName() {
      return _name;
   }

   /**
    * Sets the name
    *
    * @param name the new name value
    */
   public void setName(java.lang.String name) {
      _name = name;
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
    * Returns the contactPerson
    *
    * @return the contactPerson
    */
   public java.lang.String getContactPerson() {
      return _contactPerson;
   }

   /**
    * Sets the contactPerson
    *
    * @param contactPerson the new contactPerson value
    */
   public void setContactPerson(java.lang.String contactPerson) {
      _contactPerson = contactPerson;
   }
   /**
    * Returns the telp
    *
    * @return the telp
    */
   public java.lang.String getTelp() {
      return _telp;
   }

   /**
    * Sets the telp
    *
    * @param telp the new telp value
    */
   public void setTelp(java.lang.String telp) {
      _telp = telp;
   }
   /**
    * Returns the fax
    *
    * @return the fax
    */
   public java.lang.String getFax() {
      return _fax;
   }

   /**
    * Sets the fax
    *
    * @param fax the new fax value
    */
   public void setFax(java.lang.String fax) {
      _fax = fax;
   }
   /**
    * Returns the email
    *
    * @return the email
    */
   public java.lang.String getEmail() {
      return _email;
   }

   /**
    * Sets the email
    *
    * @param email the new email value
    */
   public void setEmail(java.lang.String email) {
      _email = email;
   }
   /**
    * Returns the address1
    *
    * @return the address1
    */
   public java.lang.String getAddress1() {
      return _address1;
   }

   /**
    * Sets the address1
    *
    * @param address1 the new address1 value
    */
   public void setAddress1(java.lang.String address1) {
      _address1 = address1;
   }
   /**
    * Returns the address2
    *
    * @return the address2
    */
   public java.lang.String getAddress2() {
      return _address2;
   }

   /**
    * Sets the address2
    *
    * @param address2 the new address2 value
    */
   public void setAddress2(java.lang.String address2) {
      _address2 = address2;
   }
   /**
    * Returns the postalCode
    *
    * @return the postalCode
    */
   public java.lang.String getPostalCode() {
      return _postalCode;
   }

   /**
    * Sets the postalCode
    *
    * @param postalCode the new postalCode value
    */
   public void setPostalCode(java.lang.String postalCode) {
      _postalCode = postalCode;
   }
   /**
    * Returns the city
    *
    * @return the city
    */
   public java.lang.String getCity() {
      return _city;
   }

   /**
    * Sets the city
    *
    * @param city the new city value
    */
   public void setCity(java.lang.String city) {
      _city = city;
   }
   /**
    * Returns the region
    *
    * @return the region
    */
   public java.lang.String getRegion() {
      return _region;
   }

   /**
    * Sets the region
    *
    * @param region the new region value
    */
   public void setRegion(java.lang.String region) {
      _region = region;
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
      if(getIdConsignee() == null) {
         errors.add("idConsignee", new ActionError("error.idConsignee.required"));
      }
      if(getName() == null) {
         errors.add("name", new ActionError("error.name.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.String getNpwp() {
        return _npwp;
    }

    public void setNpwp(java.lang.String npwp) {
        this._npwp = npwp;
    }

    public java.lang.String getNppkp() {
        return _nppkp;
    }

    public void setNppkp(java.lang.String nppkp) {
        this._nppkp = nppkp;
    }

    public String getIdAccountIDR() {
        return _idAccountIDR;
    }

    public void setIdAccountIDR(String idAccountIDR) {
        this._idAccountIDR = idAccountIDR;
    }

    public String getIdAccountUSD() {
        return _idAccountUSD;
    }

    public void setIdAccountUSD(String idAccountUSD) {
        this._idAccountUSD = idAccountUSD;
    }

    /**
     * @return the _description2
     */
    public java.lang.String getDescription2() {
        return _description2;
    }

    /**
     * @param description2 the _description2 to set
     */
    public void setDescription2(java.lang.String description2) {
        this._description2 = description2;
    }

   
}
