package com.wings.persistence;

import java.util.Date;

public class Invoice extends InvoiceKey {
   
    private Integer idJobSheet;
    
    private String invoiceNumber;
    
    private Date invoiceDate;
    
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
    
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
   
    public void setInvoiceNumber(String invoiceNumber) {
        if (invoiceNumber != null) {
            invoiceNumber = invoiceNumber.trim();
        }
        this.invoiceNumber = invoiceNumber;
    }
    
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
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
