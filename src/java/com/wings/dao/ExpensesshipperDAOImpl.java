package com.wings.dao;


import com.wings.persistence.ExpensesshipperKey;
import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Expensesshipper;

public class ExpensesshipperDAOImpl extends SqlMapDaoTemplate implements ExpensesshipperDAO {

    
    public ExpensesshipperDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Expensesshipper record) {
        insert("expensesshipper_insert", record);
    }

    
    public int updateByPrimaryKey(Expensesshipper record) {
        int rows = update("expensesshipper_updateByPrimaryKey", record);

        return rows;
    }

    
   
    public Expensesshipper selectByPrimaryKey(ExpensesshipperKey key) {
        Expensesshipper record = (Expensesshipper) queryForObject("expensesshipper_selectByPrimaryKey", key);

        return record;
    }
    
    public int deleteByPrimaryKey(ExpensesshipperKey key) {
        int rows = delete("expensesshipper_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
        List records = (List) queryForList("expensesshipper_selectAll", null);

        return records;
    }

    public List selectByJobSheetKey(JobsheetKey key) {
        List records = (List) queryForList("expensesshipper_selectByJobSheetKey", key);

        return records;
    }

    public int deleteByJobsheetKey(JobsheetKey key) {
        int rows = delete("expensesshipper_deleteByJobsheetKey", key);

        return rows;
    }

    public List selectByJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("expensesshipper_selectByJobNo", jobsheet);

        return records;
    }

    public Double selectTotalIDRByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("expensesshipper_selectTotalIDRByJobSheetKey", key);

        return record;
    }

    public Double selectTotalUSDByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("expensesshipper_selectTotalUSDByJobSheetKey", key);

        return record;
    }
    
}
