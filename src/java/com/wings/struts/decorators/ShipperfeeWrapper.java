/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Shipperfee;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class ShipperfeeWrapper extends TableDecorator {
                        
    public ShipperfeeWrapper() {        
    }
     
    public String getPajak() {
        Shipperfee shipperfee = (Shipperfee)getCurrentRowObject();
        if (shipperfee.getIsTax().equals("1")) {
            return "Tax";
        } else {
            return "Non Tax";
        }
    }
    
    public String getLinkAll()
    {
        Shipperfee shipperfee = (Shipperfee)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + shipperfee.getIdShipperFee() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + shipperfee.getIdShipperFee() + "');\">Delete</a></div>";
    }
    
}

