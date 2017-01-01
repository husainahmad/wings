package com.wings.dao;

import com.wings.persistence.ShipperfeeKey;

import java.util.List;
import com.wings.persistence.Shipperfee;

public interface ShipperfeeDAO {
    
    void insert(Shipperfee record);
   
    int updateByPrimaryKey(Shipperfee record);
   
    List selectAll(Shipperfee record);    
    
    List selectByAI(Shipperfee record);    
    
    List selectByAO(Shipperfee record);    
    
    List selectBySI(Shipperfee record);    
    
    List selectBySO(Shipperfee record);    
    
    List selectByType(Shipperfee record);    
    
    Shipperfee selectByPrimaryKey(ShipperfeeKey key);
    
    Shipperfee selectByName(Shipperfee shipperfee);   
    
    int deleteByPrimaryKey(ShipperfeeKey key);
}
