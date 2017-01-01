package com.wings.persistence;

import java.util.Date;

public class Income extends IncomeKey {

   
    private Double revenu;

    
    private String refId;

    
    private Date statusDate;

    private String kurs;
    
    public Double getRevenu() {
        return revenu;
    }
    
    public void setRevenu(Double revenu) {
        this.revenu = revenu;
    }
    
    public String getRefId() {
        return refId;
    }
    
    public void setRefId(String refId) {
        if (refId != null) {
            refId = refId.trim();
        }
        this.refId = refId;
    }
   
    public Date getStatusDate() {
        return statusDate;
    }
   
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }
}
