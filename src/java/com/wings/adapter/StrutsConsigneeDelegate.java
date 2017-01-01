
package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.ConsigneeDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Consignee;
import com.wings.persistence.ConsigneeKey;
import com.wings.web.struts.forms.ConsigneeForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsConsigneeDelegate {
    
   public static List getConsigneeByName(String name) {
        List retVals = new ArrayList();
        Consignee consignee = new Consignee();  
        consignee.setName(name);
        ConsigneeDAO consigneeDAO;
        DaoManager daoMgr = DaoConfig.getDaoManager();   
        consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
        retVals = consigneeDAO.selectByConsigneeByName(consignee);
        return retVals;
   }
 
   
   public static com.wings.web.struts.forms.ConsigneeForm create (com.wings.web.struts.forms.ConsigneeForm consigneeForm) throws Exception {
      Consignee consignee = new Consignee();  
      BeanUtils.copyProperties(consignee, consigneeForm);
      consignee.setIdConsignee(consignee.getIdConsignee().replaceAll("&",""));
      ConsigneeDAO consigneeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
      consigneeDAO.insert(consignee);
      return consigneeForm;
   }

   /**
    * Update (i.e. persist) an existing com.wings.web.struts.ConsigneeForm object.
    *
    * @param   consigneeForm   The com.wings.web.struts.ConsigneeForm object containing the data to be updated
    * @exception   Exception   If the com.wings.web.struts.ConsigneeForm object cannot be updated/persisted.
    */
   public static com.wings.web.struts.forms.ConsigneeForm update (com.wings.web.struts.forms.ConsigneeForm consigneeForm) throws Exception {
      Consignee consignee = new Consignee();  
      BeanUtils.copyProperties(consignee, consigneeForm);
      ConsigneeDAO consigneeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
      consigneeDAO.updateByPrimaryKey(consignee);
      return consigneeForm;
   }

   /**
    * Retrieve an existing com.wings.web.struts.ConsigneeForm object for editing.
    *
    * @param   consigneeForm   The com.wings.web.struts.ConsigneeForm object containing the data used to retrieve the object (i.e. the primary key info).
    * @exception   Exception   If the com.wings.web.struts.ConsigneeForm object cannot be retrieved.
    */
   public static com.wings.web.struts.forms.ConsigneeForm edit (com.wings.web.struts.forms.ConsigneeForm consigneeForm) throws Exception {
      ConsigneeKey consigneeKey = new ConsigneeKey();  
      consigneeKey.setIdConsignee(consigneeForm.getIdConsignee());
      ConsigneeDAO consigneeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
      Consignee consignee = consigneeDAO.selectByPrimaryKey(consigneeKey);
      
      try {
          BeanUtils.copyProperties(consigneeForm, consignee);
      } catch (Exception e) {
          
      }   
      
      return consigneeForm;
   }

   /**
    * Remove (delete) an existing com.wings.web.struts.ConsigneeForm object.
    *
    * @param   consigneeForm   The com.wings.web.struts.ConsigneeForm object containing the data to be deleted.
    * @exception   Exception   If the com.wings.web.struts.ConsigneeForm object cannot be removed.
    */  
   public static void remove (com.wings.web.struts.forms.ConsigneeForm consigneeForm) throws Exception {
      ConsigneeKey consigneeKey = new ConsigneeKey();  
      consigneeKey.setIdConsignee(consigneeForm.getIdConsignee());
      ConsigneeDAO consigneeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
      consigneeDAO.deleteByPrimaryKey(consigneeKey);
   }

   /**
    * Retrieve all existing com.wings.web.struts.ConsigneeForm objects.
    *
    * @exception   Exception   If the com.wings.web.struts.ConsigneeForm objects cannot be retrieved.
    */
   public static List findAll (ConsigneeForm consigneeForm) throws Exception {
      List retVals = new ArrayList();     
      Consignee consignee = new Consignee();
      if (consigneeForm!=null) {
          if (consigneeForm.getName()!=null) {
              consignee.setName(consigneeForm.getName()+"%");
          } else {
              consignee.setName("%");
          }
      } else {
          consignee.setName("%");
      }
      ConsigneeDAO consigneeDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      consigneeDAO = (ConsigneeDAO)daoMgr.getDao(ConsigneeDAO.class);      
      retVals = consigneeDAO.selectAll(consignee);
      return retVals;
   }

   /**
    * Retrieve a set of existing com.wings.web.struts.ConsigneeForm objects for editing.
    *
    * @param   consigneeForm   The com.wings.web.struts.ConsigneeForm object containing the data used to retrieve the objects (i.e. the criteria for the retrieval).
    * @exception   Exception   If the com.wings.web.struts.ConsigneeForm objects cannot be retrieved.
    */
   public static List select (com.wings.web.struts.forms.ConsigneeForm consigneeForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
