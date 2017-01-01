package com.wings.dao;

import com.wings.persistence.ShipperfeeKey;
import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.wings.persistence.Shipperfee;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class ShipperfeeDAOImpl extends SqlMapDaoTemplate implements ShipperfeeDAO {

    
    public ShipperfeeDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Shipperfee record) {
        insert("shipperfee_insert", record);
    }
   
    public int updateByPrimaryKey(Shipperfee record) {
        int rows = update("shipperfee_updateByPrimaryKey", record);

        return rows;
    }
    
    public Shipperfee selectByPrimaryKey(ShipperfeeKey key) {
        Shipperfee record = (Shipperfee) queryForObject("shipperfee_selectByPrimaryKey", key);

        return record;
    }
       
    public int deleteByPrimaryKey(ShipperfeeKey key) {
        int rows = delete("shipperfee_deleteByPrimaryKey", key);

        return rows;
    }
    
    public List selectAll(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectAll", record);

        return records;
    }

    public Shipperfee selectByName(Shipperfee shipperfee) {
        Shipperfee record = (Shipperfee) queryForObject("shipperfee_selectByName", shipperfee);

        return record;
    }

    public List selectByAI(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectByAI", record);

        return records;
    }

    public List selectByAO(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectByAO", record);

        return records;
    }

    public List selectBySI(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectBySI", record);

        return records;
    }

    public List selectBySO(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectBySO", record);

        return records;
    }

    public List selectByType(Shipperfee record) {
        List records = (List) queryForList("shipperfee_selectByType", record);
        return records;                
    }
    
}
