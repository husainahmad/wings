/*
 * MonthlySales.java
 *
 * Created on August 26, 2008, 12:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

import java.util.Date;

/**
 *
 * @author Ahmad Husain
 */
public class MonthlySales {
    private String groupingBy;
    private Date shippedDate;
    private String customer;
    private String inumber;
    private String jobNo;
    private String mawb;
    private String origin;
    private String gwt;
    private String vwt;
    private Double incomingUSD;
    private Double incomingIDR;
    private Double outgoingUSD;
    private Double outgoingIDR;
    private Double outgoingRefund;
    private Double outgoingRefundUS;
    private Double outgoingRefundIDR;
    private Double outgoingRefundUSD;
    private Double outgoingTax;
    private Double profitUSD;
    private Double profitIDR;
    private Double pag;
    private String remark;
    private String irow;
    private String flights;
    private Double refundAgentUSD;
    private Double refundAgentIDR;
    private Double creditNoteUSD;
    private Double creditNoteIDR;
    private Double bsPPH;
    private Double vatIDR2;
    
    /** Creates a new instance of MonthlySales */
    public MonthlySales() {
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getInumber() {
        return inumber;
    }

    public void setInumber(String inumber) {
        this.inumber = inumber;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getMawb() {
        return mawb;
    }

    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getGwt() {
        return gwt;
    }

    public void setGwt(String gwt) {
        this.gwt = gwt;
    }

    public String getVwt() {
        return vwt;
    }

    public void setVwt(String vwt) {
        this.vwt = vwt;
    }

    public Double getIncomingUSD() {
        return incomingUSD;
    }

    public void setIncomingUSD(Double incomingUSD) {
        this.incomingUSD = incomingUSD;
    }

    public Double getIncomingIDR() {
        return incomingIDR;
    }

    public void setIncomingIDR(Double incomingIDR) {
        this.incomingIDR = incomingIDR;
    }

    public Double getOutgoingUSD() {
        return outgoingUSD;
    }

    public void setOutgoingUSD(Double outgoingUSD) {
        this.outgoingUSD = outgoingUSD;
    }

    public Double getOutgoingIDR() {
        return outgoingIDR;
    }

    public void setOutgoingIDR(Double outgoingIDR) {
        this.outgoingIDR = outgoingIDR;
    }

    public Double getOutgoingRefund() {
        return outgoingRefund;
    }

    public void setOutgoingRefund(Double outgoingRefund) {
        this.outgoingRefund = outgoingRefund;
    }

    public Double getOutgoingTax() {
        return outgoingTax;
    }

    public void setOutgoingTax(Double outgoingTax) {
        this.outgoingTax = outgoingTax;
    }

    public Double getProfitUSD() {
        return profitUSD;
    }

    public void setProfitUSD(Double profitUSD) {
        this.profitUSD = profitUSD;
    }

    public Double getProfitIDR() {
        return profitIDR;
    }

    public void setProfitIDR(Double profitIDR) {
        this.profitIDR = profitIDR;
    }

    public Double getPag() {
        return pag;
    }

    public void setPag(Double pag) {
        this.pag = pag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIrow() {
        return irow;
    }

    public void setIrow(String irow) {
        this.irow = irow;
    }

    public String getGroupingBy() {
        return groupingBy;
    }

    public void setGroupingBy(String groupingBy) {
        this.groupingBy = groupingBy;
    }

    public String getFlights() {
        return flights;
    }

    public void setFlights(String flights) {
        this.flights = flights;
    }

    public Double getOutgoingRefundUSD() {
        return outgoingRefundUSD;
    }

    public void setOutgoingRefundUSD(Double outgoingRefundUSD) {
        this.outgoingRefundUSD = outgoingRefundUSD;
    }

    public Double getOutgoingRefundIDR() {
        return outgoingRefundIDR;
    }

    public void setOutgoingRefundIDR(Double outgoingRefundIDR) {
        this.outgoingRefundIDR = outgoingRefundIDR;
    }

    public Double getRefundAgentUSD() {
        return refundAgentUSD;
    }

    public void setRefundAgentUSD(Double refundAgentUSD) {
        this.refundAgentUSD = refundAgentUSD;
    }

    public Double getRefundAgentIDR() {
        return refundAgentIDR;
    }

    public void setRefundAgentIDR(Double refundAgentIDR) {
        this.refundAgentIDR = refundAgentIDR;
    }

    public Double getCreditNoteUSD() {
        return creditNoteUSD;
    }

    public void setCreditNoteUSD(Double creditNoteUSD) {
        this.creditNoteUSD = creditNoteUSD;
    }

    public Double getCreditNoteIDR() {
        return creditNoteIDR;
    }

    public void setCreditNoteIDR(Double creditNoteIDR) {
        this.creditNoteIDR = creditNoteIDR;
    }

    public Double getOutgoingRefundUS() {
        return outgoingRefundUS;
    }

    public void setOutgoingRefundUS(Double outgoingRefundUS) {
        this.outgoingRefundUS = outgoingRefundUS;
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

    /**
     * @return the vatIDR2
     */
    public Double getVatIDR2() {
        return vatIDR2;
    }

    /**
     * @param vatIDR2 the vatIDR2 to set
     */
    public void setVatIDR2(Double vatIDR2) {
        this.vatIDR2 = vatIDR2;
    }
    
}
