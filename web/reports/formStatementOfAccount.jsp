<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

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
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>

    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>    

    <!-- helper script that uses the calendar -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>    
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/scriptaculous/scriptaculous.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_crossframe.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_iframe.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_hide.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/overlibmws/overlibmws_shadow.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax/ajaxtags.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax/ajaxtags_controls.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax/ajaxtags_parser.js"></script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ajaxtags.css" />
      
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/displaytag.css" />
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
        function PopUpAddEdit() {				
                var url = 'printSTA.do?';
                url += 'from=' + document.getElementById("invoiceDateFrom").value;
                url += '&to=' + document.getElementById("invoiceDateTo").value;                                       
                try {
                    url += '&idConsignee=' + document.getElementById("idConsignee").value;    
                } catch (e) {
                    url += '';    
                } 
                try {
                    url += '&perConsignee=' + document.getElementById("idConsignee").options[document.getElementById("idConsignee").selectedIndex].text;
                } catch (e) {
                    url += '';    
                }
                popUp('reportSOA',url,'750','500');
                
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
            <jsp:include page="../temp/reportsMenu.jsp"/>
        </td>
        <td width="840" class="ver12gray">
            <jsp:include page="../temp/subHeader.jsp"/>
            
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">	
                <tr>
                    <td vAlign="top" align="center"colSpan="3">
                        <!--start error content goes here-->
                        <html:errors/>
                        &nbsp;<span id="indicator" style="display:none;">Loading......</span>
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
                      <form action="#">
                        <table class="ver10gray" cellSpacing="2" cellPadding="2" width="450" border="0" bgcolor="#eeeee6"
                            style="BORDER-RIGHT: dimgray 1px solid; BORDER-TOP: dimgray 1px solid; BORDER-LEFT: dimgray 1px solid; BORDER-BOTTOM: dimgray 1px solid">
                            <tr vAlign="top">
                                    <td colSpan="2">                                            
                                    </td>
                            </tr>
                            <tr>
                                    <td vAlign="middle" colSpan="2" height="30" align="center"><b><u>Report Statement Of Account</u></b></td>
                            </tr>                            
                            <tr vAlign="top">
                                    <td><b>From</b></td>
                                    <td>
                                        <input type=text name="invoiceDateFrom" id="invoiceDateFrom"/>                                                                                
                                        <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                        onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                        <script type="text/javascript">
                                            Calendar.setup({
                                                inputField     :    "invoiceDateFrom",     // id of the input field
                                                ifFormat       :    "%d/%m/%Y",      // format of the input field
                                                button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                                                //align          :    "Tl",           // alignment (defaults to "Bl")
                                                singleClick    :    true
                                            });
                                        </script>
                                    </td>
                            </tr>
                            <tr vAlign="top">
                                    <td><b>To</b></td>
                                    <td>
                                        <input type=text name="invoiceDateTo"  id="invoiceDateTo" />                                                                                
                                        <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_t" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                        onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                        <script type="text/javascript">
                                            Calendar.setup({
                                                inputField     :    "invoiceDateTo",     // id of the input field
                                                ifFormat       :    "%d/%m/%Y",      // format of the input field
                                                button         :    "f_trigger_t",  // trigger for the calendar (button ID)
                                                //align          :    "Tl",           // alignment (defaults to "Bl")
                                                singleClick    :    true
                                            });
                                        </script>
                                    </td>                            
                            </tr>
                            
                           
                                <tr vAlign="top">
                                    <td><b>Customer Name</b></td>
                                    <td>
                                        
                                        <input type="text" size="35" id="idConsignee" name="idConsignee">                            
                                        <ajax:autocomplete
                                          source="idConsignee"
                                          target="idConsignee"
                                          baseUrl="${contextPath}/SOAServletAutocomplete"
                                          className="autocomplete"
                                          indicator="indicator"
                                          minimumCharacters="1"
                                        />

                                    </td>                            
                                </tr>
                            
                            <tr vAlign="middle">
                                    <td colspan="2" align="center" height="40">
                                        <input type="button" value="Generate" onclick="PopUpAddEdit();">                                             
                                    </td>
                            </tr>
                        </table>
                    </form>
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