package com.wings.dao;

import com.wings.persistence.Expensesagent;
import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.ExpensesagentKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class ExpensesagentDAOImpl extends SqlMapDaoTemplate implements ExpensesagentDAO {

  
    public ExpensesagentDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Expensesagent record) {
        insert("expensesagent_insert", record);
    }

   
    public int updateByPrimaryKey(Expensesagent record) {
        int rows = update("expensesagent_updateByPrimaryKey", record);

        return rows;
    }


    public Expensesagent selectByPrimaryKey(ExpensesagentKey key) {
        Expensesagent record = (Expensesagent) queryForObject("expensesagent_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(ExpensesagentKey key) {
        int rows = delete("expensesagent_deleteByPrimaryKey", key);

        return rows;
    }

   
    public List selectAll() {
        List records = (List) queryForList("expensesagent_selectAll", null);

        return records;
    }

    public List selectByJobsheetKey(JobsheetKey key) {
        List records = (List) queryForList("expensesagent_selectByJobsheetKey", key);

        return records;
    }

    public int deleteByJobsheetKey(JobsheetKey key) {
        int rows = delete("expensesagent_deleteByJobsheetKey", key);

        return rows;
    }

    public List selectByJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("expensesagent_selectByJobNo", jobsheet);

        return records;
    }

    public Double selectTotalIDRByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("expensesagent_selectTotalIDRByJobsheetKey", key);

        return record;
    }

    public Double selectTotalUSDByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("expensesagent_selectTotalUSDByJobsheetKey", key);

        return record;
    }
}
