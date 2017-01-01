/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.InvoiceDetail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class InvoiceWrapper extends TableDecorator {
                        
    public InvoiceWrapper() {        
    }
     
     public String getDateInvoice() {
        InvoiceDetail invoice = (InvoiceDetail)getCurrentRowObject();    
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(invoice.getInvoiceDate());
        } catch (Exception e) {
            return "";
        }                
    }
    
    public String getLinkAll()
    {
        InvoiceDetail invoice = (InvoiceDetail)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('4','" + invoice.getIdInvoice() + "');\">Print</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + invoice.getIdInvoice() + "');\">Print (USD)</a> |" +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + invoice.getIdInvoice() + "');\">Delete</a></div>";
    }

    public String getLinkPayable()
    {
        
        InvoiceDetail invoice = (InvoiceDetail)getCurrentRowObject();
        //String rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" +invoice.getIdInvoice() + "');\">Outstanding</a>";
        String rtn = "<div align=\"center\">Outstanding</div>";
        if (invoice.getIsPayable()!=null) {
            if (invoice.getIsPayable().equalsIgnoreCase("P")) {
                rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + invoice.getIdInvoice() + "');\">Paid</a>";
            } else {
                //rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" + invoice.getIdInvoice() + "');\">Outstanding</a></div>";
                rtn = "<div align=\"center\">Outstanding</div>";
            }    
        }   
        return rtn;
    }
}

