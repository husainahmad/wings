<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
    <title>.: WINGS GLOBAL LOGISTICS - :.</title>
    <meta http-equiv="Expires" content="-1" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <style type="text/css" media="all">      
      @import url("<%=request.getContextPath()%>/css/maven-theme.css");
      @import url("<%=request.getContextPath()%>/css/site.css");
      @import url("<%=request.getContextPath()%>/css/screen.css");
    </style>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/print.css" type="text/css" media="print" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Styles.css" type="text/css" >
    
</head>
<body>

<table border="0" cellspacing="0" cellpadding="0" width="803" align="center">
    <tr>
        <td colspan="2">
            <jsp:include page="temp/header.jsp"/>
        </td>
    </tr>
    <tr valign=top>
        <%--
        <td width="160" height="400" valign="top">
            
        </td>
        --%>
        <td width="800" class="ver12gray" valign="middle" colspan="1" height="400">                        
            <table width="100%" border="0" cellspacing="0" cellpadding="0">	
                <tr>
                    <td vAlign="top" colSpan="3" align="center">
                        
                        <!--start error content goes here-->
                        Internal Server Error...
                        <!--end error content goes here-->
                    </td>
                </tr>     
                <tr>
                    
                    <td class="ver12gray" align="center" colspan="3">	
                         
                    </td>                                        
                </tr>
            </table>	
        </td>
        <td background="<%=request.getContextPath()%>/Images/shadow_02.gif" width="3"><img src="<%=request.getContextPath()%>/Images/shadow_02.gif" width="3" height="2"></td>
    </tr>    
    <tr>
            <td colspan="3">
                <jsp:include page="temp/footer.jsp"/>
            </td>
    </tr>
</table>
</body>
</html>