/*
 * BillingshipperDetail.java
 *
 * Created on May 30, 2008, 9:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author ahmad husain
 */
public class BillingagentDetail extends Billingagent {
    private String description;
    private String descriptionFee;
    private String aliasName;
    private String category;
    
    /** Creates a new instance of BillingshipperDetail */
    public BillingagentDetail() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionFee() {
        return descriptionFee;
    }

    public void setDescriptionFee(String descriptionFee) {
        this.descriptionFee = descriptionFee;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
}
