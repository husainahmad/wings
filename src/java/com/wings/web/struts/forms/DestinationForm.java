
package com.wings.web.struts.forms;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for destination.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="destinationForm"
 */
public class DestinationForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.String _idDestination = null;
   private java.lang.String _name = null;

   /**
    * Standard constructor.
    */
   public DestinationForm() {
   }

   /**
    * Returns the idDestination
    *
    * @return the idDestination
    */
   public java.lang.String getIdDestination() {
      return _idDestination;
   }

   /**
    * Sets the idDestination
    *
    * @param idDestination the new idDestination value
    */
   public void setIdDestination(java.lang.String idDestination) {
      _idDestination = idDestination;
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
      if(getIdDestination() == null) {
         errors.add("idDestination", new ActionError("error.idDestination.required"));
      }
      if(getName() == null) {
         errors.add("name", new ActionError("error.name.required"));
      }
      // TODO test format/data
      return errors;
   }
}
