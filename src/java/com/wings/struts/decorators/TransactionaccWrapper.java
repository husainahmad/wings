/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Transactionacc;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class TransactionaccWrapper extends TableDecorator {
    DecimalFormat moneyFormat = new DecimalFormat("#,###,###.##");
                        
    public TransactionaccWrapper() {        
    }
     
    public String getDateTrans() {
        
        try {
            Transactionacc transactionacc = (Transactionacc)getCurrentRowObject();
            DateFormat localformat = DateFormat.getDateInstance();
            DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
            return formatINA.format(transactionacc.getTransactionDate());
        } catch (Exception e) {
            return "";
        }                
    }
    
    public String getDebitTrans() {                
        try {
            Transactionacc transactionacc = (Transactionacc)getCurrentRowObject();
            return "<div align=\"right\">"+moneyFormat.format(transactionacc.getDebit().doubleValue())+"</div>";
        } catch (Exception e) {
            return "<div align=\"right\"></div>";
        }                
    }
    
    public String getKreditTrans() {                
        try {
            Transactionacc transactionacc = (Transactionacc)getCurrentRowObject();
            return "<div align=\"right\">"+moneyFormat.format(transactionacc.getKredit().doubleValue())+"</div>";
        } catch (Exception e) {
            return "<div align=\"right\"></div>";
        }                
    }
    
    public String getLinkAll()
    {
        Transactionacc transactionacc = (Transactionacc)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + transactionacc.getIdTransactionAcc() + "','"+transactionacc.getGroupid()+"');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + transactionacc.getIdTransactionAcc() + "','"+transactionacc.getGroupid()+"');\">Delete</a></div> ";
    }
    
    public String getLinkEdit()
    {
        Transactionacc transactionacc = (Transactionacc)getCurrentRowObject();
        
        return "<div align=\"center\">" +
                "<a class=\"link1\" href=\"findTransactionacc.do?idTransactionAcc=" + transactionacc.getIdTransactionAcc() + "\");\">Edit</a></div>";
    }
    
}

