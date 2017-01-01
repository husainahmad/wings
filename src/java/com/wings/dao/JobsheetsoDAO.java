package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Jobsheetso;
import com.wings.persistence.JobsheetsoKey;

public interface JobsheetsoDAO {

    
    void insert(Jobsheetso record);

   
    int updateByPrimaryKey(Jobsheetso record);

    
    List selectAll();

  
    Jobsheetso selectByPrimaryKey(JobsheetsoKey key);

    
    Jobsheetso selectByIdJobSheet(Jobsheetso jobsheetso);
    
    
    int deleteByPrimaryKey(JobsheetsoKey key);
    
    
    int deleteByIdJobSheet(JobsheetKey key);
     
}
