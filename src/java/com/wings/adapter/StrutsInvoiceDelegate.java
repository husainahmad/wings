



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.InvoiceDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Invoice;
import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;


public class StrutsInvoiceDelegate {


  
   public static com.wings.web.struts.forms.InvoiceForm create (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.insert(invoice); 
      return invoiceForm;
   }

  
   public static com.wings.web.struts.forms.InvoiceForm update (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.updateByPrimaryKey(invoice); 
      return invoiceForm;
   }

   public static com.wings.web.struts.forms.InvoiceForm editByJobsheet (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectByIdJobsheet(invoice);       
      try {
          if (invoice!=null) {
              BeanUtils.copyProperties(invoiceForm, invoice);
          }
      } catch (Exception e) {
          //invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm findByIdJobsheet (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectByIdJobsheet(invoice);       
      try {
          if (invoice!=null) {
              BeanUtils.copyProperties(invoiceForm, invoice);
          }
      } catch (Exception e) {
          //invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm selectMaxInvoiceNumber (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectMaxInvoiceNumber(invoice);       
      try {
          if (invoice!=null) {
              invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());              
          }
      } catch (Exception e) {          
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm selectMaxInvoiceNumberAI (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectMaxInvoiceNumberAI(invoice);       
      try {
          if (invoice!=null) {
              invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());              
          }
      } catch (Exception e) {          
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm selectMaxInvoiceNumberAO (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectMaxInvoiceNumberAO(invoice);       
      try {
          if (invoice!=null) {
              invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());              
          }
      } catch (Exception e) {          
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm selectMaxInvoiceNumberSI (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectMaxInvoiceNumberSI(invoice);       
      try {
          if (invoice!=null) {
              invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());              
          }
      } catch (Exception e) {          
      }
      return invoiceForm;
   }
   
   public static com.wings.web.struts.forms.InvoiceForm selectMaxInvoiceNumberSO (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      invoice = invoiceDAO.selectMaxInvoiceNumberSO(invoice);       
      try {
          if (invoice!=null) {
              invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());              
          }
      } catch (Exception e) {          
      }
      return invoiceForm;
   }
   
   public static List selectMaxInvoiceNumberAIList (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      List retVals = new ArrayList();
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      retVals = invoiceDAO.selectMaxInvoiceNumberAIList(invoice);             
      return retVals;
   }
   
   public static List selectMaxInvoiceNumberAOList (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      List retVals = new ArrayList();
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      retVals = invoiceDAO.selectMaxInvoiceNumberAOList(invoice);             
      return retVals;
   }
   
   public static List selectMaxInvoiceNumberSIList (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      List retVals = new ArrayList();
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      retVals = invoiceDAO.selectMaxInvoiceNumberSIList(invoice);             
      return retVals;
   }
   
   public static List selectMaxInvoiceNumberSOList (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      List retVals = new ArrayList();
      Invoice invoice = new Invoice();  
      BeanUtils.copyProperties(invoice, invoiceForm);
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);            
      retVals = invoiceDAO.selectMaxInvoiceNumberSOList(invoice);             
      return retVals;
   }
   
   public static Invoice updatePayableStatus (Invoice invoice) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.updatePayableByPrimaryKey(invoice); 
      return invoice;
   }

   public static Invoice updatePayableStatusByInvoiceNumber (Invoice invoice) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.updatePayableByInvoiceNumber(invoice); 
      return invoice;
   }

   public static com.wings.web.struts.forms.InvoiceForm edit (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      InvoiceKey invoiceKey = new InvoiceKey();  
      invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      Invoice invoice = invoiceDAO.selectByPrimaryKey(invoiceKey); 
      
      try {
          //BeanUtils.copyProperties(invoiceForm, invoice);
          invoiceForm.setIdJobSheet(invoice.getIdJobSheet());
          invoiceForm.setInvoiceDate(new java.sql.Date(invoice.getInvoiceDate().getTime()));
          invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());
          invoiceForm.setIdInvoice(invoice.getIdInvoice());
          
      } catch (Exception e) {
          invoiceForm.setInvoiceNumber(invoice.getInvoiceNumber());
      }
      return invoiceForm;
   }
    
   public static String selectJobTypeByInvoiceKey (InvoiceKey invoiceKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      String jobType = invoiceDAO.selectJobTypeByPrimaryKey(invoiceKey);       
      return jobType;
   }
   
   public static InvoiceAIDetail selectInvoiceAIDetailByInvoiceKey (InvoiceKey invoiceKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      InvoiceAIDetail invoiceAIDetail = invoiceDAO.selectJobAIDetailByPrimaryKey(invoiceKey);       
      return invoiceAIDetail;
   }
   
    public static InvoiceAODetail selectInvoiceAODetailByInvoiceKey (InvoiceKey invoiceKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      InvoiceAODetail invoiceAODetail = invoiceDAO.selectJobAODetailByPrimaryKey(invoiceKey);       
      return invoiceAODetail;
   }
    
   public static InvoiceSIDetail selectInvoiceSIDetailByInvoiceKey (InvoiceKey invoiceKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      InvoiceSIDetail invoiceSIDetail = invoiceDAO.selectJobSIDetailByPrimaryKey(invoiceKey);       
      return invoiceSIDetail;
   }
   
   public static InvoiceSODetail selectInvoiceSODetailByInvoiceKey (InvoiceKey invoiceKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      InvoiceSODetail invoiceSODetail = invoiceDAO.selectJobSODetailByPrimaryKey(invoiceKey);       
      return invoiceSODetail;
   }
   
   public static void remove (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      InvoiceKey invoiceKey = new InvoiceKey();  
      invoiceKey.setIdInvoice(invoiceForm.getIdInvoice());
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.deleteByPrimaryKey(invoiceKey); 
   }

   public static void removeByIdJobsheet (JobsheetKey jobsheetKey) throws Exception {      
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      invoiceDAO.deleteByIdJobsheet(jobsheetKey); 
   }

  
   public static List findAll (com.wings.web.struts.forms.MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      InvoiceDAO invoiceDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      invoiceDAO = (InvoiceDAO)daoMgr.getDao(InvoiceDAO.class);      
      retVals = invoiceDAO.selectByAll(monthYearForm); 
      return retVals;
   }

  
   public static List select (com.wings.web.struts.forms.InvoiceForm invoiceForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
