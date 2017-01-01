package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.JobsheetsiDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Jobsheetsi;
import com.wings.persistence.JobsheetsiKey;
import com.wings.web.struts.forms.JobsheetsiForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsJobsheetsiDelegate {
   private final static DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
   public static com.wings.web.struts.forms.JobsheetsiForm create (com.wings.web.struts.forms.JobsheetsiForm jobsheetsiForm) throws Exception {
      Jobsheetsi jobsheetsi = new Jobsheetsi();  
      BeanUtils.copyProperties(jobsheetsi, jobsheetsiForm);
      jobsheetsi.setTermHBL(jobsheetsiForm.getTermHbl());
      jobsheetsi.setTermMBL(jobsheetsiForm.getTermMbl());
      jobsheetsi.setPOD(jobsheetsiForm.getPod());
      try {
        jobsheetsi.setETAOrigin(jobsheetsiForm.getEtaorigin());
      } catch (Exception e) {          
      }
      
      try {
          jobsheetsi.setETDOrigin(jobsheetsiForm.getEtdorigin());  
      } catch (Exception e) {          
      }
      
      try {
          jobsheetsi.setCustomDate(jobsheetsiForm.getCustomeDate());
      } catch (Exception e) {          
      }      
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);      
      jobsheetsiDAO.insert(jobsheetsi);
      return jobsheetsiForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetsiForm update (com.wings.web.struts.forms.JobsheetsiForm jobsheetsiForm) throws Exception {
      Jobsheetsi jobsheetsi = new Jobsheetsi();  
      BeanUtils.copyProperties(jobsheetsi, jobsheetsiForm);
      jobsheetsi.setIdJobSheetSI(jobsheetsiForm.getIdJobSheetSi());
      jobsheetsi.setTermHBL(jobsheetsiForm.getTermHbl());
      jobsheetsi.setTermMBL(jobsheetsiForm.getTermMbl());
      jobsheetsi.setPOD(jobsheetsiForm.getPod());
      try {
        jobsheetsi.setETAOrigin(jobsheetsiForm.getEtaorigin());
      } catch (Exception e) {          
      }
      
      try {
          jobsheetsi.setETDOrigin(jobsheetsiForm.getEtdorigin());  
      } catch (Exception e) {          
      }
      
      try {
          jobsheetsi.setCustomDate(jobsheetsiForm.getCustomeDate());
      } catch (Exception e) {          
      }            
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);      
      jobsheetsiDAO.updateByPrimaryKey(jobsheetsi);
      return jobsheetsiForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetsiForm edit (com.wings.web.struts.forms.JobsheetsiForm jobsheetsiForm) throws Exception {
      JobsheetsiKey jobsheetsiKey = new JobsheetsiKey();  
      jobsheetsiKey.setIdJobSheetSI(jobsheetsiForm.getIdJobSheetSi());      
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);        
      Jobsheetsi jobsheetsi = jobsheetsiDAO.selectByPrimaryKey(jobsheetsiKey);
      BeanUtils.copyProperties(jobsheetsiForm, jobsheetsi);
      jobsheetsiForm.setIdJobSheetSi(jobsheetsi.getIdJobSheetSI());
      return jobsheetsiForm;
   }
   
   public static void remove (com.wings.web.struts.forms.JobsheetsiForm jobsheetsiForm) throws Exception {
      JobsheetsiKey jobsheetsiKey = new JobsheetsiKey();  
      jobsheetsiKey.setIdJobSheetSI(jobsheetsiForm.getIdJobSheetSi());      
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);        
      jobsheetsiDAO.deleteByPrimaryKey(jobsheetsiKey);      
   }
  
   public static void removeByIdJobSheet (com.wings.persistence.JobsheetKey key) throws Exception {         
     JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);       
      jobsheetsiDAO.deleteByIdJobSheet(key);
   }
    
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);        
      retVals = jobsheetsiDAO.selectAll();      
      return retVals;
   }

   public static List selectByidJobType (com.wings.persistence.Jobsheet jobsheet) throws Exception {
      List retVals = new ArrayList();
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);      
      //retVals = jobsheetaiDAO.selectByidJobType(jobsheet);
      return retVals;
   }
  
   public static List select (com.wings.web.struts.forms.JobsheetsiForm jobsheetsiForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

    public static JobsheetsiForm editByIdJobsheet(JobsheetsiForm jobsheetsiForm) throws Exception {
      Jobsheetsi jobsheetsi = new Jobsheetsi();  
      jobsheetsi.setIdJobSheet(jobsheetsiForm.getIdJobSheet());       
      JobsheetsiDAO jobsheetsiDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsiDAO = (JobsheetsiDAO)daoMgr.getDao(JobsheetsiDAO.class);        
      jobsheetsi = jobsheetsiDAO.selectByIdJobSheet(jobsheetsi);
      if (jobsheetsi!=null) {
          BeanUtils.copyProperties(jobsheetsiForm, jobsheetsi);
          jobsheetsiForm.setIdJobSheetSi(jobsheetsi.getIdJobSheetSI());
          try {
              jobsheetsiForm.setEtaoriginAsString(formatDate.format(jobsheetsi.getETAOrigin()));  
          } catch (Exception e) {
              jobsheetsiForm.setEtaoriginAsString("");
          }
          try {
              jobsheetsiForm.setEtdoriginAsString(formatDate.format(jobsheetsi.getETDOrigin()));
          } catch (Exception e) {
              jobsheetsiForm.setEtdoriginAsString("");
          }
          
          try {
              jobsheetsiForm.setCustomDateAsString(formatDate.format(jobsheetsi.getCustomDate()));
          } catch (Exception e) {
              jobsheetsiForm.setCustomDateAsString("");
          }

          jobsheetsiForm.setPod(jobsheetsi.getPOD());
          jobsheetsiForm.setTermHbl(jobsheetsi.getTermHBL());
          jobsheetsiForm.setTermMbl(jobsheetsi.getTermMBL());
          jobsheetsiForm.setShippingLineName(jobsheetsi.getShippingLineName());
      }      
      return jobsheetsiForm;
    }

}
