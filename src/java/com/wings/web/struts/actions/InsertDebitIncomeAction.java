package com.wings.web.struts.actions;

import com.wings.adapter.StrutsDebitKreditDelegate;
import com.wings.persistence.Income;
import com.wings.persistence.Debit;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.Debitkredit;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DebitForm;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class InsertDebitIncomeAction extends Action {
    
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {
        ServletContext context = this.getServlet().getServletConfig().getServletContext();
        try                        
        {
            DebitForm debitForm = new DebitForm();
            RequestUtils.populate(debitForm, request);
            
            DebitKey debitKey = new DebitKey();  
            debitKey.setIdDebit(debitForm.getIdDebit());
            
            Debit debit = new Debit();  
            debitForm = com.wings.adapter.StrutsDebitDelegate.edit(debitForm);
            BeanUtils.copyProperties(debit,debitForm);
            
            
            double totalUSD = 0.0;
            try {
                totalUSD = Double.valueOf(request.getParameter("totalUSD")).doubleValue();
            } catch (Exception e) {                
            }
            
            double totalIDR = 0.0;
            try {
                totalIDR = Double.valueOf(request.getParameter("totalIDR")).doubleValue();
            } catch (Exception e) {                
            }
            
            List debitKreditList = populateKredit(request, debitKey.getIdDebit());
            Debitkredit debitkredit = new Debitkredit();
            debitkredit.setIdDebit(debit.getIdDebit());
            
            StrutsDebitKreditDelegate.removeByIdDebit(debitkredit); 
            
            double totalIncome = 0.0;
            double totalKreditIDR = 0.0;
            double totalKreditUSD = 0.0;
            
            for (int i=0; i<debitKreditList.size(); i++) {
                 debitkredit = (Debitkredit)debitKreditList.get(i);
                 debitkredit = com.wings.adapter.StrutsDebitKreditDelegate.create(debitkredit);    
                 if (debitkredit.getKurs().equalsIgnoreCase("IDR")) {
                     totalKreditIDR+=debitkredit.getValue().doubleValue();
                 } else if (debitkredit.getKurs().equalsIgnoreCase("USD")) {
                     totalKreditUSD+=debitkredit.getValue().doubleValue();
                 }                                  
            }
            
            
            Income income = new Income();
            income.setRefId(debit.getDebitNumber());
            
            com.wings.adapter.StrutsIncomeDelegate.removeByRefId(income);
            // for IDR
            income.setRevenu(new Double(totalKreditIDR));
            income.setKurs("IDR");                        
            
            if (totalKreditIDR>0.0) {
                income = com.wings.adapter.StrutsIncomeDelegate.create(income);
            }
            // for USD
            income.setRevenu(new Double(totalKreditUSD));
            income.setKurs("USD");
            
            if (totalKreditUSD>0.0) {
                income = com.wings.adapter.StrutsIncomeDelegate.create(income);
            }
            //IncomeKey incomeKey = com.wings.adapter.StrutsIncomeDelegate.lastId();
            
            //invoice.setIdIncome(incomeKey.getIdIncome());
                                    
            if ((totalIDR<=totalKreditIDR) & (totalUSD<=totalKreditUSD)) {
                debit.setIsPayable("Y");
                debit = com.wings.adapter.StrutsDebitDelegate.updatePayableStatus(debit);
            }          
            
            return mapping.findForward("view");
            
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   
   private List populateKredit(HttpServletRequest request, Integer idDebit) {
       
      int countDebitKredit = Integer.parseInt(request.getParameter("countDebitKredit"));          
      List debitKreditList = new ArrayList();
      
      String value = null;
      String kurs = null;   
      String kreditDate = null;
      Debitkredit debitkredit = null;
           
      for (int i=1; i<countDebitKredit+1; i++) {
          
            kreditDate = "debitKreditDate" + i;
            value = "debitKreditValue" + i;
            kurs = "debitKreditKurs" + i;
            debitkredit = new Debitkredit();
            debitkredit.setIdDebit(idDebit);
            
            debitkredit.setKurs(request.getParameter(kurs));
            
            try {
                debitkredit.setValue(Double.valueOf(request.getParameter(value)));
            } catch (Exception e) {
                debitkredit.setValue(new Double(0.0));
            }
            
            try {
                debitkredit.setKreditDate(new java.sql.Date(FORMAT.parse(request.getParameter(kreditDate)).getTime()));
            } catch (Exception e) {
                debitkredit.setKreditDate(new java.sql.Date((new java.util.Date()).getTime()));
            }            
            debitKreditList.add(debitkredit);            
      }      
      return debitKreditList;      
   }
   
   private void executeAIReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitAIDetail debitAIDetail = com.wings.adapter.StrutsDebitDelegate.selectDebitAIDetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitAIDetail.getIdJobSheet());        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);        
        request.setAttribute("jobType", "AI");
        request.setAttribute("DebitAIDetail", debitAIDetail);
        request.setAttribute("Billingagents", list);
        request.setAttribute("action", "insert");
        return;         
       
   }
   private void executeAOReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitAODetail debitAODetail = com.wings.adapter.StrutsDebitDelegate.selectDebitAODetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitAODetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "AO");
        request.setAttribute("DebitAODetail", debitAODetail);
        request.setAttribute("Billingagents", list);
        request.setAttribute("action", "insert");
                  
        return;         
       
   }
   private void executeSIReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitSIDetail debitSIDetail = com.wings.adapter.StrutsDebitDelegate.selectDebitSIDetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitSIDetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "SI");
        request.setAttribute("DebitSIDetail", debitSIDetail);
        request.setAttribute("Billingagents", list);
        request.setAttribute("action", "insert");
                   
        return;         
       
   }
   private void executeSOReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitSODetail debitSODetail = com.wings.adapter.StrutsDebitDelegate.selectDebitSODetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitSODetail.getIdJobSheet());
        
        List list = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "SO");
        request.setAttribute("DebitSODetail", debitSODetail);
        request.setAttribute("Billingagents", list);   
        request.setAttribute("action", "insert");
        return;         
       
   }   
}
