function subtractbaDebit() {
    var table=document.getElementById("tableSellingDebitNote");
    var rowCount = table.rows.length;
    if (rowCount>1) {
        table.deleteRow(rowCount-1);
        rowCount = table.rows.length;
        document.getElementById("dacountbaDebit").value=rowCount-1;
        countBilling();
    }                    
}	
function subtractbaDebit2(rownum) {                    
    
    var dacountbaDebit = rownum;                                        
    var table=document.getElementById("tableSellingDebitNote");
    table.deleteRow(dacountbaDebit);
    document.getElementById("dacountbaDebit").value--;                    
    countBilling();
}
            
function addbaDebit() {
                
    var table=document.getElementById("tableSellingDebitNote");
    var rowCount = table.rows.length;
    
    document.getElementById('dacountbaDebit').value = rowCount;        
    
    var dacountbaDebit = document.getElementById('dacountbaDebit').value;
    var kursValue = "billingAgentKursValueDebit"+dacountbaDebit;
    var chargeDebit = "billingAgentChargeDebit"+dacountbaDebit;
    var kurs = "billingAgentKursDebit"+dacountbaDebit;
    var oriKurs = "billingAgentOriKursDebit"+dacountbaDebit;
    var oriWeight = "billingAgentOriWeightDebit"+dacountbaDebit;
    
    var new_row = table.insertRow(rowCount);    
    
    var cell1 = new_row.insertCell(0);
    var cell2 = new_row.insertCell(1);
    var cell3 = new_row.insertCell(2);
    var cell4 = new_row.insertCell(3);
    var cell5 = new_row.insertCell(4);
    var cell6 = new_row.insertCell(5);
    var cell7 = new_row.insertCell(6);
    var cell8 = new_row.insertCell(7);
    var cell9 = new_row.insertCell(8);
//    var cell10 = new_row.insertCell(9);
//    var cell11 = new_row.insertCell(10);    
//    var cell12 = new_row.insertCell(11); 
    // Add some text to the new cells:

    cell1.innerHTML = "<select name=\"billingidAgentFeeDebit"+dacountbaDebit+"\"  id=\"billingidAgentFeeDebit"+dacountbaDebit+"\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    getDataBilling() +
    "</select>";
    
    cell2.innerHTML = "<input type=\"text\" name=\"billingAgentOriKursDebit"+dacountbaDebit+"\" id=\"billingAgentOriKursDebit"+dacountbaDebit+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell3.innerHTML = "<input type=\"text\" name=\"billingAgentOriWeightDebit"+dacountbaDebit+"\" id=\"billingAgentOriWeightDebit"+dacountbaDebit+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell4.innerHTML = "<input type=\"text\" name=\"billingAgentChargeDebit"+dacountbaDebit+"\" id=\"billingAgentChargeDebit"+dacountbaDebit+"\" size=\"10\" onchange=\"countBilling()\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell5.innerHTML = "<input type=\"text\" name=\"billingAgentDescDebit"+dacountbaDebit+"\" id=\"billingAgentDescDebit"+dacountbaDebit+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell6.innerHTML = "<input type=\"text\" name=\"billingAgentDescriptionDebit"+dacountbaDebit+"\" id=\"billingAgentDescriptionDebit"+dacountbaDebit+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell7.innerHTML = "<select name=\"billingAgentKursDebit"+dacountbaDebit+"\" id=\"billingAgentKursDebit"+dacountbaDebit+"\" onchange=\"countBilling()\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    "<option value=\"IDR\">IDR</option>"+
    "<option value=\"USD\" selected>USD</option>"+
    "</select>";
    cell8.innerHTML = "<input type=\"text\" name=\"billingAgentKursValueDebit"+dacountbaDebit+"\" id=\"billingAgentKursValueDebit"+dacountbaDebit+"\" onBlur=\"this.value=formatCurrency(this.value);\" value=\"" + kursDollar + "\" style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    //cell9.innerHTML = "<input type=\"checkbox\" name=\"billingAgentTaxDebit"+dacountbaDebit+"\" id=\"billingAgentTaxDebit"+dacountbaDebit+"\" value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    //cell10.innerHTML = "<input type=\"checkbox\" name=\"billingAgentVatDebit"+dacountbaDebit+"\" id=\"billingAgentVatDebit"+dacountbaDebit+"\"  value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    //cell11.innerHTML = "<input type=\"checkbox\" name=\"billingAgentTax2Debit"+dacountbaDebit+"\" id=\"billingAgentTax2Debit"+dacountbaDebit+"\"  value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell9.innerHTML = "<input type=\"button\" value=\"-\" onclick=\"subtractbaDebit2(" + dacountbaDebit + ")\" >&nbsp;<input type=\"button\" value=\"$\" onclick=\"convertToDollarOrRupiah('" + kursValue + "','" + chargeDebit + "','" + kurs + "')\" >";                

                
}
function subtractbaInvoice() {                
    var table=document.getElementById("tableSellingInvoice");
    var rowCount = table.rows.length;
    if (rowCount>0) {
        table.deleteRow(rowCount-1);
        rowCount = table.rows.length;
        document.getElementById("dacountbaInvoice").value=rowCount-1;
        countBilling();                                        
    }                 
}	

function subtractbaInvoice2(rownum) {    
    var table=document.getElementById("tableSellingInvoice");
    var rowCount = table.rows.length;
    if (rowCount>0) {
        table.deleteRow(rownum);
        rowCount = table.rows.length;
        document.getElementById("dacountbaInvoice").value=rowCount-1;
        countBilling();                                        
    }   
}

function addbaInvoice() {
                
    var table=document.getElementById("tableSellingInvoice");
    var rowCount = table.rows.length;
    
    document.getElementById("dacountbaInvoice").value = rowCount; 
    var dacountbaInvoice = document.getElementById("dacountbaInvoice").value;                   
    dacountbaInvoice = document.getElementById("dacountbaInvoice").value;
    
    var kursValue = "billingAgentKursValueInvoice"+dacountbaInvoice;
    var chargeDebit = "billingAgentChargeInvoice"+dacountbaInvoice;
    var kurs = "billingAgentKursInvoice"+dacountbaInvoice;
    var oriKurs = "billingAgentOriKursInvoice"+dacountbaInvoice;
    var oriWeight = "billingAgentOriWeightInvoice"+dacountbaInvoice;
    
    var new_row = table.insertRow(rowCount);

    var cell1 = new_row.insertCell(0);
    var cell2 = new_row.insertCell(1);
    var cell3 = new_row.insertCell(2);
    var cell4 = new_row.insertCell(3);
    var cell5 = new_row.insertCell(4);
    var cell6 = new_row.insertCell(5);
    var cell7 = new_row.insertCell(6);
    var cell8 = new_row.insertCell(7);
    var cell9 = new_row.insertCell(8);
    var cell10 = new_row.insertCell(9);
    var cell11 = new_row.insertCell(10);    
    var cell12 = new_row.insertCell(11);   
    
    
    // Add some text to the new cells:
    cell1.innerHTML = "<select name=\"billingidAgentFeeInvoice"+dacountbaInvoice+"\"  id=\"billingidAgentFeeInvoice"+dacountbaInvoice+"\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    getDataInvoice() +
    "</select>";
    
    cell2.innerHTML = "<input type=\"text\" name=\"billingAgentOriKursInvoice"+dacountbaInvoice+"\" id=\"billingAgentOriKursInvoice"+dacountbaInvoice+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\"  onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell3.innerHTML = "<input type=\"text\" name=\"billingAgentOriWeightInvoice"+dacountbaInvoice+"\" id=\"billingAgentOriWeightInvoice"+dacountbaInvoice+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\"  onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell4.innerHTML = "<input type=\"text\" name=\"billingAgentChargeInvoice"+dacountbaInvoice+"\" id=\"billingAgentChargeInvoice"+dacountbaInvoice+"\" size=\"10\" onchange=\"countBilling()\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align:right;\"  onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell5.innerHTML = "<input type=\"text\" name=\"billingAgentDescInvoice"+dacountbaInvoice+"\" id=\"billingAgentDescInvoice"+dacountbaInvoice+"\" size=\"20\"  onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell6.innerHTML = "<input type=\"text\" name=\"billingAgentDescriptionInvoice"+dacountbaInvoice+"\" id=\"billingAgentDescriptionInvoice"+dacountbaInvoice+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell7.innerHTML = "<select name=\"billingAgentKursInvoice"+dacountbaInvoice+"\" id=\"billingAgentKursInvoice"+dacountbaInvoice+"\" onchange=\"countBilling()\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    "<option value=\"IDR\">IDR</option>"+
    "<option value=\"USD\">USD</option>"+
    "</select>";
    cell8.innerHTML = "<input type=\"text\" name=\"billingAgentKursValueInvoice"+dacountbaInvoice+"\" id=\"billingAgentKursValueInvoice"+dacountbaInvoice+"\" onBlur=\"this.value=formatCurrency(this.value);\" value=\"" + kursDollar + "\" style=\"text-align: right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell9.innerHTML = "<input type=\"checkbox\" name=\"billingAgentTaxInvoice"+dacountbaInvoice+"\" id=\"billingAgentTaxInvoice"+dacountbaInvoice+"\" value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell10.innerHTML = "<input type=\"checkbox\" name=\"billingAgentVatInvoice"+dacountbaInvoice+"\" id=\"billingAgentVatInvoice"+dacountbaInvoice+"\" value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell11.innerHTML = "<input type=\"checkbox\" name=\"billingAgentTax2Invoice"+dacountbaInvoice+"\" id=\"billingAgentTax2Invoice"+dacountbaInvoice+"\" value=\"1\" onchange =\"countBilling()\"  style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell12.innerHTML = "<input type=\"button\" value=\"-\" onclick=\"subtractbaInvoice2(" + dacountbaInvoice + ")\" >&nbsp;<input type=\"button\" value=\"$\" onclick=\"convertToDollarOrRupiah('" + kursValue + "','" + chargeDebit + "','" + kurs + "')\" >";                
}
function selectFocus(objectIn) {                
    document.getElementById(objectIn).focus();
}
function subtractexpensesagentDebit() {
    var table=document.getElementById("tableCostDebitNote");
    var rowCount = table.rows.length;
    if (rowCount>0) {
        table.deleteRow(rowCount-1);
        rowCount = table.rows.length;
        document.getElementById("dacountexpensesagentDebit").value=rowCount-1;
        countBilling();                                        
    }        
}	

function subtractexpensesagentDebit2(rownum) {
                    
    var table=document.getElementById("tableCostDebitNote");
    table.deleteRow(rownum);
    
    var rowCount = table.rows.length;
    if (rowCount>1) {        
        rowCount = table.rows.length;
        document.getElementById("dacountexpensesagentDebit").value=rowCount-1;        
    }  
    
    countExpenses();
}
function addexpensesagentDebit() {
    
    var table=document.getElementById("tableCostDebitNote");
    var rowCount = table.rows.length;
    
    document.getElementById("dacountexpensesagentDebit").value = rowCount;     
    //alert(document.getElementById("dacountexpensesagentDebit").value);
    var dacountexpensesagentDebit = document.getElementById("dacountexpensesagentDebit").value;
    var kursValue = "expensesAgentKursValueDebit"+dacountexpensesagentDebit;
    var chargeDebit = "expensesAgentChargeDebit"+dacountexpensesagentDebit;
    var kurs = "expensesAgentKursDebit"+dacountexpensesagentDebit;
    var oriKurs = "expensesAgentOriKursDebit"+dacountexpensesagentDebit;
    var oriWeight = "expensesAgentOriWeightDebit"+dacountexpensesagentDebit;                    
        
    var new_row = table.insertRow(rowCount);

    var cell1 = new_row.insertCell(0);
    var cell2 = new_row.insertCell(1);
    var cell3 = new_row.insertCell(2);
    var cell4 = new_row.insertCell(3);
    var cell5 = new_row.insertCell(4);
    var cell6 = new_row.insertCell(5);
    var cell7 = new_row.insertCell(6);
    var cell8 = new_row.insertCell(7);
    var cell9 = new_row.insertCell(8);
//    var cell10 = new_row.insertCell(9);
//    var cell11 = new_row.insertCell(10);    
    // Add some text to the new cells:
    cell1.innerHTML = "<select name=\"expensesidAgentFeeDebit"+dacountexpensesagentDebit+"\" id=\"expensesidAgentFeeDebit"+dacountexpensesagentDebit+"\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    getDataBilling()+
    "</select>";
    cell2.innerHTML = "<input type=\"text\" name=\"expensesAgentOriKursDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentOriKursDebit"+dacountexpensesagentDebit+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell3.innerHTML = "<input type=\"text\" name=\"expensesAgentOriWeightDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentOriWeightDebit"+dacountexpensesagentDebit+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell4.innerHTML = "<input type=\"text\" name=\"expensesAgentChargeDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentChargeDebit"+dacountexpensesagentDebit+"\" size=\"10\" onchange=\"countBilling()\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell5.innerHTML = "<input type=\"text\" name=\"expensesAgentDescDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentDescDebit"+dacountexpensesagentDebit+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell6.innerHTML = "<input type=\"text\" name=\"expensesAgentDescriptionDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentDescriptionDebit"+dacountexpensesagentDebit+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell7.innerHTML = "<select name=\"expensesAgentKursDebit"+dacountexpensesagentDebit+"\"  id=\"expensesAgentKursDebit"+dacountexpensesagentDebit+"\" onchange=\"countBilling()\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    "<option value=\"IDR\">IDR</option>"+
    "<option value=\"USD\" selected>USD</option>"+
    "</select>";
    cell8.innerHTML = "<input type=\"text\" name=\"expensesAgentKursValueDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentKursValueDebit"+dacountexpensesagentDebit+"\" size=\"10\" value=\"" + kursDollar + "\" onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
//    cell9.innerHTML = "<input type=\"checkbox\" name=\"expensesAgentTaxDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentTaxDebit"+dacountexpensesagentDebit+"\" value=\"1\" style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
//    cell10.innerHTML = "<input type=\"checkbox\" name=\"expensesAgentVatDebit"+dacountexpensesagentDebit+"\" id=\"expensesAgentVatDebit"+dacountexpensesagentDebit+"\" value=\"1\" style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell9.innerHTML = "<input type=\"button\" value=\"-\" onclick=\"subtractexpensesagentDebit2(" + dacountexpensesagentDebit + ")\" >&nbsp;<input type=\"button\" value=\"$\" onclick=\"convertToDollarOrRupiah('" + kursValue + "','" + chargeDebit + "','" + kurs + "')\" >";                
    
}
function subtractexpensesagentInvoice() {
    
    var table=document.getElementById("tableCostInvoice");
    var rowCount = table.rows.length;
    if (rowCount>1) {
        table.deleteRow(rowCount-1);
        rowCount = table.rows.length;
        document.getElementById("dacountexpensesagentInvoice").value=rowCount-1;
        countBilling();                                        
    } 
    
//alert(dacountexpensesagentInvoice);                    
}	

function subtractexpensesagentInvoice2(rownum) {
    var table=document.getElementById("tableCostInvoice");
    var rowCount = table.rows.length;
    if (rowCount>0) {
        table.deleteRow(rownum);
        rowCount = table.rows.length;
        document.getElementById("dacountexpensesagentInvoice").value=rowCount-1;
        countBilling();                                        
    }     
                    
}	

function addexpensesagentInvoice() {
    var table=document.getElementById("tableCostInvoice");
    var rowCount = table.rows.length;            
    
    document.getElementById("dacountexpensesagentInvoice").value = rowCount;       
    var dacountexpensesagentInvoice = document.getElementById("dacountexpensesagentInvoice").value;                 
    dacountexpensesagentInvoice = document.getElementById("dacountexpensesagentInvoice").value;
    
    var kursValue = "expensesAgentKursValueInvoice"+dacountexpensesagentInvoice;
    var chargeDebit = "expensesAgentChargeInvoice"+dacountexpensesagentInvoice;
    var kurs = "expensesAgentKursInvoice"+dacountexpensesagentInvoice;
    var oriKurs = "expensesAgentOriKursInvoice"+dacountexpensesagentInvoice;
    var oriWeight = "expensesAgentOriWeightInvoice"+dacountexpensesagentInvoice;                                
    
    var new_row = table.insertRow(rowCount);

    var cell1 = new_row.insertCell(0);
    var cell2 = new_row.insertCell(1);
    var cell3 = new_row.insertCell(2);
    var cell4 = new_row.insertCell(3);
    var cell5 = new_row.insertCell(4);
    var cell6 = new_row.insertCell(5);
    var cell7 = new_row.insertCell(6);
    var cell8 = new_row.insertCell(7);
    var cell9 = new_row.insertCell(8);
//    var cell10 = new_row.insertCell(9);
//    var cell11 = new_row.insertCell(10);    
    // Add some text to the new cells:
    cell1.innerHTML = "<select name=\"expensesidAgentFeeInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesidAgentFeeInvoice"+dacountexpensesagentInvoice+"\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    getDataInvoice()+
    "</select>";
    cell2.innerHTML = "<input type=\"text\" name=\"expensesAgentOriKursInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentOriKursInvoice"+dacountexpensesagentInvoice+"\"  size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell3.innerHTML = "<input type=\"text\" name=\"expensesAgentOriWeightInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentOriWeightInvoice"+dacountexpensesagentInvoice+"\" size=\"10\" onchange=\"countCharge('"+oriKurs+"','"+oriWeight+"','"+chargeDebit+"')\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell4.innerHTML = "<input type=\"text\" name=\"expensesAgentChargeInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentChargeInvoice"+dacountexpensesagentInvoice+"\" size=\"10\" onchange=\"countBilling()\"  onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell5.innerHTML = "<input type=\"text\" name=\"expensesAgentDescInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentDescInvoice"+dacountexpensesagentInvoice+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell6.innerHTML = "<input type=\"text\" name=\"expensesAgentDescriptionInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentDescriptionInvoice"+dacountexpensesagentInvoice+"\" size=\"20\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell7.innerHTML = "<select name=\"expensesAgentKursInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentKursInvoice"+dacountexpensesagentInvoice+"\"  onchange=\"countBilling()\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\">"+
    "<option value=\"IDR\">IDR</option>"+
    "<option value=\"USD\">USD</option>"+
    "</select>";
    cell8.innerHTML = "<input type=\"text\" name=\"expensesAgentKursValueInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentKursValueInvoice"+dacountexpensesagentInvoice+"\" size=\"10\" value=\"" + kursDollar + "\" onBlur=\"this.value=formatCurrency(this.value);\" style=\"text-align: right;\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
//    cell9.innerHTML = "<input type=\"checkbox\" name=\"expensesAgentTaxInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentTaxInvoice"+dacountexpensesagentInvoice+"\" value=\"1\" style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
//    cell10.innerHTML = "<input type=\"checkbox\" name=\"expensesAgentVatInvoice"+dacountexpensesagentInvoice+"\" id=\"expensesAgentVatInvoice"+dacountexpensesagentInvoice+"\" value=\"1\" style=\"text-align:right;\" size=\"10\" onkeydown=\"if(event.keyCode==13) event.keyCode=9;\"/>";
    cell9.innerHTML = "<input type=\"button\" value=\"-\" onclick=\"subtractexpensesagentInvoice2(" + dacountexpensesagentInvoice + ")\" >&nbsp;<input type=\"button\" value=\"$\" onclick=\"convertToDollarOrRupiah('" + kursValue + "','" + chargeDebit + "','" + kurs + "')\" >";                
    
}