package com.wings.web.struts.actions;

import com.wings.persistence.Agentfee;
import com.wings.reports.datasource.AgentDebitFeeDataSource;
import com.wings.web.struts.forms.AgentfeeForm;
import java.io.File;
import java.io.IOException;
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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class PrintAgentDebitFeeAction extends Action {
    
   SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   
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
            AgentfeeForm agentfeeForm = new AgentfeeForm();
            RequestUtils.populate(agentfeeForm, request);
            List agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(null);                        
            if (agentfeeForm.getIdJobType()!=null) {
                if (agentfeeForm.getIdJobType().equalsIgnoreCase("AI")) {
                    agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAll(agentfeeForm);                        
                } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("AI")) {
                    agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAllAI(agentfeeForm);                        
                } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("AO")) {
                    agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAllAO(agentfeeForm);                        
                } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("SI")) {
                    agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAllSI(agentfeeForm);                        
                } else if (agentfeeForm.getIdJobType().equalsIgnoreCase("SO")) {
                    agentFeeList = com.wings.adapter.StrutsAgentfeeDelegate.findAllSO(agentfeeForm);                        
                } 
            }             
            
            Object[][] dtReport = this.parseListToArray(agentFeeList);

            JasperCompileManager.compileReportToFile(context.getRealPath("/agentfee/DebitFeeReport.jrxml"));
            String reportFileName = context.getRealPath("/agentfee/DebitFeeReport.jasper");
            File reportFile = new File(reportFileName);
            if (!reportFile.exists())
                    throw new JRRuntimeException("File jasper not found. The report design must be compiled first.");

            Map parameters = new HashMap();                         
            String perDistrict = null;                   

            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(
                            reportFileName, 
                            parameters, 
                            new AgentDebitFeeDataSource(dtReport)
                            );

            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);    
            
            return mapping.findForward("view");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            return mapping.findForward("err");      
        }
                     
   }
   
   private Object[][] parseListToArray(List list) {        
        
        Object[][] valueOfTable = new Object[list.size()][12];          
        int j = 1;    
        int i = 0;
        try {            
            for (i = 0; i < list.size(); i++) {                
                Agentfee af = (Agentfee)list.get(i);
                valueOfTable[i][0] = String.valueOf(j);
                valueOfTable[i][1] = af.getDescription();
                valueOfTable[i][2] = af.getAliasName();
                if (af.getIsTax().equalsIgnoreCase("1")) {
                    valueOfTable[i][3] = "Yes";
                } else {
                    valueOfTable[i][3] = "No";
                }                
                valueOfTable[i][4] = af.getIdAccountAI();
                valueOfTable[i][5] = af.getIdAccountAO();
                valueOfTable[i][6] = af.getIdAccountSI();
                valueOfTable[i][7] = af.getIdAccountSO();
                valueOfTable[i][8] = af.getIdAccountCostAI();
                valueOfTable[i][9] = af.getIdAccountCostAO();
                valueOfTable[i][10] = af.getIdAccountCostSI();
                valueOfTable[i][11] = af.getIdAccountCostSO();   
                j++;
            }
                        
        } catch (Exception e) {
            //log.info(e);
        }
        return valueOfTable;  
    }     
}
