package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.JobnumberKey;

public class JobnumberDAOImpl extends SqlMapDaoTemplate implements JobnumberDAO {

   
    public JobnumberDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(JobnumberKey record) {
        insert("jobnumber_insert", record);
    }

    public JobnumberKey selectMax() {
        JobnumberKey record = (JobnumberKey) queryForObject("jobnumber_selectMax", null);

        return record;
    }

    public String selectNext() {
        String record = (String) queryForObject("jobnumber_selectNext", null);

        return record;
    }

        
}
