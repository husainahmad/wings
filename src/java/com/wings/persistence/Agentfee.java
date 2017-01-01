package com.wings.persistence;


public class Agentfee extends AgentfeeKey {

    
    private String description;
    private String isAI;
    private String isAO;
    private String isSI;
    private String isSO;    
    private String idAccountAI;
    private String idAccountAO;
    private String idAccountSI;
    private String idAccountSO;
    private String idAccountCostAI;
    private String idAccountCostAO;
    private String idAccountCostSI;
    private String idAccountCostSO;
    private String category;
    private String jobType;
    private Integer type;
    
    
    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        if (description != null) {
            description = description.trim();
        }
        this.description = description;
    }
    
    private String isTax;

    public String getIsTax() {
        return isTax;
    }

    public void setIsTax(String isTax) {
        this.isTax = isTax;
    }
    private String aliasName;

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }        

    public String getIdAccountAI() {
        return idAccountAI;
    }

    public void setIdAccountAI(String idAccountAI) {
        this.idAccountAI = idAccountAI;
    }

    public String getIdAccountAO() {
        return idAccountAO;
    }

    public void setIdAccountAO(String idAccountAO) {
        this.idAccountAO = idAccountAO;
    }

    public String getIdAccountSI() {
        return idAccountSI;
    }

    public void setIdAccountSI(String idAccountSI) {
        this.idAccountSI = idAccountSI;
    }

    public String getIdAccountSO() {
        return idAccountSO;
    }

    public void setIdAccountSO(String idAccountSO) {
        this.idAccountSO = idAccountSO;
    }        

    public String getIdAccountCostAI() {
        return idAccountCostAI;
    }

    public void setIdAccountCostAI(String idAccountCostAI) {
        this.idAccountCostAI = idAccountCostAI;
    }

    public String getIdAccountCostAO() {
        return idAccountCostAO;
    }

    public void setIdAccountCostAO(String idAccountCostAO) {
        this.idAccountCostAO = idAccountCostAO;
    }

    public String getIdAccountCostSI() {
        return idAccountCostSI;
    }

    public void setIdAccountCostSI(String idAccountCostSI) {
        this.idAccountCostSI = idAccountCostSI;
    }

    public String getIdAccountCostSO() {
        return idAccountCostSO;
    }

    public void setIdAccountCostSO(String idAccountCostSO) {
        this.idAccountCostSO = idAccountCostSO;
    }

    public String getIsAI() {
        return isAI;
    }

    public void setIsAI(String isAI) {
        this.isAI = isAI;
    }

    public String getIsAO() {
        return isAO;
    }

    public void setIsAO(String isAO) {
        this.isAO = isAO;
    }

    public String getIsSI() {
        return isSI;
    }

    public void setIsSI(String isSI) {
        this.isSI = isSI;
    }

    public String getIsSO() {
        return isSO;
    }

    public void setIsSO(String isSO) {
        this.isSO = isSO;
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

    /**
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * @param jobType the jobType to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
