package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.DestinationForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaoDetailForm;
import com.wings.web.struts.forms.JobsheetaoForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransporterForm;
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


public final class FindAsNewJobsheetaoAction extends Action {

 
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "updateAsNew"); 
      DynaActionForm dForm = (DynaActionForm)form;
      
      try {
          
          List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
          request.setAttribute("agentfees", agentfeeList); 
          
          List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
          request.setAttribute("shipperfees", shipperfeeList); 
                              
          JobsheetaoDetailForm jobsheetaoDetailForm = new JobsheetaoDetailForm();  
          RequestUtils.populate(jobsheetaoDetailForm, request);
          
          JobsheetForm jobsheetForm = new JobsheetForm();
          jobsheetForm.setIdJobSheet(jobsheetaoDetailForm.getIdJobSheet());
          
          jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);                    
          jobsheetForm.setInvoiceNoUsd("");
          jobsheetForm.setDebitNo("");          
          jobsheetForm.setInvoiceStatus("");
          jobsheetForm.setDebitStatus("");
          jobsheetForm.setTotalBillingIDR(new Double(0.0));
          jobsheetForm.setTotalBillingUSD(new Double(0.0));
          jobsheetForm.setTotalExpensesIDR(new Double(0.0));
          jobsheetForm.setTotalExpensesUSD(new Double(0.0));
          
          BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetForm);
          
          JobsheetaoForm jobsheetaoForm = new JobsheetaoForm();
          BeanUtils.copyProperties(jobsheetaoForm, jobsheetaoDetailForm);
          
          jobsheetaoForm = com.wings.adapter.StrutsJobsheetaoDelegate.editByIdJobsheet(jobsheetaoForm);
          BeanUtils.copyProperties(jobsheetaoDetailForm, jobsheetaoForm);
          
          ConsigneeForm consigneeForm = new ConsigneeForm();
          consigneeForm.setIdConsignee(jobsheetForm.getIdConsignee());
          try {
            consigneeForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeForm);
          } catch (Exception e) {              
          }
          
          ShipperForm shipperForm = new ShipperForm();          
          ConsigneeForm consigneeAsShipperForm = new ConsigneeForm();
          consigneeAsShipperForm.setIdConsignee(jobsheetForm.getIdShipper());
          shipperForm.setIdShipper(jobsheetForm.getIdShipper());
          try {
              consigneeAsShipperForm = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShipperForm);
              shipperForm.setName(consigneeAsShipperForm.getName());
              shipperForm.setIdShipper(consigneeAsShipperForm.getIdConsignee());
              shipperForm.setAddress1(consigneeAsShipperForm.getAddress1());
              shipperForm.setAddress2(consigneeAsShipperForm.getAddress2());
              shipperForm.setTelp(consigneeAsShipperForm.getTelp());
              shipperForm.setFax(consigneeAsShipperForm.getFax());
              
          } catch (Exception e) {
          }
          
          AgentForm agentForm = new AgentForm();
          ConsigneeForm consigneeAsAgent = new ConsigneeForm();
          consigneeAsAgent.setIdConsignee(jobsheetForm.getIdAgent());
          agentForm.setIdAgent(jobsheetForm.getIdAgent());
          try {
              consigneeAsAgent = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsAgent);
              agentForm.setName(consigneeAsAgent.getName());
              agentForm.setIdAgent(consigneeAsAgent.getIdConsignee());
              agentForm.setAddress1(consigneeAsAgent.getAddress1());
              agentForm.setAddress2(consigneeAsAgent.getAddress2());
              agentForm.setTelp(consigneeAsAgent.getTelp());
              agentForm.setFax(consigneeAsAgent.getFax());
              
            //agentForm = com.wings.adapter.StrutsAgentDelegate.edit(agentForm);
          } catch (Exception e) {
          }
                    
          TransporterForm transporterForm = new TransporterForm();
          transporterForm.setIdTransporter(jobsheetForm.getIdTransporter());
          try {
            transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
          } catch (Exception e) {              
          }
                    
          DestinationForm destinationForm = new DestinationForm();
          destinationForm.setIdDestination(jobsheetaoForm.getDestination());
          try {
            destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
          } catch (Exception e) {              
          }
          ShipperForm shipperFormAsForwarder = new ShipperForm();   
          shipperFormAsForwarder.setIdShipper(jobsheetForm.getIdForwarder());
          try {
            shipperFormAsForwarder = com.wings.adapter.StrutsShipperDelegate.edit(shipperFormAsForwarder);
          } catch (Exception e) {              
          }  
          jobsheetaoDetailForm.setIdJobSheet(null);
          jobsheetaoDetailForm.setAgentName(agentForm.getName());
          jobsheetaoDetailForm.setConsigneeName(consigneeForm.getName());
          jobsheetaoDetailForm.setShipperName(shipperForm.getName());
          jobsheetaoDetailForm.setIdTransporter(transporterForm.getIdTransporter());
          jobsheetaoDetailForm.setTransportName(transporterForm.getName());
          jobsheetaoDetailForm.setDestinationName(destinationForm.getName());
          jobsheetaoDetailForm.setForwarderName(shipperFormAsForwarder.getName());
          jobsheetaoDetailForm.setIdForwarder(shipperFormAsForwarder.getIdShipper());
//          dForm.set("jobsheetaoDetailForm", jobsheetaoDetailForm);                           
          request.getSession().setAttribute("jobsheetaoDetailForm", jobsheetaoDetailForm);                                       
                    
          JobsheetKey jobsheetKey = new JobsheetKey();
          jobsheetKey.setIdJobSheet(jobsheetForm.getIdJobSheet());
                
      } catch (Exception e) {
          
          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
          saveErrors(request, errors);   
      }         
      return mapping.findForward("form");
   }
}
