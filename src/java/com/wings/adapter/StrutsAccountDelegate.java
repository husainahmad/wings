



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.AccountDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Account;
import com.wings.persistence.AccountKey;
import com.wings.web.struts.forms.AccountForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsAccountDelegate {


   public static com.wings.web.struts.forms.AccountForm create (com.wings.web.struts.forms.AccountForm accountForm) throws Exception {
      Account account = new Account();  
      BeanUtils.copyProperties(account, accountForm);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      accountDAO.insert(account);
      return accountForm;
   }

   public static com.wings.web.struts.forms.AccountForm update (com.wings.web.struts.forms.AccountForm accountForm) throws Exception {
      Account account = new Account();  
      BeanUtils.copyProperties(account, accountForm);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      accountDAO.updateByPrimaryKey(account);
      return accountForm;
   }

   public static com.wings.web.struts.forms.AccountForm edit (com.wings.web.struts.forms.AccountForm accountForm) throws Exception {
      AccountKey accountKey = new AccountKey();  
      BeanUtils.copyProperties(accountKey, accountForm);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      Account account = accountDAO.selectByPrimaryKey(accountKey);
      BeanUtils.copyProperties(accountForm, account);
      return accountForm;
   }

   public static void remove (com.wings.web.struts.forms.AccountForm accountForm) throws Exception {
      AccountKey accountKey = new AccountKey();  
      BeanUtils.copyProperties(accountKey, accountForm);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      accountDAO.deleteByPrimaryKey(accountKey);      
   }

   public static List findAll (AccountForm accountForm) throws Exception {
      List retVals = new ArrayList();
      Account account = new Account();
      if (accountForm!=null) {
          if (accountForm.getAccountName()!=null) {
              account.setAccountName(accountForm.getAccountName()+"%");
          } else {
              account.setAccountName("%");
          }
      } else {
          account.setAccountName("%");
      }
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      retVals = accountDAO.selectByAll(account);            
      return retVals;
   }

   public static List findIdAccount (String name) throws Exception {
      List retVals = new ArrayList();
      AccountKey accountKey = new AccountKey();  
      accountKey.setIdAccount(name);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      retVals = accountDAO.selectByIdAccount(accountKey);            
      return retVals;
   }

   public static List findAccountName (String name) throws Exception {
      List retVals = new ArrayList();
      Account account = new Account();  
      account.setAccountName(name);
      AccountDAO accountDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountDAO = (AccountDAO)daoMgr.getDao(AccountDAO.class);      
      retVals = accountDAO.selectByAccountName(account);            
      return retVals;
   }

   public static List select (com.wings.web.struts.forms.AccountForm accountForm) throws Exception {
      List retVals = new ArrayList();
      
      
      return retVals;
   }

}
