<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
                <%--
		<tr>
			<td>IdTransactionAcc:</td>
			<td><html:text property="idTransactionAcc" disabled="true"/></td>
		</tr>
                --%>
                <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>
    
                <!-- import the language module -->
                <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>

                <!-- other languages might be available in the lang directory; please check
                your distribution archive. -->

                <!-- helper script that uses the calendar -->
                <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>

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

                    function addBatchPage() {                        
                        url = '<%=request.getContextPath()%>/batch/newBatch.do';
                        popUp('Batch',url,'350','200');                        
                    }
                </script>
                <html:hidden property="idTransactionAcc"/>
                <tr>
                    <td colspan="2">
                        <table width="100%">
                            <tr>
                                <td>Batch No:</td>
                                <td>
                                    <html:text property="noBatch" styleId="noBatch" size="13" tabindex="1" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>-<html:text property="batchDesc" styleId="batchDesc" onkeydown="if(event.keyCode==13) event.keyCode=9;" readonly="true" tabindex="2"/>&nbsp;<input name="addBatch" type="button" class="button" style="cursor: hand;" onclick="addBatchPage()" value="Add" tabindex="20" />
                                    <ajax:autocomplete
                                      source="noBatch"
                                      target="batchDesc"
                                      baseUrl="${contextPath}/BatchServletAutocomplete"
                                      className="autocomplete"
                                      indicator="indicator"
                                      minimumCharacters="1"
                                    />
                                </td>
                                <td></td>
                                <td></td>
                            </tr>
                            <%--
                            <tr>
                                    <td>No:</td>
                                    <td><html:text property="noUrut" size="13"/>&nbsp;<input name="addBatch" type="button" class="button" style="cursor: hand;" value="Get No" /></td>
                                    <td></td>
                                    <td></td>
                            </tr>
                            --%>
                            <html:hidden property="noUrut"/>
                            <html:hidden property="inUrut"/>
                            <tr>
                                    <td>TransactionDate:</td>
                                    <td>
                                        <html:text property="transactionDateAsString" styleId="transactionDateAsString" size="10" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="3"/>
                                        <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                        onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                        <script type="text/javascript">
                                            Calendar.setup({
                                                inputField     :    "transactionDateAsString",     // id of the input field
                                                ifFormat       :    "%d/%m/%Y",      // format of the input field
                                                button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                                                //align          :    "Tl",           // alignment (defaults to "Bl")
                                                singleClick    :    true
                                            });
                                        </script>
                                    </td>
                                    <td></td>
                                    <td></td>
                            </tr>
                            <tr>
                                    <td>ID-No Voucher:</td>
                                    <td><html:text property="voucherDesc" size="6" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="4"/>-<html:text property="noVoucher"  style="text-align: right;"  size="13" tabindex="5" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                    <td></td>
                                    <td></td>
                            </tr>                            
                            <tr>
                                    <td>IdAccount:</td>
                                    <%
                                        String accountName = "";
                                        if (request.getAttribute("accountName")!=null) {
                                            accountName=request.getAttribute("accountName").toString();
                                        }
                                    %>
                                    <td>
                                        <html:text property="idAccount" styleId="idAccount" size="13" tabindex="6" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>&nbsp;<input type="text" id="accountDesc" name="accountDesc" value="<%=accountName%>" size="38" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="7">
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
                                    <td>Description:</td>
                                    <td><html:text property="description" size="55" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="8"/></td>
                                    <td></td>
                                    <td></td>
                            </tr>                            
                            <tr>
                                    <td></td>
                                    <td align="left">
                                        <table width="100%">
                                            <tr>
                                                <td>Debit</td>
                                                <td>Kredit</td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" size="25" name="debitAsString" id="debitAsString" onpropertychange="setDebit()" onblur="this.value=formatCurrency(this.value);" style="text-align: right;" value="<bean:write name="transactionaccForm" property="debit" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="9"></td>
                                                <td><input type="text" size="25" name="kreditAsString" id="kreditAsString" onpropertychange="setKredit()" onblur="this.value=formatCurrency(this.value);" style="text-align: right;" value="<bean:write name="transactionaccForm" property="kredit" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="10"></td>
                                            </tr>
                                                <html:hidden property="debit" styleId="debit" />
                                                <html:hidden property="kredit" styleId="kredit" />                                         
                                        </table>
                              
                                        <script>
                                            function setDebit() {                                            
                                                document.getElementById("debit").value = document.getElementById("debitAsString").value.toString().replace(/\$|\,/g,'');
                                                //alert(document.getElementById("debit").value);
                                                
                                            }
                                            function setKredit() {
                                                document.getElementById("kredit").value = document.getElementById("kreditAsString").value.toString().replace(/\$|\,/g,'');
                                            }
                                            
                                        </script>
                                    </td>
                                    <td></td>
                                    <td></td>
                            </tr>
                            <tr>
                                    <td>Kurs:</td>
                                    <td>                                        
                                        <html:select property="kurs" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="11">
                                            <html:option value="IDR">IDR</html:option>  
                                            <html:option value="USD">USD</html:option>  
                                        </html:select>
                                    </td>
                                    <td></td>
                                    <td></td>
                            </tr>
                            <%--
                            <tr>
                                    
                            </tr>
                            <tr>
                                    <td>JobNo:</td>
                                    <td><html:text property="jobNo"/></td>
                            </tr>
                            --%>
                            <html:hidden property="jobNo"/>
                            <html:hidden property="tglTutupBukuAsString"/>
                            <%--
                            <tr>
                                    <td>TglTutupBuku:</td>
                                    <td>
                                        <html:text property="tglTutupBukuAsString" styleId="tglTutupBukuAsString" size="10"/>
                                        <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_d" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                        onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                        <script type="text/javascript">
                                            Calendar.setup({
                                                inputField     :    "tglTutupBukuAsString",     // id of the input field
                                                ifFormat       :    "%d/%m/%Y",      // format of the input field
                                                button         :    "f_trigger_d",  // trigger for the calendar (button ID)
                                                //align          :    "Tl",           // alignment (defaults to "Bl")
                                                singleClick    :    true
                                            });
                                        </script>
                                    </td>
                                    <td></td>
                                    <td></td>
                            </tr>
                            --%>
                        </table> 
                    </td>                    
                </tr>
                <%--
                <tr>
                    <td colspan="2">
                        <display:table name="transactionaccs" id="transactionacc" class="report" requestURI="/transactionacc/newTransactionacc.do"    
                             decorator="com.wings.struts.decorators.TransactionaccWrapper" pagesize="10">                                                                                    
                            <display:column property="dateTrans" title="Transaction Date" sortable="true"/>
                            <display:column property="noBatch" title="Batch No" sortable="true"/>
                            <display:column property="batchDesc" title="Batch Desc" sortable="true"/>
                            <display:column property="noUrut" title="Index No" sortable="true"/>
                            <display:column property="idAccount" title="Account" sortable="true"/>
                            <display:column property="description" title="Description" sortable="true"/>
                            <display:column property="debitTrans" title="Debit" sortable="true"/>
                            <display:column property="kreditTrans" title="Kredit" sortable="true"/>
                            <display:column property="linkEdit" title="Action"/>
                            
                        </display:table>                                                                        
                    </td>
                </tr>
                
                <tr>                                       
                    <td class="ver12gray" colspan="2">&nbsp;	
                        <table width="30%">
                            <tr>
                                <th bgColor="#dbdbd4" align="center" class="ver10gray">
                                    <strong>Debit</strong>
                                </th>
                                <th bgColor="#dbdbd4" align="center" class="ver10gray">
                                    <strong>Kredit</strong>
                                </th>
                            </tr>
                            <tr>
                                <td align="right" class="ver10gray" width="25%">
                                    <%=request.getAttribute("totalDebit")%>
                                </td>
                                <td align="right" class="ver10gray" width="25%">
                                    <%=request.getAttribute("totalKredit")%>
                                </td>
                            </tr>
                            
                        </table>
                    </td>
                </tr> 
                --%>
                <%--
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" name="refreshData" value="Refresh data in current batch and tgl tutup buku">
                        
                    </td>
                </tr>
                --%>
                <%
                List transAcc = null;
                if (request.getSession().getAttribute("transactionAccList")!=null) {
                    transAcc = (List)request.getSession().getAttribute("transactionAccList");
                }
                request.setAttribute("listAcc", transAcc);               
                %>
                
                <tr>
                    <td colspan="2">
                        <display:table name="listAcc" id="transactionacc" class="report" 
                             decorator="com.wings.struts.decorators.TransactionaccWrapper" pagesize="10">                                                                                    
                            <display:column property="dateTrans" title="Transaction Date" sortable="true"/>
                            <display:column property="noBatch" title="Batch No" sortable="true"/>
                            <display:column property="batchDesc" title="Batch Desc" sortable="true"/>
                            <display:column property="noUrut" title="Index No" sortable="true"/>
                            <display:column property="idAccount" title="Account" sortable="true"/>
                            <display:column property="description" title="Description" sortable="true"/>
                            <display:column property="debitTrans" title="Debit" sortable="true"/>
                            <display:column property="kreditTrans" title="Kredit" sortable="true"/>                            
                            
                        </display:table>                                                                        
                    </td>
                </tr>
                <tr>
                    <td colspan="2" height="20">                        
                    </td>
                </tr>