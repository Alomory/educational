package com.thisgary.c3043.lab.module3;

import java.util.ArrayList;
import java.util.List;

/*
Activity 4
----------
You need to write the program to display bank transaction. Transaction class consists of these attributes:
Account number - can be accessed by other program via specific method.
Account name - can be accessed by other program via specific method.
Type of account - can be access by any program.
Transaction date - can be accessed by other program via specific method.
The transaction date has a Date class. Write the main program to display:
i. The transaction for account = “10021”, account holder = “Abdul Rahman”
ii. The transaction for account = “10021”, account holder = “Abdul Rahman” and transaction date = “12 Aug 2011”
 */

public class Transaction {
    private int accountNumber;
    private String accountName;
    public char accountType;
    private List<Date> transactionDates = new ArrayList<Date>();

    public Transaction(int accountNumber, String accountName, char accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void addTransactionDate(int day, int month, int year) {
        transactionDates.add(new Date(day, month, year));
    }

    public List<Date> getTransactionDate() {
        return transactionDates;
    }

    public void overview() {
        System.out.printf("Account number : %d\n", accountNumber);
        System.out.printf("Account name   : %s\n", accountName);
        System.out.printf("Account type   : %s\n", accountType);
        System.out.printf("Last transacted: %s\n\n", transactionDates.get(transactionDates.size() - 1).toString());
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction(10021, "Abdul Rahman", 'S');
        transaction.addTransactionDate(12, 8, 2011);
        transaction.overview();
    }
}
