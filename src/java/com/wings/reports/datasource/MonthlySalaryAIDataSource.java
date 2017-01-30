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
public class MonthlySalaryAIDataSource implements JRDataSource
{
    /**
     *
     */
    private Object[][] data = null;
    private int index = -1;

    public MonthlySalaryAIDataSource(Object[][] data)
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
        else if ("origin".equals(fieldName))
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
        else if ("groupBy".equals(fieldName))
        {
                value = data[index][15];
        }
        else if ("hidOutgoingIDR".equals(fieldName))
        {
                value = data[index][16];
        }
        else if ("hidOutgoingUSD".equals(fieldName))
        {
                value = data[index][17];
        }
        else if ("hidRefund".equals(fieldName))
        {
                value = data[index][18];
        }
        else if ("hidTax".equals(fieldName))
        {
                value = data[index][19];
        }
        else if ("hidPAG".equals(fieldName))
        {
                value = data[index][20];
        }
        else if ("flights".equals(fieldName))
        {
                value = data[index][21];
        }
        else if ("hidRefundAgentIDR".equals(fieldName))
        {
                value = data[index][22];
        }
        else if ("hidRefundAgentUSD".equals(fieldName))
        {
                value = data[index][23];
        }
        else if ("creditNoteIDR".equals(fieldName))
        {
                value = data[index][24];
        }
        else if ("creditNoteUSD".equals(fieldName))
        {
                value = data[index][25];
        }
        else if ("hidRefundUS".equals(fieldName))
        {
                value = data[index][26];
        }
        else if ("bsPPH".equals(fieldName))
        {
                value = data[index][27];
        }
         else if ("hidVatIDR2".equals(fieldName))
        {
                value = data[index][28];
        }
        return value;
    }
}

