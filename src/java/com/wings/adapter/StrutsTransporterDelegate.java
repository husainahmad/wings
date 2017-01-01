package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.TransporterDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Transporter;
import com.wings.persistence.TransporterKey;
import com.wings.web.struts.forms.TransporterForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsTransporterDelegate {


  
   public static com.wings.web.struts.forms.TransporterForm create (com.wings.web.struts.forms.TransporterForm transporterForm) throws Exception {
      Transporter transporter = new Transporter();  
      BeanUtils.copyProperties(transporter, transporterForm);
      transporter.setIdTransporter(transporter.getIdTransporter().replaceAll("&",""));
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      transporterDAO.insert(transporter); 
      return transporterForm;
   }

   
   public static com.wings.web.struts.forms.TransporterForm update (com.wings.web.struts.forms.TransporterForm transporterForm) throws Exception {
      Transporter transporter = new Transporter();  
      BeanUtils.copyProperties(transporter, transporterForm);
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      transporterDAO.updateByPrimaryKey(transporter); 
      return transporterForm;
   }

   
   public static com.wings.web.struts.forms.TransporterForm edit (com.wings.web.struts.forms.TransporterForm transporterForm) throws Exception {
      TransporterKey transporterKey = new TransporterKey();  
      transporterKey.setIdTransporter(transporterForm.getIdTransporter());      
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      Transporter transporter = transporterDAO.selectByPrimaryKey(transporterKey); 
      try {
          BeanUtils.copyProperties(transporterForm, transporter);
      } catch (Exception e) {
          
      }   
      
      return transporterForm;
   }

  
   public static void remove (com.wings.web.struts.forms.TransporterForm transporterForm) throws Exception {
     TransporterKey transporterKey = new TransporterKey();  
      transporterKey.setIdTransporter(transporterForm.getIdTransporter());      
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      transporterDAO.deleteByPrimaryKey(transporterKey); 
   }

   
   public static List findAll (TransporterForm transporterForm) throws Exception {
      List retVals = new ArrayList();
      Transporter transporter = new Transporter();
      if (transporterForm!=null) {
          if (transporterForm.getName()!=null) {
              transporter.setName(transporterForm.getName()+"%");
          } else {
              transporter.setName("%");
          }
      } else {
          transporter.setName("%");
      }
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      retVals = transporterDAO.selectByAll(transporter); 
      return retVals;
   }

   public static List findByName (String name) throws Exception {
      List retVals = new ArrayList();
      Transporter transporter = new Transporter();
      transporter.setName(name);
      TransporterDAO transporterDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transporterDAO = (TransporterDAO)daoMgr.getDao(TransporterDAO.class);      
      retVals = transporterDAO.selectByName(transporter); 
      return retVals;
   }

   
   public static List select (com.wings.web.struts.forms.TransporterForm transporterForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
