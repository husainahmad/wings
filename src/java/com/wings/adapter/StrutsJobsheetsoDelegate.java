package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.JobsheetsoDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Jobsheetso;
import com.wings.persistence.JobsheetsoKey;
import com.wings.web.struts.forms.JobsheetsoForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsJobsheetsoDelegate {
   private final static DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
   public static com.wings.web.struts.forms.JobsheetsoForm create (com.wings.web.struts.forms.JobsheetsoForm jobsheetsoForm) throws Exception {
      Jobsheetso jobsheetso = new Jobsheetso();  
      BeanUtils.copyProperties(jobsheetso, jobsheetsoForm);
      jobsheetso.setTermHBL(jobsheetsoForm.getTermHbl());
      jobsheetso.setTermMBL(jobsheetsoForm.getTermMbl());
      jobsheetso.setTrucking(jobsheetsoForm.getTrucking());      
      jobsheetso.setETDOrigin(jobsheetsoForm.getEtdorigin());
      jobsheetso.setETADestination(jobsheetsoForm.getEtadestination());   
      jobsheetso.setSinDate(jobsheetsoForm.getSinDate());
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);      
      jobsheetsoDAO.insert(jobsheetso);
      return jobsheetsoForm;
   }
 
   public static com.wings.web.struts.forms.JobsheetsoForm update (com.wings.web.struts.forms.JobsheetsoForm jobsheetsoForm) throws Exception {
      Jobsheetso jobsheetso = new Jobsheetso();  
      BeanUtils.copyProperties(jobsheetso, jobsheetsoForm);
      jobsheetso.setIdJobSheetSO(jobsheetsoForm.getIdJobSheetSo());
      jobsheetso.setTermHBL(jobsheetsoForm.getTermHbl());
      jobsheetso.setTermMBL(jobsheetsoForm.getTermMbl());
      jobsheetso.setTrucking(jobsheetsoForm.getTrucking());
      jobsheetso.setETDOrigin(jobsheetsoForm.getEtdorigin());
      jobsheetso.setETADestination(jobsheetsoForm.getEtadestination()); 
      jobsheetso.setSinDate(jobsheetsoForm.getSinDate());
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);      
      jobsheetsoDAO.updateByPrimaryKey(jobsheetso);
      return jobsheetsoForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetsoForm edit (com.wings.web.struts.forms.JobsheetsoForm jobsheetsoForm) throws Exception {
      JobsheetsoKey jobsheetsoKey = new JobsheetsoKey();  
      jobsheetsoKey.setIdJobSheetSO(jobsheetsoForm.getIdJobSheetSo());      
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);      
      Jobsheetso jobsheetso = jobsheetsoDAO.selectByPrimaryKey(jobsheetsoKey);
      BeanUtils.copyProperties(jobsheetsoForm, jobsheetso);
      jobsheetsoForm.setIdJobSheetSo(jobsheetso.getIdJobSheetSO());
      
      try {
          jobsheetsoForm.setEtadestinationAsString(formatDate.format(jobsheetso.getETADestination())); 
      } catch (Exception e) {
          jobsheetsoForm.setEtadestinationAsString("");
      }      
      
      try {
          jobsheetsoForm.setEtdoriginAsString(formatDate.format(jobsheetso.getETDOrigin())); 
      } catch (Exception e) {     
          jobsheetsoForm.setEtdoriginAsString(""); 
      }      
      
      try {
        jobsheetsoForm.setSinDateAsString(formatDate.format(jobsheetso.getSinDate())); 
      } catch (Exception e) {     
      }
      
      jobsheetsoForm.setTermHbl(jobsheetso.getTermHBL());
      jobsheetsoForm.setTermMbl(jobsheetso.getTermMBL());  
      jobsheetsoForm.setTrucking(jobsheetso.getTrucking());
      jobsheetsoForm.setShippingLineName(jobsheetso.getShippingLineName());

      return jobsheetsoForm;
   }
  
   public static void remove (com.wings.web.struts.forms.JobsheetsoForm jobsheetsoForm) throws Exception {
      JobsheetsoKey jobsheetsoKey = new JobsheetsoKey();  
      jobsheetsoKey.setIdJobSheetSO(jobsheetsoForm.getIdJobSheetSo());      
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);      
      jobsheetsoDAO.deleteByPrimaryKey(jobsheetsoKey);
   }

   public static void removeByIdJobSheet (com.wings.persistence.JobsheetKey key) throws Exception {         
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);       
      jobsheetsoDAO.deleteByIdJobSheet(key);
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);      
      retVals = jobsheetsoDAO.selectAll();
      return retVals;
   }
   
   public static List select (com.wings.web.struts.forms.JobsheetsoForm jobsheetsoForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

    public static JobsheetsoForm editByIdJobsheet(JobsheetsoForm jobsheetsoForm) throws Exception {
      Jobsheetso jobsheetso = new Jobsheetso();  
      jobsheetso.setIdJobSheet(jobsheetsoForm.getIdJobSheet());   
      JobsheetsoDAO jobsheetsoDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetsoDAO = (JobsheetsoDAO)daoMgr.getDao(JobsheetsoDAO.class);        
      
      jobsheetso = jobsheetsoDAO.selectByIdJobSheet(jobsheetso);
      if (jobsheetso!=null) {          
          BeanUtils.copyProperties(jobsheetsoForm, jobsheetso);
          jobsheetsoForm.setIdJobSheetSo(jobsheetso.getIdJobSheetSO());
          try {
              jobsheetsoForm.setEtadestinationAsString(formatDate.format(jobsheetso.getETADestination())); 
          } catch (Exception e) {
              jobsheetsoForm.setEtadestinationAsString("");
          }
          
          try {
              jobsheetsoForm.setEtdoriginAsString(formatDate.format(jobsheetso.getETDOrigin()));  
          } catch (Exception e) {
              jobsheetsoForm.setEtdoriginAsString("");  
          }          

          try {
              jobsheetsoForm.setSinDateAsString(formatDate.format(jobsheetso.getSinDate())); 
          } catch (Exception e) {     
              jobsheetsoForm.setSinDateAsString(""); 
          }

          jobsheetsoForm.setTermHbl(jobsheetso.getTermHBL());
          jobsheetsoForm.setTermMbl(jobsheetso.getTermMBL());       
      }      
      return jobsheetsoForm;
    }

}
