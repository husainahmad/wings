package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.DestinationKey;
import java.util.List;
import com.wings.persistence.Destination;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class DestinationDAOImpl extends SqlMapDaoTemplate implements DestinationDAO {

    
    public DestinationDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Destination record) {
        insert("destination_insert", record);
    }

   
    public int updateByPrimaryKey(Destination record) {
        int rows = update("destination_updateByPrimaryKey", record);

        return rows;
    }

    
    public Destination selectByPrimaryKey(DestinationKey key) {
        Destination record = (Destination) queryForObject("destination_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(DestinationKey key) {
        int rows = delete("destination_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll(Destination destination) {
        List records = (List) queryForList("destination_selectAll", destination);

        return records;
    }

    public List selectByName(Destination record) {
        List records = (List) queryForList("destination_selectByName", record);

        return records;
    }
    
}
