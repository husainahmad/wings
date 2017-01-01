package com.wings.dao;

import com.wings.persistence.AccountKey;
import java.util.List;
import com.wings.persistence.Account;

public interface AccountDAO {

    void insert(Account record);

    int updateByPrimaryKey(Account record);

    List selectByAll(Account account);
    
    List selectByIdAccount(AccountKey key);
    
    List selectByAccountName(Account record);

    Account selectByPrimaryKey(AccountKey key);

    int deleteByPrimaryKey(AccountKey key);
}
