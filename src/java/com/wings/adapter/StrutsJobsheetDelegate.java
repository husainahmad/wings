package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.JobsheetDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Consignee;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DateSelection;
import com.wings.web.struts.forms.MonthYearForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

public class StrutsJobsheetDelegate {
  
   public static com.wings.web.struts.forms.JobsheetForm create (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      jobsheet.setInvoiceNoUSD(jobsheetForm.getInvoiceNoUsd());
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      JobsheetKey jobsheetKey = (JobsheetKey)jobsheetDAO.insert(jobsheet);
      jobsheetForm.setIdJobSheet(jobsheetKey.getIdJobSheet());
      return jobsheetForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetForm update (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      jobsheet.setInvoiceNoUSD(jobsheetForm.getInvoiceNoUsd());
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.updateByPrimaryKey(jobsheet);
      return jobsheetForm;
   }

   public static com.wings.web.struts.forms.JobsheetForm updateDebitNoAndStatus (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      jobsheet.setInvoiceNoUSD(jobsheetForm.getInvoiceNoUsd());
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.updateDebitNoAndStatusByPrimaryKey(jobsheet);
      return jobsheetForm;
   }

   public static com.wings.web.struts.forms.JobsheetForm updateInvoiceNoAndStatus (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      jobsheet.setInvoiceNoUSD(jobsheetForm.getInvoiceNoUsd());
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.updateInvoiceNoAndStatusByPrimaryKey(jobsheet);
      return jobsheetForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetForm updateTaxVat (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.updateTaxVatByPrimaryKey(jobsheet);
      return jobsheetForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetForm updateStatus (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      Jobsheet jobsheet = new Jobsheet();  
      BeanUtils.copyProperties(jobsheet, jobsheetForm);
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.updateStatusByPrimaryKey(jobsheet);
      return jobsheetForm;
   }
   
   public static com.wings.web.struts.forms.JobsheetForm edit (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
      JobsheetKey jobsheetKey = new JobsheetKey();  
      jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());      
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      Jobsheet jobsheet = jobsheetDAO.selectByPrimaryKey(jobsheetKey);
      
      jobsheetForm.setIdJobSheet(jobsheet.getIdJobSheet());
      jobsheetForm.setIdAgent(jobsheet.getIdAgent());
      jobsheetForm.setIdConsignee(jobsheet.getIdConsignee());
      jobsheetForm.setIdJobType(jobsheet.getIdJobType());
      jobsheetForm.setIdShipper(jobsheet.getIdShipper());
      jobsheetForm.setIdForwarder(jobsheet.getIdForwarder());
      jobsheetForm.setInvoiceNoUsd(jobsheet.getInvoiceNoUSD());
      jobsheetForm.setDebitNo(jobsheet.getDebitNo());
      jobsheetForm.setInvoiceStatus(jobsheet.getInvoiceStatus());
      jobsheetForm.setJobNo(jobsheet.getJobNo());
      jobsheetForm.setQty(jobsheet.getQty());
      jobsheetForm.setQtyDesc(jobsheet.getQtyDesc());
      jobsheetForm.setRemark(jobsheet.getRemark());
      
      jobsheetForm.setShippeddateAsString(formatDate.format(jobsheet.getShippeddate()));
      jobsheetForm.setTotalBillingIDR(jobsheet.getTotalBillingIDR());
      jobsheetForm.setTotalExpensesIDR(jobsheet.getTotalExpensesIDR());
      jobsheetForm.setTotalBillingUSD(jobsheet.getTotalBillingUSD());
      jobsheetForm.setTotalExpensesUSD(jobsheet.getTotalExpensesUSD());
      jobsheetForm.setVolume(jobsheet.getVolume());
      jobsheetForm.setVolumeDesc(jobsheet.getVolumeDesc());
      jobsheetForm.setWeight(jobsheet.getWeight());
      jobsheetForm.setWeightDesc(jobsheet.getWeightDesc());
      jobsheetForm.setIdTransporter(jobsheet.getIdTransporter());
      jobsheetForm.setTransportCost(jobsheet.getTransportCost());
      jobsheetForm.setRefundIDR(jobsheet.getRefundIDR());
      jobsheetForm.setRefundUSD(jobsheet.getRefundUSD());
      jobsheetForm.setCnNo(jobsheet.getCnNo());      
      jobsheetForm.setDepart(jobsheet.getDepart());
      jobsheetForm.setCnKurs(jobsheet.getCnKurs());      
      jobsheetForm.setCmb(jobsheet.getCmb());
      jobsheetForm.setCreditNoteIDR(jobsheet.getCreditNoteIDR());
      jobsheetForm.setCreditNoteUSD(jobsheet.getCreditNoteUSD());
      jobsheetForm.setJaminan(jobsheet.getJaminan());
      jobsheetForm.setStatus(jobsheet.getStatus());
      
      jobsheetForm.setVatIDR(jobsheet.getVatIDR());
      jobsheetForm.setPphIDR(jobsheet.getPphIDR());
      jobsheetForm.setVatUSD(jobsheet.getVatUSD());
      jobsheetForm.setPphUSD(jobsheet.getPphUSD());
      
      jobsheetForm.setDppIDR(jobsheet.getDppIDR());
      jobsheetForm.setDppUSD(jobsheet.getDppUSD());
      
      jobsheetForm.setDppIDR2(jobsheet.getDppIDR2());
      jobsheetForm.setVatIDR2(jobsheet.getVatIDR2());
      jobsheetForm.setJaminan(jobsheet.getJaminan());
      
      return jobsheetForm;
   }

   public static com.wings.persistence.JobsheetKey findLastJobsheetKey () throws Exception {      
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      JobsheetKey jobsheetKey = jobsheetDAO.selectLastInsertId();     
      return jobsheetKey;
   }
   
   public static com.wings.persistence.Jobsheet selectMaxJobNo (com.wings.persistence.Jobsheet jobsheet) throws Exception {      
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheet = jobsheetDAO.selectMaxJobNo(jobsheet);     
      return jobsheet;
   }
      
   public static void remove (JobsheetKey jobsheetKey) throws Exception {       
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      jobsheetDAO.deleteByPrimaryKey(jobsheetKey);      
   }
   
   public static List findStatementOfAccount (String name) throws Exception {
      List retVals = new ArrayList();
      Consignee consignee = new Consignee();
      consignee.setName(name);
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectName(consignee);
      return retVals;
   }
   
   public static List findAll () throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectAll();
      return retVals;
   }
   
   public static List select (com.wings.web.struts.forms.JobsheetForm jobsheetForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

   public static List selectByidJobTypeAI (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectByidJobTypeAI(monthYearForm);
      return retVals;
   }

    public static List selectChartByYear (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectChart(monthYearForm);
      return retVals;
   }
    
   public static List selectByidJobTypeAO (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);
      retVals = jobsheetDAO.selectByidJobTypeAO(monthYearForm);
      return retVals;
   }

   public static List selectByidJobTypeSI (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);
      retVals = jobsheetDAO.selectByidJobTypeSI(monthYearForm);
      return retVals;
   }

   public static List selectByidJobTypeSO (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);
      retVals = jobsheetDAO.selectByidJobTypeSO(monthYearForm);
      return retVals;
   }
   
   public static List selectStatementOfAccountByMonthAndYear (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectStatementOfAccountList(monthYearForm);
      return retVals;
   }
   
   public static List selectUnPaymentList (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectUnPaymentList(monthYearForm);
      return retVals;
   }
   
   
   public static List selectStatementOfAccountAllStatusByMonthAndYear (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectStatementOfAccountListAll(monthYearForm);
      return retVals;
   }

   public static List selectUnPaymentStatementOfAccountAllStatusByMonthAndYear (MonthYearForm monthYearForm) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectUnPaymentStatementOfAccount(monthYearForm);
      return retVals;
   }

   public static List selectReportStatementOfAccountByIdConsignee (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
       jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectStatementOfAccountByIdConsignee(dateSelection);
      return retVals;
   }
   
   public static List selectReportStatementOfAccount (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectStatementOfAccount(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryJobsheet (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryJobsheet(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryJobsheetCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryJobsheetCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportOutstandingCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectOutstandingCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportOutstanding (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectOutstanding(dateSelection);
      return retVals;
   }
   
    public static List selectReportPayableCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectPayableCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportPayable (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectPayable(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySales (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySales(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesInvoiceAI (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesInvoiceAI(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesInvoiceAO (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesInvoiceAO(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesInvoiceSI (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesInvoiceSI(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesInvoiceSO (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesInvoiceSO(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesDebit (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesDebit(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesAICustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesAICustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesAO (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesAO(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesAOCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesAOCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesSI (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesSI(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesSICustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesSICustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesSO (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesSO(dateSelection);
      return retVals;
   }
   
   public static List selectReportMonthlySalesSOCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectMonthlySalesSOCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryTrucking (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryTruckingCharge(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryTruckingByTrucking (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryTruckingChargeByTransporter(dateSelection);
      return retVals;
   }
   
   public static List selectReportJaminan (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectReportJaminan(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryTax (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryReportTaxMonthly(dateSelection);
      return retVals;
   }
   
   public static List selectReportSummaryTaxByCustomer (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectSummaryReportTaxMonthlyCustomer(dateSelection);
      return retVals;
   }
   
   public static List selectDetailJobsheet(JobsheetKey jobsheetKey) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectDetailJobsheet(jobsheetKey);
      return retVals;
   }
   
   public static List selectDetailJobsheetByJobNo(Jobsheet jobsheet) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectDetailJobsheetByJobNo(jobsheet);
      return retVals;
   }
   
   public static List selectJobsheetByJobNo(Jobsheet jobsheet) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectByJobNo(jobsheet);
      return retVals;
   }
   
   public static List selectReportRefund (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectRefund(dateSelection);
      return retVals;
   }
   
   public static List selectReportFakturPajak (DateSelection dateSelection) throws Exception {
      List retVals = new ArrayList();
      JobsheetDAO jobsheetDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      jobsheetDAO = (JobsheetDAO)daoMgr.getDao(JobsheetDAO.class);      
      retVals = jobsheetDAO.selectFakturPajakByJobType(dateSelection);
      return retVals;
   }
}
