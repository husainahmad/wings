<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%
	JasperPrint jasperPrint = (JasperPrint)session.getAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE);
		
	
	JRHtmlExporter exporter = new JRHtmlExporter();
	
	int pageIndex = 0;
	int lastPageIndex = 0;
	if (jasperPrint!= null)
	{
		lastPageIndex = jasperPrint.getPages().size() - 1;
	}

	String pageStr = request.getParameter("page");
	try
	{
		pageIndex = Integer.parseInt(pageStr);
	}
	catch(Exception e)
	{
	}
	
	if (pageIndex < 0)
	{
		pageIndex = 0;
	}

	if (pageIndex > lastPageIndex)
	{
		pageIndex = lastPageIndex;
	}
	
	StringBuffer sbuffer = new StringBuffer();

	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sbuffer);
	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../servlets/image?image=");
	exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(pageIndex));
	exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");
	exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, "");
	exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
        
        try {
		exporter.exportReport();
	} catch (Exception e) {
            
        }
	
%>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
  <title>.:  :.</title>  
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
    
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td><a href="#" onclick="JavaScript:location.reload(true);"><img src="<%=request.getContextPath()%>/Images/reload.GIF" border="0"></a></td>
        <td><a href="#" onclick="PrintReport();"><img src="<%=request.getContextPath()%>/Images/print.gif" border="0"></a></td>
        <td><a target="_blank" href="<%=request.getContextPath()%>/reports/PdfServlet"><img src="<%=request.getContextPath()%>/Images/pdf.gif" border="0"></a></td>
        <td><a target="_blank" href="<%=request.getContextPath()%>/reports/XlsServlet"><img src="<%=request.getContextPath()%>/Images/excel.gif" border="0"></a></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
<%
	if (pageIndex > 0)
	{
%>
        <td><a href="viewer.jsp?page=0"><img src="<%=request.getContextPath()%>/Images/first.GIF" border="0"></a></td>
        <td><a href="viewer.jsp?page=<%=pageIndex - 1%>"><img src="<%=request.getContextPath()%>/Images/previous.GIF" border="0"></a></td>
<%
	}
	else
	{
%>
        <td><img src="<%=request.getContextPath()%>/Images/first_grey.GIF" border="0"></td>
        <td><img src="<%=request.getContextPath()%>/Images/previous_grey.GIF" border="0"></td>
<%
	}

	if (pageIndex < lastPageIndex)
	{
%>
        <td><a href="viewer.jsp?page=<%=pageIndex + 1%>"><img src="<%=request.getContextPath()%>/Images/next.GIF" border="0"></a></td>
        <td><a href="viewer.jsp?page=<%=lastPageIndex%>"><img src="<%=request.getContextPath()%>/Images/last.GIF" border="0"></a></td>
<%
	}
	else
	{
%>
        <td><img src="<%=request.getContextPath()%>/Images/next_grey.GIF" border="0"></td>
        <td><img src="<%=request.getContextPath()%>/Images/last_grey.GIF" border="0"></td>
<%
	}
%>
        <td width="100%">&nbsp;</td>
      </tr>
    </table>
    
    </span>
  </td>
  <td width="50%">&nbsp;</td>
</tr>
<tr>
  <td width="50%">&nbsp;</td>
  <td align="center">

<%=sbuffer.toString()%>

  </td>
  <td width="50%">&nbsp;</td>
</tr>    
</table>
</body>
</html>
