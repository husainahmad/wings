package com.wings.persistence;

import java.util.Date;

public class Debitkredit extends DebitkreditKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column debitkredit.idDebit
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    private Integer idDebit;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column debitkredit.value
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    private Double value;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column debitkredit.kurs
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    private String kurs;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column debitkredit.kreditDate
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    private Date kreditDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column debitkredit.number
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    private Integer number;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column debitkredit.idDebit
     *
     * @return the value of debitkredit.idDebit
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public Integer getIdDebit() {
        return idDebit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column debitkredit.idDebit
     *
     * @param idDebit the value for debitkredit.idDebit
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public void setIdDebit(Integer idDebit) {
        this.idDebit = idDebit;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column debitkredit.value
     *
     * @return the value of debitkredit.value
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public Double getValue() {
        return value;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column debitkredit.value
     *
     * @param value the value for debitkredit.value
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column debitkredit.kurs
     *
     * @return the value of debitkredit.kurs
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column debitkredit.kurs
     *
     * @param kurs the value for debitkredit.kurs
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public void setKurs(String kurs) {
        if (kurs != null) {
            kurs = kurs.trim();
        }
        this.kurs = kurs;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column debitkredit.kreditDate
     *
     * @return the value of debitkredit.kreditDate
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public Date getKreditDate() {
        return kreditDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column debitkredit.kreditDate
     *
     * @param kreditDate the value for debitkredit.kreditDate
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public void setKreditDate(Date kreditDate) {
        this.kreditDate = kreditDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column debitkredit.number
     *
     * @return the value of debitkredit.number
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column debitkredit.number
     *
     * @param number the value for debitkredit.number
     *
     * @abatorgenerated Tue Jun 03 22:44:21 ICT 2008
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}
