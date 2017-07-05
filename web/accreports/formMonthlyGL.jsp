<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
    <title>.:  :.</title>
    <meta http-equiv="Expires" content="-1" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <style type="text/css" media="all">

      @import url("<%=request.getContextPath()%>/css/maven-theme.css");
      @import url("<%=request.getContextPath()%>/css/site.css");
      @import url("<%=request.getContextPath()%>/css/screen.css");
    </style>
    <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/skins/aqua/theme.css" title="Aqua" />    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/print.css" type="text/css" media="print" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Styles.css" type="text/css" >
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>

    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>    

    <!-- helper script that uses the calendar -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>
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
        function PopUpAddEdit() {				
                var url = 'printGL.do?';
                url += 'month=' + document.getElementById("month").value;
                url += '&year=' + document.getElementById("year").value;
                url += '&idAccount=' + document.getElementById("idAccount").value;
                try {
                    url += '&perMonth=' + document.getElementById("month").options[document.getElementById("month").selectedIndex].text;
                } catch (e) {
                    url += '';    
                }
                popUp('printMonthlyGL',url,'750','500');
                
        }		
    </script>
</head>
<body>

<table border="0" cellspacing="0" cellpadding="0" width="1003" align="center">
    <tr>
        <td colspan="3">
            <jsp:include page="../temp/header.jsp"/>
        </td>
    </tr>
    <tr valign=top>
        <td width="160" height="400" background="<%=request.getContextPath()%>/Images/menu_bg.gif" valign="top">
            <jsp:include page="../temp/accreportsMenu.jsp"/>
        </td>
        <td width="840" class="ver12gray">
            <jsp:include page="../temp/subHeader.jsp"/>
            
            
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
                        <html:form action="/printBB" method="GET">                                                
                            <table class="ver10gray" cellSpacing="2" cellPadding="2" width="450" border="0" bgcolor="#eeeee6"
                                   style="BORDER-RIGHT: dimgray 1px solid; BORDER-TOP: dimgray 1px solid; BORDER-LEFT: dimgray 1px solid; BORDER-BOTTOM: dimgray 1px solid">
                                <tr vAlign="top">
                                    <td colSpan="2">                                            
                                    </td>
                                </tr>
                                <tr>
                                    <td vAlign="middle" colSpan="2" height="30" align="center"><b><u>Report Monthly General Ledger</u></b></td>
                                </tr>                            
                                <tr vAlign="top">
                                    <td><b>Month</b></td>
                                    <td>
                                        <html:select styleId="month"  property="month">
                                            <html:options collection="monthList" property="monthId" labelProperty="monthName"/>
                                        </html:select>                                                
                                    </td>
                                </tr>
                                <tr vAlign="top">
                                    <td><b>Year</b></td>
                                    <td>
                                        <html:select styleId="year" property="year">
                                            <html:options collection="yearList" property="year" labelProperty="year"/>
                                        </html:select>
                                    </td>                            
                                </tr>
                                <tr>
                                    <td><b>Account</b></td>                                    
                                    <td><html:text property="idAccount" styleId="idAccount" size="13"/>&nbsp;
                                    </td>                                    
                                </tr>
                                <%--
                           
                                <tr vAlign="top">
                                    <td><b>Account</b></td>
                                    <td>
                                        
                                    </td>                            
                                </tr>
                            --%>
                                <tr vAlign="middle">
                                    <td colspan="2" align="center" height="40">
                                        <input type="button" value="Generate" onclick="PopUpAddEdit();">                                             
                                    </td>
                                </tr>
                            </table>
                        </html:form>
                    </td>                    
                    <td width="10">&nbsp;</td>
                </tr>
                <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray">	                                                
                    </td>                    
                    <td width="10">&nbsp;</td>
                </tr>
            </table>	
        </td>
        <td background="<%=request.getContextPath()%>/Images/shadow_02.gif" width="3"><img src="<%=request.getContextPath()%>/Images/shadow_02.gif" width="3" height="2"></td>
    </tr>    
    <tr>
            <td colspan="3">
                <jsp:include page="../temp/footer.jsp"/>
            </td>
    </tr>
</table>
</body>
</html>