
<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
              
<%
SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
%>                
                <html:hidden property="idDebit"/>
                <html:hidden property="debitNumber"/>
                
                <logic:equal name="jobType" value="AI">
                    <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.DebitAIDetail debitAIDetail = (com.wings.persistence.DebitAIDetail)request.getAttribute("DebitAIDetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=debitAIDetail.getDebitNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=debitAIDetail.getDebitDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=debitAIDetail.getShipperName()%></td>                                    
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
                                        <td><%=debitAIDetail.getMawb()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Air Import</td>                                    
                                    </tr>   
                                    <tr>
                                        <td>HAWB</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getHawb()%></td>                                    
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getQtyDesc()%>/<%=debitAIDetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getJobNo()%></td>                                    
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Flight.No</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getFlights()%></td>                                    
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getCommodity()%></td>                                    
                                    </tr>        
                                    <tr>
                                        <td>Origin</td>
                                        <td>:</td>
                                        <td><%=debitAIDetail.getDestination()%></td>                                    
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(debitAIDetail.getDueDate())%></td>                                    
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
                            com.wings.persistence.DebitAODetail debitAODetail = (com.wings.persistence.DebitAODetail)request.getAttribute("DebitAODetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=debitAODetail.getDebitNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=debitAODetail.getDebitDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=debitAODetail.getShipperName()%></td>                                    
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
                                        <td><%=debitAODetail.getMawb()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Air Export</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getQtyDesc()%>/<%=debitAODetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Flight.No</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getFlights()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=debitAODetail.getCommodity()%></td>                                    
                                    </tr>    
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(debitAODetail.getDueDate())%></td>                                
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
                            com.wings.persistence.DebitSIDetail debitSIDetail = (com.wings.persistence.DebitSIDetail)request.getAttribute("DebitSIDetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=debitSIDetail.getDebitNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=debitSIDetail.getDebitDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=debitSIDetail.getShipperName()%></td>                                    
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
                                        <td><%=debitSIDetail.getTermHBL()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Sea Import</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getQtyDesc()%>/<%=debitSIDetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Vessel</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getFeederVessel()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=debitSIDetail.getCommodity()%></td>                                    
                                    </tr>   
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(debitSIDetail.getDueDate())%></td>                                
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
                            com.wings.persistence.DebitSODetail debitSODetail = (com.wings.persistence.DebitSODetail)request.getAttribute("DebitSODetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
                                <tr>
                                    <td>No</td>
                                    <td>:</td>
                                    <td><strong><%=debitSODetail.getDebitNumber()%></strong></td>                                    
                                </tr>   
                                <tr>
                                    <td>Date</td>
                                    <td>:</td>
                                    <td><%=debitSODetail.getDebitDate()%></td>                                    
                                </tr> 
                                <tr>
                                    <td>Shipper</td>
                                    <td>:</td>
                                    <td><%=debitSODetail.getShipperName()%></td>                                    
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
                                        <td><%=debitSODetail.getTermHBL()%></td>                                    
                                        <td>Job Description</td>
                                        <td>:</td>
                                        <td>Sea Export</td>                                    
                                    </tr>   
                                    <tr>
                                         <td>Job.No</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getJobNo()%></td>                                        
                                         <td>Qty/Weight</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getQtyDesc()%>/<%=debitSODetail.getWeightDesc()%></td>  
                                    </tr>                                     
                                    <tr>
                                        <td>Vessel</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getFeederVessel()%></td>                                 
                                        <td>Volume</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getVolumeDesc()%></td>                                    
                                    </tr>                                 
                                    <tr>
                                        <td>Destination</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getDestination()%></td>                                 
                                        <td>Commodity</td>
                                        <td>:</td>
                                        <td><%=debitSODetail.getCommodity()%></td>                                    
                                    </tr>     
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>                                 
                                        <td>DueDate</td>
                                        <td>:</td>
                                        <td><%=FORMAT.format(debitSODetail.getDueDate())%></td>                                
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
                                    <logic:iterate id="billingagents" name="Billingagents" type="com.wings.persistence.Billingagent">  
                                        <%
                                        com.wings.persistence.BillingagentDetail bs = (com.wings.persistence.BillingagentDetail)billingagents;                                       
                                        %>
                                        <tr>
                                            <td>&nbsp;<bean:write name="billingagents" property="descriptionFee"/></td>
                                            <td>&nbsp;<bean:write name="billingagents" property="description"/></td>
                                            <logic:equal name="billingagents" property="kurs" value="USD">
                                                <%
                                                 totalUSD+=bs.getCharge();
                                                %> 
                                                <td align="right">&nbsp;<bean:write name="billingagents" property="charge"/></td>
                                                <td align="right">0.0</td>
                                            </logic:equal>  
                                            <logic:equal name="billingagents" property="kurs" value="IDR">
                                                <%
                                                 totalIDR+=bs.getCharge();
                                                %>                                                
                                                <td align="right">0.0</td>
                                                <td align="right">&nbsp;<bean:write name="billingagents" property="charge"/></td>
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
		<tr>
                        <td colspan="2" height="10"></td>
                </tr>             
                <script>
                    //"<img src=\"<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif\" id=\"f_trigger_c\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" onmouseover=\"this.style.background='red';\" onmouseout=\"this.style.background=''\" />"+                               
                    function addDebitKredit() {                
                        document.getElementById("countDebitKredit").value++;                
                        var countDebitKredit = document.getElementById("countDebitKredit").value;
                        var nextDebitKredit = countDebitKredit*1-1;
                        var daid1 = document.getElementById("daid1");
                        var row = "<span id=\"dasbaKredit"+countDebitKredit+"\">"+
                                    "<table border=\"0\" cellpadding=\"2\" cellspacing=\"2\" width=\"100%\">" +
                                        "<tr>"+                        
                                            "<td width=15%>"+countDebitKredit+"</td>"+ 
                                            "<td width=35%><input type=\"text\" name=\"debitKreditDate"+countDebitKredit+"\"  id=\"debitKreditDate"+countDebitKredit+"\" size=\"10\"/>"+ 
                                            "(dd/mm/yyyy)" +
                                            "</td> "+
                                            "<td width=25%><input type=\"text\" name=\"debitKreditValue"+countDebitKredit+"\" size=\"20\" onpropertychange=\"countTotal()\" value=\"0.0\"/></td>"+
                                            "<td width=25%>"+
                                                "<select name=\"debitKreditKurs"+countDebitKredit+"\" onchange=\"countTotal()\">"+
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
                    
                    function subtractDebitKredit() {
                        var countDebitKredit = document.getElementById("countDebitKredit").value;                    
                        tempDep=document.getElementById("dasbaKredit"+countDebitKredit);
                        if (tempDep && (countDebitKredit>0)) {
                            tempDep.innerHTML="";
                            tempDep.outerHTML="";                    
                            document.getElementById("countDebitKredit").value--;
                        }
                    }	
                    
                    function countTotal() {
                
                        var countDebitKredit = document.getElementById("countDebitKredit").value;

                        var i = 1;
                        var billacchd = "debitKreditValue";
                        var kurs = "debitKreditKurs";
                        var pas1 = "";
                        var pas2 = "";
                        var totalIDR = 0;
                        var totalUSD = 0;

                        for (i=1; i<=countDebitKredit; i++) {
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
                        inputField     :    "debitKreditDate1",     // id of the input field
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
                    <td bgColor="#b7b7af" colspan="2"><strong>Debit Kredit</strong></td>
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
                                                    <logic:notEmpty name="debitKreditList" scope="request">                                                                                            
                                                        <logic:iterate id="debitKredit" name="debitKreditList" type="com.wings.persistence.Debitkredit">       
                                                            <%
                                                            com.wings.persistence.Debitkredit ik = (com.wings.persistence.Debitkredit)debitKredit;
                                                            i++;                                                        
                                                            %>
                                                            <span id="dasbaKredit<%=i%>">
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
                                                                        <td width=35%><input type=text name="debitKreditDate<%=i%>"  id="debitKreditDate<%=i%>" value="<%=strDateKredit%>" size="10"/> 
                                                                        (dd/mm/yyyy) 
                                                                        </td> 
                                                                        <td width=25%><input type=text name="debitKreditValue<%=i%>" size="20" onpropertychange="countTotal()" value="<%=ik.getValue()%>"/></td>
                                                                        <td width=25%>
                                                                            <select name="debitKreditKurs<%=i%>" onchange="countTotal()">
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
                                                    <logic:notEmpty name="debitKreditList" scope="request">                                                                                            
                                                        <logic:iterate id="debitKredit" name="debitKreditList" type="com.wings.persistence.Debitkredit">       
                                                            <%
                                                            com.wings.persistence.Debitkredit ik = (com.wings.persistence.Debitkredit)debitKredit;
                                                            i++;                                                        
                                                            %>
                                                            <span id="dasbaKredit<%=i%>">
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
                                                                        <td width=35%><%=strDateKredit%></td> 
                                                                        <td width=25%><%=ik.getValue()%></td>
                                                                        <td width=25%>                                                                            
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
                                        <input type="hidden" name="countDebitKredit" value="<%=i%>">                                                                                 
                                </tr>
                                <tr>
                                    <logic:equal name="action" value="insert">
                                        <td valign="middle">
                                             <input type="button" onclick="addDebitKredit()" value=" + ">
                                             <input type="button" onclick="subtractDebitKedit()" value=" - "> 
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
