



 


package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.TaxDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Tax;
import com.wings.persistence.TaxKey;
import com.wings.web.struts.forms.MonthYearForm;
import com.wings.web.struts.forms.TaxForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsTaxDelegate {
    
   private static final DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

   public static TaxForm create (TaxForm taxForm) throws Exception {
      Tax tax = new Tax();
      BeanUtils.copyProperties(tax, taxForm);
      TaxDAO taxDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      taxDAO = (TaxDAO)daoMgr.getDao(TaxDAO.class);    
      taxDAO.insert(tax);
      return taxForm;
   }


   public static TaxForm update (TaxForm taxForm) throws Exception {
      Tax tax = new Tax();
      BeanUtils.copyProperties(tax, taxForm);
      TaxDAO taxDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      taxDAO = (TaxDAO)daoMgr.getDao(TaxDAO.class);    
      taxDAO.updateByPrimaryKey(tax);
      return taxForm;
   }


   public static TaxForm edit (TaxForm taxForm) throws Exception {
      TaxKey taxKey = new TaxKey();
      taxKey.setIdTax(taxForm.getIdTax());
      TaxDAO taxDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      taxDAO = (TaxDAO)daoMgr.getDao(TaxDAO.class);    
      Tax tax = taxDAO.selectByPrimaryKey(taxKey);
      
      try {
          taxForm.setIdJobSheet(tax.getIdJobSheet());
          taxForm.setNoFaktur(tax.getNoFaktur());
          taxForm.setPpn(tax.getPpn());
          taxForm.setDpp(tax.getDpp());
          try {
              taxForm.setFakturDateAsString(formatDate.format(tax.getFakturDate()));          
          } catch (Exception ex) {
              taxForm.setFakturDateAsString(formatDate.format(new Date()));          
          }
      } catch (Exception e) {           
          System.out.println(e);
      }
      
      return taxForm;
   }


   public static void remove (TaxForm taxForm) throws Exception {
      TaxKey taxKey = new TaxKey();
      taxKey.setIdTax(taxForm.getIdTax());
      TaxDAO taxDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      taxDAO = (TaxDAO)daoMgr.getDao(TaxDAO.class);    
      taxDAO.deleteByPrimaryKey(taxKey);
   }


   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }


   public static List selectByMonthYearForm (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      TaxDAO taxDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      taxDAO = (TaxDAO)daoMgr.getDao(TaxDAO.class);    
      retVals = (List)taxDAO.selectMonthly(monthYearForm);
      return retVals;
   }

}
