package com.wings.dao;

import com.wings.persistence.Expensesagent;
import com.wings.persistence.ExpensesagentKey;
import com.wings.persistence.Jobsheet;

import com.wings.persistence.JobsheetKey;
import java.util.List;

public interface ExpensesagentDAO {

   
    void insert(Expensesagent record);

    
    int updateByPrimaryKey(Expensesagent record);

   
    List selectAll();

   
    List selectByJobsheetKey(JobsheetKey key);

    List selectByJobNo(Jobsheet jobsheet);
  
    Expensesagent selectByPrimaryKey(ExpensesagentKey key);
   
    int deleteByPrimaryKey(ExpensesagentKey key);
    
    int deleteByJobsheetKey(JobsheetKey key);
    
    Double selectTotalIDRByIdJobSheet(JobsheetKey key);
    
    Double selectTotalUSDByIdJobSheet(JobsheetKey key);
    
}
