<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
                <%--
		<tr>
			<td>IdKursDollar:</td>
			<td><html:text property="idKursDollar" disabled="true"/></td>
		</tr>
                --%>
                
                <html:hidden property="idKursDollar"/>
                <%--
                <tr>
			<td>ChangeDate:</td>
			<td><html:text property="changeDateAsString"/></td>
		</tr>
                --%>
		<tr>
			<td>Value:</td>
			<td><html:text property="value" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
