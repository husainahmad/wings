package com.wings.persistence;


public class Expensesshipper extends ExpensesshipperKey {

    
    private Integer idJobSheet;

    
    private Integer idShipperFee;

    
    private Double charge;

    
    private String kurs;
    
    private String description;
    
    private Double kursValue;
    private String descriptionInvoice;
    private Double oriKurs;
    private Double oriWeight;
    private Integer isTax;
    private Integer isVat;
    private Double totalTax;
    private Double totalVat;
    private Integer isTax2;
    private Double totalTax2;
    public Integer getIdJobSheet() {
        return idJobSheet;
    }

    
    public void setIdJobSheet(Integer idJobSheet) {
        this.idJobSheet = idJobSheet;
    }    

    
    public Double getCharge() {
        return charge;
    }

    
    public void setCharge(Double charge) {
        this.charge = charge;
    }

    
    public String getKurs() {
        return kurs;
    }

   
    public void setKurs(String kurs) {
        if (kurs != null) {
            kurs = kurs.trim();
        }
        this.kurs = kurs;
    }

    public Integer getIdShipperFee() {
        return idShipperFee;
    }

    public void setIdShipperFee(Integer idShipperFee) {
        this.idShipperFee = idShipperFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getKursValue() {
        return kursValue;
    }

    public void setKursValue(Double kursValue) {
        this.kursValue = kursValue;
    }

    public String getDescriptionInvoice() {
        return descriptionInvoice;
    }

    public void setDescriptionInvoice(String descriptionInvoice) {
        this.descriptionInvoice = descriptionInvoice;
    }

    public Double getOriKurs() {
        return oriKurs;
    }

    public void setOriKurs(Double oriKurs) {
        this.oriKurs = oriKurs;
    }

    public Double getOriWeight() {
        return oriWeight;
    }

    public void setOriWeight(Double oriWeight) {
        this.oriWeight = oriWeight;
    }

    /**
     * @return the isTax
     */
    public Integer getIsTax() {
        return isTax;
    }

    /**
     * @param isTax the isTax to set
     */
    public void setIsTax(Integer isTax) {
        this.isTax = isTax;
    }

    /**
     * @return the isVat
     */
    public Integer getIsVat() {
        return isVat;
    }

    /**
     * @param isVat the isVat to set
     */
    public void setIsVat(Integer isVat) {
        this.isVat = isVat;
    }

    /**
     * @return the totalTax
     */
    public Double getTotalTax() {
        return totalTax;
    }

    /**
     * @param totalTax the totalTax to set
     */
    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * @return the totalVat
     */
    public Double getTotalVat() {
        return totalVat;
    }

    /**
     * @param totalVat the totalVat to set
     */
    public void setTotalVat(Double totalVat) {
        this.totalVat = totalVat;
    }

    /**
     * @return the isTax2
     */
    public Integer getIsTax2() {
        return isTax2;
    }

    /**
     * @param isTax2 the isTax2 to set
     */
    public void setIsTax2(Integer isTax2) {
        this.isTax2 = isTax2;
    }

    /**
     * @return the totalTax2
     */
    public Double getTotalTax2() {
        return totalTax2;
    }

    /**
     * @param totalTax2 the totalTax2 to set
     */
    public void setTotalTax2(Double totalTax2) {
        this.totalTax2 = totalTax2;
    }
}
