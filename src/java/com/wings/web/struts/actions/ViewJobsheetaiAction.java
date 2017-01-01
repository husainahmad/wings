package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaiDetailForm;
import com.wings.web.struts.forms.JobsheetaiForm;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


public final class ViewJobsheetaiAction extends Action {

  
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
          DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
          
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
                    
          JobsheetaiDetailForm jobsheetaiDetailForm = new JobsheetaiDetailForm();  
          RequestUtils.populate(jobsheetaiDetailForm, request);
          
          JobsheetForm jobsheetForm = new JobsheetForm();
          jobsheetForm.setIdJobSheet(jobsheetaiDetailForm.getIdJobSheet());
          
          jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);                    
          BeanUtils.copyProperties(jobsheetaiDetailForm, jobsheetForm);
          
          JobsheetaiForm jobsheetaiForm = new JobsheetaiForm();
          BeanUtils.copyProperties(jobsheetaiForm, jobsheetaiDetailForm);
          
          jobsheetaiForm = com.wings.adapter.StrutsJobsheetaiDelegate.editByIdJobsheet(jobsheetaiForm);
          BeanUtils.copyProperties(jobsheetaiDetailForm, jobsheetaiForm);
          
          dForm.set("jobsheetaiDetailForm", jobsheetaiDetailForm);                           
          request.getSession().setAttribute("jobsheetaiDetailForm", jobsheetaiDetailForm);                                       
                    
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
