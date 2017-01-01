package com.wings.dao;

import java.util.List;
import com.wings.persistence.PerkiraanExample;
import com.wings.persistence.Perkiraan;
import com.wings.persistence.PerkiraanKey;

public interface PerkiraanDAO {

    void insert(Perkiraan record);

    int updateByPrimaryKey(Perkiraan record);

    Perkiraan selectByPrimaryKey(PerkiraanKey key);

    int deleteByPrimaryKey(PerkiraanKey key);
    
    List selectByAll();
}
