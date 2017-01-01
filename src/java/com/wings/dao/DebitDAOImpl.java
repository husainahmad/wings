package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.DebitKey;
import com.wings.persistence.Debit;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class DebitDAOImpl extends SqlMapDaoTemplate implements DebitDAO {

    
    public DebitDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Debit record) {
        insert("debit_insert", record);
    }

    
    public int updateByPrimaryKey(Debit record) {
        int rows = update("debit_updateByPrimaryKey", record);

        return rows;
    }

   
    public Debit selectByPrimaryKey(DebitKey key) {
        Debit record = (Debit) queryForObject("debit_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(DebitKey key) {
        int rows = delete("debit_deleteByPrimaryKey", key);

        return rows;
    }
    
    public int deleteByIdJobsheet(JobsheetKey key) {
        int rows = delete("debit_deleteByIdJobSheet", key);

        return rows;
    }
    

    public List selectByAll(com.wings.web.struts.forms.MonthYearForm monthYearForm) {
        List records = (List) queryForList("debit_selectByAll", monthYearForm);

        return records;
    }

    public DebitAIDetail selectJobAIDetailByPrimaryKey(DebitKey key) {
        DebitAIDetail record = (DebitAIDetail) queryForObject("debit_selectAIByDebitKey", key);

        return record;
    }

    public DebitAODetail selectJobAODetailByPrimaryKey(DebitKey key) {
        DebitAODetail record = (DebitAODetail) queryForObject("debit_selectAOByDebitKey", key);

        return record;
    }

    public DebitSIDetail selectJobSIDetailByPrimaryKey(DebitKey key) {
        DebitSIDetail record = (DebitSIDetail) queryForObject("debit_selectSIByDebitKey", key);

        return record;
    }

    public DebitSODetail selectJobSODetailByPrimaryKey(DebitKey key) {
        DebitSODetail record = (DebitSODetail) queryForObject("debit_selectSOByDebitKey", key);

        return record;
    }

    public String selectJobTypeByPrimaryKey(DebitKey key) {
        String record = (String) queryForObject("debit_selectJobTypeByDebitKey", key);

        return record;
    }

    public int updatePayableByPrimaryKey(Debit record) {
        int rows = update("debit_updatePayableByPrimaryKey", record);

        return rows;
    }

    public Debit selectByIdJobsheet(Debit debit) {
        Debit record = (Debit) queryForObject("debit_selectByIdJobsheet", debit);

        return record;
    }

    public Debit selectByMaxDebitNumber(Debit debit) {
        Debit record = (Debit) queryForObject("debit_selectMaxDebitNo", debit);

        return record;
    }

    public int updatePayableByDebitNumber(Debit record) {
        int rows = update("debit_updatePayableByDebitNumber", record);

        return rows;
    }
    
}
