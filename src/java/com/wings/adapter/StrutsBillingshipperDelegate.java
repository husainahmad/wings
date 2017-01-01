



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.BillingshipperDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Billingshipper;
import com.wings.persistence.BillingshipperKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.BillingshipperForm;
import com.wings.web.struts.forms.JobsheetForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsBillingshipperDelegate {


  
   public static com.wings.web.struts.forms.BillingshipperForm create (com.wings.web.struts.forms.BillingshipperForm billingshipperForm) throws Exception {
      Billingshipper billingshipper = new Billingshipper();  
      BeanUtils.copyProperties(billingshipper, billingshipperForm);
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      billingshipperDAO.insert(billingshipper);
      return billingshipperForm;
   }

  
   public static com.wings.web.struts.forms.BillingshipperForm update (com.wings.web.struts.forms.BillingshipperForm billingshipperForm) throws Exception {
      Billingshipper billingshipper = new Billingshipper();  
      BeanUtils.copyProperties(billingshipper, billingshipperForm);
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      billingshipperDAO.updateByPrimaryKey(billingshipper);
      return billingshipperForm;
   }

  
   public static com.wings.web.struts.forms.BillingshipperForm edit (com.wings.web.struts.forms.BillingshipperForm billingshipperForm) throws Exception {
      BillingshipperKey billingshipperKey = new BillingshipperKey();  
      billingshipperKey.setIdbillingShipper(billingshipperForm.getIdbillingShipper());
  
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      Billingshipper billingshipper = billingshipperDAO.selectByPrimaryKey(billingshipperKey);
      BeanUtils.copyProperties(billingshipperForm, billingshipper);
      return billingshipperForm;
   }

   
   public static void remove (com.wings.web.struts.forms.BillingshipperForm billingshipperForm) throws Exception {
      BillingshipperKey billingshipperKey = new BillingshipperKey();  
      billingshipperKey.setIdbillingShipper(billingshipperForm.getIdbillingShipper());
  
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      billingshipperDAO.deleteByPrimaryKey(billingshipperKey);
   }

   public static void removeByJobsheetKey (JobsheetKey key) throws Exception {      
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      billingshipperDAO.deleteByJobsheetKey(key);
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectAll();
      return retVals;
   }

   
   public static List selectByJobsheetKey (com.wings.persistence.JobsheetKey key) throws Exception {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectByJobsheetKey(key);
      return retVals;
   }
   
   public static List selectByJobsheetKeyIDR (com.wings.persistence.JobsheetKey key) throws Exception {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectByJobsheetKeyIDR(key);
      return retVals;
   }
   
   public static List selectByJobsheetKeyUSD (com.wings.persistence.JobsheetKey key) throws Exception {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectByJobsheetKeyUSD(key);
      return retVals;
   }
   
   public static List selectByJobNo (JobsheetForm jobsheetForm) throws Exception {
      List retVals = new ArrayList();
      Jobsheet jobsheet = new Jobsheet();
      jobsheet.setJobNo(jobsheetForm.getJobNo());
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectByJobNo(jobsheet);
      return retVals;
   }

    public static List select(BillingshipperForm billingshipperForm) {
        return null;
    }

    public static List selectByIdJobSheet(JobsheetKey jobsheetKey) {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectByJobsheetKey(jobsheetKey);
      return retVals;
    }

    public static Double selectTotalIDRByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      totalCharge = billingshipperDAO.selectTotalIDRByIdJobSheet(jobsheetKey);
      return totalCharge;
    }

    public static Double selectTotalUSDByIdJobSheet(JobsheetKey jobsheetKey) {
      Double totalCharge = new Double(0.0);
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      totalCharge = billingshipperDAO.selectTotalUSDByIdJobSheet(jobsheetKey);
      return totalCharge;
    }
    
    public static List selectTaxByIdJobSheet(JobsheetKey jobsheetKey) {
      List retVals = new ArrayList();
      BillingshipperDAO billingshipperDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingshipperDAO = (BillingshipperDAO)daoMgr.getDao(BillingshipperDAO.class);      
      retVals = billingshipperDAO.selectTaxByJobsheetKey(jobsheetKey);
      return retVals;
    }

}
