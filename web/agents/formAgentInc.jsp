<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

                <%--
		<tr>
			<td>IdAgent:</td>
			<td><html:text property="idAgent" disabled="true"/></td>
		</tr>
                --%>
                <%--
                <html:hidden property="idAgent"/>
                --%>
                <logic:equal name="action" value="insert">
                        <tr>
                                <td>Id Agent:</td>
                                <td><html:text property="idAgent" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        </tr>
                </logic:equal>
                <logic:equal name="action" value="update">
                        <tr>
                                <td>Id Agent:</td>
                                <td><html:text property="idAgent" size="13" readonly="true"/></td>
                        </tr>
                </logic:equal>
                <logic:equal name="action" value="select">
                        <tr>
                                <td>Id Agent:</td>
                                <td><html:text property="idAgent" size="13" readonly="true"/></td>
                        </tr>
                </logic:equal>
                
		<tr>
			<td>Name:</td>
			<td><html:text property="name" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <tr>
			<td>Invoicing Name:</td>
			<td><html:text property="description2" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><html:text property="description" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <tr>
			<td>NPWP:</td>
			<td><html:text property="npwp" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
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
                        <td></td>
			<td>
                            <table cellpadding="2" cellspacing="2" border="0">
                                <tr>
                                        <td>Contact Person:</td>
                                        <td>Email:</td>
                                </tr>
                                <tr>
                                        <td><html:text property="contactPerson" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                        <td><html:text property="email" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td><html:text property="person2" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                        <td><html:text property="email2" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td><html:text property="person3" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                        <td><html:text property="email3" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td><html:text property="person4" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                        <td><html:text property="email4" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td><html:text property="person5" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                        <td><html:text property="email5" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                            </table>
                        </td>
			
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
			<td>Address:</td>
			<td><html:text property="address1" size="45" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td></td>
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
