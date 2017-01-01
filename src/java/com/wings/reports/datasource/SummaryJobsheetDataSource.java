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
public class SummaryJobsheetDataSource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data = null;
		

	private int index = -1;
	

	public SummaryJobsheetDataSource(Object[][] data)
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
		
		if ("shippeddate".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("jobNo".equals(fieldName))
		{
			value = data[index][1];
		}
                else if ("idShipper".equals(fieldName))
		{
			value = data[index][2];
		}
		else if ("idConsignee".equals(fieldName))
		{
			value = data[index][3];
                }        
		else if ("idAgent".equals(fieldName))
		{
			value = data[index][4];
		}	
                else if ("qtyDesc".equals(fieldName))
		{
			value = data[index][5];
		}
                else if ("weightDesc".equals(fieldName))
		{
			value = data[index][6];
		}
                else if ("volumeDesc".equals(fieldName))
		{
			value = data[index][7];
		}
                else if ("idJobType".equals(fieldName))
		{
			value = data[index][8];
		}
                else if ("totalBillingIDR".equals(fieldName))
		{
			value = data[index][9];
		}
                else if ("totalBillingUSD".equals(fieldName))
		{
			value = data[index][10];
		}
                else if ("totalExpensesIDR".equals(fieldName))
		{
			value = data[index][11];
		}
                else if ("totalExpensesUSD".equals(fieldName))
		{
			value = data[index][12];
		}
                else if ("idTransporter".equals(fieldName))
		{
			value = data[index][13];
		}
		return value;
	}


}

