package com.wings.dao;

import com.ibatis.dao.client.DaoManager;
import com.wings.persistence.AccountKey;
import java.util.List;
import com.wings.persistence.Account;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.AccountSaldo;
import com.wings.web.struts.forms.MonthYearForm;

public class AccountSaldoDAOImpl extends SqlMapDaoTemplate implements AccountSaldoDAO {

    public AccountSaldoDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public void insert(AccountSaldo record) {
        insert("accountSaldo_insert", record);
    }

    public int updateByPrimaryKey(AccountSaldo record) {
        int rows = update("accountSaldo_updateByPrimaryKey", record);

        return rows;
    }

    public AccountSaldo selectByPrimaryKey(AccountSaldo key) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByPrimaryKey", key);

        return record;
    }

    public int deleteByPrimaryKey(AccountSaldo key) {
        int rows = delete("accountSaldo_deleteByPrimaryKey", key);

        return rows;
    }    

    public List selectByIdAccount(AccountKey key) {
        List records = (List) queryForList("accountSaldo_selectByIdAccount", key);

        return records;
    }

    public List selectByAccountName(AccountSaldo record) {
        List records = (List) queryForList("accountSaldo_selectByAccountName", record);

        return records;
    }

    public List selectByAll(AccountSaldo account) {
        List records = (List) queryForList("accountSaldo_selectByAll", account);

        return records;
    }

    public List selectByDate(MonthYearForm monthYearForm) {
        List records = (List) queryForList("accountSaldo_selectByDate", monthYearForm);

        return records;
    }

    public AccountSaldo selectByKas(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByKas", monthYearForm);

        return record;
    }

    public AccountSaldo selectByBank(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByBank", monthYearForm);

        return record;
    }

    public AccountSaldo selectByDeposit(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByDeposit", monthYearForm);

        return record;
    }

    public AccountSaldo selectByPiutang(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByPiutang", monthYearForm);

        return record;
    }
    
     public AccountSaldo selectByPiutangPihak(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByPiutangPihak", monthYearForm);

        return record;
    }

    public AccountSaldo selectByPajak(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByPajak", monthYearForm);

        return record;
    }

    public AccountSaldo selectByAktivaTidakLancar(MonthYearForm monthYearForm) {
         AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByAktivaTidakLancar", monthYearForm);

        return record;
    }

    public AccountSaldo selectByHutangLancar(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByHutangLancar", monthYearForm);

        return record;
    }
    
    public AccountSaldo selectByHutangLeasing(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByHutangLeasing", monthYearForm);

        return record;
    }
    
    public AccountSaldo selectByHutangPajak(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByHutangPajak", monthYearForm);

        return record;
    }

    public AccountSaldo selectByEkuitas(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByEkuitas", monthYearForm);

        return record;
    }
    
    public AccountSaldo selectByEkuitas2(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByEkuitas2", monthYearForm);

        return record;
    }
    
    public AccountSaldo selectByEkuitas3(MonthYearForm monthYearForm) {
        AccountSaldo record = (AccountSaldo) queryForObject("accountSaldo_selectByEkuitas3", monthYearForm);

        return record;
    }

     public List selectByRL(MonthYearForm monthYearForm) {
        List records = (List) queryForList("accountSaldo_selectRL", monthYearForm);

        return records;
    }

    
}
