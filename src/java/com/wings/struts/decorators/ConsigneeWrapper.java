/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Consignee;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class ConsigneeWrapper extends TableDecorator {
                        
    public ConsigneeWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Consignee consignee = (Consignee)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + consignee.getIdConsignee() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + consignee.getIdConsignee() + "');\">Delete</a></div> ";
    }

    
}

