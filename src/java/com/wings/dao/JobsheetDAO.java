package com.wings.dao;

import com.wings.persistence.Consignee;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DateSelection;
import java.util.List;
import com.wings.persistence.Jobsheet;
import com.wings.web.struts.forms.MonthYearForm;

public interface JobsheetDAO {
  
    JobsheetKey insert(Jobsheet record);
   
    int updateByPrimaryKey(Jobsheet record);

    int updateDebitNoAndStatusByPrimaryKey(Jobsheet record);
 
    int updateInvoiceNoAndStatusByPrimaryKey(Jobsheet record);
    
    int updateTaxVatByPrimaryKey(Jobsheet record);
    
    int updateStatusByPrimaryKey(Jobsheet record);
 
    List selectAll();
    
    //List selectByidJobType(MonthYearForm monthYearForm);

    List selectChart(MonthYearForm monthYearForm);
    
    List selectByidJobTypeAI(MonthYearForm monthYearForm);

    List selectByidJobTypeAO(MonthYearForm monthYearForm);

    List selectByidJobTypeSI(MonthYearForm monthYearForm);

    List selectByidJobTypeSO(MonthYearForm monthYearForm);

    List selectStatementOfAccountList(MonthYearForm monthYearForm);
    
    List selectStatementOfAccountListAll(MonthYearForm monthYearForm);
    
    List selectUnPaymentList(MonthYearForm monthYearForm);
    
    List selectUnPaymentStatementOfAccount(MonthYearForm monthYearForm);
    
    Jobsheet selectByPrimaryKey(JobsheetKey key);
    
    List selectByJobNo(Jobsheet jobsheet);
    
    Jobsheet selectMaxJobNo(Jobsheet jobsheet);
    
    List selectName(Consignee consignee);
    
    JobsheetKey selectLastInsertId();
    
    int deleteByPrimaryKey(JobsheetKey key);
    
    List selectStatementOfAccountByIdConsignee(DateSelection dateSelection);
    
    List selectStatementOfAccount(DateSelection dateSelection);
    
    List selectSummaryJobsheet(DateSelection dateSelection);
    
    List selectSummaryJobsheetCustomer(DateSelection dateSelection);
    
    List selectOutstandingCustomer(DateSelection dateSelection);
    
    List selectOutstanding(DateSelection dateSelection);
    
    List selectPayableCustomer(DateSelection dateSelection);
    
    List selectPayable(DateSelection dateSelection);
    
    List selectMonthlySales(DateSelection dateSelection);        
    
    List selectMonthlySalesInvoiceAI(DateSelection dateSelection);
    
    List selectMonthlySalesInvoiceAO(DateSelection dateSelection);
    
    List selectMonthlySalesInvoiceSI(DateSelection dateSelection);
    
    List selectMonthlySalesInvoiceSO(DateSelection dateSelection);
    
    List selectMonthlySalesDebit(DateSelection dateSelection);
    
    List selectMonthlySalesAICustomer(DateSelection dateSelection);
    
    List selectMonthlySalesAO(DateSelection dateSelection);
    
    List selectMonthlySalesAOCustomer(DateSelection dateSelection);
    
    List selectMonthlySalesSI(DateSelection dateSelection);
    
    List selectMonthlySalesSICustomer(DateSelection dateSelection);
    
    List selectMonthlySalesSO(DateSelection dateSelection);
    
    List selectMonthlySalesSOCustomer(DateSelection dateSelection);
    
    List selectSummaryTruckingCharge(DateSelection dateSelection);
    
    List selectSummaryTruckingChargeByTransporter(DateSelection dateSelection);
    
    List selectSummaryReportTaxMonthlyCustomer(DateSelection dateSelection);
    
    List selectSummaryReportTaxMonthly(DateSelection dateSelection);
    
    List selectReportJaminan(DateSelection dateSelection);
    
    List selectDetailJobsheet(JobsheetKey jobsheetKey);
    
    List selectDetailJobsheetByJobNo(Jobsheet jobsheet);
    
    List selectRefund(DateSelection dateSelection);
    
    List selectFakturPajakByJobType(DateSelection dateSelection);
}
