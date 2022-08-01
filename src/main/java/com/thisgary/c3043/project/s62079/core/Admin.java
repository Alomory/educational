package com.thisgary.c3043.project.s62079.core;

import com.thisgary.c3043.project.s62079.exception.LazyException;

import java.util.List;
import java.util.stream.Collectors;

public class Admin extends Account {
    public Admin(String username, String password) throws LazyException {
        super(username, password);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void removeAccount(String username) {
        Account account = getAccount(username);
        if (account != null) accounts.remove(account);
    }

    public List<Customer> getCustomers() {
        return accounts.stream()
                .filter(a -> a instanceof Customer)
                .map(a -> (Customer) a)
                .collect(Collectors.toList());
    }

    public static Admin getGenius() {
        try {
            return new Admin("admin", "admin");
        } catch (LazyException e) { // impossible
            return null;
        }
    }
}
