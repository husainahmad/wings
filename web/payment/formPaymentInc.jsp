<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar.js"></script>        
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/lang/calendar-en.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/calendar-setup.js"></script>
<script>
    function countPayment() {

        var countRow = document.getElementById("hidRow").value;
        var payAmountUSD = document.getElementById("payAmountUSD").value;
        payAmountUSD = payAmountUSD.toString().replace(/\$|\,/g,'');
        var payAmountIDR = document.getElementById("payAmountIDR").value;
        payAmountIDR = payAmountIDR.toString().replace(/\$|\,/g,'');
        
        var totalAmountUSD = document.getElementById("totalAmountUSD").value;
        totalAmountUSD = totalAmountUSD.toString().replace(/\$|\,/g,'');
        var totalAmountIDR = document.getElementById("totalAmountIDR").value;
        totalAmountIDR = totalAmountIDR.toString().replace(/\$|\,/g,'');
        
        var totalPphIDR = document.getElementById("totalPPH").value;
        totalPphIDR = totalPphIDR.toString().replace(/\$|\,/g,'');
        
        var i = 1;
                
        for (i=1; i<=countRow; i++) {
            var chargeUSD = "chargeUSD";
            var chargeIDR = "chargeIDR";
            var chargePPH = "chargePPH";
            
            var billUSD = "billUSD";
            var billIDR = "billIDR";
            var kurs = "kurs";
            try {                
                billUSD = billUSD + i;
                billIDR = billIDR + i;
                chargeUSD = chargeUSD + i;
                chargeUSD = document.getElementById(chargeUSD).value;
                chargeUSD = chargeUSD.toString().replace(/\$|\,/g,'');                
                
                chargeIDR = chargeIDR + i;
                chargeIDR = document.getElementById(chargeIDR).value;
                chargeIDR = chargeIDR.toString().replace(/\$|\,/g,'');
                
                chargePPH = chargePPH + i;
                chargePPH = document.getElementById(chargePPH).value;
                chargePPH = chargePPH.toString().replace(/\$|\,/g,'');
                
                if (parseFloat(totalAmountIDR)>=parseFloat(payAmountIDR + chargePPH)) {                    
                    document.getElementById(billIDR).value=formatCurrency(parseFloat(chargeIDR + chargePPH));                        
                    payAmountIDR=parseFloat(payAmountIDR)+parseFloat(chargeIDR + chargePPH);                    
                } 

                if (parseFloat(totalAmountUSD)>=parseFloat(payAmountUSD)) {                    
                    document.getElementById(billUSD).value=formatCurrency(parseFloat(chargeUSD));                        
                    payAmountUSD=parseFloat(payAmountUSD)+parseFloat(chargeUSD);
                } 
                
            } catch (e) {
                alert(e);
            }                                                                               
        } // end for        
        document.getElementById("payAmountUSD").value = formatCurrency(payAmountUSD);        
        document.getElementById("payAmountIDR").value = formatCurrency(payAmountIDR);   
        
        document.getElementById("unpayAmountUSD").value = formatCurrency(totalAmountUSD-payAmountUSD);        
        document.getElementById("unpayAmountIDR").value = formatCurrency((totalAmountIDR+totalPPH)-payAmountIDR);   
        
        
    }
    
    function reCountDep(index) {
        var reco = 'reco' + index;      
        //alert(document.getElementById(reco).value);
        var billIDR = 'billIDR'+index;
        
        if (!document.getElementById(reco).checked) {
            document.getElementById(billIDR).value = "0";
            return;
        }
            
        var ikurs = 'kurs' + index;
        ikurs = document.getElementById(ikurs).value;
        if (ikurs=='USD') {
            var chargeUSD = 'chargeUSD'+index;
            chargeUSD = document.getElementById(chargeUSD).value;
            var billUSD = 'billUSD'+index;
            document.getElementById(billUSD).value = chargeUSD;
        } else {
            var chargeIDR = 'chargeIDR'+index;
            chargeIDR = document.getElementById(chargeIDR).value;
            
            var chargePPH = 'chargePPH'+index;
            chargePPH = document.getElementById(chargePPH).value;
            
            var isPPH = 'isPPH'+index;
            isPPH = document.getElementById(isPPH).checked;
                        
            if (isPPH) {
                document.getElementById(billIDR).value = formatCurrency(parseFloat(chargeIDR.toString().replace(/\$|\,/g,'')) - parseFloat(chargePPH.toString().replace(/\$|\,/g,'')));
            } else {
                document.getElementById(billIDR).value = formatCurrency(parseFloat(chargeIDR.toString().replace(/\$|\,/g,'')));
            }                        
        }
    }
    
</script>
<script language="JavaScript">
    function doAcc(id) {        
        document.getElementById("hidid").value = id;
        window.open('<%=request.getContextPath()%>/account/listAccount.do?idAcc='+id,null,'height=650,width=550,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,left=0,top=0,screenX=0,screenY=0') 
    }
    function doChange() {     
        
        var accD = document.getElementById("hidid").value;
        
        var accD2 = document.getElementById(accD).value;
        
        var accD3 = document.getElementById("idAcc").value;
        
        accD2.value = accD3;
    }
</script>

<input type="hidden" name="hidid" id="hidid">
<input type="hidden" name="idAcc" id="idAcc" onchange="doChange()" >

<tr>
    <td colspan="2">
        <table width="100%">
            <tr bgcolor="yellow">
<!--                <td>Acc IDR</td>
                <td>Acc USD</td>-->
                <td>Name</td>
                <td>JobNo</td>   
                <td>Number</td>                
                <td>Date</td>                
                <td>Bank/Cash</td>
                <td>Amount USD</td>
                <td>Amount IDR</td>
                <td>PPH</td>
                <td></td>                
                <td>Payment USD</td>
                <td>Payment IDR</td>                
                <td>Kurs</td>
                <td>Value</td>
                <td></td>
            </tr>
            <%
            java.text.DecimalFormat moneyFormat = new java.text.DecimalFormat("#,###,###.##");
            com.wings.web.struts.forms.KursdollarForm kursForm = (com.wings.web.struts.forms.KursdollarForm)request.getSession().getAttribute("kursdollarForm");
            String kursDollar = moneyFormat.format(kursForm.getValue().doubleValue());
            int i = 0;
            %>
            <logic:notEmpty name="PayableList" scope="request">                                                                                            
                <logic:iterate id="payment" name="PayableList" type="com.wings.persistence.InvoiceAIDetail">                                
                    <%
                    i++;
                    %>
                    <tr>                                                
                        <td><input type="text" name="name<%=i%>" id="name<%=i%>" value="<bean:write name="payment" property="name" />"></td>
                        <td><input type="text" name="jobNo<%=i%>" id="jobNo<%=i%>" size="18" value="<bean:write name="payment" property="jobNo" />"></td>                        
                        <td><input type="text" name="idNumber<%=i%>" id="idNumber<%=i%>" size="18" value="<bean:write name="payment" property="idNumber" />"></td>                        
                        <td>
                            <input type="text" name="datte<%=i%>" id="datte<%=i%>" value="" size="10">
                            <img src="<%=request.getContextPath()%>/Javascript/jscalendar-1.0/img.gif" id="f_trigger_c<%=i%>" style="cursor: pointer; border: 1px solid red;" title="Date selector"
                            onmouseover="this.style.background='red';" onmouseout="this.style.background=''" />
                            <script type="text/javascript">
                                Calendar.setup({
                                    inputField     :    "datte<%=i%>",     // id of the input field
                                    ifFormat       :    "%d/%m/%Y",      // format of the input field
                                    button         :    "f_trigger_c<%=i%>",  // trigger for the calendar (button ID)
                                    //align          :    "Tl",           // alignment (defaults to "Bl")
                                    singleClick    :    true
                                });
                            </script>
                        </td>                        
                        <td>
                            <select name="bank<%=i%>">
                                <option value="1101001">Cash On Hand IDR</option>
                                <option value="1101002">Cash On Hand USD</option>
                                <option value="1102001">Bank Permata USD</option>
                                <option value="1102002">Bank Permata IDR</option>
                                <option value="1102003">BCA USD</option>
                                <option value="1102004">BCA IDR</option>
                                <option value="1102005">Bank Woori</option>
                                <option value="1102006">City Bank USD</option>
                                <option value="1102007">City Bank IDR</option>
                                <option value="1102008">Hana Bank</option>
                                <option value="1102009">BNI</option>
                                
                            </select>
                                <input type="hidden" name="vatIDR<%=i%>" id="vatIDR<%=i%>"  value="<bean:write name="payment" property="vatIDR" />">
                                <input type="hidden" name="vatIDR2<%=i%>" id="vatIDR2<%=i%>"  value="<bean:write name="payment" property="vatIDR2" />">
<!--                                <input type="text" name="bank<%=i%>" id="bank<%=i%>" size="9" value="1102004">-->
                        </td>
                        <td><input type="text" name="chargeUSD<%=i%>" id="chargeUSD<%=i%>" value="<bean:write name="payment" property="totalBillingUSD" format="###,###.##" />" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" size="9"></td>
                        <td><input type="text" name="chargeIDR<%=i%>" id="chargeIDR<%=i%>" value="<bean:write name="payment" property="totalBillingIDR" format="###,###"/>" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" size="9"></td>
                        <td><input type="text" name="chargePPH<%=i%>" id="chargePPH<%=i%>" value="<bean:write name="payment" property="pphIDR" format="###,###"/>" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" size="9"></td>
                        <td><input type="checkbox" name="isPPH<%=i%>" id="isPPH<%=i%>" onclick="reCountDep('<%=i%>');"></td>
                        <td><input type="text" name="billUSD<%=i%>" id="billUSD<%=i%>" size="9" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="0"></td>
                        <td><input type="text" name="billIDR<%=i%>" id="billIDR<%=i%>" size="9" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" value="0"></td>
                        <td>
                            <select name="kurs<%=i%>" id="kurs<%=i%>">
                                <logic:greaterThan name="payment" property="totalBillingUSD" value="0">
                                    <option value="USD" selected>USD</option>
                                    <option value="IDR">IDR</option>
                                </logic:greaterThan>
                                <logic:greaterThan name="payment" property="totalBillingIDR" value="0">
                                    <option value="USD">USD</option>
                                    <option value="IDR" selected>IDR</option>
                                </logic:greaterThan>
                            </select>                            
                        </td>
                        
                        <td><input type="text" name="kursvalue<%=i%>" id="kursvalue<%=i%>" style="text-align: right;" onBlur="this.value=formatCurrency(this.value);" onkeydown="if(event.keyCode==13) event.keyCode=9;" size="6"></td>
                        <td><input type="checkbox" id="reco<%=i%>" name="reco<%=i%>" value="true" onclick="reCountDep('<%=i%>');"></td>
                    </tr>            
                </logic:iterate>
            </logic:notEmpty>
            <input type="hidden" name="hidRow" id="hidRow" value="<%=i%>"/>
        </table>    
    </td>
</tr>

