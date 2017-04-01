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
public class FakturLapReportDataSource implements JRDataSource
{
    /**
     *
     */
    private Object[][] data = null;

    private int index = -1;

    public FakturLapReportDataSource(Object[][] data)
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

        if ("tgl".equals(fieldName))
        {
                value = data[index][0];
        }
        else if ("invoice".equals(fieldName))
        {
                value = data[index][1];
        }
        else if ("jobno".equals(fieldName))
        {
                value = data[index][2];
        }
        else if ("customer".equals(fieldName))
        {
                value = data[index][3];
        }        
        else if ("vat10".equals(fieldName))
        {
                value = data[index][4];
        }	
        else if ("vat1".equals(fieldName))
        {
                value = data[index][5];
        }
        else if ("pph".equals(fieldName))
        {
                value = data[index][6];
        }
        else if ("total".equals(fieldName))
        {
                value = data[index][7];
        }
           
        return value;
    }


}

