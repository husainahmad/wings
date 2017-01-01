
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class UserForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

   private java.lang.String _userId = null;
   private java.lang.String _name = null;
   private java.lang.String _password = null;
   private java.lang.String _newPassword = null;
   private java.lang.String _againNewPassword = null;
   private java.lang.String _authorityId = null;
   private java.lang.String _districtId = null;


   public UserForm() {
   }


   public java.lang.String getUserId() {
      return _userId;
   }


   public void setUserId(java.lang.String userId) {
      _userId = userId;
   }

   public java.lang.String getName() {
      return _name;
   }


   public void setName(java.lang.String name) {
      _name = name;
   }

   public java.lang.String getPassword() {
      return _password;
   }


   public void setPassword(java.lang.String password) {
      _password = password;
   }

   public java.lang.String getAuthorityId() {
      return _authorityId;
   }


   public void setAuthorityId(java.lang.String authorityId) {
      _authorityId = authorityId;
   }

   public java.lang.String getDistrictId() {
      return _districtId;
   }


   public void setDistrictId(java.lang.String districtId) {
      _districtId = districtId;
   }



   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
      ActionErrors errors = new ActionErrors();
      // test for nullity
//      if(getUserId() == null) {
//         errors.add("userId", new ActionError("error.userId.required"));
//      }
//      if(getName() == null) {
//         errors.add("name", new ActionError("error.name.required"));
//      }
//      if(getPassword() == null) {
//         errors.add("password", new ActionError("error.password.required"));
//      }
//      if(getAuthorityId() == null) {
//         errors.add("authorityId", new ActionError("error.authorityId.required"));
//      }
//      if(getDistrictId() == null) {
//         errors.add("districtId", new ActionError("error.districtId.required"));
//      }
      // TODO test format/data
      return errors;
   }

    public java.lang.String getNewPassword() {
        return _newPassword;
    }

    public void setNewPassword(java.lang.String newPassword) {
        this._newPassword = newPassword;
    }

    public java.lang.String getAgainNewPassword() {
        return _againNewPassword;
    }

    public void setAgainNewPassword(java.lang.String againNewPassword) {
        this._againNewPassword = againNewPassword;
    }
}
