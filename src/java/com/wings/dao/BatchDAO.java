package com.wings.dao;

import java.util.List;
import com.wings.persistence.BatchKey;
import com.wings.persistence.Batch;

public interface BatchDAO {

    void insert(Batch record);

    int updateByPrimaryKey(Batch record);

    Batch selectByPrimaryKey(BatchKey key);

    int deleteByPrimaryKey(BatchKey key);
    
    List selectByAll();
    
    List selectByName(BatchKey key);
}
