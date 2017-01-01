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
import com.wings.persistence.AccountSaldo;
import com.wings.persistence.Transactionacc;
import java.text.DecimalFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class AccountSaldoWrapper extends TableDecorator {
    DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
                        
    public AccountSaldoWrapper() {        
    }
    
    public String getSaldoAkhirTrans() {                
        try {
            AccountSaldo account = (AccountSaldo)getCurrentRowObject();
            return "<div align=\"right\">"+moneyFormat.format(account.getSaldoAkhir().doubleValue())+"</div>";
        } catch (Exception e) {
            return "<div align=\"right\"></div>";
        }                
    }
    
    public String getIdAccountLink() {
        AccountSaldo account = (AccountSaldo)getCurrentRowObject();
        return "<div align=\"center\"><a style=\"cursor: hand;\" onclick=\"GetAccount('" + account.getIdAccount() + "','" + account.getAccountName().replaceAll("'","`") + "');\"/>"+account.getIdAccount()+"</a></div> ";
    }
    public String getLinkAll()
    {
        AccountSaldo account = (AccountSaldo)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + account.getIdAccount() + "', '"+account.getBulan()+"', '"+ account.getTahun() +"');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + account.getIdAccount() + "', '"+account.getBulan()+"', '"+ account.getTahun() +"');\">Delete</a></div> ";
    }

    
}

