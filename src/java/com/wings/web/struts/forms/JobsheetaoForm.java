
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for jobsheetao.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="jobsheetaoForm"
 */
public class JobsheetaoForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idJobSheetAo = null;
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _dnNo = null;
   private java.lang.String _destination = null;
   private java.lang.String _flights = null;
   private java.lang.String _cntFlight = null;
   private java.lang.String _freightTerm = null;
   private java.lang.String _bookingTo = null;
   private java.lang.String _operationStaff = null;
   private java.lang.String _telpColoader = null;
   private java.lang.String _faxColoader = null;
   private java.lang.String _picColoader = null;
   private java.lang.String _mawb = null;
   private java.lang.String _hawb = null;
   private java.lang.String _epte = null;
   private java.lang.String _pibNo = null;
   private java.lang.String _dimention = null;
   private java.lang.String _pickupCargo = null;
   private java.lang.String _commodity;
   private java.lang.String _billTo;
   private java.lang.String _billToDebit = null;
   /**
    * Standard constructor.
    */
   public JobsheetaoForm() {
   }

   /**
    * Returns the idJobSheetAo
    *
    * @return the idJobSheetAo
    */
   public java.lang.Integer getIdJobSheetAo() {
      return _idJobSheetAo;
   }

   /**
    * Sets the idJobSheetAo
    *
    * @param idJobSheetAo the new idJobSheetAo value
    */
   public void setIdJobSheetAo(java.lang.Integer idJobSheetAo) {
      _idJobSheetAo = idJobSheetAo;
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
    * Returns the dnNo
    *
    * @return the dnNo
    */
   public java.lang.String getDnNo() {
      return _dnNo;
   }

   /**
    * Sets the dnNo
    *
    * @param dnNo the new dnNo value
    */
   public void setDnNo(java.lang.String dnNo) {
      _dnNo = dnNo;
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
    * Returns the flights
    *
    * @return the flights
    */
   public java.lang.String getFlights() {
      return _flights;
   }

   /**
    * Sets the flights
    *
    * @param flights the new flights value
    */
   public void setFlights(java.lang.String flights) {
      _flights = flights;
   }
   /**
    * Returns the cntFlight
    *
    * @return the cntFlight
    */
   public java.lang.String getCntFlight() {
      return _cntFlight;
   }

   /**
    * Sets the cntFlight
    *
    * @param cntFlight the new cntFlight value
    */
   public void setCntFlight(java.lang.String cntFlight) {
      _cntFlight = cntFlight;
   }
   /**
    * Returns the freightTerm
    *
    * @return the freightTerm
    */
   public java.lang.String getFreightTerm() {
      return _freightTerm;
   }

   /**
    * Sets the freightTerm
    *
    * @param freightTerm the new freightTerm value
    */
   public void setFreightTerm(java.lang.String freightTerm) {
      _freightTerm = freightTerm;
   }
   /**
    * Returns the bookingTo
    *
    * @return the bookingTo
    */
   public java.lang.String getBookingTo() {
      return _bookingTo;
   }

   /**
    * Sets the bookingTo
    *
    * @param bookingTo the new bookingTo value
    */
   public void setBookingTo(java.lang.String bookingTo) {
      _bookingTo = bookingTo;
   }
   /**
    * Returns the operationStaff
    *
    * @return the operationStaff
    */
   public java.lang.String getOperationStaff() {
      return _operationStaff;
   }

   /**
    * Sets the operationStaff
    *
    * @param operationStaff the new operationStaff value
    */
   public void setOperationStaff(java.lang.String operationStaff) {
      _operationStaff = operationStaff;
   }
   /**
    * Returns the telpColoader
    *
    * @return the telpColoader
    */
   public java.lang.String getTelpColoader() {
      return _telpColoader;
   }

   /**
    * Sets the telpColoader
    *
    * @param telpColoader the new telpColoader value
    */
   public void setTelpColoader(java.lang.String telpColoader) {
      _telpColoader = telpColoader;
   }
   /**
    * Returns the faxColoader
    *
    * @return the faxColoader
    */
   public java.lang.String getFaxColoader() {
      return _faxColoader;
   }

   /**
    * Sets the faxColoader
    *
    * @param faxColoader the new faxColoader value
    */
   public void setFaxColoader(java.lang.String faxColoader) {
      _faxColoader = faxColoader;
   }
   /**
    * Returns the picColoader
    *
    * @return the picColoader
    */
   public java.lang.String getPicColoader() {
      return _picColoader;
   }

   /**
    * Sets the picColoader
    *
    * @param picColoader the new picColoader value
    */
   public void setPicColoader(java.lang.String picColoader) {
      _picColoader = picColoader;
   }
   /**
    * Returns the mawb
    *
    * @return the mawb
    */
   public java.lang.String getMawb() {
      return _mawb;
   }

   /**
    * Sets the mawb
    *
    * @param mawb the new mawb value
    */
   public void setMawb(java.lang.String mawb) {
      _mawb = mawb;
   }
   /**
    * Returns the hawb
    *
    * @return the hawb
    */
   public java.lang.String getHawb() {
      return _hawb;
   }

   /**
    * Sets the hawb
    *
    * @param hawb the new hawb value
    */
   public void setHawb(java.lang.String hawb) {
      _hawb = hawb;
   }
   /**
    * Returns the epte
    *
    * @return the epte
    */
   public java.lang.String getEpte() {
      return _epte;
   }

   /**
    * Sets the epte
    *
    * @param epte the new epte value
    */
   public void setEpte(java.lang.String epte) {
      _epte = epte;
   }
   /**
    * Returns the pibNo
    *
    * @return the pibNo
    */
   public java.lang.String getPibNo() {
      return _pibNo;
   }

   /**
    * Sets the pibNo
    *
    * @param pibNo the new pibNo value
    */
   public void setPibNo(java.lang.String pibNo) {
      _pibNo = pibNo;
   }
   /**
    * Returns the dimention
    *
    * @return the dimention
    */
   public java.lang.String getDimention() {
      return _dimention;
   }

   /**
    * Sets the dimention
    *
    * @param dimention the new dimention value
    */
   public void setDimention(java.lang.String dimention) {
      _dimention = dimention;
   }
   /**
    * Returns the pickupCargo
    *
    * @return the pickupCargo
    */
   public java.lang.String getPickupCargo() {
      return _pickupCargo;
   }

   /**
    * Sets the pickupCargo
    *
    * @param pickupCargo the new pickupCargo value
    */
   public void setPickupCargo(java.lang.String pickupCargo) {
      _pickupCargo = pickupCargo;
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
      if(getIdJobSheetAo() == null) {
         errors.add("idJobSheetAo", new ActionError("error.idJobSheetAo.required"));
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
}
