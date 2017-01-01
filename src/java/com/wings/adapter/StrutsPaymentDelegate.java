package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.PaymentDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Payment;
import com.wings.web.struts.forms.DateSelection;
import com.wings.web.struts.forms.PaymentForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsPaymentDelegate {
   
   public static PaymentForm create (PaymentForm paymentForm) throws Exception {      
      Payment payment = new Payment();  
      BeanUtils.copyProperties(payment, paymentForm);      
      PaymentDAO paymentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      paymentDAO = (PaymentDAO)daoMgr.getDao(PaymentDAO.class);      
      paymentDAO.insert(payment);      
      return paymentForm;
   }

   public static PaymentForm update (PaymentForm paymentForm) throws Exception {
      return paymentForm;
   }
  
   public static PaymentForm edit (PaymentForm paymentForm) throws Exception {
      return paymentForm;
   }
   
   public static void remove (PaymentForm paymentForm) throws Exception {      
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();      
      return retVals;
   }
   
   public static List select (PaymentForm paymentForm) throws Exception {
      List retVals = new ArrayList();      
      return retVals;
   }
   
   public static List selectPayableCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();  
      PaymentDAO paymentDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      paymentDAO = (PaymentDAO)daoMgr.getDao(PaymentDAO.class);      
      retVals = (List)paymentDAO.selectPayableCustomer(dateSelection);
      return retVals;
   }
   
}
