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
public class InvoiceDetail extends Invoice {
    
    private String jobType;
    private String jobNo;
    private String debitNumber;
    private String idConsignee;
    
    public InvoiceDetail() {
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

    public String getDebitNumber() {
        return debitNumber;
    }

    public void setDebitNumber(String debitNumber) {
        this.debitNumber = debitNumber;
    }

    public String getIdConsignee() {
        return idConsignee;
    }

    public void setIdConsignee(String idConsignee) {
        this.idConsignee = idConsignee;
    }
    
}
