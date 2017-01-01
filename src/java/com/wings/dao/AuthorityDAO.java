package com.wings.dao;

import com.wings.persistence.Authority;
import com.wings.persistence.AuthorityKey;
import java.util.List;


public interface AuthorityDAO {
    
    void insert(Authority record);
    
    int updateByPrimaryKey(Authority record);
    
    List selectAll();
    
    Authority selectByPrimaryKey(AuthorityKey key);
       
    int deleteByPrimaryKey(AuthorityKey key);
}
