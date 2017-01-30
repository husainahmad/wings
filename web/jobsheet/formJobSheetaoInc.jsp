<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>
    

    <!-- import the language module -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>

    <!-- other languages might be available in the lang directory; please check
    your distribution archive. -->

    <!-- helper script that uses the calendar -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>
    <%
        java.text.DecimalFormat moneyFormat = new java.text.DecimalFormat("#,###,###.##");
        com.wings.web.struts.forms.KursdollarForm kursForm = (com.wings.web.struts.forms.KursdollarForm)request.getSession().getAttribute("kursdollarForm");
        String kursDollar = moneyFormat.format(kursForm.getValue().doubleValue());
    %>

    <script>
         var kursDollar = "<%=kursDollar%>";
             function getDataBilling() {
                var data = "";
                 <logic:iterate id="agentfees" name="agentfees" type="com.wings.persistence.Agentfee">                                
                     data +="<option value=\"<bean:write name="agentfees" property="idAgentFee"/>\"><bean:write name="agentfees" property="description"/></option>";
                 </logic:iterate>    
                return data;
             }
             function getDataInvoice() {
                var data = "";
                 <logic:iterate id="shipperfees" name="shipperfees" type="com.wings.persistence.Shipperfee">                                
                     data +="<option value=\"<bean:write name="shipperfees" property="idShipperFee"/>\"><bean:write name="shipperfees" property="description"/></option>";
                 </logic:iterate>    
                return data;
             }
             function showTRInbound(theTR, img) {
        
                var DataTR = eval('document.all.' + theTR);

                if (DataTR.style.display=="block" || DataTR.style.display=="" )
                {
                    document.getElementById(img).src="<%=request.getContextPath()%>/Images/arrowCollapsed.gif";
                    DataTR.style.display="none";
                } else {
                    document.getElementById(img).src="<%=request.getContextPath()%>/Images/arrowDown.gif";
                    DataTR.style.display="block";            
                }

            }
            function showTROutbound(theTR, img) {

                var DataTR = eval('document.all.' + theTR);

                if (DataTR.style.display=="block" || DataTR.style.display=="" )
                {
                    document.getElementById(img).src="<%=request.getContextPath()%>/Images/arrowCollapsed.gif";
                    DataTR.style.display="none";
                } else {
                    document.getElementById(img).src="<%=request.getContextPath()%>/Images/arrowDown.gif";
                    DataTR.style.display="block";            
                }

            }
                                    
         </script>
         <script>
             function countCharge(oriKurs,oriWeight,charge) {
                var oks = document.getElementById(oriKurs).value; 
                oks = oks.toString().replace(/\$|\,/g,'');
                var ow = document.getElementById(oriWeight).value; 
                ow = ow.toString().replace(/\$|\,/g,'');                
                var tot = 0;
                tot = oks*ow;
                document.getElementById(charge).value = formatCurrency(tot);                                    
            }
            
         </script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/js/jobsheet_counting.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/js/jobsheet_add_remove_row_ao.js"></script>
         <tr>
             <td>                          
                 <table width="100%">
                     <tr><html:hidden name="jobsheetaoDetailForm" property="idJobSheet"/>
                     <html:hidden name="jobsheetaoDetailForm" property="idJobSheetAo"/>
                        <td>Job.No:</td>
			<td>                            
                            <logic:equal name="action" value="insert">
                                 [Job.No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="copy">
                                 [Job.No will be generate by system]
                            </logic:equal>
                            <logic:equal name="action" value="updateAsNew">
                                 <html:text name="jobsheetaoDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="update">
                                 <html:text name="jobsheetaoDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetaoDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>          
                            </logic:equal>      
                        </td>
                        <td width="5"></td>
                        <td>Date:</td>
                            <td>
                                <html:text name="jobsheetaoDetailForm" property="shippeddateAsString" styleId="shippeddateAsString" size="10" tabindex="8" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                                
                                <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                <script type="text/javascript">
                                    Calendar.setup({
                                        inputField     :    "shippeddateAsString",     // id of the input field
                                        ifFormat       :    "%d/%m/%Y",      // format of the input field
                                        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                                        //align          :    "Tl",           // alignment (defaults to "Bl")
                                        singleClick    :    true
                                    });
                                </script>
                            </td>
                     </tr> 
                     <tr>
                        <td>Invoice.No:</td>
			<td>
                            <logic:equal name="action" value="insert">
                                 [Invoice.No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="copy">
                                 [Invoice.No will be generate by system]
                            </logic:equal>
                            <logic:equal name="action" value="updateAsNew">
                                 [Invoice.No will be generate by system] 
                            </logic:equal>
                            <logic:equal name="action" value="update">
                                 <html:text name="jobsheetaoDetailForm" property="invoiceNoUsd" size="35" readonly="true"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetaoDetailForm" property="invoiceNoUsd" size="35" readonly="true"/>          
                            </logic:equal>                            
                        </td>
                        <td width="5"></td>                
                         <td>Operation Staff:</td>
			<td><html:text name="jobsheetaoDetailForm" property="operationStaff" size="35" tabindex="9"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr> 
                     
                      <tr>
                        <td>DN No:</td>
			<td>                            
                            <logic:equal name="action" value="insert">
                                 [DN No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="copy">
                                 [DN No will be generate by system]
                            </logic:equal>
                            <logic:equal name="action" value="updateAsNew">
                                 [DN No will be generate by system]      
                            </logic:equal>
                            <logic:equal name="action" value="update">
                                 <html:text name="jobsheetaoDetailForm" property="debitNo" size="35" readonly="true"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetaoDetailForm" property="debitNo" size="35" readonly="true"/>          
                            </logic:equal>
                        </td>
                        <td width="5"></td>                
                         <td>PIC Coloadeer:</td>
			<td><html:text name="jobsheetaoDetailForm" property="picColoader" size="35" tabindex="10"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr> 
                      <tr>
                        <td>Shipper:</td>
			<td>
                             <html:hidden name="jobsheetaoDetailForm" property="idShipper" styleId="idShipper"/>
                            <html:text name="jobsheetaoDetailForm" property="shipperName" styleId="shipperName" size="35" tabindex="1"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
                            <ajax:autocomplete
                              source="shipperName"
                              target="idShipper"
                              baseUrl="${contextPath}/ShipperServletAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                               
                        </td>
                        <td width="5"></td>                
                         <td>MAWB:</td>
			<td><html:text name="jobsheetaoDetailForm" property="mawb" size="35" tabindex="11" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr> 
                      <tr>
                        <td>Consignee:</td>
			<td>
                            <html:hidden name="jobsheetaoDetailForm" property="idConsignee" styleId="idConsignee"/>
                            <html:text name="jobsheetaoDetailForm" property="consigneeName" styleId="consigneeName" size="35" tabindex="2" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
                            <ajax:autocomplete
                              source="consigneeName"
                              target="idConsignee"
                              baseUrl="${contextPath}/ConsigneeServletAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                            
                        </td>
                        <td width="5"></td>                
                         <td>HAWB:</td>
			<td><html:text name="jobsheetaoDetailForm" property="hawb" size="35" tabindex="12" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr> 
                     <tr>
                        <td>Agents:</td>
			<td>
                            <html:hidden name="jobsheetaoDetailForm" property="idAgent" styleId="idAgent"/>
                            <html:text name="jobsheetaoDetailForm" property="agentName" styleId="agentName" size="35" tabindex="3" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                           
                            <ajax:autocomplete
                              source="agentName"
                              target="idAgent"
                              baseUrl="${contextPath}/AgentServletAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                            
                        </td>
                        <td width="5"></td>               
                         <td>Qty/Weight:</td>
			<td><html:text name="jobsheetaoDetailForm" property="qtyDesc" size="13" tabindex="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>/<html:text name="jobsheetaoDetailForm" property="weightDesc" size="13" tabindex="14" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr> 
                      <tr>
                        <td>Forwarder:</td>
			<td>                            
                            <html:text name="jobsheetaoDetailForm" property="forwarderName" styleId="forwarderName" size="35" tabindex="3" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            <html:hidden name="jobsheetaoDetailForm" property="idForwarder" styleId="idForwarder"/>
                            <ajax:autocomplete
                              source="forwarderName"
                              target="idForwarder"
                              baseUrl="${contextPath}/ForwarderServletAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="0"
                            />
                        </td>
                        <td width="5"></td>               
                         <td></td>
			<td></td>
                     </tr> 
                     <tr>
                        <td>Destination:</td>
			<td>                            
                            <html:hidden name="jobsheetaoDetailForm" property="destination" styleId="destination"/>
                            <html:text name="jobsheetaoDetailForm" property="destinationName" styleId="destinationName" size="20" tabindex="4" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
                            <ajax:autocomplete
                              source="destinationName"
                              target="destination"
                              baseUrl="${contextPath}/DestinationSerlvetAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                        </td>
                        <td width="5"></td> 
                         <td>Volume:</td>
			<td><html:text name="jobsheetaoDetailForm" property="volumeDesc" size="30" tabindex="15" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                     
                    </tr> 
                     <tr>
                        <td>Flight</td>
			<td><html:text name="jobsheetaoDetailForm" property="flights" size="35" tabindex="5" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>
                         <td>Dimention:</td>
			<td><html:text name="jobsheetaoDetailForm" property="dimention" size="35" tabindex="16" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                     
                     </tr> 
                     <tr>
                        <td>Cnt.Flight</td>
			<td><html:text name="jobsheetaoDetailForm" property="cntFlight" size="35" tabindex="5" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>                
                         <td>Commodity:</td>
			<td><html:text name="jobsheetaoDetailForm" property="commodity" size="35" tabindex="17" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                     
                     </tr> 
                     <tr>
                        <td>FreightTerm </td>
			<td><html:text name="jobsheetaoDetailForm" property="freightTerm" size="35" tabindex="6" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>  
                        <td>Transport  To</td>
			<td>
                            <html:hidden name="jobsheetaoDetailForm" property="idTransporter" styleId="idTransporter"/>
                            <html:text name="jobsheetaoDetailForm" property="transportName" styleId="transportName" size="35" tabindex="19" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                           
                            <ajax:autocomplete
                              source="transportName"
                              target="idTransporter"
                              baseUrl="${contextPath}/TransporterSerlvetAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                            
                        </td>                                            
                        
                     </tr> 
                     <tr>
                        <td>Booking To </td>
			<td><html:text name="jobsheetaoDetailForm" property="bookingTo" size="35" tabindex="7" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>   
                        <td>CMB</td>
			<td>
                            <html:text name="jobsheetaoDetailForm" property="cmb" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                            
                        </td>                     
                     </tr> 
                     <tr>
                        <td>Bill To (Debit)</td>
			<td>
                                <html:select name="jobsheetaoDetailForm" property="billToDebit" tabindex="20" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                    <html:option value="1">Agent</html:option>
                                    <html:option value="2">Consignee</html:option>
                                    <html:option value="3">Shipper</html:option>
                                    <html:option value="4">Shipping Line</html:option>
                                </html:select>
                        </td>   
                        <td width="5"></td>               
                        <td>Bill To (Invoice)</td>
			<td>
                                <html:select name="jobsheetaoDetailForm" property="billTo" tabindex="20" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                    <html:option value="1">Agent</html:option>
                                    <html:option value="2">Consignee</html:option>
                                    <html:option value="3">Shipper</html:option>
                                    <html:option value="4">Shipping Line</html:option>
                                </html:select>
                        </td>   
                     </tr>
                     <tr>
                        <td>C/N No.</td>
			<td><html:text name="jobsheetaoDetailForm" property="cnNo" size="35" tabindex="21" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>  
                        <td></td>
			<td>                            
                        </td>
                        <%--
                        <td>Amount:</td>
			<td>
                            <html:text name="jobsheetaoDetailForm" property="depart" size="20" tabindex="22" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            Kurs 
                            <html:select name="jobsheetaoDetailForm" property="cnKurs" tabindex="23" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                <html:option value="IDR">IDR</html:option>
                                <html:option value="USD">USD</html:option>                                
                            </html:select>
                        </td>     
                        --%>
                     </tr>
                     <tr>
                        <td>Komisi Agent IDR</td>
                        <td><html:text name="jobsheetaoDetailForm" property="refundIDR" styleId="refundIDR" size="35" maxlength="35" tabindex="24" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>   
                        <td>Komisi Agent USD</td>
			<td>
                            <html:text name="jobsheetaoDetailForm" property="refundUSD" styleId="refundUSD" size="35" maxlength="35" tabindex="24" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>                                          
                     </tr>
                     <tr>
                        <td>Credit Note IDR</td>
			<td><html:text name="jobsheetaoDetailForm" property="creditNoteIDR" styleId="creditNoteIDR" size="35" maxlength="35" tabindex="26" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>   
                        <td>Credit Note USD</td>
			<td><html:text name="jobsheetaoDetailForm" property="creditNoteUSD" styleId="creditNoteUSD" size="35" maxlength="35" tabindex="26" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr>
                     
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     <tr bgcolor="#b7b7af" onmousedown="showTRInbound('tableSellingDebitNote','imgInbound');" style="cursor:hand">
                         <td valign="middle" colspan="5">&nbsp;&nbsp;<img id="imgInbound" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Selling Debit Note</strong></td>
                    </tr>
                     <tr>
                            <td colspan="5" height="5">                                
                            <table cellpadding="2" cellspacing="2" width="100%" id="tableSellingDebitNote">
                                <tr bgColor="#b7b7af" >
                                    <td width="25%" align="center">
                                        Fee
                                    </td>
                                    <td align="center">
                                        Rate
                                    </td>
                                    <td align="center">
                                        Weight
                                    </td>
                                    <td width="25%" align="center">
                                        Value
                                    </td>
                                    <td width="25%" align="center">
                                        Description Job
                                    </td>
                                    <td width="25%" align="center">
                                        Description Debit/Invoice
                                    </td>
                                    <td width="25%" align="center">
                                        Kurs
                                    </td>                                                        
                                    <td width="25%" align="center">
                                        Kurs Value
                                    </td>                         
<!--                                    <td width="25%" align="center">
                                        VAT
                                    </td> 
                                    <td width="25%" align="center">
                                        PPH23
                                    </td> 
                                    <td width="25%" align="center">
                                        VAT 1 %
                                    </td> -->
                                    <td width="25%" align="center">
                                        Action
                                    </td>                         
                                </tr>                                                                   
                                    <% int i = 0; 
                                    java.util.List agentfeeList = (java.util.List)request.getAttribute("agentfees");
                                    java.util.List shipperfeeList = (java.util.List)request.getAttribute("shipperfees");

                                    %>
                                    <logic:notEmpty name="billAgentList" scope="request">                                                                                            
                                            <logic:iterate id="billAgent" name="billAgentList" type="com.wings.persistence.Billingagent">                                
                                        <%
                                        com.wings.persistence.Billingagent billingagent = (com.wings.persistence.Billingagent)billAgent;
                                        i++;
                                        %>
                                            <span id="dasbaDebit<%=i%>">
                                            <tr>
                                                <td width="25%">
                                                    <select name="billingidAgentFeeDebit<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                            for (int j=0;j<agentfeeList.size();j++) {
                                                                com.wings.persistence.Agentfee agfee = (com.wings.persistence.Agentfee)agentfeeList.get(j);
                                                                if (agfee.getIdAgentFee().equals(billingagent.getIdAgentFee())) {
                                                        %>
                                                                    <option value="<%=agfee.getIdAgentFee()%>" selected><%=agfee.getDescription()%></option>
                                                        <%
                                                                } else {
                                                        %>
                                                                    <option value="<%=agfee.getIdAgentFee()%>"><%=agfee.getDescription()%></option>
                                                        <%
                                                                }                                                                    
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                                <td><input type="text" name="billingAgentOriKursDebit<%=i%>" id="billingAgentOriKursDebit<%=i%>" value="<bean:write name="billAgent" property="oriKurs" format="#,###,###.##"/>" size="10" onchange="countCharge('billingAgentOriKursDebit<%=i%>','billingAgentOriWeightDebit<%=i%>','billingAgentChargeDebit<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td><input type="text" name="billingAgentOriWeightDebit<%=i%>" id="billingAgentOriWeightDebit<%=i%>" value="<bean:write name="billAgent" property="oriWeight" format="#,###,###.##"/>" size="10" onchange="countCharge('billingAgentOriKursDebit<%=i%>','billingAgentOriWeightDebit<%=i%>','billingAgentChargeDebit<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                                       
                                                <td width="25%"><input type="text" name="billingAgentChargeDebit<%=i%>" id="billingAgentChargeDebit<%=i%>" value="<bean:write name="billAgent" property="charge" format="#,###,###.##"/>" size="10" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="billingAgentDescDebit<%=i%>" id="billingAgentDescDebit<%=i%>" value="<bean:write name="billAgent" property="description"/>" size="20"onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="billingAgentDescriptionDebit<%=i%>" id="billingAgentDescriptionDebit<%=i%>" value="<bean:write name="billAgent" property="descriptionInvoice"/>" size="20"onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%">
                                                    <select name="billingAgentKursDebit<%=i%>" id="billingAgentKursDebit<%=i%>" onchange="countBilling()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                        if (billingagent.getKurs().equalsIgnoreCase("IDR")) {
                                                        %>
                                                            <option value="IDR" selected>IDR</option>
                                                            <option value="USD">USD</option>
                                                        <%
                                                        } else {
                                                        %>
                                                            <option value="IDR">IDR</option>
                                                            <option value="USD" selected>USD</option>
                                                        <%
                                                        }
                                                        %>                                                                
                                                    </select>
                                                </td>
                                                <td width="25%"><input type="text" name="billingAgentKursValueDebit<%=i%>"id="billingAgentKursValueDebit<%=i%>"  value="<bean:write name="billAgent" property="kursValue" format="#,###,###.##"/>" size="10" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <%--<td width="25%"><input type="checkbox" name="billingAgentTaxDebit<%=i%>" id="billingAgentTaxDebit<%=i%>" value="<bean:write name="billAgent" property="isTax" />" <%=billingagent.getIsTax().intValue()>0 ? " checked " : ""%> size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>--%>
                                                <%--<td width="25%"><input type="checkbox" name="billingAgentVatDebit<%=i%>" id="billingAgentVatDebit<%=i%>" value="<bean:write name="billAgent" property="isVat" />" <%=billingagent.getIsVat().intValue()>0 ? " checked " : ""%> size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>--%>
                                                <%--<td width="25%"><input type="checkbox" name="billingAgentTax2Debit<%=i%>" id="billingAgentTax2Debit<%=i%>" value="<bean:write name="billAgent" property="isTax2" />" <%=billingagent.getIsTax2().intValue()>0 ? " checked " : ""%> size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>--%>
                                                <td><input type="button" value="-" onclick="subtractbaDebit2(<%=i%>)">&nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('billingAgentKursValueDebit<%=i%>','billingAgentChargeDebit<%=i%>','billingAgentKursDebit<%=i%>')" > </td>
                                            </tr>
                                            </span>
                                        </logic:iterate>   
                                        </logic:notEmpty>
                                </table>                                                                            
                            </td>
                     </tr>
                     <tr>
                         <td valign="middle" colspan="5">
                                    <input type="button" onclick="addbaDebit()" value=" + ">
                                    <input type="button" onclick="subtractbaDebit()" value=" - "> 
                                    <input type="hidden" name="dacountbaDebit" id="dacountbaDebit" value="<%=i%>">
                            </td>
                        </tr>
                      <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     <tr bgcolor="#b7b7af" onmousedown="showTROutbound('tableSellingInvoice','imgOutbound');" style="cursor:hand">
                         <td valign="middle" colspan="5">&nbsp;&nbsp;<img id="imgOutbound" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Selling Invoice</strong></td>
                    </tr>
                     <tr>
                            <td colspan="5" height="5">                                
                                <table cellpadding="2" cellspacing="2" width="100%" id="tableSellingInvoice">
                                    <tr bgColor="#b7b7af" >
                                        <td width="25%" align="center">
                                            Fee
                                        </td>
                                        <td align="center">
                                            Rate
                                        </td>
                                        <td align="center">
                                            Weight
                                        </td>
                                        <td width="25%" align="center">
                                            Value
                                        </td>
                                        <td width="25%" align="center">
                                            Description Job
                                        </td>
                                        <td width="25%" align="center">
                                            Description Debit/Invoice
                                        </td>
                                        <td width="25%" align="center">
                                            Kurs
                                        </td>                                                        
                                        <td width="25%" align="center">
                                            Kurs Value
                                        </td>
                                        <td width="25%" align="center">
                                            VAT
                                        </td>       
                                            <td width="25%" align="center">
                                            PPH23
                                        </td>     
                                        <td width="25%" align="center">
                                            VAT 1%
                                        </td>
                                        <td width="25%" align="center">
                                            Action
                                        </td>                         
                                        </tr>
                                            <% i = 0; %>
                                            <logic:notEmpty name="billShipperList" scope="request">
                                                <logic:iterate id="billShipper" name="billShipperList" type="com.wings.persistence.Billingshipper">                                                                                                                            
                                                <%
                                                com.wings.persistence.Billingshipper billS = (com.wings.persistence.Billingshipper)billShipper;
                                                i++;
                                                %>
                                                <span id="dasbaInvoice<%=i%>">   
                                                <tr>
                                                    <td width="25%">
                                                        <select name="billingidAgentFeeInvoice<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                            <%
                                                                for (int j=0;j<shipperfeeList.size();j++) {
                                                                    com.wings.persistence.Shipperfee shippFee = (com.wings.persistence.Shipperfee)shipperfeeList.get(j);
                                                                    if (shippFee.getIdShipperFee().equals(billS.getIdShipperFee())) {
                                                            %>
                                                                        <option value="<%=shippFee.getIdShipperFee()%>" selected><%=shippFee.getDescription()%></option>
                                                            <%
                                                                    } else {
                                                            %>
                                                                        <option value="<%=shippFee.getIdShipperFee()%>"><%=shippFee.getDescription()%></option>
                                                            <%
                                                                    }                                                                    
                                                                }
                                                            %>
                                                        </select>
                                                    </td>
                                                    <td><input type="text" name="billingAgentOriKursInvoice<%=i%>" id="billingAgentOriKursInvoice<%=i%>" value="<bean:write name="billShipper" property="oriKurs" format="#,###,###.##"/>" size="10" onchange="countCharge('billingAgentOriKursInvoice<%=i%>','billingAgentOriWeightInvoice<%=i%>','billingAgentChargeInvoice<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td><input type="text" name="billingAgentOriWeightInvoice<%=i%>" id="billingAgentOriWeightInvoice<%=i%>" value="<bean:write name="billShipper" property="oriWeight" format="#,###,###.##"/>" size="10" onchange="countCharge('billingAgentOriKursInvoice<%=i%>','billingAgentOriWeightInvoice<%=i%>','billingAgentChargeInvoice<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="text" name="billingAgentChargeInvoice<%=i%>" id="billingAgentChargeInvoice<%=i%>" value="<bean:write name="billShipper" property="charge" format="#,###,###.##"/>" size="10" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="text" name="billingAgentDescInvoice<%=i%>" id="billingAgentDescInvoice<%=i%>" value="<bean:write name="billShipper" property="description"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="text" name="billingAgentDescriptionInvoice<%=i%>" id="billingAgentDescriptionInvoice<%=i%>" value="<bean:write name="billShipper" property="descriptionInvoice"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>

                                                    <td width="25%">
                                                        <select name="billingAgentKursInvoice<%=i%>" id="billingAgentKursInvoice<%=i%>" onchange="countBilling()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                            <%
                                                            if (billS.getKurs().equalsIgnoreCase("IDR")) {
                                                            %>
                                                                <option value="IDR" selected>IDR</option>
                                                                <option value="USD">USD</option>
                                                            <%
                                                            } else {
                                                            %>
                                                                <option value="IDR">IDR</option>
                                                                <option value="USD" selected>USD</option>
                                                            <%
                                                            }
                                                            %> 
                                                        </select>
                                                    </td>
                                                    <td width="25%"><input type="text" name="billingAgentKursValueInvoice<%=i%>" id="billingAgentKursValueInvoice<%=i%>" value="<bean:write name="billShipper" property="kursValue" format="#,###,###.##"/>" size="10" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentTaxInvoice<%=i%>" id="billingAgentTaxInvoice<%=i%>" value="1" <%=billS.getIsTax().intValue()>0 ? " checked " : ""%>  onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentVatInvoice<%=i%>" id="billingAgentVatInvoice<%=i%>" value="1" <%=billS.getIsVat().intValue()>0 ? " checked " : ""%>  onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentTax2Invoice<%=i%>" id="billingAgentTax2Invoice<%=i%>" value="1" <%=billS.getIsTax2().intValue()>0 ? " checked " : ""%>  onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td><input type="button" value="-" onclick="subtractbaInvoice2(<%=i%>)">&nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('billingAgentKursValueInvoice<%=i%>','billingAgentChargeInvoice<%=i%>','billingAgentKursInvoice<%=i%>')" >  </td>
                                                </tr>      
                                                </span>
                                             </logic:iterate>  
                                            </logic:notEmpty>
                                        </table>                                    
                            </td>
                     </tr>
                     <tr>
                         <td valign="middle" colspan="5">
                                <input type="button" onclick="addbaInvoice()" value=" + ">
                                <input type="button" onclick="subtractbaInvoice()" value=" - "> 
                                <input type="hidden" name="dacountbaInvoice" id="dacountbaInvoice" value="<%=i%>">
                        </td>
                    </tr>                                   
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     <tr bgcolor="#b7b7af" onmousedown="showTRInbound('tableCostDebitNote','imgInbound2');" style="cursor:hand">
                         <td valign="middle" colspan="5">&nbsp;&nbsp;<img id="imgInbound2" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Cost Agent Debit Note</strong></td>
                    </tr>
                     <tr>
                            <td colspan="5" height="5">                               
                                <table cellpadding="2" cellspacing="2" width="100%" id="tableCostDebitNote">
                                    <tr bgColor="#b7b7af" >
                                        <td width="25%" align="center">
                                            Fee
                                        </td>
                                        <td align="center">
                                            Rate
                                        </td>
                                        <td align="center">
                                            Weight
                                        </td>
                                        <td width="25%" align="center">
                                            Value
                                        </td>
                                        <td width="25%" align="center">
                                            Description Job
                                        </td>
                                        <td width="25%" align="center">
                                            Description Debit/Invoice
                                        </td>
                                        <td width="25%" align="center">
                                            Kurs
                                        </td>
                                        <td width="25%" align="center">
                                            Kurs Value
                                        </td> 
<!--                                        <td width="25%" align="center">
                                            Tax
                                        </td>  
                                        <td width="25%" align="center">
                                            Vat
                                        </td> -->
                                        <td width="25%" align="center">
                                            Action
                                        </td>                         
                                    </tr>                                  
                                    <% i = 0; %>
                                    <logic:notEmpty name="expensesAgentList" scope="request">
                                        <logic:iterate id="expAgent" name="expensesAgentList" type="com.wings.persistence.Expensesagent">                                                                                                                            
                                        <%
                                        com.wings.persistence.Expensesagent exAgent = (com.wings.persistence.Expensesagent)expAgent;
                                        i++;
                                        %>
                                            <span id="dasexpensesagentDebit<%=i%>">
                                            <tr>
                                                <td width="25%">
                                                    <select name="expensesidAgentFeeDebit<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                            for (int j=0;j<agentfeeList.size();j++) {
                                                                com.wings.persistence.Agentfee agfee = (com.wings.persistence.Agentfee)agentfeeList.get(j);
                                                                if (agfee.getIdAgentFee().equals(exAgent.getIdAgentFee())) {
                                                        %>
                                                                    <option value="<%=agfee.getIdAgentFee()%>" selected><%=agfee.getDescription()%></option>
                                                        <%
                                                                } else {
                                                        %>
                                                                    <option value="<%=agfee.getIdAgentFee()%>"><%=agfee.getDescription()%></option>
                                                        <%
                                                                }                                                                    
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                                <td><input type="text" name="expensesAgentOriKursDebit<%=i%>" id="expensesAgentOriKursDebit<%=i%>" value="<bean:write name="expAgent" property="oriKurs" format="#,###,###.##"/>" size="10" onchange="countCharge('expensesAgentOriKursDebit<%=i%>','expensesAgentOriWeightDebit<%=i%>','expensesAgentChargeDebit<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td><input type="text" name="expensesAgentOriWeightDebit<%=i%>" id="expensesAgentOriWeightDebit<%=i%>" value="<bean:write name="expAgent" property="oriWeight" format="#,###,###.##"/>" size="10" onchange="countCharge('expensesAgentOriKursDebit<%=i%>','expensesAgentOriWeightDebit<%=i%>','expensesAgentChargeDebit<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentChargeDebit<%=i%>" id="expensesAgentChargeDebit<%=i%>" value="<bean:write name="expAgent" property="charge" format="#,###,###.##"/>" size="10" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentDescDebit<%=i%>" id="expensesAgentDescDebit<%=i%>" value="<bean:write name="expAgent" property="description"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentDescriptionDebit<%=i%>" id="expensesAgentDescriptionDebit<%=i%>" value="<bean:write name="expAgent" property="descriptionInvoice"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%">
                                                    <select name="expensesAgentKursDebit<%=i%>" id="expensesAgentKursDebit<%=i%>" onchange="countBilling()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                        if (exAgent.getKurs().equalsIgnoreCase("IDR")) {
                                                        %>
                                                            <option value="IDR" selected>IDR</option>
                                                            <option value="USD">USD</option>
                                                        <%
                                                        } else {
                                                        %>
                                                            <option value="IDR">IDR</option>
                                                            <option value="USD" selected>USD</option>
                                                        <%
                                                        }
                                                        %>       
                                                    </select>
                                                </td> 
                                                <td width="25%"><input type="text" name="expensesAgentKursValueDebit<%=i%>" id="expensesAgentKursValueDebit<%=i%>" value="<bean:write name="expAgent" property="kursValue" format="#,###,###.##"/>" size="10" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
<!--                                                <td width="25%"><input type="checkbox" name="expensesAgentTaxDebit<%=i%>" id="expensesAgentTaxDebit<%=i%>" value="<bean:write name="expAgent" property="isTax" />" <%=exAgent.getIsTax().intValue()>0 ? " checked " : ""%>  size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="checkbox" name="expensesAgentVatDebit<%=i%>" id="expensesAgentVatDebit<%=i%>" value="<bean:write name="expAgent" property="isVat" />" <%=exAgent.getIsVat().intValue()>0 ? " checked " : ""%>  size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                                -->
                                                <td><input type="button" value="-" onclick="subtractexpensesagentDebit2(<%=i%>)">&nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('expensesAgentKursValueDebit<%=i%>','expensesAgentChargeDebit<%=i%>','expensesAgentKursDebit<%=i%>')" >  </td>
                                            </tr>   
                                            </span>
                                        </logic:iterate>  
                                    </logic:notEmpty>
                                    </table>                                 
                            </td>
                     </tr>
                     <tr>
                         <td valign="middle" colspan="5">
                                    <input type="button" onclick="addexpensesagentDebit()" value=" + ">
                                    <input type="button" onclick="subtractexpensesagentDebit()" value=" - "> 
                                    <input type="hidden" name="dacountexpensesagentDebit" id="dacountexpensesagentDebit" value="<%=i%>">
                            </td>
                     </tr>
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     <tr bgcolor="#b7b7af" onmousedown="showTROutbound('tableCostInvoice','imgOutbound2');" style="cursor:hand">
                         <td valign="middle" colspan="5">&nbsp;&nbsp;<img id="imgOutbound2" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Cost Invoice</strong></td>
                    </tr>
                     <tr>
                            <td colspan="5" height="5">
                                <table cellpadding="2" cellspacing="2" width="100%" id="tableCostInvoice">
                                    <tr  bgColor="#b7b7af">
                                        <td width="25%" align="center">
                                            Fee
                                        </td>
                                        <td align="center">
                                            Rate
                                        </td>
                                        <td align="center">
                                            Weight
                                        </td>
                                        <td width="25%" align="center">
                                            Value
                                        </td>
                                        <td width="25%" align="center">
                                            Description Job
                                        </td>
                                        <td width="25%" align="center">
                                            Description Debit/Invoice
                                        </td>
                                        <td width="25%" align="center">
                                            Kurs
                                        </td>                         
                                        <td width="25%" align="center">
                                            Kurs Value
                                        </td>                         
<!--                                        <td width="25%" align="center">
                                            Tax
                                        </td>  
                                        <td width="25%" align="center">
                                            Vat
                                        </td> -->
                                        <td width="25%" align="center">
                                            Action
                                        </td>                         
                                    </tr>                                           
                                         <% i = 0; %>                                           
                                    <logic:notEmpty name="expensesShipperList" scope="request">
                                        <logic:iterate id="expShipper" name="expensesShipperList" type="com.wings.persistence.Expensesshipper">                                                                                                                            
                                        <%
                                        com.wings.persistence.Expensesshipper exShipper = (com.wings.persistence.Expensesshipper)expShipper;
                                        i++;
                                        %>
                                            <tr>
                                                <td width="25%">
                                                    <select name="expensesidAgentFeeInvoice<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                            for (int j=0;j<shipperfeeList.size();j++) {
                                                                com.wings.persistence.Shipperfee shipperfee = (com.wings.persistence.Shipperfee)shipperfeeList.get(j);
                                                                if (shipperfee.getIdShipperFee().equals(exShipper.getIdShipperFee())) {
                                                        %>
                                                                    <option value="<%=shipperfee.getIdShipperFee()%>" selected><%=shipperfee.getDescription()%></option>
                                                        <%
                                                                } else {
                                                        %>
                                                                    <option value="<%=shipperfee.getIdShipperFee()%>"><%=shipperfee.getDescription()%></option>
                                                        <%
                                                                }                                                                    
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                                <td><input type="text" name="expensesAgentOriKursInvoice<%=i%>" id="expensesAgentOriKursInvoice<%=i%>" value="<bean:write name="expShipper" property="oriKurs" format="#,###,###.##"/>" size="10" onchange="countCharge('expensesAgentOriKursInvoice<%=i%>','expensesAgentOriWeightInvoice<%=i%>','expensesAgentChargeInvoice<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td><input type="text" name="expensesAgentOriWeightInvoice<%=i%>" id="expensesAgentOriWeightInvoice<%=i%>" value="<bean:write name="expShipper" property="oriWeight" format="#,###,###.##"/>" size="10" onchange="countCharge('expensesAgentOriKursInvoice<%=i%>','expensesAgentOriWeightInvoice<%=i%>','expensesAgentChargeInvoice<%=i%>')" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentChargeInvoice<%=i%>" id="expensesAgentChargeInvoice<%=i%>" value="<bean:write name="expShipper" property="charge" format="#,###,###.##"/>" size="10" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentDescInvoice<%=i%>" id="expensesAgentDescInvoice<%=i%>" value="<bean:write name="expShipper" property="description"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="text" name="expensesAgentDescriptionInvoice<%=i%>" id="expensesAgentDescriptionInvoice<%=i%>" value="<bean:write name="expShipper" property="descriptionInvoice"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%">
                                                    <select name="expensesAgentKursInvoice<%=i%>" id="expensesAgentKursInvoice<%=i%>"  onchange="countBilling()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                                        <%
                                                        if (exShipper.getKurs().equalsIgnoreCase("IDR")) {
                                                        %>
                                                            <option value="IDR" selected>IDR</option>
                                                            <option value="USD">USD</option>
                                                        <%
                                                        } else {
                                                        %>
                                                            <option value="IDR">IDR</option>
                                                            <option value="USD" selected>USD</option>
                                                        <%
                                                        }
                                                        %>                                                                
                                                    </select>
                                                </td> 
                                                <td width="25%"><input type="text" name="expensesAgentKursValueInvoice<%=i%>" id="expensesAgentKursValueInvoice<%=i%>" value="<bean:write name="expShipper" property="kursValue" format="#,###,###.##"/>" size="10" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
<!--                                                <td width="25%"><input type="checkbox" name="expensesAgentTaxInvoice<%=i%>" id="expensesAgentTaxInvoice<%=i%>" value="<bean:write name="expShipper" property="isTax" />" <%=exShipper.getIsTax().intValue()>0 ? " checked " : ""%>  size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                <td width="25%"><input type="checkbox" name="expensesAgentVatInvoice<%=i%>" id="expensesAgentVatInvoice<%=i%>" value="<bean:write name="expShipper" property="isVat" />" <%=exShipper.getIsVat().intValue()>0 ? " checked " : ""%>  size="10" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>-->
                                                <td><input type="button" value="-" onclick="subtractexpensesagentInvoice2(<%=i%>)">&nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('expensesAgentKursValueInvoice<%=i%>','expensesAgentChargeInvoice<%=i%>','expensesAgentKursInvoice<%=i%>')" > </td>
                                            </tr>                                                                                                
                                        </logic:iterate>  
                                    </logic:notEmpty>
                                </table>    
                            </td>
                     </tr>
                     <tr>
                         <td valign="middle" colspan="5">
                                <input type="button" onclick="addexpensesagentInvoice()" value=" + ">
                                <input type="button" onclick="subtractexpensesagentInvoice()" value=" - "> 
                                <input type="hidden" name="dacountexpensesagentInvoice" id="dacountexpensesagentInvoice" value="<%=i%>">
                        </td>
                     </tr>                   
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     <tr>
                            <td bgColor="#b7b7af" colspan="5"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                     </tr>
                     <tr>
                            <td colspan="5" height="5">
                                <table width="100%">
                                    <tr>
                                        <td></td>                                        
                                        <td width="5"></td>                                        
                                        <td>
                                            USD
                                        </td>
                                        <td>
                                            IDR
                                        </td>
                                    </tr>  
                                    
                                    <tr>
                                        <td>
                                            Sub Total Cost
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalCostUSDAsString" name="totalCostUSDAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                             <input type="text" id="totalCostIDRAsString" name="totalCostIDRAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Sub Total Selling
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalSellingUSDAsString" name="totalSellingUSDAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                             <input type="text" id="totalSellingIDRAsString" name="totalSellingIDRAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>

                                    <input type="hidden" id="totalSellingIDR" name="totalSellingIDR" >
                                    <input type="hidden" id="totalSellingUSD" name="totalSellingUSD" >
                                    <input type="hidden" id="totalCostIDR" name="totalCostIDR" >
                                    <input type="hidden" id="totalCostUSD" name="totalCostUSD" >

                                    <tr>
                                        <td>
                                            DPP
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalDPPUSDAsString" name="totalDPPUSDAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                                <input type="text" id="totalDPPIDRAsString" name="totalDPPIDRAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            VAT
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalVatUSDAsString" name="totalVatUSDAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                                <input type="text" id="totalVatIDRAsString" name="totalVatIDRAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            VAT 1 %
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalVat2USDAsString" name="totalVat2USDAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                                <input type="text" id="totalVat2IDRAsString" name="totalVat2IDRAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Total 
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="subTotalBillingUSDAsString" name="subTotalBillingUSDAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                            <input type="text" id="subTotalBillingIDRAsString" name="subTotalBillingIDRAsString" size="35" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                        </td>
                                    </tr>  
                                    <tr>
                                        <td>
                                            PPH 23
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalPPHUSDAsString" name="totalPPHUSDAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                        <td>
                                                <input type="text" id="totalPPHIDRAsString" name="totalPPHIDRAsString" size="35" style="text-align: right;" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;">                                                        
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Total Billing
                                        </td>                                        
                                        <td width="5"></td>                                        
                                        <td>      
                                            <input type="text" id="totalBillingUSDAsString" name="totalBillingUSDAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetaoDetailForm" property="totalBillingUSD" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetaoDetailForm" property="totalBillingUSD" styleId="totalBillingUSD"/>                                                       
                                        </td>
                                        <td>
                                            <input type="text" id="totalBillingIDRAsString" name="totalBillingIDRAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetaoDetailForm" property="totalBillingIDR" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetaoDetailForm" property="totalBillingIDR" styleId="totalBillingIDR"/>
                                        </td>
                                    </tr>  
                                    <tr>
                                        <td>
                                            Total Expenses
                                        </td>                                        
                                        <td width="5"></td>                                        
                                            <td>      
                                                <input type="text" id="totalExpensesUSDAsString" name="totalExpensesUSDAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetaoDetailForm" property="totalExpensesUSD" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetaoDetailForm" property="totalExpensesUSD" styleId="totalExpensesUSD"/>                                                       
                                        </td>
                                        <td>
                                            <input type="text" id="totalExpensesIDRAsString" name="totalExpensesIDRAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetaoDetailForm" property="totalExpensesIDR" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetaoDetailForm" property="totalExpensesIDR" styleId="totalExpensesIDR"/>
                                        </td>
                                    </tr>  
                                    <tr>
                                            <td colspan="5">&nbsp;</td>
                                    </tr> 
                                    <tr>
                                            <td bgColor="#b7b7af" colspan="5"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                                    </tr> 
                                    <tr>
                                            <td colspan="5">&nbsp;</td>
                                    </tr> 
                                    <tr>
                                        <td>
                                            Jaminan
                                        </td>                                        
                                        <td width="5"></td>                                        
                                            <td>      
                                            <html:text name="jobsheetaoDetailForm" property="jaminan" size="35" maxlength="35" style="text-align: right;"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                                        </td>
                                        <td>

                                        </td>
                                    </tr>   
                                    <tr>
                                        <td>
                                            Remark
                                        </td>                                        
                                        <td width="5"></td>                                        
                                            <td >
                                            <html:text name="jobsheetaoDetailForm" property="remark" size="35" maxlength="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                                        </td>
                                        <td>                                                        
                                        </td>
                                    </tr>   
                                </table>
                            </td>
                     </tr>
                     <tr>
                            <td bgColor="#b7b7af" colspan="5"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                     </tr>                     
                 </table>
             </td>   
         </tr>   
                
         <script>
             countBilling();         
         </script>    