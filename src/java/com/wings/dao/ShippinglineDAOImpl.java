package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.Shippingline;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.ShippinglineKey;
import java.util.List;

public class ShippinglineDAOImpl extends SqlMapDaoTemplate implements ShippinglineDAO {

    public ShippinglineDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Shippingline record) {
        insert("shippingLine_insert", record);
    }

    public int updateByPrimaryKey(Shippingline record) {
        int rows = update("shippingLine_updateByPrimaryKey", record);

        return rows;
    }

    
    public Shippingline selectByPrimaryKey(ShippinglineKey key) {
        Shippingline record = (Shippingline) queryForObject("shippingLine_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(ShippinglineKey key) {
        int rows = delete("shippingLine_deleteByPrimaryKey", key);

        return rows;
    }    

    public List getListOfShipping() {
        List records = (List) queryForList("shippingLine_selectByAll", null);
        return records;
    }

    public List getListOfShippingByName(Shippingline record) {
        List records = (List) queryForList("shippingLine_selectByLikeName", record);
        return records;
    }
}
