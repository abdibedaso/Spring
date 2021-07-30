package com.geekcolab.development;

import com.geekcolab.development.entity.Account;
import com.geekcolab.development.entity.Country;
import com.geekcolab.development.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);

        List<Account> accounts = accountService.getAccountList(new Country("United States"));
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
