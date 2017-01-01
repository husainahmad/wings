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
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class AccountWrapper extends TableDecorator {
                        
    public AccountWrapper() {        
    }
     
    public String getIdAccountLink() {
        Account account = (Account)getCurrentRowObject();
        return "<div align=\"center\"><a  style=\"cursor: hand;\" onclick=\"GetAccount('" + account.getIdAccount() + "','" + account.getAccountName().replaceAll("'","`") + "');\"/>"+account.getIdAccount()+"</a></div> ";
    }
    public String getLinkAll()
    {
        Account account = (Account)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + account.getIdAccount() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + account.getIdAccount() + "');\">Delete</a></div> ";
    }

    
}

