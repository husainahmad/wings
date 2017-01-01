package com.wings.dao;

import java.util.List;
import com.wings.persistence.KursdollarKey;
import com.wings.persistence.Kursdollar;

public interface KursdollarDAO {

    void insert(Kursdollar record);

    int updateByPrimaryKey(Kursdollar record);

    List selectByAll();

    Kursdollar selectByLastKurs();

    Kursdollar selectByPrimaryKey(KursdollarKey key);
    
    int deleteByPrimaryKey(KursdollarKey key);
}
