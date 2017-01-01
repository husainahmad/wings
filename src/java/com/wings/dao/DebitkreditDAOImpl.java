package com.wings.dao;

import com.wings.persistence.Debitkredit;
import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.DebitkreditKey;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import java.util.List;

public class DebitkreditDAOImpl extends SqlMapDaoTemplate implements DebitkreditDAO {

    
    public DebitkreditDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Debitkredit record) {
        insert("debitkredit_insert", record);
    }

    
    public int updateByPrimaryKey(Debitkredit record) {
        int rows = update("debitkredit_updateByPrimaryKey", record);

        return rows;
    }

   
    public Debitkredit selectByPrimaryKey(DebitkreditKey key) {
        Debitkredit record = (Debitkredit) queryForObject("debitkredit_selectByPrimaryKey", key);

        return record;
    }

  
    public int deleteByPrimaryKey(DebitkreditKey key) {
        int rows = delete("debitkredit_deleteByPrimaryKey", key);

        return rows;
    }    

    public int deleteByIdDebit(Debitkredit debitkredit) {
        int rows = delete("debitkredit_deleteByIdDebit", debitkredit);
        return rows;        
    }

    public List selectByIdDebit(Debitkredit debitkredit) {
        List records = (List) queryForList("debitkredit_selectByIdDebit", debitkredit);

        return records;
    }
}
