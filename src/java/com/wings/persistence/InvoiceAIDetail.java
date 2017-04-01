package com.wings.persistence;

import java.util.Date;

public class InvoiceAIDetail extends Jobsheet {

    private Integer idInvoice = null;   
    private String invoiceNumber = null;
    private Date invoiceDate = null;    
    private Date dueDate = null;
    private String consigneeName = null;
    private String shipperName = null;    
    private String mawb = null;
    private String hawb = null;
    private String commodity = null;
    private String destination = null;
    private String flights = null;
    private String fax = null;
    private String address1 = null;
    private String address2 = null;
    private Date payableDate;
    private String name;
    private Date dDate = null;
    private String idNumber = null;
    private String shippingLine = null;
    private String billTo = null;
    private String billToDebit = null;
    private String isPayable = null;
    private String idS = null;
    private String idC = null;
    private String idA = null;
    private String idSAccountIDR = null;
    private String idCAccountIDR = null;
    private String idAAccountIDR = null;
    private String idSAccountUSD = null;
    private String idCAccountUSD = null;
    private String idAAccountUSD = null;
    private String idAccountIDR = null;    
    private String idAccountUSD = null;
    private String vol;
    private Double jaminan;
    
    public InvoiceAIDetail() {
        
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getMawb() {
        return mawb;
    }

    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    public String getHawb() {
        return hawb;
    }

    public void setHawb(String hawb) {
        this.hawb = hawb;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlights() {
        return flights;
    }

    public void setFlights(String flights) {
        this.flights = flights;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Date getPayableDate() {
        return payableDate;
    }

    public void setPayableDate(Date payableDate) {
        this.payableDate = payableDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getShippingLine() {
        return shippingLine;
    }

    public void setShippingLine(String shippingLine) {
        this.shippingLine = shippingLine;
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

    public String getIsPayable() {
        return isPayable;
    }

    public void setIsPayable(String isPayable) {
        this.isPayable = isPayable;
    }

    /**
     * @return the idS
     */
    public String getIdS() {
        return idS;
    }

    /**
     * @param idS the idS to set
     */
    public void setIdS(String idS) {
        this.idS = idS;
    }

    /**
     * @return the idC
     */
    public String getIdC() {
        return idC;
    }

    /**
     * @param idC the idC to set
     */
    public void setIdC(String idC) {
        this.idC = idC;
    }

    /**
     * @return the idA
     */
    public String getIdA() {
        return idA;
    }

    /**
     * @param idA the idA to set
     */
    public void setIdA(String idA) {
        this.idA = idA;
    }

    /**
     * @return the idSAccountIDR
     */
    public String getIdSAccountIDR() {
        return idSAccountIDR;
    }

    /**
     * @param idSAccountIDR the idSAccountIDR to set
     */
    public void setIdSAccountIDR(String idSAccountIDR) {
        this.idSAccountIDR = idSAccountIDR;
    }

    /**
     * @return the idCAccountIDR
     */
    public String getIdCAccountIDR() {
        return idCAccountIDR;
    }

    /**
     * @param idCAccountIDR the idCAccountIDR to set
     */
    public void setIdCAccountIDR(String idCAccountIDR) {
        this.idCAccountIDR = idCAccountIDR;
    }

    /**
     * @return the idAAccountIDR
     */
    public String getIdAAccountIDR() {
        return idAAccountIDR;
    }

    /**
     * @param idAAccountIDR the idAAccountIDR to set
     */
    public void setIdAAccountIDR(String idAAccountIDR) {
        this.idAAccountIDR = idAAccountIDR;
    }

    /**
     * @return the idSAccountUSD
     */
    public String getIdSAccountUSD() {
        return idSAccountUSD;
    }

    /**
     * @param idSAccountUSD the idSAccountUSD to set
     */
    public void setIdSAccountUSD(String idSAccountUSD) {
        this.idSAccountUSD = idSAccountUSD;
    }

    /**
     * @return the idCAccountUSD
     */
    public String getIdCAccountUSD() {
        return idCAccountUSD;
    }

    /**
     * @param idCAccountUSD the idCAccountUSD to set
     */
    public void setIdCAccountUSD(String idCAccountUSD) {
        this.idCAccountUSD = idCAccountUSD;
    }

    /**
     * @return the idAAccountUSD
     */
    public String getIdAAccountUSD() {
        return idAAccountUSD;
    }

    /**
     * @param idAAccountUSD the idAAccountUSD to set
     */
    public void setIdAAccountUSD(String idAAccountUSD) {
        this.idAAccountUSD = idAAccountUSD;
    }

    /**
     * @return the idAccountIDR
     */
    public String getIdAccountIDR() {
        return idAccountIDR;
    }

    /**
     * @param idAccountIDR the idAccountIDR to set
     */
    public void setIdAccountIDR(String idAccountIDR) {
        this.idAccountIDR = idAccountIDR;
    }

    /**
     * @return the idAccountUSD
     */
    public String getIdAccountUSD() {
        return idAccountUSD;
    }

    /**
     * @param idAccountUSD the idAccountUSD to set
     */
    public void setIdAccountUSD(String idAccountUSD) {
        this.idAccountUSD = idAccountUSD;
    }

    /**
     * @return the vol
     */
    public String getVol() {
        return vol;
    }

    /**
     * @param vol the vol to set
     */
    public void setVol(String vol) {
        this.vol = vol;
    }

    /**
     * @return the jaminan
     */
    public Double getJaminan() {
        return jaminan;
    }

    /**
     * @param jaminan the jaminan to set
     */
    public void setJaminan(Double jaminan) {
        this.jaminan = jaminan;
    }
}
