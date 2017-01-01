package com.wings.dao;

import com.wings.persistence.IncomeKey;
import com.wings.persistence.Income;

public interface IncomeDAO {

   
    void insert(Income record);

   
    int updateByPrimaryKey(Income record);

      
    Income selectByPrimaryKey(IncomeKey key);

       
    int deleteByPrimaryKey(IncomeKey key);
    
    int deleteByRefId(Income record);
    
    IncomeKey selectLastId();
    
}
