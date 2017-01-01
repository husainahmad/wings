<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

<html>
<head>
    <title>.: WINGS GLOBAL LOGISTICS - :.</title>
     <style type="text/css" media="all">

      @import url("<%=request.getContextPath()%>/css/maven-theme.css");
      @import url("<%=request.getContextPath()%>/css/site.css");
      @import url("<%=request.getContextPath()%>/css/screen.css");
    </style>
    <link href="<%=request.getContextPath()%>/Styles.css" type="text/css" rel="stylesheet">
</head>
<body bgColor="#c4c4c4" >
    
    <table cellSpacing="0" cellPadding="0" width="630" align="center" border="0">
        <tr>
            <td>
                <table cellSpacing="0" cellPadding="10" width="100%" border="0">
                    <tr>
                        <td class="ver12gray" bgColor="#dbdbd4">Add/Edit Jobsheet</td>
                    </tr>
                </table>
                <table cellSpacing="0" cellPadding="0" width="100%" border="0">
                    <tr>
                        <td bgColor="#b7b7af"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                        <td bgColor="#ffffff"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                </table>
            </td>
            <td vAlign="top" width="3" background="<%=request.getContextPath()%>/Images/shadow_02.gif"><IMG height="3" src="<%=request.getContextPath()%>/Images/shadow_01.gif" width="3"></td>
        </tr>
    </table>
    <table cellSpacing="0" cellPadding="0" width="630" align="center" border="0">
            <tr>
            <td>
                <table cellSpacing="10" cellPadding="0" width="100%" bgColor="#eeeee6" border="0">
                    <tr>
                        <td>
                            <table class="ver10gray" cellSpacing="2" cellPadding="2" width="100%" border="0">
                                    <!--start content goes here-->
                                <tr>
                                    <td vAlign="top" align="center" colSpan="2">
                                        <!--start error content goes here-->
                                         <html:errors/>
                                        <!--end error content goes here-->
                                    </td>
                                </tr>
                                <tr>
                                    <td width="10">&nbsp;</td>
                                    <td class="ver10gray">
                                     
                                    <logic:equal name="action" value="insert">
                                            <html:form action="/insertJobsheet" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/jobsheet/formJobsheetInc.jsp"/>
                                                    <tr>
                                                            <td colspan="2"><html:submit value="create"/></td>
                                                    </tr>
                                            </table>
                                            </html:form>
                                    </logic:equal>
                                    <logic:equal name="action" value="update">
                                            <html:form action="/updateJobsheet" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/jobsheet/formJobsheetInc.jsp"/>
                                                    <tr>
                                                            <td colspan="2"><html:submit value="update"/></td>
                                                    </tr>
                                            </table>
                                            </html:form>
                                    </logic:equal>
                                    <logic:equal name="action" value="select">
                                            <html:form action="/selectJobsheet" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/jobsheet/formJobsheetInc.jsp"/>
                                                    <tr>
                                                            <td colspan="2"><html:submit value="find"/></td>
                                                    </tr>
                                            </table>
                                            </html:form>
                                    </logic:equal>
   
                                    </td>                    
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <table cellSpacing="0" cellPadding="0" width="100%" border="0">
                    <tr>
                        <td bgColor="#b7b7af"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                        <td bgColor="#ffffff"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                </table>
                <table cellSpacing="0" cellPadding="5" width="100%" bgColor="#eeeee6" border="0">
                    <tr>
                        <td>
                            <table class="ver10gray" cellSpacing="0" cellPadding="0" width="100%" border="0">
                                <tr>
                                    <td align="center">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="3" background="<%=request.getContextPath()%>/Images/shadow_02.gif"><IMG height="2" src="../Images/shadow_02.gif" width="3"></td>
        </tr>
    </table>
    <table cellSpacing="0" cellPadding="0" width="630" align="center" border="0">
        <tr>
            <td bgColor="#404040"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
        </tr>
        <tr>
            <td bgColor="#505050"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
        </tr>
        <tr>
            <td bgColor="#919191"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
        </tr>
    </table>
       
<%--


--%>

</body>
</html>

<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

<html>
<head>
	<title>Jobsheet Form</title>
</head>
<body>

<h1>Jobsheet Form</h1>

<html:errors/>

<jsp:include page="/struts/menu.jsp" flush="true" />

</body>
</html>