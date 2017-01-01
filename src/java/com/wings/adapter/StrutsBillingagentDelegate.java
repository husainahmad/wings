



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.BillingagentDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Billingagent;
import com.wings.persistence.BillingagentKey;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.JobsheetForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsBillingagentDelegate {


  
   public static com.wings.web.struts.forms.BillingagentForm create (com.wings.web.struts.forms.BillingagentForm billingagentForm) throws Exception {
      Billingagent billingagent = new Billingagent();  
      BeanUtils.copyProperties(billingagent, billingagentForm);
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);      
      billingagentDAO.insert(billingagent);
      return billingagentForm;
   }

   
   public static com.wings.web.struts.forms.BillingagentForm update (com.wings.web.struts.forms.BillingagentForm billingagentForm) throws Exception {
      Billingagent billingagent = new Billingagent();  
      BeanUtils.copyProperties(billingagent, billingagentForm);
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);      
      billingagentDAO.updateByPrimaryKey(billingagent);
      return billingagentForm;
   }

   
   public static com.wings.web.struts.forms.BillingagentForm edit (com.wings.web.struts.forms.BillingagentForm billingagentForm) throws Exception {
      BillingagentKey billingagentKey = new BillingagentKey(); 
      billingagentKey.setIdbillingAgent(billingagentForm.getIdbillingAgent());
      
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);      
      Billingagent billingagent = billingagentDAO.selectByPrimaryKey(billingagentKey);
      BeanUtils.copyProperties(billingagentForm, billingagent);
      return billingagentForm;
   }

  
   public static void remove (com.wings.web.struts.forms.BillingagentForm billingagentForm) throws Exception {
      BillingagentKey billingagentKey = new BillingagentKey(); 
      billingagentKey.setIdbillingAgent(billingagentForm.getIdbillingAgent());
      
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);      
      billingagentDAO.deleteByPrimaryKey(billingagentKey);      
   }
   
    public static void removeByJobsheetKey(JobsheetKey key) throws Exception {      
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);      
      billingagentDAO.deleteByJobsheetKey(key);      
   }
 
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectAll();
      return retVals;
   }

   
   public static List select (com.wings.web.struts.forms.BillingagentForm billingagentForm) throws Exception {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectAll();
      return retVals;
   }
   
   public static List selectByIdJobSheet (com.wings.persistence.JobsheetKey jobsheetKey) throws Exception {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectByIdJobSheet(jobsheetKey);
      return retVals;
   }

   public static List selectByIdJobSheetIDR (com.wings.persistence.JobsheetKey jobsheetKey) throws Exception {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectByIdJobSheetIDR(jobsheetKey);
      return retVals;
   }

   public static List selectByIdJobSheetUSD (com.wings.persistence.JobsheetKey jobsheetKey) throws Exception {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectByIdJobSheetUSD(jobsheetKey);
      return retVals;
   }

   public static Double selectTotalIDRByIdJobSheet (com.wings.persistence.JobsheetKey jobsheetKey) throws Exception {
      Double totalCharge = new Double(0.0);
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      totalCharge = billingagentDAO.selectTotalIDRByIdJobSheet(jobsheetKey);
      return totalCharge;
   }
   
   public static Double selectTotalUSDByIdJobSheet (com.wings.persistence.JobsheetKey jobsheetKey) throws Exception {
      Double totalCharge = new Double(0.0);
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      totalCharge = billingagentDAO.selectTotalUSDByIdJobSheet(jobsheetKey);
      return totalCharge;
   }

   public static List selectByIdJobNo (JobsheetForm jobsheetForm) throws Exception {
      List retVals = new ArrayList();
      Jobsheet jobsheet = new Jobsheet();
      jobsheet.setJobNo(jobsheetForm.getJobNo());
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectByIdJobNo(jobsheet);
      return retVals;
   }
   
    public static List selectTaxByIdJobSheet(JobsheetKey jobsheetKey) {
      List retVals = new ArrayList();
      BillingagentDAO billingagentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      billingagentDAO = (BillingagentDAO)daoMgr.getDao(BillingagentDAO.class);  
      retVals = billingagentDAO.selectTaxByIdJobSheet(jobsheetKey);
      return retVals;
    }

}
