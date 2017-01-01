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

<table border="0" cellspacing="0" cellpadding="0" width="1003" align="center">
    <tr>
        <td colspan="3">
            <jsp:include page="temp/header.jsp"/>
        </td>
    </tr>
    <tr valign=top>
        <td width="160" height="400" background="<%=request.getContextPath()%>/Images/menu_bg.gif" valign="top">
            <jsp:include page="temp/othersMenu.jsp"/>
        </td>
        <td width="840" class="ver12gray">
            <jsp:include page="temp/subHeader.jsp"/>
            
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">	
                <tr>
                    <td vAlign="top" colSpan="3">
                        <!--start error content goes here-->
                        <html:errors/>
                        <!--end error content goes here-->
                    </td>
                </tr>    
                <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray">
                            <table cellSpacing="0" cellPadding="0" width="100%" border="0">
                                    <tr>
                                            <td width="100%">&nbsp;
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                            </td>
                                            <td vAlign="middle" noWrap align="right">&nbsp;
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
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
                        <table cellpadding="2" cellspacing="2" border="0">
                            <tr>
                                <td align="left">                                    
                                    <strong><u>Minimum system requirement</u></strong><br>
                                    Untuk menjalankan aplikasi ini dengan baik, client browser minimal Internet Exploler 1.5 or higher<br>
                                    atau browser lain yang telah mendukung AJAX.
                                    <br><br>                        
                                    <strong><u>Session Timeout</u></strong><br>
                                    Aplikasi ini akan menghapus session user secara otomatis dalam waktu 300 second jika user tersebut tidak melakukan transaksi apapun. <br>
                                    Dan aplikasi akan meminta untuk login kembali.                                    
                                    <br><br>                        
                                    <strong><u>Security</u></strong><br>
                                    Untuk keamanan, pastikan anda selalu logout setiap kali selesai melakukan transaksi.                                                                        
                                    <br><br>                                       
                                </td>
                            </tr>
                        </table>
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