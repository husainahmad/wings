package com.wings.dao;


import com.wings.persistence.ExpensesshipperKey;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Expensesshipper;
import com.wings.persistence.Jobsheet;

public interface ExpensesshipperDAO {
   
    void insert(Expensesshipper record);
    
    int updateByPrimaryKey(Expensesshipper record);
    
    Expensesshipper selectByPrimaryKey(ExpensesshipperKey key);
        
    List selectAll();
        
    List selectByJobSheetKey(JobsheetKey key);
        
    List selectByJobNo(Jobsheet jobsheet);    
    
    int deleteByPrimaryKey(ExpensesshipperKey key);    
    
    int deleteByJobsheetKey(JobsheetKey key);
    
    Double selectTotalIDRByIdJobSheet(JobsheetKey key);
    
    Double selectTotalUSDByIdJobSheet(JobsheetKey key);
    
}
