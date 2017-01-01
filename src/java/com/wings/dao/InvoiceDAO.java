package com.wings.dao;

import com.wings.persistence.InvoiceAIDetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;
import com.wings.persistence.Invoice;
import com.wings.persistence.InvoiceAODetail;
import com.wings.persistence.InvoiceKey;
import com.wings.persistence.InvoiceSIDetail;
import com.wings.persistence.InvoiceSODetail;

public interface InvoiceDAO {

    
    void insert(Invoice record);

   
    int updateByPrimaryKey(Invoice record);

    int updatePayableByPrimaryKey(Invoice record);
    
    int updatePayableByInvoiceNumber(Invoice record);
    
    Invoice selectByPrimaryKey(InvoiceKey key);
    
    Invoice selectMaxInvoiceNumber(Invoice invoice);

    Invoice selectMaxInvoiceNumberAI(Invoice invoice);
    
    Invoice selectMaxInvoiceNumberAO(Invoice invoice);
    
    Invoice selectMaxInvoiceNumberSI(Invoice invoice);
    
    Invoice selectMaxInvoiceNumberSO(Invoice invoice);        
    
    Invoice selectByIdJobsheet(Invoice key);        

    List selectMaxInvoiceNumberAIList(Invoice invoice);
    
    List selectMaxInvoiceNumberAOList(Invoice invoice);
    
    List selectMaxInvoiceNumberSIList(Invoice invoice);
    
    List selectMaxInvoiceNumberSOList(Invoice invoice);        
    
    int deleteByPrimaryKey(InvoiceKey key);
    
    int deleteByIdJobsheet(JobsheetKey key);
    
    List selectByAll(com.wings.web.struts.forms.MonthYearForm monthYearForm);
    
    String selectJobTypeByPrimaryKey(InvoiceKey key);
    
    InvoiceAIDetail selectJobAIDetailByPrimaryKey(InvoiceKey key);
    
    InvoiceAODetail selectJobAODetailByPrimaryKey(InvoiceKey key);
    
    InvoiceSIDetail selectJobSIDetailByPrimaryKey(InvoiceKey key);
    
    InvoiceSODetail selectJobSODetailByPrimaryKey(InvoiceKey key);
    
    
}
