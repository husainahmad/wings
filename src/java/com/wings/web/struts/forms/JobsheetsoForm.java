
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for jobsheetso.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="jobsheetsoForm"
 */
public class JobsheetsoForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idJobSheetSo = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _shippingLine = null;
   private java.lang.String _shippingLineName = null;
   private java.lang.String _feederVessel = null;
   private java.lang.String _mvessel = null;
   private java.lang.String _termMbl = null;
   private java.lang.String _termHbl = null;
   private java.lang.String _origin = null;
   private java.lang.String _destination = null;
   private java.util.Date _etdorigin = null;
   private java.util.Date _etadestination = null;
   
   private java.lang.String _mbl = null;
   private java.lang.String _trucking = null;
   private java.lang.String _commodity = null;
   private java.lang.String _dnNo;
   private java.lang.String _billTo;
   private java.lang.String _cnNo;
   private java.lang.String _billToDebit = null;   
    
   /**
    * Standard constructor.
    */
   public JobsheetsoForm() {
   }

   /**
    * Returns the idJobSheetSo
    *
    * @return the idJobSheetSo
    */
   public java.lang.Integer getIdJobSheetSo() {
      return _idJobSheetSo;
   }

   /**
    * Sets the idJobSheetSo
    *
    * @param idJobSheetSo the new idJobSheetSo value
    */
   public void setIdJobSheetSo(java.lang.Integer idJobSheetSo) {
      _idJobSheetSo = idJobSheetSo;
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
    * Returns the destination
    *
    * @return the destination
    */
   public java.lang.String getDestination() {
      return _destination;
   }

   /**
    * Sets the destination
    *
    * @param destination the new destination value
    */
   public void setDestination(java.lang.String destination) {
      _destination = destination;
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
      if( getEtdorigin() != null ) {
         return getFORMAT().format(getEtdorigin());
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
         setEtdorigin(new java.util.Date(getFORMAT().parse(etdorigin).getTime()));
      } catch (ParseException pe) {
         //setEtdorigin(new java.util.Date((new java.util.Date()).getTime()));
         setEtdorigin(null);
      }
   }

   /**
    * Returns the etadestination
    *
    * @return the etadestination
    */
   public java.util.Date getEtadestination() {
      return _etadestination;
   }

   /**
    * Returns the etadestination as a String
    *
    * @return the etadestination as a String
    */
   public String getEtadestinationAsString() {
      if( getEtadestination() != null ) {
         return getFORMAT().format(getEtadestination());
      }
      else {
         return "";
      }
   }

   /**
    * Sets the etadestination
    *
    * @param etadestination the new etadestination value
    */
   public void setEtadestination(java.util.Date etadestination) {
      _etadestination = etadestination;
   }

   /**
    * Sets the etadestination as a String.
    *
    * @param etadestination the new etadestination value as a String
    */
   public void setEtadestinationAsString(String etadestination) {
      try {
         setEtadestination(new java.util.Date(getFORMAT().parse(etadestination).getTime()));
      } catch (ParseException pe) {
         //setEtadestination(new java.util.Date((new java.util.Date()).getTime()));
         setEtadestination(null);
      }
   }

   /**
    * Returns the mbl
    *
    * @return the mbl
    */
   public java.lang.String getMbl() {
      return _mbl;
   }

   /**
    * Sets the mbl
    *
    * @param mbl the new mbl value
    */
   public void setMbl(java.lang.String mbl) {
      _mbl = mbl;
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
      if(getIdJobSheetSo() == null) {
         errors.add("idJobSheetSo", new ActionError("error.idJobSheetSo.required"));
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
    
    private java.util.Date _sinDate = null;        
    
    public String getSinDateAsString() {
      if( getSinDate() != null ) {
         return getFORMAT().format(getSinDate());
      }
      else {
         return "";
      }
   }
    
    public void setSinDateAsString(String sinDate) {
      try {
         setSinDate(new java.util.Date(getFORMAT().parse(sinDate).getTime()));
      } catch (ParseException pe) {
         //setSinDate(new java.util.Date((new java.util.Date()).getTime()));
         setSinDate(null);
      }
   }
    
    public java.util.Date getSinDate() {
        return _sinDate;
    }

    public void setSinDate(java.util.Date sinDate) {
        this._sinDate = sinDate;
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

    public java.lang.String getCnNo() {
        return _cnNo;
    }

    public void setCnNo(java.lang.String cnNo) {
        this._cnNo = cnNo;
    }

    public static SimpleDateFormat getFORMAT() {
        return FORMAT;
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
