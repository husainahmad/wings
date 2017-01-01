package com.wings.web.struts.actions;

import com.wings.adapter.StrutsAccountSaldoDelegate;
import com.wings.persistence.*;
import com.wings.reports.datasource.MonthlySalaryAIDataSource;
import com.wings.reports.datasource.StatementOfAccountDatasource;
import com.wings.reports.datasource.SummaryJobsheetDataSource;
import com.wings.reports.datasource.TransactionDataSource;
import com.wings.reports.datasource.TransactionaccGLDataSource;
import com.wings.web.struts.forms.DateSelection;
import com.wings.web.struts.forms.MonthYearForm;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintNLAction extends Action {       
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        try                        
        {
            List list = this.getListData(request);
            Object[][] dtReport = this.parseListToArray(list);
                                                
            JasperCompileManager.compileReportToFile(context.getRealPath("/accreports/NLReportNew.jrxml"));
            String reportFileName = context.getRealPath("/accreports/NLReportNew.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();            
            
            //parameters.put("ConsigneeName", request.getParameter("perConsignee"));        
            
            MonthYearForm monthYearForm = new MonthYearForm();
            RequestUtils.populate(monthYearForm, request);
            parameters.put("BaseDir", reportFile.getParentFile());                        
            parameters.put("tanggal2", "" + "31 Desember " + " - " + (monthYearForm.getYear().intValue()-1));               
            parameters.put("tanggal", "" + "31 Desember " + " - " + request.getParameter("year"));               
            
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new TransactionaccGLDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);            
            return mapping.findForward("view");      
            
        }
        catch (Exception e)
        {            
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }               
   }
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private List getListData(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, Exception {
       
        MonthYearForm monthYearForm = new MonthYearForm();
        RequestUtils.populate(monthYearForm, request);
        String sdate = "01" + "/" + StringUtils.leftPad(String.valueOf(monthYearForm.getMonth()), 2, "0") + "/" + monthYearForm.getYear();

        Date date = null;
        try {
            date = new java.sql.Date(FORMAT.parse(sdate).getTime());
        } catch (ParseException pe) {
            date = new java.sql.Date((new java.util.Date()).getTime());
        }

        monthYearForm.setDate(date);
        
        monthYearForm.setStrYearMonthDate(monthYearForm.getYear() + "-" + StringUtils.leftPad(String.valueOf(monthYearForm.getMonth()), 2, "0") + "-" + "01");
        
        monthYearForm.setIdAccount(monthYearForm.getIdAccount()+"%");
        // kas
        AccountSaldo saldoKas = StrutsAccountSaldoDelegate.selectByKas(monthYearForm);
        // bank
        AccountSaldo saldoBank = StrutsAccountSaldoDelegate.selectByBank(monthYearForm);
        
        // piutang
        AccountSaldo saldoPiutang = StrutsAccountSaldoDelegate.selectByPiutang(monthYearForm);        
        AccountSaldo saldoPiutangPihak = StrutsAccountSaldoDelegate.selectByPiutangPihak(monthYearForm);        
        
        // deposit
        AccountSaldo saldoDeposit = StrutsAccountSaldoDelegate.selectByDeposit(monthYearForm);        
        // pajak
        AccountSaldo saldoPajak = StrutsAccountSaldoDelegate.selectByPajak(monthYearForm);        
        // aktiva tidak lancar
        AccountSaldo saldoAktiva = StrutsAccountSaldoDelegate.selectByAktivaTidakLancar(monthYearForm);
        
        AccountSaldo saldoHutangLancar = StrutsAccountSaldoDelegate.selectByHutangLancar(monthYearForm);
        AccountSaldo saldoHutangLeasing = StrutsAccountSaldoDelegate.selectByHutangLeasing(monthYearForm);
        AccountSaldo saldoHutangPajak = StrutsAccountSaldoDelegate.selectByHutangPajak(monthYearForm);
        
        AccountSaldo saldoEkuitas = StrutsAccountSaldoDelegate.selectByEkuitas(monthYearForm);
        AccountSaldo saldoEkuitas2 = StrutsAccountSaldoDelegate.selectByEkuitas2(monthYearForm);
        AccountSaldo saldoEkuitas3 = StrutsAccountSaldoDelegate.selectByEkuitas3(monthYearForm);
        
        monthYearForm.setYear(new Integer(monthYearForm.getYear().intValue()-1));
        // kas
        AccountSaldo lastsaldoKas = StrutsAccountSaldoDelegate.selectByKas(monthYearForm);
        //bank
        AccountSaldo lastsaldoBank = StrutsAccountSaldoDelegate.selectByBank(monthYearForm);
        
        // piutang
        AccountSaldo lastsaldoPiutang = StrutsAccountSaldoDelegate.selectByPiutang(monthYearForm);        
        // piutang pihak
        AccountSaldo lastsaldoPiutangPihak = StrutsAccountSaldoDelegate.selectByPiutangPihak(monthYearForm);  
        // deposit
        AccountSaldo lastsaldoDeposit = StrutsAccountSaldoDelegate.selectByDeposit(monthYearForm);        
        // pajak
        AccountSaldo lastsaldoPajak = StrutsAccountSaldoDelegate.selectByPajak(monthYearForm);        
        // aktiva tidak lancar
        AccountSaldo lastsaldoAktiva = StrutsAccountSaldoDelegate.selectByAktivaTidakLancar(monthYearForm);
        AccountSaldo lastsaldoHutangLancar = StrutsAccountSaldoDelegate.selectByHutangLancar(monthYearForm);
        AccountSaldo lastsaldoHutangLeasing = StrutsAccountSaldoDelegate.selectByHutangLeasing(monthYearForm);
        AccountSaldo lastsaldoHutangPajak = StrutsAccountSaldoDelegate.selectByHutangPajak(monthYearForm);
        
        AccountSaldo lastsaldoEkuitas = StrutsAccountSaldoDelegate.selectByEkuitas(monthYearForm);
        AccountSaldo lastsaldoEkuitas2 = StrutsAccountSaldoDelegate.selectByEkuitas2(monthYearForm);
        AccountSaldo lastsaldoEkuitas3 = StrutsAccountSaldoDelegate.selectByEkuitas3(monthYearForm);
        
        List list = new ArrayList();  
        saldoKas.setType("AKTIVA");     
        saldoKas.setCategory("AKTIVA LANCAR");      
        saldoKas.setAccountName("Kas dan Setara Kas");        
        saldoKas.setSaldoAwal(lastsaldoKas.getSaldoAkhir());
        list.add(saldoKas);
        
        saldoBank.setType("AKTIVA");     
        saldoBank.setCategory("AKTIVA LANCAR");      
        saldoBank.setAccountName("Kas Bank");        
        saldoBank.setSaldoAwal(lastsaldoBank.getSaldoAkhir());
        list.add(saldoBank);
        
        saldoPiutang.setType("AKTIVA");     
        saldoPiutang.setCategory("AKTIVA LANCAR");
        saldoPiutang.setAccountName("Piutang Usaha");
        saldoPiutang.setSaldoAwal(lastsaldoPiutang.getSaldoAkhir());
        list.add(saldoPiutang);        
        
        saldoPiutangPihak.setType("AKTIVA");   
        saldoPiutangPihak.setCategory("AKTIVA LANCAR");
        saldoPiutangPihak.setAccountName("Biaya Dibayar Dimuka");
        saldoPiutangPihak.setSaldoAwal(lastsaldoPiutangPihak.getSaldoAkhir());
        list.add(saldoPiutangPihak);
        
        saldoDeposit.setType("AKTIVA"); 
        saldoDeposit.setCategory("AKTIVA LANCAR");
        saldoDeposit.setAccountName("Piutang Pihak Hubungan Istimewa");
        saldoDeposit.setSaldoAwal(lastsaldoDeposit.getSaldoAkhir());
        list.add(saldoDeposit);
        
        saldoPajak.setType("AKTIVA"); 
        saldoPajak.setCategory("AKTIVA LANCAR");        
        saldoPajak.setAccountName("Pajak Dibayar Dimuka");
        saldoPajak.setSaldoAwal(lastsaldoDeposit.getSaldoAkhir());
        list.add(saldoPajak);
        
        saldoAktiva.setType("AKTIVA"); 
        saldoAktiva.setCategory("AKTIVA TIDAK LANCAR");   
        saldoAktiva.setAccountName("Aktiva tidak lancar");
        saldoAktiva.setSaldoAwal(lastsaldoAktiva.getSaldoAkhir());
        list.add(saldoAktiva);
        
        saldoHutangLancar.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoHutangLancar.setCategory("KEWAJIBAN LANCAR");   
        saldoHutangLancar.setAccountName("Hutang Usaha");   
        saldoHutangLancar.setSaldoAwal(lastsaldoHutangLancar.getSaldoAkhir());
        list.add(saldoHutangLancar);
        
        saldoHutangLeasing.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoHutangLeasing.setCategory("KEWAJIBAN LANCAR");   
        saldoHutangLeasing.setAccountName("Hutang Leasing");   
        saldoHutangLeasing.setSaldoAwal(lastsaldoHutangLeasing.getSaldoAkhir());
        list.add(saldoHutangLeasing);
        
        saldoHutangPajak.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoHutangPajak.setCategory("KEWAJIBAN LANCAR");   
        saldoHutangPajak.setAccountName("Hutang Pajak");
        saldoHutangPajak.setSaldoAwal(lastsaldoHutangPajak.getSaldoAkhir());
        list.add(saldoHutangPajak);
        
        saldoEkuitas.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoEkuitas.setCategory("EKUITAS");   
        saldoEkuitas.setAccountName("Modal Saham");
        saldoEkuitas.setSaldoAwal(lastsaldoEkuitas.getSaldoAkhir());
        list.add(saldoEkuitas);
        
        saldoEkuitas2.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoEkuitas2.setCategory("EKUITAS");
        saldoEkuitas2.setAccountName("Laba ditahan");
        saldoEkuitas2.setSaldoAwal(lastsaldoEkuitas2.getSaldoAkhir());
        list.add(saldoEkuitas2);
        
        saldoEkuitas3.setType("KEWAJIBAN DAN EKUITAS"); 
        saldoEkuitas3.setCategory("EKUITAS");
        saldoEkuitas3.setAccountName("Laba (Rugi) Tahun Berjalan");
        saldoEkuitas3.setSaldoAwal(lastsaldoEkuitas3.getSaldoAkhir());
        list.add(saldoEkuitas3);
        
        return list;
        
   }
    
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][19];  
        AccountSaldo cccountSaldo = null;     
        Double tax = null;
        Double totalExpensesIDR = null;
                
        try {
            
            for (int i = 0; i < list.size(); i++) {                                
               cccountSaldo = (AccountSaldo)list.get(i);               
               valueOfTable[i][0] = cccountSaldo.getAccountName();
               valueOfTable[i][1] = cccountSaldo.getSaldoAwal();
               valueOfTable[i][2] = cccountSaldo.getSaldoAkhir();
               valueOfTable[i][3] = cccountSaldo.getCategory();
               valueOfTable[i][4] = cccountSaldo.getType();
               
            }
        } catch (Exception e) {
           System.out.println(e);
        }
        
        return valueOfTable;  
        
    }  
}
