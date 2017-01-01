<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		<tr>
			<td>IdDebit:</td>
			<td><html:text property="idDebit" disabled="true"/></td>
		</tr>
		<tr>
			<td>IdJobSheet:</td>
			<td><html:text property="idJobSheet"/></td>
		</tr>
		<tr>
			<td>DebitNumber:</td>
			<td><html:text property="debitNumber"/></td>
		</tr>
		<tr>
			<td>DebitDate:</td>
			<td><html:text property="debitDateAsString"/>(dd.mm.yyyy hh:mm:ss)</td>
		</tr>
