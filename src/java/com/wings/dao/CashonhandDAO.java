package com.wings.dao;

import com.wings.persistence.Cashonhand;
import java.util.List;

public interface CashonhandDAO {
    
    int deleteByPrimaryKey(Integer idCashOnHand);

    void insert(Cashonhand record);

    Cashonhand selectByPrimaryKey(Integer idCashOnHand);

    int updateByPrimaryKey(Cashonhand record);
    
    List selectAll();
}