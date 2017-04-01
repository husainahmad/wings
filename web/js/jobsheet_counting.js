
            
function convertToDollarOrRupiah(kursValue,chargeDebit,kurs) {
    var kv = document.getElementById(kursValue).value; 
    kv = kv.toString().replace(/\$|\,/g,'');
    var cd = document.getElementById(chargeDebit).value; 
    cd = cd.toString().replace(/\$|\,/g,'');
    var kr = document.getElementById(kurs).value; 
    var tot = 0;
    if (kr=='IDR') {
        tot = cd*kv;
        document.getElementById(chargeDebit).value = formatCurrency(tot);                    
    } else {
        tot = cd/kv;
        document.getElementById(chargeDebit).value = formatCurrency(tot);                    
    }
}
                        
            
function countBilling() {
    var dacountbaDebit = document.getElementById("dacountbaDebit").value;    
    var i = 1;
    var billacchd = "billingAgentChargeDebit";
    var kurs = "billingAgentKursDebit";
    
    var param_tax = "billingAgentTaxDebit";
    var param_vat = "billingAgentVatDebit";
    var param_tax2 = "billingAgentTax2Debit";
    
    var pas1 = "";
    var pas2 = "";
    var tax1 = "";
    var vat1 = "";
    var tax2 = "";
    
    var totalIDR = 0;
    var totalUSD = 0;
    var totalDPPIDR = 0;
    var totalPPHIDR = 0;
    var totalDPP2IDR = 0;
    
    var totalDPPUSD = 0;
    var totalPPHUSD =0;
    var totalDPP2USD =0;
    
    for (i=1; i<=dacountbaDebit+5; i++) {
        try {
            pas2 = kurs + i;
            pas2 = document.getElementById(pas2).value;

            pas1 = billacchd + i;
            pas1 = document.getElementById(pas1).value;     
            pas1 = pas1.toString().replace(/\$|\,/g,'');
            
            tax1 = document.getElementById(param_tax+i);  
            vat1 = document.getElementById(param_vat+i);  
            
            tax2 = document.getElementById(param_tax2+i);  
            
            if (pas2=="IDR") {
                totalIDR+=parseFloat(pas1);    
            } else {
                totalUSD+=parseFloat(pas1);    
            }
            
        } catch (e) {
        }                                                                               
    }
                
    var dacountbaInvoice = document.getElementById("dacountbaInvoice").value;
                                
    i = 1;
    billacchd = "billingAgentChargeInvoice";
    kurs = "billingAgentKursInvoice";
    
    tax = "billingAgentTaxInvoice";
    vat = "billingAgentVatInvoice";
    tax2 = "billingAgentTax2Invoice";
    
    pas1 = "";
    pas2 = "";                
    pas3 = "";
    
    for (i=1; i<=dacountbaInvoice+5; i++) {
        try {                        
            pas2 = kurs + i;
            pas2 = document.getElementById(pas2).value;

            pas1 = billacchd + i;
            pas1 = document.getElementById(pas1).value;     
            pas1 = pas1.toString().replace(/\$|\,/g,'');
            
            tax1 = document.getElementById(tax+i);  
            vat1 = document.getElementById(vat+i); 
            pas3 = document.getElementById(tax2+i); 
            
            if (pas2=="IDR") {
                totalIDR+=parseFloat(pas1);   
                if (tax1.checked) {
                    totalDPPIDR += parseFloat(pas1);
                } 
                
                if (pas3.checked) {
                    totalDPP2IDR += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    totalPPHIDR += parseFloat(pas1);
                    
                } 
            } else {
                totalUSD+=parseFloat(pas1); 
                if (tax1.checked) {
                    totalDPPUSD += parseFloat(pas1);
                } 

                if (pas3.checked) {
                    totalDPP2USD += parseFloat(pas1);
                } 
                
                if (vat1.checked) {
                    totalPPHUSD += parseFloat(pas1);                    
                } 
            }
        } catch (e) {
        }                                                                               
    }
    
    countExpenses();
    
    var vat2IDR = Math.round(totalDPP2IDR * 0.01);
    
    totalDPP2IDR = Math.round(totalDPP2IDR * 0.10);
    totalDPP2USD = totalDPP2USD * 0.10;
    
    var vatIDR = Math.round(totalDPPIDR * 0.10);
    
    var pph23IDR = Math.round((totalDPPIDR+totalDPP2IDR) * 0.02);
    
    var vatUSD = totalDPPUSD * 0.10;
    var vat2USD = totalDPP2USD * 0.01;
    var pph23USD = totalPPHUSD * 0.02;
    
    document.getElementById("totalSellingUSDAsString").value = formatCurrency(totalUSD);
    document.getElementById("totalSellingUSD").value = formatCurrency(totalUSD);
    
    document.getElementById("totalSellingIDRAsString").value = formatCurrency(Math.round(totalIDR));
    document.getElementById("totalSellingIDR").value = totalIDR;
    
    document.getElementById("totalDPPUSDAsString").value = formatCurrency(totalDPPUSD);
    document.getElementById("totalDPPIDRAsString").value = formatCurrency(totalDPPIDR);
    
    document.getElementById("totalDPP2USDAsString").value = formatCurrency(totalDPP2USD);
    document.getElementById("totalDPP2IDRAsString").value = formatCurrency(totalDPP2IDR);
          
    document.getElementById("totalVatUSDAsString").value = formatCurrency(vatUSD);
    document.getElementById("totalVatIDRAsString").value = formatCurrency(vatIDR);
    
    document.getElementById("totalVat2USDAsString").value = formatCurrency(vat2USD);
    document.getElementById("totalVat2IDRAsString").value = formatCurrency(vat2IDR);
    
    document.getElementById("totalPPHUSDAsString").value = formatCurrency(pph23USD);
    document.getElementById("totalPPHIDRAsString").value = formatCurrency(pph23IDR);
    
    document.getElementById("subTotalBillingUSDAsString").value = formatCurrency(totalUSD + vatUSD + vat2USD);    
    document.getElementById("subTotalBillingIDRAsString").value = formatCurrency(Math.round(totalIDR + vatIDR + vat2IDR));        
    
    document.getElementById("totalBillingUSDAsString").value = formatCurrency((totalUSD + vatUSD + vat2USD) - pph23USD);
    document.getElementById("totalBillingIDRAsString").value = formatCurrency(Math.round((totalIDR + vatIDR + vat2IDR) - pph23IDR));
    
    document.getElementById("totalBillingUSD").value = ((totalUSD + vatUSD + vat2USD) - pph23USD);
    document.getElementById("totalBillingIDR").value = ((totalIDR + vatIDR + vat2IDR) - pph23IDR);                
                
    var totalBillingIDR = document.getElementById("totalBillingIDR").value;
    var totalBillingUSD = document.getElementById("totalBillingUSD").value;    
    
    var totalExpensesIDR = document.getElementById("totalExpensesIDR").value;
    var totalExpensesUSD = document.getElementById("totalExpensesUSD").value;          
                 
    var refundUSD = 0;
    var refundIDR = 0;
                
    totalBillingIDR=parseFloat(totalBillingIDR);     
    totalExpensesIDR=(parseFloat(totalExpensesIDR) + vatIDR + vat2IDR);
    totalExpensesUSD=(parseFloat(totalExpensesUSD) + vatUSD);
    
    document.getElementById("totalExpensesIDRAsString").value = formatCurrency(Math.round(totalExpensesIDR));
    document.getElementById("totalExpensesUSDAsString").value = formatCurrency(totalExpensesUSD);
    document.getElementById("totalExpensesIDR").value = totalExpensesIDR;
    document.getElementById("totalExpensesUSD").value = totalExpensesUSD;
    
    try {                        
        if (totalBillingIDR>totalExpensesIDR) {                       
            if (totalExpensesIDR>0)
                refundIDR = Math.round((totalBillingIDR-totalExpensesIDR) * 0.3);                        
        }                       
    } catch (e) {
        refundIDR = 0;
    }           
                
    totalExpensesUSD=parseFloat(totalExpensesUSD); 
    totalBillingUSD=parseFloat(totalBillingUSD); 
    try {               
        if (totalBillingUSD>totalExpensesUSD) {                       
            if (totalBillingUSD>0) {                           
                if (totalBillingUSD>=51) {                               
                    refundUSD = (totalBillingUSD-totalExpensesUSD) * 0.3;
                } else {
                    refundUSD = 0;
                }                    
            } else {
                refundUSD = 0;
            }
        } else {
            refundUSD = 0;
        }                                              
    } catch (e) {
        refundUSD = 0;
    }           
                        
    var creditNoteIDR = 0;
    var creditNoteUSD = 0;
                
    try {
        creditNoteIDR = parseFloat(document.getElementById("creditNoteIDR").value);      
    } catch (e) {
        creditNoteIDR = 0;
    }
                
    try {
        creditNoteUSD = parseFloat(document.getElementById("creditNoteUSD").value);      
    } catch (e) {
        creditNoteUSD = 0;
    }        
                
    if (refundIDR>creditNoteIDR) {
        document.getElementById("refundIDR").value = Math.round(parseFloat(refundIDR-creditNoteIDR));
    } else {
        document.getElementById("refundIDR").value = 0;
    }
    if (refundUSD>creditNoteUSD) {
        document.getElementById("refundUSD").value = parseFloat(refundUSD-creditNoteUSD);
    } else {
        document.getElementById("refundUSD").value = 0;
    }       
}          
            
function countExpenses() {

    var dacountexpensesagentDebit = document.getElementById("dacountexpensesagentDebit").value;
    
    var i = 1;
    var billacchd = "expensesAgentChargeDebit";
    var kurs = "expensesAgentKursDebit";
    var tax = "expensesAgentTaxDebit";
    var vat = "expensesAgentVatDebit";
    
    var pas1 = "";
    var pas2 = "";
    
    
    var totalIDR = 0;
    var totalUSD = 0;              
    
    for (i=1; i<=dacountexpensesagentDebit+5; i++) {
                
        try {
            pas2 = kurs + i;
            pas2 = document.getElementById(pas2).value;

            pas1 = billacchd + i;
            pas1 = document.getElementById(pas1).value;     
            pas1 = pas1.toString().replace(/\$|\,/g,'');
            
            tax1 = document.getElementById(tax+i);  
            vat1 = document.getElementById(vat+i);  
            
            if (pas2=="IDR") {
                totalIDR+=parseFloat(pas1);                                        
            } else {
                totalUSD+=parseFloat(pas1);                                              
            }
                                    
        } catch (e) {
        }                                                                               
    }
                
    var dacountexpensesagentInvoice = document.getElementById("dacountexpensesagentInvoice").value;
    i = 1;
    billacchd = "expensesAgentChargeInvoice";
    kurs = "expensesAgentKursInvoice";
    
    tax = "expensesAgentTaxInvoice";
    vat = "expensesAgentVatInvoice";
    
    pas1 = "";
    pas2 = "";                
        
    
    for (i=1; i<=dacountexpensesagentInvoice+5; i++) {
        
        try {
            pas2 = kurs + i;
            pas2 = document.getElementById(pas2).value;

            pas1 = billacchd + i;
            pas1 = document.getElementById(pas1).value;     
            pas1 = pas1.toString().replace(/\$|\,/g,'');
            
            if (pas2=="IDR") {
                totalIDR+=parseFloat(pas1);       
            } else {
                totalUSD+=parseFloat(pas1);                                             
            }
        } catch (e) {
        }                                                                               
    }
    
    
    document.getElementById("totalCostUSDAsString").value = formatCurrency(totalUSD);
    document.getElementById("totalCostUSD").value = formatCurrency(totalUSD);
    
    document.getElementById("totalCostIDRAsString").value = formatCurrency(Math.round(totalIDR));
    document.getElementById("totalCostIDR").value = totalIDR;
    
   
    document.getElementById("totalExpensesIDRAsString").value = formatCurrency(totalIDR);
    document.getElementById("totalExpensesUSDAsString").value = formatCurrency(totalUSD);
    document.getElementById("totalExpensesIDR").value = totalIDR;
    document.getElementById("totalExpensesUSD").value = totalUSD;
    
        
}