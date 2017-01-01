package com.wings.persistence;


public class AccountSaldo extends AccountKey {

    private String accountName;
    private String category;
    private String type;
    private Double saldoAwal;
    private Double saldoAkhir;
    private Integer bulan;
    private Integer tahun;
    private Double kursrange;
    private String kurs;
   
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
     * @return the bulan
     */
    public Integer getBulan() {
        return bulan;
    }

    /**
     * @param bulan the bulan to set
     */
    public void setBulan(Integer bulan) {
        this.bulan = bulan;
    }

    /**
     * @return the tahun
     */
    public Integer getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }


    /**
     * @return the kurs
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * @param kurs the kurs to set
     */
    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    /**
     * @return the kursrange
     */
    public Double getKursrange() {
        return kursrange;
    }

    /**
     * @param kursrange the kursrange to set
     */
    public void setKursrange(Double kursrange) {
        this.kursrange = kursrange;
    }
}
