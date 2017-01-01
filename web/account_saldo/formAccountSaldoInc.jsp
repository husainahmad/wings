<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
                            <tr>
                                    <td>IdAccount:</td>
                                    <%
                                        String accountName = "";
                                        if (request.getAttribute("accountName")!=null) {
                                            accountName=request.getAttribute("accountName").toString();
                                        }
                                    %>
                                    <td>
                                        <html:text property="idAccount" styleId="idAccount" size="13" tabindex="6" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>&nbsp;<input type="text" id="accountDesc" name="accountDesc" value="<bean:write name="accountSaldoForm" property="accountName"/>" size="38" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="7">
                                        <input name="ButtonDepartemen" type="button" class="button" style="cursor: hand;" onclick="doAcc()" value=" ... " />
                            <script language="JavaScript">
                                function doAcc() {
                                
                                window.open('<%=request.getContextPath()%>/account/listAccount.do',null,'height=650,width=550,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,left=0,top=0,screenX=0,screenY=0') 
                            }
                            </script>
                                    </td>
                                    <ajax:autocomplete
                                      source="idAccount"
                                      target="accountDesc"
                                      baseUrl="${contextPath}/AccountIdServletAutocomplete"
                                      className="autocomplete"
                                      indicator="indicator"
                                      minimumCharacters="1"
                                    />
                                    <ajax:autocomplete
                                      source="accountDesc"
                                      target="idAccount"
                                      baseUrl="${contextPath}/AccountNameServletAutocomplete"
                                      className="autocomplete"
                                      indicator="indicator"
                                      minimumCharacters="1"
                                    />
                                    <td></td>
                                    <td></td>
                            </tr>
		
		<tr>
			<td>Bulan:</td>
			<td>
                            <html:select  property="bulan">
                                <html:options collection="monthList" property="monthId" labelProperty="monthName"/>
                            </html:select>    
                            
                        </td>
		</tr>
		<tr>
			<td>Tahun:</td>
			<td>
                            <html:select  property="tahun">
                                <html:options collection="yearList" property="tahun" labelProperty="tahun"/>
                            </html:select>                            
                        </td>
		</tr>
		<tr>
			<td>Saldo Akhir:</td>
			<td>
                            <input type="text" name="saldoAkhir" value="<bean:write name="accountSaldoForm"  format="###.##" property="saldoAkhir"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>
		</tr>
                
                <tr>
                    <td>Kurs</td>
                    <td>
                        <html:select property="kurs" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="11">
                                            <html:option value="IDR">IDR</html:option>  
                                            <html:option value="USD">USD</html:option>  
                                        </html:select>
                    </td>                        
                </tr>    
                
                <tr>
                    <td>Range</td>
                    <td>
                        <input type="text" name="kursrange" value="<bean:write name="accountSaldoForm" property="kursrange" format="###"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        &nbsp;
                    </td>                        
                </tr>    
