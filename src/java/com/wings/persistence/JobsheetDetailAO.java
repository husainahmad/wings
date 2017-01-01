/*
 * JobsheetDetailAO.java
 *
 * Created on June 10, 2008, 7:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author Ahmad Husain
 */
public class JobsheetDetailAO extends Jobsheet {
    
    private String invoicePaymentStatus;
    private String debitPaymentStatus;
    private String invoiceNumber;
    private String debitNumber;
    private java.lang.Integer _idJobSheetAo = null;
   
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
    private Double _baTax;
    private Double _bsTax;
    private String billTo;
    private String billToDebit;
    private Double totalUSD;
    private Double totalIDR;    
    private String inumber;
    private String flights;
    private Double pag;
    private Double refund;
    private Double refundUS;
    private Double bsPPH;  
    public JobsheetDetailAO() {
    }

    public String getInvoicePaymentStatus() {
        return invoicePaymentStatus;
    }

    public void setInvoicePaymentStatus(String invoicePaymentStatus) {
        this.invoicePaymentStatus = invoicePaymentStatus;
    }

    public String getDebitPaymentStatus() {
        return debitPaymentStatus;
    }

    public void setDebitPaymentStatus(String debitPaymentStatus) {
        this.debitPaymentStatus = debitPaymentStatus;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public java.lang.Integer getIdJobSheetAo() {
        return _idJobSheetAo;
    }

    public void setIdJobSheetAo(java.lang.Integer idJobSheetAo) {
        this._idJobSheetAo = idJobSheetAo;
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

    public java.lang.String getBookingTo() {
        return _bookingTo;
    }

    public void setBookingTo(java.lang.String bookingTo) {
        this._bookingTo = bookingTo;
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

    public Double getBaTax() {
        return _baTax;
    }

    public void setBaTax(Double baTax) {
        this._baTax = baTax;
    }

    public Double getBsTax() {
        return _bsTax;
    }

    public void setBsTax(Double bsTax) {
        this._bsTax = bsTax;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getBillToDebit() {
        return billToDebit;
    }

    public void setBillToDebit(String billToDebit) {
        this.billToDebit = billToDebit;
    }

    public String getDebitNumber() {
        return debitNumber;
    }

    public void setDebitNumber(String debitNumber) {
        this.debitNumber = debitNumber;
    }

    public Double getTotalUSD() {
        return totalUSD;
    }

    public void setTotalUSD(Double totalUSD) {
        this.totalUSD = totalUSD;
    }

    public Double getTotalIDR() {
        return totalIDR;
    }

    public void setTotalIDR(Double totalIDR) {
        this.totalIDR = totalIDR;
    }

    public String getInumber() {
        return inumber;
    }

    public void setInumber(String inumber) {
        this.inumber = inumber;
    }

    public Double getPag() {
        return pag;
    }

    public void setPag(Double pag) {
        this.pag = pag;
    }
    
    public Double getRefund() {
        return refund;
    }

    public void setRefund(Double refund) {
        this.refund = refund;
    }

    public Double getRefundUS() {
        return refundUS;
    }

    public void setRefundUS(Double refundUS) {
        this.refundUS = refundUS;
    }

    /**
     * @return the bsPPH
     */
    public Double getBsPPH() {
        return bsPPH;
    }

    /**
     * @param bsPPH the bsPPH to set
     */
    public void setBsPPH(Double bsPPH) {
        this.bsPPH = bsPPH;
    }
    
}
