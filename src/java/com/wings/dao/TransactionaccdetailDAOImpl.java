package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.TransactionaccKey;
import com.wings.persistence.Transactionaccdetail;
import java.util.List;

public class TransactionaccdetailDAOImpl extends SqlMapDaoTemplate implements TransactionaccdetailDAO {

    public TransactionaccdetailDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Transactionaccdetail record) {
        insert("transactionaccdetail_insert", record);
    }   

    public List selectByTransactionAccKey(TransactionaccKey key) {
        List records = (List) queryForList("transactionaccdetail_selectByTransactionAccKey", key);

        return records;
    }

    public Transactionaccdetail selectByPrimaryKey(Transactionaccdetail key) {
        Transactionaccdetail record = (Transactionaccdetail) queryForObject("transactionaccdetail_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(Transactionaccdetail key) {
        int rows = delete("transactionaccdetail_deleteByPrimaryKey", key);

        return rows;
    }

    public int deleteByJobNo(Transactionaccdetail key) {
        int rows = delete("transactionaccdetail_deleteByJobNo", key);

        return rows;
    }

    public int updateByPrimaryKey(Transactionaccdetail record) {
        int rows = update("transactionaccdetail_updateByPrimaryKey", record);

        return rows;
    }
}
