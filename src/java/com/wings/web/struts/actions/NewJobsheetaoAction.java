package com.wings.web.struts.actions;

import com.wings.web.struts.forms.AgentfeeForm;
import com.wings.web.struts.forms.JobsheetaoDetailForm;
import com.wings.web.struts.forms.ShipperfeeForm;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


public final class NewJobsheetaoAction extends Action {

   
   public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "insert"); 
      DynaActionForm dForm = (DynaActionForm)form;
      
      try {
//          List shippers = com.wings.adapter.StrutsShipperDelegate.findAll();          
//          request.setAttribute("shipperList", shippers); 
//          
//          List consignees = com.wings.adapter.StrutsConsigneeDelegate.findAll();          
//          request.setAttribute("consigneeList", consignees); 
//          
//          List agents = com.wings.adapter.StrutsAgentDelegate.findAll();          
//          request.setAttribute("agents", agents); 
          
          List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
          request.setAttribute("agentfees", agentfeeList); 
          
          List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
          request.setAttribute("shipperfees", shipperfeeList); 
          
//          List transporters = com.wings.adapter.StrutsTransporterDelegate.findAll();			
//          request.setAttribute("transporters", transporters);
//          
//          List destinations = com.wings.adapter.StrutsDestinationDelegate.findAll();			                    
//          request.setAttribute("destinations", destinations);
          
          JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();     
          jobsheetaoDetailForm.setCreditNoteIDR(new Double(0));
          jobsheetaoDetailForm.setCreditNoteUSD(new Double(0));
          //dForm.set("jobsheetaoDetailForm", jobsheetaoDetailForm);                           
          request.getSession().setAttribute("jobsheetaoDetailForm", jobsheetaoDetailForm);                                       
                    
      } catch (Exception e) {
          
          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
          saveErrors(request, errors);   
      }         
      return mapping.findForward("form");
   }
}
