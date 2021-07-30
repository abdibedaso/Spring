package com.geekcolab.development.dao;

import com.geekcolab.development.entity.Country;
import com.geekcolab.development.entity.Account;

import java.util.List;

public interface IAccountDAO {
    public List<Account> getAllAccounts();
    public List<Account> getAccountList(Country country);
}
