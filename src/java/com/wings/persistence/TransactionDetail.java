/*
 * TransactionDetail.java
 *
 * Created on July 15, 2008, 9:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.persistence;

/**
 *
 * @author Ahmad Husain
 */
public class TransactionDetail extends Transactionacc {
    private String accountGroup;
    private String accountSuperGroup;
    private Double saldoAwal;
    private String accountModel;
    public TransactionDetail() {
    }

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }

    public Double getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(Double saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public String getAccountSuperGroup() {
        return accountSuperGroup;
    }

    public void setAccountSuperGroup(String accountSuperGroup) {
        this.accountSuperGroup = accountSuperGroup;
    }

    public String getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(String accountModel) {
        this.accountModel = accountModel;
    }
    
}
