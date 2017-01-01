/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Perkiraan;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class PerkiraanWrapper extends TableDecorator {
                        
    public PerkiraanWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Perkiraan perkiraan = (Perkiraan)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + perkiraan.getIdPerkiraan() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"deletePerkiraan.do?idPerkiraan=" + perkiraan.getIdPerkiraan() + "\");\">Delete</a></div> ";
    }

    
}

