DROP DATABASE IF EXISTS Lab7;
CREATE DATABASE Lab7;
USE Lab7;

CREATE TABLE Salesman (
    salesman_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hp VARCHAR(255) NOT NULL,
    telephone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

DESC Salesman;

CREATE TABLE Customer (
    customer_code VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    postcode VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    hp VARCHAR(255) NOT NULL,
    telephone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    salesman_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (salesman_id) 
        REFERENCES Salesman(salesman_id)
);

DESC Customer;

CREATE TABLE Orders (
    order_no INT PRIMARY KEY,
    order_type VARCHAR(20),
    order_date DATE,
    delivery_date DATE
);

DESC Orders;

CREATE TABLE OrderDetails (
    order_no INT,
    customer_code VARCHAR(255),
    item_code VARCHAR(10),
    item_description VARCHAR(50),
    order_quantity INT,
    unit_selling_price DECIMAL(10,2),
    amount DECIMAL(10,2),
    FOREIGN KEY (order_no) 
        REFERENCES Orders(order_no),
    FOREIGN KEY (customer_code)
        REFERENCES Customer(customer_code)
);

DESC OrderDetails;

INSERT INTO Salesman (salesman_id, name, hp, telephone, email) 
VALUES
    ('S001', 'John Smith', '012-345-6789', '012-345-6789', 'john.smith@email.com'),
    ('S002', 'Jane Doe', '012-345-6789', '012-345-6789', 'jane.doe@email.com'),
    ('S003', 'Bob Johnson', '012-345-6789', '012-345-6789', 'bob.johnson@email.com');

SELECT * FROM Salesman;

INSERT INTO Customer (customer_code, name, address, postcode, city, state, hp, telephone, email, salesman_id)
VALUES 
    ('CS30120', 'John Smith', '1234 Main St', '12345', 'Seattle', 'WA', 
     '555-555-5555', '555-555-5555', 'john.smith@email.com', 'S001'),
    ('CS21578', 'Jane Doe', '5678 Park Ave', '56789', 'Los Angeles', 'CA', 
     '555-555-5555', '555-555-5555', 'jane.doe@email.com', 'S002'),
    ('CS30287', 'Bob Johnson', '91011 Elm St', '91011', 'Houston', 'TX', 
     '555-555-5555', '555-555-5555', 'bob.johnson@email.com', 'S003');

SELECT * FROM Customer;

INSERT INTO Orders (order_no, order_type, order_date, delivery_date)
VALUES 
    (1, 'Retail Order', '2022-05-01', '2022-05-05'),
    (2, 'Company Order', '2022-06-01', '2022-06-10'),
    (3, 'Retail Order', '2022-07-01', '2022-07-15'),
    (4, 'Company Order', '2022-08-01', '2022-09-11');

SELECT * FROM Orders;

INSERT INTO OrderDetails (order_no, customer_code, item_code, item_description, order_quantity, unit_selling_price, amount)
VALUES 
    (1, 'CS30120', 'Nike-101', 'Dwi Layer Running Shoes', 2, 100.00, 200.00),
    (2, 'CS21578', 'Adidas-202', 'Superstar Sneakers', 4, 120.00, 480.00),
    (3, 'CS30287', 'Puma-303', 'RS-X3 Sneakers', 1, 150.00, 150.00),
    (4, 'CS30287', 'Nike-101', 'Dwi Layer Running Shoes', 5, 100.00, 500.00);

SELECT * FROM OrderDetails;
