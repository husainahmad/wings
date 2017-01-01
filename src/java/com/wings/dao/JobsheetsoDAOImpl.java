package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.JobsheetKey;
import java.util.List;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Jobsheetso;
import com.wings.persistence.JobsheetsoKey;

public class JobsheetsoDAOImpl extends SqlMapDaoTemplate implements JobsheetsoDAO {

 
    public JobsheetsoDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Jobsheetso record) {
        insert("jobsheetso_insert", record);
    }

    
    public int updateByPrimaryKey(Jobsheetso record) {
        int rows = update("jobsheetso_updateByPrimaryKey", record);

        return rows;
    }
      
    
    public Jobsheetso selectByPrimaryKey(JobsheetsoKey key) {
        Jobsheetso record = (Jobsheetso) queryForObject("jobsheetso_selectByPrimaryKey", key);

        return record;
    }

    
    public int deleteByPrimaryKey(JobsheetsoKey key) {
        int rows = delete("jobsheetso_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
         List records = (List) queryForList("jobsheetso_selectByPrimaryKey", null);

        return records;
    }

    public Jobsheetso selectByIdJobSheet(Jobsheetso jobsheetso) {
        Jobsheetso record = (Jobsheetso) queryForObject("jobsheetso_selectByIdJobSheet", jobsheetso);

        return record;
    }

    public int deleteByIdJobSheet(JobsheetKey key) {
        int rows = delete("jobsheetso_deleteByIdJobSheet", key);

        return rows;
    }

    
}
