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
    order_id INTEGER PRIMARY KEY,
    customer_id INTEGER,
    product_id INTEGER,
    vendor_id INTEGER,
    quantity INTEGER,
    order_total DECIMAL,
    order_status VARCHAR(20),
    note_content VARCHAR(255)
);

CREATE TABLE Customer (
    customer_id INTEGER PRIMARY KEY,
    customer_name VARCHAR(50),
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
    vendor_contact_name VARCHAR(50),
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
