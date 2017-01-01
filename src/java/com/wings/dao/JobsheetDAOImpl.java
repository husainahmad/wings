package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import com.ibatis.dao.client.DaoManager;
import com.wings.web.struts.forms.DateSelection;
import java.util.List;
import com.wings.persistence.Jobsheet;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Consignee;
import com.wings.web.struts.forms.MonthYearForm;

public class JobsheetDAOImpl extends SqlMapDaoTemplate implements JobsheetDAO {

    
    public JobsheetDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public JobsheetKey insert(Jobsheet record) {
        
        JobsheetKey jobsheetKey = (JobsheetKey) insert("jobsheet_insert", record);
        return jobsheetKey;
    }

  
    public int updateByPrimaryKey(Jobsheet record) {
        int rows = update("jobsheet_updateByPrimaryKey", record);

        return rows;
    }
    
    public int updateTaxVatByPrimaryKey(Jobsheet record) {
        int rows = update("jobsheet_updateTaxVatByPrimaryKey", record);

        return rows;
    }
    
    public int updateStatusByPrimaryKey(Jobsheet record) {
        int rows = update("jobsheet_updateStatusByPrimaryKey", record);

        return rows;
    }

    public Jobsheet selectByPrimaryKey(JobsheetKey key) {
        Jobsheet record = (Jobsheet) queryForObject("jobsheet_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(JobsheetKey key) {
        int rows = delete("jobsheet_deleteByPrimaryKey", key);

        return rows;
    }

   
    public List selectAll() {
        List records = (List) queryForList("jobsheet_selectAll", null);

        return records;
    }

    public JobsheetKey selectLastInsertId() {
        JobsheetKey record = (JobsheetKey) queryForObject("jobsheet_select_LAST_INSERT_ID", null);

        return record;
    }

//    public List selectByidJobType(MonthYearForm monthYearForm) {
//        List records = (List) queryForList("jobsheet_selectByidJobType", monthYearForm);
//
//        return records;
//    }

    public List selectChart(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectChartByYear", monthYearForm);

        return records;
    }
    
    public List selectByidJobTypeAI(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectByidJobTypeAI", monthYearForm);

        return records;
    }

    public List selectByidJobTypeAO(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectByidJobTypeAO", monthYearForm);

        return records;
    }

    public List selectByidJobTypeSI(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectByidJobTypeSI", monthYearForm);

        return records;
    }

    public List selectByidJobTypeSO(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectByidJobTypeSO", monthYearForm);

        return records;
    }

    public List selectStatementOfAccountByIdConsignee(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportStatementOfAccountByIdConsignee", dateSelection);

        return records;
    }

    public List selectStatementOfAccount(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportStatementOfAccount", dateSelection);

        return records;
    }

    public List selectSummaryJobsheet(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportSummaryJobsheet", dateSelection);

        return records;
    }

    public List selectSummaryJobsheetCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportSummaryJobsheetCustomer", dateSelection);

        return records;
    }
    
    public List selectOutstandingCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportOutstandingCustomer", dateSelection);

        return records;
    }

    public List selectOutstanding(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportOutstanding", dateSelection);

        return records;
    }

    public List selectPayableCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportPayableCustomer", dateSelection);

        return records;
    }

    public List selectPayable(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportPayable", dateSelection);

        return records;
    }

    public List selectMonthlySales(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySales", dateSelection);

        return records;
    }

    public List selectMonthlySalesAICustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesAICustomer", dateSelection);

        return records;
    }
    
    public List selectMonthlySalesAO(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesAO", dateSelection);

        return records;
    }

    public List selectMonthlySalesAOCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesAOCustomer", dateSelection);

        return records;
    }

    public List selectMonthlySalesSI(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesSI", dateSelection);

        return records;
    }

    public List selectMonthlySalesSICustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesSICustomer", dateSelection);

        return records;
    }

    public List selectMonthlySalesSO(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesSO", dateSelection);

        return records;
    }

    public List selectMonthlySalesSOCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesSOCustomer", dateSelection);

        return records;
    }

    public List selectSummaryTruckingCharge(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportSummaryTrucking", dateSelection);

        return records;
    }

    public List selectSummaryTruckingChargeByTransporter(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportSummaryTruckingByTransporter", dateSelection);

        return records;
    }

    public List selectSummaryReportTaxMonthlyCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportTaxMonthlyCustomer", dateSelection);

        return records;
    }

    public List selectSummaryReportTaxMonthly(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportTaxMonthly", dateSelection);

        return records;
    }

    public Jobsheet selectMaxJobNo(Jobsheet jobsheet) {
        Jobsheet record = (Jobsheet) queryForObject("jobsheet_selectMaxJobNo", jobsheet);

        return record;
    }

    public List selectDetailJobsheet(JobsheetKey jobsheetKey) {
        List records = (List) queryForList("jobsheet_select_detail", jobsheetKey);

        return records;        
    }

    public int updateDebitNoAndStatusByPrimaryKey(Jobsheet record) {
        int rows = update("jobsheet_updateDebitNoAndStatusByPrimaryKey", record);

        return rows;
    }

    public int updateInvoiceNoAndStatusByPrimaryKey(Jobsheet record) {
        int rows = update("jobsheet_updateInvoiceNoAndStatusByPrimaryKey", record);

        return rows;
    }

    public List selectDetailJobsheetByJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("jobsheet_select_detail_by_jobno", jobsheet);

        return records;        
    }

    public List selectByJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("jobsheet_selectByJobNo", jobsheet);

        return records;        
    }

    public List selectName(Consignee consignee) {
        List records = (List) queryForList("jobsheet_select_Name", consignee);

        return records;        
    }

    public List selectMonthlySalesInvoiceAI(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesInvoiceAI", dateSelection);

        return records;
    }
    
    public List selectMonthlySalesInvoiceAO(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesInvoiceAO", dateSelection);

        return records;
    }
    
    public List selectMonthlySalesInvoiceSI(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesInvoiceSI", dateSelection);

        return records;
    }
     
    public List selectMonthlySalesInvoiceSO(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesInvoiceSO", dateSelection);

        return records;
    }
    
    public List selectMonthlySalesDebit(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportMonthlySalesDebit", dateSelection);

        return records;
    }

    public List selectStatementOfAccountList(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectReportStatementOfAccountList", monthYearForm);

        return records;
    }

    public List selectStatementOfAccountListAll(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectReportStatementOfAccountListAll", monthYearForm);

        return records;
    }

    public List selectUnPaymentStatementOfAccount(MonthYearForm monthYearForm) {
        List records = (List) queryForList("jobsheet_selectReportUnPaymentStatementOfAccount", monthYearForm);

        return records;
    }
    
    public List selectRefund(DateSelection dateSelection) {
        List records = (List) queryForList("jobsheet_selectReportRefund", dateSelection);

        return records;
    }
    
}
