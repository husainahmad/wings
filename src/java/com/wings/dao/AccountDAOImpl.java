package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.AccountKey;
import java.util.List;
import com.wings.persistence.Account;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class AccountDAOImpl extends SqlMapDaoTemplate implements AccountDAO {

    public AccountDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Account record) {
        insert("account_insert", record);
    }

    public int updateByPrimaryKey(Account record) {
        int rows = update("account_updateByPrimaryKey", record);

        return rows;
    }

    public Account selectByPrimaryKey(AccountKey key) {
        Account record = (Account) queryForObject("account_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(AccountKey key) {
        int rows = delete("account_deleteByPrimaryKey", key);

        return rows;
    }    

    public List selectByIdAccount(AccountKey key) {
        List records = (List) queryForList("account_selectByIdAccount", key);

        return records;
    }

    public List selectByAccountName(Account record) {
        List records = (List) queryForList("account_selectByAccountName", record);

        return records;
    }

    public List selectByAll(Account account) {
        List records = (List) queryForList("account_selectByAll", account);

        return records;
    }

    
}
