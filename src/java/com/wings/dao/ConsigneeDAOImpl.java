package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.wings.persistence.Consignee;
import com.wings.persistence.ConsigneeKey;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class ConsigneeDAOImpl extends SqlMapDaoTemplate implements ConsigneeDAO {

  
    public ConsigneeDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Consignee record) {
        insert("consignee_insert", record);
    }

    
    public int updateByPrimaryKey(Consignee record) {
        int rows = update("consignee_updateByPrimaryKey", record);

        return rows;
    }

    
    public Consignee selectByPrimaryKey(ConsigneeKey key) {
        Consignee record = (Consignee) queryForObject("consignee_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(ConsigneeKey key) {
        int rows = delete("consignee_deleteByPrimaryKey", key);

        return rows;
    }
   
    public List selectAll(Consignee record) {
        List records = (List) queryForList("consignee_selectAll", record);

        return records;
    }

    public List selectByConsigneeByName(Consignee key) {
        List records = (List) queryForList("consignee_selectByName", key);

        return records;
    }
    
}
