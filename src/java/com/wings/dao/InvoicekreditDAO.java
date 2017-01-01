package com.wings.dao;

import com.wings.persistence.InvoicekreditKey;
import com.wings.persistence.Invoicekredit;
import java.util.List;

public interface InvoicekreditDAO {
   
    void insert(Invoicekredit record);
   
    int updateByPrimaryKey(Invoicekredit record);    
   
    Invoicekredit selectByPrimaryKey(InvoicekreditKey key);
    
    List selectByIdInvoice(Invoicekredit record);
    
    int deleteByPrimaryKey(InvoicekreditKey key);
    
    int deleteByIdInvoice(Invoicekredit key);
    
}
