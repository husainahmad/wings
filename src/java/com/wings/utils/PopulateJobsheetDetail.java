/*
 * PopulateJobsheetDetail.java
 *
 * Created on July 4, 2008, 9:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import com.wings.persistence.Agentfee;
import com.wings.persistence.JobsheetKey;
import com.wings.persistence.Shipperfee;
import com.wings.web.struts.forms.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ahmad Husain
 */
public class PopulateJobsheetDetail {
    private double totalDebitIDR;
    
    public PopulateJobsheetDetail() {        
    }
    
    public static boolean checkDebit(HttpServletRequest request) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaDebit"));          
      boolean isDebit = false;      
      String idAgentFee = null;      
      String desc = null;      
      String kurs = null;      
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "billingidAgentFeeDebit"+i;                    
          if (request.getParameter(idAgentFee)!=null) {              
              isDebit = true;
              return true;
          }          
      }
      return isDebit;
    }
    
    public static boolean checkInvoice(HttpServletRequest request) {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaInvoice"));          
      boolean isInvoice = false;
      String idAgentFee = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "billingidAgentFeeInvoice"+i;
          if (request.getParameter(idAgentFee)!=null) {
              isInvoice = true;
              return true;
          }                    
      }
      return isInvoice;
    }
    //AgentDebit = BillingAgent
    public static List populateBillingAgentDebit(HttpServletRequest request, Integer idJobSheet, List agentfeeList) throws Exception {
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaDebit"));          
      KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();         
      List baDebitList = new ArrayList();
      BillingagentForm billingagent = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;      
      String desc2 = null;      
      String kurs = null;
      String bc;
      String kursValue = null;
      String kv;
      String oriKursStr;
      String oks;
      String oriWeightStr;
      String ows;
      String billingAgentTaxDebit;
      String billingAgentVatDebit;
      
      double totalBillingDebit = 0.0;  
      boolean isDebitAda = false;
      Agentfee agentfee = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          
          idAgentFee = "billingidAgentFeeDebit"+i;
          charge = "billingAgentChargeDebit"+i;
          desc = "billingAgentDescDebit"+i;
          desc2= "billingAgentDescriptionDebit"+i;
          kurs = "billingAgentKursDebit"+i;
          kursValue = "billingAgentKursValueDebit"+i;
          oriKursStr = "billingAgentOriKursDebit"+i;
          oriWeightStr = "billingAgentOriWeightDebit"+i;
          billingAgentTaxDebit = "billingAgentTaxDebit"+i;
          billingAgentVatDebit = "billingAgentVatDebit"+i;
          
          billingagent = new BillingagentForm();
          billingagent.setIdJobSheet(idJobSheet);
          if (request.getParameter(idAgentFee)!=null) {
              isDebitAda = true;
              billingagent.setIdAgentFee(Integer.valueOf(request.getParameter(idAgentFee)));
              // looping to find idAccount
              for (int j=0; j<agentfeeList.size();j++) {
                  agentfee = (Agentfee)agentfeeList.get(j);
                  if (billingagent.getIdAgentFee().intValue()==agentfee.getIdAgentFee().intValue()) {
                      // do somethink here
                      billingagent.setIdAccountAI(agentfee.getIdAccountAI());
                      billingagent.setIdAccountAO(agentfee.getIdAccountAO());
                      billingagent.setIdAccountSI(agentfee.getIdAccountSI());
                      billingagent.setIdAccountSO(agentfee.getIdAccountSO());
                      billingagent.setIdAccountCostAI(agentfee.getIdAccountCostAI());
                      billingagent.setIdAccountCostAO(agentfee.getIdAccountCostAO());
                      billingagent.setIdAccountCostSI(agentfee.getIdAccountCostSI());
                      billingagent.setIdAccountCostSO(agentfee.getIdAccountCostSO());
                      billingagent.setForName(agentfee.getDescription());  
                  }
              }
              try {
                  bc = request.getParameter(charge);
                  bc = bc.replaceAll(",","");                  
                  billingagent.setCharge(Double.valueOf(bc));                  
              } catch (Exception e) {
                  billingagent.setCharge(new Double(0.0));
              }          
              try {
                  kv = request.getParameter(kursValue);
                  kv = kv.replaceAll(",","");
                  billingagent.setKursValue(Double.valueOf(kv));
              } catch (Exception e) {
                  billingagent.setKursValue(kursdollarForm.getValue());
              }
              
              try {
                  oks = request.getParameter(oriKursStr);
                  oks = oks.replaceAll(",","");
                  billingagent.setOriKurs(Double.valueOf(oks));
              } catch (Exception e) {
                  billingagent.setOriKurs(new Double(0.0));
              }
              
              try {
                  ows = request.getParameter(oriWeightStr);
                  ows = ows.replaceAll(",","");
                  billingagent.setOriWeight(Double.valueOf(ows));
              } catch (Exception e) {
                  billingagent.setOriWeight(new Double(0.0));
              }
              
              billingagent.setDescription(request.getParameter(desc));
              billingagent.setDescriptionInvoice(request.getParameter(desc2));
              billingagent.setKurs(request.getParameter(kurs));
              if (billingagent.getKurs().equalsIgnoreCase("USD")) {
                  totalBillingDebit+=totalBillingDebit + billingagent.getCharge().doubleValue();
              }
              billingagent.setIsTax(new Integer("0"));
              if (request.getParameter(billingAgentTaxDebit)!=null) { 
                  try {
                      billingagent.setIsTax(new Integer(request.getParameter(billingAgentTaxDebit)));
                  } catch (Exception ex) {                     
                  }                  
              }
              billingagent.setIsVat(new Integer("0"));
              if (request.getParameter(billingAgentVatDebit)!=null) { 
                  try {
                      billingagent.setIsVat(new Integer(request.getParameter(billingAgentVatDebit)));
                  } catch (Exception ex) {                      
                  }                  
              }
              baDebitList.add(billingagent);                
          }
      }
      if (isDebitAda) {
          //populateAccountDebit(request, idJobSheet, totalBillingDebit);
      }
      return baDebitList;
   }
   //AgentInvoice = BillingShipper
   public static List populateBillingAgentInvoice(HttpServletRequest request, Integer idJobSheet, List shipperfeeList) throws Exception {
      KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();          
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountbaInvoice"));          
      List baDebitList = new ArrayList();
      BillingshipperForm billingshipper = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;      
      String desc2 = null;            
      String kurs = null;
      String kursValue = null;
      String bc = null;
      String kv = null;
      String oriKursStr;
      String oks;
      String oriWeightStr;
      String ows;
      Shipperfee shipperfee = null;
      String billingAgentTaxInvoice;
      String billingAgentVatInvoice;
      double totalBillingInvoice = 0.0;
      boolean isInvoiceAda = false;
      for (int i=1; i<dacountbaDebit+1; i++) {
          
          idAgentFee = "billingidAgentFeeInvoice"+i;
          charge = "billingAgentChargeInvoice"+i;
          desc = "billingAgentDescInvoice"+i;
          desc2 = "billingAgentDescriptionInvoice"+i;
          kurs = "billingAgentKursInvoice"+i;
          kursValue = "billingAgentKursValueInvoice"+i;
          oriKursStr = "billingAgentOriKursInvoice"+i;
          oriWeightStr = "billingAgentOriWeightInvoice"+i;
          billingAgentTaxInvoice = "billingAgentTaxInvoice" +i;
          billingAgentVatInvoice = "billingAgentVatInvoice" +i;
          
          billingshipper = new BillingshipperForm();
          billingshipper.setIdJobSheet(idJobSheet);
          if (request.getParameter(idAgentFee)!=null) {
              isInvoiceAda = true;
              billingshipper.setIdShipperFee(Integer.valueOf(request.getParameter(idAgentFee)));
              // looping to find idAccount
              for (int j=0; j<shipperfeeList.size();j++) {
                  shipperfee = (Shipperfee)shipperfeeList.get(j);
                  if (billingshipper.getIdShipperFee().intValue()==shipperfee.getIdShipperFee().intValue()) {
                      // do somethink here
                      billingshipper.setIdAccountAI(shipperfee.getIdAccountAI());
                      billingshipper.setIdAccountAO(shipperfee.getIdAccountAO());
                      billingshipper.setIdAccountSI(shipperfee.getIdAccountSI());
                      billingshipper.setIdAccountSO(shipperfee.getIdAccountSO());
                      billingshipper.setIdAccountCostAI(shipperfee.getIdAccountCostAI());
                      billingshipper.setIdAccountCostAO(shipperfee.getIdAccountCostAO());
                      billingshipper.setIdAccountCostSI(shipperfee.getIdAccountCostSI());
                      billingshipper.setIdAccountCostSO(shipperfee.getIdAccountCostSO());
                      billingshipper.setForName(shipperfee.getDescription());
                  }
              }
              try {
                  bc = request.getParameter(charge);
                  bc = bc.replaceAll(",","");
                  billingshipper.setCharge(Double.valueOf(bc));
              } catch (Exception e) {
                  billingshipper.setCharge(new Double(0.0));
              }
              try {
                  kv = request.getParameter(kursValue);
                  kv = kv.replaceAll(",","");
                  billingshipper.setKursValue(Double.valueOf(kv));
              } catch (Exception e) {
                  billingshipper.setKursValue(kursdollarForm.getValue());
              }
              
              try {
                  oks = request.getParameter(oriKursStr);
                  oks = oks.replaceAll(",","");
                  billingshipper.setOriKurs(Double.valueOf(oks));
              } catch (Exception e) {
                  billingshipper.setOriKurs(new Double(0.0));
              }
              
              try {
                  ows = request.getParameter(oriWeightStr);
                  ows = ows.replaceAll(",","");
                  billingshipper.setOriWeight(Double.valueOf(ows));
              } catch (Exception e) {
                  billingshipper.setOriWeight(new Double(0.0));
              }
              
              billingshipper.setDescription(request.getParameter(desc));
              billingshipper.setDescriptionInvoice(request.getParameter(desc2));
              billingshipper.setKurs(request.getParameter(kurs));
              totalBillingInvoice+= billingshipper.getCharge().doubleValue();
              
              billingshipper.setIsTax(new Integer("0"));
              if (request.getParameter(billingAgentTaxInvoice)!=null) { 
                  try {
                      billingshipper.setIsTax(new Integer(request.getParameter(billingAgentTaxInvoice)));
                  } catch (Exception ex) {                      
                  }                  
              }
              billingshipper.setIsVat(new Integer("0"));
              if (request.getParameter(billingAgentVatInvoice)!=null) { 
                  try {
                      billingshipper.setIsVat(new Integer(request.getParameter(billingAgentVatInvoice)));
                  } catch (Exception ex) {                      
                  }                  
              }
              
              baDebitList.add(billingshipper);  
          }          
      }
      
      // process  inserting data
      if (isInvoiceAda) {                    
          //populateAccountDebit(request, idJobSheet, to);
      }
      
      return baDebitList;
   }
   
   public static List populateExpensesAgentDebit(HttpServletRequest request, Integer idJobSheet, List agentfeeList) throws Exception {
      KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();          
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountexpensesagentDebit"));          
      List baDebitList = new ArrayList();
      ExpensesagentForm expensesagent = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;     
      String desc2 = null;     
      String kurs = null;
      String kursValue = null;
      String kv = null;
      String bc = null;
      String oriKursStr;
      String oks;
      String oriWeightStr;
      String ows;
      String expensesAgentTaxDebit;
      String expensesAgentVatDebit;
      
      Agentfee agentfee = null;
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "expensesidAgentFeeDebit"+i;
          charge = "expensesAgentChargeDebit"+i;
          desc = "expensesAgentDescDebit"+i;
          desc2 = "expensesAgentDescriptionDebit"+i;
          kurs = "expensesAgentKursDebit"+i;
          kursValue = "expensesAgentKursValueDebit"+i;
          oriKursStr = "expensesAgentOriKursDebit"+i;
          oriWeightStr = "expensesAgentOriWeightDebit"+i;
          expensesAgentTaxDebit = "expensesAgentTaxDebit"+i;
          expensesAgentVatDebit = "expensesAgentVatDebit"+i;
          
          expensesagent = new ExpensesagentForm();
          expensesagent.setIdJobSheet(idJobSheet);
          if (request.getParameter(idAgentFee)!=null) {
              
              expensesagent.setIdAgentFee(Integer.valueOf(request.getParameter(idAgentFee)));

              // looping to find idAccount
              for (int j=0; j<agentfeeList.size();j++) {
                  agentfee = (Agentfee)agentfeeList.get(j);
                  if (expensesagent.getIdAgentFee().intValue()==agentfee.getIdAgentFee().intValue()) {
                      // do somethink here
                      expensesagent.setIdAccountAI(agentfee.getIdAccountAI());
                      expensesagent.setIdAccountAO(agentfee.getIdAccountAO());
                      expensesagent.setIdAccountSI(agentfee.getIdAccountSI());
                      expensesagent.setIdAccountSO(agentfee.getIdAccountSO());
                      expensesagent.setIdAccountCostAI(agentfee.getIdAccountCostAI());
                      expensesagent.setIdAccountCostAO(agentfee.getIdAccountCostAO());
                      expensesagent.setIdAccountCostSI(agentfee.getIdAccountCostSI());
                      expensesagent.setIdAccountCostSO(agentfee.getIdAccountCostSO());
                      expensesagent.setForName(agentfee.getDescription());
                  }
              }

              try {
                  bc = request.getParameter(charge);
                  bc = bc.replaceAll(",","");
                  expensesagent.setCharge(Double.valueOf(bc));
              } catch (Exception e) {
                  expensesagent.setCharge(new Double(0.0));
              }
              try {
                  kv = request.getParameter(kursValue);
                  kv = kv.replaceAll(",","");
                  expensesagent.setKursValue(Double.valueOf(kv));
              } catch (Exception e) {
                  expensesagent.setKursValue(kursdollarForm.getValue());
              }
              try {
                  oks = request.getParameter(oriKursStr);
                  oks = oks.replaceAll(",","");
                  expensesagent.setOriKurs(Double.valueOf(oks));
              } catch (Exception e) {
                  expensesagent.setOriKurs(new Double(0.0));
              }
              
              try {
                  ows = request.getParameter(oriWeightStr);
                  ows = ows.replaceAll(",","");
                  expensesagent.setOriWeight(Double.valueOf(ows));
              } catch (Exception e) {
                  expensesagent.setOriWeight(new Double(0.0));
              }
              expensesagent.setIsTax(new Integer("0"));
              if (request.getParameter(expensesAgentTaxDebit)!=null) {
                  try {
                      expensesagent.setIsTax(new Integer(request.getParameter(expensesAgentTaxDebit)));
                  } catch (Exception ex) {                      
                  }                  
              }      
              expensesagent.setIsVat(new Integer("0"));
              if (request.getParameter(expensesAgentVatDebit)!=null) {
                  try {
                      expensesagent.setIsVat(new Integer(request.getParameter(expensesAgentVatDebit)));
                  } catch (Exception ex) {                      
                  }                  
              }  
              expensesagent.setDescription(request.getParameter(desc));
              expensesagent.setDescriptionInvoice(request.getParameter(desc2));
              expensesagent.setKurs(request.getParameter(kurs));
              baDebitList.add(expensesagent);  
          }
      }
      return baDebitList;
   }
   //CostInvoice = expensesShipper
   public static List populateExpensesAgentInvoice(HttpServletRequest request, Integer idJobSheet, List shipperfeeList) throws Exception {
      KursdollarForm kursdollarForm = com.wings.adapter.StrutsKursdollarDelegate.selectLastKurs();          
      int dacountbaDebit = Integer.parseInt(request.getParameter("dacountexpensesagentInvoice"));          
      List baDebitList = new ArrayList();
      ExpensesshipperForm expensesshipper = null;        
      String idAgentFee = null;
      String charge = null;
      String desc = null;     
      String desc2 = null;     
      String kurs = null;
      String kursValue = null;
      String kv = null;
      String bc = null;
      String oriKursStr;
      String oks;
      String oriWeightStr;
      String ows;
      Shipperfee shipperfee = null;
      String expensesShipperTaxInvoice;
      String expensesShipperVatInvoice;
      
      for (int i=1; i<dacountbaDebit+1; i++) {
          idAgentFee = "expensesidAgentFeeInvoice"+i;
          charge = "expensesAgentChargeInvoice"+i;
          desc = "expensesAgentDescInvoice"+i;
          desc2 = "expensesAgentDescriptionInvoice"+i;
          kurs = "expensesAgentKursInvoice"+i;
          kursValue = "expensesAgentKursValueInvoice"+i;
          oriKursStr = "expensesAgentOriKursInvoice"+i;
          oriWeightStr = "expensesAgentOriWeightInvoice"+i;
          expensesShipperTaxInvoice = "expensesAgentTaxInvoice"+i;
          expensesShipperVatInvoice = "expensesAgentVatInvoice"+i;
          
          expensesshipper = new ExpensesshipperForm();
          expensesshipper.setIdJobSheet(idJobSheet);
          if (request.getParameter(idAgentFee)!=null) {
              expensesshipper.setIdShipperFee(Integer.valueOf(request.getParameter(idAgentFee)));
              // looping to find idAccount
              for (int j=0; j<shipperfeeList.size();j++) {
                  shipperfee = (Shipperfee)shipperfeeList.get(j);
                  if (expensesshipper.getIdShipperFee().intValue()==shipperfee.getIdShipperFee().intValue()) {
                      // do somethink here
                      expensesshipper.setIdAccountAI(shipperfee.getIdAccountAI());
                      expensesshipper.setIdAccountAO(shipperfee.getIdAccountAO());
                      expensesshipper.setIdAccountSI(shipperfee.getIdAccountSI());
                      expensesshipper.setIdAccountSO(shipperfee.getIdAccountSO());
                      expensesshipper.setIdAccountCostAI(shipperfee.getIdAccountCostAI());
                      expensesshipper.setIdAccountCostAO(shipperfee.getIdAccountCostAO());
                      expensesshipper.setIdAccountCostSI(shipperfee.getIdAccountCostSI());
                      expensesshipper.setIdAccountCostSO(shipperfee.getIdAccountCostSO());
                      expensesshipper.setForName(shipperfee.getDescription());
                  }
              }

              try {
                  bc = request.getParameter(charge);
                  bc = bc.replaceAll(",","");
                  expensesshipper.setCharge(Double.valueOf(bc));
              } catch (Exception e) {
                  expensesshipper.setCharge(new Double(0.0));
              }
              try {
                  kv = request.getParameter(kursValue);
                  kv = kv.replaceAll(",","");
                  expensesshipper.setKursValue(Double.valueOf(kv));
              } catch (Exception e) {
                  expensesshipper.setKursValue(kursdollarForm.getValue());
              }
              try {
                  oks = request.getParameter(oriKursStr);
                  oks = oks.replaceAll(",","");
                  expensesshipper.setOriKurs(Double.valueOf(oks));
              } catch (Exception e) {
                  expensesshipper.setOriKurs(new Double(0.0));
              }
              
              try {
                  ows = request.getParameter(oriWeightStr);
                  ows = ows.replaceAll(",","");
                  expensesshipper.setOriWeight(Double.valueOf(ows));
              } catch (Exception e) {
                  expensesshipper.setOriWeight(new Double(0.0));
              }
              expensesshipper.setIsTax(new Integer("0"));
              if (request.getParameter(expensesShipperTaxInvoice)!=null) {
                  try {
                      expensesshipper.setIsTax(new Integer(request.getParameter(expensesShipperTaxInvoice)));
                  } catch (Exception ex) {                      
                  }                  
              }
              expensesshipper.setIsVat(new Integer("0"));
              if (request.getParameter(expensesShipperVatInvoice)!=null) {
                  try {
                      expensesshipper.setIsVat(new Integer(request.getParameter(expensesShipperVatInvoice)));
                  } catch (Exception ex) {                      
                  }                  
              }
              
              expensesshipper.setDescription(request.getParameter(desc));
              expensesshipper.setDescriptionInvoice(request.getParameter(desc2));
              expensesshipper.setKurs(request.getParameter(kurs));
              baDebitList.add(expensesshipper);  
          }          
      }
      return baDebitList;
   }
   
   public static void processingPopulatedDetailItem(HttpServletRequest request, JobsheetKey jobsheetKey, 
                                                    List agentfeeList, List shipperfeeList, 
                                                    JobsheetForm jobsheetForm) throws Exception {
         
         TransactionaccForm transactionaccForm = new TransactionaccForm();
         transactionaccForm.setJobNo(jobsheetForm.getJobNo());
                                                                      
         List baDebitList = PopulateJobsheetDetail.populateBillingAgentDebit(request, jobsheetKey.getIdJobSheet(), agentfeeList);
         BillingagentForm billingagent = null;         
         
         double totalDPPAgent = 0.0;
         double totalPPHAgent = 0.0;
         
         for (int i=0; i<baDebitList.size(); i++) {             
             billingagent = (BillingagentForm)baDebitList.get(i);
             if (billingagent.getIsTax().intValue()==1) {
                 totalDPPAgent = totalDPPAgent + billingagent.getCharge().doubleValue();
             }
             if (billingagent.getIsVat().intValue()==1) {
                 totalPPHAgent = totalPPHAgent + billingagent.getCharge().doubleValue();
             }
             billingagent = com.wings.adapter.StrutsBillingagentDelegate.create(billingagent);                                                                              
         }
                                 
         
         transactionaccForm.setJobNo(jobsheetForm.getJobNo());
         // make sure there is no same data // old format
         com.wings.adapter.StrutsTransactionaccDelegate.removeByJobNo(transactionaccForm);
             
         jobsheetForm.setJobNo(jobsheetForm.getJobNo() + " " + jobsheetForm.getIdJobSheet());
         transactionaccForm.setJobNo(jobsheetForm.getJobNo());         
         // make sure there is no same data // new format
         com.wings.adapter.StrutsTransactionaccDelegate.removeByJobNo(transactionaccForm);
         
                                   
         List baInvoiceList = PopulateJobsheetDetail.populateBillingAgentInvoice(request, jobsheetKey.getIdJobSheet(), shipperfeeList);
         
//         double totalTaxShipper = 0.0;
//         double totalVatShipper = 0.0;
         
         BillingshipperForm billingshipper = null;
         for (int i=0; i<baInvoiceList.size(); i++) {
             billingshipper = (BillingshipperForm)baInvoiceList.get(i);             
             if (billingshipper.getIsTax().intValue()==1) {
                 totalDPPAgent = totalDPPAgent + billingshipper.getCharge().doubleValue();
             }
             if (billingshipper.getIsVat().intValue()==1) {
                 totalPPHAgent = totalPPHAgent + billingshipper.getCharge().doubleValue();
             }
             billingshipper = com.wings.adapter.StrutsBillingshipperDelegate.create(billingshipper);                                                                   
         }
         
         double vatAgent = totalDPPAgent * 0.10;
         double pph23Agent = totalPPHAgent * 0.02;   
         
//         jobsheetForm.setBillTaxIDR(new Double(totalDPPAgent));
//         jobsheetForm.setBillVatIDR(new Double(totalPPHAgent));
//         
//         jobsheetForm.setExpTaxIDR(new Double(totalTaxShipper));
//         jobsheetForm.setExpVatIDR(new Double(totalVatShipper));         
         
         List expDebitList = PopulateJobsheetDetail.populateExpensesAgentDebit(request, jobsheetKey.getIdJobSheet(), agentfeeList);
         
         ExpensesagentForm expensesagent = null;
         transactionaccForm = null;
         
//         double exTotalTaxAgent = 0.0;
//         double exTotalVatAgent = 0.0;
         
         for (int i=0; i<expDebitList.size(); i++) {
             expensesagent = (ExpensesagentForm)expDebitList.get(i);             
//             if (expensesagent.getIsTax().intValue()==1) {
//                 exTotalTaxAgent = exTotalTaxAgent + expensesagent.getCharge().doubleValue();
//             }
//             if (expensesagent.getIsTax().intValue()==1) {
//                 exTotalVatAgent = exTotalVatAgent + expensesagent.getCharge().doubleValue();
//             }
             expensesagent = com.wings.adapter.StrutsExpensesagentDelegate.create(expensesagent);                          
         }
                
//         exTotalTaxAgent = exTotalTaxAgent * 0.02;
//         exTotalVatAgent = exTotalVatAgent * 0.10;
         
         List expInvoiceList = PopulateJobsheetDetail.populateExpensesAgentInvoice(request, jobsheetKey.getIdJobSheet(), shipperfeeList);
         
         ExpensesshipperForm expensesshipper = null;
         transactionaccForm = null;
         
//         double exTotalTaxShipper = 0.0;
//         double exTotalVatShipper = 0.0;
         
         for (int i=0; i<expInvoiceList.size(); i++) {
             expensesshipper = (ExpensesshipperForm)expInvoiceList.get(i);
             
//             if (expensesshipper.getIsTax().intValue()==1) {
//                 exTotalTaxShipper = exTotalTaxShipper + expensesshipper.getCharge().doubleValue();
//             }
//             if (expensesagent.getIsTax().intValue()==1) {
//                 exTotalVatShipper = exTotalVatShipper + expensesshipper.getCharge().doubleValue();
//             }             
             expensesshipper = com.wings.adapter.StrutsExpensesshipperDelegate.create(expensesshipper);             
         }
         
//         exTotalTaxShipper = exTotalTaxShipper * 0.02;
//         exTotalVatShipper = exTotalVatShipper * 0.10;
         

         jobsheetForm.setVatIDR(new Double(vatAgent));
         jobsheetForm.setPphIDR(new Double(pph23Agent));         
         
         jobsheetForm.setVatUSD(new Double(0.0));
         jobsheetForm.setPphUSD(new Double(0.0));         
         
         jobsheetForm.setDppIDR(new Double(totalDPPAgent + totalPPHAgent));
         jobsheetForm.setDppUSD(new Double(0.0));         
         
         com.wings.adapter.StrutsJobsheetDelegate.updateTaxVat(jobsheetForm);
         
         // create header transaction acc debit
         PopulateAccount populateAccount = new PopulateAccount();
         if (jobsheetForm.getJaminan().doubleValue()>0.0) {
             populateAccount.insertJaminanToAccount(jobsheetForm);
         }
                           
//       populateAccount.generateAccountDataHeaderDebit(jobsheetForm, baDebitList);                  
          
         // create invoice acc header
//       populateAccount.generateAccountDataHeaderInvoice(jobsheetForm, baInvoiceList);         
         
         // account Operational Expense/Selling/Billing
         TransactionaccForm trFormDebitExpenses = populateAccount.generateAccountDataHeaderDebitExpenses(jobsheetForm, baDebitList);   
         populateAccount.insertDetailAccountDataDebitExpenses(trFormDebitExpenses, jobsheetForm, baDebitList);
         // account Operational Expense/Cost
         TransactionaccForm trFormDebitCost = populateAccount.generateAccountDataHeaderDebitCost(jobsheetForm, expDebitList);                  
         populateAccount.insertDetailAccountDataDebitCost(trFormDebitCost, jobsheetForm, expDebitList);
         //populateAccount.generateAccountDataHeaderInvoiceExpenses(jobsheetForm, expInvoiceList);
         
         // account Sales/Selling
         TransactionaccForm trFormInvoiceExpenses = populateAccount.generateAccountDataHeaderInvoiceExpenses(jobsheetForm, baInvoiceList);                  
         populateAccount.insertDetailAccountDataInvoiceExpenses(trFormInvoiceExpenses, jobsheetForm, baInvoiceList);
         
         TransactionaccForm trFormInvoiceCost = populateAccount.generateAccountDataHeaderInvoiceCost(jobsheetForm, expInvoiceList);
         populateAccount.insertDetailAccountDataInvoiceCost(trFormInvoiceCost, jobsheetForm, expInvoiceList);
         
         
   }          
}
