package com.geekcolab.development.dao;

import com.geekcolab.development.entity.Country;
import com.geekcolab.development.entity.Account;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO implements IAccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Account> getAllAccounts() {
        // Query
        Query query = sessionFactory.getCurrentSession().createQuery("from Account c");
        query.setParameter("countryName", "United States");

        return query.list();
    }


    public List<Account> getAccountList(Country country) {
        // Query
        Query query = sessionFactory.getCurrentSession().createQuery("from Account c where c.address.city.country.name = :countryName");
        query.setParameter("countryName", "United States");
        List<Account> accounts = query.list();

        return query.list();
    }
}