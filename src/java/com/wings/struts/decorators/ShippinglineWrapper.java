/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Shippingline;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class ShippinglineWrapper extends TableDecorator {
                        
    public ShippinglineWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Shippingline shippingline = (Shippingline)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + shippingline.getIdShippingLine() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + shippingline.getIdShippingLine() + "');\">Delete</a></div> ";
    }

    
}

