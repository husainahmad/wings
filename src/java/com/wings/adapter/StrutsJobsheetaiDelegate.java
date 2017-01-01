package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.JobsheetaiDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Jobsheetai;
import com.wings.persistence.JobsheetaiKey;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsJobsheetaiDelegate {
 
   public static com.wings.web.struts.forms.JobsheetaiForm create (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      Jobsheetai jobsheetai = new Jobsheetai();  
      BeanUtils.copyProperties(jobsheetai, jobsheetaiForm);
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);      
      jobsheetaiDAO.insert(jobsheetai);
      return jobsheetaiForm;
   }
  
   public static com.wings.web.struts.forms.JobsheetaiForm update (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      Jobsheetai jobsheetai = new Jobsheetai();  
      BeanUtils.copyProperties(jobsheetai, jobsheetaiForm);
      jobsheetai.setIdJobSheetAI(jobsheetaiForm.getIdJobSheetAi());
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);      
      jobsheetaiDAO.updateByPrimaryKey(jobsheetai);
      return jobsheetaiForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetaiForm edit (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      JobsheetaiKey jobsheetaiKey = new JobsheetaiKey();  
      jobsheetaiKey.setIdJobSheetAI(jobsheetaiForm.getIdJobSheetAi());      
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);        
      Jobsheetai jobsheetai = jobsheetaiDAO.selectByPrimaryKey(jobsheetaiKey);
      BeanUtils.copyProperties(jobsheetaiForm, jobsheetai);
      jobsheetaiForm.setIdJobSheetAi(jobsheetai.getIdJobSheetAI());
      return jobsheetaiForm;
   }
  
    public static com.wings.web.struts.forms.JobsheetaiForm editByIdJobsheet (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      Jobsheetai jobsheetai = new Jobsheetai();  
      BeanUtils.copyProperties(jobsheetai, jobsheetaiForm);     
      jobsheetai.setIdJobSheetAI(jobsheetaiForm.getIdJobSheetAi());
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);        
      jobsheetai = jobsheetaiDAO.selectByIdJobSheet(jobsheetai);
      if (jobsheetai!=null) {
          BeanUtils.copyProperties(jobsheetaiForm, jobsheetai);
          jobsheetaiForm.setIdJobSheetAi(jobsheetai.getIdJobSheetAI());
      }            
      return jobsheetaiForm;
   }
    
   public static void remove (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      JobsheetaiKey jobsheetaiKey = new JobsheetaiKey();  
      jobsheetaiKey.setIdJobSheetAI(jobsheetaiForm.getIdJobSheetAi());      
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);        
      jobsheetaiDAO.deleteByPrimaryKey(jobsheetaiKey);
   }
   
   public static void removeByIdJobSheet (com.wings.persistence.JobsheetKey key) throws Exception {         
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);        
      jobsheetaiDAO.deleteByIdJobSheet(key);
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }
   
    public static List selectByidJobType (com.wings.persistence.Jobsheet jobsheet) throws Exception {
      List retVals = new ArrayList();
      JobsheetaiDAO jobsheetaiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetaiDAO = (JobsheetaiDAO)daoMgr.getDao(JobsheetaiDAO.class);      
      //retVals = jobsheetaiDAO.selectByidJobType(jobsheet);
      return retVals;
   }
  
   public static List select (com.wings.web.struts.forms.JobsheetaiForm jobsheetaiForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
