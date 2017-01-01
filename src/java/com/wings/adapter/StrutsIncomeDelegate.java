



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.IncomeDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Income;
import com.wings.persistence.IncomeKey;
import com.wings.web.struts.forms.AgentForm;
import java.util.List;
import java.util.ArrayList;

public class StrutsIncomeDelegate {


   
   public static Income create (Income income) throws Exception {      
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);      
      incomeDAO.insert(income);
      return income;
   }
   
   public static Income update (Income income) throws Exception {
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);       
      incomeDAO.updateByPrimaryKey(income);
      return income;
   }
  
   public static Income edit (IncomeKey incomeKey) throws Exception {
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);      
      Income income = incomeDAO.selectByPrimaryKey(incomeKey);
      return income;
   }
   
   public static IncomeKey lastId () throws Exception {
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);      
      IncomeKey incomeKey = (IncomeKey)incomeDAO.selectLastId();
      return incomeKey;
   }
   
   public static void remove (IncomeKey incomeKey) throws Exception {
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);      
      incomeDAO.deleteByPrimaryKey(incomeKey);
   }
  
   public static void removeByRefId (Income income) throws Exception {
      IncomeDAO incomeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      incomeDAO = (IncomeDAO)daoMgr.getDao(IncomeDAO.class);      
      incomeDAO.deleteByRefId(income);
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

  
   public static List select (AgentForm agentForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
