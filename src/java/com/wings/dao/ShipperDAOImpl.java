package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.ShipperKey;
import java.util.List;

import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Shipper;

public class ShipperDAOImpl extends SqlMapDaoTemplate implements ShipperDAO {

    
    public ShipperDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Shipper record) {
        insert("shipper_insert", record);
    }

   
    public int updateByPrimaryKey(Shipper record) {
        int rows = update("shipper_updateByPrimaryKey", record);

        return rows;
    }

    
    public Shipper selectByPrimaryKey(ShipperKey key) {
        Shipper record = (Shipper) queryForObject("shipper_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(ShipperKey key) {
        int rows = delete("shipper_deleteByPrimaryKey", key);

        return rows;
    }
    
    public List selectAll(Shipper shipper) {
        List records = (List) queryForList("shipper_selectAll", shipper);

        return records;
    }

    public List selectByName(Shipper record) {
        List records = (List) queryForList("shipper_selectByName", record);

        return records;
    }

    public Shipper selectByIdName(Shipper record) {
        record = (Shipper) queryForObject("shipper_selectByIdName", record);

        return record;
    }
}
