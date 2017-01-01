/*
 * TaxDetail.java
 *
 * Created on June 12, 2008, 8:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author Ahmad Husain
 */
public class TaxDetail extends Tax {
    
    private String jobNo;
        
    public TaxDetail() {
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }
    
}
