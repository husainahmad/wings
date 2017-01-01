package com.wings.persistence;

import java.util.Date;

public class Tax extends TaxKey {
    
    private String idJobSheet;
    
    private String noFaktur;
    
    private Date fakturDate;
    
    private Double dpp;
    
    private Double ppn;
    
    private Date pkpDate;
    
    public String getIdJobSheet() {
        return idJobSheet;
    }
    
    public void setIdJobSheet(String idJobSheet) {
        if (idJobSheet != null) {
            idJobSheet = idJobSheet.trim();
        }
        this.idJobSheet = idJobSheet;
    }
    
    public String getNoFaktur() {
        return noFaktur;
    }
    
    public void setNoFaktur(String noFaktur) {
        if (noFaktur != null) {
            noFaktur = noFaktur.trim();
        }
        this.noFaktur = noFaktur;
    }
    
    public Date getFakturDate() {
        return fakturDate;
    }
    
    public void setFakturDate(Date fakturDate) {
        this.fakturDate = fakturDate;
    }
    
    public Double getDpp() {
        return dpp;
    }
    
    public void setDpp(Double dpp) {
        this.dpp = dpp;
    }
    
    public Double getPpn() {
        return ppn;
    }
    
    public void setPpn(Double ppn) {
        this.ppn = ppn;
    }

    public Date getPkpDate() {
        return pkpDate;
    }

    public void setPkpDate(Date pkpDate) {
        this.pkpDate = pkpDate;
    }
}