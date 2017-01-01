package com.wings.dao;

import com.wings.persistence.InvoicekreditExample;
import com.wings.persistence.InvoicekreditKey;
import com.ibatis.dao.client.DaoManager;
import java.util.Map;
import java.util.List;
import com.wings.persistence.Invoicekredit;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import java.util.HashMap;

public class InvoicekreditDAOImpl extends SqlMapDaoTemplate implements InvoicekreditDAO {

   
    public InvoicekreditDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    
    public void insert(Invoicekredit record) {
        insert("invoicekredit_insert", record);
    }

    
    public int updateByPrimaryKey(Invoicekredit record) {
        int rows = update("invoicekredit_updateByPrimaryKey", record);

        return rows;
    }

    
   
    public Invoicekredit selectByPrimaryKey(InvoicekreditKey key) {
        Invoicekredit record = (Invoicekredit) queryForObject("invoicekredit_selectByPrimaryKey", key);

        return record;
    }

   
    public int deleteByPrimaryKey(InvoicekreditKey key) {
        int rows = delete("invoicekredit_deleteByPrimaryKey", key);

        return rows;
    }

    public int deleteByIdInvoice(Invoicekredit key) {
        int rows = delete("invoicekredit_deleteByIdInvoice", key);

        return rows;
    }

    public List selectByIdInvoice(Invoicekredit record) {
        List records = (List) queryForList("invoicekredit_selectByIdInvoice", record);

        return records;
    }

}
