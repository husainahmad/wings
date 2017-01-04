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
         <script type="text/javascript" src="<%=request.getContextPath()%>/js/jobsheet_counting.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/js/jobsheet_add_remove_row.js"></script>
         <tr>
             <td>                          
                 <table width="100%">
                     <tr><html:hidden name="jobsheetsiDetailForm" property="idJobSheet"/>
                     <html:hidden name="jobsheetsiDetailForm" property="idJobSheetSi"/>
                        <td>Job.No:</td>
			<td>                            
                            <logic:equal name="action" value="insert">
                                 [Job.No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="copy">
                                 [Job.No will be generate by system]
                            </logic:equal>
                            <logic:equal name="action" value="updateAsNew">
                                 <html:text name="jobsheetsiDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="update">
                                 <html:text name="jobsheetsiDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetsiDetailForm" property="jobNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>          
                            </logic:equal>    
                        </td>
                        <td width="5"></td>
                        <td>Date:</td>
                            <td>
                                <html:text name="jobsheetsiDetailForm" property="shippeddateAsString" style="shippeddateAsString" styleId="shippeddateAsString" size="10" onkeydown="if(event.keyCode==13) event.keyCode=9;" tabindex="8"/>                                
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
                                 <html:text name="jobsheetsiDetailForm" property="invoiceNoUsd" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetsiDetailForm" property="invoiceNoUsd" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>          
                            </logic:equal>
                        </td>
                        <td width="5"></td>                                        
                        <td>ETA/Custom</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="etaoriginAsString" styleId="etaoriginAsString" size="10" tabindex="9" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                             <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_e" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                <script type="text/javascript">
                                    Calendar.setup({
                                        inputField     :    "etaoriginAsString",     // id of the input field
                                        ifFormat       :    "%d/%m/%Y",      // format of the input field
                                        button         :    "f_trigger_e",  // trigger for the calendar (button ID)
                                        //align          :    "Tl",           // alignment (defaults to "Bl")
                                        singleClick    :    true
                                    });
                                </script>
                                <html:text name="jobsheetsiDetailForm" property="customDateAsString" styleId="customDateAsString" size="10" tabindex="10" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                                 <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_f" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                    onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                    <script type="text/javascript">
                                        Calendar.setup({
                                            inputField     :    "customDateAsString",     // id of the input field
                                            ifFormat       :    "%d/%m/%Y",      // format of the input field
                                            button         :    "f_trigger_f",  // trigger for the calendar (button ID)
                                            //align          :    "Tl",           // alignment (defaults to "Bl")
                                            singleClick    :    true
                                        });
                                    </script>
                        </td>
                     </tr> 
                     <tr>
                        <td>DN.No:</td>
			<td>                            
                            <logic:equal name="action" value="insert">
                                 [Debit.No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="copy">
                                 [Debit.No will be generate by system]
                            </logic:equal>
                            <logic:equal name="action" value="updateAsNew">
                                 [Debit.No will be generate by system]          
                            </logic:equal>
                            <logic:equal name="action" value="update">
                                 <html:text name="jobsheetsiDetailForm" property="debitNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>             
                            </logic:equal>
                            <logic:equal name="action" value="select">
                                 <html:text name="jobsheetsiDetailForm" property="debitNo" size="35" readonly="true" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>          
                            </logic:equal>
                        </td>                        
                        <td width="5"></td>                
                        <td>ETD Origin:</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="etdoriginAsString" styleId="etdoriginAsString" size="10" tabindex="11"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                                
                                <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_d" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                <script type="text/javascript">
                                    Calendar.setup({
                                        inputField     :    "etdoriginAsString",     // id of the input field
                                        ifFormat       :    "%d/%m/%Y",      // format of the input field
                                        button         :    "f_trigger_d",  // trigger for the calendar (button ID)
                                        //align          :    "Tl",           // alignment (defaults to "Bl")
                                        singleClick    :    true
                                    });
                                </script>
                        </td>
                     </tr>                      
                      <tr>
                        <td>Consignee:</td>
			<td>
                            <html:hidden name="jobsheetsiDetailForm" property="idConsignee" styleId="idConsignee"/>
                            <html:text name="jobsheetsiDetailForm" property="consigneeName" styleId="consigneeName" size="35" tabindex="1" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
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
                        <td>Feedder Vessel:</td>
			<td>
                             <html:text name="jobsheetsiDetailForm" property="feederVessel" size="35" tabindex="12" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                           
                        </td>                        
                     </tr> 
                      <tr>
                        <td>Shipper:</td>
			<td>
                            <html:hidden name="jobsheetsiDetailForm" property="idShipper" styleId="idShipper"/>
                            <html:text name="jobsheetsiDetailForm" property="shipperName" styleId="shipperName" size="35" tabindex="2" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            
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
                        <td>Shipping Line:</td>
			<td>
                            <html:hidden name="jobsheetsiDetailForm" property="shippingLine" styleId="shippingLine"/>
                            <html:text name="jobsheetsiDetailForm" property="shippingLineName" styleId="shippingLineName" size="35" tabindex="13" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            <ajax:autocomplete
                              source="shippingLineName"
                              target="shippingLine"
                              baseUrl="${contextPath}/ShippingLineServletAutocomplete"
                              className="autocomplete"
                              indicator="indicator"
                              minimumCharacters="1"
                            />
                        </td>
                        
                     </tr> 
                      <tr>
                        <td>Agent:</td>
			<td>
                            <html:hidden name="jobsheetsiDetailForm" property="idAgent" styleId="idAgent"/>
                            <html:text name="jobsheetsiDetailForm" property="agentName" styleId="agentName" size="35" tabindex="3" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                           
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
                         <td>POD/WHS</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="pod" size="35" tabindex="14" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>
                     </tr> 
                      <tr>
                        <td>Forwarder:</td>
			<td>                            
                            <html:text name="jobsheetsiDetailForm" property="forwarderName" styleId="forwarderName" size="35" tabindex="3" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            <html:hidden name="jobsheetsiDetailForm" property="idForwarder" styleId="idForwarder"/>
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
                        <td>Mvessel:</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="mvessel" size="35" tabindex="4" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                            
                        </td> 
                        <td width="5"></td>  
                        <td>Qty/Weight:</td>
			<td><html:text name="jobsheetsiDetailForm" property="qtyDesc" size="13" tabindex="15" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>/<html:text name="jobsheetsiDetailForm" property="weightDesc" size="13" tabindex="16" onkeydown="if(event.keyCode==13) event.keyCode=9;" /></td>
                     </tr> 
                     <tr>
                        <td>M B/L:</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="termMbl" size="35" tabindex="5" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>                        
                        <td width="5"></td>  
                        <td>Volume:</td>
			<td><html:text name="jobsheetsiDetailForm" property="volumeDesc" size="35" tabindex="17" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                                             
                     </tr> 
                     <tr>
                        <td>H B/L:</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="termHbl" size="35" tabindex="6" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>
                        <td width="5"></td>               
                        <td>Commodity</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="commodity" size="35" tabindex="18" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                        </td>     
                     </tr> 
                     
                     <tr>                                                
                        <td>Origin:</td>
			<td><html:text name="jobsheetsiDetailForm" property="origin" size="13" tabindex="7" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>                         
                        <td width="5"></td>                         
                        <td>Transport  To:</td>
			<td>
                            <html:hidden name="jobsheetsiDetailForm" property="idTransporter" styleId="idTransporter"/>
                            <html:text name="jobsheetsiDetailForm" property="transportName" styleId="transportName" size="35" tabindex="19" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                           
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
                        <td></td>
			<td></td>                         
                        <td width="5"></td>                         
                        <td>CMB</td>
			<td>                            
                            <html:text name="jobsheetsiDetailForm" property="cmb" size="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>                                                       
                        </td>   
                     </tr>
                     <tr>
                        <td>Bill To (Debit)</td>
			<td>
                                <html:select name="jobsheetsiDetailForm" property="billToDebit" tabindex="20" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                    <html:option value="1">Agent</html:option>
                                    <html:option value="2">Consignee</html:option>
                                    <html:option value="3">Shipper</html:option>
                                    <html:option value="4">Shipping Line</html:option>
                                </html:select>
                        </td>
                        <td width="5"></td>               
                        <td>Bill To (Invoice)</td>
			<td>
                                <html:select name="jobsheetsiDetailForm" property="billTo" tabindex="21" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                    <html:option value="1">Agent</html:option>
                                    <html:option value="2">Consignee</html:option>
                                    <html:option value="3">Shipper</html:option>
                                    <html:option value="4">Shipping Line</html:option>
                                </html:select>
                        </td>   
                     </tr>
                     <tr>
                        <td>C/N No.</td>
			<td><html:text name="jobsheetsiDetailForm" property="cnNo" size="35" tabindex="22" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>  
                        <td></td>
			<td>
                            
                        </td>
                        <%--
                        <td>Amount:</td>
			<td>
                            <html:text name="jobsheetsiDetailForm" property="depart" size="20" tabindex="23" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
                            Kurs 
                            <html:select name="jobsheetsiDetailForm" property="cnKurs" tabindex="24" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                <html:option value="IDR">IDR</html:option>
                                <html:option value="USD">USD</html:option>                                
                            </html:select>
                        </td>
                        --%>
                     </tr>
                     <tr>
                        <td>Komisi Agent IDR</td>
                        <td><html:text name="jobsheetsiDetailForm" styleId="refundIDR" property="refundIDR" size="35" maxlength="35" tabindex="25" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>   
                        <td>Komisi Agent USD</td>
                        <td><html:text name="jobsheetsiDetailForm" styleId="refundUSD" property="refundUSD" size="35" maxlength="35" tabindex="25" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr>
                     <tr>
                        <td>Credit Note IDR</td>
			<td><html:text name="jobsheetsiDetailForm" styleId="creditNoteIDR" property="creditNoteIDR" size="35" maxlength="35" tabindex="26" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                        <td width="5"></td>   
                        <td>Credit Note USD</td>
			<td><html:text name="jobsheetsiDetailForm" styleId="creditNoteUSD" property="creditNoteUSD" size="35" maxlength="35" tabindex="26" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                     </tr>    
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>
                     
                     <%@include file="formJobsheet_row_detail.jsp" %> 
                     
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
                                            <input type="text" id="totalBillingUSDAsString" name="totalBillingUSDAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetsiDetailForm" property="totalBillingUSD" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetsiDetailForm" property="totalBillingUSD" styleId="totalBillingUSD"/>                                                       
                                        </td>
                                        <td>
                                            <input type="text" id="totalBillingIDRAsString" name="totalBillingIDRAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetsiDetailForm" property="totalBillingIDR" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetsiDetailForm" property="totalBillingIDR" styleId="totalBillingIDR"/>
                                        </td>
                                    </tr>  
                                    <tr>
                                        <td>
                                            Total Expenses
                                        </td>                                        
                                        <td width="5"></td>                                        
                                            <td>      
                                                <input type="text" id="totalExpensesUSDAsString" name="totalExpensesUSDAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetsiDetailForm" property="totalExpensesUSD" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetsiDetailForm" property="totalExpensesUSD" styleId="totalExpensesUSD"/>                                                       
                                        </td>
                                        <td>
                                            <input type="text" id="totalExpensesIDRAsString" name="totalExpensesIDRAsString" size="35" style="text-align: right;" value="<bean:write name="jobsheetsiDetailForm" property="totalExpensesIDR" format="#,###,###.##"/>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
                                            <html:hidden name="jobsheetsiDetailForm" property="totalExpensesIDR" styleId="totalExpensesIDR"/>
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
                                            <html:text name="jobsheetsiDetailForm" property="jaminan" size="35" maxlength="35" style="text-align: right;"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
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
                                            <html:text name="jobsheetsiDetailForm" property="remark" size="35" maxlength="35" onkeydown="if(event.keyCode==13) event.keyCode=9;"/>
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
             document.addEventListener("DOMContentLoaded", function(event) { 
                 countBilling();
                 countExpenses();
             });
         </script>     