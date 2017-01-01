/*
 * DetailJobsheet.java
 *
 * Created on July 25, 2008, 9:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author Ahmad Husain
 */
public class DetailJobsheet {
    
    private String description;
    private Double billingIDR;
    private Double billingUSD;
    private Double expensesIDR;
    private Double expensesUSD;
    private String description2;    
    private String description3;    
    private Double kursValue;
    
    public DetailJobsheet() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBillingIDR() {
        return billingIDR;
    }

    public void setBillingIDR(Double billingIDR) {
        this.billingIDR = billingIDR;
    }

    public Double getBillingUSD() {
        return billingUSD;
    }

    public void setBillingUSD(Double billingUSD) {
        this.billingUSD = billingUSD;
    }

    public Double getExpensesIDR() {
        return expensesIDR;
    }

    public void setExpensesIDR(Double expensesIDR) {
        this.expensesIDR = expensesIDR;
    }

    public Double getExpensesUSD() {
        return expensesUSD;
    }

    public void setExpensesUSD(Double expensesUSD) {
        this.expensesUSD = expensesUSD;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public Double getKursValue() {
        return kursValue;
    }

    public void setKursValue(Double kursValue) {
        this.kursValue = kursValue;
    }
    
}
