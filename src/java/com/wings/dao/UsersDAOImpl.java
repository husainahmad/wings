package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Users;
import com.wings.persistence.UsersKey;
import java.util.List;


public class UsersDAOImpl extends SqlMapDaoTemplate implements UsersDAO {

    
    public UsersDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Users record) {
        insert("users_insert", record);
    }

    
    public int updateByPrimaryKey(Users record) {
        int rows = update("users_updateByPrimaryKey", record);

        return rows;
    }
    
     public int updatePasswordByPrimaryKey(Users record) {
        int rows = update("users_updatePasswordByPrimaryKey", record);

        return rows;
        
    }

    public Users selectByPrimaryKey(UsersKey key) {
        Users record = (Users) queryForObject("users_selectByPrimaryKey", key);

        return record;
    }        
    

    
    public int deleteByPrimaryKey(UsersKey key) {
        int rows = delete("users_deleteByPrimaryKey", key);

        return rows;
    }

    public List getUsers() {
        List list = (List)queryForList("users_selectAll", null);
        return list;
    }

    public Users selectUserByUserIdAndPassword(Users user) {        
        Users record = (Users) queryForObject("users_selectByUserIdAndPassword", user);

        return record;
    }

   
        
}
