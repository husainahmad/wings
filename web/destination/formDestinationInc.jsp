<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		<tr>
			<td>IdDestination:</td>
			<td><html:text property="idDestination" size="6" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><html:text property="name" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
		</tr>
