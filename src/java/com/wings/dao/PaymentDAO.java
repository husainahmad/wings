package com.wings.dao;

import com.wings.persistence.Payment;
import com.wings.persistence.PaymentKey;
import com.wings.web.struts.forms.DateSelection;
import java.util.List;

public interface PaymentDAO {

    void insert(Payment record);

    int updateByPrimaryKey(Payment record);

    Payment selectByPrimaryKey(PaymentKey key);
    
    List selectPayableCustomer(DateSelection dateSelection);

    int deleteByPrimaryKey(PaymentKey key);
    
}
