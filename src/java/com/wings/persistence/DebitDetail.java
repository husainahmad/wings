/*
 * InvoiceDetail.java
 *
 * Created on May 30, 2008, 9:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author ahmad husain
 */
public class DebitDetail extends Debit {
    
    private String jobType;
    private String jobNo;
    private String invoiceNumber;
    private String idConsignee;
    
    public DebitDetail() {
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getIdConsignee() {
        return idConsignee;
    }

    public void setIdConsignee(String idConsignee) {
        this.idConsignee = idConsignee;
    }
    
}
