package com.wings.dao;

import com.ibatis.dao.client.DaoManager;

import com.wings.persistence.Jobtype;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.JobtypeKey;

public class JobtypeDAOImpl extends SqlMapDaoTemplate implements JobtypeDAO {

    
    public JobtypeDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Jobtype record) {
        insert("jobtype_insert", record);
    }
   
    public int updateByPrimaryKey(Jobtype record) {
        int rows = update("jobtype_updateByPrimaryKey", record);

        return rows;
    }
    
    public Jobtype selectByPrimaryKey(JobtypeKey key) {
        Jobtype record = (Jobtype) queryForObject("jobtype_selectByPrimaryKey", key);

        return record;
    }
    
    public int deleteByPrimaryKey(JobtypeKey key) {
        int rows = delete("jobtype_deleteByPrimaryKey", key);

        return rows;
    }
    
}
