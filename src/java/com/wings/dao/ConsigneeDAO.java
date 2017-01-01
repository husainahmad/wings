package com.wings.dao;

import java.util.List;
import com.wings.persistence.Consignee;
import com.wings.persistence.ConsigneeKey;

public interface ConsigneeDAO {

   
    void insert(Consignee record);

    int updateByPrimaryKey(Consignee record);

    
    List selectAll(Consignee record);
  
    Consignee selectByPrimaryKey(ConsigneeKey key);
    
    List selectByConsigneeByName(Consignee key);
     
    int deleteByPrimaryKey(ConsigneeKey key);
}
