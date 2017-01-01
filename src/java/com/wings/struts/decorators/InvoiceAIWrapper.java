/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.InvoiceAIDetail;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class InvoiceAIWrapper extends TableDecorator {
                        
    public InvoiceAIWrapper() {        
    }
     
     public String getDateInvoice() {
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();    
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(invoice.getDDate());
        } catch (Exception e) {
            return "";
        }                
    }
    
    public String getLinkAll()
    {
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('4','" + invoice.getIdInvoice() + "');\">Print</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + invoice.getIdInvoice() + "');\">Print (USD)</a> |" +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + invoice.getIdInvoice() + "');\">Delete</a></div>";
    }

    public String getFormatTotalBillingIDR()
    {
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();
        DecimalFormat moneyFormat = new DecimalFormat("###,###,###");
        return "<div align=\"right\">"+moneyFormat.format(invoice.getTotalBillingIDR())+"</div>";
    }
    
    public String getFormatTotalBillingUSD()
    {
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();
        DecimalFormat moneyFormat = new DecimalFormat("###,###.##");
        return "<div align=\"right\">"+moneyFormat.format(invoice.getTotalBillingUSD())+"</div>";
    }
    
    public String getPayed()
    {
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();
        String pay = "Outstanding";
        if (invoice.getIsPayable()!=null) {
            if (invoice.getIsPayable().equalsIgnoreCase("P")) {
                pay = "Paid";
            }
        }        
        return pay;
    }
    
    public String getLinkPayable()
    {
        
        InvoiceAIDetail invoice = (InvoiceAIDetail)getCurrentRowObject();
        String rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" +invoice.getIdInvoice() + "');\">Outstanding</a>";
        if (invoice.getIsPayable()!=null) {
            if (invoice.getIsPayable().equalsIgnoreCase("P")) {
                rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + invoice.getIdInvoice() + "');\">Paid</a>";
            } else {
                rtn = "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" + invoice.getIdInvoice() + "');\">Outstanding</a></div>";
            }    
        }   
        return rtn;
    }
}

