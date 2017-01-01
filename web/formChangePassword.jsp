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
    
    <script>
        function popUp(n,u,w,h,x) {
                args="width="+w+",height="+h+",resizable=yes,scrollbars=yes,status=0,left="+((screen.width-w-10)/2)+",top="+((screen.height-h-30)/2);
                remote=window.open(u,n,args);
                remote.focus();
                if (remote != null) {
                        if (remote.opener == null)
                                remote.opener = self;
                        }
                if (x == 1) { return remote; }						
        }

        /* Open new window for lookup Add/Edit Entry */
        function PopUpAddEdit(id, handlingId) {				
                var url;
                if (id==0) {
                    url = 'newHandling.do';
                } else if (id==1) {
                    url = 'findHandling.do?handlingId=' + handlingId;
                } else if (id==2) {
                    //url = 'deleteHandling.do?handlingId=' + handlingId;
                } else if (id==3) {
                    url = 'viewHandling.do?handlingId=' + handlingId;
                }                 
                popUp('handling',url,'750','500');
        }		
    </script>
</head>
<body>

<table border="0" cellspacing="0" cellpadding="0" width="1003" align="center">
    <tr>
        <td colspan="3">
            <jsp:include page="temp/header.jsp"/>
        </td>
    </tr>
    
    <tr valign=top>
        <td width="160" height="400" background="<%=request.getContextPath()%>/Images/menu_bg.gif" valign="top">
            <table border="0" cellspacing="0" cellpadding="0" width="160">
                <tr>
                        <td background="<%=request.getContextPath()%>/Images/grey_1.gif" class="ver12white">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                                <td width="15"><img src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1" height="41"></td>
                                                <td class="ver12white">Change Password</td>
                                        </tr>
                                </table>
                        </td>
                </tr>
                <tr>
                        <td background="<%=request.getContextPath()%>/Images/grey_2.gif">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                                <td width="15">&nbsp;</td>
                                                <td width="14"><img src="<%=request.getContextPath()%>/Images/arrow.gif" width="14" height="26"></td>
                                                <td><html:link styleClass="menu" module="/" action="/changePassword">Change Password</html:link></td>
                                        </tr>
                                </table>
                        </td>
                </tr>

        </table>
        </td>
        
        <td width="840" class="ver12gray">
            <jsp:include page="temp/subHeader.jsp"/>                        
            <table width="100%" border="0" cellspacing="0" cellpadding="0">	
                <tr>
                    <td vAlign="top" colSpan="3">
                        <p align="center">
                        <!--start error content goes here-->
                        <html:errors/>
                        <%
                            if (request.getAttribute("success")!=null) {
                                out.print(request.getAttribute("success"));
                            }
                        %>
                        </p>
                        <!--end error content goes here-->
                    </td>                                       
                </tr>
                 <tr>
                        <td width="10">&nbsp;</td>
                        <td class="ver12gray" >
                                <table cellSpacing="0" cellPadding="0" width="100%" border="0">
                                    
                                        <tr>
                                            <td width="100%">&nbsp;
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                            </td>
                                            <td vAlign="middle" noWrap align="right">&nbsp;
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">                                                                                               
                                            </td>
                                            <td vAlign="middle" noWrap align="right">&nbsp;                                               
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;                                                
                                            </td>
                                            <td vAlign="middle" noWrap align="right" width="130">                                                
                                            </td>
                                        </tr>
                                   
                                </table>
                        </td>
                        <td width="10">&nbsp;</td>
                </tr>
                <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray" align="center">	
                        <html:form action="/updatePassword" method="POST">
                        <table class="ver10gray" cellSpacing="2" cellPadding="2" width="450" border="0" bgcolor="#eeeee6"
                            style="BORDER-RIGHT: dimgray 1px solid; BORDER-TOP: dimgray 1px solid; BORDER-LEFT: dimgray 1px solid; BORDER-BOTTOM: dimgray 1px solid">
                            <tr vAlign="top">
                                    <td colSpan="2">                                            
                                    </td>
                            </tr>
                            <tr>
                                    <td vAlign="middle" colSpan="2" height="30" align="center"><b><u>Change Password</u></b></td>
                            </tr>                            
                            <tr vAlign="top">
                                    <td><b>Old Password</b></td>
                                    <td>
                                        <html:password property="password" size="25"/>
                                    </td>
                            </tr>
                            <tr vAlign="top">
                                    <td><b>New Password</b></td>
                                    <td>
                                        <html:password property="newPassword" size="25"/>
                                    </td>                            
                            </tr>
                            <tr vAlign="top">
                                    <td><b>New Password (Again)</b></td>
                                    <td>
                                        <html:password property="againNewPassword" size="25"/>
                                    </td>                            
                            </tr>
                            <tr vAlign="middle">
                                    <td colspan="2" align="center" height="40">
                                         <html:submit value="Submit"/>
                                    </td>
                            </tr>
                        </table>                        
                        </html:form>
                    </td>                    
                    <td width="10">&nbsp;</td>
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