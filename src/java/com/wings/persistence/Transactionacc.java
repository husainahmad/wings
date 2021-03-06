package com.wings.persistence;

import java.util.Date;

public class Transactionacc extends TransactionaccKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.noBatch
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String noBatch;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.noUrut
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String noUrut;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.batchDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String batchDesc;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.transactionDate
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private Date transactionDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.noVoucher
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String noVoucher;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.voucherDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String voucherDesc;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.idAccount
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String idAccount;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.description
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String description;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.kurs
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String kurs;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.debit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private Double debit;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.kredit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private Double kredit;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.jobNo
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private String jobNo;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column transactionacc.tglTutupBuku
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    private Date tglTutupBuku;

    private Integer inUrut;
    
    private Double kursValue;
    private Double saldoAkhir;
    private String groupid;
    
    public String getNoBatch() {
        return noBatch;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.noBatch
     *
     * @param noBatch the value for transactionacc.noBatch
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setNoBatch(String noBatch) {
        this.noBatch = noBatch;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.noUrut
     *
     * @return the value of transactionacc.noUrut
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getNoUrut() {
        return noUrut;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.noUrut
     *
     * @param noUrut the value for transactionacc.noUrut
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setNoUrut(String noUrut) {
        this.noUrut = noUrut;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.batchDesc
     *
     * @return the value of transactionacc.batchDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getBatchDesc() {
        return batchDesc;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.batchDesc
     *
     * @param batchDesc the value for transactionacc.batchDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setBatchDesc(String batchDesc) {
        if (batchDesc != null) {
            batchDesc = batchDesc.trim();
        }
        this.batchDesc = batchDesc;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.transactionDate
     *
     * @return the value of transactionacc.transactionDate
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.transactionDate
     *
     * @param transactionDate the value for transactionacc.transactionDate
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.voucherDesc
     *
     * @return the value of transactionacc.voucherDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getVoucherDesc() {
        return voucherDesc;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.voucherDesc
     *
     * @param voucherDesc the value for transactionacc.voucherDesc
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setVoucherDesc(String voucherDesc) {
        if (voucherDesc != null) {
            voucherDesc = voucherDesc.trim();
        }
        this.voucherDesc = voucherDesc;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.idAccount
     *
     * @return the value of transactionacc.idAccount
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getIdAccount() {
        return idAccount;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.idAccount
     *
     * @param idAccount the value for transactionacc.idAccount
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.description
     *
     * @return the value of transactionacc.description
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.description
     *
     * @param description the value for transactionacc.description
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setDescription(String description) {
        if (description != null) {
            description = description.trim();
        }
        this.description = description;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.kurs
     *
     * @return the value of transactionacc.kurs
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.kurs
     *
     * @param kurs the value for transactionacc.kurs
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setKurs(String kurs) {
        if (kurs != null) {
            kurs = kurs.trim();
        }
        this.kurs = kurs;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.debit
     *
     * @return the value of transactionacc.debit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public Double getDebit() {
        return debit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.debit
     *
     * @param debit the value for transactionacc.debit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setDebit(Double debit) {
        this.debit = debit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.kredit
     *
     * @return the value of transactionacc.kredit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public Double getKredit() {
        return kredit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.kredit
     *
     * @param kredit the value for transactionacc.kredit
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setKredit(Double kredit) {
        this.kredit = kredit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.jobNo
     *
     * @return the value of transactionacc.jobNo
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public String getJobNo() {
        return jobNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.jobNo
     *
     * @param jobNo the value for transactionacc.jobNo
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setJobNo(String jobNo) {
        if (jobNo != null) {
            jobNo = jobNo.trim();
        }
        this.jobNo = jobNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column transactionacc.tglTutupBuku
     *
     * @return the value of transactionacc.tglTutupBuku
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public Date getTglTutupBuku() {
        return tglTutupBuku;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column transactionacc.tglTutupBuku
     *
     * @param tglTutupBuku the value for transactionacc.tglTutupBuku
     *
     * @abatorgenerated Thu Jul 03 21:27:57 ICT 2008
     */
    public void setTglTutupBuku(Date tglTutupBuku) {
        this.tglTutupBuku = tglTutupBuku;
    }

    public Integer getInUrut() {
        return inUrut;
    }

    public void setInUrut(Integer inUrut) {
        this.inUrut = inUrut;
    }

    public Double getKursValue() {
        return kursValue;
    }

    public void setKursValue(Double kursValue) {
        this.kursValue = kursValue;
    }

    public String getNoVoucher() {
        return noVoucher;
    }

    public void setNoVoucher(String noVoucher) {
        this.noVoucher = noVoucher;
    }

    /**
     * @return the saldoAkhir
     */
    public Double getSaldoAkhir() {
        return saldoAkhir;
    }

    /**
     * @param saldoAkhir the saldoAkhir to set
     */
    public void setSaldoAkhir(Double saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    /**
     * @return the groupid
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
   
}
