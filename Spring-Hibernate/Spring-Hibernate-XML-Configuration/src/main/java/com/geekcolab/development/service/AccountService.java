package com.geekcolab.development.service;

import java.util.List;

import com.geekcolab.development.dao.AccountDAO;
import com.geekcolab.development.dao.IAccountDAO;
import com.geekcolab.development.entity.Account;
import com.geekcolab.development.entity.Country;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountService implements IAccountService {

    SessionFactory sessionFactory;

    private IAccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Account> getAllAccounts() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Account> accounts = accountDAO.getAllAccounts();
        tx.commit();

        return accounts;
    }

    public List<Account> getAccountList(Country country) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Account> accounts = accountDAO.getAccountList(country);
        tx.commit();

        return accounts;
    }


}
