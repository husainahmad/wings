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
public class StatementOfAccountDatasource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data = null;
		

	private int index = -1;
	

	public StatementOfAccountDatasource(Object[][] data)
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
		
		if ("InvoiceDate".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("JobNo".equals(fieldName))
		{
			value = data[index][1];
		}
                else if ("InvoiceNo".equals(fieldName))
		{
			value = data[index][2];
		}
		else if ("AWB".equals(fieldName))
		{
			value = data[index][3];
                }        
		else if ("Dest".equals(fieldName))
		{
			value = data[index][4];
		}	
                else if ("AmountUSD".equals(fieldName))
		{
			value = data[index][5];
		}
                 else if ("AmountIDR".equals(fieldName))
		{
			value = data[index][6];
		}
                 else if ("dDate".equals(fieldName))
		{
			value = data[index][7];
		} 
                 else if ("idNumber".equals(fieldName))
		{
			value = data[index][8];
		}
                else if ("name".equals(fieldName))
		{
			value = data[index][9];
		}
                else if ("vat10".equals(fieldName))
		{
			value = data[index][10];
		}
                else if ("vat1".equals(fieldName))
		{
			value = data[index][11];
		}
                else if ("pph".equals(fieldName))
		{
			value = data[index][12];
		}
		return value;
	}


}

