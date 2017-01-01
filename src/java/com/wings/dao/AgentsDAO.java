package com.wings.dao;

import com.wings.persistence.AgentsKey;
import java.util.List;
import com.wings.persistence.Agents;

public interface AgentsDAO {
   
    void insert(Agents record);
   
    int updateByPrimaryKey(Agents record);   
    
    Agents selectByPrimaryKey(AgentsKey key);
        
    List selectAll(Agents agent);
    
    List selectByName(Agents record);
  
    int deleteByPrimaryKey(AgentsKey key);
}
