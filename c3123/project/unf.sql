DROP DATABASE IF EXISTS Project;
CREATE DATABASE Project;
USE Project;

CREATE TABLE OrderSystem (
    order_id INTEGER PRIMARY KEY,
    quantity INTEGER,
    order_total DECIMAL,
    order_datetime DATETIME,
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
