package com.wings.persistence;

import java.util.Date;

public class Payment extends PaymentKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.idCostomer
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String idCostomer;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.billTo
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String billTo;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.billToDebit
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String billToDebit;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.invoiceNumber
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String invoiceNumber;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.isInvoice
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String isInvoice;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.paymentDate
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private Date paymentDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.bank
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String bank;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.amount
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private Double amount;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column payment.kurs
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    private String kurs;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.idCostomer
     *
     * @return the value of payment.idCostomer
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getIdCostomer() {
        return idCostomer;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.idCostomer
     *
     * @param idCostomer the value for payment.idCostomer
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setIdCostomer(String idCostomer) {
        if (idCostomer != null) {
            idCostomer = idCostomer.trim();
        }
        this.idCostomer = idCostomer;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.billTo
     *
     * @return the value of payment.billTo
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getBillTo() {
        return billTo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.billTo
     *
     * @param billTo the value for payment.billTo
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setBillTo(String billTo) {
        if (billTo != null) {
            billTo = billTo.trim();
        }
        this.billTo = billTo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.billToDebit
     *
     * @return the value of payment.billToDebit
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getBillToDebit() {
        return billToDebit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.billToDebit
     *
     * @param billToDebit the value for payment.billToDebit
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setBillToDebit(String billToDebit) {
        if (billToDebit != null) {
            billToDebit = billToDebit.trim();
        }
        this.billToDebit = billToDebit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.invoiceNumber
     *
     * @return the value of payment.invoiceNumber
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.invoiceNumber
     *
     * @param invoiceNumber the value for payment.invoiceNumber
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setInvoiceNumber(String invoiceNumber) {
        if (invoiceNumber != null) {
            invoiceNumber = invoiceNumber.trim();
        }
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.isInvoice
     *
     * @return the value of payment.isInvoice
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getIsInvoice() {
        return isInvoice;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.isInvoice
     *
     * @param isInvoice the value for payment.isInvoice
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setIsInvoice(String isInvoice) {
        if (isInvoice != null) {
            isInvoice = isInvoice.trim();
        }
        this.isInvoice = isInvoice;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.paymentDate
     *
     * @return the value of payment.paymentDate
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.paymentDate
     *
     * @param paymentDate the value for payment.paymentDate
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.bank
     *
     * @return the value of payment.bank
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getBank() {
        return bank;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.bank
     *
     * @param bank the value for payment.bank
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setBank(String bank) {
        if (bank != null) {
            bank = bank.trim();
        }
        this.bank = bank;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.amount
     *
     * @return the value of payment.amount
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.amount
     *
     * @param amount the value for payment.amount
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column payment.kurs
     *
     * @return the value of payment.kurs
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column payment.kurs
     *
     * @param kurs the value for payment.kurs
     *
     * @abatorgenerated Tue Sep 02 21:00:49 ICT 2008
     */
    public void setKurs(String kurs) {
        if (kurs != null) {
            kurs = kurs.trim();
        }
        this.kurs = kurs;
    }
}
