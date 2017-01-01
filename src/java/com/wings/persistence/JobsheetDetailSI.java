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
public class JobsheetDetailSI extends Jobsheet {
    
    private String invoicePaymentStatus;
    private String debitPaymentStatus;
    private String invoiceNumber;
    private String origin;
    private java.lang.Integer _idJobSheetAo = null;       
    private java.lang.String _termHBL = null;    
    private String destination;
    private Double baTax;
    private Double bsTax;
    private String billTo;
    private String billToDebit;
    private Double totalUSD;
    private Double totalIDR;    
    private String inumber;
    private String flights;
    private Double pag;
    private String mawb;
    private String shippingLine;
    private Double refund;
    private Double refundUS;
     private Double bsPPH;    
    public JobsheetDetailSI() {
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

    public java.lang.String getTermHBL() {
        return _termHBL;
    }

    public void setTermHBL(java.lang.String termHBL) {
        this._termHBL = termHBL;
    }
    
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getBaTax() {
        return baTax;
    }

    public void setBaTax(Double baTax) {
        this.baTax = baTax;
    }

    public Double getBsTax() {
        return bsTax;
    }

    public void setBsTax(Double bsTax) {
        this.bsTax = bsTax;
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

    public String getFlights() {
        return flights;
    }

    public void setFlights(String flights) {
        this.flights = flights;
    }

    public Double getPag() {
        return pag;
    }

    public void setPag(Double pag) {
        this.pag = pag;
    }

    public String getMawb() {
        return mawb;
    }

    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    public String getShippingLine() {
        return shippingLine;
    }

    public void setShippingLine(String shippingLine) {
        this.shippingLine = shippingLine;
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
