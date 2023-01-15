DROP DATABASE IF EXISTS Project;
CREATE DATABASE Project;
USE Project;

CREATE TABLE Orders (
    order_id INTEGER PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    vendor_id INTEGER NOT NULL,
    quantity INTEGER,
    order_total DECIMAL,
    order_datetime DATETIME
        DEFAULT CURRENT_TIMESTAMP,
    order_status VARCHAR(20),
    note_content VARCHAR(255),
    FOREIGN KEY (customer_id) 
        REFERENCES Customers(customer_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (product_id) 
        REFERENCES Products(product_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (vendor_id) 
        REFERENCES Vendor(vendor_id)
        ON UPDATE CASCADE
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
    contact_name VARCHAR(50),
    vendor_email VARCHAR(100),
    vendor_phone VARCHAR(20)
);
