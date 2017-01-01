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
    	
    </script>
</head>
<body>
    <div align="center">
        <br><br>
        
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
                        <html:form action="/listAccount" method="GET">
                            <input type="hidden" name="idAcc" value="<%=request.getAttribute("idAcc")%>"/>
                            <tr>
                                <td width="100%">&nbsp;
                                </td>
                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;Search
                                </td>
                                <td vAlign="middle" noWrap align="right">&nbsp;Name
                                </td>
                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                    <html:text property="accountName" size="35"/>
                                    
                                </td>
                                <td vAlign="middle" noWrap align="right">&nbsp;
                                    <html:submit value="Go"/>
                                </td>
                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                </td>
                                <td vAlign="middle" noWrap align="right" width="130">
                                    
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
                    
                    <display:table name="accounts" id="account" class="report" requestURI="/account/listAccount.do"    
                                   decorator="com.wings.struts.decorators.AccountWrapper" pagesize="30">                            
                        <display:column property="idAccountLink" title="Id Account" sortable="true"/>
                        <display:column property="accountName" title="Account Name" sortable="true"/> 
                        <display:column property="category" title="Category" sortable="true"/> 
                        <display:column property="type" title="Type" sortable="true"/>                             
                        
                    </display:table>
                    <script>
                        function GetAccount(idAccount,accountName) {                            
                            if (window.opener.document.getElementById('idAccount')==null) {
                                var idAcc = '<%=request.getAttribute("idAcc")%>';
                                window.opener.document.getElementById(idAcc).value=idAccount;
                            } else {
                                window.opener.document.getElementById('idAccount').value=idAccount;
                            }
                            if (window.opener.document.getElementById('accountDesc')!=null) {
                                window.opener.document.getElementById('accountDesc').value=accountName;
                            }                            
                            window.close();
                        }
                    </script>                    
                </td>                    
                <td width="10">&nbsp;</td>
            </tr>
            
        </table>	
    </div>       
</body>
</html>