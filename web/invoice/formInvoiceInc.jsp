
<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
                <%--
		<tr>
			<td>IdInvoice:</td>
			<td><html:text property="idInvoice"/></td>
		</tr>
                --%>
                <html:hidden property="idInvoice"/>
		<tr>
			<td>IdJobSheet:</td>
			<td><html:text property="idJobSheet"/></td>
		</tr>
		<tr>
			<td>InvoiceNumber:</td>
			<td><html:text property="invoiceNumber"/></td>
		</tr>
		<tr>
			<td>InvoiceDate:</td>
			<td><html:text property="invoiceDateAsString"/>(dd.mm.yyyy hh:mm:ss)</td>
		</tr>
