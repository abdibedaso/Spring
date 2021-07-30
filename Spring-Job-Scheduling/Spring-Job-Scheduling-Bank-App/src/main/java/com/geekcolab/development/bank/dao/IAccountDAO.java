package com.geekcolab.development.bank.dao;

import java.util.Collection;

import com.geekcolab.development.bank.domain.Account;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
