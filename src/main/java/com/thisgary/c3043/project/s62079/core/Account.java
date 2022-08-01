package com.thisgary.c3043.project.s62079.core;

import com.thisgary.c3043.project.s62079.exception.LazyException;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected static List<Account> accounts = new ArrayList<>();
    private String username;
    private String password;

    public static Account getAccount(String username) {
        return accounts.stream()
                .filter(a -> a.getUsername() != null && a.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Account(String username, String password) throws LazyException {
        setUsername(username);
        setPassword(password);
        accounts.add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws LazyException {
        if (username.equals("")) throw new LazyException("Invalid username");
        if (accounts.stream().anyMatch(a -> a.username != null && a.username.equals(username)))
            throw new LazyException("Username already exists");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws LazyException {
        if (password.equals("")) throw new LazyException("Invalid password");
        this.password = password;
    }

    public String toString() {
        return String.format("Username: %s\nPassword: %s\n", username, password);
    }
}
