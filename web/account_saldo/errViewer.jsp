<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
  <title>.: :.</title>  
  <style type="text/css">
    a {text-decoration: none}
  </style>
  <SCRIPT language="JAVASCRIPT">
    <!--	
            function PrintReport() {				                                        
                    var tableHeader = eval('document.all.header');
                    tableHeader.style.visibility = 'hidden';              
                    window.print(); 
                    tableHeader.style.visibility = 'visible';
                    
                    return false;			                                        
            }			
    //-->
    </SCRIPT>
    <LINK href="<%=request.getContextPath()%>/Styles.css" type="text/css" rel="stylesheet">
</head>
<body text="#000000" link="#000000" alink="#000000" vlink="#000000">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
  <td width="50%">&nbsp;</td>
  <td align="left">
    <span id="header">
    <hr size="1" color="#000000">    
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td><a href="#" onclick="JavaScript:location.reload(true);"><img src="<%=request.getContextPath()%>/Images/reload.GIF" border="0"></a></td>
        <td><a href="#" onclick="PrintReport();"><img src="<%=request.getContextPath()%>/Images/print.gif" border="0"></a></td>
        <td><a target="_blank" href="<%=request.getContextPath()%>/reports/PdfServlet"><img src="<%=request.getContextPath()%>/Images/pdf.gif" border="0"></a></td>
        <td><a target="_blank" href="<%=request.getContextPath()%>/reports/XlsServlet"><img src="<%=request.getContextPath()%>/Images/excel.gif" border="0"></a></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%">&nbsp;</td>
      </tr>
    </table>
    <hr size="1" color="#000000">
    <%
        if (request.getAttribute("err")!=null) {
    %>
        Failed while querying data...!<br>
        <%=request.getAttribute("err")%>
    <%
        } 
    %>
    </span>
  </td>
  <td width="50%">&nbsp;</td>
</tr>
<tr>
  <td width="50%">&nbsp;</td>
  <td align="center">

  </td>
  <td width="50%">&nbsp;</td>
</tr>    
</table>
</body>
</html>
