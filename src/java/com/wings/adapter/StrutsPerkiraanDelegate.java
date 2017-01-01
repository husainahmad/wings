



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.PerkiraanDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Perkiraan;
import com.wings.persistence.PerkiraanKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

/**
 * This is a delegate class to handle interaction with the backend persistence layer of cmp20. 
 * It has a set of methods to handle persistence for Perkiraan data (i.e. 
 * com.wings.web.struts.PerkiraanForm objects).
 * 
 * @author <strong>Generated by Middlegen.</strong>
 */
public class StrutsPerkiraanDelegate {


   /**
    * Create a new com.wings.web.struts.PerkiraanForm object and persist (i.e. insert) it.
    *
    * @param   perkiraanForm   The object containing the data for the new com.wings.web.struts.PerkiraanForm object
    * @exception   Exception   If the new com.wings.web.struts.PerkiraanForm object cannot be created or persisted.
    */
   public static com.wings.web.struts.forms.PerkiraanForm create (com.wings.web.struts.forms.PerkiraanForm perkiraanForm) throws Exception {
      Perkiraan perkiraan = new Perkiraan();  
      BeanUtils.copyProperties(perkiraan, perkiraanForm);
      PerkiraanDAO perkiraanDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      perkiraanDAO = (PerkiraanDAO)daoMgr.getDao(PerkiraanDAO.class);      
      perkiraanDAO.insert(perkiraan);
      return perkiraanForm;
   }

   /**
    * Update (i.e. persist) an existing com.wings.web.struts.PerkiraanForm object.
    *
    * @param   perkiraanForm   The com.wings.web.struts.PerkiraanForm object containing the data to be updated
    * @exception   Exception   If the com.wings.web.struts.PerkiraanForm object cannot be updated/persisted.
    */
   public static com.wings.web.struts.forms.PerkiraanForm update (com.wings.web.struts.forms.PerkiraanForm perkiraanForm) throws Exception {
      Perkiraan perkiraan = new Perkiraan();  
      BeanUtils.copyProperties(perkiraan, perkiraanForm);
      PerkiraanDAO perkiraanDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      perkiraanDAO = (PerkiraanDAO)daoMgr.getDao(PerkiraanDAO.class);      
      perkiraanDAO.updateByPrimaryKey(perkiraan);
      return perkiraanForm;
   }

   /**
    * Retrieve an existing com.wings.web.struts.PerkiraanForm object for editing.
    *
    * @param   perkiraanForm   The com.wings.web.struts.PerkiraanForm object containing the data used to retrieve the object (i.e. the primary key info).
    * @exception   Exception   If the com.wings.web.struts.PerkiraanForm object cannot be retrieved.
    */
   public static com.wings.web.struts.forms.PerkiraanForm edit (com.wings.web.struts.forms.PerkiraanForm perkiraanForm) throws Exception {
      PerkiraanKey perkiraanKey = new PerkiraanKey();  
      BeanUtils.copyProperties(perkiraanKey, perkiraanForm);
      PerkiraanDAO perkiraanDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      perkiraanDAO = (PerkiraanDAO)daoMgr.getDao(PerkiraanDAO.class);      
      perkiraanDAO.selectByPrimaryKey(perkiraanKey);
      BeanUtils.copyProperties(perkiraanForm, perkiraanKey);
      return perkiraanForm;
   }

   /**
    * Remove (delete) an existing com.wings.web.struts.PerkiraanForm object.
    *
    * @param   perkiraanForm   The com.wings.web.struts.PerkiraanForm object containing the data to be deleted.
    * @exception   Exception   If the com.wings.web.struts.PerkiraanForm object cannot be removed.
    */  
   public static void remove (com.wings.web.struts.forms.PerkiraanForm perkiraanForm) throws Exception {
      PerkiraanKey perkiraanKey = new PerkiraanKey();  
      BeanUtils.copyProperties(perkiraanKey, perkiraanForm);
      PerkiraanDAO perkiraanDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      perkiraanDAO = (PerkiraanDAO)daoMgr.getDao(PerkiraanDAO.class);      
      perkiraanDAO.deleteByPrimaryKey(perkiraanKey);
   }

   /**
    * Retrieve all existing com.wings.web.struts.PerkiraanForm objects.
    *
    * @exception   Exception   If the com.wings.web.struts.PerkiraanForm objects cannot be retrieved.
    */
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      PerkiraanDAO perkiraanDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      perkiraanDAO = (PerkiraanDAO)daoMgr.getDao(PerkiraanDAO.class);      
      retVals = (List)perkiraanDAO.selectByAll();
      return retVals;
   }

   /**
    * Retrieve a set of existing com.wings.web.struts.PerkiraanForm objects for editing.
    *
    * @param   perkiraanForm   The com.wings.web.struts.PerkiraanForm object containing the data used to retrieve the objects (i.e. the criteria for the retrieval).
    * @exception   Exception   If the com.wings.web.struts.PerkiraanForm objects cannot be retrieved.
    */
   public static List select (com.wings.web.struts.forms.PerkiraanForm perkiraanForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
