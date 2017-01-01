package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.BatchKey;
import com.wings.persistence.Batch;

public class BatchDAOImpl extends SqlMapDaoTemplate implements BatchDAO {
    
    public BatchDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Batch record) {
        insert("batch_insert", record);
    }
    
    public int updateByPrimaryKey(Batch record) {
        int rows = update("batch_updateByPrimaryKey", record);

        return rows;
    }

    public Batch selectByPrimaryKey(BatchKey key) {
        Batch record = (Batch) queryForObject("batch_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(BatchKey key) {
        int rows = delete("batch_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll() {
        List records = (List) queryForList("batch_selectByAll", null);

        return records;
    }

    public List selectByName(BatchKey key) {
        List records = (List) queryForList("batch_selectByName", key);

        return records;
    }
    
}
