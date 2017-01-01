
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
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/skins/aqua/theme.css" title="Aqua" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/scriptaculous/scriptaculous.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_crossframe.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_iframe.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_hide.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_shadow.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.2-beta2.js"></script>      
      <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jsLib.js"></script>
      
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ajaxtags.css" />
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/site.css" />
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/displaytag.css" />
     <link href="<%=request.getContextPath()%>/Styles.css" type="text/css" rel="stylesheet">
</head>
<body bgColor="#c4c4c4" >
    
    <table cellSpacing="0" cellPadding="0" width="630" align="center" border="0">
        <tr>
            <td>
                <table cellSpacing="0" cellPadding="10" width="100%" border="0">
                    <tr>
                        <td class="ver12gray" bgColor="#dbdbd4">Add/Edit Cash On Hand <span id="indicator" style="display:none;">Loading......</span></td>
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
                                            <html:form action="/insertCashonhand" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/cashonhand/formCashonhandInc.jsp"/>
                                                    <tr>
                                                            <td colspan="2"><html:submit value="create"/></td>
                                                    </tr>
                                            </table>
                                            </html:form>
                                    </logic:equal>
                                    <logic:equal name="action" value="update">
                                            <html:form action="/updateCashonhand" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/cashonhand/formCashonhandInc.jsp"/>
                                                    <tr>
                                                            <td colspan="2"><html:submit value="update"/></td>
                                                    </tr>
                                            </table>
                                            </html:form>
                                    </logic:equal>
                                    <logic:equal name="action" value="select">
                                            <html:form action="/selectCashonhand" method="POST">
                                            <table border="0">
                                                    <jsp:include page="/cashonhand/formCashonhandInc.jsp"/>
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