package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.JobsheetKey;
import com.wings.persistence.JobsheetsiKey;
import com.wings.persistence.Jobsheetsi;
import java.util.List;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class JobsheetsiDAOImpl extends SqlMapDaoTemplate implements JobsheetsiDAO {

  
    public JobsheetsiDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Jobsheetsi record) {
        insert("jobsheetsi_insert", record);
    }

   
    public int updateByPrimaryKey(Jobsheetsi record) {
        int rows = update("jobsheetsi_updateByPrimaryKey", record);

        return rows;
    }

   
    public Jobsheetsi selectByPrimaryKey(JobsheetsiKey key) {
        Jobsheetsi record = (Jobsheetsi) queryForObject("jobsheetsi_selectByPrimaryKey", key);

        return record;
    }

     
    public int deleteByPrimaryKey(JobsheetsiKey key) {
        int rows = delete("jobsheetsi_deleteByPrimaryKey", key);

        return rows;
    }    

    public List selectAll() {
        List records = (List) queryForList("jobsheetsi_selectAll", null);

        return records;
    }

    public Jobsheetsi selectByIdJobSheet(Jobsheetsi jobsheetsi) {
        Jobsheetsi record = (Jobsheetsi) queryForObject("jobsheetsi_selectByIdJobSheet", jobsheetsi);

        return record;
    }

    public int deleteByIdJobSheet(JobsheetKey key) {
        int rows = delete("jobsheetsi_deleteByIdJobSheet", key);

        return rows;
    }
    
}
