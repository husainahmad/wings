<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>    
    <!-- import the language module -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>

    <!-- other languages might be available in the lang directory; please check
    your distribution archive. -->

    <!-- helper script that uses the calendar -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>
    
                <html:hidden property="idCashOnHand"/>
                
                <%
                    String accountName = "";
                    if (request.getAttribute("accountName")!=null) {
                        accountName=request.getAttribute("accountName").toString();
                    }
                %>
		<tr>
			<td valign="top">
                             
                            <table width="100%">
                                <tr>
                                        <td>Id Perkiraan:</td>
                                        <td>
                                                <html:text property="idAccount" styleId="idAccount" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                                                                                        
                                                <ajax:autocomplete
                                                      source="idAccount"
                                                      target="accountDesc"
                                                      baseUrl="${contextPath}/AccountIdServletAutocomplete"
                                                      className="autocomplete"
                                                      indicator="indicator"
                                                      minimumCharacters="1"
                                                    />                                                    
                                        </td>
                                </tr>
                                <tr>
                                    <td>Trans Date:</td>
                                        <td>
                                            <html:text property="transDateAsString" styleId="transDateAsString" size="10" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                                            <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                            onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                            <script type="text/javascript">
                                                Calendar.setup({
                                                    inputField     :    "transDateAsString",     // id of the input field
                                                    ifFormat       :    "%d/%m/%Y",      // format of the input field
                                                    button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                                                    //align          :    "Tl",           // alignment (defaults to "Bl")
                                                    singleClick    :    true
                                                });
                                            </script>
                                        </td>
                                </tr>
                                <tr>
                                        <td>Type:</td>
                                        <td>
                                            <html:select property="type" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                <html:option value="INCOMING">INCOMING</html:option>
                                                <html:option value="OUTGOING">OUTGOING</html:option>                                                
                                            </html:select>                                            
                                        </td>
                                </tr>
                                <tr>
                                        <td>Description:</td>
                                        <td><html:text property="description" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>                                		
                                <tr>
                                        <td>Remark:</td>
                                        <td><html:text property="remark" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>

                            </table>    
                        </td>
			<td valign="top">
                            <table width="100%">
                                <tr>
                                        <td>Table Name</td>
                                        <td><input type="text" id="accountDesc" name="accountDesc" value="<%=accountName%>" size="38" onkeydown="if(event.keyCode==13) event.keyCode=9;" ></td>                                                                                                                                    
                                                    <ajax:autocomplete
                                                      source="accountDesc"
                                                      target="idAccount"
                                                      baseUrl="${contextPath}/AccountNameServletAutocomplete"
                                                      className="autocomplete"
                                                      indicator="indicator"
                                                      minimumCharacters="1"
                                                    />    
                                </tr>
                                <tr>
                                        <td>Amt IDR:</td>
                                        <td><html:text property="amtIdr" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td>Amt USD:</td>
                                        <td><html:text property="amtUsd" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>                                
                                <tr>
                                        <td>Amt IDR:</td>
                                        <td><html:text property="amt2idr" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                                <tr>
                                        <td>Amt USD:</td>
                                        <td><html:text property="amt2usd" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                </tr>
                            </table>    
                        </td>
		</tr>
                
		
		
		
		
		
