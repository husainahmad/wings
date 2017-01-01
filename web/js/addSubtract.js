function kurangDep() {
	var dacountDep = document.frm.dacountDep.value;
	tempDep=document.getElementById("dasDep"+dacountDep);
	if (tempDep && (dacountDep>0)) {
	tempDep.innerHTML="";
	tempDep.outerHTML="";
	document.frm.dacountDep.value--;
	}
}	

function tambahDep() {
document.frm.dacountDep.value++;
var dacountDep = document.frm.dacountDep.value;
var danextDep = danextDep*1-1;
var daid1 = document.getElementById("daid1");
var row = 
"<span id=\"dasDep"+dacountDep+"\"> "+
"<table width=\"100%\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" >"+
((dacountDep>1)?"":"")+
"<tr>"+
"<td valign=\"top\" class=\"node1\" width=\"2%\">"+dacountDep+". </td>"+
"<td valign=\"top\" class=\"node1\" width=\"18%\">Kode dan Nama Departemen</td>"+
"<td valign=\"top\" class=\"node1\"  width=\"2%\">:</td>"+
"<td colspan=\"3\" class=\"node1\">"+
"<input type=\"text\" name=\"KodeDepartemen"+dacountDep+"\" class=\"ewTableAltRow\" size=\"10\">&nbsp;"+
"<input type=\"text\" name=\"NamaDepartemen"+dacountDep+"\" class=\"ewTableAltRow\" size=\"38\">&nbsp;"+
"<input style=\"cursor: hand;\" type=\"button\" value=\" ... \" class=\"tombol\" name=\"ButtonDepartemen\" onClick='window.open(\"ListDepartemen.php?index="+dacountDep+"\",null,\"height=500,width=550,status=yes,toolbar=no,scrollbars=yes,menubar=no,location=no,left=0, top=0,screenX=0,screenY=0\")'>"+
"</td>"+
"</tr>"+
"<tr>"+
"<td valign=\"top\" class=\"node1\">&nbsp;</td>"+
"<td valign=\"top\" class=\"node1\">Jumlah Alokasi Pinjaman</td>"+
"<td valign=\"top\" class=\"node1\">:</td>"+
"<td colspan=\"3\" class=\"node1\"><input type=\"text\" name=\"AlokasiDep"+dacountDep+"\" class=\"ewTableAltRow\" size=\"25\">"+
"</td>"+
"</tr>"+
"<tr>"+
"<td height=\"21\" colspan=\"6\"><hr width=\"100%\" color=\"#666666\"></td>"+
"</tr>"+
"</table></span>";
daid1.innerHTML=daid1.innerHTML+row;
}