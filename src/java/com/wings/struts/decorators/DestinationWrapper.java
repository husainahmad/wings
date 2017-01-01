/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Destination;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class DestinationWrapper extends TableDecorator {
                        
    public DestinationWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Destination destination = (Destination)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + destination.getIdDestination() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + destination.getIdDestination() + "');\">Delete</a></div> ";
    }

    
}

