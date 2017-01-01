package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import java.util.Map;
import java.util.List;
import com.wings.persistence.PerkiraanExample;
import com.wings.persistence.Perkiraan;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.PerkiraanKey;
import java.util.HashMap;

public class PerkiraanDAOImpl extends SqlMapDaoTemplate implements PerkiraanDAO {

    
    public PerkiraanDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Perkiraan record) {
        insert("perkiraan_insert", record);
    }

    
    public int updateByPrimaryKey(Perkiraan record) {
        int rows = update("perkiraan_updateByPrimaryKey", record);

        return rows;
    }

    public Perkiraan selectByPrimaryKey(PerkiraanKey key) {
        Perkiraan record = (Perkiraan) queryForObject("perkiraan_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(PerkiraanKey key) {
        int rows = delete("perkiraan_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectByAll() {
        List records = (List) queryForList("perkiraan_selectByAll", null);

        return records;
    }
    
}
