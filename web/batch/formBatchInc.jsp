<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		<tr>
			<td>NoBatch:</td>
			<td><html:text property="noBatch" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><html:text property="description" size="30" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
