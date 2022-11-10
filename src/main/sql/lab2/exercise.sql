DROP DATABASE IF EXISTS exercise;
CREATE DATABASE exercise;
USE exercise;

CREATE TABLE Branch (
    brID INT(5) PRIMARY KEY,
    brName VARCHAR(50),
    city VARCHAR(50),
    manager VARCHAR(50)
);

\! echo "Branch";
DESCRIBE Branch;

CREATE TABLE Customer (
    custIC INT(12) PRIMARY KEY,
    custName VARCHAR(50) NOT NULL,
    custAddress VARCHAR(255),
    town VARCHAR(50),
    custState VARCHAR(50),
    postcode INT(5),
    email VARCHAR(50),
    custStatus VARCHAR(50) DEFAULT "New"
);

\! echo "Customer";
DESCRIBE Customer;

CREATE TABLE Account (
    accID INT(12) PRIMARY KEY,
    custIC INT(12) NOT NULL,
    brID INT(5) NOT NULL,
    balance DOUBLE(8,2) NOT NULL DEFAULT 0.00,
    regDate DATE NOT NULL,
    FOREIGN KEY (custIC) REFERENCES Customer(custIC),
    FOREIGN KEY (brID) REFERENCES Branch(brID)
);

\! echo "Account";
DESCRIBE Account;

CREATE TABLE Loan (
    loanID INT(12) PRIMARY KEY,
    custIC INT(12) NOT NULL,
    loanType VARCHAR(10),
    brID INT(5) NOT NULL,
    amount DOUBLE(8,2) NOT NULL DEFAULT 0.00,
    loanStatus VARCHAR(10) DEFAULT "Apply",
    FOREIGN KEY (custIC) REFERENCES Customer(custIC),
    FOREIGN KEY (brID) REFERENCES Branch(brID),
    CONSTRAINT chk_loanType CHECK(
        loanType IN ('Personal', 'Housing', 'Others')
    )
);

\! echo "Loan";
DESCRIBE Loan;

CREATE TABLE Transactions (
    txnID INT(10) PRIMARY KEY,
    accID INT(12) NOT NULL,
    custIC INT(12) NOT NULL,
    txnDate DATE,
    txnTime TIME,
    txnType VARCHAR(10),
    amount DOUBLE(8,2) NOT NULL DEFAULT 0.00,
    FOREIGN KEY (accID) REFERENCES Account(accID),
    FOREIGN KEY (custIC) REFERENCES Customer(custIC),
    CONSTRAINT chk_txnType CHECK(
        txnType IN ('Deposit', 'Withdrawal')
    )
);

\! echo "Transactions";
DESCRIBE Transactions;

SHOW TABLES;