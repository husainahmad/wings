package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.DestinationDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Destination;
import com.wings.persistence.DestinationKey;
import com.wings.web.struts.forms.DestinationForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsDestinationDelegate {


   
   public static com.wings.web.struts.forms.DestinationForm create (com.wings.web.struts.forms.DestinationForm destinationForm) throws Exception {
      Destination destination = new Destination();  
      BeanUtils.copyProperties(destination, destinationForm);
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      destinationDAO.insert(destination); 
      return destinationForm;
   }

   
   public static com.wings.web.struts.forms.DestinationForm update (com.wings.web.struts.forms.DestinationForm destinationForm) throws Exception {
      Destination destination = new Destination();  
      BeanUtils.copyProperties(destination, destinationForm);
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      destinationDAO.updateByPrimaryKey(destination); 
      return destinationForm;
   }

  
   public static com.wings.web.struts.forms.DestinationForm edit (com.wings.web.struts.forms.DestinationForm destinationForm) throws Exception {
      DestinationKey destinationKey = new DestinationKey();  
      destinationKey.setIdDestination(destinationForm.getIdDestination());            
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      Destination destination = destinationDAO.selectByPrimaryKey(destinationKey); 
      try {
          BeanUtils.copyProperties(destinationForm, destination);
      } catch (Exception e) {
          
      }   
      
      return destinationForm;
   }

  
   public static void remove (com.wings.web.struts.forms.DestinationForm destinationForm) throws Exception {
      DestinationKey destinationKey = new DestinationKey();  
      destinationKey.setIdDestination(destinationForm.getIdDestination());            
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      destinationDAO.deleteByPrimaryKey(destinationKey); 
   }

   
   public static List findAll (DestinationForm destinationForm) throws Exception {
      List retVals = new ArrayList();
      Destination destination = new Destination();
      if (destinationForm!=null) {
          if (destinationForm.getName()!=null) {
              destination.setName(destinationForm.getName()+"%");
          } else {
              destination.setName("%");
          }
      } else {
          destination.setName("%");
      }
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      retVals = destinationDAO.selectByAll(destination); 
      return retVals;
   }

   public static List findByName (String name) throws Exception {
      List retVals = new ArrayList();
      Destination dest = new Destination();
      dest.setName(name);
      DestinationDAO destinationDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      destinationDAO = (DestinationDAO)daoMgr.getDao(DestinationDAO.class);      
      retVals = destinationDAO.selectByName(dest); 
      return retVals;
   }
   
   public static List select (com.wings.web.struts.forms.DestinationForm destinationForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
