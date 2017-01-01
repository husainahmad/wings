package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.ExpensesshipperDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Expensesshipper;
import com.wings.persistence.ExpensesshipperKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.ExpensesshipperForm;
import com.wings.web.struts.forms.JobsheetForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsExpensesshipperDelegate {

   public static com.wings.web.struts.forms.ExpensesshipperForm create (com.wings.web.struts.forms.ExpensesshipperForm expensesshipperForm) throws Exception {
      Expensesshipper expensesshipper = new Expensesshipper();  
      BeanUtils.copyProperties(expensesshipper, expensesshipperForm);
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      expensesshipperDAO.insert(expensesshipper);
      return expensesshipperForm;
   }

   
   public static com.wings.web.struts.forms.ExpensesshipperForm update (com.wings.web.struts.forms.ExpensesshipperForm expensesshipperForm) throws Exception {
      Expensesshipper expensesshipper = new Expensesshipper();  
      BeanUtils.copyProperties(expensesshipper, expensesshipperForm);
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      expensesshipperDAO.updateByPrimaryKey(expensesshipper);
      return expensesshipperForm;
   }

   
   public static com.wings.web.struts.forms.ExpensesshipperForm edit (com.wings.web.struts.forms.ExpensesshipperForm expensesshipperForm) throws Exception {
      ExpensesshipperKey expensesshipperKey = new ExpensesshipperKey();        
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      Expensesshipper expensesshipper = expensesshipperDAO.selectByPrimaryKey(expensesshipperKey);
      BeanUtils.copyProperties(expensesshipperForm, expensesshipper);
      return expensesshipperForm;
   }

   
   public static void remove (com.wings.web.struts.forms.ExpensesshipperForm expensesshipperForm) throws Exception {
      ExpensesshipperKey expensesshipperKey = new ExpensesshipperKey();        
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      expensesshipperDAO.deleteByPrimaryKey(expensesshipperKey);
   }

   
   public static void removeByJobsheetKey (com.wings.persistence.JobsheetKey key) throws Exception {     
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      expensesshipperDAO.deleteByJobsheetKey(key);
   }
   
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();           
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      retVals = expensesshipperDAO.selectAll();
      return retVals;
   }

  
   public static List select (com.wings.persistence.JobsheetKey key) throws Exception {
      List retVals = new ArrayList();
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      retVals = expensesshipperDAO.selectByJobSheetKey(key);
      return retVals;
   }

    public static List select(ExpensesshipperForm expensesshipperForm) {
        return null;
    }

    public static List selectByIdJobSheet(JobsheetKey jobsheetKey) {
      List retVals = new ArrayList();           
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      retVals = expensesshipperDAO.selectByJobSheetKey(jobsheetKey);
      return retVals;
    }
    
    public static List selectByJobNo(JobsheetForm jobsheetForm) {
      List retVals = new ArrayList();       
      Jobsheet jobsheet = new Jobsheet();
      jobsheet.setJobNo(jobsheetForm.getJobNo());
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      retVals = expensesshipperDAO.selectByJobNo(jobsheet);
      return retVals;
    }

    public static Double selectTotalIDRByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);           
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      totalCharge = expensesshipperDAO.selectTotalIDRByIdJobSheet(jobsheetKey);
      return totalCharge;
    }
    
    public static Double selectTotalUSDByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);           
      ExpensesshipperDAO expensesshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      expensesshipperDAO = (ExpensesshipperDAO)daoMgr.getDao(ExpensesshipperDAO.class);      
      totalCharge = expensesshipperDAO.selectTotalUSDByIdJobSheet(jobsheetKey);
      return totalCharge;
    }
    
}
