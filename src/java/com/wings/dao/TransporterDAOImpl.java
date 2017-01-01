package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import java.util.List;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.TransporterKey;
import com.wings.persistence.Transporter;

public class TransporterDAOImpl extends SqlMapDaoTemplate implements TransporterDAO {

    
    public TransporterDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Transporter record) {
        insert("transporter_insert", record);
    }

    
    public int updateByPrimaryKey(Transporter record) {
        int rows = update("transporter_updateByPrimaryKey", record);

        return rows;
    }

    public Transporter selectByPrimaryKey(TransporterKey key) {
        Transporter record = (Transporter) queryForObject("transporter_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(TransporterKey key) {
        int rows = delete("transporter_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll(Transporter transporter) {
        List records = (List) queryForList("transporter_selectAll", transporter);

        return records;
    }

    public List selectByName(Transporter record) {
        List records = (List) queryForList("transporter_selectByName", record);

        return records;
    }

}
