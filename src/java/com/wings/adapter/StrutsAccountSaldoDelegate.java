



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.AccountSaldoDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Account;
import com.wings.persistence.AccountKey;
import com.wings.persistence.AccountSaldo;
import com.wings.web.struts.forms.AccountSaldoForm;
import com.wings.web.struts.forms.MonthYearForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsAccountSaldoDelegate {


   public static com.wings.web.struts.forms.AccountSaldoForm create (com.wings.web.struts.forms.AccountSaldoForm accountSaldoForm) throws Exception {
      AccountSaldo accountSaldo = new AccountSaldo();  
      BeanUtils.copyProperties(accountSaldo, accountSaldoForm);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      accountSaldoDAO.insert(accountSaldo);
      return accountSaldoForm;
   }

   public static com.wings.web.struts.forms.AccountSaldoForm update (com.wings.web.struts.forms.AccountSaldoForm accountSaldoForm) throws Exception {
      AccountSaldo accountSaldo = new AccountSaldo();  
      BeanUtils.copyProperties(accountSaldo, accountSaldoForm);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      accountSaldoDAO.updateByPrimaryKey(accountSaldo);
      return accountSaldoForm;
   }

   public static com.wings.web.struts.forms.AccountSaldoForm edit (com.wings.web.struts.forms.AccountSaldoForm accountSaldoForm) throws Exception {
      AccountSaldo accountSaldo = new AccountSaldo();  
      BeanUtils.copyProperties(accountSaldo, accountSaldoForm);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByPrimaryKey(accountSaldo);
      BeanUtils.copyProperties(accountSaldoForm, account);
      return accountSaldoForm;
   }
   
   public static AccountSaldo selectByKas (MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByKas(monthYearForm);
      return account;
   }
   
    public static AccountSaldo selectByBank (MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByBank(monthYearForm);
      return account;
   }

   public static AccountSaldo selectByDeposit (MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByDeposit(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByPiutang(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByPiutang(monthYearForm);
      return account;
   }
   
    public static AccountSaldo selectByPiutangPihak(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByPiutangPihak(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByPajak(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByPajak(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByAktivaTidakLancar(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByAktivaTidakLancar(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByHutangLancar(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByHutangLancar(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByHutangLeasing(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByHutangLeasing(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByHutangPajak(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByHutangPajak(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByEkuitas(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByEkuitas(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByEkuitas2(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByEkuitas2(monthYearForm);
      return account;
   }
   
   public static AccountSaldo selectByEkuitas3(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      AccountSaldo account = accountSaldoDAO.selectByEkuitas3(monthYearForm);
      return account;
   }
   
   public static List selectByRL(MonthYearForm monthYearForm) throws Exception {
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      List accounts = accountSaldoDAO.selectByRL(monthYearForm);
      return accounts;
   }
   
   
   public static void remove (com.wings.web.struts.forms.AccountSaldoForm accountSaldoForm) throws Exception {
      AccountSaldo accountSaldo = new AccountSaldo();  
      BeanUtils.copyProperties(accountSaldo, accountSaldoForm);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      accountSaldoDAO.deleteByPrimaryKey(accountSaldo);      
   }

   public static List findAll (AccountSaldoForm accountSaldoForm) throws Exception {
      List retVals = new ArrayList();
      AccountSaldo account = new AccountSaldo();
      if (accountSaldoForm!=null) {
          if (accountSaldoForm.getAccountName()!=null) {
              account.setAccountName(accountSaldoForm.getAccountName()+"%");
          } else {
              account.setAccountName("%");
          }
      } else {
          account.setAccountName("%");
      }
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      retVals = accountSaldoDAO.selectByAll(account);            
      return retVals;
   }

   public static List findIdAccountSaldo (String name) throws Exception {
      List retVals = new ArrayList();
      AccountKey accountKey = new AccountKey();  
      accountKey.setIdAccount(name);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      retVals = accountSaldoDAO.selectByIdAccount(accountKey);            
      return retVals;
   }

   public static List findAccountName (String name) throws Exception {
      List retVals = new ArrayList();
      AccountSaldo account = new AccountSaldo();  
      account.setAccountName(name);
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      retVals = accountSaldoDAO.selectByAccountName(account);            
      return retVals;
   }

   public static List select (com.wings.web.struts.forms.AccountSaldoForm accountSaldoForm) throws Exception {
      List retVals = new ArrayList();
      
      
      return retVals;
   }

    public static List findByDate(MonthYearForm monthYearForm) {
      List retVals = new ArrayList();
     
      AccountSaldoDAO accountSaldoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      accountSaldoDAO = (AccountSaldoDAO)daoMgr.getDao(AccountSaldoDAO.class);      
      retVals = accountSaldoDAO.selectByDate(monthYearForm);            
      return retVals;
    }

}
