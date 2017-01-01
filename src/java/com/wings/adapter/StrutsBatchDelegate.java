



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.BatchDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Batch;
import com.wings.persistence.BatchKey;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsBatchDelegate {
    
    public static com.wings.web.struts.forms.BatchForm create (com.wings.web.struts.forms.BatchForm batchForm) throws Exception {
      Batch batch = new Batch();  
      BeanUtils.copyProperties(batch, batchForm);
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      batchDAO.insert(batch);
      return batchForm;
   }

   public static com.wings.web.struts.forms.BatchForm update (com.wings.web.struts.forms.BatchForm batchForm) throws Exception {
      Batch batch = new Batch();  
      BeanUtils.copyProperties(batch, batchForm);
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      batchDAO.updateByPrimaryKey(batch);
      return batchForm;
   }

   
   public static com.wings.web.struts.forms.BatchForm edit (com.wings.web.struts.forms.BatchForm batchForm) throws Exception {
      BatchKey batchKey = new BatchKey();  
      BeanUtils.copyProperties(batchKey, batchForm);
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      Batch batch = batchDAO.selectByPrimaryKey(batchKey);
      BeanUtils.copyProperties(batchForm, batch);
      return batchForm;
   }

   public static List findByName (String name) throws Exception {
      BatchKey batchKey = new BatchKey();  
      batchKey.setNoBatch(name);
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      List batchs = batchDAO.selectByName(batchKey);      
      return batchs;
   }
   
   public static void remove (com.wings.web.struts.forms.BatchForm batchForm) throws Exception {
      BatchKey batchKey = new BatchKey();  
      BeanUtils.copyProperties(batchKey, batchForm);
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      batchDAO.deleteByPrimaryKey(batchKey);
   }

   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      BatchDAO batchDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      batchDAO = (BatchDAO)daoMgr.getDao(BatchDAO.class);      
      retVals = batchDAO.selectByAll();
      return retVals;
   }

   
   public static List select (com.wings.web.struts.forms.BatchForm batchForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
