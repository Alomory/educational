DROP DATABASE IF EXISTS exercise;
CREATE DATABASE exercise;
USE exercise;


CREATE TABLE Examination (
    examid INT(5) PRIMARY KEY AUTO_INCREMENT,
    examdesc VARCHAR(50) NOT NULL,
    certififiedby VARCHAR(40),
    duration INT
) AUTO_INCREMENT = 10000;


CREATE TABLE Customer (
    icno VARCHAR(15) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(75),
    city VARCHAR(30),
    postcode INT(5),
    state VARCHAR(30)
);


CREATE TABLE AttendExam (
    icno VARCHAR(15),
    examid INT(5),
    examdate DATE NOT NULL,
    examtime TIME NOT NULL,
    result INT,
    certified CHAR(1), 
    FOREIGN KEY (icno) 
        REFERENCES Customer(icno)
        ON UPDATE CASCADE,
    FOREIGN KEY (examid) 
        REFERENCES Examination(examid)
        ON UPDATE CASCADE,
    CONSTRAINT yn CHECK (certified IN ('Y', 'N'))
);


CREATE TABLE Invoice (
    invoiceno INT(7) PRIMARY KEY AUTO_INCREMENT,
    invoicedate DATE NOT NULL,
    icno VARCHAR(15),
    pymttype INT(1) NOT NULL DEFAULT 1,
    paidamount DECIMAL(9,2),
    FOREIGN KEY (icno) 
        REFERENCES Customer(icno)
        ON UPDATE CASCADE,
    CONSTRAINT ott CHECK (pymttype IN (1, 2, 3))
);


CREATE TABLE Training ( 
    trainingid INT(5) PRIMARY KEY AUTO_INCREMENT, 
    trainingtype INT(1) NOT NULL DEFAULT 1, 
    trainingdesc VARCHAR(65) NOT NULL, 
    duration INT(4),
    trainingfees DECIMAL(9,2),
    provider VARCHAR(50),
    examid INT(5),
    FOREIGN KEY (examid) 
        REFERENCES Examination(examid)
        ON UPDATE CASCADE,
    CONSTRAINT ott2 CHECK (trainingtype IN (1, 2, 3))
);


CREATE TABLE InvoiceLine(
    invoiceno INT(7),
    trainingid INT(5) NOT NULL,
    quantity INT,
    totalamount DECIMAL(9,2),
    FOREIGN KEY (invoiceno) 
        REFERENCES Invoice(invoiceno)
        ON UPDATE CASCADE,
    FOREIGN KEY (trainingid) 
        REFERENCES Training(trainingid)
        ON UPDATE CASCADE
);
