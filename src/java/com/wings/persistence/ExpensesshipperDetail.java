package com.wings.persistence;


public class ExpensesshipperDetail extends Expensesshipper {

    private String descriptionFee;
    private String aliasName;

    public ExpensesshipperDetail() {
        
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
    
}
