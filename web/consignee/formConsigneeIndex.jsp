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
        function PopUpAddEdit(id, idConsignee) {				
                var url;
                if (id==0) {
                    url = 'newConsignee.do';
                } else if (id==1) {
                    url = 'findConsignee.do?idConsignee=' + idConsignee;
                } else if (id==2) {
                    question = confirm('Are you sure want to delete this record?'); 
                    if (question) {
                        window.location='deleteConsignee.do?idConsignee=' + idConsignee;
                        return;
                    } else {
                        return;
                    }                    
                } else if (id==3) {
                    url = 'viewConsignee.do?idConsignee=' + idConsignee;
                }                 
                popUp('Consignee',url,'765','450');
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
            <jsp:include page="../temp/masterMenu.jsp"/>
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
                                    <html:form action="/consignee" method="GET">
                                        <tr>
                                            <td width="100%">&nbsp;
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;Search
                                            </td>
                                            <td vAlign="middle" noWrap align="right">&nbsp;
                                                Name
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                                <html:text property="name" size="25"/>
                                            </td>
                                            <td vAlign="middle" noWrap align="right">&nbsp;
                                                <html:submit value="Go"/>
                                            </td>
                                            <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                            </td>
                                            <td vAlign="middle" noWrap align="right" width="130">
                                                <a class="link1" href="Javascript:PopUpAddEdit('0','');">Add New Customer <IMG height="26" src="<%=request.getContextPath()%>/Images/icon_add_new.gif" width="26" align="absMiddle" border="0"></a>
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
                        <display:table name="consigneeList" id="consignee" class="report" requestURI="/consignee/consignee.do"    
                             decorator="com.wings.struts.decorators.ConsigneeWrapper" pagesize="10">
                             <display:column property="idConsignee" title="Id" sortable="true"/>
                            <display:column property="name" title="Name" sortable="true"/>
                            <display:column property="description" title="Description" sortable="true"/>
                            <display:column property="contactPerson" title="Contact Person" sortable="true"/>
                            <display:column property="email" title="Email" sortable="true"/>
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