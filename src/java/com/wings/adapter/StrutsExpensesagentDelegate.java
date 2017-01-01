
package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.ExpensesagentDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Expensesagent;
import com.wings.persistence.ExpensesagentKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.JobsheetForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsExpensesagentDelegate {

   
   public static com.wings.web.struts.forms.ExpensesagentForm create (com.wings.web.struts.forms.ExpensesagentForm expensesagentForm) throws Exception {
      Expensesagent expensesagent = new Expensesagent();  
      BeanUtils.copyProperties(expensesagent, expensesagentForm);
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      expensesagentDAO.insert(expensesagent);
      return expensesagentForm;
   }

  
   public static com.wings.web.struts.forms.ExpensesagentForm update (com.wings.web.struts.forms.ExpensesagentForm expensesagentForm) throws Exception {
      Expensesagent expensesagent = new Expensesagent();  
      BeanUtils.copyProperties(expensesagent, expensesagentForm);
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      expensesagentDAO.updateByPrimaryKey(expensesagent);
      return expensesagentForm;
   }

 
   public static com.wings.web.struts.forms.ExpensesagentForm edit (com.wings.web.struts.forms.ExpensesagentForm expensesagentForm) throws Exception {
      ExpensesagentKey expensesagentKey = new ExpensesagentKey();  
      expensesagentKey.setIdExpensesAgent(expensesagentForm.getIdExpensesAgent());
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      Expensesagent expensesagent = expensesagentDAO.selectByPrimaryKey(expensesagentKey);
      BeanUtils.copyProperties(expensesagentForm, expensesagent);
      return expensesagentForm;
   }

    
   public static void remove (com.wings.web.struts.forms.ExpensesagentForm expensesagentForm) throws Exception {
      ExpensesagentKey expensesagentKey = new ExpensesagentKey();  
      expensesagentKey.setIdExpensesAgent(expensesagentForm.getIdExpensesAgent());
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      expensesagentDAO.deleteByPrimaryKey(expensesagentKey);
   }

   public static void removeByJobsheetKey (com.wings.persistence.JobsheetKey key) throws Exception {      
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      expensesagentDAO.deleteByJobsheetKey(key);
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();      
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      retVals = expensesagentDAO.selectAll();
      return retVals;
   }

  
   public static List selectByJobsheetKey (com.wings.persistence.JobsheetKey key) throws Exception {
      List retVals = new ArrayList();
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      retVals = expensesagentDAO.selectByJobsheetKey(key);
      return retVals;
   }
   
   public static List selectByJobNo (JobsheetForm jobsheetForm) throws Exception {
      List retVals = new ArrayList();
      Jobsheet jobsheet = new Jobsheet();
      jobsheet.setJobNo(jobsheetForm.getJobNo());
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      retVals = expensesagentDAO.selectByJobNo(jobsheet);
      return retVals;
   }
   
   public static List select (com.wings.web.struts.forms.ExpensesagentForm expensesagentForm) throws Exception {
       List retVals = new ArrayList();
      
      return retVals;
   }

    public static List selectByIdJobSheet(JobsheetKey jobsheetKey) {
      List retVals = new ArrayList();
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      retVals = expensesagentDAO.selectByJobsheetKey(jobsheetKey);
      return retVals;
    }
    
    public static Double selectTotalIDRByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      totalCharge = expensesagentDAO.selectTotalIDRByIdJobSheet(jobsheetKey);
      return totalCharge;
    }
    
    public static Double selectTotalUSDByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);
      ExpensesagentDAO expensesagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesagentDAO = (ExpensesagentDAO)daoMgr.getDao(ExpensesagentDAO.class);      
      totalCharge = expensesagentDAO.selectTotalUSDByIdJobSheet(jobsheetKey);
      return totalCharge;
    }
}
