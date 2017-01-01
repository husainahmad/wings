package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.UsersDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Users;
import com.wings.persistence.UsersKey;
import com.wings.web.struts.forms.UserForm;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;




public class StrutsUserDelegate {



   public static UserForm create (UserForm userForm) throws Exception {
      Users user = new Users();
      BeanUtils.copyProperties(user, userForm);
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                
      usersDAO.insert(user);
      return userForm;
   }


   public static UserForm update (UserForm userForm) throws Exception {
      Users user = new Users();
      BeanUtils.copyProperties(user, userForm);
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                
      usersDAO.updateByPrimaryKey(user);
      return userForm;
   }


   public static UserForm edit (UserForm userForm) throws Exception {
      UsersKey key = new UsersKey();   
      key.setUserId(userForm.getUserId());
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                
      Users user = usersDAO.selectByPrimaryKey(key);
      BeanUtils.copyProperties(userForm, user);
      return userForm;
   }

    public static Users findUserByUserId (UserForm userForm) throws Exception {
      UsersKey key = new UsersKey();   
      key.setUserId(userForm.getUserId());
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                
      Users user = usersDAO.selectByPrimaryKey(key);      
      return user;
   }
    
   public static Users findUserByUserIdAndPassword (Users user) throws Exception {      
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                      
      return usersDAO.selectUserByUserIdAndPassword(user);
   }
   
   public static void updatePassword (Users user) throws Exception {      
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                      
      usersDAO.updatePasswordByPrimaryKey(user);
   }
   
   public static void remove (UserForm userForm) throws Exception {
      UsersKey key = new UsersKey();   
      key.setUserId(userForm.getUserId());
      UsersDAO usersDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      usersDAO = (UsersDAO)daoMgr.getDao(UsersDAO.class);                
      usersDAO.deleteByPrimaryKey(key);
   }


   public static List findAll () throws Exception {
      UsersDAO userDao;
      DaoManager daoMgr = DaoConfig.getDaoManager();         
      userDao = (UsersDAO)daoMgr.getDao(UsersDAO.class);          
      return userDao.getUsers();      
   }


   public static List select (UserForm userForm) throws Exception {
      List retVals = new ArrayList();      
      return retVals;
   }

}
