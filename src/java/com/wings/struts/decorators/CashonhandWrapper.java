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
import com.wings.persistence.Cashonhand;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class CashonhandWrapper extends TableDecorator {
                        
    public CashonhandWrapper() {        
    }
     
    public String getIdAccountLink() {
        Cashonhand cashonhand = (Cashonhand)getCurrentRowObject();
        return "<div align=\"center\"><a  style=\"cursor: hand;\" onclick=\"GetAccount('" + cashonhand.getIdCashOnHand() + "','" + cashonhand.getIdCashOnHand() + "');\"/>"+cashonhand.getIdCashOnHand()+"</a></div> ";
    }
    public String getLinkAll()
    {
        Cashonhand cashonhand = (Cashonhand)getCurrentRowObject();
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + cashonhand.getIdCashOnHand() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + cashonhand.getIdCashOnHand() + "');\">Delete</a></div> ";
    }

    
}

