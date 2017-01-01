package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Cashonhand;
import java.util.List;

public class CashonhandDAOImpl extends SqlMapDaoTemplate implements CashonhandDAO {

    public CashonhandDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public int deleteByPrimaryKey(Integer idCashOnHand) {
        Cashonhand key = new Cashonhand();
        key.setIdCashOnHand(idCashOnHand);
        int rows = delete("cashonhand_deleteByPrimaryKey", key);
        return rows;
    }

    public void insert(Cashonhand record) {
        insert("cashonhand_insert", record);
    }

    public Cashonhand selectByPrimaryKey(Integer idCashOnHand) {
        Cashonhand key = new Cashonhand();
        key.setIdCashOnHand(idCashOnHand);
        Cashonhand record = (Cashonhand) queryForObject("cashonhand_selectByPrimaryKey", key);
        return record;
    }

    public int updateByPrimaryKey(Cashonhand record) {
        int rows = update("cashonhand_updateByPrimaryKey", record);
        return rows;
    }    

    public List selectAll() {
        List records = (List) queryForList("cashonhand_selectByAll", null);
        return records;
    }
}