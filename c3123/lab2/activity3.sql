DROP DATABASE IF EXISTS activity3;
CREATE DATABASE activity3;
USE activity3;

CREATE TABLE srvcustomer (
    custCode VARCHAR(15) PRIMARY KEY,
    custName VARCHAR(60) NOT NULL,
    custICNo VARCHAR(15) NOT NULL,
    custType VARCHAR(15) NOT NULL,
    custAddr VARCHAR(60),
    custTown VARCHAR(30),
    custPostCode INT(5),
    custRegister DATE
);

\! echo 'srvvcustomer';
DESCRIBE srvcustomer;

CREATE TABLE srvvehicle (
    vecNo VARCHAR(10) PRIMARY KEY,
    vecOwner VARCHAR(15),
    vehChassisNo VARCHAR(30),
    vecModel VARCHAR(60) NOT NULL,
    vehManufactured VARCHAR(60),
    vehYearProduced INT(4),
    vehLastOdometer BIGINT(20),
    FOREIGN KEY (vecOwner) REFERENCES srvcustomer(custCode)
);

\! echo 'srvvehicle';
DESCRIBE srvvehicle;

CREATE TABLE srvtechnician (
    tchNo INT(12) PRIMARY KEY,
    tchName VARCHAR(60) NOT NULL,
    tchHireDate DATE
);

\! echo 'srvtechnician';
DESCRIBE srvtechnician;

CREATE TABLE srvservice (
    srvNo INT(12) PRIMARY KEY,
    custCode VARCHAR(15),
    vecNo VARCHAR(10),
    srvType VARCHAR(25) NOT NULL,
    srvDate DATE,
    tchNo INT(5), 
    FOREIGN KEY (tchNo) REFERENCES srvtechnician(tchNo),
    CONSTRAINT chk_srvType CHECK(
        srvType IN ('Normal', 'Major', 'Warranty')
    )
);

\! echo 'srvservice';
DESCRIBE srvservice;

CREATE TABLE srvparts (
    partNo VARCHAR(45) PRIMARY KEY,
    partDescription VARCHAR(60) NOT NULL,
    partCategory VARCHAR(45),
    partUnit VARCHAR(35),
    partCostPrice DECIMAL(9,2),
    partSalesPrice DECIMAL(9,2),
    partQtyOnHand INT(11)
);

\! echo 'srvparts';
DESCRIBE srvparts;

CREATE TABLE srvservicedetails (
    srvNo INT(12),
    partNo VARCHAR(45),
    orderQty INT(11) NOT NULL,
    slsPrice DECIMAL(9,2),
    FOREIGN KEY (srvNo) REFERENCES srvservice(srvNo),
    FOREIGN KEY (partNo) REFERENCES srvparts(partNo)
);

\! echo 'srvservicedetails';
DESCRIBE srvservicedetails;

SHOW TABLES;
