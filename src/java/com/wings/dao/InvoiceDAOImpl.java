package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Invoice;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.InvoiceKey;

public class InvoiceDAOImpl extends SqlMapDaoTemplate implements InvoiceDAO {

   
    public InvoiceDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Invoice record) {
        insert("invoice_insert", record);
    }

    
    public int updateByPrimaryKey(Invoice record) {
        int rows = update("invoice_updateByPrimaryKey", record);

        return rows;
    }

  
    public Invoice selectByPrimaryKey(InvoiceKey key) {
        Invoice record = (Invoice) queryForObject("invoice_selectByPrimaryKey", key);

        return record;
    }

    
    public int deleteByPrimaryKey(InvoiceKey key) {
        int rows = delete("invoice_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll(com.wings.web.struts.forms.MonthYearForm monthYearForm) {
        List records = (List) queryForList("invoice_selectByAll", monthYearForm);

        return records;
    }

    public String selectJobTypeByPrimaryKey(InvoiceKey key) {
        String record = (String) queryForObject("invoice_selectJobTypeByInvoiceKey", key);

        return record;
    }

    public InvoiceAIDetail selectJobAIDetailByPrimaryKey(InvoiceKey key) {
        InvoiceAIDetail record = (InvoiceAIDetail) queryForObject("invoice_selectAIByInvoiceKey", key);

        return record;
    }

    public InvoiceAODetail selectJobAODetailByPrimaryKey(InvoiceKey key) {
        InvoiceAODetail record = (InvoiceAODetail) queryForObject("invoice_selectAOByInvoiceKey", key);

        return record;
    }

    public InvoiceSIDetail selectJobSIDetailByPrimaryKey(InvoiceKey key) {
        InvoiceSIDetail record = (InvoiceSIDetail) queryForObject("invoice_selectSIByInvoiceKey", key);

        return record;
    }

    public InvoiceSODetail selectJobSODetailByPrimaryKey(InvoiceKey key) {
         InvoiceSODetail record = (InvoiceSODetail) queryForObject("invoice_selectSOByInvoiceKey", key);

        return record;
    }

    public int updatePayableByPrimaryKey(Invoice record) {
         int rows = update("invoice_updatePayableByPrimaryKey", record);

        return rows;
    }

    public Invoice selectByIdJobsheet(Invoice key) {
        Invoice record = (Invoice) queryForObject("invoice_selectByIdJobsheet", key);

        return record;
    }

    public int deleteByIdJobsheet(JobsheetKey key) {
        int rows = delete("invoice_deleteByIdJobSheet", key);

        return rows;
    }

    public Invoice selectMaxInvoiceNumber(Invoice invoice) {
        Invoice record = (Invoice) queryForObject("invoice_selectMaxInvoiceNumber", invoice);

        return record;
    }

    public Invoice selectMaxInvoiceNumberAI(Invoice invoice) {
        Invoice record = (Invoice) queryForObject("invoice_selectMaxInvoiceNumberAI", invoice);

        return record;
    }

    public Invoice selectMaxInvoiceNumberAO(Invoice invoice) {
        Invoice record = (Invoice) queryForObject("invoice_selectMaxInvoiceNumberAO", invoice);

        return record;
    }

    public Invoice selectMaxInvoiceNumberSI(Invoice invoice) {
        Invoice record = (Invoice) queryForObject("invoice_selectMaxInvoiceNumberSI", invoice);

        return record;
    }

    public Invoice selectMaxInvoiceNumberSO(Invoice invoice) {
        Invoice record = (Invoice) queryForObject("invoice_selectMaxInvoiceNumberSO", invoice);

        return record;
    }

    public List selectMaxInvoiceNumberAIList(Invoice invoice) {
        List records = (List) queryForList("invoice_selectMaxInvoiceNumberAIList", invoice);

        return records;
    }

    public List selectMaxInvoiceNumberAOList(Invoice invoice) {
        List records = (List) queryForList("invoice_selectMaxInvoiceNumberAOList", invoice);

        return records;
    }

    public List selectMaxInvoiceNumberSIList(Invoice invoice) {
        List records = (List) queryForList("invoice_selectMaxInvoiceNumberSIList", invoice);

        return records;
    }

    public List selectMaxInvoiceNumberSOList(Invoice invoice) {
        List records = (List) queryForList("invoice_selectMaxInvoiceNumberSOList", invoice);

        return records;
    }

    public int updatePayableByInvoiceNumber(Invoice record) {
        int rows = update("invoice_updatePayableByInvoiceNumber", record);

        return rows;
    }

    
}
