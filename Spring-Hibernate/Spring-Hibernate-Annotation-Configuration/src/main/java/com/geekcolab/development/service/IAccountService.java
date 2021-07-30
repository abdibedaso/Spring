package com.geekcolab.development.service;

import com.geekcolab.development.entity.Account;
import com.geekcolab.development.entity.Country;

import java.util.List;

public interface IAccountService {
    public List<Account> getAllAccounts();
    public List<Account> getAccountList(Country country);
}
