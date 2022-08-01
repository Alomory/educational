package com.thisgary.c3043.lab.module4;

/*
Activity 1
----------
Write a program to display person in-charge, transaction type (D-Deposit, W-Withdrawal), transaction
number and balance when the user withdrawing or deposit the money from the specific account.

You must define transaction number and balance as a static instance variable and each of the variables
defaulted to 0 and 1000.00 respectively.

Create the main program and run the following transactions:
1st transaction as a withdrawal transaction. Pass the parameters to the object using the following
information; account number = 1002, account name = “Ali”, transaction as withdrawal (“W”) and the
withdrawal amount is RM400.00.

2nd transaction as a deposit transaction. Pass the parameters to the object using the following
information; account number = 1002, account name = “Ali”, transaction as deposit (“D”) and the deposit
amount is RM100.00.

3rd transaction as a withdrawal transaction. Pass the parameters to the object using the following
information; account number = 1002, account name = “Ali”, transaction as withdrawal (“W”) and the
withdrawal amount is RM600.00

What are the last transaction number and the current balance?
Go run the code yourself
 */

public class Transaction {
    private String whoThis;
    private int accountNumber;
    private char transactionType;
    private static int transactionNumber = 0;
    private static double balance = 1000.00;

    public Transaction(String whoThis, int accountNumber, char transactionType, double amount) {
        this.whoThis = whoThis;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionNumber += 1;
        if (transactionType == 'D') {
            this.balance += amount;
        } else if (transactionType == 'W') {
            this.balance -= amount;
        }
    }

    public void overview() {
        System.out.println("Account Owner     : " + whoThis);
        System.out.println("Account Number    : " + accountNumber);
        System.out.println("Transaction type  : " + transactionType);
        System.out.println("Transaction number: " + transactionNumber);
        System.out.printf("Remaining Balance  : RM%.2f\n\n", balance);
    }

    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("Ali", 1002, 'W', 400);
        transaction1.overview();
        Transaction transaction2 = new Transaction("Ali", 1002, 'D', 100);
        transaction2.overview();
        Transaction transaction3 = new Transaction("Ali", 1002, 'W', 600);
        transaction3.overview();
    }
}
