DROP DATABASE IF EXISTS activity1;
CREATE DATABASE activity1;
USE activity1;

CREATE TABLE Customer (
    cust_number VARCHAR(5) PRIMARY KEY,
    cust_name VARCHAR(50),
    addr VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    postcode CHAR(5),
    contact_no VARCHAR(15)
);
\! echo 'Customer';
DESCRIBE Customer;

INSERT INTO Customer (cust_number, cust_name, addr, city, state, postcode, contact_no)
VALUES
    ('C0001', 'Ahmad', 'Somewhere', 'Nearby', 'Antartica', '00000', '0123456789'),
    ('C0002', 'Ben', 'Never', 'Gonna', 'Give', '11111', '0134567890'),
    ('C1003', 'Celline', 'You', 'Up', 'Selangor', '22222', '0145678901'),
    ('C0004', 'Dex', 'Never', 'Gonna', 'Let', '33333', '0156789012'),
    ('C1006', 'Abdul Rauf Osman', 'You', 'Down', 'Selangor', '11211', '0167890123');
SELECT * FROM Customer;

CREATE TABLE Invoice (
    inv_number CHAR(5) PRIMARY KEY,
    inv_date DATE,
    cust_number VARCHAR(5) NOT NULL,
    inv_amount INT,
    shipped_by VARCHAR(50),
    ship_trackingno VARCHAR(40),
    FOREIGN KEY (cust_number) REFERENCES Customer(cust_number)
);
\! echo 'Invoice';
DESCRIBE Invoice;

INSERT INTO Invoice (inv_number, inv_date, cust_number, inv_amount, shipped_by, ship_trackingno)
VALUES 
    ('12345', '2016-08-16', 'C0001', 8400.00, 'Express', '54321'),
    ('67890', '2016-08-24', 'C0002', 999999.99, 'GDex', '09876'),
    ('23456', '2022-01-02', 'C1003', 2100.00, 'Expresso', '65432'),
    ('34567', '2022-01-03', 'C0004', 1234.56, 'Latte', '76543'),
    ('45678', '2022-01-04', 'C0001', 690000.00, 'GDex', '87654');
SELECT * FROM Invoice;

CREATE TABLE Product (
    prod_code CHAR(12) PRIMARY KEY,
    prod_desc VARCHAR(255),
    unit VARCHAR(15),
    sales_price DOUBLE(8, 2) 
);
\! echo 'Product';
DESCRIBE Product;

INSERT INTO Product (prod_code, prod_desc, unit, sales_price)
VALUES
    ('AW-1001', 'TV LCD 4 inch', 'Box', 0.00),
    ('AK-47', 'Avtomat Kalashnikova 1:1 replica', 'Crate', 700.00),
    ('M16', 'Model 16 1:1 replica', 'Crate', 700.00),
    ('A9394', 'iPhone XX', 'Box', 10000.00),
    ('XGF-02', 'Its funtional, trust me bro', 'Container', 999999.99);
SELECT * FROM Product;

CREATE TABLE Invoice_line (
    inv_number CHAR(5),
    prod_code CHAR(12),
    quantity INT,
    sales_price DOUBLE(8, 2),
    total_sales DOUBLE(8, 2),
    FOREIGN KEY (inv_number) 
        REFERENCES Invoice(inv_number)
        ON UPDATE CASCADE,
    FOREIGN KEY (prod_code) 
        REFERENCES Product(prod_code) 
        ON UPDATE CASCADE
);
\! echo 'Invoice_line';
DESCRIBE Invoice_line;

INSERT INTO Invoice_line (inv_number, prod_code, quantity, sales_price, total_sales)
VALUES
    ('12345', 'AK-47', 12, 700.00, 8400.00),
    ('67890', 'XGF-02', 1, 999999.99, 999999.99),
    ('23456', 'M16', 3, 700.00, 2100.00),
    ('34567', 'AW-1001', 1, 0, 0),
    ('45678', 'A9394', 69, 10000.00, 690000.00);
SELECT * FROM Invoice_line;