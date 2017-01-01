



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.TransactionaccDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Transactionacc;
import com.wings.persistence.TransactionaccKey;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.MonthYearForm;
import com.wings.web.struts.forms.TransactionaccForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

public class StrutsTransactionaccDelegate {


   public static com.wings.web.struts.forms.TransactionaccForm create (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      Transactionacc transactionac = new Transactionacc();  
      BeanUtils.copyProperties(transactionac, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      TransactionaccKey transactionKey = (TransactionaccKey) transactionaccDAO.insert(transactionac);
      transactionaccForm.setIdTransactionAcc(transactionKey.getIdTransactionAcc());
      return transactionaccForm;
   }

   public static Integer selectNoUrut (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      Transactionacc transactionac = new Transactionacc();  
      BeanUtils.copyProperties(transactionac, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      Integer inUrut = (Integer)transactionaccDAO.selectNoUrut(transactionac);
      return inUrut;
   }
   
   public static com.wings.web.struts.forms.TransactionaccForm update (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      Transactionacc transactionac = new Transactionacc();  
      BeanUtils.copyProperties(transactionac, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      transactionaccDAO.updateByPrimaryKey(transactionac);
      return transactionaccForm;
   }

   public static com.wings.web.struts.forms.TransactionaccForm edit (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
      TransactionaccKey transactionacKey = new TransactionaccKey();  
      BeanUtils.copyProperties(transactionacKey, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      Transactionacc transactionacc =  transactionaccDAO.selectByPrimaryKey(transactionacKey);
      try {
            transactionaccForm.setIdAccount(transactionacc.getIdAccount());
            transactionaccForm.setIdTransactionAcc(transactionacc.getIdTransactionAcc());
            transactionaccForm.setNoBatch(transactionacc.getNoBatch());
            transactionaccForm.setBatchDesc(transactionacc.getBatchDesc());            
            transactionaccForm.setDescription(transactionacc.getDescription());
            transactionaccForm.setDebit(transactionacc.getDebit());
            transactionaccForm.setKredit(transactionacc.getKredit());
            transactionaccForm.setKurs(transactionacc.getKurs());
            transactionaccForm.setVoucherDesc(transactionacc.getVoucherDesc());
            transactionaccForm.setNoVoucher(transactionacc.getNoVoucher());
            transactionaccForm.setNoUrut(transactionacc.getNoUrut());
            transactionaccForm.setTransactionDateAsString(formatDate.format(transactionacc.getTransactionDate()));
            transactionaccForm.setTglTutupBukuAsString(formatDate.format(transactionacc.getTglTutupBuku()));
            
            
      } catch (Exception e) {
          
      }
      
      return transactionaccForm;
   }

   public static void remove (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      TransactionaccKey transactionacKey = new TransactionaccKey();  
      BeanUtils.copyProperties(transactionacKey, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      transactionaccDAO.deleteByPrimaryKey(transactionacKey);
   }

   public static void removeByJobNo (com.wings.web.struts.forms.TransactionaccForm transactionaccForm) throws Exception {
      Transactionacc transactionac = new Transactionacc();  
      BeanUtils.copyProperties(transactionac, transactionaccForm);
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      transactionaccDAO.deleteByJobNo(transactionac);
   }

   public static void insertJobsheetTransaction(JobsheetForm jobsheetForm) throws Exception {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        ConsigneeForm consigneeForm = new ConsigneeForm();
        consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
        consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
        if (consigneeForm.getIdAccountIDR()!=null) {
             if (!consigneeForm.getIdAccountIDR().equalsIgnoreCase("")) {
                 if (jobsheetForm.getTotalBillingIDR().doubleValue()>0) {
                    transactionaccForm.setDebit(jobsheetForm.getTotalBillingIDR());
                    transactionaccForm.setKredit(new Double(0.0));
                    transactionaccForm.setIdAccount(consigneeForm.getIdAccountIDR());
                    transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                    transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                    transactionaccForm.setKurs("IDR");
                    transactionaccForm.setNoBatch("");
                    transactionaccForm.setBatchDesc("");

                    Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                    transactionaccForm.setInUrut(inUrut);
                    transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),3,"0"));

                    transactionaccForm.setDescription(jobsheetForm.getJobNo()+"-"+consigneeForm.getName()+" RP. " + String.valueOf(jobsheetForm.getTotalBillingIDR().doubleValue()));
                    transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                    transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm); 
                }          
            }   
             if (!consigneeForm.getIdAccountUSD().equalsIgnoreCase("")) {
                 if (jobsheetForm.getTotalBillingUSD().doubleValue()>0) {
                    transactionaccForm.setDebit(jobsheetForm.getTotalBillingUSD());
                    transactionaccForm.setKredit(new Double(0.0));
                    transactionaccForm.setIdAccount(consigneeForm.getIdAccountUSD());
                    transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                    transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                    transactionaccForm.setKurs("USD");
                    transactionaccForm.setNoBatch("");
                    transactionaccForm.setBatchDesc("");
                    transactionaccForm.setDescription(jobsheetForm.getJobNo()+"-"+consigneeForm.getName()+" $. " + String.valueOf(jobsheetForm.getTotalBillingUSD().doubleValue()));
                    transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                    Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                    transactionaccForm.setInUrut(inUrut);
                    transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),3,"0"));

                    transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm); 
                }          
            }   
        }
   }
   
   public static List findAll (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccDAO.selectByAll(monthYearForm);
      return retVals;
   }

    public static com.wings.web.struts.forms.TransactionaccForm selectTotalByDateAndBatchNo (MonthYearForm monthYearForm) throws Exception {        
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      Transactionacc transactionacc =  transactionaccDAO.selectTotalByDateAndBatchNo(monthYearForm);
      TransactionaccForm transactionaccForm = new TransactionaccForm();
      transactionaccForm.setDebit(transactionacc.getDebit());
      transactionaccForm.setKredit(transactionacc.getKredit());      
      return transactionaccForm;
   }

   public static List selectReportBB (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccDAO.selectReportBB(monthYearForm);
      return retVals;
   }

   public static List selectReportGL (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccDAO.selectReportGL(monthYearForm);
      return retVals;
   }

   public static List selectReportGLSaldo (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);
      retVals = transactionaccDAO.selectReportGLSaldo(monthYearForm);
      return retVals;
   }

   public static List selectReportRL (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccDAO.selectReportRL(monthYearForm);
      return retVals;
   }

   public static List selectReportNL (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccDAO transactionaccDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccDAO = (TransactionaccDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccDAO.selectReportNL(monthYearForm);
      return retVals;
   }   
}
