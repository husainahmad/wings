/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.JobsheetDetail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class JobsheetsoWrapper extends TableDecorator {
                        
    public JobsheetsoWrapper() {        
    }
    public String getDateJobsheet() {
        JobsheetDetail jobsheet = (JobsheetDetail)getCurrentRowObject(); 
        DateFormat localformat = DateFormat.getDateInstance();
        DateFormat formatINA = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatINA.format(jobsheet.getShippeddate());
        } catch (Exception e) {
            return "";
        }                
    }
    public String getInvoiceStatus() {
        JobsheetDetail jobsheet = (JobsheetDetail)getCurrentRowObject();
        if (jobsheet.getInvoiceStatus()==null) {
             return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEditInvoice('0','" + jobsheet.getIdJobSheet() + "');\">Create Invoice</a></div> ";
        } else {
            return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEditInvoice('1','" + jobsheet.getIdJobSheet() + "');\">Invoiced</a></div> ";
        }        
    }
    public String getDebitStatus() {
        JobsheetDetail jobsheet = (JobsheetDetail)getCurrentRowObject();
        if (jobsheet.getInvoiceStatus()==null) {
             return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEditDerbit('0','" + jobsheet.getIdJobSheet() + "');\">Create Debit</a></div> ";
        } else {
            return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEditDebit('1','" + jobsheet.getIdJobSheet() + "');\">Debited</a></div> ";
        }        
    }
    public String getLinkAll()
    {
        JobsheetDetail jobsheet = (JobsheetDetail)getCurrentRowObject();
        
        return "<div align=\"center\" ><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_edit.png\" alt=\"Edit\"/></a> " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('5','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_add_new.png\" alt=\"As New\"/></a> " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('6','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_add_copy.png\" alt=\"Copy\"/></a> " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('4','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_print.png\" alt=\"Print\"/></a> " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('7','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_print_header.png\" alt=\"Print Shipping Advice\"/></a> " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + jobsheet.getIdJobSheet() + "');\"><img src=\"../Images/icon_delete.png\" alt=\"Delete\"/></a></div>";
    }

    
}

