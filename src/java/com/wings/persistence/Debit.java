package com.wings.persistence;

import java.util.Date;

public class Debit extends DebitKey {
  
    private Integer idJobSheet;
  
    private String debitNumber;

    private Date debitDate;

    private String isPayable;
    
    private Integer idIncome;
    
    private Date payableDate;
    
    private Date dueDate;
    
    public Integer getIdJobSheet() {
        return idJobSheet;
    }
  
    public void setIdJobSheet(Integer idJobSheet) {
        this.idJobSheet = idJobSheet;
    }
   
    public String getDebitNumber() {
        return debitNumber;
    }
  
    public void setDebitNumber(String debitNumber) {
        if (debitNumber != null) {
            debitNumber = debitNumber.trim();
        }
        this.debitNumber = debitNumber;
    }
 
    public Date getDebitDate() {
        return debitDate;
    }
    
    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public String getIsPayable() {
        return isPayable;
    }

    public void setIsPayable(String isPayable) {
        this.isPayable = isPayable;
    }

    public Integer getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Integer idIncome) {
        this.idIncome = idIncome;
    }

    public Date getPayableDate() {
        return payableDate;
    }

    public void setPayableDate(Date payableDate) {
        this.payableDate = payableDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
}
