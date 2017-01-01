package com.wings.dao;

import com.wings.persistence.Transactionacc;
import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.wings.persistence.TransactionaccKey;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.web.struts.forms.MonthYearForm;

public class TransactionaccDAOImpl extends SqlMapDaoTemplate implements TransactionaccDAO {

    public TransactionaccDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public int updateByPrimaryKey(Transactionacc record) {
        int rows = update("transactionacc_updateByPrimaryKey", record);

        return rows;
    }
   
    public Transactionacc selectByPrimaryKey(TransactionaccKey key) {
        Transactionacc record = (Transactionacc) queryForObject("transactionacc_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(TransactionaccKey key) {
        int rows = delete("transactionacc_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectByAll", monthYearForm);

        return records;
    }

    public int deleteByJobNo(Transactionacc key) {
        int rows = delete("transactionacc_deleteByJobNo", key);

        return rows;
    }

    public Integer selectNoUrut(Transactionacc record) {
        Integer row = (Integer) queryForObject("transactionacc_selectNoUrut", record);

        return row;
    }

    public Transactionacc selectTotalByDateAndBatchNo(MonthYearForm monthYearForm) {
        Transactionacc record = (Transactionacc) queryForObject("transactionacc_selectByTotal", monthYearForm);

        return record;
    }

    public List selectReportBB(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectReportBB", monthYearForm);

        return records;
    }

    public List selectReportGL(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectReportGL", monthYearForm);

        return records;
    }

    public List selectReportGLSaldo(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectReportGLSaldo", monthYearForm);

        return records;
    }

    public List selectReportRL(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectReportRL", monthYearForm);

        return records;
    }

    public List selectReportNL(MonthYearForm monthYearForm) {
        List records = (List) queryForList("transactionacc_selectReportNL", monthYearForm);

        return records;
    }

    public TransactionaccKey insert(Transactionacc record) {
        TransactionaccKey transactionaccKey = (TransactionaccKey) insert("transactionacc_insert", record);

        return transactionaccKey;
    }
}
