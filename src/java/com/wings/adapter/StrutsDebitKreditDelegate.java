



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.DebitDAO;
import com.wings.dao.DebitkreditDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Debit;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.Debitkredit;
import com.wings.persistence.DebitkreditKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsDebitKreditDelegate {


  
   public static Debitkredit create (Debitkredit debitkredit) throws Exception {      
      DebitkreditDAO debitkreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitkreditDAO = (DebitkreditDAO)daoMgr.getDao(DebitkreditDAO.class);      
      debitkreditDAO.insert(debitkredit);
      return debitkredit;
   }

  
   public static Debitkredit update (Debitkredit debitkredit) throws Exception {
      DebitkreditDAO debitkreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitkreditDAO = (DebitkreditDAO)daoMgr.getDao(DebitkreditDAO.class);      
      debitkreditDAO.updateByPrimaryKey(debitkredit);
      return debitkredit;
   }
   
   public static void remove (DebitkreditKey debitkreditKey) throws Exception {
      DebitkreditDAO debitkreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitkreditDAO = (DebitkreditDAO)daoMgr.getDao(DebitkreditDAO.class);      
      debitkreditDAO.deleteByPrimaryKey(debitkreditKey);
   }

   public static void removeByIdDebit (Debitkredit debitkredit) throws Exception {
      DebitkreditDAO debitkreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitkreditDAO = (DebitkreditDAO)daoMgr.getDao(DebitkreditDAO.class);      
      debitkreditDAO.deleteByIdDebit(debitkredit);
   }   
  
   public static List findAllByIdDebit (Debitkredit debitkredit) throws Exception {
      List retVals = new ArrayList();
      DebitkreditDAO debitkreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      debitkreditDAO = (DebitkreditDAO)daoMgr.getDao(DebitkreditDAO.class);      
      retVals = debitkreditDAO.selectByIdDebit(debitkredit);
      return retVals;
   }
   
}
