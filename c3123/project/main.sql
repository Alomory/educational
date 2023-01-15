DROP DATABASE IF EXISTS Project;
CREATE DATABASE Project;
USE Project;

CREATE TABLE OrderSystem (
    order_id INTEGER PRIMARY KEY,
    quantity INTEGER,
    order_total DECIMAL,
    order_datetime DATETIME
        DEFAULT CURRENT_TIMESTAMP,
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
    order_datetime DATETIME
        DEFAULT CURRENT_TIMESTAMP,
    order_status VARCHAR(20)
        CHECK (order_status IN ("Delivered", "Pending", "Cancelled")),
    note_content VARCHAR(255)
);

CREATE TABLE Customer (
    customer_id INTEGER 
        PRIMARY KEY
        AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    customer_email VARCHAR(100),
    customer_phone VARCHAR(20)
) AUTO_INCREMENT = 100;

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
    note_id INTEGER 
        PRIMARY KEY 
        AUTO_INCREMENT,
    order_id INTEGER,
    note_content VARCHAR(255),
    FOREIGN KEY (order_id) 
        REFERENCES Orders(order_id)
);

-- Create view vendor 
CREATE VIEW CustomerInfo AS
SELECT 
    customer_id AS id,
    CONCAT(first_name, ' ', last_name) AS name, 
    customer_email AS email, 
    customer_phone AS phone
FROM Customer;

CREATE VIEW VendorOrder AS
SELECT 
    vendor_id AS vendor, 
    customer_id AS customer, 
    product_id AS product, 
    quantity, 
    order_total AS total, 
    order_datetime AS datetime,
    order_status AS status
FROM Orders;

-- Create view customer 
CREATE VIEW VendorInfo AS
SELECT 
    vendor_id AS id,
    vendor_name AS vendor, 
    contact_name AS contact, 
    vendor_email AS email, 
    vendor_phone AS phone
FROM Vendor;

CREATE VIEW CustomerOrder AS
SELECT 
    vendor_id AS vendor,
    customer_id AS customer,    
    CONCAT((
        SELECT product_name 
        FROM Product p 
        WHERE p.product_id = o.product_id
    ), " x", quantity) AS product,
    order_total AS total, 
    order_datetime AS datetime,
    order_status AS status
FROM Orders o;

-- Create user vendor
DROP USER IF EXISTS vendor;
CREATE USER vendor IDENTIFIED BY 'password';

GRANT INSERT, UPDATE, DELETE ON Vendor TO vendor;
GRANT SELECT, INSERT, UPDATE, DELETE ON Product TO vendor;

GRANT SELECT ON CustomerInfo TO vendor; 
GRANT SELECT ON VendorOrder TO vendor; 

-- Create user customer
DROP USER IF EXISTS customer;
CREATE USER customer IDENTIFIED BY 'password';

GRANT SELECT, UPDATE, DELETE ON Customer TO customer;

GRANT SELECT ON VendorInfo TO customer; 
GRANT SELECT ON CustomerOrder TO customer;

-- Create common
GRANT SELECT ON Note TO vendor, customer;

DELIMITER //

CREATE PROCEDURE UpdateOrderStatus (
    IN orderId INT, 
    IN orderStatus VARCHAR(20)
)
BEGIN
    UPDATE Orders
    SET order_status = orderStatus
    WHERE order_id = orderId;
END //

CREATE PROCEDURE CreateNote (
    IN orderId INT, 
    IN noteContent VARCHAR(255)
)
BEGIN
    INSERT INTO Note (order_id, note_content)
    VALUES (orderId, noteContent);
END //

CREATE PROCEDURE UpdateNote (
    IN noteId INT, 
    IN noteContent VARCHAR(255)
)
BEGIN
    UPDATE Note
    SET note_content = noteContent
    WHERE note_id = noteId;
END //

CREATE PROCEDURE DeleteNote (IN noteId INT)
BEGIN
    DELETE FROM Note
    WHERE note_id = noteId;
END //

DELIMITER ;

GRANT EXECUTE ON PROCEDURE Project.UpdateOrderStatus TO vendor, customer;
GRANT EXECUTE ON PROCEDURE Project.CreateNote TO vendor, customer;
GRANT EXECUTE ON PROCEDURE Project.UpdateNote TO vendor, customer;
GRANT EXECUTE ON PROCEDURE Project.DeleteNote TO vendor, customer;

FLUSH PRIVILEGES;

-- Insert test data
INSERT INTO Customer (first_name, last_name, customer_email, customer_phone) 
VALUES 
    ('Fatimah Azzahra', 'Salleh', 'fatima@gmail.com', '0144392833'),
    ('John', 'Scott', 'johnscott@yahoo.com', '0123329443'),
    ('Mia', 'Hilton', 'sarah123@gmail.com', '0133942228'),
    ('Ahmad Ali', 'Ahmed', 'ali.ahmed@gmail.com', '0194385294'),
    ('Kiew', 'Ah-Kun', 'kiew.ahkun@gmail.com', '0189932718');

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

INSERT INTO Orders (customer_id, product_id, vendor_id, quantity, order_total, order_status)
VALUES
    (102, 119, 110, 3, 60.00, 'Delivered'),
    (102, 531, 111, 2, 530.00, 'Cancelled'),
    (103, 361, 112, 8, 40.00, 'Cancelled'),
    (100, 191, 113, 1, 48.00, 'Delivered'),
    (101, 198, 114, 5, 225.00, 'Delivered'),
    (104, 119, 110, 10, 550.00, 'Pending');

INSERT INTO Note (note_id, order_id, note_content)
VALUES
    (121, 1, 'Red color'),
    (122, 2, 'Pink color, Small size'),
    (123, 3, 'Black color, M size'),
    (124, 4, 'Big size with purse'),
    (125, 5, 'Blue color');
