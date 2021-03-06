



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.ShipperfeeDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Shipperfee;
import com.wings.persistence.ShipperfeeKey;
import com.wings.web.struts.forms.ShipperfeeForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

/**
 * This is a delegate class to handle interaction with the backend persistence layer of cmp20. 
 * It has a set of methods to handle persistence for Shipperfee data (i.e. 
 * com.wings.web.struts.ShipperfeeForm objects).
 * 
 * @author <strong>Generated by Middlegen.</strong>
 */
public class StrutsShipperfeeDelegate {


   /**
    * Create a new com.wings.web.struts.ShipperfeeForm object and persist (i.e. insert) it.
    *
    * @param   shipperfeeForm   The object containing the data for the new com.wings.web.struts.ShipperfeeForm object
    * @exception   Exception   If the new com.wings.web.struts.ShipperfeeForm object cannot be created or persisted.
    */
   public static com.wings.web.struts.forms.ShipperfeeForm create (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      Shipperfee shipperfee = new Shipperfee();  
      BeanUtils.copyProperties(shipperfee, shipperfeeForm);
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      shipperfeeDAO.insert(shipperfee);
      return shipperfeeForm;
   }

   /**
    * Update (i.e. persist) an existing com.wings.web.struts.ShipperfeeForm object.
    *
    * @param   shipperfeeForm   The com.wings.web.struts.ShipperfeeForm object containing the data to be updated
    * @exception   Exception   If the com.wings.web.struts.ShipperfeeForm object cannot be updated/persisted.
    */
   public static com.wings.web.struts.forms.ShipperfeeForm update (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      Shipperfee shipperfee = new Shipperfee();  
      BeanUtils.copyProperties(shipperfee, shipperfeeForm);
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      shipperfeeDAO.updateByPrimaryKey(shipperfee);
      return shipperfeeForm;
   }

   /**
    * Retrieve an existing com.wings.web.struts.ShipperfeeForm object for editing.
    *
    * @param   shipperfeeForm   The com.wings.web.struts.ShipperfeeForm object containing the data used to retrieve the object (i.e. the primary key info).
    * @exception   Exception   If the com.wings.web.struts.ShipperfeeForm object cannot be retrieved.
    */
   public static com.wings.web.struts.forms.ShipperfeeForm edit (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      ShipperfeeKey shipperfeeKey = new ShipperfeeKey();  
      shipperfeeKey.setIdShipperFee(shipperfeeForm.getIdShipperFee());      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      Shipperfee shipperfee = shipperfeeDAO.selectByPrimaryKey(shipperfeeKey);      
      BeanUtils.copyProperties(shipperfeeForm, shipperfee);
      return shipperfeeForm;
   }

   public static com.wings.web.struts.forms.ShipperfeeForm findByName (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      Shipperfee shipperfee = new Shipperfee();  
      shipperfee.setDescription(shipperfeeForm.getDescription());      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      shipperfee = shipperfeeDAO.selectByName(shipperfee);      
      if (shipperfee!=null) {
         BeanUtils.copyProperties(shipperfeeForm, shipperfee);   
      } else {
         shipperfeeForm = null; 
      }      
      return shipperfeeForm;
   }

   /**
    * Remove (delete) an existing com.wings.web.struts.ShipperfeeForm object.
    *
    * @param   shipperfeeForm   The com.wings.web.struts.ShipperfeeForm object containing the data to be deleted.
    * @exception   Exception   If the com.wings.web.struts.ShipperfeeForm object cannot be removed.
    */  
   public static void remove (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      ShipperfeeKey shipperfeeKey = new ShipperfeeKey();  
      shipperfeeKey.setIdShipperFee(shipperfeeForm.getIdShipperFee());      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      shipperfeeDAO.deleteByPrimaryKey(shipperfeeKey);      
      
   }

   /**
    * Retrieve all existing com.wings.web.struts.ShipperfeeForm objects.
    *
    * @exception   Exception   If the com.wings.web.struts.ShipperfeeForm objects cannot be retrieved.
    */
   public static List findAll (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      
      if (shipperfeeForm==null) {
          shipperfee.setDescription("%");
      } else {
          if (shipperfeeForm.getDescription()!=null) {
             shipperfee.setDescription(shipperfeeForm.getDescription()+"%");
          } else {
              shipperfee.setDescription("%");
          }
      }
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectAll(shipperfee);      
      return retVals;
   }

   public static List findAllAI (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      
      if (shipperfeeForm==null) {
          shipperfee.setDescription("%");
      } else {
          if (shipperfeeForm.getDescription()!=null) {
             shipperfee.setDescription(shipperfeeForm.getDescription()+"%");
          } else {
              shipperfee.setDescription("%");
          }
      }
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectByAI(shipperfee);      
      return retVals;
   }
   
   public static List findAllByType (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      BeanUtils.copyProperties(shipperfee, shipperfeeForm);
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectByType(shipperfee);      
      return retVals;
   }

   public static List findAllAO (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      
      if (shipperfeeForm==null) {
          shipperfee.setDescription("%");
      } else {
          if (shipperfeeForm.getDescription()!=null) {
             shipperfee.setDescription(shipperfeeForm.getDescription()+"%");
          } else {
              shipperfee.setDescription("%");
          }
      }
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectByAO(shipperfee);      
      return retVals;
   }
   
   public static List findAllSI (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      
      if (shipperfeeForm==null) {
          shipperfee.setDescription("%");
      } else {
          if (shipperfeeForm.getDescription()!=null) {
             shipperfee.setDescription(shipperfeeForm.getDescription()+"%");
          } else {
              shipperfee.setDescription("%");
          }
      }
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectBySI(shipperfee);      
      return retVals;
   }
   
   public static List findAllSO (ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      Shipperfee shipperfee = new Shipperfee();  
      
      if (shipperfeeForm==null) {
          shipperfee.setDescription("%");
      } else {
          if (shipperfeeForm.getDescription()!=null) {
             shipperfee.setDescription(shipperfeeForm.getDescription()+"%");
          } else {
              shipperfee.setDescription("%");
          }
      }
      
      ShipperfeeDAO shipperfeeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      shipperfeeDAO = (ShipperfeeDAO)daoMgr.getDao(ShipperfeeDAO.class);      
      retVals = shipperfeeDAO.selectBySO(shipperfee);      
      return retVals;
   }
   
   /**
    * Retrieve a set of existing com.wings.web.struts.ShipperfeeForm objects for editing.
    *
    * @param   shipperfeeForm   The com.wings.web.struts.ShipperfeeForm object containing the data used to retrieve the objects (i.e. the criteria for the retrieval).
    * @exception   Exception   If the com.wings.web.struts.ShipperfeeForm objects cannot be retrieved.
    */
   public static List select (com.wings.web.struts.forms.ShipperfeeForm shipperfeeForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
