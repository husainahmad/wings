package com.wings.dao;

import com.wings.persistence.DestinationKey;
import java.util.List;

import com.wings.persistence.Destination;

public interface DestinationDAO {

    
    void insert(Destination record);

    
    int updateByPrimaryKey(Destination record);

        
    Destination selectByPrimaryKey(DestinationKey key);

        
    int deleteByPrimaryKey(DestinationKey key);
    
    List selectByAll(Destination destination);
    
    List selectByName(Destination record);
    
}
