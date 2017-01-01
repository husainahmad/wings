package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import com.wings.persistence.JobsheetsiKey;
import com.wings.persistence.Jobsheetsi;
import java.util.List;

public interface JobsheetsiDAO {

   
    void insert(Jobsheetsi record);

   
    int updateByPrimaryKey(Jobsheetsi record);

   
    List selectAll();

   
    Jobsheetsi selectByPrimaryKey(JobsheetsiKey key);

    Jobsheetsi selectByIdJobSheet(Jobsheetsi jobsheetsi);
   
    int deleteByPrimaryKey(JobsheetsiKey key);
    
    int deleteByIdJobSheet(JobsheetKey key);
     
}
