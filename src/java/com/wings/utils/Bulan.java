/*
 * Month.java
 *
 * Created on 21 Juni 2007, 5:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

/**
 *
 * @author Administrator
 */
public class Bulan {
    private int monthId;
    private String monthName;
    
    public Bulan(int monthId, String monthName) {
        this.monthId = monthId;
        this.monthName = monthName;
    }    
    
    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
    
}
