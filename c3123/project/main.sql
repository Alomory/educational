DROP DATABASE IF EXISTS Project;
CREATE DATABASE Project;
USE Project;

CREATE TABLE OrderSystem (
    order_id INTEGER PRIMARY KEY,
    quantity INTEGER,
    order_total DECIMAL,
    order_status VARCHAR(20),
    customer_name VARCHAR(50),
    customer_email VARCHAR(100),
    customer_phone VARCHAR(20),
    product_name VARCHAR(100),
    product_price DECIMAL,
    product_stock INTEGER,
    vendor_name VARCHAR(100),
    vendor_contact_name VARCHAR(50),
    vendor_email VARCHAR(100),
    vendor_phone VARCHAR(20),
    note_content VARCHAR(500)
);

-- 1NF
DROP TABLE OrderSystem;

CREATE TABLE Orders (
    order_id INTEGER 
        PRIMARY KEY 
        AUTO_INCREMENT,
    customer_id INTEGER,
    product_id INTEGER,
    vendor_id INTEGER,
    quantity INTEGER,
    order_total DECIMAL,
    order_status VARCHAR(20)
        CHECK (order_status IN ("Paid", "Not Paid")),
    note_content VARCHAR(255)
);

CREATE TABLE Customer (
    customer_id INTEGER PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    customer_email VARCHAR(100),
    customer_phone VARCHAR(20)
);

CREATE TABLE Product (
    product_id INTEGER PRIMARY KEY,
    product_name VARCHAR(100),
    product_price DECIMAL,
    product_stock INTEGER
);

CREATE TABLE Vendor (
    vendor_id INTEGER PRIMARY KEY,
    vendor_name VARCHAR(100),
    contact_name VARCHAR(50), 
    vendor_email VARCHAR(100),
    vendor_phone VARCHAR(20)
);

-- 2NF
ALTER TABLE Orders
ADD FOREIGN KEY (customer_id) 
    REFERENCES Customer(customer_id) 
    ON UPDATE CASCADE,
ADD FOREIGN KEY (product_id) 
    REFERENCES Product(product_id) 
    ON UPDATE CASCADE,
ADD FOREIGN KEY (vendor_id) 
    REFERENCES Vendor(vendor_id) 
    ON UPDATE CASCADE;

-- 3NF
ALTER TABLE Orders
DROP COLUMN note_content;

CREATE TABLE Note (
    note_id INTEGER PRIMARY KEY,
    order_id INTEGER,
    note_content VARCHAR(255),
    FOREIGN KEY (order_id) 
        REFERENCES Orders(order_id)
);

-- Insert test data
INSERT INTO Customer (customer_id, first_name, last_name, customer_email, customer_phone) 
VALUES 
    (101, 'Fatimah Azzahra', 'Salleh', 'fatima@gmail.com', '0144392833'),
    (102, 'John', 'Scott', 'johnscott@yahoo.com', '0123329443'),
    (103, 'Mia', 'Hilton', 'sarah123@gmail.com', '0133942228'),
    (104, 'Ahmad Ali', 'Ahmed', 'ali.ahmed@gmail.com', '0194385294'),
    (105, 'Kiew', 'Ah-Kun', 'kiew.ahkun@gmail.com', '0189932718');

INSERT INTO Product (product_id, product_name, product_price, product_stock)
VALUES 
    (198, 'Batik Bag', 45.00, 10),
    (119, 'Zink', 55.00, 20),
    (531, 'Hardcase Luggage', 265.00, 15),
    (361, 'Kinder Bueno', 5.00, 50),
    (191, 'Bootcut Pant', 48.00, 40);

INSERT INTO Vendor (vendor_id, vendor_name, contact_name, vendor_email, vendor_phone)
VALUES 
    (110, 'Malayan Bazaar', 'Farah Syatira', 'farah_syat@gmail.com', '0128936621'),
    (111, 'Artbeat Sdn. Bhd.', 'Angelina', 'angel@yahoo.com', '0123389462'),
    (112, 'Thirty-One', 'Sam Jackson', 'jackson@gmail.com', '0173627710'),
    (113, 'Park Lane', 'Malek Hakem', 'malek.work@gmail.com', '0166438721'),
    (114, 'Ruby Ribbon', 'Puteri Mawar', 'rosputeri@gmail.com', '0173392784');

INSERT INTO Orders (order_id, customer_id, product_id, vendor_id, quantity, order_total, order_status)
VALUES
    (1, 102, 119, 110, 3, 60.00, 'Paid'),
    (2, 102, 531, 111, 2, 530.00, 'Paid'),
    (3, 103, 361, 112, 8, 40.00, 'Paid'),
    (4, 105, 191, 113, 1, 48.00, 'Paid'),
    (5, 101, 198, 114, 5, 225.00, 'Paid'),
    (6, 104, 119, 110, 10, 550.00, 'Not Paid');

INSERT INTO Note (note_id, order_id, note_content)
VALUES
    (121, 1, 'Red color'),
    (122, 2, 'Pink color, Small size'),
    (123, 3, 'Black color, M size'),
    (124, 4, 'Big size with purse'),
    (125, 5, 'Blue color');

-- Create user view
CREATE VIEW CustomerInfo AS
SELECT 
    CONCAT(first_name, ' ', last_name) AS name, 
    customer_email AS email, 
    customer_phone AS phone
FROM Customer;

CREATE VIEW VendorDetail AS
SELECT 
    vendor_name AS vendor, 
    contact_name AS contact, 
    vendor_email AS email, 
    vendor_phone AS phone
FROM Vendor;

-- Create user
DROP USER IF EXISTS vendor;
CREATE USER vendor IDENTIFIED BY 'password';
GRANT SELECT, UPDATE, DELETE ON Product TO vendor;
GRANT SELECT ON CustomerDetail TO vendor; 
GRANT SELECT, UPDATE, DELETE ON Vendor TO vendor;
GRANT SELECT, UPDATE ON Orders TO vendor;
GRANT SELECT, UPDATE, DELETE ON Note TO vendor;

DROP USER IF EXISTS customer;
CREATE USER customer IDENTIFIED BY 'password';
GRANT SELECT, UPDATE, DELETE ON Customer TO customer;
GRANT SELECT ON VendorDetail TO customer; 
GRANT SELECT, UPDATE ON Orders TO customer; 
GRANT SELECT, UPDATE, DELETE ON Note TO customer;

FLUSH PRIVILEGES;