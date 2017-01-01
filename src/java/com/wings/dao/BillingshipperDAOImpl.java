package com.wings.dao;

import com.wings.persistence.Billingshipper;
import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.persistence.BillingshipperKey;
import java.util.List;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class BillingshipperDAOImpl extends SqlMapDaoTemplate implements BillingshipperDAO {
    
    public BillingshipperDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
  
    public void insert(Billingshipper record) {
        insert("billingshipper_insert", record);
    }
   
    public int updateByPrimaryKey(Billingshipper record) {
        int rows = update("billingshipper_updateByPrimaryKey", record);

        return rows;
    }
    
    public Billingshipper selectByPrimaryKey(BillingshipperKey key) {
        Billingshipper record = (Billingshipper) queryForObject("billingshipper_selectByPrimaryKey", key);

        return record;
    }  
    
    public int deleteByPrimaryKey(BillingshipperKey key) {
        int rows = delete("billingshipper_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
        List records = (List) queryForList("billingshipper_selectAll", null);

        return records;
    }

    public List selectByJobsheetKey(JobsheetKey key) {
        List records = (List) queryForList("billingshipper_selectJobsheetKey", key);

        return records;
    }

    public int deleteByJobsheetKey(JobsheetKey key) {
        int rows = delete("billingshipper_deleteByJobsheetKey", key);

        return rows;
    }

    public List selectTaxByJobsheetKey(JobsheetKey key) {
        List records = (List) queryForList("billingshipper_selectTaxJobsheetKey", key);

        return records;
    }

    public List selectByJobNo(Jobsheet jobsheet) {
        List records = (List) queryForList("billingshipper_selectByJobNo", jobsheet);

        return records;
    }

    public Double selectTotalIDRByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("billingshipper_selectTotalIDRByJobsheetKey", key);

        return record;
    }

    public Double selectTotalUSDByIdJobSheet(JobsheetKey key) {
        Double record = (Double) queryForObject("billingshipper_selectTotalUSDByJobsheetKey", key);

        return record;
    }

    public List selectByJobsheetKeyIDR(JobsheetKey key) {
        List records = (List) queryForList("billingshipper_selectByJobsheetKeyIDR", key);

        return records;
    }

    public List selectByJobsheetKeyUSD(JobsheetKey key) {
        List records = (List) queryForList("billingshipper_selectByJobsheetKeyUSD", key);

        return records;
    }

}
