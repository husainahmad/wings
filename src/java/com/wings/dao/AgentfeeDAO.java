package com.wings.dao;


import com.wings.persistence.AgentfeeKey;
import java.util.List;
import com.wings.persistence.Agentfee;

public interface AgentfeeDAO {

   
    void insert(Agentfee record);

    
    int updateByPrimaryKey(Agentfee record);
     
    Agentfee selectByPrimaryKey(AgentfeeKey key);
    
    Agentfee selectByName(Agentfee agentfee);
   
    int deleteByPrimaryKey(AgentfeeKey key);
    
    List selectAll(Agentfee agentfee);
    
    List selectByAI(Agentfee agentfee);
    
    List selectByAO(Agentfee agentfee);
    
    List selectBySI(Agentfee agentfee);
    
    List selectBySO(Agentfee agentfee);
    
    List selectByType(Agentfee agentfee);
    
    
}
