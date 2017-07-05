
<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
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
        function PopUpAddEdit(id, idPayment) {				
                var url;
                var customer = document.getElementById("idConsignee").value;
                var month = document.getElementById("month").value;
                var year = document.getElementById("year").value;

                if (id==0) {
                    url = 'newPayment.do?idCostomer='+customer+'&month='+month+'&year='+year;
                } else if (id==1) {
                    url = 'findPayment.do?idPayment=' + idPayment+'&idCostomer='+customer+'&month='+month+'&year='+year;
                } else if (id==2) {
                    //url = 'deletePayment.do?idPayment=' + idPayment+'&idCostomer='+customer+'&month='+month+'&year='+year;
                } else if (id==3) {
                    url = 'viewPayment.do?idPayment=' + idPayment+ '&idCostomer='+customer+'&month='+month+'&year='+year;
                }                 
                //alert(url);
                popUp('Payment',url,'850','600');
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
            <jsp:include page="../temp/debitInvoiceMenu.jsp"/>
        </td>
        <td width="840" class="ver12gray">
            <jsp:include page="../temp/subHeader.jsp"/>
            
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">	
               <tr>
                    <td vAlign="top" align="center" colSpan="3">
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
                                                <html:form action="/payment" method="GET">                                                
                                                <td class="ver10gray" vAlign="middle" noWrap align="right">
                                                </td>
                                                <td vAlign="middle" class="ver10gray"noWrap align="left">
                                                    Customer
                                                    <html:text property="idConsignee" styleId="idConsignee" size="30"/>                                                    
                                                        <ajax:autocomplete
                                                          source="idConsignee"
                                                          target="idConsignee"
                                                          baseUrl="${contextPath}/SOAServletAutocomplete"
                                                          className="autocomplete"
                                                          indicator="indicator"
                                                          minimumCharacters="1"
                                                        />
                                                </td>
                                                <td class="ver10gray" vAlign="middle" noWrap align="right">Month
                                                    <html:select  property="month" styleId="month">
                                                        <html:options collection="monthList" property="monthId" labelProperty="monthName"/>
                                                    </html:select>                                                
                                                </td>
                                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;Year
                                                    <html:select  property="year" styleId="year">
                                                        <html:options collection="yearList" property="year" labelProperty="year"/>
                                                    </html:select>
                                                </td>
                                                <td class="ver10gray" vAlign="middle" noWrap align="right">&nbsp;
                                                    <html:submit value="Go"/>                                                    
                                                </td>                                                
                                                </html:form>
                                                <td vAlign="middle" noWrap align="right" width="130">                                                    
                                                  <a class="link1" href="Javascript:PopUpAddEdit('0','');">Add New Payment<IMG height="26" src="<%=request.getContextPath()%>/Images/icon_add_new.gif" width="26" align="absMiddle" border="0">
                                                  </a>                                                  
                                                </td>
                                        </tr>
                                        </tr>
                                </table>
                        </td>
                        <td width="10">&nbsp;</td>
                </tr>                                    
               <tr>
                    <td width="10">&nbsp;</td>
                    <td class="ver12gray">
                        
                        <display:table name="SOAList" id="invoiceAIDetail" class="report" requestURI="/payment/unpayment.do"    
                             decorator="com.wings.struts.decorators.InvoiceAIWrapper" pagesize="10">                                                        
                            <display:column property="dateInvoice" title="Date" sortable="true"/>
                            <display:column property="name" title="Name" sortable="true"/>
                            <display:column property="idNumber" title="Number" sortable="true" />                            
                            <display:column property="formatTotalBillingUSD" title="USD" sortable="true" />                            
                            <display:column property="formatTotalBillingIDR" title="IDR" sortable="true" />                            
                            <display:column property="payed" title="Status" sortable="true" />                            
                            
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