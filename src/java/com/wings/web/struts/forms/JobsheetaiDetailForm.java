
package com.wings.web.struts.forms;

import com.wings.persistence.Jobsheet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


public class JobsheetaiDetailForm extends JobsheetForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
     
   private java.lang.Integer _idJobSheetAi = null;
   
   private java.lang.String _dnNo = null;
   private java.lang.String _destination = null;
   private java.lang.String _flights = null;
   private java.lang.String _cntFlight = null;
   private java.lang.String _freightTerm = null;
   private java.lang.String _agentTo = null;
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
   private java.lang.String _consigneeName = null;
   private java.lang.String _forwarderName = null;
   private java.lang.String _shipperName = null;
   private java.lang.String _agentName = null;
   private java.lang.String _originName = null;
   private java.lang.String _destinationName = null;
   private java.lang.String _transportName = null;
   private java.lang.String _billTo = null;
   private java.lang.String _billToDebit = null;
   private java.lang.Double _jaminan = null;
   
    
   /**
    * Standard constructor.
    */
   public JobsheetaiDetailForm() {
   }

    public java.lang.Integer getIdJobSheetAi() {
        return _idJobSheetAi;
    }

    public void setIdJobSheetAi(java.lang.Integer idJobSheetAi) {
        this._idJobSheetAi = idJobSheetAi;
    }

    public java.lang.String getDnNo() {
        return _dnNo;
    }

    public void setDnNo(java.lang.String dnNo) {
        this._dnNo = dnNo;
    }

    public java.lang.String getDestination() {
        return _destination;
    }

    public void setDestination(java.lang.String destination) {
        this._destination = destination;
    }

    public java.lang.String getFlights() {
        return _flights;
    }

    public void setFlights(java.lang.String flights) {
        this._flights = flights;
    }

    public java.lang.String getCntFlight() {
        return _cntFlight;
    }

    public void setCntFlight(java.lang.String cntFlight) {
        this._cntFlight = cntFlight;
    }

    public java.lang.String getFreightTerm() {
        return _freightTerm;
    }

    public void setFreightTerm(java.lang.String freightTerm) {
        this._freightTerm = freightTerm;
    }

    public java.lang.String getAgentTo() {
        return _agentTo;
    }

    public void setAgentTo(java.lang.String agentTo) {
        this._agentTo = agentTo;
    }

    public java.lang.String getOperationStaff() {
        return _operationStaff;
    }

    public void setOperationStaff(java.lang.String operationStaff) {
        this._operationStaff = operationStaff;
    }

    public java.lang.String getTelpColoader() {
        return _telpColoader;
    }

    public void setTelpColoader(java.lang.String telpColoader) {
        this._telpColoader = telpColoader;
    }

    public java.lang.String getFaxColoader() {
        return _faxColoader;
    }

    public void setFaxColoader(java.lang.String faxColoader) {
        this._faxColoader = faxColoader;
    }

    public java.lang.String getPicColoader() {
        return _picColoader;
    }

    public void setPicColoader(java.lang.String picColoader) {
        this._picColoader = picColoader;
    }

    public java.lang.String getMawb() {
        return _mawb;
    }

    public void setMawb(java.lang.String mawb) {
        this._mawb = mawb;
    }

    public java.lang.String getHawb() {
        return _hawb;
    }

    public void setHawb(java.lang.String hawb) {
        this._hawb = hawb;
    }

    public java.lang.String getEpte() {
        return _epte;
    }

    public void setEpte(java.lang.String epte) {
        this._epte = epte;
    }

    public java.lang.String getPibNo() {
        return _pibNo;
    }

    public void setPibNo(java.lang.String pibNo) {
        this._pibNo = pibNo;
    }

    public java.lang.String getDimention() {
        return _dimention;
    }

    public void setDimention(java.lang.String dimention) {
        this._dimention = dimention;
    }

    public java.lang.String getPickupCargo() {
        return _pickupCargo;
    }

    public void setPickupCargo(java.lang.String pickupCargo) {
        this._pickupCargo = pickupCargo;
    }

    public java.lang.String getCommodity() {
        return _commodity;
    }

    public void setCommodity(java.lang.String commodity) {
        this._commodity = commodity;
    }

    public java.lang.String getConsigneeName() {
        return _consigneeName;
    }

    public void setConsigneeName(java.lang.String consigneeName) {
        this._consigneeName = consigneeName;
    }

    public java.lang.String getShipperName() {
        return _shipperName;
    }

    public void setShipperName(java.lang.String shipperName) {
        this._shipperName = shipperName;
    }

    public java.lang.String getAgentName() {
        return _agentName;
    }

    public void setAgentName(java.lang.String agentName) {
        this._agentName = agentName;
    }

    public java.lang.String getOriginName() {
        return _originName;
    }

    public void setOriginName(java.lang.String originName) {
        this._originName = originName;
    }

    public java.lang.String getTransportName() {
        return _transportName;
    }

    public void setTransportName(java.lang.String transportName) {
        this._transportName = transportName;
    }

    public java.lang.String getDestinationName() {
        return _destinationName;
    }

    public void setDestinationName(java.lang.String destinationName) {
        this._destinationName = destinationName;
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
     * @return the _forwarderName
     */
    public java.lang.String getForwarderName() {
        return _forwarderName;
    }

    /**
     * @param forwarderName the _forwarderName to set
     */
    public void setForwarderName(java.lang.String forwarderName) {
        this._forwarderName = forwarderName;
    }

    /**
     * @return the _jaminan
     */
    public java.lang.Double getJaminan() {
        return _jaminan;
    }

    /**
     * @param jaminan the _jaminan to set
     */
    public void setJaminan(java.lang.Double jaminan) {
        this._jaminan = jaminan;
    }

    
}
