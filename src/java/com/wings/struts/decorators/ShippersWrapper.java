/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Shipper;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class ShippersWrapper extends TableDecorator {
                        
    public ShippersWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Shipper shipper = (Shipper)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + shipper.getIdShipper() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + shipper.getIdShipper() + "');\">Delete</a></div> ";
    }

    
}

