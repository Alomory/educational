DROP DATABASE IF EXISTS Lab8;
CREATE DATABASE Lab8;
USE Lab8;

CREATE TABLE Types (
    types_id INT PRIMARY KEY,
    types_description VARCHAR(70)
);

DESC Types;

CREATE TABLE Property (
    property_id INT PRIMARY KEY,
    property_address VARCHAR(70),
    city VARCHAR(35),
    postcode INT,
    types_id INT,
    FOREIGN KEY (types_id)
        REFERENCES Types(types_id)
);

DESC Property;

CREATE TABLE Renter (
    ic VARCHAR(30) PRIMARY KEY,
    renter_name VARCHAR(50),
    phone VARCHAR(16),
    email VARCHAR(30)
);

DESC Renter;

CREATE TABLE Term (
    term_id VARCHAR(30) PRIMARY KEY,
    ic VARCHAR(30),
    property_id INT,
    term_start_date DATE,
    term_end_date DATE,
    term_bill_inclusive CHAR(1),
    term_monthly_amount DECIMAL(9, 2),
    FOREIGN KEY (ic)
        REFERENCES Renter(ic),
    FOREIGN KEY (property_id)
        REFERENCES Property(property_id),
    CHECK (term_bill_inclusive IN ('Y', 'N'))
);

DESC Term;

CREATE TABLE Bill (
    bill_id INT 
        PRIMARY KEY
        AUTO_INCREMENT,
    bill_date DATE,
    ic VARCHAR(30),
    bill_month INT 
        AS (MONTH(bill_date)),
    bill_year INT
        AS (YEAR(bill_date)),
    bill_amount DECIMAL(9, 2),
    FOREIGN KEY (ic)
        REFERENCES Renter(ic)
) AUTO_INCREMENT = 100001;

DESC Bill;

INSERT INTO Types (types_id, types_description) 
VALUES
    (10, 'Single Family Home'),
    (20, 'Apartment'),
    (30, 'Condo'),
    (40, 'Somewhere'),
    (50, 'Over The Rainbow');

SELECT * FROM Types;

INSERT INTO Property (property_id, property_address, city, postcode, types_id) 
VALUES
    (30001, '123 Main St', 'New York', 10001, 10),
    (30002, '456 Park Ave', 'New York', 10002, 20),
    (30003, '789 Elm St', 'Chicago', 60007, 30),
    (30004, '321 Oak St', 'Los Angeles', 90001, 10),
    (30005, '124 Pine St', 'Shah Alam', 40150, 20);

SELECT * FROM Property;

INSERT INTO Renter (ic, renter_name, phone, email) 
VALUES
    ('A123456789', 'John Smith', '012-5545050', 'johnsmith@example.com'),
    ('B987654321', 'Jane Doe', '012-5545051', 'janedoe@example.com'),
    ('C123456789', 'Bob Johnson', '012-5545052', 'bobjohnson@example.com'),
    ('D123456789', 'Amy Williams', '012-5545053', 'amywilliams@example.com'),
    ('E987654321', 'Michael Brown', '012-5545054', 'michaelbrown@example.com');

SELECT * FROM Renter;

INSERT INTO Term (term_id, ic, property_id, term_start_date, term_end_date, term_bill_inclusive, term_monthly_amount) 
VALUES
    ('T001', 'A123456789', 30001, '2022-01-01', '2022-12-31', 'Y', 1000.00),
    ('T002', 'B987654321', 30002, '2022-01-01', '2022-12-31', 'N', 1200.00),
    ('T003', 'C123456789', 30003, '2022-01-01', '2022-12-31', 'Y', 800.00),
    ('T004', 'A123456789', 30004, '2022-01-01', '2022-12-31', 'N', 1400.00),
    ('T005', 'B987654321', 30005, '2022-01-01', '2022-12-31', 'Y', 900.00);

SELECT * FROM Term;

INSERT INTO Bill (bill_date, ic, bill_amount) 
VALUES
    ('2010-01-01','A123456789', 1000.50),
    ('2011-02-01','B987654321', 1200.25),
    ('2012-03-01','C123456789', 800.00),
    ('2013-04-01','A123456789', 1400.75),
    ('2014-05-01','B987654321', 900.50),
    ('2015-06-01','C123456789', 700.00),
    ('2010-07-01','A123456789', 800.50),
    ('2011-08-01','B987654321', 1100.25),
    ('2012-09-01','C123456789', 900.00),
    ('2013-10-01','A123456789', 1300.75);

SELECT * FROM Bill;

\! ehco ""
\! echo "1. Retrieve ic number, rental name, property number and rental year (from attribute startdate) for any property that has property type as 10."

SELECT ic, renter_name, property_id, YEAR(term_start_date) AS start_year
FROM Renter
JOIN Term USING (ic)
JOIN Property USING (property_id)
WHERE types_id = 10;

\! echo ""
\! echo "2. Display billing number, billing date, rental name and payment month for property number 30001 and 30005. You should format billing date as ‘dd-mm-yyyy’."

SELECT bill_id, DATE_FORMAT(bill_date, '%d-%m-%Y') AS bill_date, renter_name, bill_month
FROM Bill
JOIN Renter USING (ic)
JOIN Term USING (ic)
JOIN Property USING (property_id) 
WHERE property_id IN (30001, 30005);

\! echo ""
\! echo "3. Retrieve rental name, term reference number, hp number and monthly rental amount for property located at 'Shah Alam'. Example value for hp number is 012-5545050. You should display hp number as 0125545050 in your query."

SELECT renter_name, term_id, REPLACE(phone,'-','') AS phone, term_monthly_amount
FROM Renter
JOIN Term USING (ic)
JOIN Property USING (property_id)
WHERE city = 'Shah Alam';

\! echo ""
\! echo "4. Retrieve property description, property address, rental amount and bill inclusive for all property. If bill inclusive = 'N', display as 'Electricity & Water bill not inclusive'. For bill inclusive = 'Y', display as 'Electricity & Water bill is inclusive'."

SELECT 
    types_description, 
    property_address, 
    term_monthly_amount,
    (CASE
        WHEN (term_bill_inclusive = "N") THEN "Electricity & Water bill not inclusive"
        WHEN (term_bill_inclusive = "Y") THEN "Electricity & Water bill inclusive"
        ELSE "That's impossible, but ok"
    END) AS bill_inclusive
FROM Term
JOIN Property USING (property_id)
JOIN Types USING (types_id);

\! echo ""
\! echo "Retrieve payment year, average payment amount for property where the signed date of term reference signed starting from year 2012 until 2014. You should display the average payment amount up to two (2) decimal places."

SELECT 
    bill_year, 
    ROUND(AVG(bill_amount), 2) AS average_bill_amount
FROM Bill
JOIN Renter USING (ic)
JOIN Term USING (ic)
WHERE bill_year BETWEEN 2012 AND 2014
GROUP BY bill_year;
