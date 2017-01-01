package com.wings.persistence;

import java.util.Date;

public class InvoiceSODetail extends Jobsheet {

    private Integer idInvoice = null;   
    private String invoiceNumber = null;
    private Date invoiceDate = null;
    private Date dueDate = null;
    private String consigneeName = null;
    private String shipperName = null;    
    private String feederVessel = null;
    private String termHBL = null;
    private String commodity = null;
    private String destination = null;
    private String origin = null;
    private String fax = null;
    private String address1 = null;
    private String address2 = null;
    private Date payableDate;
    
    public InvoiceSODetail() {
        
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

    public String getFeederVessel() {
        return feederVessel;
    }

    public void setFeederVessel(String feederVessel) {
        this.feederVessel = feederVessel;
    }

    public String getTermHBL() {
        return termHBL;
    }

    public void setTermHBL(String termHBL) {
        this.termHBL = termHBL;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
}
