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
        function PopUpAddEdit(id, idTax) {				
                var url;
                if (id==0) {
                    url = 'newTax.do';
                } else if (id==1) {
                    url = 'findTax.do?idTax=' + idTax;
                } else if (id==2) {
                    question = confirm('Are you sure want to delete this record?'); 
                    if (question) {
                        window.location='deleteTax.do?idTax=' + idTax;
                        return;
                    } else {
                        return;
                    }                    
                } else if (id==3) {
                    url = 'viewTax.do?idTax=' + idTax;
                } else if (id==4) {
                    url = 'printTax.do?idTax=' + idTax;
                }               
                popUp('Tax',url,'750','500');
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
            <jsp:include page="../temp/taxMenu.jsp"/>
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
                                            <html:form action="/tax" method="GET">
                                                <td width="50%">&nbsp;
                                                </td>
                                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;Search
                                                </td>
                                                <td vAlign="middle" noWrap align="right">
                                                    <html:select  property="idJobType">
                                                        <html:option value="AI">AI</html:option> 
                                                        <html:option value="AO">AO</html:option>
                                                        <html:option value="SI">SI</html:option>
                                                        <html:option value="SO">SO</html:option>
                                                    </html:select>   
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
                                                </td>
                                            </html:form>
                                        </tr>
                                </table>
                        </td>
                        <td width="10">&nbsp;</td>
                </tr>                                    
               <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray">	
                       
                        <display:table name="taxs" id="tax" class="report" requestURI="/tax/tax.do"    
                             decorator="com.wings.struts.decorators.TaxWrapper" pagesize="10">  
                            <display:column property="dateTax" title="Faktur.Date" sortable="true"/>   
                             
                            <display:column property="jobNo" title="Job.No" sortable="true"/>                            
                            <display:column property="noFaktur" title="Faktur.No" sortable="true"/>  
                            <display:column property="dpp" title="DPP" sortable="true"/>   
                            <display:column property="ppnAsDouble" title="PPN" sortable="true"/>   
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