<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
              
<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>
    

<!-- import the language module -->
<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>

<!-- other languages might be available in the lang directory; please check
your distribution archive. -->

<!-- helper script that uses the calendar -->
<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>

<%
SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
%>                               
                
                <logic:equal name="jobType" value="AI">
                    <tr>			
			<td colspan="2">
                            <%
                            com.wings.persistence.InvoiceAIDetail invoiceAIDetail = (com.wings.persistence.InvoiceAIDetail)request.getAttribute("InvoiceAIDetail");
                            %>                                                        
                            <table cellpadding="2" cellspacing="2" width="100%"> 
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
                                <tr>
                                    <td>Consignee</td>
                                    <td>:</td>
                                    <td><%=invoiceAIDetail.getConsigneeName()%></td>                                    
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
                                        <td></td>                                    
                                        <td></td>
                                        <td></td>
                                        <td></td>                                    
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

                <html:hidden property="idTax"/>
                <html:hidden property="idJobSheet"/>
		<tr>
			<td>NoFaktur:</td>
			<td><html:text property="noFaktur" size="35"/></td>
		</tr>
		<tr>
			<td>FakturDate:</td>
			<td><html:text property="fakturDateAsString" size="10"/>
                        <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                                onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                                <script type="text/javascript">
                                    Calendar.setup({
                                        inputField     :    "fakturDateAsString",     // id of the input field
                                        ifFormat       :    "%d/%m/%Y",      // format of the input field
                                        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
                                        //align          :    "Tl",           // alignment (defaults to "Bl")
                                        singleClick    :    true
                                    });
                                </script>
                    </td>
		</tr>
		<tr>
			<td>DPP:</td>
			<td><html:text property="dpp" size="13"/></td>
		</tr>                
		<tr>
                        <td colspan="2" height="10"></td>
                </tr>    		
