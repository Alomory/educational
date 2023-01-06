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


-- Data poisoning

INSERT INTO Examination (examdesc, certififiedby, duration)
VALUES
  ('Exam 1', 'Certification Body 1', 120),
  ('Exam 2', 'Certification Body 2', 90),
  ('Exam 3', 'Oracle Corporation', 60),
  ('Exam 4', 'Certification Body 4', 150),
  ('Exam 5', 'Oracle Corporation', 75);

INSERT INTO Customer (icno, name, address, city, postcode, state)
VALUES
  ('IC12345', 'John Doe', '123 Main St', 'New York', 12345, 'NY'),
  ('IC23456', 'Jane Smith', '456 Park Ave', 'Kelantan', 23456, 'CA'),
  ('IC34567', 'Bob Johnson', '789 Broad St', 'Chicago', 34567, 'IL'),
  ('IC45678', 'Ruhaimie Osman', '321 Maple St', 'Houston', 45678, 'TX'),
  ('IC56789', 'Mike Brown', '654 Oak St', 'Terengganu', 56789, 'PA');

INSERT INTO AttendExam (icno, examid, examdate, examtime, result, certified)
VALUES
  ('IC12345', 10000, '2022-01-01', '10:00:00', 80, 'Y'),
  ('IC23456', 10001, '2022-02-02', '11:00:00', 75, 'Y'),
  ('IC34567', 10002, '2022-03-03', '12:00:00', 65, 'N'),
  ('IC45678', 10003, '2022-04-04', '13:00:00', 90, 'Y'),
  ('IC56789', 10004, '2022-05-05', '14:00:00', 85, 'Y');

INSERT INTO Invoice (invoicedate, icno, pymttype, paidamount)
VALUES
  ('2022-01-01', 'IC12345', 1, 5000.00),
  ('2022-02-02', 'IC23456', 2, 4000.00),
  ('2022-03-03', 'IC34567', 3, 3000.00),
  ('2022-04-04', 'IC45678', 1, 2000.00),
  ('2022-05-05', 'IC56789', 2, 1000.00);

INSERT INTO Training (trainingtype, trainingdesc, duration, trainingfees, provider, examid)
VALUES
  (1, 'Training 1', 120, 1000.00, 'Provider 1', 10000),
  (2, 'Training 2', 90, 750.00, 'Provider 2', 10001),
  (3, 'Training 3', 60, 500.00, 'Provider 3', 10002),
  (1, 'Training 4', 150, 1250.00, 'Provider 4', 10003),
  (2, 'Training 5', 100, 250.00, 'Provider 5', 10004);

INSERT INTO InvoiceLine (invoiceno, trainingid, quantity, totalamount)
VALUES
  (1, 1, RAND()*10, RAND()*100),
  (2, 2, RAND()*10, RAND()*100),
  (3, 3, RAND()*10, RAND()*100),
  (4, 1, RAND()*10, RAND()*100),
  (5, 2, RAND()*10, RAND()*100);


\! echo '1. Retrieve a list of training code, training description, training duration and fees.';

SELECT trainingid, trainingdesc, duration, trainingfees
FROM Training;


\! echo '2. Retrieve customer ic number, name and city they live for customer from ‘Terengganu’ or ‘Kelantan’.';

SELECT icno, name, city
FROM Customer
WHERE city IN ('Terengganu', 'Kelantan');


\! echo '3. Display the candidate ic number and the certification status who taking the examination.';

SELECT icno, certified
FROM AttendExam;

\! echo '4. Retrieve examination code, description and duration for examination which the certification is comes from ‘Oracle Corporation’.';

SELECT examid, examdesc, duration
FROM Examination
WHERE certififiedby = 'Oracle Corporation';


\! echo '5. Display invoice information where the customer pay the invoice amount greater than RM4000.00.';

SELECT *
FROM Invoice
WHERE paidamount > 4000.00;


\! echo '6. Modify the duration for examination code 10004 from 3 hours to 4 hours.';

UPDATE Examination
SET duration = 4
WHERE examid = 10004;


\! echo '7. Display a record for ic number, examination code, date of examination and time of examination. Your output must be sort out based on the latest date of examination.';

SELECT icno, examid, examdate, examtime
FROM AttendExam
ORDER BY examdate DESC;


\! echo '8. The ic number for Ruhaimie Osman is wrongly key-in as 890315-10-3278. Perform the query to retreive ic number and name from customer. Subsequently, and retrieve ic number from invoice table. Verify the ic number for both tables. Write a SQL statement to change the ic number to 890315-10-3288. Verify whether change occurs in invoice table. Justify your answer.';

SELECT icno, name
FROM Customer
WHERE name = 'Ruhaimie Osman';

SELECT Invoice.icno
FROM Invoice, Customer
WHERE Invoice.icno = Customer.icno
    AND Customer.name = 'Ruhaimie Osman';

UPDATE Customer
SET icno = '890315-10-3288'
WHERE name = 'Ruhaimie Osman';

SELECT icno
FROM Invoice;


\! echo '9. Perform the query to verify the payment type for inoive 4 is 1 (Cash). Then, make a changes for type of payment for this invoice from Cash to Misc. Your answer should include original record, SQL statement to modify payment type and, finally display invoice information in order to ascertain that the modification has been done accordingly.';

SELECT (pymttype = 1) AS result
FROM Invoice 
WHERE invoiceno = 4;

SELECT * 
FROM Invoice 
WHERE invoiceno = 4;

UPDATE Invoice 
SET pymttype = '3' 
WHERE invoiceno = 4;

SELECT * 
FROM Invoice 
WHERE invoiceno = 4;


\! echo '10. Retrieve details about the examination information where the records sorted by certification provider as an ascending order, followed by duration as descending order.';

SELECT * 
FROM Examination
ORDER BY certififiedby ASC, duration DESC;