package com.wings.dao;


import com.wings.persistence.JobnumberKey;

public interface JobnumberDAO {
   
    void insert(JobnumberKey record);
    JobnumberKey selectMax();
    String selectNext();
}
