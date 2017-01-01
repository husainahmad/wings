package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.JobsheetaoKey;
import com.wings.persistence.Jobsheetao;

public interface JobsheetaoDAO {

  
    void insert(Jobsheetao record);

    
    int updateByPrimaryKey(Jobsheetao record);

   
    List selectAll();

      
    Jobsheetao selectByPrimaryKey(JobsheetaoKey key);

   
    Jobsheetao selectByIdJobSheet(Jobsheetao jobsheetao);
    
    
    int deleteByPrimaryKey(JobsheetaoKey key);

    int deleteByIdJobSheet(JobsheetKey key);     
    
}
