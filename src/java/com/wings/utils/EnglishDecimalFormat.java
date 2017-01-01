/*
 * EnglishDecimalFormat.java
 *
 * Created on July 5, 2008, 9:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import com.wings.persistence.JobsheetDetail;
import com.wings.web.struts.forms.DateSelection;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.josql.Query;
import org.josql.QueryResults;

/**
 *
 * @author Ahmad Husain
 */
public class EnglishDecimalFormat {
  private static final String[] majorNames = {
    "",
    " thousand",
    " million",
    " billion",
    " trillion",
    " quadrillion",
    " quintillion"
    };

  private static final String[] tensNames = {
    "",
    " ten",
    " twenty",
    " thirty",
    " fourty",
    " fifty",
    " sixty",
    " seventy",
    " eighty",
    " ninety"
    };

  private static final String[] numNames = {
    "",
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
    };

 private String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
        soFar = numNames[number % 100];
        number /= 100;
       }
    else {
        soFar = numNames[number % 10];
        number /= 10;

        soFar = tensNames[number % 10] + soFar;
        number /= 10;
       }
    if (number == 0) return soFar;
    return numNames[number] + " hundred" + soFar;
}

public String convert(int number) {
    /* special case */
    if (number == 0) { return "zero"; }

    String prefix = "";

    if (number < 0) {
        number = -number;
        prefix = "negative";
      }

    String soFar = "";
    int place = 0;

    do {
      int n = number % 1000;
      if (n != 0){
         String s = convertLessThanOneThousand(n);
         soFar = s + majorNames[place] + soFar;
        }
      place++;
      number /= 1000;
      } while (number > 0);
      
    return (prefix + soFar).trim();
}

public static void main(String[] args) {
    EnglishDecimalFormat f = new EnglishDecimalFormat();
    
    System.out.println("*** " + f.convert(0));
    System.out.println("*** " + f.convert(1));
    System.out.println(StringUtils.leftPad("11", 2, "0"));
    System.out.println("*** " + f.convert(16));
    System.out.println("*** " + f.convert(100));
    System.out.println("*** " + f.convert(118));
    System.out.println("*** " + f.convert(200));
    System.out.println("*** " + f.convert(219));
    System.out.println("*** " + f.convert(800));
    System.out.println("*** " + f.convert(801));
    System.out.println("*** " + f.convert(1316));
    System.out.println("*** " + f.convert(1000000));
    System.out.println("*** " + f.convert(2000000));
    System.out.println("*** " + f.convert(3000200));
    System.out.println("*** " + f.convert(700000));
    System.out.println("*** " + f.convert(9000000));
    System.out.println("*** " + f.convert(123456789));
    System.out.println("*** " + f.convert(-45));
    DecimalFormat moneyFormat = new DecimalFormat("###.##");
    String tttt = moneyFormat.format(12435.40);
    Float num = new Float(tttt) ;
    long ll = num.longValue();
    Double doo = new Double(124.40);
    int dollars = (int)Math.floor(124.40) ;
    double dddd = num.doubleValue();
    double d2 = num.doubleValue() - dollars;
    double dd = (double)Math.round(d2);
    String dt = String.valueOf(dddd).replace('.',':');//.replaceAll(",",":");
    
    String[] a = dt.replace('.',':').split(":");
    String a1 = a[0];
    String a2 = a[1];
    int cent = 0;
    
    try {
        double dol = (double)Math.round(new Double(a2).doubleValue()); 
        cent = Integer.parseInt(a2+"0");
    } catch (Exception e) {
        
    }
    int ggg = (int)((num.doubleValue() - dollars) * 100);
    cent = (int) Math.round((num.doubleValue() - dollars ) * 100.0f)  ;

        String s = "$ " + f.convert( dollars ) + " and " 
            + f.convert( cent ) + " cents" ;
            System.out.println(s);
            
    /*
    *** zero
    *** one
    *** sixteen
    *** one hundred
    *** one hundred eighteen
    *** two hundred
    *** two hundred nineteen
    *** eight hundred
    *** eight hundred one
    *** one thousand three hundred sixteen
    *** one million
    *** two million
    *** three million two hundred
    *** seven hundred thousand
    *** nine million
    *** one hundred twenty three million four hundred 
    **                fifty six thousand seven hundred eighty nine
    *** negative fourty five
    */
            SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");        
            DateSelection ds = new DateSelection();
        
        try {
             ds.setFrom(new java.sql.Timestamp(FORMAT.parse("01/08/2008" + " 00:00").getTime()));               
        } catch (ParseException pe) {
             ds.setFrom(new java.sql.Timestamp(new Date().getTime()));  
        }
        try {
             ds.setTo(new java.sql.Timestamp(FORMAT.parse("15/08/2008" + " 23:59").getTime()));               
        } catch (ParseException pe) {
             ds.setTo(new java.sql.Timestamp(new Date().getTime()));  
        }
        
        List globalList = null;
        //globalList = com.wings.adapter.StrutsJobsheetDelegate.selectReportMonthlySalesAI(ds);  
        
        try {
            Query q = new Query ();            
            q.parse ("SELECT distinct jobNo FROM com.wings.persistence.JobsheetDetail");            
            QueryResults qr = q.execute (globalList);            
            List res = qr.getResults ();
            List distinctList = new ArrayList();
            JobsheetDetail jobsheetDetail = null;
            for (int i = 0; i < res.size (); i++)
            {
                jobsheetDetail = (JobsheetDetail)res.get(i);
                distinctList.add(jobsheetDetail);
            }
            
        } catch (Exception e) {            
        }
    }
}
