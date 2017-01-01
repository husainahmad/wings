package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.TaxKey;
import com.wings.persistence.Tax;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.web.struts.forms.MonthYearForm;
import java.util.List;

public class TaxDAOImpl extends SqlMapDaoTemplate implements TaxDAO {
    
    public TaxDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }
    
    public void insert(Tax record) {
        insert("tax_insert", record);
    }
    
    public int updateByPrimaryKey(Tax record) {
        int rows = update("tax_updateByPrimaryKey", record);

        return rows;
    }

    public Tax selectByPrimaryKey(TaxKey key) {
        Tax record = (Tax) queryForObject("tax_selectByPrimaryKey", key);

        return record;
    }
   
    public int deleteByPrimaryKey(TaxKey key) {
        int rows = delete("tax_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectMonthly(MonthYearForm monthYearForm) {
        List records = (List) queryForList("tax_selectByMontlySelection", monthYearForm);

        return records;
    }
    
}
