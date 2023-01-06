package educational.c3043.lab.module1;

/*
Activity 4
----------
Figure 1 show the UML diagram for Account’s class. Based on UML diagram, display the account number,
account name and balance for account number = “1001”. Write your solution using object-oriented
approach.

            Account
  - AcctNo        : String
  - AcctName      : String
  - Balance       : double
  + getAcctNo()   : String
  + setAcctNo()   : void
  + getAcctName() : String
  + setAcctName() : void
  + getBalance()  : double

Algorithms:
Step 1 – Declare a class Account and attributes.
Step 2 – Create constructor
Step 3 – Initialize the values of account number, name and balance via constructor
Step 4 – Define getter and setter for each attribute
Step 5 - Declare a class AccountTest.
Step 6 – Instantiate Account class and display the account number, name and balance.
*/

public class Account {
    private String acctNo;
    private String acctName;
    private final double balance;

    public Account(String acctNo, String acctName, double balance) {
        this.acctNo = acctNo;
        this.acctName = acctName;
        this.balance = balance;
    }

    public String getAcctNo() {
        return (acctNo);
    }

    public String getAcctName() {
        return (acctName);
    }

    public double getBalance() {
        return (balance);
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public static void main(String[] args) {
        Account account = new Account("1001", "John Cena", 1000);
        System.out.println("Account number: " + account.getAcctNo());
        System.out.println("Account name: " + account.getAcctName());
        System.out.println("Account balance: " + account.getBalance());
    }
}
