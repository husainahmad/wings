/*
 * GenerateDate.java
 *
 * Created on May 30, 2008, 12:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmad husain
 */
public class GenerateDate {
    
    /** Creates a new instance of GenerateDate */
    public GenerateDate() {
    }
    public List getYears(int iyear) {       
           List yearList = new ArrayList();
           iyear+=-20;
           for (int i = 0; i < 40; i++) {
               Year year = new Year();
               year.setYear(iyear);
               yearList.add(year);
               iyear++;
           }
           return yearList;
       }
    
    public List getTahun(int iyear) {       
           List yearList = new ArrayList();
           iyear+=-20;
           for (int i = 0; i < 40; i++) {
               Tahun year = new Tahun();
               year.setTahun(iyear);
               yearList.add(year);
               iyear++;
           }
           return yearList;
       }
        
       public List getMonths() {       
           List monthList = new ArrayList();       
           monthList.add(new Month(1, "January"));
           monthList.add(new Month(2, "February"));
           monthList.add(new Month(3, "March"));
           monthList.add(new Month(4, "April"));
           monthList.add(new Month(5, "Mei"));
           monthList.add(new Month(6, "June"));
           monthList.add(new Month(7, "July"));
           monthList.add(new Month(8, "August"));
           monthList.add(new Month(9, "September"));
           monthList.add(new Month(10, "October"));
           monthList.add(new Month(11, "November"));
           monthList.add(new Month(12, "December"));       
           return monthList;
       }
       
       public List getBulans() {       
           List monthList = new ArrayList();       
           monthList.add(new Bulan(1, "January"));
           monthList.add(new Bulan(2, "February"));
           monthList.add(new Bulan(3, "March"));
           monthList.add(new Bulan(4, "April"));
           monthList.add(new Bulan(5, "Mei"));
           monthList.add(new Bulan(6, "June"));
           monthList.add(new Bulan(7, "July"));
           monthList.add(new Bulan(8, "August"));
           monthList.add(new Bulan(9, "September"));
           monthList.add(new Bulan(10, "October"));
           monthList.add(new Bulan(11, "November"));
           monthList.add(new Bulan(12, "December"));       
           return monthList;
       }
        
       
}
