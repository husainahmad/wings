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
public class MonthlySalaryAODataSource implements JRDataSource
{

    private Object[][] data = null;
    private int index = -1;

    public MonthlySalaryAODataSource(Object[][] data)
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

        if ("shippingDate".equals(fieldName))
        {
                value = data[index][0];
        }
        else if ("customer".equals(fieldName))
        {
                value = data[index][1];
        }
        else if ("invoiceNo".equals(fieldName))
        {
                value = data[index][2];
        }
        else if ("jobNo".equals(fieldName))
        {
                value = data[index][3];
        }        
        else if ("MAWB".equals(fieldName))
        {
                value = data[index][4];
        }	
        else if ("dest".equals(fieldName))
        {
                value = data[index][5];
        }
        else if ("gwt".equals(fieldName))
        {
                value = data[index][6];
        }
        else if ("vwt".equals(fieldName))
        {
                value = data[index][7];
        }
        else if ("incomingIDR".equals(fieldName))
        {
                value = data[index][8];
        }
        else if ("incomingUSD".equals(fieldName))
        {
                value = data[index][9];
        }
        else if ("outgoingIDR".equals(fieldName))
        {
                value = data[index][10];
        }
        else if ("outgoingUSD".equals(fieldName))
        {
                value = data[index][11];
        }
        else if ("refundIDR".equals(fieldName))
        {
                value = data[index][12];
        }
        else if ("tax".equals(fieldName))
        {
                value = data[index][13];
        }               
        else if ("remark".equals(fieldName))
        {
                value = data[index][14];
        }                
        return value;
    }
}

