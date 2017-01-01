package com.wings.dao;

import com.wings.persistence.ShipperKey;
import java.util.List;

import com.wings.persistence.Shipper;

public interface ShipperDAO {

    
    void insert(Shipper record);

    
    int updateByPrimaryKey(Shipper record);

    
    List selectAll(Shipper shipper);
    
    List selectByName(Shipper record);
    
    Shipper selectByIdName(Shipper record);
    
    Shipper selectByPrimaryKey(ShipperKey key);

    
    int deleteByPrimaryKey(ShipperKey key);
}
