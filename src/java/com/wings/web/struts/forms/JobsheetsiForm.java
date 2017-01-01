
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for jobsheetsi.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="jobsheetsiForm"
 */
public class JobsheetsiForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idJobSheetSi = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _shippingLine = null;
   private java.lang.String _shippingLineName = null;
   private java.lang.String _feederVessel = null;
   private java.lang.String _mvessel = null;
   private java.lang.String _termMbl = null;
   private java.lang.String _termHbl = null;
   private java.lang.String _origin = null;
   private java.util.Date _etdorigin = null;
   private java.util.Date _etaorigin = null;
   private java.util.Date _customeDate = null;
   private java.lang.String _pod = null;
   private java.lang.String _trucking = null;
   private java.lang.String _commodity = null;
   private java.lang.String _dnNo;
   private java.lang.String _billTo;
   private java.lang.String _billToDebit = null;
   /**
    * Standard constructor.
    */
   public JobsheetsiForm() {
   }

   /**
    * Returns the idJobSheetSi
    *
    * @return the idJobSheetSi
    */
   public java.lang.Integer getIdJobSheetSi() {
      return _idJobSheetSi;
   }

   /**
    * Sets the idJobSheetSi
    *
    * @param idJobSheetSi the new idJobSheetSi value
    */
   public void setIdJobSheetSi(java.lang.Integer idJobSheetSi) {
      _idJobSheetSi = idJobSheetSi;
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
    * Returns the shippingLine
    *
    * @return the shippingLine
    */
   public java.lang.String getShippingLine() {
      return _shippingLine;
   }

   /**
    * Sets the shippingLine
    *
    * @param shippingLine the new shippingLine value
    */
   public void setShippingLine(java.lang.String shippingLine) {
      _shippingLine = shippingLine;
   }
   /**
    * Returns the feederVessel
    *
    * @return the feederVessel
    */
   public java.lang.String getFeederVessel() {
      return _feederVessel;
   }

   /**
    * Sets the feederVessel
    *
    * @param feederVessel the new feederVessel value
    */
   public void setFeederVessel(java.lang.String feederVessel) {
      _feederVessel = feederVessel;
   }
   /**
    * Returns the mvessel
    *
    * @return the mvessel
    */
   public java.lang.String getMvessel() {
      return _mvessel;
   }

   /**
    * Sets the mvessel
    *
    * @param mvessel the new mvessel value
    */
   public void setMvessel(java.lang.String mvessel) {
      _mvessel = mvessel;
   }
   /**
    * Returns the termMbl
    *
    * @return the termMbl
    */
   public java.lang.String getTermMbl() {
      return _termMbl;
   }

   /**
    * Sets the termMbl
    *
    * @param termMbl the new termMbl value
    */
   public void setTermMbl(java.lang.String termMbl) {
      _termMbl = termMbl;
   }
   /**
    * Returns the termHbl
    *
    * @return the termHbl
    */
   public java.lang.String getTermHbl() {
      return _termHbl;
   }

   /**
    * Sets the termHbl
    *
    * @param termHbl the new termHbl value
    */
   public void setTermHbl(java.lang.String termHbl) {
      _termHbl = termHbl;
   }
   /**
    * Returns the origin
    *
    * @return the origin
    */
   public java.lang.String getOrigin() {
      return _origin;
   }

   /**
    * Sets the origin
    *
    * @param origin the new origin value
    */
   public void setOrigin(java.lang.String origin) {
      _origin = origin;
   }
   /**
    * Returns the etdorigin
    *
    * @return the etdorigin
    */
   public java.util.Date getEtdorigin() {
      return _etdorigin;
   }

   /**
    * Returns the etdorigin as a String
    *
    * @return the etdorigin as a String
    */
   public String getEtdoriginAsString() {
      if( _etdorigin != null ) {
         return FORMAT.format(_etdorigin);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the etdorigin
    *
    * @param etdorigin the new etdorigin value
    */
   public void setEtdorigin(java.util.Date etdorigin) {
      _etdorigin = etdorigin;
   }

   /**
    * Sets the etdorigin as a String.
    *
    * @param etdorigin the new etdorigin value as a String
    */
   public void setEtdoriginAsString(String etdorigin) {
      try {
         _etdorigin = new java.util.Date(FORMAT.parse(etdorigin).getTime());
      } catch (ParseException pe) {
         //_etdorigin = new java.util.Date((new java.util.Date()).getTime());
          _etdorigin = null;
      }
   }

   /**
    * Returns the etaorigin
    *
    * @return the etaorigin
    */
   public java.util.Date getEtaorigin() {
      return _etaorigin;
   }

   /**
    * Returns the etaorigin as a String
    *
    * @return the etaorigin as a String
    */
   public String getEtaoriginAsString() {
      if( _etaorigin != null ) {
         return FORMAT.format(_etaorigin);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the etaorigin
    *
    * @param etaorigin the new etaorigin value
    */
   public void setEtaorigin(java.util.Date etaorigin) {
      _etaorigin = etaorigin;
   }

   /**
    * Sets the etaorigin as a String.
    *
    * @param etaorigin the new etaorigin value as a String
    */
   public void setEtaoriginAsString(String etaorigin) {
      try {
         _etaorigin = new java.util.Date(FORMAT.parse(etaorigin).getTime());
      } catch (ParseException pe) {
         //_etaorigin = new java.util.Date((new java.util.Date()).getTime());
         _etaorigin = null;
      }
   }

   /**
    * Returns the pod
    *
    * @return the pod
    */
   public java.lang.String getPod() {
      return _pod;
   }

   /**
    * Sets the pod
    *
    * @param pod the new pod value
    */
   public void setPod(java.lang.String pod) {
      _pod = pod;
   }
   /**
    * Returns the trucking
    *
    * @return the trucking
    */
   public java.lang.String getTrucking() {
      return _trucking;
   }

   /**
    * Sets the trucking
    *
    * @param trucking the new trucking value
    */
   public void setTrucking(java.lang.String trucking) {
      _trucking = trucking;
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
      if(getIdJobSheetSi() == null) {
         errors.add("idJobSheetSi", new ActionError("error.idJobSheetSi.required"));
      }
      if(getIdJobSheet() == null) {
         errors.add("idJobSheet", new ActionError("error.idJobSheet.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.String getCommodity() {
        return _commodity;
    }

    public void setCommodity(java.lang.String commodity) {
        this._commodity = commodity;
    }
    
    public void setCustomDateAsString(String customDate) {
      try {
         setCustomeDate(new java.util.Date(FORMAT.parse(customDate).getTime()));
      } catch (ParseException pe) {
         //setCustomeDate(new java.util.Date((new java.util.Date()).getTime()));
          setCustomeDate(null);
      }
   }
    
   public String getCustomDateAsString() {
      if( _customeDate != null ) {
         return FORMAT.format(_customeDate);
      }
      else {
         return "";
      }
   }
    public java.util.Date getCustomeDate() {
        return _customeDate;
    }

    public void setCustomeDate(java.util.Date customeDate) {
        this._customeDate = customeDate;
    }

    public java.lang.String getDnNo() {
        return _dnNo;
    }

    public void setDnNo(java.lang.String dnNo) {
        this._dnNo = dnNo;
    }

    public java.lang.String getBillTo() {
        return _billTo;
    }

    public void setBillTo(java.lang.String billTo) {
        this._billTo = billTo;
    }

    public java.lang.String getBillToDebit() {
        return _billToDebit;
    }

    public void setBillToDebit(java.lang.String billToDebit) {
        this._billToDebit = billToDebit;
    }

    /**
     * @return the _shippingLineName
     */
    public java.lang.String getShippingLineName() {
        return _shippingLineName;
    }

    /**
     * @param shippingLineName the _shippingLineName to set
     */
    public void setShippingLineName(java.lang.String shippingLineName) {
        this._shippingLineName = shippingLineName;
    }
}
