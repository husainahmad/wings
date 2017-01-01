



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.DebitDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Debit;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsDebitDelegate {


  
   public static com.wings.web.struts.forms.DebitForm create (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      Debit debit = new Debit();  
      BeanUtils.copyProperties(debit, debitForm);
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debitDAO.insert(debit); 
      return debitForm;
   }

  
   public static com.wings.web.struts.forms.DebitForm update (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      Debit debit = new Debit();  
      BeanUtils.copyProperties(debit, debitForm);
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debitDAO.updateByPrimaryKey(debit);
      return debitForm;
   }
   
   public static Debit updatePayableStatus (Debit debit) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);   
      debitDAO.updatePayableByPrimaryKey(debit); 
      return debit;
   }
   
   public static Debit updatePayableStatusByDebitNumber (Debit debit) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);   
      debitDAO.updatePayableByDebitNumber(debit); 
      return debit;
   }
   
   public static com.wings.web.struts.forms.DebitForm edit (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      DebitKey debitKey = new DebitKey();  
      debitKey.setIdDebit(debitForm.getIdDebit());      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      Debit debit = debitDAO.selectByPrimaryKey(debitKey);
      try {
           debitForm.setDebitDate(new java.sql.Date(debit.getDebitDate().getTime()));
           debitForm.setDebitNumber(debit.getDebitNumber());
           debitForm.setIdDebit(debit.getIdDebit());
           debitForm.setIdJobSheet(debit.getIdJobSheet());           
           //BeanUtils.copyProperties(debitForm, debit);
      } catch (Exception e) {
           debitForm.setDebitNumber(debit.getDebitNumber());
      }
      return debitForm;
   }

   public static com.wings.web.struts.forms.DebitForm findByIdJobsheet (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      Debit debit = new Debit();  
      BeanUtils.copyProperties(debit, debitForm);
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debit = debitDAO.selectByIdJobsheet(debit);
      try {
           if (debit!=null) {
               BeanUtils.copyProperties(debitForm, debit);
           }           
      } catch (Exception e) {
           debitForm.setIdDebit(debit.getIdDebit());
           debitForm.setIdJobSheet(debit.getIdJobSheet());           
           debitForm.setDebitNumber(debit.getDebitNumber());
      }
      return debitForm;
   }
   
   public static com.wings.web.struts.forms.DebitForm selectMaxDebitNumber (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      Debit debit = new Debit();  
      BeanUtils.copyProperties(debit, debitForm);
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debit = debitDAO.selectByMaxDebitNumber(debit);
      try {
           if (debit!=null) {
               debitForm.setDebitNumber(debit.getDebitNumber());               
           }           
      } catch (Exception e) {           
      }
      return debitForm;
   }
    
   public static void remove (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      DebitKey debitKey = new DebitKey();  
      debitKey.setIdDebit(debitForm.getIdDebit());      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debitDAO.deleteByPrimaryKey(debitKey);
   }
  
   public static void removeByIdJobsheet (JobsheetKey jobsheetKey) throws Exception {
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      debitDAO.deleteByIdJobsheet(jobsheetKey);
   }
   
   public static List findAll (com.wings.web.struts.forms.MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      retVals = debitDAO.selectByAll(monthYearForm);
      return retVals;
   }

   
   public static List select (com.wings.web.struts.forms.DebitForm debitForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

   public static String selectJobTypeByDebitKey (DebitKey debitKey) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      String jobType = debitDAO.selectJobTypeByPrimaryKey(debitKey);       
      return jobType;
   }
   
   public static DebitAIDetail selectDebitAIDetailByDebitKey (DebitKey debitKey) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      DebitAIDetail debitAIDetail = debitDAO.selectJobAIDetailByPrimaryKey(debitKey);       
      return debitAIDetail;
   }
   
    public static DebitAODetail selectDebitAODetailByDebitKey (DebitKey debitKey) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      DebitAODetail debitAODetail = debitDAO.selectJobAODetailByPrimaryKey(debitKey);       
      return debitAODetail;
   }
    
   public static DebitSIDetail selectDebitSIDetailByDebitKey (DebitKey debitKey) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      DebitSIDetail debitSIDetail = debitDAO.selectJobSIDetailByPrimaryKey(debitKey);       
      return debitSIDetail;
   }
   
   public static DebitSODetail selectDebitSODetailByDebitKey (DebitKey debitKey) throws Exception {      
      DebitDAO debitDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitDAO = (DebitDAO)daoMgr.getDao(DebitDAO.class);      
      DebitSODetail debitSODetail = debitDAO.selectJobSODetailByPrimaryKey(debitKey);       
      return debitSODetail;
   }
   
}
