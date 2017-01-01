package com.wings.web.struts.actions;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.*;
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


public final class CopyJobsheetsiAction extends Action {

 
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

      request.setAttribute("action", "copy");
      DynaActionForm dForm = (DynaActionForm)form;
      JobsheetsiDetailForm jobsheetsiDetailForm = new JobsheetsiDetailForm();

      try {
          DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

          List agentfeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);
          request.setAttribute("agentfees", agentfeeList);

          List shipperfeeList = com.wings.adapter.StrutsShipperfeeDelegate.findAll(null);
          request.setAttribute("shipperfees", shipperfeeList);

          RequestUtils.populate(jobsheetsiDetailForm, request);

          JobsheetForm jobsheetForm = new JobsheetForm();
          jobsheetForm.setIdJobSheet(jobsheetsiDetailForm.getIdJobSheet());

          jobsheetForm = com.wings.adapter.StrutsJobsheetDelegate.edit(jobsheetForm);
          BeanUtils.copyProperties(jobsheetsiDetailForm, jobsheetForm);

          JobsheetsiForm jobsheetsiForm = new JobsheetsiForm();
          jobsheetsiForm.setIdJobSheet(jobsheetForm.getIdJobSheet());

          jobsheetsiForm = com.wings.adapter.StrutsJobsheetsiDelegate.editByIdJobsheet(jobsheetsiForm);
          jobsheetsiDetailForm.setIdJobSheetSi(jobsheetsiForm.getIdJobSheetSi());
          jobsheetsiDetailForm.setIdJobSheet(jobsheetsiForm.getIdJobSheet());
          jobsheetsiDetailForm.setShippingLine(jobsheetsiForm.getShippingLine());
          jobsheetsiDetailForm.setFeederVessel(jobsheetsiForm.getFeederVessel());
          jobsheetsiDetailForm.setMvessel(jobsheetsiForm.getMvessel());
          jobsheetsiDetailForm.setTermMbl(jobsheetsiForm.getTermMbl());
          jobsheetsiDetailForm.setTermHbl(jobsheetsiForm.getTermHbl());
          jobsheetsiDetailForm.setOrigin(jobsheetsiForm.getOrigin());
          jobsheetsiDetailForm.setCmb(jobsheetForm.getCmb());
          try {
              jobsheetsiDetailForm.setEtaoriginAsString(formatDate.format(jobsheetsiForm.getEtaorigin()));
          } catch (Exception e) {
              jobsheetsiDetailForm.setEtaoriginAsString("");
          }
          try {
              jobsheetsiDetailForm.setEtdoriginAsString(formatDate.format(jobsheetsiForm.getEtdorigin()));
          } catch (Exception e) {
              jobsheetsiDetailForm.setEtdoriginAsString("");
          }
          try {
              jobsheetsiDetailForm.setCustomDateAsString(formatDate.format(jobsheetsiForm.getCustomeDate()));
          } catch (Exception e) {
              jobsheetsiDetailForm.setCustomDateAsString("");
          }

          jobsheetsiDetailForm.setPod(jobsheetsiForm.getPod());
          jobsheetsiDetailForm.setTrucking(jobsheetsiForm.getTrucking());
          jobsheetsiDetailForm.setCommodity(jobsheetsiForm.getCommodity());
          jobsheetsiDetailForm.setBillTo(jobsheetsiForm.getBillTo());
          jobsheetsiDetailForm.setBillToDebit(jobsheetsiForm.getBillToDebit());
          
          
          ConsigneeForm consigneeAsShippingLine = new ConsigneeForm();
          consigneeAsShippingLine.setIdConsignee(jobsheetsiForm.getShippingLine());
          ShippinglineForm  shippinglineForm  = new ShippinglineForm();
            try {
                consigneeAsShippingLine = com.wings.adapter.StrutsConsigneeDelegate.edit(consigneeAsShippingLine);
                shippinglineForm.setName(consigneeAsShippingLine.getName());
                shippinglineForm.setIdShippingLine(consigneeAsShippingLine.getIdConsignee());
                shippinglineForm.setAddress1(consigneeAsShippingLine.getAddress1());
                shippinglineForm.setAddress2(consigneeAsShippingLine.getAddress2());
                shippinglineForm.setTelp(consigneeAsShippingLine.getTelp());
                shippinglineForm.setFax(consigneeAsShippingLine.getFax());

                jobsheetsiDetailForm.setShippingLineName(shippinglineForm.getName());
                jobsheetsiDetailForm.setShippingLine(shippinglineForm.getIdShippingLine());
            } catch (Exception e) {
            }

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
          
          ShipperForm shipperFormAsForwarder = new ShipperForm();   
          shipperFormAsForwarder.setIdShipper(jobsheetForm.getIdForwarder());
          try {
            shipperFormAsForwarder = com.wings.adapter.StrutsShipperDelegate.edit(shipperFormAsForwarder);
          } catch (Exception e) {              
          }  
          jobsheetsiDetailForm.setForwarderName(shipperFormAsForwarder.getName());
          

          TransporterForm transporterForm = new TransporterForm();
          transporterForm.setIdTransporter(jobsheetForm.getIdTransporter());
          try {
            transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
          } catch (Exception e) {
          }

          DestinationForm destinationForm = new DestinationForm();
          destinationForm.setIdDestination(jobsheetsiForm.getOrigin());
          try {
            destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
          } catch (Exception e) {
          }

          jobsheetsiDetailForm.setAgentName(agentForm.getName());
          jobsheetsiDetailForm.setConsigneeName(consigneeForm.getName());
          jobsheetsiDetailForm.setShipperName(shipperForm.getName());
          jobsheetsiDetailForm.setIdTransporter(transporterForm.getIdTransporter());
          jobsheetsiDetailForm.setTransportName(transporterForm.getName());
          jobsheetsiDetailForm.setDestinationName(destinationForm.getName());
          jobsheetsiDetailForm.setForwarderName(shipperFormAsForwarder.getName());
          jobsheetsiDetailForm.setIdForwarder(shipperFormAsForwarder.getIdShipper());
          
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
      //dForm.set("jobsheetsiDetailForm", jobsheetsiDetailForm);
      request.getSession().setAttribute("jobsheetsiDetailForm", jobsheetsiDetailForm);
      return mapping.findForward("form");
   }
}
