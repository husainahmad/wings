package com.wings.dao;

import com.wings.persistence.DebitKey;
import com.wings.persistence.Debit;
import com.wings.persistence.DebitAIDetail;
import com.wings.persistence.DebitAODetail;
import com.wings.persistence.DebitSIDetail;
import com.wings.persistence.DebitSODetail;
import com.wings.persistence.JobsheetKey;
import java.util.List;

public interface DebitDAO {

   
    void insert(Debit record);

  
    int updateByPrimaryKey(Debit record);
    
    int updatePayableByPrimaryKey(Debit record);
    
    int updatePayableByDebitNumber(Debit record);
     
    Debit selectByPrimaryKey(DebitKey key);
    
    Debit selectByMaxDebitNumber(Debit debit);
    
    int deleteByPrimaryKey(DebitKey key);
    
    int deleteByIdJobsheet(JobsheetKey key);
    
    List selectByAll(com.wings.web.struts.forms.MonthYearForm monthYearForm);
    
    String selectJobTypeByPrimaryKey(DebitKey key);
    
    DebitAIDetail selectJobAIDetailByPrimaryKey(DebitKey key);
    
    DebitAODetail selectJobAODetailByPrimaryKey(DebitKey key);
    
    DebitSIDetail selectJobSIDetailByPrimaryKey(DebitKey key);
    
    DebitSODetail selectJobSODetailByPrimaryKey(DebitKey key);

    Debit selectByIdJobsheet(Debit debit);
    
}
