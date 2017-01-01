package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.TransactionaccDAO;
import com.wings.dao.TransactionaccdetailDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.TransactionaccKey;
import com.wings.persistence.Transactionaccdetail;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsTransactionaccDetailDelegate {

   public static com.wings.web.struts.forms.TransactionaccDetailForm create (com.wings.web.struts.forms.TransactionaccDetailForm transactionaccdetailForm) throws Exception {
      Transactionaccdetail transactionaccdetail = new Transactionaccdetail();  
      BeanUtils.copyProperties(transactionaccdetail, transactionaccdetailForm);
      TransactionaccdetailDAO TransactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      TransactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccdetailDAO.class);      
      TransactionaccdetailDAO.insert(transactionaccdetail);
      return transactionaccdetailForm;
   }  
   
   public static com.wings.web.struts.forms.TransactionaccDetailForm update (com.wings.web.struts.forms.TransactionaccDetailForm transactionaccdetailForm) throws Exception {
      Transactionaccdetail transactionaccdetail = new Transactionaccdetail();  
      BeanUtils.copyProperties(transactionaccdetail, transactionaccdetailForm);
      TransactionaccdetailDAO TransactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      TransactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccdetailDAO.class);      
      TransactionaccdetailDAO.updateByPrimaryKey(transactionaccdetail);
      return transactionaccdetailForm;
   }

   public static com.wings.web.struts.forms.TransactionaccDetailForm edit (com.wings.web.struts.forms.TransactionaccDetailForm transactionaccdetailForm) throws Exception {
      DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
      Transactionaccdetail transactionaccdetail = new Transactionaccdetail();  
      BeanUtils.copyProperties(transactionaccdetail, transactionaccdetailForm);
      TransactionaccdetailDAO TransactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      TransactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccdetailDAO.class);      
      transactionaccdetail =  TransactionaccdetailDAO.selectByPrimaryKey(transactionaccdetail);
      try {
            transactionaccdetailForm.setIdAccount(transactionaccdetail.getIdAccount());
            transactionaccdetailForm.setIdTransactionAcc(transactionaccdetail.getIdTransactionAcc());
            transactionaccdetailForm.setNoBatch(transactionaccdetail.getNoBatch());
            transactionaccdetailForm.setBatchDesc(transactionaccdetail.getBatchDesc());            
            transactionaccdetailForm.setDescription(transactionaccdetail.getDescription());
            transactionaccdetailForm.setDebit(transactionaccdetail.getDebit());
            transactionaccdetailForm.setKredit(transactionaccdetail.getKredit());
            transactionaccdetailForm.setKurs(transactionaccdetail.getKurs());
            transactionaccdetailForm.setVoucherDesc(transactionaccdetail.getVoucherDesc());
            transactionaccdetailForm.setNoVoucher(transactionaccdetail.getNoVoucher());
            transactionaccdetailForm.setNoUrut(transactionaccdetail.getNoUrut());
            transactionaccdetailForm.setTransactionDateAsString(formatDate.format(transactionaccdetail.getTransactionDate()));
            transactionaccdetailForm.setTglTutupBukuAsString(formatDate.format(transactionaccdetail.getTglTutupBuku()));
            transactionaccdetailForm.setGroupid(transactionaccdetail.getGroupid());                        
      } catch (Exception e) {          
      }      
      return transactionaccdetailForm;
   }

   public static void remove (com.wings.web.struts.forms.TransactionaccDetailForm TransactionaccDetailForm) throws Exception {
      Transactionaccdetail transactionacKey = new Transactionaccdetail();  
      BeanUtils.copyProperties(transactionacKey, TransactionaccDetailForm);
      TransactionaccdetailDAO TransactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      TransactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccdetailDAO.class);      
      TransactionaccdetailDAO.deleteByPrimaryKey(transactionacKey);
   }

   public static void removeByJobNo (com.wings.web.struts.forms.TransactionaccDetailForm TransactionaccDetailForm) throws Exception {
      Transactionaccdetail transactionac = new Transactionaccdetail();  
      BeanUtils.copyProperties(transactionac, TransactionaccDetailForm);
      TransactionaccdetailDAO TransactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      TransactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccdetailDAO.class);      
      TransactionaccdetailDAO.deleteByJobNo(transactionac);
   }
   
   public static List selectByTransactionAccKey (TransactionaccKey key) throws Exception {
      List retVals = new ArrayList();      
      TransactionaccdetailDAO transactionaccdetailDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      transactionaccdetailDAO = (TransactionaccdetailDAO)daoMgr.getDao(TransactionaccDAO.class);      
      retVals = transactionaccdetailDAO.selectByTransactionAccKey(key);
      return retVals;
   }   
}
