package com.wings.dao;

import com.wings.persistence.Debitkredit;
import com.wings.persistence.DebitkreditKey;
import java.util.List;
import com.wings.persistence.DebitkreditExample;

public interface DebitkreditDAO {
   
    void insert(Debitkredit record);
   
    int updateByPrimaryKey(Debitkredit record);
     
    Debitkredit selectByPrimaryKey(DebitkreditKey key);
    
    int deleteByPrimaryKey(DebitkreditKey key);

    int deleteByIdDebit(Debitkredit debitkredit);
    
    List selectByIdDebit(Debitkredit debitkredit);
    
}
