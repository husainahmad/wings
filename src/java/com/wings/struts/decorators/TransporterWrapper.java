/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Transporter;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class TransporterWrapper extends TableDecorator {
                        
    public TransporterWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Transporter transporter = (Transporter)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + transporter.getIdTransporter() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + transporter.getIdTransporter() + "');\">Delete</a></div> ";
    }

    
}

