package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaoDetailForm;
import com.wings.web.struts.forms.JobsheetaoForm;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.RequestUtils;


public final class ViewJobsheetaoAction extends Action {

   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "select"); 
      DynaActionForm dForm = (DynaActionForm)form;
      
      try {
          List shippers = com.wings.adapter.StrutsShipperDelegate.findAll(null);          
          request.setAttribute("shipperList", shippers); 
          
          List consignees = com.wings.adapter.StrutsConsigneeDelegate.findAll(null);          
          request.setAttribute("consigneeList", consignees); 
          
          List agents = com.wings.adapter.StrutsAgentDelegate.findAll(null);          
          request.setAttribute("agents", agents);
          
          List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
          request.setAttribute("agentfees", agentfeeList); 
          
          List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
          request.setAttribute("shipperfees", shipperfeeList); 
                    
          JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();  
          RequestUtils.populate(jobsheetaoDetailForm, request);
          
          JobsheetForm jobsheetForm = new JobsheetForm();
          jobsheetForm.setIdJobSheet(jobsheetaoDetailForm.getIdJobSheet());
          
          jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);                    
          BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetForm);
          
          JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
          BeanUtils.copyProperties(jobsheetaoForm, jobsheetaoDetailForm);
          
          jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
          BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetaoForm);
          
          dForm.set("jobsheetaoDetailForm", jobsheetaoDetailForm);                           
          request.getSession().setAttribute("jobsheetaoDetailForm", jobsheetaoDetailForm);                                       
                    
          JobsheetKey jobsheetKey = new JobsheetKey();
          jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
          
          List billAgentList = com.wings.adapter.StrutsBillingagentDelegate.selectByIdJobSheet(jobsheetKey);
          request.setAttribute("billAgentList", billAgentList);  
          
          List billShipperList = com.wings.adapter.StrutsBillingshipperDelegate.selectByIdJobSheet(jobsheetKey);
          request.setAttribute("billShipperList", billShipperList);  
                    
          List expensesShipperList = com.wings.adapter.StrutsExpensesshipperDelegate.selectByIdJobSheet(jobsheetKey);
          request.setAttribute("expensesShipperList", expensesShipperList);  
                   
          List expensesAgentList = com.wings.adapter.StrutsExpensesagentDelegate.selectByJobsheetKey(jobsheetKey);
          request.setAttribute("expensesAgentList", expensesAgentList);  
           
      } catch (Exception e) {
          
          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
          saveErrors(request, errors);   
      }         
      return mapping.findForward("form");
   }     
}
