/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Tax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class TaxWrapper extends TableDecorator {
                        
    public TaxWrapper() {        
    }
     
     public String getDateTax() {
        Tax tax = (Tax)getCurrentRowObject();    
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(tax.getFakturDate());
        } catch (Exception e) {
            return "";
        }                
    }
     public String getDatePkp() {
        Tax tax = (Tax)getCurrentRowObject();    
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(tax.getPkpDate());
        } catch (Exception e) {
            return "";
        }                
    }
    
    public Double getPpnAsDouble() {
        Tax tax = (Tax)getCurrentRowObject();    
        return new Double(tax.getDpp().doubleValue()*0.10);           
    }
    
    public String getLinkAll()
    {
        Tax tax = (Tax)getCurrentRowObject();   
        
        return "<div align=\"center\">"+
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('4','" + tax.getIdTax() + "');\">Print</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + tax.getIdTax() + "');\">Update</a><!-- | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + tax.getIdTax() + "');\">Delete</a--></div>";
    }

    
}

