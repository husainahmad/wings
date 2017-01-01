package com.wings.web.struts.actions;

import com.wings.adapter.StrutsDebitKreditDelegate;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitKey;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.Debitkredit;
import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.DebitForm;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class NewDebitIncomeAction extends Action {       
   
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
            
            String jobType = com.wings.adapter.StrutsDebitDelegate.selectJobTypeByDebitKey(debitKey);
                        
            if (jobType.equalsIgnoreCase("AI")) {
                executeAIReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("AO")) {
                executeAOReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("SI")) {
                executeSIReport(request, debitKey, context);
            } else if (jobType.equalsIgnoreCase("SO")) {
                executeSOReport(request, debitKey, context);
            }
            
            Debitkredit debitkredit = new Debitkredit();
            debitkredit.setIdDebit(debitKey.getIdDebit());
            
            List debitKreditList = StrutsDebitKreditDelegate.findAllByIdDebit(debitkredit);
            request.setAttribute("debitKreditList", debitKreditList);
            
            return mapping.findForward("form");
            
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   private void executeAIReport(HttpServletRequest request, DebitKey debitKey, ServletContext context) throws Exception {
       
        DebitAIDetail debitAIDetail = com.wings.adapter.StrutsDebitDelegate.selectDebitAIDetailByDebitKey(debitKey);
        JobsheetKey jobsheetKey = new JobsheetKey();
        jobsheetKey.setIdJobSheet(debitAIDetail.getIdJobSheet());        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);          
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);
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
        
        List list = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);
        request.setAttribute("jobType", "SO");
        request.setAttribute("DebitSODetail", debitSODetail);
        request.setAttribute("Billingagents", list);   
        request.setAttribute("action", "insert");
        return;         
       
   }   
}
