/*
 * SHRSummaryDataSource.java
 *
 * Created on 12 Juni 2007, 1:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.reports.datasource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Administrator
 */
public class TaxReportDataSource implements JRDataSource
{
    /**
     *
     */
    private Object[][] data = null;

    private int index = -1;

    public TaxReportDataSource(Object[][] data)
    {
        this.data = data;
    }

    public boolean next() throws JRException
    {
        index++;

        return (index < data.length);
    }

    public Object getFieldValue(JRField field) throws JRException
    {
        Object value = null;

        String fieldName = field.getName();

        if ("no".equals(fieldName))
        {
                value = data[index][0];
        }
        else if ("nama".equals(fieldName))
        {
                value = data[index][1];
        }
        else if ("npwp".equals(fieldName))
        {
                value = data[index][2];
        }
        else if ("noInvoice".equals(fieldName))
        {
                value = data[index][3];
        }        
        else if ("tglInvoice".equals(fieldName))
        {
                value = data[index][4];
        }	
        else if ("jobNo".equals(fieldName))
        {
                value = data[index][5];
        }
        else if ("volume".equals(fieldName))
        {
                value = data[index][6];
        }
         else if ("tglFaktur".equals(fieldName))
        {
                value = data[index][7];
        }
        else if ("dpp".equals(fieldName))
        {
                value = data[index][8];
        }
        else if ("noFaktur".equals(fieldName))
        {
                value = data[index][9];
        }        
        return value;
    }


}

