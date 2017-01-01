package com.wings.dao;

import com.wings.persistence.BillingagentKey;
import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Billingagent;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Jobsheet;

public class BillingagentDAOImpl extends SqlMapDaoTemplate implements BillingagentDAO {

   
    public BillingagentDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

  
    public void insert(Billingagent record) {
        insert("billingagent_insert", record);
    }

   
    public int updateByPrimaryKey(Billingagent record) {
        int rows = update("billingagent_updateByPrimaryKey", record);

        return rows;
    }
   
 
    public Billingagent selectByPrimaryKey(BillingagentKey key) {
        Billingagent record = (Billingagent) queryForObject("billingagent_selectByPrimaryKey", key);

        return record;
    }
   
   
    public int deleteByPrimaryKey(BillingagentKey key) {
        int rows = delete("billingagent_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
        List records = (List) queryForList("billingagent_selectAll", null);

        return records;
    }

    public List selectByIdJobSheet(JobsheetKey key) {
        List records = (List) queryForList("billingagent_selectByJobsheetKey", key);

        return records;
    }

    public int deleteByJobsheetKey(JobsheetKey key) {
        int rows = delete("billingagent_deleteByJobsheetKey", key);

        return rows;
    }

    public List selectTaxByIdJobSheet(JobsheetKey key) {
        List records = (List) queryForList("billingagent_selectTaxByJobsheetKey", key);

        return records;
    }

    public List selectByIdJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("billingagent_selectByJobNo", jobsheet);

        return records;        
    }

    public Double selectTotalIDRByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("billingagent_selectTotalIDRByJobsheetKey", key);

        return record;
    }

    public Double selectTotalUSDByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("billingagent_selectTotalUSDByJobsheetKey", key);

        return record;
    }

    public List selectByIdJobSheetIDR(JobsheetKey key) {
        List records = (List) queryForList("billingagent_selectByJobsheetKeyIDR", key);

        return records;        
    }

    public List selectByIdJobSheetUSD(JobsheetKey key) {
        List records = (List) queryForList("billingagent_selectByJobsheetKeyUSD", key);

        return records;        
    }
    
}
