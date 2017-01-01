<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
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
                args="width="+w+",height="+h+",resizable=yes,scrollbars=yes,status=1,left="+((screen.width-w-10)/2)+",top="+((screen.height-h-30)/2);
                remote=window.open(u,n,args);
                remote.focus();
                if (remote != null) {
                        if (remote.opener == null)
                                remote.opener = self;
                        }
                if (x == 1) { return remote; }						
        }

        /* Open new window for lookup Add/Edit Entry */
        function PopUpAddEdit(id, idJobSheet) {				
                var url;
                if (id==0) {
                    url = 'newJobsheetai.do';
                } else if (id==1) {
                    url = 'findJobsheetai.do?idJobSheet=' + idJobSheet;
                } else if (id==2) {
                    question = confirm('Are you sure want to delete this record?'); 
                    if (question) {
                        window.location='deleteJobsheetai.do?idJobSheet='+ idJobSheet;
                        return;
                    } else {
                        return;
                    }
                } else if (id==3) {
                    url = 'viewJobsheetai.do?idJobSheet=' + idJobSheet;                
                } else if (id==5) {
                    url = 'findAsNewJobsheetai.do?idJobSheet=' + idJobSheet;
                 } else if (id==6) {
                    url = 'copyJobsheetai.do?idJobSheet=' + idJobSheet;
                } else if (id==4) {
                    url = 'printJobsheetai.do?idJobSheet=' + idJobSheet;
                } else if (id==7) {
                    url = 'printJobsheetaiHeader.do?idJobSheet=' + idJobSheet;
                }

                popUp('JobsheetAi',url,'1250','650');
                
        }


                
        function PopUpAddEditInvoice(id, idJobSheet) {				
                var url;
                if (id==0) {
                    url = '<%=request.getContextPath()%>/invoice/newInvoice.do';
                } else if (id==1) {
                    url = '<%=request.getContextPath()%>/invoice/findInvoice.do?idJobSheet=' + idJobSheet;
                } else if (id==2) {
                    question = confirm('Are you sure want to delete this record?'); 
                    if (question) {
                        window.location='<%=request.getContextPath()%>/deleteJobsheetai.do?idJobSheet='+ idJobSheet;
                    }
                } else if (id==3) {
                    url = '<%=request.getContextPath()%>/invoice/viewInvoice.do?idJobSheet=' + idJobSheet;
                }                 
                popUp('Invoice',url,'850','550');
        }	
        function PopUpAddEditDebit(id, idJobSheet) {				
                var url;
                if (id==0) {
                    url = 'newDebit.do';
                } else if (id==1) {
                    url = 'findDebit.do?idJobSheet=' + idJobSheet;
                } else if (id==2) {
                    //url = 'deleteAgent.do?idJobSheet=' + idJobSheet;
                } else if (id==3) {
                    url = 'viewDebit.do?idJobSheet=' + idJobSheet;
                }                 
                popUp('Debit',url,'850','550');
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
            <jsp:include page="../temp/jobsheetMenu.jsp"/>
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
                                        <html:form action="/jobsheetai" method="GET">
                                        <td width="100%">&nbsp;
                                        </td>
                                        <td class="ver10gray" vAlign="middle" noWrap align="right">Search
                                            <html:text property="txtSearch"></html:text>&nbsp;
                                        </td>
                                        <td vAlign="middle" noWrap align="right">
                                            <html:select  property="query">
                                                <html:option value="0">&nbsp;</html:option>
                                                <html:option value="1">Shipper</html:option>
                                                <html:option value="2">Consignee</html:option>
                                                <html:option value="3">Agent</html:option>
                                                <html:option value="4">Flight</html:option>
                                                <html:option value="5">JobNo</html:option>
                                                <html:option value="6">MAWB</html:option>
                                                <html:option value="7">HAWB</html:option>

                                            </html:select>&nbsp;
                                        </td>
                                        <td class="ver10gray" vAlign="middle" noWrap align="right">
                                            <html:select  property="month">
                                                <html:options collection="monthList" property="monthId" labelProperty="monthName"/>
                                            </html:select>                                                
                                        </td>
                                        <td vAlign="middle" noWrap align="right">&nbsp;
                                            <html:select  property="year">
                                                <html:options collection="yearList" property="year" labelProperty="year"/>
                                            </html:select>
                                        </td>
                                        <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                            <html:submit value="Go"/>
                                        </td>
                                        <td vAlign="middle" noWrap align="right" width="130">
                                            <a class="link1" href="Javascript:PopUpAddEdit('0','');">Add New Jobsheet (AI) <IMG height="26" src="<%=request.getContextPath()%>/Images/icon_add_new.gif" width="26" align="absMiddle" border="0"></a>
                                        </td>
                                    </tr>
                                    </html:form>
                                </table>
                        </td>
                        <td width="10">&nbsp;</td>
                </tr>                                    
               <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray">	
                        
                            <display:table name="jobsheetais" id="jobsheet" class="report" requestURI="/jobsheet/jobsheetai.do"    
                                           decorator="com.wings.struts.decorators.JobsheetaiWrapper" pagesize="10" excludedParams="ajax">      
                                <display:column property="dateJobsheet" title="Date" sortable="true"/>     
                                <display:column property="jobNo" title="Job No" sortable="true"/>
                                <display:column property="idShipper" title="Shipper" sortable="true"/>
                                <display:column property="idConsignee" title="Consignee" sortable="true"/>
                                <display:column property="invoiceNumber" title="Invoice Number" sortable="true"/>                            
                                <display:column property="debitNumber" title="Debit Number" sortable="true"/>
                                <display:column property="linkAll" title="Actions" />                            
                            </display:table>                                                
                        
              <input type="hidden" name="hidRefresh" id="hidRefresh" onpropertychange="JavaScript:location.reload(true);"/>                         
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