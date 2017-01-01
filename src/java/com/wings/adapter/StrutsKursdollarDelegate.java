



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.KursdollarDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Kursdollar;
import com.wings.persistence.KursdollarKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsKursdollarDelegate {


   public static com.wings.web.struts.forms.KursdollarForm create (com.wings.web.struts.forms.KursdollarForm kursdollarForm) throws Exception {
      Kursdollar kursdollar = new Kursdollar();
      BeanUtils.copyProperties(kursdollar, kursdollarForm);
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      kursdollarDAO.insert(kursdollar);
      return kursdollarForm;
   }

   public static com.wings.web.struts.forms.KursdollarForm update (com.wings.web.struts.forms.KursdollarForm kursdollarForm) throws Exception {
      Kursdollar kursdollar = new Kursdollar();
      BeanUtils.copyProperties(kursdollar, kursdollarForm);
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      kursdollarDAO.updateByPrimaryKey(kursdollar); 
      return kursdollarForm;
   }

   
   public static com.wings.web.struts.forms.KursdollarForm edit (com.wings.web.struts.forms.KursdollarForm kursdollarForm) throws Exception {
      KursdollarKey kursdollarKey = new KursdollarKey();
      BeanUtils.copyProperties(kursdollarKey, kursdollarForm);
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      Kursdollar kursdollar = kursdollarDAO.selectByPrimaryKey(kursdollarKey);
      BeanUtils.copyProperties(kursdollarForm, kursdollar);
      return kursdollarForm;
   }

     
   public static void remove (com.wings.web.struts.forms.KursdollarForm kursdollarForm) throws Exception {
      KursdollarKey kursdollarKey = new KursdollarKey();
      BeanUtils.copyProperties(kursdollarKey, kursdollarForm);
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      kursdollarDAO.deleteByPrimaryKey(kursdollarKey);
   }

   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();      
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      retVals = kursdollarDAO.selectByAll();
      return retVals;
   }

   
   public static com.wings.web.struts.forms.KursdollarForm selectLastKurs () throws Exception {
      KursdollarDAO kursdollarDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      kursdollarDAO = (KursdollarDAO)daoMgr.getDao(KursdollarDAO.class);      
      Kursdollar kursdollar = kursdollarDAO.selectByLastKurs();
      com.wings.web.struts.forms.KursdollarForm kursdollarForm = new com.wings.web.struts.forms.KursdollarForm();
      kursdollarForm.setValue(kursdollar.getValue());
      //BeanUtils.copyProperties(kursdollarForm, kursdollar);
      return kursdollarForm;
   }

}
