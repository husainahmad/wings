package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import com.wings.persistence.Jobsheetai;
import com.wings.persistence.JobsheetaiKey;
import java.util.List;

public interface JobsheetaiDAO {
    
    void insert(Jobsheetai record);
   
    int updateByPrimaryKey(Jobsheetai record);
   
    List selectAll();
   
    Jobsheetai selectByPrimaryKey(JobsheetaiKey key);

    Jobsheetai selectByIdJobSheet(Jobsheetai jobsheetai);
    
    int deleteByPrimaryKey(JobsheetaiKey key);
    
    int deleteByIdJobSheet(JobsheetKey key);
     
    
}
