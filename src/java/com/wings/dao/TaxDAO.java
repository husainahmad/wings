package com.wings.dao;

import com.wings.persistence.TaxKey;
import com.wings.persistence.Tax;
import com.wings.web.struts.forms.MonthYearForm;
import java.util.List;

public interface TaxDAO {

    void insert(Tax record);
    
    int updateByPrimaryKey(Tax record);
        
    Tax selectByPrimaryKey(TaxKey key);

    int deleteByPrimaryKey(TaxKey key);
    
    List selectMonthly(MonthYearForm monthYearForm);
}
