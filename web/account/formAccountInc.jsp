<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		<tr>
			<td>IdAccount:</td>
			<td>
                            <html:text property="idAccount" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
                        </td>
		</tr>
		<tr>
			<td>AccountName:</td>
			<td><html:text property="accountName" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Category:</td>
			<td><html:text property="category" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Type:</td>
			<td><html:text property="type" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>SaldoAwal:</td>
                        <td> 
                            <input type="text" name="saldoAwal" value="<bean:write name="accountForm" property="saldoAwal" format="###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
			</td>
		</tr>
