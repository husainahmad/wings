package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.JobsheetaoKey;
import com.wings.persistence.Jobsheetao;

public class JobsheetaoDAOImpl extends SqlMapDaoTemplate implements JobsheetaoDAO {

    
    public JobsheetaoDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Jobsheetao record) {
        insert("jobsheetao_insert", record);
    }

   
    public int updateByPrimaryKey(Jobsheetao record) {
        int rows = update("jobsheetao_updateByPrimaryKey", record);

        return rows;
    }

       
    public Jobsheetao selectByPrimaryKey(JobsheetaoKey key) {
        Jobsheetao record = (Jobsheetao) queryForObject("jobsheetao_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(JobsheetaoKey key) {
        int rows = delete("jobsheetao_deleteByPrimaryKey", key);

        return rows;
    }

   
    public List selectAll() {
        List records = (List) queryForList("jobsheetao_selectAll", null);

        return records;
    }

    public Jobsheetao selectByIdJobSheet(Jobsheetao jobsheetao) {
        Jobsheetao record = (Jobsheetao) queryForObject("jobsheetao_selectByIdJobSheet", jobsheetao);

        return record;
    }

    public int deleteByIdJobSheet(JobsheetKey key) {
        int rows = delete("jobsheetao_deleteByIdJobSheet", key);

        return rows;
    }
}
