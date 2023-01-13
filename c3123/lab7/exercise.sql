DROP DATABASE IF EXISTS Lab7;
CREATE DATABASE Lab7;
USE Lab7;

CREATE TABLE TransactionType (
    transaction_type VARCHAR(5) PRIMARY KEY,
    transaction_description VARCHAR(50)
);

DESC TransactionType;

CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(50)
) AUTO_INCREMENT = 1000;

DESC Supplier;

CREATE TABLE ItemMaster (
    item_id VARCHAR(35) PRIMARY KEY,
    item_description VARCHAR(60),
    unit VARCHAR(15),
    stock_owned INT,
    stock_ordered INT,
    stock_blocked INT
);

DESC ItemMaster;

CREATE TABLE ReplenishmentOrder (
    replenishment_order_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_id INT(4) NOT NULL,
    item_id VARCHAR(35) NOT NULL,
    quantity INT,
    order_date DATE,
    delivery_date DATE,
    created_by VARCHAR(30),
    FOREIGN KEY (supplier_id) 
        REFERENCES Supplier(supplier_id),
    FOREIGN KEY (item_id)
        REFERENCES ItemMaster(item_id)
) AUTO_INCREMENT = 400000;

DESC ReplenishmentOrder;

CREATE TABLE ProductionOrder (
    production_order_id INT PRIMARY KEY AUTO_INCREMENT,
    item_id VARCHAR(35) NOT NULL,
    order_date DATE,
    factory_id VARCHAR(10),
    production_line INT,
    order_status VARCHAR(15)
        CHECK (order_status IN ("NEW", "WIP", "DELIVERED")),
    quantity INT,
    created_by VARCHAR(30),
    FOREIGN KEY (item_id)
        REFERENCES ItemMaster(item_id)
        ON UPDATE CASCADE
) AUTO_INCREMENT = 300000;

DESC ProductionOrder;

CREATE TABLE InventoryTransaction (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_type VARCHAR(5) NOT NULL,
    item_id VARCHAR(35) NOT NULL,
    transaction_reference_id INT NOT NULL,
    transaction_date DATE,
    quantity INT(11),
    created_by VARCHAR(30),
    FOREIGN KEY (transaction_type)
        REFERENCES TransactionType(transaction_type) 
        ON UPDATE CASCADE,
    FOREIGN KEY (item_id)
        REFERENCES ItemMaster(item_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (transaction_reference_id)
        REFERENCES ReplenishmentOrder(replenishment_order_id)
        ON UPDATE CASCADE
) AUTO_INCREMENT = 100000;

DESC InventoryTransaction;

INSERT INTO TransactionType (transaction_type, transaction_description) 
VALUES 
    ('TRX1', 'Replenishment Order'),
    ('TRX2', 'Production Order'),
    ('TRX3', 'Inventory Adjustment'),
    ('TRX4', 'Inventory Transfer'),
    ('TRX5', 'Sales Order');

SELECT * FROM TransactionType;

INSERT INTO Supplier (supplier_name) 
VALUES 
    ('ABC Inc.'),
    ('DEF Corp.'),
    ('GHI Industries'),
    ('JKL Enterprises'),
    ('MNO Group');

SELECT * FROM Supplier;

INSERT INTO ItemMaster (item_id, item_description, unit, stock_owned, stock_ordered, stock_blocked) 
VALUES 
    ('EC-100PV', 'Electric Motor 100 horsepower', 'EA', 100, 50, 20),
    ('EZ-02145', 'Electric Motor 145 horsepower', 'EA', 150, 75, 30),
    ('MZ-01010', 'Manual Motor 10 horsepower', 'EA', 200, 100, 40),
    ('PZ-05005', 'Pneumatic Motor 5 horsepower', 'EA', 150, 75, 30),
    ('HZ-10000', 'Hydraulic Motor 10 horsepower', 'EA', 100, 50, 20);

SELECT * FROM ItemMaster;

INSERT INTO ReplenishmentOrder (supplier_id, item_id, quantity, order_date, delivery_date, created_by)
VALUES 
    (1003, 'EC-100PV', 50, '2022-01-01', '2022-01-15', 'John Doe'),
    (1001, 'EC-100PV', 60, '2022-01-10', '2022-01-20', 'Jane Smith'),
    (1002, 'EC-100PV', 45, '2022-01-05', '2022-01-15', 'Bob Johnson'),
    (1004, 'EC-100PV', 55, '2022-01-15', '2022-01-25', 'Samantha Williams'),
    (1000, 'EZ-02145', 100, '2022-01-20', '2022-01-30', 'Michael Brown');

SELECT * FROM ReplenishmentOrder;

INSERT INTO ProductionOrder (item_id, order_date, factory_id, production_line, order_status, quantity, created_by)
VALUES 
    ('EC-100PV', '2022-01-01', 'FACT-01', 1, 'WIP', 50, 'John Doe'),
    ('EC-100PV', '2022-01-10', 'FACT-02', 2, 'NEW', 60, 'Jane Smith'),
    ('EC-100PV', '2022-01-05', 'FACT-03', 3, 'DELIVERED', 45, 'Bob Johnson'),
    ('EC-100PV', '2022-01-15', 'FACT-04', 4, 'WIP', 55, 'Samantha Williams'),
    ('EZ-02145', '2022-01-20', 'FACT-05', 5, 'NEW', 65, 'Michael Brown');

SELECT * FROM ProductionOrder;

INSERT INTO InventoryTransaction (transaction_type, item_id, transaction_reference_id, transaction_date, quantity, created_by)
VALUES 
    ('TRX1', 'EC-100PV', 400000, '2022-01-01', 50, 'John Doe'),
    ('TRX1', 'EC-100PV', 400001, '2022-01-10', 60, 'Jane Smith'),
    ('TRX1', 'MZ-01010', 400002, '2022-01-05', 45, 'Bob Johnson'),
    ('TRX1', 'EC-100PV', 400003, '2022-01-15', 55, 'Samantha Williams'),
    ('TRX1', 'EZ-02145', 400004, '2022-01-20', 65, 'Michael Brown');

SELECT * FROM InventoryTransaction;

\! echo ""
\! echo "1. Display order date, item code, item description, order quantity for replenishment order which order quantity is exceeded the average order production order quantity for item code ‘EC-100PV’. Your output must be sorted by latest order date ."

SELECT ro.order_date, im.item_id, im.item_description, ro.quantity 
FROM ReplenishmentOrder ro 
JOIN ItemMaster im USING (item_id) 
WHERE ro.quantity > (
    SELECT AVG(po.quantity) 
    FROM ProductionOrder po 
    WHERE po.item_id = 'EC-100PV'
)
ORDER BY ro.order_date DESC;

\! echo ""
\! echo "2. List transaction number, transaction date, transaction reference no for any orders that do not supplied by supplier number ‘1003’."

SELECT transaction_id, transaction_date, transaction_reference_id 
FROM InventoryTransaction 
JOIN ReplenishmentOrder ro ON transaction_reference_id = ro.replenishment_order_id
JOIN Supplier s USING (supplier_id)
WHERE ro.supplier_id != "1003";

\! echo ""
\! echo "3. Find production order number, order, item description, factoryid, order status and order quantity for all production orders where the order date is equal to replenishment order data that having the maximum order quantity."

SELECT po.production_order_id, po.order_date, im.item_description, po.factory_id, po.order_status, po.quantity
FROM ProductionOrder po
JOIN ItemMaster im USING (item_id)
WHERE po.order_date = (
    SELECT order_date
    FROM ReplenishmentOrder
    WHERE quantity IN (
        SELECT MAX(quantity) 
        FROM ReplenishmentOrder
    )
); -- TLDR: same date with RepOrd's date with max quantity

\! echo ""
\! echo "4. Find the replenishment order number, order date, item code, item description which order quantity is greater than the average quantity for item code = ‘EZ-02145’ for any records that exist in inventory transaction relation, and posses transaction type as ‘TRX1’ which representing ‘Replenishment Order’."

SELECT replenishment_order_id, order_date, im.item_id, im.item_description
FROM ReplenishmentOrder ro
JOIN ItemMaster im USING (item_id)
JOIN InventoryTransaction it ON transaction_reference_id = replenishment_order_id
WHERE ro.quantity > (SELECT AVG(quantity) FROM InventoryTransaction WHERE item_id = 'EZ-02145')
AND it.transaction_type = 'TRX1';

\! echo ""
\! echo "5. Retrieve transaction number, transaction date, item code and quantity for inventory transaction where item code does not exist in any replenishment order."

SELECT transaction_id, transaction_date, item_id, quantity
FROM InventoryTransaction it
WHERE item_id NOT IN (SELECT item_id FROM ReplenishmentOrder); 

\! echo ""
\! echo "Yes, I know the data doesn't tally, but this is just for achieving requirements"
