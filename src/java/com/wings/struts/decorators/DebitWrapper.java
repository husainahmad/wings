/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.DebitDetail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class DebitWrapper extends TableDecorator {
                        
    public DebitWrapper() {        
    }
     
     public String getDateDebit() {
        DebitDetail debitDetail = (DebitDetail)getCurrentRowObject();    
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(debitDetail.getDebitDate());
        } catch (Exception e) {
            return "";
        }                
    }
    
    public String getLinkAll()
    {
        DebitDetail debitDetail = (DebitDetail)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('4','" + debitDetail.getIdDebit() + "');\">Print</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + debitDetail.getIdDebit() + "');\">Print (USD)</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + debitDetail.getIdDebit() + "');\">Delete</a></div>";
    }

    public String getLinkPayable()
    {
        
        DebitDetail debitDetail = (DebitDetail)getCurrentRowObject();
        //String rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" + debitDetail.getIdDebit() + "');\">Outstanding</a></div>";
        String rtn = "<div align=\"center\">Outstanding</div>";
        if (debitDetail.getIsPayable()!=null) {
            if (debitDetail.getIsPayable().equalsIgnoreCase("P")) {
                rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + debitDetail.getIdDebit() + "');\">Paid</a></div>";
            } else {
                //rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" + debitDetail.getIdDebit() + "');\">Outstanding</a></div>";
                rtn = "<div align=\"center\">Outstanding</div>";
            }    
        }   
        return rtn;
    }
}

