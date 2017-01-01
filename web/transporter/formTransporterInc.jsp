<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		
                <logic:equal name="action" value="insert">
                        <tr>
                                <td>Id Transporter:</td>
                                <html:text property="idTransporter" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </tr>                                             
                </logic:equal>
                <logic:equal name="action" value="update">
                        <tr>
                                <td>Id Transporter:</td>
                                <html:text property="idTransporter" size="13" readonly="true"/>                        
                        </tr>
                </logic:equal>
                <logic:equal name="action" value="select">
                        <tr>
                                <td>Id Transporter:</td>
                                <html:text property="idTransporter" size="13" readonly="true"/>                        
                        </tr>                        
                </logic:equal>

		<tr>
			<td>Name:</td>
			<td><html:text property="name" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><html:text property="description" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>ContactPerson:</td>
			<td><html:text property="contactPerson" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Telp:</td>
			<td><html:text property="telp" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Fax:</td>
			<td><html:text property="fax" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><html:text property="email" size="30" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <tr>
			<td>AccountId(IDR):</td>
			<td><html:text property="idAccountIDR" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <tr>
			<td>AccountId(USD):</td>
			<td><html:text property="idAccountUSD" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Address1:</td>
			<td><html:text property="address1" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Address2:</td>
			<td><html:text property="address2" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>PostalCode:</td>
			<td><html:text property="postalCode" size="9" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><html:text property="city" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Region:</td>
			<td><html:text property="region" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Npwp:</td>
			<td><html:text property="npwp" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
