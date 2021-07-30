package com.geekcolab.development.bank.service;

import java.util.Collection;

import com.geekcolab.development.bank.dao.IAccountDAO;
import com.geekcolab.development.bank.domain.Account;
import com.geekcolab.development.bank.domain.AccountEntry;
import com.geekcolab.development.bank.domain.Customer;
import com.geekcolab.development.bank.jms.IJMSSender;
import com.geekcolab.development.bank.logging.ILogger;
import org.springframework.scheduling.annotation.Scheduled;

public class AccountService implements IAccountService {

    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private IJMSSender jmsSender;
    private ILogger logger;

    public AccountService() {
    }

    @Scheduled(cron="0/10 * * * * *")
    public void printAccountStatements() {
        // show balances
        Collection<Account> accountlist = getAllAccounts();

        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            }
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }

    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }

    public Account getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    public void depositEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }

    public void withdrawEuros(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount + " to account with accountNumber= " + toAccount);
        }
    }

    public void setAccountDAO(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setCurrencyConverter(ICurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public void setJmsSender(IJMSSender jmsSender) {
        this.jmsSender = jmsSender;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }
}
