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
public class AgentDebitFeeDataSource implements JRDataSource
{


	/**
	 *
	 */
	private Object[][] data = null;
		

	private int index = -1;
	

	public AgentDebitFeeDataSource(Object[][] data)
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
		
		if ("No".equals(fieldName))
		{
			value = data[index][0];
		}
		else if ("Name".equals(fieldName))
		{
			value = data[index][1];
		}
                else if ("Alias".equals(fieldName))
		{
			value = data[index][2];
		}	
                else if ("Tax".equals(fieldName))
		{
			value = data[index][3];
		}
                else if ("SAI".equals(fieldName))
		{
			value = data[index][4];
		}
                else if ("SAO".equals(fieldName))
		{
			value = data[index][5];
		}
                else if ("SSI".equals(fieldName))
		{
			value = data[index][6];
		}
                else if ("SSO".equals(fieldName))
		{
			value = data[index][7];
		}
                else if ("CAI".equals(fieldName))
		{
			value = data[index][8];
		}
                else if ("CAO".equals(fieldName))
		{
			value = data[index][9];
		}
                else if ("CSI".equals(fieldName))
		{
			value = data[index][10];
		}
                else if ("CSO".equals(fieldName))
		{
			value = data[index][11];
		}
		return value;
	}


}

