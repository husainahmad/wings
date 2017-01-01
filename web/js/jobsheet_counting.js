
            
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
    console.log(dacountbaDebit);
    var i = 1;
    var billacchd = "billingAgentChargeDebit";
    var kurs = "billingAgentKursDebit";
    
    var tax = "billingAgentTaxDebit";
    var vat = "billingAgentVatDebit";
    
    var pas1 = "";
    var pas2 = "";
    var tax1 = "";
    var vat1 = "";
    var totalIDR = 0;
    var totalUSD = 0;
    var totalDPPIDR = 0;
    var totalPPHIDR =0;
    
    var totalDPPUSD = 0;
    var totalPPHUSD =0;
    
    for (i=1; i<=dacountbaDebit+5; i++) {
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
                if (tax1.checked) {
                    console.log('checked');
                    totalDPPIDR += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalPPHIDR += parseFloat(pas1);
                } 
            } else {
                totalUSD+=parseFloat(pas1);    
                if (tax1.checked) {
                    console.log('checked');
                    totalDPPUSD += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalPPHUSD += parseFloat(pas1);
                } 
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
    
    pas1 = "";
    pas2 = "";                
                
    for (i=1; i<=dacountbaInvoice+5; i++) {
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
                if (tax1.checked) {
                    console.log('checked');
                    totalDPPIDR += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalPPHIDR += parseFloat(pas1);
                    
                } 
            } else {
                totalUSD+=parseFloat(pas1); 
                if (tax1.checked) {
                    console.log('checked');
                    totalDPPUSD += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalPPHUSD += parseFloat(pas1);                    
                } 
            }
        } catch (e) {
        }                                                                               
    }
    
    var vatIDR = totalDPPIDR * 0.10;
    var pph23IDR = totalPPHIDR * 0.02;
    
    var vatUSD = totalDPPUSD * 0.10;
    var pph23USD = totalPPHUSD * 0.02;
    
    document.getElementById("totalDPPUSDAsString").value = formatCurrency(totalDPPUSD + totalPPHUSD);
    document.getElementById("totalDPPIDRAsString").value = formatCurrency(totalDPPIDR + totalPPHIDR);
    
    document.getElementById("totalVatUSDAsString").value = formatCurrency(vatUSD);
    document.getElementById("totalVatIDRAsString").value = formatCurrency(vatIDR);
        
    document.getElementById("subTotalBillingUSDAsString").value = formatCurrency(totalUSD + vatUSD);    
    document.getElementById("subTotalBillingIDRAsString").value = formatCurrency(totalIDR + vatIDR);
    
    document.getElementById("totalPPHUSDAsString").value = formatCurrency(pph23USD);
    document.getElementById("totalPPHIDRAsString").value = formatCurrency(pph23IDR);
    
    document.getElementById("totalBillingUSDAsString").value = formatCurrency((totalUSD + vatUSD) - pph23USD);
    document.getElementById("totalBillingIDRAsString").value = formatCurrency((totalIDR + vatIDR) - pph23IDR);
    
    document.getElementById("totalBillingUSD").value = ((totalUSD + vatUSD) - pph23USD);
    document.getElementById("totalBillingIDR").value = ((totalIDR + vatIDR) - pph23IDR);
        
    
//    document.getElementById("totalBillingIDRAsString").value = formatCurrency(totalIDR - (totalTaxIDR+totalVatIDR));
//    document.getElementById("totalBillingUSDAsString").value = formatCurrency(totalUSD - (totalTaxUSD+totalVatUSD));
//                
//    document.getElementById("totalBillingIDR").value = totalIDR - (totalTaxIDR+totalVatIDR);
//    document.getElementById("totalBillingUSD").value = totalUSD - (totalTaxUSD+totalVatUSD);      
                
    var totalBillingIDR = document.getElementById("totalBillingIDR").value;
    var totalBillingUSD = document.getElementById("totalBillingUSD").value;

    var totalExpensesIDR = document.getElementById("totalExpensesIDR").value;
    var totalExpensesUSD = document.getElementById("totalExpensesUSD").value;
                 
    var refundUSD = 0;
    var refundIDR = 0;
                
    totalBillingIDR=parseFloat(totalBillingIDR); 
    totalExpensesIDR=parseFloat(totalExpensesIDR); 

    try {                        
        if (totalBillingIDR>totalExpensesIDR) {                       
            if (totalExpensesIDR>0)
                refundIDR = (totalBillingIDR-totalExpensesIDR) * 0.4;                        
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
                    refundUSD = (totalBillingUSD-totalExpensesUSD) * 0.4;
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
        document.getElementById("refundIDR").value = (refundIDR-creditNoteIDR);
    } else {
        document.getElementById("refundIDR").value = 0;
    }
    if (refundUSD>creditNoteUSD) {
        document.getElementById("refundUSD").value = (refundUSD-creditNoteUSD);
    } else {
        document.getElementById("refundUSD").value = 0;
    }       
}          
            
function countExpenses() {

    var dacountexpensesagentDebit = document.getElementById("dacountexpensesagentDebit").value;
    console.log(dacountexpensesagentDebit);
    var i = 1;
    var billacchd = "expensesAgentChargeDebit";
    var kurs = "expensesAgentKursDebit";
    var tax = "expensesAgentTaxDebit";
    var vat = "expensesAgentVatDebit";
    
    var pas1 = "";
    var pas2 = "";
    var tax1 = "";
    var vat1 = "";
    
    var totalIDR = 0;
    var totalUSD = 0;                                
    var totalTaxIDR = 0;
    var totalVatIDR =0;
    
    var totalTaxUSD = 0;
    var totalVatUSD =0;
    
    
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
                if (tax1.checked) {
                    console.log('checked');
                    totalTaxIDR += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalVatIDR += parseFloat(pas1);
                } 

            } else {
                totalUSD+=parseFloat(pas1);                                             
                if (tax1.checked) {
                    console.log('checked');
                    totalTaxUSD += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalVatUSD += parseFloat(pas1);
                } 
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
            
            tax1 = document.getElementById(tax+i);  
            vat1 = document.getElementById(vat+i); 
            
            if (pas2=="IDR") {
                totalIDR+=parseFloat(pas1);       
                if (tax1.checked) {
                    console.log('checked');
                    totalTaxIDR += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalVatIDR += parseFloat(pas1);
                    
                } 
            } else {
                totalUSD+=parseFloat(pas1);                                             
                if (tax1.checked) {
                    console.log('checked');
                    totalTaxUSD += parseFloat(pas1);
                } 

                if (vat1.checked) {
                    console.log('vat checked');
                    totalVatUSD += parseFloat(pas1);
                } 
            }
        } catch (e) {
        }                                                                               
    }
//   
//    totalTaxIDR = totalTaxIDR * 0.02;
//    totalVatIDR = totalVatIDR * 0.10;
//    
//    totalTaxUSD = totalTaxUSD * 0.02;
//    totalVatUSD = totalVatUSD * 0.10;
//    
//    document.getElementById("totalExTaxIDRAsString").value = formatCurrency(totalTaxIDR);
//    document.getElementById("totalExVatIDRAsString").value = formatCurrency(totalVatIDR);
//    
//    document.getElementById("totalExTaxUSDAsString").value = formatCurrency(totalTaxUSD);
//    document.getElementById("totalExVatUSDAsString").value = formatCurrency(totalVatUSD);
//    
//    document.getElementById("totalExpensesIDRAsString").value = formatCurrency(totalIDR - (totalTaxIDR + totalVatIDR));
//    document.getElementById("totalExpensesUSDAsString").value = formatCurrency(totalUSD - (totalTaxUSD + totalVatUSD));
//    document.getElementById("totalExpensesIDR").value = totalIDR - (totalTaxIDR + totalVatIDR);
//    document.getElementById("totalExpensesUSD").value = totalUSD - (totalTaxUSD + totalVatUSD);

    document.getElementById("totalExpensesIDRAsString").value = formatCurrency(totalIDR);
    document.getElementById("totalExpensesUSDAsString").value = formatCurrency(totalUSD);
    document.getElementById("totalExpensesIDR").value = totalIDR;
    document.getElementById("totalExpensesUSD").value = totalUSD;

    var totalBillingIDR = document.getElementById("totalBillingIDR").value;
    var totalBillingUSD = document.getElementById("totalBillingUSD").value;
                 
    var totalExpensesIDR = document.getElementById("totalExpensesIDR").value;
    var totalExpensesUSD = document.getElementById("totalExpensesUSD").value;
                 
    var refundUSD = 0;
    var refundIDR = 0;
                
    totalBillingIDR=parseFloat(totalBillingIDR); 
    totalExpensesIDR=parseFloat(totalExpensesIDR); 

    try {                        
        if (totalBillingIDR>totalExpensesIDR ) {                       
            refundIDR = (totalBillingIDR-totalExpensesIDR) * 0.4;
        }                       
    } catch (e) {
        refundIDR = 0;
    }           

    totalExpensesUSD=parseFloat(totalExpensesUSD); 
    totalBillingUSD=parseFloat(totalBillingUSD);          
         
    try {               
        if (totalBillingUSD>totalExpensesUSD) {
            if (totalExpensesUSD>0) {                           
                if (totalExpensesUSD>=51) {                              
                    refundUSD = (totalBillingUSD-totalExpensesUSD) * 0.4;
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
        document.getElementById("refundIDR").value = (refundIDR-creditNoteIDR);
    } else {
        document.getElementById("refundIDR").value = 0;
    }
    if (refundUSD>creditNoteUSD) {
        document.getElementById("refundUSD").value = (refundUSD-creditNoteUSD);
    } else {
        document.getElementById("refundUSD").value = 0;
    }      
}