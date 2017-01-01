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
public class AccountDataSource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data = null;
		

	private int index = -1;
	

	public AccountDataSource(Object[][] data)
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
		
		if ("idAccount".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("accountName".equals(fieldName))
		{
			value = data[index][1];
		}
                else if ("category".equals(fieldName))
		{
			value = data[index][2];
		}		
                else if ("type".equals(fieldName))
		{
			value = data[index][3];
		}
                else if ("saldo".equals(fieldName))
		{
			value = data[index][4];
		}
		return value;
	}


}

