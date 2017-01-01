package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.Payment;
import com.wings.persistence.PaymentKey;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.web.struts.forms.DateSelection;
import java.util.List;

public class PaymentDAOImpl extends SqlMapDaoTemplate implements PaymentDAO {

    public PaymentDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(Payment record) {
        insert("payment_insert", record);
    }

    public int updateByPrimaryKey(Payment record) {
        int rows = update("payment_updateByPrimaryKey", record);

        return rows;
    }

    public Payment selectByPrimaryKey(PaymentKey key) {
        Payment record = (Payment) queryForObject("payment_selectByPrimaryKey", key);

        return record;
    }
    
    public int deleteByPrimaryKey(PaymentKey key) {
        int rows = delete("payment_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectPayableCustomer(DateSelection dateSelection) {
        List records = (List) queryForList("payment_selectReportPayableCustomer", dateSelection);

        return records;
    }
   
}
