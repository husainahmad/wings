package com.wings.dao;

import com.wings.persistence.Billingshipper;
import com.wings.persistence.BillingshipperKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import java.util.List;

public interface BillingshipperDAO {
   
    void insert(Billingshipper record);
   
    int updateByPrimaryKey(Billingshipper record);
   
    Billingshipper selectByPrimaryKey(BillingshipperKey key);
    
    List selectAll();
    
    List selectByJobsheetKey(JobsheetKey key);
    
    List selectByJobsheetKeyIDR(JobsheetKey key);
    
    List selectByJobsheetKeyUSD(JobsheetKey key);
    
    List selectByJobNo(Jobsheet jobsheet);
    
    List selectTaxByJobsheetKey(JobsheetKey key);
    
    int deleteByPrimaryKey(BillingshipperKey key);

    int deleteByJobsheetKey(JobsheetKey key);
    
    Double selectTotalIDRByIdJobSheet(JobsheetKey key);
    
    Double selectTotalUSDByIdJobSheet(JobsheetKey key);
    
    
}
