/* FORM POPUP */
function showPrintForm(setWidth,setHeight,windowName,URL){
    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }
    var leftPos = (w-setWidth)/2, topPos = ((h-setHeight)/2)-25;
    eval(windowName + " = window.open('"+ URL + "','" + windowName + "', 'toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=1,resizable=0,width="+ setWidth +",height="+ setHeight +",left = "+ leftPos +",top = "+topPos +"');");
}

function showForm(setWidth,setHeight,windowName,URL){

    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }
    var leftPos = (w-setWidth)/2, topPos = (h-setHeight)/2;
    setHeight += 50;
    eval(windowName + " = window.open('"+ URL + "','" + windowName + "', 'toolbar=0,scrollbars=0,location=0,statusbar=1,menubar=0,resizable=0,width="+ setWidth +",height="+ setHeight +",left = "+ leftPos +",top = "+topPos +"');");
}

function showFormMaxRight(setWidth,setHeight,windowName,URL){
    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }
    var leftPos = (w-setWidth)-50, topPos = 50;
    setHeight += 50;
    eval(windowName + " = window.open('"+ URL + "','" + windowName + "', 'toolbar=0,scrollbars=0,location=0,statusbar=1,menubar=0,resizable=0,width="+ setWidth +",height="+ setHeight +",left = "+ leftPos +",top = "+topPos +"');");
}

function showFormMaxLeft(setWidth,setHeight,windowName,URL){
    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }
    var leftPos = 0+50, topPos = 50;
    setHeight += 50;
    eval(windowName + " = window.open('"+ URL + "','" + windowName + "', 'toolbar=0,scrollbars=0,location=0,statusbar=1,menubar=0,resizable=0,width="+ setWidth +",height="+ setHeight +",left = "+ leftPos +",top = "+topPos +"');");
}

function showFormScroll(setWidth,setHeight,windowName,URL){
    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }
    var leftPos = (w-setWidth)/2, topPos = (h-setHeight)/2;
    setHeight += 50;
    eval(windowName + " = window.open('"+ URL + "','" + windowName + "', 'toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=1,resizable=0,width="+ setWidth +",height="+ setHeight +",left = "+ leftPos +",top = "+topPos +"');");
}
/* ============== */
/* END FORM POPUP */
/* ============== */

function windowOpen($linkUrl) {

    window.open($linkUrl,'_self');
}

function wpResizeTo(setWidth, setHeight) {
    if (document.all || document.layers) {
       w = screen.availWidth;
       h = screen.availHeight;
    }

    var leftPos = (w-setWidth)/2;
    var topPos  = (h-setHeight)/2;

    window.moveTo(leftPos, topPos);
    window.top.resizeTo(500, 500);
}

 
function formatCurrency(num) {
    num = num.toString().replace(/\$|\,/g,'');
    if(isNaN(num))
    num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num*100+0.50000000001);
    cents = num%100;
    num = Math.floor(num/100).toString();
    if(cents<10)
    cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
    num = num.substring(0,num.length-(4*i+3))+','+
    num.substring(num.length-(4*i+3));
    if (cents>0) {
        return (((sign)?'':'-') + '' + num + '.' + cents);
    } else {
        return (((sign)?'':'-') + '' + num);
    }
}
