
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for perkiraan.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="perkiraanForm"
 */
public class PerkiraanForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.String _idPerkiraan = null;
   private java.lang.String _description = null;

   /**
    * Standard constructor.
    */
   public PerkiraanForm() {
   }

   /**
    * Returns the idPerkiraan
    *
    * @return the idPerkiraan
    */
   public java.lang.String getIdPerkiraan() {
      return _idPerkiraan;
   }

   /**
    * Sets the idPerkiraan
    *
    * @param idPerkiraan the new idPerkiraan value
    */
   public void setIdPerkiraan(java.lang.String idPerkiraan) {
      _idPerkiraan = idPerkiraan;
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
      if(getIdPerkiraan() == null) {
         errors.add("idPerkiraan", new ActionError("error.idPerkiraan.required"));
      }
      if(getDescription() == null) {
         errors.add("description", new ActionError("error.description.required"));
      }
      // TODO test format/data
      return errors;
   }
}
