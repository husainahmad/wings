package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.CashonhandDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Cashonhand;
import com.wings.web.struts.forms.CashonhandForm;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsCashonhandDelegate {


   public static CashonhandForm create (CashonhandForm cashonhandForm) throws Exception {
      Cashonhand cashonhand = new Cashonhand();        
      BeanUtils.copyProperties(cashonhand, cashonhandForm);
      CashonhandDAO cashonhandDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      cashonhandDAO = (CashonhandDAO)daoMgr.getDao(CashonhandDAO.class);      
      cashonhandDAO.insert(cashonhand);
      BeanUtils.copyProperties(cashonhandForm, cashonhand);
      return cashonhandForm;
   }

   public static CashonhandForm update (CashonhandForm cashonhandForm) throws Exception {
      Cashonhand cashonhand = new Cashonhand();        
      BeanUtils.copyProperties(cashonhand, cashonhandForm);
      CashonhandDAO cashonhandDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      cashonhandDAO = (CashonhandDAO)daoMgr.getDao(CashonhandDAO.class);      
      cashonhandDAO.updateByPrimaryKey(cashonhand);
      BeanUtils.copyProperties(cashonhandForm, cashonhand);
      return cashonhandForm;
   }

   public static CashonhandForm edit (CashonhandForm cashonhandForm) throws Exception {
      Cashonhand cashonhand = new Cashonhand();        
      cashonhand.setIdCashOnHand(cashonhandForm.getIdCashOnHand());
      CashonhandDAO cashonhandDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      cashonhandDAO = (CashonhandDAO)daoMgr.getDao(CashonhandDAO.class);      
      cashonhand = cashonhandDAO.selectByPrimaryKey(cashonhand.getIdCashOnHand());
      BeanUtils.copyProperties(cashonhandForm, cashonhand);
      return cashonhandForm;
   }

   public static void remove (CashonhandForm cashonhandForm) throws Exception {
      Cashonhand cashonhand = new Cashonhand();        
      cashonhand.setIdCashOnHand(cashonhandForm.getIdCashOnHand());
      CashonhandDAO cashonhandDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      cashonhandDAO = (CashonhandDAO)daoMgr.getDao(CashonhandDAO.class);      
      cashonhandDAO.deleteByPrimaryKey(cashonhand.getIdCashOnHand());
   }

   public static List findAll () throws Exception {
      List retVals = new ArrayList();            
      CashonhandDAO cashonhandDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      cashonhandDAO = (CashonhandDAO)daoMgr.getDao(CashonhandDAO.class);      
      retVals = cashonhandDAO.selectAll();
      return retVals;
   }

   public static List select (CashonhandForm cashonhandForm) throws Exception {
      List retVals = new ArrayList();
      return retVals;
   }

}
