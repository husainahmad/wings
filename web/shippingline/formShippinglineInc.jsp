<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

                <%--
		<tr>
			<td>IdShippingLine:</td>
			<td><html:text property="idShippingLine" disabled="true"/></td>
		</tr>
                --%>
                <%--
                <html:hidden property="idShippingLine"/>
                --%>
                <logic:equal name="action" value="insert">
                        <tr>
                                <td>Id Shipping Line:</td>
                                <td><html:text property="idShippingLine" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        </tr>
                </logic:equal>
                <logic:equal name="action" value="update">
                        <tr>
                                <td>Id Shipping Line:</td>
                                <td><html:text property="idShippingLine" size="13" readonly="true"/></td>
                        </tr>
                </logic:equal>
                <logic:equal name="action" value="select">
                        <tr>
                                <td>Id Shipping Line:</td>
                                <td><html:text property="idShippingLine" size="13" readonly="true"/></td>
                        </tr>
                </logic:equal>
		<tr>
			<td>Name:</td>
			<td><html:text property="name" size="40"/></td>
		</tr>
                 <tr>
			<td>Invoicing Name:</td>
			<td><html:text property="description2" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><html:text property="description"  size="40"/></td>
		</tr>
		<tr>
			<td>ContactPerson:</td>
			<td><html:text property="contactPerson"  size="40"/></td>
		</tr>
		<tr>
			<td>Telp:</td>
			<td><html:text property="telp" /></td>
		</tr>
		<tr>
			<td>Fax:</td>
			<td><html:text property="fax"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><html:text property="email"  size="40"/></td>
		</tr>
		<tr>
			<td>Address1:</td>
			<td><html:text property="address1"  size="40"/></td>
		</tr>
		<tr>
			<td>Address2:</td>
			<td><html:text property="address2" size="40"/></td>
		</tr>
		<tr>
			<td>PostalCode:</td>
			<td><html:text property="postalCode"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><html:text property="city"/></td>
		</tr>
		<tr>
			<td>Region:</td>
			<td><html:text property="region"/></td>
		</tr>
		<tr>
			<td>NPWP:</td>
			<td><html:text property="npwp" size="40"/></td>
		</tr>
		<tr>
			<td>Id Account IDR:</td>
			<td><html:text property="idAccountIdr"/></td>
		</tr>
		<tr>
			<td>Id Account USD:</td>
			<td><html:text property="idAccountUsd"/></td>
		</tr>
