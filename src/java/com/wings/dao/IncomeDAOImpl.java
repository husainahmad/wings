package com.wings.dao;

import com.wings.persistence.IncomeKey;
import com.wings.persistence.Income;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class IncomeDAOImpl extends SqlMapDaoTemplate implements IncomeDAO {

    
    public IncomeDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Income record) {
        insert("income_insert", record);
    }

   
    public int updateByPrimaryKey(Income record) {
        int rows = update("income_updateByPrimaryKey", record);

        return rows;
    }
        
    public Income selectByPrimaryKey(IncomeKey key) {
        Income record = (Income) queryForObject("income_selectByPrimaryKey", key);

        return record;
    }
    
    public int deleteByPrimaryKey(IncomeKey key) {
        int rows = delete("income_deleteByPrimaryKey", key);

        return rows;
    }

    public IncomeKey selectLastId() {
        IncomeKey record = (IncomeKey) queryForObject("income_select_LAST_INSERT_ID", null);

        return record;
    }

    public int deleteByRefId(Income record) {
        int rows = delete("income_deleteByRefId", record);

        return rows;
    }
    
}
