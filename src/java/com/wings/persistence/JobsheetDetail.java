/*
 * JobsheetInvoice.java
 *
 * Created on June 7, 2008, 12:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author Ahmad Husain
 */
public class JobsheetDetail extends Jobsheet {
    
    private String invoicePaymentStatus;
    private String debitPaymentStatus;
    private String invoiceNumber;
    private String debitNumber;
    private String mawb;
    private String hawb;
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
    private Double refundIDR;
    private Double refundUSD;
    private Double refund;
    private Double refundUS;
    private String agent;
    private String consignee;
    private String shipper;
    private String shippingLine;
    private Double bsPPH;
    
    
    public JobsheetDetail() {
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

    public String getDebitNumber() {
        return debitNumber;
    }

    public void setDebitNumber(String debitNumber) {
        this.debitNumber = debitNumber;
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

    public String getInumber() {
        return inumber;
    }

    public void setInumber(String inumber) {
        this.inumber = inumber;
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

    public Double getRefundIDR() {
        return refundIDR;
    }

    public void setRefundIDR(Double refundIDR) {
        this.refundIDR = refundIDR;
    }

    public Double getRefundUSD() {
        return refundUSD;
    }

    public void setRefundUSD(Double refundUSD) {
        this.refundUSD = refundUSD;
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
     * @return the agent
     */
    public String getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(String agent) {
        this.agent = agent;
    }

    /**
     * @return the consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * @param consignee the consignee to set
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * @return the shipper
     */
    public String getShipper() {
        return shipper;
    }

    /**
     * @param shipper the shipper to set
     */
    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    /**
     * @return the shippingLine
     */
    public String getShippingLine() {
        return shippingLine;
    }

    /**
     * @param shippingLine the shippingLine to set
     */
    public void setShippingLine(String shippingLine) {
        this.shippingLine = shippingLine;
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
