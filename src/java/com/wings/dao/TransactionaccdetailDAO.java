package com.wings.dao;

import com.wings.persistence.TransactionaccKey;
import com.wings.persistence.Transactionaccdetail;
import java.util.List;

public interface TransactionaccdetailDAO {

    List selectByTransactionAccKey(TransactionaccKey key);
        
    Transactionaccdetail selectByPrimaryKey(Transactionaccdetail key);  
    
    int deleteByPrimaryKey(Transactionaccdetail key);
    
    int deleteByJobNo(Transactionaccdetail key);
    
    void insert(Transactionaccdetail record);

    int updateByPrimaryKey(Transactionaccdetail record);
    
}
