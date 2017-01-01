

<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
              
<%
SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
%>
                <html:hidden property="idInvoice"/>
                <html:hidden property="invoiceNumber"/>
                
                <logic:equal name="jobType" value="AI">
                    <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.InvoiceAIDetail invoiceAIDetail = (com.wings.persistence.InvoiceAIDetail)request.getAttribute("InvoiceAIDetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=invoiceAIDetail.getInvoiceNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=invoiceAIDetail.getInvoiceDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=invoiceAIDetail.getShipperName()%></td>                                    
                                </tr>                                 
                            </table>
                        </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                     <tr>
                            <td colspan="2">
                                <table cellpadding="2" cellspacing="2" width="100%"> 
                                    <tr>
                                        <td>MAWB</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getMawb()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Air Import</td>                                    
                                    </tr>   
                                    <tr>
                                        <td>HAWB</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getHawb()%></td>                                    
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getQtyDesc()%>/<%=invoiceAIDetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getJobNo()%></td>                                    
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Flight.No</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getFlights()%></td>                                    
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getCommodity()%></td>                                    
                                    </tr>        
                                    <tr>
                                        <td>Origin</td>
                                        <td>:</td>
                                        <td><%=invoiceAIDetail.getDestination()%></td>                                    
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(invoiceAIDetail.getDueDate())%></td>                                    
                                    </tr> 
                                    
                                </table>
                            </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                </logic:equal>
                <logic:equal name="jobType" value="AO">
                        <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.InvoiceAODetail invoiceAODetail = (com.wings.persistence.InvoiceAODetail)request.getAttribute("InvoiceAODetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=invoiceAODetail.getInvoiceNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=invoiceAODetail.getInvoiceDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=invoiceAODetail.getShipperName()%></td>                                    
                                </tr>                                 
                            </table>
                        </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                     <tr>
                            <td colspan="2">
                                <table cellpadding="2" cellspacing="2" width="100%"> 
                                    <tr>
                                        <td>MAWB</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getMawb()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Air Export</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getQtyDesc()%>/<%=invoiceAODetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Flight.No</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getFlights()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=invoiceAODetail.getCommodity()%></td>                                    
                                    </tr>   
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(invoiceAODetail.getDueDate())%></td>                           
                                    </tr>  
                                </table>
                            </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                </logic:equal>
                <logic:equal name="jobType" value="SI">
                     <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.InvoiceSIDetail invoiceSIDetail = (com.wings.persistence.InvoiceSIDetail)request.getAttribute("InvoiceSIDetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=invoiceSIDetail.getInvoiceNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=invoiceSIDetail.getInvoiceDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=invoiceSIDetail.getShipperName()%></td>                                    
                                </tr>                                 
                            </table>
                        </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                     <tr>
                            <td colspan="2">
                                <table cellpadding="2" cellspacing="2" width="100%"> 
                                    <tr>
                                        <td>HB/L.No</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getTermHBL()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Sea Import</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getQtyDesc()%>/<%=invoiceSIDetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Vessel</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getFeederVessel()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=invoiceSIDetail.getCommodity()%></td>                                    
                                    </tr>    
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(invoiceSIDetail.getDueDate())%></td>                           
                                    </tr> 
                                </table>
                            </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>   
                </logic:equal>
                <logic:equal name="jobType" value="SO">    
                     <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.InvoiceSODetail invoiceSODetail = (com.wings.persistence.InvoiceSODetail)request.getAttribute("InvoiceSODetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=invoiceSODetail.getInvoiceNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=invoiceSODetail.getInvoiceDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=invoiceSODetail.getShipperName()%></td>                                    
                                </tr>                                 
                            </table>
                        </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                     <tr>
                            <td colspan="2">
                                <table cellpadding="2" cellspacing="2" width="100%"> 
                                    <tr>
                                        <td>HB/L.No</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getTermHBL()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Sea Export</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getQtyDesc()%>/<%=invoiceSODetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Vessel</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getFeederVessel()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=invoiceSODetail.getCommodity()%></td>                                    
                                    </tr>   
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(invoiceSODetail.getDueDate())%></td>                           
                                    </tr> 
                                </table>
                            </td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr>
                    <tr>
                            <td bgColor="#b7b7af" colspan="2"><IMG height="1" src="<%=request.getContextPath()%>/Images/pxl_spacer.gif" width="1"></td>
                    </tr>
                    <tr>
                            <td colspan="2" height="10"></td>
                    </tr> 
                </logic:equal>
                
                <tr>
			<td colspan="2">
                            <table width="100%" border="1" cellpadding="0" cellspacing="0">
                                <tr bgcolor="#b7b7af">
                                    <td align="center"><strong>Charged</strong></td>
                                    <td align="center"><strong>Descrition</strong></td>
                                    <td align="center"><strong>Amount(USD)</strong></td>
                                    <td align="center"><strong>Amount(IDR)</strong></td>
                                </tr>
                                    <%
                                    Double totalIDR = 0.0;
                                    Double totalUSD = 0.0;
                                    %>
                                    <logic:iterate id="billingshippers" name="Billingshippers" type="com.wings.persistence.Billingshipper">  
                                        <%
                                        com.wings.persistence.BillingshipperDetail bs = (com.wings.persistence.BillingshipperDetail)billingshippers;                                        
                                        %>
                                        <tr>
                                            <td>&nbsp;<bean:write name="billingshippers" property="descriptionFee"/></td>
                                            <td>&nbsp;<bean:write name="billingshippers" property="description"/></td>
                                            <logic:equal name="billingshippers" property="kurs" value="USD">
                                                <%
                                                 totalUSD+=bs.getCharge();
                                                %> 
                                                <td align="right">&nbsp;<bean:write name="billingshippers" property="charge"/></td>
                                                <td align="right">0.0</td>
                                            </logic:equal>    
                                            <logic:equal name="billingshippers" property="kurs" value="IDR">
                                                <%
                                                 totalIDR+=bs.getCharge();
                                                %>  
                                                <td align="right">0.0</td>
                                                <td align="right">&nbsp;<bean:write name="billingshippers" property="charge"/></td>
                                            </logic:equal>                                                                                    
                                        </tr>    
                                    </logic:iterate>    
                                    <tr bgcolor="#b7b7af">
                                        <td colspan="2" align="center"><strong>Total</strong></td>
                                        <logic:equal name="action" value="insert">
                                            <td align="right"><input type="text" name="totalUSD" id="totalUSD" readonly="readonly" value="<%=totalUSD%>" style="text-align:right;"></td>
                                            <td align="right"><input type="text" name="totalIDR" id="totalIDR" readonly="readonly" value="<%=totalIDR%>" style="text-align:right;"></td>
                                        </logic:equal>
                                        <logic:equal name="action" value="select">
                                            <td align="right"><%=totalUSD%></td>
                                            <td align="right"><%=totalIDR%></td>
                                        </logic:equal>
                                    </tr>
                            </table>
                        </td>
		</tr>
                <script>
                    //"<img src=\"<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif\" id=\"f_trigger_c\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" onmouseover=\"this.style.background='red';\" onmouseout=\"this.style.background=''\" />"+                               
                    function addInvoiceKredit() {                
                        document.getElementById("countInvoiceKredit").value++;                
                        var countInvoiceKredit = document.getElementById("countInvoiceKredit").value;
                        var nextInvoiceKredit = countInvoiceKredit*1-1;
                        var daid1 = document.getElementById("daid1");
                        var row = "<span id=\"dasbaInvoice"+countInvoiceKredit+"\">"+
                                    "<table border=\"0\" cellpadding=\"2\" cellspacing=\"2\" width=\"100%\">" +
                                        "<tr>"+                        
                                            "<td width=15%>"+countInvoiceKredit+"</td>"+ 
                                            "<td width=35%><input type=\"text\" name=\"invoiceKreditDate"+countInvoiceKredit+"\"  id=\"invoiceKreditDate"+countInvoiceKredit+"\" size=\"10\"/>"+ 
                                            "(dd/mm/yyyy)" +
                                            "</td> "+
                                            "<td width=25%><input type=\"text\" name=\"invoiceKreditValue"+countInvoiceKredit+"\" size=\"20\" onpropertychange=\"countTotal()\" value=\"0.0\"/></td>"+
                                            "<td width=25%>"+
                                                "<select name=\"invoiceKreditKurs"+countInvoiceKredit+"\" onchange=\"countTotal()\">"+
                                                    "<option value=\"IDR\">IDR</option>"+
                                                    "<option value=\"USD\">USD</option>"+
                                                "</select>"+
                                            "</td> "+
                                        "</tr>"+                                                  
                                    "</table>"+   
                                "</span>";                        

                        daid1.innerHTML=daid1.innerHTML+row;
                        //alert(daid1.innerHTML);
                    }
                    
                    function subtractInvoiceKedit() {
                        var countInvoiceKredit = document.getElementById("countInvoiceKredit").value;                    
                        tempDep=document.getElementById("dasbaInvoice"+countInvoiceKredit);
                        if (tempDep && (countInvoiceKredit>0)) {
                            tempDep.innerHTML="";
                            tempDep.outerHTML="";                    
                            document.getElementById("countInvoiceKredit").value--;
                        }
                    }	
                    
                    function countTotal() {
                
                        var countInvoiceKredit = document.getElementById("countInvoiceKredit").value;

                        var i = 1;
                        var billacchd = "invoiceKreditValue";
                        var kurs = "invoiceKreditKurs";
                        var pas1 = "";
                        var pas2 = "";
                        var totalIDR = 0;
                        var totalUSD = 0;

                        for (i=1; i<=countInvoiceKredit; i++) {
                            pas2 = kurs + i;
                            pas2 = document.getElementById(pas2).value;

                            pas1 = billacchd + i;
                            pas1 = document.getElementById(pas1).value;     

                            if (pas2=="IDR") {
                                totalIDR+=parseFloat(pas1);                             
                            } else {
                                totalUSD+=parseFloat(pas1);                                             
                            }                                                           
                        }
                        
                        document.getElementById("totalKreditIDR").value = totalIDR;
                        document.getElementById("totalKreditUSD").value = totalUSD;
                        
                    }
                    
                    Calendar.setup({
                        inputField     :    "invoiceKreditDate1",     // id of the input field
                        ifFormat       :    "%d/%m/%Y",      // format of the input field
                        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                        //align          :    "Tl",           // alignment (defaults to "Bl")
                        singleClick    :    true
                    });
                                
                </script>  
                <tr>
                        <td colspan="2" height="10"></td>
                </tr>
                <tr>
                    <td bgColor="#b7b7af" colspan="2"><strong>Invoice Kredit</strong></td>
                </tr>
                <tr>
                        <td colspan="2">
                            <table width="100%" border="1" cellpadding="2" cellspacing="2">
                                
                                <tr>
                                    <td id="daid1" colspan="3">       
                                                <table border="0" cellpadding="2" cellspacing="2" width="100%" >
                                                    <tr>
                                                        <td width="15%" align="center" bgColor="#b7b7af"><strong>No</strong></td>
                                                        <td width="35%" align="center" bgColor="#b7b7af"><strong>Date</strong></td>
                                                        <td width="25%" align="center" bgColor="#b7b7af"><strong>Kredit</strong></td>
                                                        <td width="25%" align="center" bgColor="#b7b7af"><strong>Kurs</strong></td> 
                                                    </tr>
                                                </table>
                                                <% int i = 0; 
                                                   String strDateKredit = "";
                                                   double totalKreditIDR = 0.0;
                                                   double totalKreditUSD = 0.0;
                                                %>
                                                <logic:equal name="action" value="insert">
                                                   <logic:notEmpty name="invoiceKreditList" scope="request">                                                                                            
                                                        <logic:iterate id="invoiceKredit" name="invoiceKreditList" type="com.wings.persistence.Invoicekredit">       
                                                            <%
                                                            com.wings.persistence.Invoicekredit ik = (com.wings.persistence.Invoicekredit)invoiceKredit;
                                                            i++;                                                        
                                                            %>
                                                            <span id="dasbaInvoice<%=i%>">
                                                                <table border=0 cellpadding=2 cellspacing=2 width=100%> 
                                                                    <tr>                        
                                                                        <td width=15%><%=i%></td> 
                                                                        <%
                                                                        try {
                                                                            strDateKredit = FORMAT.format(ik.getKreditDate());
                                                                        } catch (Exception e) {
                                                                            strDateKredit = FORMAT.format(new java.util.Date());
                                                                        }
                                                                        %>
                                                                        <td width=35%><input type=text name="invoiceKreditDate<%=i%>"  id="invoiceKreditDate<%=i%>" value="<%=strDateKredit%>" size="10"/> 
                                                                        (dd/mm/yyyy) 
                                                                        </td> 
                                                                        <td width=25%><input type=text name="invoiceKreditValue<%=i%>" size="20" onpropertychange="countTotal()" value="<%=ik.getValue()%>"/></td>
                                                                        <td width=25%>
                                                                            <select name="invoiceKreditKurs<%=i%>" onchange="countTotal()">
                                                                                <%
                                                                                if (ik.getKurs().equalsIgnoreCase("IDR")) {
                                                                                    totalKreditIDR+=ik.getValue().doubleValue();
                                                                                %>
                                                                                    <option value=IDR selected>IDR</option>
                                                                                    <option value=USD>USD</option>
                                                                                <%
                                                                                } else {
                                                                                    totalKreditUSD+=ik.getValue().doubleValue();
                                                                                %>
                                                                                    <option value=IDR>IDR</option>
                                                                                    <option value=USD selected>USD</option>
                                                                                <%
                                                                                }
                                                                                %>
                                                                            </select>
                                                                        </td> 
                                                                    </tr>                                                  
                                                                </table>   
                                                            </span>
                                                        </logic:iterate>
                                                    </logic:notEmpty> 
                                                </logic:equal>
                                                <logic:equal name="action" value="select">
                                                    <logic:notEmpty name="invoiceKreditList" scope="request">                                                                                            
                                                        <logic:iterate id="invoiceKredit" name="invoiceKreditList" type="com.wings.persistence.Invoicekredit">       
                                                            <%
                                                            com.wings.persistence.Invoicekredit ik = (com.wings.persistence.Invoicekredit)invoiceKredit;
                                                            i++;                                                        
                                                            %>
                                                            <span id="dasbaInvoice<%=i%>">
                                                                <table border=0 cellpadding=2 cellspacing=2 width=100%> 
                                                                    <tr>                        
                                                                        <td width=15%><%=i%></td> 
                                                                        <%
                                                                        try {
                                                                            strDateKredit = FORMAT.format(ik.getKreditDate());
                                                                        } catch (Exception e) {
                                                                            strDateKredit = FORMAT.format(new java.util.Date());
                                                                        }
                                                                        %>
                                                                        <td width=35% align="center"><%=strDateKredit%></td> 
                                                                        <td width=25% align="right"><%=ik.getValue()%></td>
                                                                        <td width=25% align="center">                                                                            
                                                                                <%
                                                                                if (ik.getKurs().equalsIgnoreCase("IDR")) {
                                                                                    totalKreditIDR+=ik.getValue().doubleValue();                                                                                
                                                                                } else {
                                                                                    totalKreditUSD+=ik.getValue().doubleValue();                                                                                
                                                                                }
                                                                                %>
                                                                            <%=ik.getKurs()%>
                                                                        </td> 
                                                                    </tr>                                                  
                                                                </table>   
                                                            </span>
                                                        </logic:iterate>
                                                    </logic:notEmpty> 
                                                </logic:equal>
                                        </td>
                                        <input type="hidden" name="countInvoiceKredit" value="<%=i%>">                                                                                 
                                </tr>
                                <tr>
                                    <logic:equal name="action" value="insert">
                                        <td valign="middle">
                                             <input type="button" onclick="addInvoiceKredit()" value=" + ">
                                             <input type="button" onclick="subtractInvoiceKedit()" value=" - "> 
                                        </td>                                    
                                        <td valign="middle">
                                            Total(USD) : <input type="text" name="totalKreditUSD" value="<%=totalKreditUSD%>" size="20" readonly="readonly"/>
                                        </td>
                                        <td valign="middle">
                                            Total(IDR) : <input type="text" name="totalKreditIDR" value="<%=totalKreditIDR%>" size="20" readonly="readonly"/>
                                        </td>
                                    </logic:equal>
                                    <logic:equal name="action" value="select">
                                                                          
                                        <td align="center" colspan="2" width="50%">
                                            Total(USD) : <%=totalKreditUSD%>
                                        </td>
                                        <td align="center" width="50%">
                                            Total(IDR) : <%=totalKreditIDR%>
                                        </td>
                                    </logic:equal>                                    
                                </tr>
                            </table>
                        </td>
                </tr> 
		<tr>
                        <td colspan="2" height="10"></td>
                </tr>             
