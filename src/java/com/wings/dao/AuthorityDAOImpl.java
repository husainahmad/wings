package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Authority;
import com.wings.persistence.AuthorityKey;
import java.util.List;



public class AuthorityDAOImpl extends SqlMapDaoTemplate implements AuthorityDAO {

    
    public AuthorityDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Authority record) {
        insert("authority_insert", record);
    }

    
    public int updateByPrimaryKey(Authority record) {
        int rows = update("authority_updateByPrimaryKey", record);

        return rows;
    }

    
    public Authority selectByPrimaryKey(AuthorityKey key) {
        Authority record = (Authority) queryForObject("authority_selectByPrimaryKey", key);

        return record;
    }


    public int deleteByPrimaryKey(AuthorityKey key) {
        int rows = delete("authority_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll() {
        List list = (List) queryForList("authority_selectAll", null);

        return list;
    }

}
