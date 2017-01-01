package com.wings.dao;

import com.wings.persistence.AccountKey;
import java.util.List;
import com.wings.persistence.Account;
import com.wings.persistence.AccountSaldo;
import com.wings.web.struts.forms.MonthYearForm;

public interface AccountSaldoDAO {

    void insert(AccountSaldo record);

    int updateByPrimaryKey(AccountSaldo record);

    List selectByAll(AccountSaldo account);
    
    List selectByIdAccount(AccountKey key);
    
    List selectByAccountName(AccountSaldo record);
    
    List selectByDate(MonthYearForm monthYearForm);

    AccountSaldo selectByPrimaryKey(AccountSaldo key);
    
    AccountSaldo selectByKas(MonthYearForm monthYearForm);
    
    AccountSaldo selectByBank(MonthYearForm monthYearForm);

    AccountSaldo selectByDeposit(MonthYearForm monthYearForm);

    AccountSaldo selectByPiutang(MonthYearForm monthYearForm);
    
    AccountSaldo selectByPiutangPihak(MonthYearForm monthYearForm);

    AccountSaldo selectByPajak(MonthYearForm monthYearForm);

    AccountSaldo selectByAktivaTidakLancar(MonthYearForm monthYearForm);

    AccountSaldo selectByHutangLancar(MonthYearForm monthYearForm);

    AccountSaldo selectByHutangLeasing(MonthYearForm monthYearForm);

    AccountSaldo selectByHutangPajak(MonthYearForm monthYearForm);

    AccountSaldo selectByEkuitas(MonthYearForm monthYearForm);
    
    AccountSaldo selectByEkuitas2(MonthYearForm monthYearForm);
     
    AccountSaldo selectByEkuitas3(MonthYearForm monthYearForm);
    
    List selectByRL(MonthYearForm monthYearForm);
    
    int deleteByPrimaryKey(AccountSaldo key);
}
