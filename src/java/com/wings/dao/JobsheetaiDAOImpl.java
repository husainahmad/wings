package com.wings.dao;

import com.wings.persistence.JobsheetKey;
import com.wings.persistence.Jobsheetai;
import com.wings.persistence.JobsheetaiKey;
import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class JobsheetaiDAOImpl extends SqlMapDaoTemplate implements JobsheetaiDAO {
    
    public JobsheetaiDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Jobsheetai record) {
        insert("jobsheetai_insert", record);
    }
   
    public int updateByPrimaryKey(Jobsheetai record) {
        int rows = update("jobsheetai_updateByPrimaryKey", record);

        return rows;
    }

    public Jobsheetai selectByPrimaryKey(JobsheetaiKey key) {
        Jobsheetai record = (Jobsheetai) queryForObject("jobsheetai_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(JobsheetaiKey key) {
        int rows = delete("jobsheetai_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
        List records = (List) queryForList("jobsheetai_selectAll", null);

        return records;
    }

    public Jobsheetai selectByIdJobSheet(Jobsheetai jobsheetai) {
        Jobsheetai record = (Jobsheetai) queryForObject("jobsheetai_selectByIdJobSheet", jobsheetai);

        return record;
    }

    public int deleteByIdJobSheet(JobsheetKey key) {
        int rows = delete("jobsheetai_deleteByIdJobSheet", key);

        return rows;
    }
}
