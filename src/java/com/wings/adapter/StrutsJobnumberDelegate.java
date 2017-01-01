package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.JobnumberDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.JobnumberKey;

public class StrutsJobnumberDelegate {

   public static JobnumberKey create (JobnumberKey jobnumberKey) throws Exception {      
      JobnumberDAO jobnumberDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobnumberDAO = (JobnumberDAO)daoMgr.getDao(JobnumberDAO.class);      
      jobnumberDAO.insert(jobnumberKey);
      return jobnumberKey;
   }
   
   public static JobnumberKey selectMax () throws Exception {
      JobnumberDAO jobnumberDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobnumberDAO = (JobnumberDAO)daoMgr.getDao(JobnumberDAO.class);      
      JobnumberKey jobnumberKey = jobnumberDAO.selectMax();
      return jobnumberKey;
   }
   
   public static String selectNext () throws Exception {
      JobnumberDAO jobnumberDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobnumberDAO = (JobnumberDAO)daoMgr.getDao(JobnumberDAO.class);      
      String jobnumberKey = jobnumberDAO.selectNext();
      return jobnumberKey;
   }   
}
