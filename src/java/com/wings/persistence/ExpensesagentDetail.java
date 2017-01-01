package com.wings.persistence;


public class ExpensesagentDetail extends Expensesagent {

    private String descriptionFee;
    private String aliasName;
    private String category;
    
    public ExpensesagentDetail() {
        
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
