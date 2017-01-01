<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<html>
<head>
<title>.: WINGS GLOBAL LOGISTICS - :.</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <link href="<%=request.getContextPath()%>/Styles.css" type="text/css" rel="stylesheet">    
    <script language="javascript">
	function setDefault() {
		document.userForm.userId.focus();
	}
    </script>
</head>

<body bgcolor="#C4C4C4" text="#000000" onload="setDefault();">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
   <html:form action="/getLogin" method="post" onsubmit="return validateUserForm(this);">
    <tr>
      <td align="center" bgcolor="#C4C4C4">                          
          <table border="0" cellpadding="0" cellspacing="0" width="750">                    
              <tr>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="363" height="1" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="154" height="1" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="1" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="170" height="1" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="32" height="1" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="1" border="0" alt=""></td>
              </tr>

              <tr>
               <td colspan="5"><img name="wings_r1_c1" src="<%=request.getContextPath()%>/Images/wings_r1_c1.gif" width="750" height="59" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="59" border="0" alt=""></td>
              </tr>
              <tr>
               <td colspan="5"><img name="wings_r2_c1" src="<%=request.getContextPath()%>/Images/wings_r2_c1.gif" width="750" height="259" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="259" border="0" alt=""></td>
              </tr>
              <tr>
               <td rowspan="4" ><img name="wings_r3_c1" src="<%=request.getContextPath()%>/Images/wings_r3_c1.gif" width="378" height="88" border="0" alt=""></td>
               <td><img name="wings_r3_c2" src="<%=request.getContextPath()%>/Images/wings_r3_c2.gif" width="154" height="24" border="0" alt=""></td>
               <td rowspan="7"><img name="wings_r3_c3" src="<%=request.getContextPath()%>/Images/wings_r3_c3.gif" width="1" height="209" border="0" alt=""></td>
               <td bgcolor="#EEEEE6" ><html:text property="userId" size="30" styleClass="textboxwhite"/></td>
               <td rowspan="7"><img name="wings_r3_c5" src="<%=request.getContextPath()%>/Images/wings_r3_c5.gif" width="20" height="209" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="24" border="0" alt=""></td>
              </tr>
              <tr>
               <td><img name="wings_r4_c2" src="<%=request.getContextPath()%>/Images/wings_r4_c2.gif" width="154" height="12" border="0" alt=""></td>
               <td><img name="wings_r4_c4" src="<%=request.getContextPath()%>/Images/wings_r4_c4.gif" width="200" height="12" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="12" border="0" alt=""></td>
              </tr>
              <tr>
               <td><img name="wings_r5_c2" src="<%=request.getContextPath()%>/Images/wings_r5_c2.gif" width="154" height="24" border="0" alt=""></td>
               <td bgcolor="#EEEEE6"><html:password property="password" size="30" styleClass="textboxwhite"/></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="24" border="0" alt=""></td>
              </tr>
              <tr>
               <td rowspan="4"><img name="wings_r6_c2" src="<%=request.getContextPath()%>/Images/wings_r6_c2.gif" width="154" height="149" border="0" alt=""></td>
               <td rowspan="2"><img name="wings_r6_c4" src="<%=request.getContextPath()%>/Images/wings_r6_c4.gif" width="196" height="44" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="28" border="0" alt=""></td>
              </tr>
              <tr>
               <td rowspan="3"><img name="wings_r7_c1" src="<%=request.getContextPath()%>/Images/wings_r7_c1.gif" width="377" height="121" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="16" border="0" alt=""></td>
              </tr>
              <tr>
               <td bgcolor="white"><html:submit value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" style="height:20px; width:110px;font-size: 10px;"/></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="32" border="0" alt=""></td>
              </tr>
              <tr>
               <td><img name="wings_r9_c4" src="<%=request.getContextPath()%>/Images/wings_r9_c4.gif" width="197" height="73" border="0" alt=""></td>
               <td><img src="<%=request.getContextPath()%>/Images/spacer.gif" width="1" height="73" border="0" alt=""></td>
              </tr>
              <html:javascript formName="userForm"/>
              </html:form>            
            </table>      
            
          <table width="750" border="0" cellspacing="0" cellpadding="0" background="<%=request.getContextPath()%>/Images/footer_03.gif">
      <tr> 
        <td class="ver10gray" valign="middle"><html:errors/>   
        <%
            if (request.getParameter("err")!=null) {
                out.println(request.getParameter("err").toString());
            }
        %>  
        </td>
        <td align="right"><img src="<%=request.getContextPath()%>/Images/footer_04.gif" ></td>
      </tr>
    </table>                              
      </td>
    </tr>
  </table>
</body>
</html>