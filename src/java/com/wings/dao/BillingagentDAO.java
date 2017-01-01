package com.wings.dao;

import com.wings.persistence.BillingagentKey;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Billingagent;
import com.wings.persistence.Jobsheet;

public interface BillingagentDAO {
    
    void insert(Billingagent record);
    
    int updateByPrimaryKey(Billingagent record);
       
    Billingagent selectByPrimaryKey(BillingagentKey key);    
    
    List selectAll();
    
    List selectTaxByIdJobSheet(JobsheetKey key);
    
    List selectByIdJobSheet(JobsheetKey key);
    
    List selectByIdJobSheetIDR(JobsheetKey key);
    
    List selectByIdJobSheetUSD(JobsheetKey key);
    
    Double selectTotalIDRByIdJobSheet(JobsheetKey key);
    
    Double selectTotalUSDByIdJobSheet(JobsheetKey key);
    
    List selectByIdJobNo(Jobsheet jobsheet);
    
    int deleteByPrimaryKey(BillingagentKey key);
    
    int deleteByJobsheetKey(JobsheetKey key);
    
}
