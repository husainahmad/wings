package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.ShippinglineDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Shippingline;
import com.wings.persistence.ShippinglineKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsShippinglineDelegate {


   public static com.wings.web.struts.forms.ShippinglineForm create (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
	   Shippingline shippingline = new Shippingline();  
	   BeanUtils.copyProperties(shippingline , shippinglineForm);
	   ShippinglineDAO shippinglineDAO;
	   DaoManager daoMgr = DaoConfig.getDaoManager();   
	   shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);      
	   shippinglineDAO.insert(shippingline);	
           return shippinglineForm;
   }

   public static com.wings.web.struts.forms.ShippinglineForm update (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
           Shippingline shippingline = new Shippingline();  
	   BeanUtils.copyProperties(shippingline , shippinglineForm);
	   ShippinglineDAO shippinglineDAO;
	   DaoManager daoMgr = DaoConfig.getDaoManager();   
	   shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);      
           shippinglineDAO.updateByPrimaryKey(shippingline);
           return shippinglineForm;
   }

   public static com.wings.web.struts.forms.ShippinglineForm edit (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
           ShippinglineKey shippinglineKey = new ShippinglineKey();
           shippinglineKey.setIdShippingLine(shippinglineForm.getIdShippingLine());
	   ShippinglineDAO shippinglineDAO;
	   DaoManager daoMgr = DaoConfig.getDaoManager();   
	   shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);
           Shippingline shippingline = shippinglineDAO.selectByPrimaryKey(shippinglineKey);
           BeanUtils.copyProperties(shippinglineForm, shippingline);
           return shippinglineForm;
   }

   public static void remove (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
           ShippinglineKey shippinglineKey = new ShippinglineKey();
           shippinglineKey.setIdShippingLine(shippinglineForm.getIdShippingLine());
	   ShippinglineDAO shippinglineDAO;
	   DaoManager daoMgr = DaoConfig.getDaoManager();   
	   shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);      
           shippinglineDAO.deleteByPrimaryKey(shippinglineKey);
   }

   public static List findAll () throws Exception {
          List retVals = new ArrayList();      
          ShippinglineDAO shippinglineDAO;
          DaoManager daoMgr = DaoConfig.getDaoManager();   
          shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);      
          retVals = shippinglineDAO.getListOfShipping();
          return retVals;
   }

   public static List findByName (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
          List retVals = new ArrayList();
          ShippinglineDAO shippinglineDAO;
          Shippingline shippingline = new Shippingline();
          shippingline.setName(shippinglineForm.getName());
	  BeanUtils.copyProperties(shippingline , shippinglineForm);
          DaoManager daoMgr = DaoConfig.getDaoManager();
          shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);
          retVals = shippinglineDAO.getListOfShippingByName(shippingline);
          return retVals;
   }

   public static List select (com.wings.web.struts.forms.ShippinglineForm shippinglineForm) throws Exception {
          List retVals = new ArrayList();
          ShippinglineDAO shippinglineDAO;
          DaoManager daoMgr = DaoConfig.getDaoManager();
          shippinglineDAO = (ShippinglineDAO)daoMgr.getDao(ShippinglineDAO.class);
          retVals = shippinglineDAO.getListOfShipping();
          return retVals;
   }

}
