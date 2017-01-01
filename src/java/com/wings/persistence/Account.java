package com.wings.persistence;


public class Account extends AccountKey {

    private String accountName;

    private String category;

    private String type;

    private Double saldoAwal;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName != null) {
            accountName = accountName.trim();
        }
        this.accountName = accountName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null) {
            category = category.trim();
        }
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null) {
            type = type.trim();
        }
        this.type = type;
    }

    public Double getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoAwal(Double saldoAwal) {
        this.saldoAwal = saldoAwal;
    }
}
