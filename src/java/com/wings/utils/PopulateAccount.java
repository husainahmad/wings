/*
 * PopulateAccount.java
 *
 * Created on July 29, 2008, 9:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.wings.utils;

import com.wings.adapter.StrutsTransactionaccDetailDelegate;
import com.wings.persistence.JobsheetKey;
import com.wings.persistence.Transactionaccdetail;
import com.wings.web.struts.forms.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Ahmad Husain
 */
public class PopulateAccount {

    private String nameAccount;

    public PopulateAccount() {
    }

    public static String getBillingDebitTo(JobsheetForm jobsheetForm) throws Exception {
        String billingDebitTo = "";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();
            jobsheetaiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.editByIdJobsheet(jobsheetaiForm);
            billingDebitTo = jobsheetaiForm.getBillToDebit();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
            jobsheetaoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
            billingDebitTo = jobsheetaoForm.getBillToDebit();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
            jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
            billingDebitTo = jobsheetsiForm.getBillToDebit();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
            jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
            billingDebitTo = jobsheetsoForm.getBillToDebit();
        }
        return billingDebitTo;
    }

    public static String getBillingInvoiceTo(JobsheetForm jobsheetForm) throws Exception {
        String billingInvoiceTo = "";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();
            jobsheetaiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.editByIdJobsheet(jobsheetaiForm);
            billingInvoiceTo = jobsheetaiForm.getBillTo();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
            jobsheetaoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
            billingInvoiceTo = jobsheetaoForm.getBillTo();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
            jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
            billingInvoiceTo = jobsheetsiForm.getBillTo();
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
            jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
            billingInvoiceTo = jobsheetsoForm.getBillTo();
        }
        return billingInvoiceTo;
    }

    public String getNoBatch(JobsheetForm jobsheetForm) {
        String noBatch = "001";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            noBatch = "001";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            noBatch = "002";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            noBatch = "003";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            noBatch = "004";
        }
        return noBatch;
    }

    public String getNamaBatch(JobsheetForm jobsheetForm) {
        String nameBatch = "001";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            nameBatch = "Sales AI";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            nameBatch = "Sales AO";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            nameBatch = "Sales SI";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            nameBatch = "Sales SO";
        }
        return nameBatch;
    }

    public String getNoBatchExpenses(JobsheetForm jobsheetForm) {
        String noBatch = "";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            noBatch = "005";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            noBatch = "006";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            noBatch = "007";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            noBatch = "008";
        }
        return noBatch;
    }

    public String getNamaBatchExpenses(JobsheetForm jobsheetForm) {
        String nameBatch = "";
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            nameBatch = "Cost AI";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            nameBatch = "Cost AO";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            nameBatch = "Cost SI";
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            nameBatch = "Cost SO";
        }
        return nameBatch;
    }

    public String getIdInvoice(int iInvo) {
        String sInv = "";
        if (iInvo == 1) { // for Sales
            sInv = "SAO";
        } else if (iInvo == 2) { // for Cost
            sInv = "CAO";
        }
        return sInv;
    }

    public String getIdInvoiceDesc(JobsheetForm jobsheetForm) {
        String sInvDesc = "";
        try {
            sInvDesc = jobsheetForm.getJobNo().substring(4, 12);
        } catch (Exception e) {
        }
        return sInvDesc;
    }
    /*
     * public void generateAccountDataHeaderInvoice(JobsheetForm jobsheetForm,
     * List bsInvoiceList) { try { TransactionaccForm transactionaccForm = new
     * TransactionaccForm(); KursdollarForm kursdollarForm =
     * com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs(); String name
     * = ""; String id = ""; String idInvoice = ""; //String noInvoice =
     * getIdInvoiceDesc(jobsheetForm); String billInvoiceTo =
     * this.getBillingInvoiceTo(jobsheetForm); JobsheetKey jobsheetKey = new
     * JobsheetKey(); jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
     *
     * InvoiceForm invoiceForm = new InvoiceForm();
     * invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet()); try {
     * invoiceForm =
     * com.wings.adapter.StrutsInvoiceDelegate.findByIdJobsheet(invoiceForm); }
     * catch (Exception e) { }
     *
     * if (billInvoiceTo != null) { if (billInvoiceTo.equalsIgnoreCase("4")) {
     * if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) { name = ""; } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) { name = ""; } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) { JobsheetsiForm
     * jobsheetsiForm = new JobsheetsiForm();
     * jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
     * jobsheetsiForm =
     * com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
     * name = jobsheetsiForm.getShippingLine(); } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) { JobsheetsoForm
     * jobsheetsoForm = new JobsheetsoForm();
     * jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
     * jobsheetsoForm =
     * com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
     * name = jobsheetsoForm.getShippingLine(); } Double totalIDR =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) {
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue()); //
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } }
     * Double totalUSD =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     *
     * id = ""; if (totalUSD.doubleValue() > 0.0) {
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } }
     * else if (billInvoiceTo.equalsIgnoreCase("3")) { ShipperForm shipperForm =
     * new ShipperForm(); ConsigneeForm consigneeAsShipperForm = new
     * ConsigneeForm();
     * consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
     * shipperForm.setIdShipper(jobsheetForm.getIdShipper()); try {
     * consigneeAsShipperForm =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
     * shipperForm.setName(consigneeAsShipperForm.getName());
     * shipperForm.setIdShipper(consigneeAsShipperForm.getIdConsignee());
     * shipperForm.setAddress1(consigneeAsShipperForm.getAddress1());
     * shipperForm.setAddress2(consigneeAsShipperForm.getAddress2());
     * shipperForm.setTelp(consigneeAsShipperForm.getTelp());
     * shipperForm.setFax(consigneeAsShipperForm.getFax());
     * shipperForm.setIdAccountIDR(consigneeAsShipperForm.getIdAccountIDR());
     * shipperForm.setIdAccountUSD(consigneeAsShipperForm.getIdAccountUSD()); }
     * catch (Exception e) { }
     *
     * name = shipperForm.getName(); this.setNameAccount(shipperForm.getName());
     * Double totalIDR =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (shipperForm.getIdAccountIDR() !=
     * null) { id = shipperForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " RP. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } id =
     * ""; Double totalUSD =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * if (totalUSD.doubleValue() > 0.0) { if (shipperForm.getIdAccountUSD() !=
     * null) { id = shipperForm.getIdAccountUSD(); }
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } }
     * else if (billInvoiceTo.equalsIgnoreCase("2")) { // account process
     * ConsigneeForm consigneeForm = new ConsigneeForm();
     * consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
     * consigneeForm =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm); name =
     * consigneeForm.getName(); id = "";
     * this.setNameAccount(consigneeForm.getName()); Double totalIDR =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (consigneeForm.getIdAccountIDR()
     * != null) { id = consigneeForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } id =
     * ""; Double totalUSD =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * if (totalUSD.doubleValue() > 0.0) { if (consigneeForm.getIdAccountUSD()
     * != null) { id = consigneeForm.getIdAccountUSD(); }
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } }
     * else if (billInvoiceTo.equalsIgnoreCase("1")) { AgentForm agentForm = new
     * AgentForm(); ConsigneeForm consigneeAsAgent = new ConsigneeForm();
     * consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
     * agentForm.setIdAgent(jobsheetForm.getIdAgent()); try { consigneeAsAgent =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
     * agentForm.setName(consigneeAsAgent.getName());
     * agentForm.setIdAgent(consigneeAsAgent.getIdConsignee());
     * agentForm.setAddress1(consigneeAsAgent.getAddress1());
     * agentForm.setAddress2(consigneeAsAgent.getAddress2());
     * agentForm.setTelp(consigneeAsAgent.getTelp());
     * agentForm.setFax(consigneeAsAgent.getFax());
     *
     * //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm); }
     * catch (Exception e) { } name = agentForm.getName(); id = "";
     * this.setNameAccount(agentForm.getName()); Double totalIDR =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (agentForm.getIdAccountIDR() !=
     * null) { id = agentForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } id =
     * ""; Double totalUSD =
     * com.wings.adapter.StrutsBillingshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * if (totalUSD.doubleValue() > 0.0) { if (agentForm.getIdAccountUSD() !=
     * null) { id = agentForm.getIdAccountUSD(); }
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingshipperForm expensesshipper = null; // for (int i=0;
     * i<bsInvoiceList.size(); i++) { // expensesshipper =
     * (BillingshipperForm)bsInvoiceList.get(i); // try { //
     * insertAccountDetailInvoice(jobsheetForm, expensesshipper, name, //
     * kursdollarForm, invoiceForm); // } catch (Exception e) { // } // } } } }
     * } catch (Exception e) { System.out.println(e.getMessage()); } }
     *
     * public void generateAccountDataHeaderDebit(JobsheetForm jobsheetForm,
     * List baDebitList) { try { TransactionaccForm transactionaccForm = new
     * TransactionaccForm();
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); // make sure there
     * is no same data
     * //com.wings.adapter.StrutsTransactionaccDelegate.removeByJobNo(transactionaccForm);
     *
     * KursdollarForm kursdollarForm =
     * com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs(); String name
     * = ""; String id = ""; String billDebitTo =
     * this.getBillingDebitTo(jobsheetForm); JobsheetKey jobsheetKey = new
     * JobsheetKey(); jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
     *
     * DebitForm invoiceForm = new DebitForm();
     * invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet()); try {
     * invoiceForm =
     * com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(invoiceForm); }
     * catch (Exception e) { }
     *
     * if (billDebitTo != null) { if (billDebitTo.equalsIgnoreCase("4")) { if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) { name = ""; } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) { name = ""; } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) { JobsheetsiForm
     * jobsheetsiForm = new JobsheetsiForm();
     * jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
     * jobsheetsiForm =
     * com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
     * name = jobsheetsiForm.getShippingLine(); } if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) { JobsheetsoForm
     * jobsheetsoForm = new JobsheetsoForm();
     * jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
     * jobsheetsoForm =
     * com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
     * name = jobsheetsoForm.getShippingLine(); } Double totalIDR =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) {
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     *
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } Double totalUSD =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * id = ""; if (totalUSD.doubleValue() > 0.0) {
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } } else if (billDebitTo.equalsIgnoreCase("3"))
     * { ShipperForm shipperForm = new ShipperForm(); ConsigneeForm
     * consigneeAsShipperForm = new ConsigneeForm();
     * consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
     * shipperForm.setIdShipper(jobsheetForm.getIdShipper()); try {
     * consigneeAsShipperForm =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
     * shipperForm.setName(consigneeAsShipperForm.getName());
     * shipperForm.setIdShipper(consigneeAsShipperForm.getIdConsignee());
     * shipperForm.setAddress1(consigneeAsShipperForm.getAddress1());
     * shipperForm.setAddress2(consigneeAsShipperForm.getAddress2());
     * shipperForm.setTelp(consigneeAsShipperForm.getTelp());
     * shipperForm.setFax(consigneeAsShipperForm.getFax());
     * shipperForm.setIdAccountIDR(consigneeAsShipperForm.getIdAccountIDR());
     * shipperForm.setIdAccountUSD(consigneeAsShipperForm.getIdAccountUSD()); }
     * catch (Exception e) { } name = shipperForm.getName();
     * this.setNameAccount(shipperForm.getName()); Double totalIDR =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (shipperForm.getIdAccountIDR() !=
     * null) { id = shipperForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " RP. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } Double totalUSD =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * id = ""; if (totalUSD.doubleValue() > 0.0) { if
     * (shipperForm.getIdAccountUSD() != null) { id =
     * shipperForm.getIdAccountUSD(); } transactionaccForm.setDebit(totalUSD);
     * transactionaccForm.setKredit(new Double(0.0));
     * transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } } else if (billDebitTo.equalsIgnoreCase("2"))
     * { // account process ConsigneeForm consigneeForm = new ConsigneeForm();
     * consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
     * consigneeForm =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm); name =
     * consigneeForm.getName(); this.setNameAccount(consigneeForm.getName()); id
     * = ""; Double totalIDR =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (consigneeForm.getIdAccountIDR()
     * != null) { id = consigneeForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " RP. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } id = ""; Double totalUSD =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * if (totalUSD.doubleValue() > 0.0) { if (consigneeForm.getIdAccountUSD()
     * != null) { id = consigneeForm.getIdAccountUSD(); }
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } } else if (billDebitTo.equalsIgnoreCase("1"))
     * { AgentForm agentForm = new AgentForm(); ConsigneeForm consigneeAsAgent =
     * new ConsigneeForm();
     * consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
     * agentForm.setIdAgent(jobsheetForm.getIdAgent()); try { consigneeAsAgent =
     * com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
     * agentForm.setName(consigneeAsAgent.getName());
     * agentForm.setIdAgent(consigneeAsAgent.getIdConsignee());
     * agentForm.setAddress1(consigneeAsAgent.getAddress1());
     * agentForm.setAddress2(consigneeAsAgent.getAddress2());
     * agentForm.setTelp(consigneeAsAgent.getTelp());
     * agentForm.setFax(consigneeAsAgent.getFax());
     *
     * //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm); }
     * catch (Exception e) { } name = agentForm.getName();
     * this.setNameAccount(agentForm.getName()); id = ""; Double totalIDR =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
     * if (totalIDR.doubleValue() > 0.0) { if (agentForm.getIdAccountIDR() !=
     * null) { id = agentForm.getIdAccountIDR(); }
     * transactionaccForm.setDebit(totalIDR); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } id = ""; Double totalUSD =
     * com.wings.adapter.StrutsBillingagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
     * if (totalUSD.doubleValue() > 0.0) { if (agentForm.getIdAccountUSD() !=
     * null) { id = agentForm.getIdAccountUSD(); }
     * transactionaccForm.setDebit(totalUSD); transactionaccForm.setKredit(new
     * Double(0.0)); transactionaccForm.setIdAccount(id);
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
     * transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0,
     * 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * // BillingagentForm expensesshipper = null; // for (int i=0;
     * i<baDebitList.size(); i++) { // expensesshipper =
     * (BillingagentForm)baDebitList.get(i); // try { //
     * generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm,
     * expensesshipper, name, // kursdollarForm, invoiceForm); // } catch
     * (Exception e) { // } // } } } } } catch (Exception e) {
     * System.out.println(e); } }
     *
     */

    public String getNameBillTo(String billDebitTo, JobsheetForm jobsheetForm) {
        String name = null;
        try {
            if (billDebitTo != null) {
                if (billDebitTo.equalsIgnoreCase("4")) {
                    if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                        name = "";
                    }
                    if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                        name = "";
                    }
                    if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                        JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
                        jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
                        jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
                        name = jobsheetsiForm.getShippingLine();
                    }
                    if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                        JobsheetsoForm jobsheetsoForm = new JobsheetsoForm();
                        jobsheetsoForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
                        jobsheetsoForm = com.wings.adapter.StrutsJobsheetsoDelegate.editByIdJobsheet(jobsheetsoForm);
                        name = jobsheetsoForm.getShippingLine();
                    }
                } else if (billDebitTo.equalsIgnoreCase("3")) {
                    ShipperForm shipperForm = new ShipperForm();
                    ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
                    consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
                    shipperForm.setIdShipper(jobsheetForm.getIdShipper());
                    consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
                    shipperForm.setName(consigneeAsShipperForm.getName());
                    name = shipperForm.getName();
                } else if (billDebitTo.equalsIgnoreCase("2")) {
                    // account process         
                    ConsigneeForm consigneeForm = new ConsigneeForm();
                    consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
                    consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
                    name = consigneeForm.getName();
                } else if (billDebitTo.equalsIgnoreCase("1")) {
                    AgentForm agentForm = new AgentForm();
                    ConsigneeForm consigneeAsAgent = new ConsigneeForm();
                    consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
                    agentForm.setIdAgent(jobsheetForm.getIdAgent());
                    consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
                    agentForm.setName(consigneeAsAgent.getName());
                    name = agentForm.getName();
                }
            }
        } catch (Exception e) {
        }
        return name;
    }

    public void insertDetailAccountDataDebitExpenses(TransactionaccForm transactionaccForm, JobsheetForm jobsheetForm, List baDebitList) {
        try {

            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            DebitForm debitForm = new DebitForm();
            debitForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            try {
                debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
            } catch (Exception e) {
            }

            // first clean all related data detail by  getIdTransactionAcc
            TransactionaccDetailForm transactionaccdetailform = new TransactionaccDetailForm();
            BeanUtils.copyProperties(transactionaccdetailform, transactionaccForm);
            StrutsTransactionaccDetailDelegate.removeByJobNo(transactionaccdetailform);

            BillingagentForm billingagent = null;
            for (int i = 0; i < baDebitList.size(); i++) {
                billingagent = (BillingagentForm) baDebitList.get(i);
                try {
                    generateDataAndInsertAccountDetailDebitExpenses(jobsheetForm, billingagent, this.getNameBillTo(this.getBillingDebitTo(jobsheetForm), jobsheetForm),
                            kursdollarForm, debitForm, i, transactionaccForm.getIdTransactionAcc().intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertDetailAccountDataDebitCost(TransactionaccForm transactionaccForm, JobsheetForm jobsheetForm, List expDebitList) {
        try {

            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            DebitForm debitForm = new DebitForm();
            debitForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            try {
                debitForm = com.wings.adapter.StrutsDebitDelegate.findByIdJobsheet(debitForm);
            } catch (Exception e) {
            }

            ExpensesagentForm expensesagent = null;
            for (int i = 0; i < expDebitList.size(); i++) {
                expensesagent = (ExpensesagentForm) expDebitList.get(i);
                try {
                    generateDataAndInsertAccountDetailDebitCost(jobsheetForm, expensesagent, this.getNameBillTo(this.getBillingDebitTo(jobsheetForm), jobsheetForm),
                            kursdollarForm, debitForm, i, transactionaccForm.getIdTransactionAcc().intValue());
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public TransactionaccForm insertJaminanToAccount(JobsheetForm jobsheetForm) {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        String uuid = String.valueOf(new AtomicInteger().incrementAndGet());
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            transactionaccForm.setDebit(new Double(0.0));
            transactionaccForm.setKredit(jobsheetForm.getJaminan());
            transactionaccForm.setIdAccount("1201002");
            transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
            transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
            transactionaccForm.setKurs("IDR");
            transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
            transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
            transactionaccForm.setVoucherDesc(getIdInvoice(2));
            transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
            transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + "Deposits on container" + " Rp. " + String.valueOf(jobsheetForm.getJaminan()));
            transactionaccForm.setJobNo(jobsheetForm.getJobNo());

            Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
            transactionaccForm.setInUrut(inUrut);
            transactionaccForm.setGroupid(uuid);
            
            transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
            transactionaccForm.setKursValue(kursdollarForm.getValue());
            transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            
            // debit 
            
            String idTR = "";
            String nameTR = "";
            
            if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                idTR = "1104004";
                nameTR = "T/R AO";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                idTR = "1104003";
                nameTR = "T/R AI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                idTR = "1104002";
                nameTR = "T/R SO";                
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                idTR = "1104001";
                nameTR = "T/R SI";
            }
            
            transactionaccForm.setDebit(jobsheetForm.getJaminan());
            transactionaccForm.setKredit(new Double(0.0));
            transactionaccForm.setIdAccount(idTR);
            
            transactionaccForm.setBatchDesc(nameTR);
            transactionaccForm.setVoucherDesc(getIdInvoice(2));
            transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
            transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameTR + " Rp. " + String.valueOf(jobsheetForm.getJaminan()));
            transactionaccForm.setJobNo(jobsheetForm.getJobNo());

            inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
            transactionaccForm.setInUrut(inUrut);
            transactionaccForm.setGroupid(uuid);
            
            transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
            transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);            
            
            return transactionaccForm;
        } catch (Exception e) {
        }

        return null;
    }
    //BillingAgent//Selling//Billing

    public TransactionaccForm generateAccountDataHeaderDebitExpenses(JobsheetForm jobsheetForm, List baDebitList) {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            String name = "";
            String id = "";
            String idTR = "";
            String nameTR = "";
            if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                id = "4101001";
                name = "Sales Air Export";
                idTR = "1104004";
                nameTR = "T/R AO";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                id = "4101002";
                name = "Sales Air Import";
                idTR = "1104003";
                nameTR = "T/R AI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                id = "4101003";
                name = "Sales Sea Export";
                idTR = "1104002";
                nameTR = "T/R SO";                
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                id = "4101004";
                name = "Sales Sea Import";
                idTR = "1104001";
                nameTR = "T/R SI";
            }

            JobsheetKey jobsheetKey = new JobsheetKey();
            jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
            String uuid = String.valueOf(new AtomicInteger().incrementAndGet());

            Double totalIDR = com.wings.adapter.StrutsBillingagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
            if (totalIDR.doubleValue() > 0.0) {
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalIDR);
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());

                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setGroupid(uuid);

                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit

                transactionaccForm.setDebit(totalIDR);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(idTR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameTR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameTR + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

            }

            Double totalUSD = com.wings.adapter.StrutsBillingagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
            if (totalUSD.doubleValue() > 0.0) {
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalUSD);
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit
                transactionaccForm.setDebit(totalUSD);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(idTR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameTR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameTR + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            }
            return transactionaccForm;
        } catch (Exception e) {
        }

        return null;
    }

    public TransactionaccForm generateAccountDataHeaderDebitCost(JobsheetForm jobsheetForm, List expDebitList) {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            String name = "";
            String id = "";

            String idAR_IDR = "1103001";
            String nameAR_IDR = "Account Receivable IDR";
            String idAR_USD = "1103002";
            String nameAR_USD = "Account Receivable USD";
            if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                id = "5101002";
                name = "Operational Expense - AI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                id = "5101001";
                name = "Operational Expense - AO";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                id = "5101004";
                name = "Operational Expense - SI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                id = "5101003";
                name = "Operational Expense - SO";
            }
            JobsheetKey jobsheetKey = new JobsheetKey();
            jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
            String uuid = String.valueOf(new AtomicInteger().incrementAndGet());

            Double totalIDR = com.wings.adapter.StrutsExpensesagentDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);
            if (totalIDR.doubleValue() > 0.0) {
                transactionaccForm.setDebit(totalIDR);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());

                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setGroupid(uuid);

                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit

                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalIDR);
                transactionaccForm.setIdAccount(idAR_IDR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameAR_IDR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameAR_IDR + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

            }

            Double totalUSD = com.wings.adapter.StrutsExpensesagentDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
            if (totalUSD.doubleValue() > 0.0) {
                transactionaccForm.setDebit(totalUSD);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalUSD);
                transactionaccForm.setIdAccount(idAR_USD);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameAR_USD);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameAR_USD + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            }
            return transactionaccForm;
        } catch (Exception e) {
        }
        return null;
    }

    public TransactionaccForm generateAccountDataHeaderInvoiceExpenses(JobsheetForm jobsheetForm, List expDebitList) {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            String name = "";
            String id = "";
            String idTR = "";
            String nameTR = "";
            if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                id = "4101002";
                name = "Sales Air Export";
                idTR = "1104003";
                nameTR = "T/R AI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                id = "4101001";
                name = "Sales Air Import";
                idTR = "1104004";
                nameTR = "T/R AO";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                id = "4101004";
                name = "Sales Sea Export";
                idTR = "1104001";
                nameTR = "T/R SI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                id = "4101003";
                name = "Sales Sea Import";
                idTR = "1104002";
                nameTR = "T/R SO";
            }

            JobsheetKey jobsheetKey = new JobsheetKey();
            jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
            String uuid = String.valueOf(new AtomicInteger().incrementAndGet());
            Double totalIDR = com.wings.adapter.StrutsBillingshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);

            transactionaccForm.setGroupid(uuid);

            if (totalIDR.doubleValue() > 0.0) {
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalIDR);
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit

                transactionaccForm.setDebit(totalIDR);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(idTR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameTR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameTR + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

            }

            Double totalUSD = com.wings.adapter.StrutsBillingshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
            if (totalUSD.doubleValue() > 0.0) {
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalUSD);
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit
                transactionaccForm.setDebit(totalUSD);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(idTR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameTR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameTR + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            }

            return transactionaccForm;
        } catch (Exception e) {
        }
        return null;
    }

    public TransactionaccForm generateAccountDataHeaderInvoiceCost(JobsheetForm jobsheetForm, List expDebitList) {
        TransactionaccForm transactionaccForm = new TransactionaccForm();
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            String name = "";
            String id = null;

            String idAR_IDR = "1103001";
            String nameAR_IDR = "Account Receivable IDR";
            String idAR_USD = "1103002";
            String nameAR_USD = "Account Receivable USD";
            if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
                id = "5101002";
                name = "Operational Expense - AI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
                id = "5101001";
                name = "Operational Expense - AO";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
                id = "5101004";
                name = "Operational Expense - SI";
            } else if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
                id = "5101003";
                name = "Operational Expense - SO";
            }
            JobsheetKey jobsheetKey = new JobsheetKey();
            jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
            String uuid = String.valueOf(new AtomicInteger().incrementAndGet());
            Double totalIDR = com.wings.adapter.StrutsExpensesshipperDelegate.selectTotalIDRByIdJobSheet(jobsheetKey);

            transactionaccForm.setGroupid(uuid);

            if (totalIDR.doubleValue() > 0.0) {
                transactionaccForm.setDebit(totalIDR);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit

                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalIDR);
                transactionaccForm.setIdAccount(idAR_IDR);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("IDR");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameAR_IDR);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameAR_IDR + " Rp. " + String.valueOf(totalIDR.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

            }

            Double totalUSD = com.wings.adapter.StrutsExpensesshipperDelegate.selectTotalUSDByIdJobSheet(jobsheetKey);
            if (totalUSD.doubleValue() > 0.0) {
                transactionaccForm.setDebit(totalUSD);
                transactionaccForm.setKredit(new Double(0.0));
                transactionaccForm.setIdAccount(id);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(name);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + name + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                Integer inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);

                // sebelah debit
                transactionaccForm.setDebit(new Double(0.0));
                transactionaccForm.setKredit(totalUSD);
                transactionaccForm.setIdAccount(idAR_USD);
                transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
                transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate());
                transactionaccForm.setKurs("USD");
                transactionaccForm.setNoBatch(getNoBatchExpenses(jobsheetForm));
                transactionaccForm.setBatchDesc(nameAR_USD);
                transactionaccForm.setVoucherDesc(getIdInvoice(2));
                transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
                transactionaccForm.setDescription(jobsheetForm.getJobNo().substring(0, 16) + "-" + nameAR_USD + " $. " + String.valueOf(totalUSD.doubleValue()));
                transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                inUrut = com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
                transactionaccForm.setInUrut(inUrut);
                transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut), 3, "0"));
                transactionaccForm.setKursValue(kursdollarForm.getValue());
                transactionaccForm = com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
            }
            return transactionaccForm;
        } catch (Exception e) {
        }
        return null;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public void generateDataAndInsertAccountDetailDebitExpenses(JobsheetForm jobsheetForm, BillingagentForm billingagent, String name,
            KursdollarForm kursdollarForm, DebitForm debitForm, int nourut, int idtansactionAcc) throws Exception {
        TransactionaccDetailForm transactionaccDetailForm = new TransactionaccDetailForm();
        transactionaccDetailForm.setIdTransactionAcc(Integer.valueOf(idtansactionAcc));
        transactionaccDetailForm.setTransactionDate(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setTglTutupBuku(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setGroupid(String.valueOf(billingagent.getIdbillingAgent()));
        // TODO // add new id for getIdbillingAgent

        transactionaccDetailForm.setNoBatch(getNoBatch(jobsheetForm));
        transactionaccDetailForm.setBatchDesc(getNamaBatch(jobsheetForm));
        transactionaccDetailForm.setVoucherDesc(getIdInvoice(1));
        transactionaccDetailForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));

        transactionaccDetailForm.setJobNo(jobsheetForm.getJobNo());
        transactionaccDetailForm.setInUrut(Integer.valueOf(nourut));
        transactionaccDetailForm.setNoUrut(StringUtils.leftPad(String.valueOf(nourut), 3, "0"));
        transactionaccDetailForm.setKursValue(kursdollarForm.getValue());

        String id = "";
        transactionaccDetailForm.setIdAccount(id);
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            if ((billingagent.getIdAccountAI() != null) && (!billingagent.getIdAccountAI().equalsIgnoreCase(""))) {
                id = billingagent.getIdAccountAI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " RP. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " $. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            if ((billingagent.getIdAccountAO() != null) && (!billingagent.getIdAccountAO().equalsIgnoreCase(""))) {
                id = billingagent.getIdAccountAO();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " RP. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " $. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            if ((billingagent.getIdAccountSI() != null) && (!billingagent.getIdAccountSI().equalsIgnoreCase(""))) {
                id = billingagent.getIdAccountSI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " RP. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " $. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            if ((billingagent.getIdAccountSO() != null) && (!billingagent.getIdAccountSO().equalsIgnoreCase(""))) {
                id = billingagent.getIdAccountSO();
                transactionaccDetailForm.setIdAccount(billingagent.getIdAccountSO());
            }
            if (billingagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " RP. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + "-" + billingagent.getForName() + " $. " + String.valueOf(billingagent.getCharge().doubleValue()));
                transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
            }
        }
    }

    public void generateDataAndInsertAccountDetailDebitCost(JobsheetForm jobsheetForm, ExpensesagentForm expensesagent, String name,
            KursdollarForm kursdollarForm, DebitForm debitForm, int nourut, int idtansactionAcc) throws Exception {
        TransactionaccDetailForm transactionaccDetailForm = new TransactionaccDetailForm();
        transactionaccDetailForm.setIdTransactionAcc(Integer.valueOf(idtansactionAcc));
        transactionaccDetailForm.setTransactionDate(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setTglTutupBuku(jobsheetForm.getShippeddate());
        String id = "";
        transactionaccDetailForm.setIdAccount(id);

        transactionaccDetailForm.setNoBatch(getNoBatch(jobsheetForm));
        transactionaccDetailForm.setBatchDesc(getNamaBatch(jobsheetForm));
        transactionaccDetailForm.setVoucherDesc(getIdInvoice(1));
        transactionaccDetailForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));

        transactionaccDetailForm.setJobNo(jobsheetForm.getJobNo());
        transactionaccDetailForm.setInUrut(Integer.valueOf(nourut));
        transactionaccDetailForm.setNoUrut(StringUtils.leftPad(String.valueOf(nourut), 3, "0"));
        transactionaccDetailForm.setKursValue(kursdollarForm.getValue());

        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            if ((expensesagent.getIdAccountAI() != null) && (!expensesagent.getIdAccountAI().equalsIgnoreCase(""))) {
                id = expensesagent.getIdAccountAI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " RP. " + String.valueOf(expensesagent.getCharge().doubleValue()));

            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " $. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            if ((expensesagent.getIdAccountAO() != null) && (!expensesagent.getIdAccountAO().equalsIgnoreCase(""))) {
                id = expensesagent.getIdAccountAO();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " RP. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " $. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            if ((expensesagent.getIdAccountSI() != null) && (!expensesagent.getIdAccountSI().equalsIgnoreCase(""))) {
                id = expensesagent.getIdAccountSI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " RP. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " $. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            if ((expensesagent.getIdAccountSO() != null) && (!expensesagent.getIdAccountSO().equalsIgnoreCase(""))) {
                id = expensesagent.getIdAccountSO();
                transactionaccDetailForm.setIdAccount(expensesagent.getIdAccountSO());
            }
            if (expensesagent.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " RP. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesagent.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(debitForm.getDebitNumber() + "-" + name + " $. " + String.valueOf(expensesagent.getCharge().doubleValue()));
            }
        }

        transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
    }

    /*
     * public void insertAccountDetailInvoice(JobsheetForm jobsheetForm,
     * BillingshipperForm billingshipperForm, String name, KursdollarForm
     * kursdollarForm, InvoiceForm invoiceForm) throws Exception {
     * TransactionaccForm transactionaccForm = new TransactionaccForm();
     * transactionaccForm.setTransactionDate(jobsheetForm.getShippeddate());
     * transactionaccForm.setTglTutupBuku(jobsheetForm.getShippeddate()); String
     * id = ""; transactionaccForm.setIdAccount(id); if
     * (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) { if
     * ((billingshipperForm.getIdAccountAI() != null) &&
     * (!billingshipperForm.getIdAccountAI().equalsIgnoreCase(""))) { id =
     * billingshipperForm.getIdAccountAI(); transactionaccForm.setIdAccount(id);
     * } if (billingshipperForm.getKurs().equalsIgnoreCase("IDR")) {
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " RP. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } else { transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " $. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } } if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) { if
     * ((billingshipperForm.getIdAccountAO() != null) &&
     * (!billingshipperForm.getIdAccountAO().equalsIgnoreCase(""))) { id =
     * billingshipperForm.getIdAccountAO(); transactionaccForm.setIdAccount(id);
     * } if (billingshipperForm.getKurs().equalsIgnoreCase("IDR")) {
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " RP. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } else { transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " $. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } } if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) { if
     * ((billingshipperForm.getIdAccountSI() != null) &&
     * (!billingshipperForm.getIdAccountSI().equalsIgnoreCase(""))) { id =
     * billingshipperForm.getIdAccountSI(); transactionaccForm.setIdAccount(id);
     * } if (billingshipperForm.getKurs().equalsIgnoreCase("IDR")) {
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " RP. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } else { transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " $. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } } if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) { if
     * ((billingshipperForm.getIdAccountSO() != null) &&
     * (!billingshipperForm.getIdAccountSO().equalsIgnoreCase(""))) { id =
     * billingshipperForm.getIdAccountSO();
     * transactionaccForm.setIdAccount(billingshipperForm.getIdAccountSO()); }
     * if (billingshipperForm.getKurs().equalsIgnoreCase("IDR")) {
     * transactionaccForm.setKurs("IDR");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " RP. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } else { transactionaccForm.setKurs("USD");
     * transactionaccForm.setNoBatch(getNoBatch(jobsheetForm));
     * transactionaccForm.setBatchDesc(getNamaBatch(jobsheetForm));
     * transactionaccForm.setVoucherDesc(getIdInvoice(1));
     * transactionaccForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));
     * transactionaccForm.setKredit(billingshipperForm.getCharge());
     * transactionaccForm.setDebit(new Double(0.0));
     * transactionaccForm.setDescription(invoiceForm.getInvoiceNumber() + "-" +
     * name + " $. " +
     * String.valueOf(billingshipperForm.getCharge().doubleValue()));
     * transactionaccForm.setJobNo(jobsheetForm.getJobNo()); Integer inUrut =
     * com.wings.adapter.StrutsTransactionaccDelegate.selectNoUrut(transactionaccForm);
     * transactionaccForm.setInUrut(inUrut);
     * transactionaccForm.setNoUrut(StringUtils.leftPad(String.valueOf(inUrut),
     * 3, "0")); transactionaccForm.setKursValue(kursdollarForm.getValue());
     * transactionaccForm =
     * com.wings.adapter.StrutsTransactionaccDelegate.create(transactionaccForm);
     * } } }
     *
     */
    void insertDetailAccountDataInvoiceExpenses(TransactionaccForm trFormInvoiceExpenses, JobsheetForm jobsheetForm, List baInvoiceList) {
        try {

            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            InvoiceForm invoiceForm = new InvoiceForm();
            invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            try {
                invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.findByIdJobsheet(invoiceForm);
            } catch (Exception e) {
            }

            BillingshipperForm billingshipper = null;
            for (int i = 0; i < baInvoiceList.size(); i++) {
                billingshipper = (BillingshipperForm) baInvoiceList.get(i);
                try {
                    generateDataAndInsertAccountDetailInvoiceExpenses(jobsheetForm, billingshipper, this.getNameBillTo(this.getBillingDebitTo(jobsheetForm), jobsheetForm),
                            kursdollarForm, invoiceForm, i, trFormInvoiceExpenses.getIdTransactionAcc().intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertDetailAccountDataInvoiceCost(TransactionaccForm trFormInvoiceCost, JobsheetForm jobsheetForm, List expInvoiceList) {
        try {
            KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();
            InvoiceForm invoiceForm = new InvoiceForm();
            invoiceForm.setIdJobSheet(jobsheetForm.getIdJobSheet());
            try {
                invoiceForm = com.wings.adapter.StrutsInvoiceDelegate.findByIdJobsheet(invoiceForm);
            } catch (Exception e) {
            }

            ExpensesshipperForm expensesshipper = null;
            for (int i = 0; i < expInvoiceList.size(); i++) {
                expensesshipper = (ExpensesshipperForm) expInvoiceList.get(i);
                try {
                    generateDataAndInsertAccountDetailInvoiveCost(jobsheetForm, expensesshipper, this.getNameBillTo(this.getBillingDebitTo(jobsheetForm), jobsheetForm),
                            kursdollarForm, invoiceForm, i, trFormInvoiceCost.getIdTransactionAcc().intValue());
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void generateDataAndInsertAccountDetailInvoiceExpenses(JobsheetForm jobsheetForm, BillingshipperForm billingshipper, String name, KursdollarForm kursdollarForm, InvoiceForm invoiceForm, int nourut, int idtansactionAcc) throws Exception {
        TransactionaccDetailForm transactionaccDetailForm = new TransactionaccDetailForm();
        transactionaccDetailForm.setIdTransactionAcc(Integer.valueOf(idtansactionAcc));
        transactionaccDetailForm.setTransactionDate(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setTglTutupBuku(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setGroupid(String.valueOf(billingshipper.getIdbillingShipper()));

        transactionaccDetailForm.setNoBatch(getNoBatch(jobsheetForm));
        transactionaccDetailForm.setBatchDesc(getNamaBatch(jobsheetForm));
        transactionaccDetailForm.setVoucherDesc(getIdInvoice(1));
        transactionaccDetailForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));

        transactionaccDetailForm.setJobNo(jobsheetForm.getJobNo());
        transactionaccDetailForm.setInUrut(Integer.valueOf(nourut));
        transactionaccDetailForm.setNoUrut(StringUtils.leftPad(String.valueOf(nourut), 3, "0"));
        transactionaccDetailForm.setKursValue(kursdollarForm.getValue());

        // TODO // add new id for getIdbillingAgent
        String id = "";
        transactionaccDetailForm.setIdAccount(id);
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            if ((billingshipper.getIdAccountAI() != null) && (!billingshipper.getIdAccountAI().equalsIgnoreCase(""))) {
                id = billingshipper.getIdAccountAI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");

                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " RP. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " $. " + String.valueOf(billingshipper.getCharge().doubleValue()));
                transactionaccDetailForm.setKursValue(kursdollarForm.getValue());
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            if ((billingshipper.getIdAccountAO() != null) && (!billingshipper.getIdAccountAO().equalsIgnoreCase(""))) {
                id = billingshipper.getIdAccountAO();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " RP. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " $. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            if ((billingshipper.getIdAccountSI() != null) && (!billingshipper.getIdAccountSI().equalsIgnoreCase(""))) {
                id = billingshipper.getIdAccountSI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (billingshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " RP. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " $. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            if ((billingshipper.getIdAccountSO() != null) && (!billingshipper.getIdAccountSO().equalsIgnoreCase(""))) {
                id = billingshipper.getIdAccountSO();
                transactionaccDetailForm.setIdAccount(billingshipper.getIdAccountSO());
            }
            if (billingshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " RP. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(billingshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + billingshipper.getForName() + " $. " + String.valueOf(billingshipper.getCharge().doubleValue()));
            }
        }

        transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
    }

    private void generateDataAndInsertAccountDetailInvoiveCost(JobsheetForm jobsheetForm, ExpensesshipperForm expensesshipper, String name, KursdollarForm kursdollarForm, InvoiceForm invoiceForm, int nourut, int idtansactionAcc) throws Exception {
        TransactionaccDetailForm transactionaccDetailForm = new TransactionaccDetailForm();
        transactionaccDetailForm.setIdTransactionAcc(Integer.valueOf(idtansactionAcc));
        transactionaccDetailForm.setTransactionDate(jobsheetForm.getShippeddate());
        transactionaccDetailForm.setTglTutupBuku(jobsheetForm.getShippeddate());
        String id = "";
        transactionaccDetailForm.setIdAccount(id);

        transactionaccDetailForm.setNoBatch(getNoBatch(jobsheetForm));
        transactionaccDetailForm.setBatchDesc(getNamaBatch(jobsheetForm));
        transactionaccDetailForm.setVoucherDesc(getIdInvoice(1));
        transactionaccDetailForm.setNoVoucher(getIdInvoiceDesc(jobsheetForm));

        transactionaccDetailForm.setJobNo(jobsheetForm.getJobNo());
        transactionaccDetailForm.setInUrut(Integer.valueOf(nourut));
        transactionaccDetailForm.setNoUrut(StringUtils.leftPad(String.valueOf(nourut), 3, "0"));
        transactionaccDetailForm.setKursValue(kursdollarForm.getValue());


        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AI")) {
            if ((expensesshipper.getIdAccountAI() != null) && (!expensesshipper.getIdAccountAI().equalsIgnoreCase(""))) {
                id = expensesshipper.getIdAccountAI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " RP. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " $. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("AO")) {
            if ((expensesshipper.getIdAccountAO() != null) && (!expensesshipper.getIdAccountAO().equalsIgnoreCase(""))) {
                id = expensesshipper.getIdAccountAO();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " RP. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " $. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SI")) {
            if ((expensesshipper.getIdAccountSI() != null) && (!expensesshipper.getIdAccountSI().equalsIgnoreCase(""))) {
                id = expensesshipper.getIdAccountSI();
                transactionaccDetailForm.setIdAccount(id);
            }
            if (expensesshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " RP. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " $. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            }
        }
        if (jobsheetForm.getIdJobType().equalsIgnoreCase("SO")) {
            if ((expensesshipper.getIdAccountSO() != null) && (!expensesshipper.getIdAccountSO().equalsIgnoreCase(""))) {
                id = expensesshipper.getIdAccountSO();
                transactionaccDetailForm.setIdAccount(expensesshipper.getIdAccountSO());
            }
            if (expensesshipper.getKurs().equalsIgnoreCase("IDR")) {
                transactionaccDetailForm.setKurs("IDR");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " RP. " + String.valueOf(expensesshipper.getCharge().doubleValue()));
            } else {
                transactionaccDetailForm.setKurs("USD");
                transactionaccDetailForm.setKredit(expensesshipper.getCharge());
                transactionaccDetailForm.setDebit(new Double(0.0));
                transactionaccDetailForm.setDescription(invoiceForm.getInvoiceNumber() + "-" + name + "-" + expensesshipper.getForName() + " $. " + String.valueOf(expensesshipper.getCharge().doubleValue()));

            }
        }
        transactionaccDetailForm = com.wings.adapter.StrutsTransactionaccDetailDelegate.create(transactionaccDetailForm);
    }
}
