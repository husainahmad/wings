<tr bgcolor="#b7b7af" onmousedown="showTRInbound('tableSellingDebitNote','imgInbound');" style="cursor:hand">
                            <td bgColor="#b7b7af" colspan="5">
                                <img id="imgInbound" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Selling Debit Note</strong>
                            </td>
                     </tr>                     
                     <tr>
                            <td colspan="5">
                                <table border="0" width="100%" cellpadding="2" cellspacing="2" id="tableSellingDebitNote">
                                    <tr bgColor="#b7b7af" id="trHeader" >
                                        <td width="25%" align="center">
                                            Fee
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
                                                        <select name="billingidAgentFeeDebit<%=i%>"  id="billingidAgentFeeDebit<%=i%>"   onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
                                                    <td width="25%"><input type="text" name="billingAgentChargeDebit<%=i%>" id="billingAgentChargeDebit<%=i%>" value="<bean:write name="billAgent" property="charge" format="#,###,###.##"/>" size="20" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="text" name="billingAgentDescDebit<%=i%>" id="billingAgentDescDebit<%=i%>" value="<bean:write name="billAgent" property="description"/>" size="20"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="text" name="billingAgentDescriptionDebit<%=i%>" id="billingAgentDescriptionDebit<%=i%>" value="<bean:write name="billAgent" property="descriptionInvoice"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;" /></td>
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
                                                    <td width="25%"><input type="text" name="billingAgentKursValueDebit<%=i%>" id="billingAgentKursValueDebit<%=i%>" value="<bean:write name="billAgent" property="kursValue" format="#,###,###.##"/>" size="10" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentTaxDebit<%=i%>" id="billingAgentTaxDebit<%=i%>" value="1" <%=billingagent.getIsTax().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentVatDebit<%=i%>" id="billingAgentVatDebit<%=i%>" value="1" <%=billingagent.getIsVat().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td width="25%"><input type="checkbox" name="billingAgentTax2Debit<%=i%>" id="billingAgentTax2Debit<%=i%>" value="1" <%=billingagent.getIsTax2().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                    <td width="25%">
                                                        &nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('billingAgentKursValueDebit<%=i%>','billingAgentChargeDebit<%=i%>','billingAgentKursDebit<%=i%>')" >
                                                    </td>                                                        
                                                </tr>
                                            </span>                                                                                                
                                            </logic:iterate>   
                                            </logic:notEmpty>
                                </table>    
                            </td>
                     </tr>
                      <tr>
                            <input type="hidden" name="dacountbaDebit" id="dacountbaDebit" value="<%=i%>">                                    
                            <td colspan="5" height="5">
                                <input type="button" onclick="addbaDebit()" value=" + ">
                                <input type="button" onclick="subtractbaDebit()" value=" - "> 
                            </td>
                     </tr>
                     
                      <tr bgcolor="#b7b7af" onmousedown="showTRInbound('tableSellingInvoice','imgOutbound');" style="cursor:hand">
                            <td bgColor="#b7b7af" colspan="5">
                                <img id="imgOutbound" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Selling Invoice</strong>
                            </td>
                     </tr>  
                     <tr>
                            <td colspan="5" height="5">
                                <table border="0" width="100%" cellpadding="2" cellspacing="2" id="tableSellingInvoice">
                                    <tr bgColor="#b7b7af" >
                                        <td width="25%" align="center">
                                            Fee
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
                                                            <select name="billingidAgentFeeInvoice<%=i%>" id="billingidAgentFeeInvoice<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
                                                        <td width="25%"><input type="text" name="billingAgentChargeInvoice<%=i%>" id="billingAgentChargeInvoice<%=i%>" value="<bean:write name="billShipper" property="charge" format="#,###,###.##"/>" size="20" onchange="countBilling()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
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
                                                        <td width="25%"><input type="checkbox" name="billingAgentTaxInvoice<%=i%>" id="billingAgentTaxInvoice<%=i%>" value="1" <%=billS.getIsTax().intValue() >0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                        <td width="25%"><input type="checkbox" name="billingAgentVatInvoice<%=i%>" id="billingAgentVatInvoice<%=i%>" value="1" <%=billS.getIsVat().intValue() >0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                        <td width="25%"><input type="checkbox" name="billingAgentTax2Invoice<%=i%>" id="billingAgentTax2Invoice<%=i%>" value="1" <%=billS.getIsTax2().intValue() >0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;" onchange="countBilling()"/></td>
                                                        <td width="25%">
                                                            &nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('billingAgentKursValueInvoice<%=i%>','billingAgentChargeInvoice<%=i%>','billingAgentKursInvoice<%=i%>')" >
                                                        </td>
                                                    </tr>
                                                </span>                                                                                                
                                             </logic:iterate>  
                                            </logic:notEmpty>
                                        </table>    
                                    </tr>
                                    <tr>
                                        <td valign="middle" colspan="5">
                                             <input type="button" onclick="addbaInvoice()" value=" + ">
                                             <input type="button" onclick="subtractbaInvoice()" value=" - "> 
                                             <input type="hidden" name="dacountbaInvoice" id="dacountbaInvoice" value="<%=i%>">
                                        </td>
                                    </tr>                                   
                                </table>    
                            </td>
                     </tr>
                     <tr>
                            <td colspan="5" height="5"></td>
                     </tr>           
                     <tr bgcolor="#b7b7af" onmousedown="showTRInbound('tableCostDebitNote','imgInbound2');" style="cursor:hand">
                         <td colspan="5" valign="middle">&nbsp;&nbsp;<img id="imgInbound2" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Cost Agent Debit Note</strong></td>
                     </tr>                                    
                     <tr>
                         <td colspan="5" height="5">
                            <table border="0" width="100%" cellpadding="2" cellspacing="2" id="tableCostDebitNote">                                    
                                <tr bgColor="#b7b7af" >
                                    <td width="25%" align="center">
                                        Fee
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
                                        PPH
                                    </td>                         
                                    <td width="25%" align="center">
                                        Vat
                                    </td>-->
                                    <td width="25%" align="center">
                                        Action
                                    </td>     
                                </tr>                                        
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
                                                            <select name="expensesidAgentFeeDebit<%=i%>" id="expensesidAgentFeeDebit<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
                                                        <td width="25%"><input type="text" name="expensesAgentChargeDebit<%=i%>" id="expensesAgentChargeDebit<%=i%>" value="<bean:write name="expAgent" property="charge" format="#,###,###.##"/>" size="20" onchange="countExpenses()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="text" name="expensesAgentDescDebit<%=i%>" id="expensesAgentDescDebit<%=i%>" value="<bean:write name="expAgent" property="description"/>" size="20"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="text" name="expensesAgentDescriptionDebit<%=i%>" id="expensesAgentDescriptionDebit<%=i%>" value="<bean:write name="expAgent" property="descriptionInvoice"/>" size="20"  onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%">
                                                            <select name="expensesAgentKursDebit<%=i%>" id="expensesAgentKursDebit<%=i%>" onchange="countExpenses()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
<!--                                                        <td width="25%"><input type="checkbox" name="expensesAgentTaxDebit<%=i%>" id="expensesAgentTaxDebit<%=i%>" value="1" <%=exAgent.getIsTax().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="checkbox" name="expensesAgentVatDebit<%=i%>" id="expensesAgentVatDebit<%=i%>" value="1" <%=exAgent.getIsVat().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>-->
                                                        <td width="25%">
                                                            &nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('expensesAgentKursValueDebit<%=i%>','expensesAgentChargeDebit<%=i%>','expensesAgentKursDebit<%=i%>')" >
                                                        </td>
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
                    </tr>
                    <tr>
                         <td colspan="5" height="5"></td>
                    </tr>           
                    <tr bgcolor="#b7b7af" onmousedown="showTROutbound('tableCostInvoice','imgOutbound2');" style="cursor:hand">
                        <td valign="middle" colspan="5">&nbsp;&nbsp;<img id="imgOutbound2" src="<%=request.getContextPath()%>/Images/arrowDown.gif">&nbsp;&nbsp;<strong>Cost Invoice</strong></td>
                    </tr>                                    
                    <tr>
                        <td colspan="5">
                            <table border="0" width="100%" cellpadding="2" cellspacing="2" id="tableCostInvoice">                                    
                                <tr bgColor="#b7b7af" >
                                    <td width="25%" align="center">
                                        Fee
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
                                        Tax
                                    </td>                         
                                    <td width="25%" align="center">
                                        Vat
                                    </td>-->
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
                                                            <select name="expensesidAgentFeeInvoice<%=i%>" id="expensesidAgentFeeInvoice<%=i%>" onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
                                                        <td width="25%"><input type="text" name="expensesAgentChargeInvoice<%=i%>" id="expensesAgentChargeInvoice<%=i%>" value="<bean:write name="expShipper" property="charge" format="#,###,###.##"/>" size="20" onchange="countExpenses()" onBlur="this.value=formatCurrency(this.value);" style="text-align: right;" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="text" name="expensesAgentDescInvoice<%=i%>" id="expensesAgentDescInvoice<%=i%>" value="<bean:write name="expShipper" property="description"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="text" name="expensesAgentDescriptionInvoice<%=i%>" id="expensesAgentDescriptionInvoice<%=i%>" value="<bean:write name="expShipper" property="descriptionInvoice"/>" size="20" onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%">
                                                            <select name="expensesAgentKursInvoice<%=i%>" id="expensesAgentKursInvoice<%=i%>"  onchange="countExpenses()" onkeydown="if(event.keyCode==13) event.keyCode=9;">
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
<!--                                                        <td width="25%"><input type="checkbox" name="expensesAgentTaxInvoice<%=i%>" id="expensesAgentTaxInvoice<%=i%>" value="1" <%=exShipper.getIsTax().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>
                                                        <td width="25%"><input type="checkbox" name="expensesAgentVatInvoice<%=i%>" id="expensesAgentVatInvoice<%=i%>" value="1" <%=exShipper.getIsTax().intValue()>0 ? " checked " : ""%> onkeydown="if(event.keyCode==13) event.keyCode=9;"/></td>-->
                                                        <td width="25%">
                                                            &nbsp;<input type="button" value="$" onclick="convertToDollarOrRupiah('expensesAgentKursValueInvoice<%=i%>','expensesAgentChargeInvoice<%=i%>','expensesAgentKursInvoice<%=i%>')" >
                                                        </td>
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