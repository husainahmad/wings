package com.wings.web.struts.actions;

import com.wings.persistence.InvoiceAIDetail;
import com.wings.utils.GenerateDate;
import com.wings.web.struts.forms.MonthYearForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;
import org.joda.time.DateTime;
import org.josql.Query;
import org.josql.QueryResults;


public final class NewPaymentAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      request.setAttribute("action", "insert");
    
      try {
            MonthYearForm monthYearForm = new MonthYearForm();             
            RequestUtils.populate(monthYearForm, request);
            GenerateDate generateDate = new GenerateDate();

            Date now = Calendar.getInstance().getTime();          
            DateTime dateTime = new DateTime(now);       
            int iyear = dateTime.getYear();
            int imonth = dateTime.getMonthOfYear();

            List yearList = generateDate.getYears(iyear);
            List monthList = generateDate.getMonths();
            request.setAttribute("yearList", yearList);                
            request.setAttribute("monthList", monthList);  

            if (monthYearForm.getYear()==null)  {
                monthYearForm.setYear(new Integer(iyear));
            }
            if (monthYearForm.getMonth()==null) {
                monthYearForm.setMonth(new Integer(imonth));
            }

            List list = com.wings.adapter.StrutsJobsheetDelegate.selectStatementOfAccountByMonthAndYear(monthYearForm);
            list = this.clearUnusedData(list, request);
            
            request.setAttribute("PayableList", list);
            
      } catch (Exception e) {
          
      }      

      return mapping.findForward("form");
   }
   
      private List clearUnusedData(List repList, HttpServletRequest request) {
       
       List reportList = new ArrayList();
       List newRepList = new ArrayList();
       InvoiceAIDetail invoiceAIDetail = null;
       InvoiceAIDetail newInvoiceAIDetail = null;
       
       for (int i=0;i<repList.size();i++) {
            invoiceAIDetail = (InvoiceAIDetail)repList.get(i);
            if (invoiceAIDetail.getIdNumber().substring(0,1).equalsIgnoreCase("D")) { // means Debit
                newInvoiceAIDetail = (InvoiceAIDetail)invoiceAIDetail;
                if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("1")) {
                    // 1:agent
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdAgent());          
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdAAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdAAccountUSD());          
                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("2")) {
                    // 2:Consignee
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdConsignee());                    
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdCAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdCAccountUSD());          
                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("3")) {
                    // 3:Shipper
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdShipper());                    
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdSAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdSAccountUSD());          
                    
                } else if (invoiceAIDetail.getBillToDebit().equalsIgnoreCase("4")) {
                    // 4:ShippingLine
                    newInvoiceAIDetail.setName(invoiceAIDetail.getShippingLine());                    
                    newInvoiceAIDetail.setIdAccountIDR("");          
                    newInvoiceAIDetail.setIdAccountUSD("");          
                    
                } 
            } else {
                newInvoiceAIDetail = (InvoiceAIDetail)invoiceAIDetail;
                if (invoiceAIDetail.getBillTo().equalsIgnoreCase("1")) {
                    // 1:agent
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdAgent());           
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdAAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdAAccountUSD());     
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("2")) {
                    // 2:Consignee
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdConsignee());      
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdCAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdCAccountUSD()); 
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("3")) {
                    // 3:Shipper
                    newInvoiceAIDetail.setName(invoiceAIDetail.getIdShipper());    
                    newInvoiceAIDetail.setIdAccountIDR(invoiceAIDetail.getIdSAccountIDR());          
                    newInvoiceAIDetail.setIdAccountUSD(invoiceAIDetail.getIdSAccountUSD()); 
                } else if (invoiceAIDetail.getBillTo().equalsIgnoreCase("4")) {
                    // 4:ShippingLine
                    newInvoiceAIDetail.setName(invoiceAIDetail.getShippingLine()); 
                    newInvoiceAIDetail.setIdAccountIDR("");          
                    newInvoiceAIDetail.setIdAccountUSD(""); 
                }
            }
            newRepList.add(newInvoiceAIDetail);
       }
       
       reportList = newRepList;
       
       if(request.getParameter("idCostomer")!=null) {
           if (!request.getParameter("idCostomer").equalsIgnoreCase("")) {
               reportList = new ArrayList();
               invoiceAIDetail = null;
               try {
                    for (int i=0;i<newRepList.size();i++) {
                        invoiceAIDetail = (InvoiceAIDetail)repList.get(i);
                        if (invoiceAIDetail.getName()!=null) {
                            if (invoiceAIDetail.getName().equalsIgnoreCase(request.getParameter("idCostomer").toString())) {
                                if ((invoiceAIDetail.getIsPayable()==null) || (invoiceAIDetail.getIsPayable().equalsIgnoreCase(""))) {
                                    reportList.add(invoiceAIDetail);
                                }                            
                            }
                        }                        
                   }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }               
           } 
       }
       
       List realList = new ArrayList();
       try {            
            Query q = new Query ();            
            q.parse ("SELECT * FROM com.wings.persistence.InvoiceAIDetail order by name");

            // Execute the query.
            QueryResults qr = q.execute (reportList);

            // Cycle over the query results.
            List res = qr.getResults ();

            for (int i = 0; i < res.size (); i++)
            {
                invoiceAIDetail = (InvoiceAIDetail)res.get (i);                                
                realList.add(invoiceAIDetail);
            }
        } catch (Exception e) {            
        }       
       //Collections.sort(reportList,); 
       return realList;
   }
}
