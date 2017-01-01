package com.wings.dao;

import com.wings.persistence.Transactionacc;
import java.util.List;
import com.wings.persistence.TransactionaccKey;
import com.wings.web.struts.forms.MonthYearForm;

public interface TransactionaccDAO {

    
    TransactionaccKey insert(Transactionacc record);

    int updateByPrimaryKey(Transactionacc record);

    List selectByAll(MonthYearForm monthYearForm);
    
    List selectReportBB(MonthYearForm monthYearForm);
    
    List selectReportGL(MonthYearForm monthYearForm);    

    List selectReportGLSaldo(MonthYearForm monthYearForm);

    List selectReportRL(MonthYearForm monthYearForm);    
    
    List selectReportNL(MonthYearForm monthYearForm);    
    
    Transactionacc selectByPrimaryKey(TransactionaccKey key);
    
    Transactionacc selectTotalByDateAndBatchNo(MonthYearForm monthYearForm);
    
    Integer selectNoUrut(Transactionacc record);
    
    int deleteByPrimaryKey(TransactionaccKey key);
    
    int deleteByJobNo(Transactionacc key);
}
