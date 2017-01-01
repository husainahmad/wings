package com.wings.dao;


import com.wings.persistence.Users;
import com.wings.persistence.UsersKey;
import java.util.List;

public interface UsersDAO {

    
    void insert(Users record);

    
    int updateByPrimaryKey(Users record);

    int updatePasswordByPrimaryKey(Users record);
    
    List getUsers();
        
    Users selectByPrimaryKey(UsersKey key);
    
    Users selectUserByUserIdAndPassword(Users user);
    
    int deleteByPrimaryKey(UsersKey key);
}
