<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
                <%--
		<tr>
			<td>IdShipperFee:</td>
			<td><html:text property="idShipperFee" disabled="true"/></td>
		</tr>
                --%>
                <html:hidden property="idShipperFee"/>
		<tr>
			<td>Description:</td>
			<td><html:text property="description" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <tr>
			<td>Alias Name:</td>
			<td><html:text property="aliasName" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
                <%--
                <tr>
			<td>Tax:</td>
			<td><html:radio property="isTax" value="1"/>Yes<html:radio property="isTax" value="0"/>No</td>
		</tr>
                --%>
                <tr>
			<td>Category:</td>
			<td>
                            <html:select property="category" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                <html:option value="Cost to Cost">Cost to Cost</html:option>
                                <html:option value="Service">Service</html:option>    
                            </html:select>
                        </td>
		</tr>
                <tr>
			<td>To Departement:</td>
			<td>
                            <table cellpadding="2" cellspacing="2" border="0" width="100%">                                
                                <tr>
                                    <td>AI : <html:checkbox property="isAI" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="1"/></td>                                
                                    <td>AO : <html:checkbox property="isAO" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="1"/></td>                                
                                    <td>SI : <html:checkbox property="isSI" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="1"/></td>
                                    <td>SO : <html:checkbox property="isSO" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="1"/></td>
                                </tr>
                            </table>
                        </td>
		</tr>
                <tr>
			<td>Sales Account:</td>
			<td>
                            <table cellpadding="2" cellspacing="2" border="0" width="100%">
                                <tr>
                                    <td>AI</td>                                
                                    <td>AO</td>                                
                                    <td>SI</td>
                                    <td>SO</td>
                                </tr>
                                <tr>
                                    <td><html:text property="idAccountAI" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                
                                    <td><html:text property="idAccountAO" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                
                                    <td><html:text property="idAccountSI" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                    <td><html:text property="idAccountSO" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                            </table>
                        </td>
		</tr>
                <tr>
			<td>Cost Account:</td>
			<td>
                            <table cellpadding="2" cellspacing="2" border="0" width="100%">
                                <tr>
                                    <td>AI</td>                                
                                    <td>AO</td>                                
                                    <td>SI</td>
                                    <td>SO</td>
                                </tr>
                                <tr>
                                    <td><html:text property="idAccountCostAI" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                
                                    <td><html:text property="idAccountCostAO" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                
                                    <td><html:text property="idAccountCostSI" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                    <td><html:text property="idAccountCostSO" size="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                            </table>
                        </td>
		</tr>