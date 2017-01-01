



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.InvoicekreditDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Invoicekredit;
import com.wings.persistence.InvoicekreditKey;
import java.util.List;
import java.util.ArrayList;

public class StrutsInvoiceKreditDelegate {

   public static Invoicekredit create (Invoicekredit invoiceKredit) throws Exception {
      InvoicekreditDAO invoicekreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoicekreditDAO = (InvoicekreditDAO)daoMgr.getDao(InvoicekreditDAO.class);      
      invoicekreditDAO.insert(invoiceKredit);
      return invoiceKredit;
   }
  
   public static Invoicekredit update (Invoicekredit invoiceKredit) throws Exception {
      InvoicekreditDAO invoicekreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoicekreditDAO = (InvoicekreditDAO)daoMgr.getDao(InvoicekreditDAO.class);      
      invoicekreditDAO.updateByPrimaryKey(invoiceKredit);
      return invoiceKredit;
   }
   
   public static void remove (InvoicekreditKey invoiceKreditKey) throws Exception {
      InvoicekreditDAO invoicekreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoicekreditDAO = (InvoicekreditDAO)daoMgr.getDao(InvoicekreditDAO.class);      
      invoicekreditDAO.deleteByPrimaryKey(invoiceKreditKey);
   }

   public static void removeByIdInvoice (Invoicekredit invoicekredit) throws Exception {
      InvoicekreditDAO invoicekreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoicekreditDAO = (InvoicekreditDAO)daoMgr.getDao(InvoicekreditDAO.class);      
      invoicekreditDAO.deleteByIdInvoice(invoicekredit);
   }   
  
   public static List findAllByIdInvoice (Invoicekredit invoicekredit) throws Exception {
      List retVals = new ArrayList();
      InvoicekreditDAO invoicekreditDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoicekreditDAO = (InvoicekreditDAO)daoMgr.getDao(InvoicekreditDAO.class);    
      retVals = invoicekreditDAO.selectByIdInvoice(invoicekredit);
      return retVals;
   }

}
