package com.wings.web.struts.actions;

import com.wings.persistence.BillingagentDetail;
import com.wings.persistence.JobsheetKey;
import com.wings.reports.datasource.JobsheetDataSource;
import com.wings.web.struts.forms.AgentForm;
import com.wings.web.struts.forms.ConsigneeForm;
import com.wings.web.struts.forms.DestinationForm;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.JobsheetaiDetailForm;
import com.wings.web.struts.forms.JobsheetaiForm;
import com.wings.web.struts.forms.ShipperForm;
import com.wings.web.struts.forms.TransporterForm;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.RequestUtils;


public final class CopyJobsheetaiAction extends Action {

   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
   public ActionForward execute(ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

       ServletContext context = this.getServlet().getServletConfig().getServletContext();

      request.setAttribute("action", "copy");
      DynaActionForm dForm = (DynaActionForm)form;

      try {
          DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

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
          jobsheetaiDetailForm.setForwarderName(shipperFormAsForwarder.getName());
          
          TransporterForm transporterForm = new TransporterForm();
          transporterForm.setIdTransporter(jobsheetForm.getIdTransporter());
          try {
            transporterForm = com.wings.adapter.StrutsTransporterDelegate.edit(transporterForm);
          } catch (Exception e) {
          }

          DestinationForm destinationForm = new DestinationForm();
          destinationForm.setIdDestination(jobsheetaiForm.getDestination());
          try {
            destinationForm = com.wings.adapter.StrutsDestinationDelegate.edit(destinationForm);
          } catch (Exception e) {
          }

          jobsheetaiDetailForm.setAgentName(agentForm.getName());
          jobsheetaiDetailForm.setConsigneeName(consigneeForm.getName());
          jobsheetaiDetailForm.setShipperName(shipperForm.getName());
          jobsheetaiDetailForm.setIdTransporter(transporterForm.getIdTransporter());
          jobsheetaiDetailForm.setTransportName(transporterForm.getName());
          jobsheetaiDetailForm.setDestinationName(destinationForm.getName());
          
          jobsheetaiDetailForm.setForwarderName(shipperFormAsForwarder.getName());
          jobsheetaiDetailForm.setIdForwarder(shipperFormAsForwarder.getIdShipper());
          
          //dForm.set("jobsheetaiDetailForm", jobsheetaiDetailForm);
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

           return mapping.findForward("form");
      } catch (Exception e) {

          ActionErrors errors = new ActionErrors();
          errors.add("errors", new ActionError("err.message",e.getLocalizedMessage()));
          saveErrors(request, errors);
          return mapping.findForward("form");
      }         
     
   }
      
}
