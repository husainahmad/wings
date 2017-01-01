
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for account.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="accountForm"
 */
public class AccountForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.String _idAccount = null;
   private java.lang.String _accountName = null;
   private java.lang.String _category = null;
   private java.lang.String _type = null;
   private java.lang.Double _saldoAwal = null;

   /**
    * Standard constructor.
    */
   public AccountForm() {
   }

   /**
    * Returns the idAccount
    *
    * @return the idAccount
    */
   public java.lang.String getIdAccount() {
      return _idAccount;
   }

   /**
    * Sets the idAccount
    *
    * @param idAccount the new idAccount value
    */
   public void setIdAccount(java.lang.String idAccount) {
      _idAccount = idAccount;
   }
   /**
    * Returns the accountName
    *
    * @return the accountName
    */
   public java.lang.String getAccountName() {
      return _accountName;
   }

   /**
    * Sets the accountName
    *
    * @param accountName the new accountName value
    */
   public void setAccountName(java.lang.String accountName) {
      _accountName = accountName;
   }
   /**
    * Returns the category
    *
    * @return the category
    */
   public java.lang.String getCategory() {
      return _category;
   }

   /**
    * Sets the category
    *
    * @param category the new category value
    */
   public void setCategory(java.lang.String category) {
      _category = category;
   }
   /**
    * Returns the type
    *
    * @return the type
    */
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
    * Returns the saldoAwal
    *
    * @return the saldoAwal
    */
   public java.lang.Double getSaldoAwal() {
      return _saldoAwal;
   }

   /**
    * Sets the saldoAwal
    *
    * @param saldoAwal the new saldoAwal value
    */
   public void setSaldoAwal(java.lang.Double saldoAwal) {
      _saldoAwal = saldoAwal;
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
      if(getIdAccount() == null) {
         errors.add("idAccount", new ActionError("error.idAccount.required"));
      }
      if(getAccountName() == null) {
         errors.add("accountName", new ActionError("error.accountName.required"));
      }
      // TODO test format/data
      return errors;
   }
}
