package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import java.util.List;
import com.wings.persistence.KursdollarKey;
import com.wings.persistence.Kursdollar;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class KursdollarDAOImpl extends SqlMapDaoTemplate implements KursdollarDAO {

    public KursdollarDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Kursdollar record) {
        insert("kursdollar_insert", record);
    }

    public int updateByPrimaryKey(Kursdollar record) {
        int rows = update("kursdollar_updateByPrimaryKey", record);

        return rows;
    }

    public Kursdollar selectByPrimaryKey(KursdollarKey key) {
        Kursdollar record = (Kursdollar) queryForObject("kursdollar_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(KursdollarKey key) {
        int rows = delete("kursdollar_deleteByPrimaryKey", key);

        return rows;
    }

    
    public List selectByAll() {
        List records = (List) queryForList("kursdollar_selectByAll", null);

        return records;
    }
    
    public Kursdollar selectByLastKurs() {
        Kursdollar record = (Kursdollar) queryForObject("kursdollar_selectByLastKurs", null);

        return record;
    }
}
