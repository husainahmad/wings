/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Account;
import com.wings.persistence.Kursdollar;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class KursdollarWrapper extends TableDecorator {
                        
    public KursdollarWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Kursdollar kursdollar = (Kursdollar)getCurrentRowObject();
        //<a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + kursdollar.getIdKursDollar() + "');\">Edit</a> | 
        return "<div align=\"center\">" +
                "<a class=\"link1\" href=\"deleteKursdollar.do?idKursDollar=" + kursdollar.getIdKursDollar() + "\");\">Delete</a></div> ";
    }

    
}

