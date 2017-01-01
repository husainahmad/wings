<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

<html>
<head>
	<title>Debit Form</title>
</head>
<body>

<h1>Debit Form</h1>

<html:errors/>

<logic:equal name="action" value="insert">
	<html:form action="/struts/insertDebit" method="POST">
	<table border="1">
		<jsp:include page="/struts/formDebitInc.jsp"/>
		<tr>
			<td colspan="2"><html:submit value="create"/></td>
		</tr>
	</table>
	</html:form>
</logic:equal>
<logic:equal name="action" value="update">
	<html:form action="/struts/updateDebit" method="POST">
	<table border="1">
		<jsp:include page="/struts/formDebitInc.jsp"/>
		<tr>
			<td colspan="2"><html:submit value="update"/></td>
		</tr>
	</table>
	</html:form>
</logic:equal>
<logic:equal name="action" value="select">
	<html:form action="/struts/selectDebit" method="POST">
	<table border="1">
		<jsp:include page="/struts/formDebitInc.jsp"/>
		<tr>
			<td colspan="2"><html:submit value="find"/></td>
		</tr>
	</table>
	</html:form>
</logic:equal>

<jsp:include page="/struts/menu.jsp" flush="true" />

</body>
</html>