package com.wings.dao;

import com.wings.persistence.Shippingline;
import com.wings.persistence.ShippinglineKey;
import java.util.List;

public interface ShippinglineDAO {

    void insert(Shippingline record);
    
    int updateByPrimaryKey(Shippingline record);

    Shippingline selectByPrimaryKey(ShippinglineKey key);

    int deleteByPrimaryKey(ShippinglineKey key);
    
    List getListOfShipping();

    List getListOfShippingByName(Shippingline record);
}
