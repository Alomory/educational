DROP DATABASE IF EXISTS Lab5;
CREATE DATABASE Lab5;
USE Lab5;

CREATE TABLE itemcategory (
    iccode INTEGER PRIMARY KEY 
        AUTO_INCREMENT,
    icdescription VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 101;

DESC itemcategory;

CREATE TABLE item (
    itmcode VARCHAR(5) PRIMARY KEY,
    itmdesc VARCHAR(255) NOT NULL,
    iccode INTEGER NOT NULL,
    avgmthlyusage DECIMAL(10,2) NOT NULL,
    reorderlevel INTEGER NOT NULL,
    reorderqty INTEGER NOT NULL,
    FOREIGN KEY (iccode) 
        REFERENCES itemcategory (iccode)
        ON UPDATE CASCADE
);

DESC item;

CREATE TABLE itemstock (
    itmcode VARCHAR(5) NOT NULL,
    stkcountdate DATE NOT NULL,
    qtystock DECIMAL(10,2) NOT NULL,
    stkcountstatus VARCHAR(255) NOT NULL,
    PRIMARY KEY (itmcode, stkcountdate),
    FOREIGN KEY (itmcode) 
        REFERENCES item (itmcode)
        ON UPDATE CASCADE,
    CHECK 
        (stkcountstatus IN ("Closed", "Opened"))
);

DESC itemstock;

CREATE TABLE supplier (
    suppid INTEGER PRIMARY KEY 
        AUTO_INCREMENT,
    suppname VARCHAR(255) NOT NULL,
    suppemail VARCHAR(255) NOT NULL,
    suppofficeno VARCHAR(255) NOT NULL,
    supphpno VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 300001;

DESC supplier;

CREATE TABLE itemsupplier (
    itmcode VARCHAR(5) NOT NULL,
    suppid INTEGER NOT NULL,
    totqtysupptodate DECIMAL(10,2) NOT NULL,
    firstdatesupply DATE NOT NULL,
    lastdatesupply DATE NOT NULL,
    stdprice DECIMAL(10,2) NOT NULL,
    discount DECIMAL(10,2) NOT NULL,
    minorderqty INTEGER NOT NULL,
    maxorderqty INTEGER NOT NULL,
    FOREIGN KEY (itmcode) 
        REFERENCES item (itmcode)
        ON UPDATE CASCADE,
    FOREIGN KEY (suppid) 
        REFERENCES supplier (suppid)
        ON UPDATE CASCADE
);

DESC itemsupplier;

CREATE TABLE supplieraddress (
    suppaddid INTEGER PRIMARY KEY 
        AUTO_INCREMENT,
    suppid INTEGER NOT NULL,
    addr1 VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    postcode VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    FOREIGN KEY (suppid) 
        REFERENCES supplier (suppid)
        ON UPDATE CASCADE
) AUTO_INCREMENT = 2001;

DESC supplieraddress;

INSERT INTO itemcategory ( icdescription)
VALUES 
    ("Food"), 
    ("Beverages"), 
    ("Household"), 
    ("Personal Care"), 
    ("Apparel");

SELECT * FROM itemcategory;

INSERT INTO supplier (suppname, suppemail, suppofficeno, supphpno)
VALUES 
    ("Acme Inc.", "info@acme.com", "555-123-4567", "555-987-6543"),
    ("XYZ Enterprises", "contact@xyz.com", "555-555-1212", "555-555-3434"),
    ("123 Supplies", "sales@123supplies.com", "555-444-2222", "555-444-3333"),
    ("ABC Distributors", "orders@abc.com", "555-222-1212", "555-222-9876"),
    ("PQR Inc.", "customer_service@pqr.com", "555-333-4567", "555-333-7890");

SELECT * FROM supplier;

INSERT INTO item (itmcode, itmdesc, iccode, avgmthlyusage, reorderlevel, reorderqty)
VALUES 
    ("F1", "Bread", 101, 100, 50, 75),
    ("F2", "Milk", 101, 500, 300, 450),
    ("F3", "Cereal", 101, 200, 100, 150),
    ("F4", "Soda", 102, 1000, 750, 1125),
    ("F5", "Water", 102, 2000, 1500, 2250),
    ("G6", "Toilet Paper", 103, 5000, 3750, 5625),
    ("G7", "Trash Bags", 103, 1000, 750, 1125),
    ("G8", "Shampoo", 104, 1500, 1125, 1688),
    ("G9", "Conditioner", 104, 1000, 750, 1125),
    ("G10", "Soap", 104, 2000, 1500, 2250),
    ("H11", "Jeans", 105, 1000, 750, 1125),
    ("H12", "T-Shirts", 105, 2000, 1500, 2250),
    ("H13", "Dresses", 105, 500, 375, 563),
    ("H14", "Suits", 105, 100, 75, 113),
    ("H15", "Coats", 105, 250, 188, 281);

SELECT * FROM item;

INSERT INTO itemsupplier (itmcode, suppid, totqtysupptodate, firstdatesupply, lastdatesupply, stdprice, discount, minorderqty, maxorderqty)
VALUES 
    ("F1", 300001, 10000, "2022-01-01", "2022-01-31", 1.50, 0.10, 100, 1000),
    ("F2", 300001, 10000, "2022-01-01", "2022-01-31", 2.50, 0.10, 100, 1000),
    ("F2", 300002, 5000, "2022-02-01", "2022-02-28", 2.75, 0.05, 50, 500),
    ("F2", 300003, 2500, "2022-03-01", "2022-03-31", 3.00, 0.00, 25, 250),
    ("F3", 300001, 10000, "2022-01-01", "2022-01-31", 4.50, 0.10, 100, 1000),
    ("F3", 300005, 2500, "2022-03-01", "2022-03-31", 5.00, 0.00, 25, 250),
    ("F4", 300001, 10000, "2022-01-01", "2022-01-31", 1.50, 0.10, 100, 1000),
    ("F4", 300005, 5000, "2022-02-01", "2022-02-28", 1.75, 0.05, 50, 500),
    ("F4", 300003, 2500, "2022-03-01", "2022-03-31", 2.00, 0.00, 25, 250),
    ("F5", 300001, 10000, "2022-01-01", "2022-01-31", 2.50, 0.10, 100, 1000);

SELECT * FROM itemsupplier;

INSERT INTO supplieraddress (suppaddid, suppid, addr1, city, postcode, state)
VALUES 
    (2001, 300001, "123 Main St", "New York", "12345", "NY"),
    (2002, 300001, "456 Market St", "Chicago", "54321", "IL"),
    (2003, 300002, "789 Elm St", "Los Angeles", "98765", "CA"),
    (2004, 300002, "321 Oak Ave", "Dallas", "56789", "TX"),
    (2005, 300003, "654 Pine St", "Houston", "24689", "TX");

SELECT * FROM supplieraddress;

INSERT INTO itemstock (itmcode, stkcountdate, qtystock, stkcountstatus)
VALUES 
    ("F1", "2022-01-01", 1000, "Closed"),
    ("F1", "2022-02-01", 900, "Opened"),
    ("F1", "2022-03-01", 800, "Closed"),
    ("F1", "2022-04-01", 700, "Closed"),
    ("F1", "2022-05-01", 600, "Opened"),
    ("F2", "2022-01-01", 500, "Opened"),
    ("F2", "2022-02-01", 400, "Closed"),
    ("F2", "2022-03-01", 300, "Opened"),
    ("G7", "2022-04-01", 200, "Closed"),
    ("G7", "2022-05-01", 100, "Opened");

SELECT * FROM itemstock;

\! echo "\n1. Retrieve item code, item description, last stock count date and stock quantity that take place from the system for item code which the first character start from ‘G’."

SELECT itmcode, itmdesc, stkcountdate, qtystock
FROM item 
JOIN itemstock USING (itmcode)
WHERE itmcode LIKE "G%";

\! echo "\n2. Display supplier name and details address for supplier code 300001."

SELECT suppname, addr1, city, postcode, state
FROM supplier
JOIN supplieraddress USING (suppid)
wHERE suppid = 300001;

\! echo "\n3. Find the suppliers who supplied the item for every item code that exist in the system. You should display supplier id, name, item code, item description and last date supply for that item."

SELECT s.suppid, s.suppname, i.itmcode, i.itmdesc, isupp.lastdatesupply
FROM item i
RIGHT OUTER JOIN itemsupplier isupp ON i.itmcode = isupp.itmcode
JOIN supplier s ON isupp.suppid = s.suppid;

\! echo "\n4. Display item category, description, item code, description, and reorder quantity where all the item details must reflect to all item category that exist in the system."

SELECT ic.iccode, ic.icdescription, i.itmcode, i.itmdesc, i.reorderqty
FROM itemcategory ic
LEFT OUTER JOIN item i ON ic.iccode = i.iccode;

\! echo "\n5. Retrieve supplier code, supplier name, item code, description and last date supply for supplier code 300005. You should use USING operator in constructing SQL DML command."

SELECT s.suppid, s.suppname, i.itmcode, i.itmdesc, isupp.lastdatesupply
FROM supplier s
JOIN itemsupplier isupp USING (suppid)
JOIN item i USING (itmcode)
WHERE s.suppid = 300005;

\! echo "\n6. Display item code, description and current stock for item category that belong to ‘Home Appliances’. Rename the header of each attribute as ProductCode, ProductName and StockOnHand when populating your records."

SELECT i.itmcode AS ProductCode, i.itmdesc AS ProductName, istock.qtystock AS StockOnHand
FROM item i
JOIN itemstock istock ON i.itmcode = istock.itmcode
JOIN itemcategory ic ON i.iccode = ic.iccode
WHERE ic.icdescription = 'Home Appliances';

\! echo "\n7. Retrieve supplier address id, supplier id, address and state for all supplier that located at the same state and posses different supplier address id. You should sorting the records based on state, followed by supplier id."

SELECT sad.suppaddid, s.suppid, sad.addr1, sad.state
FROM supplier s
JOIN supplieraddress sad ON s.suppid = sad.suppid
WHERE sad.state IN (SELECT sad2.state FROM supplieraddress sad2 WHERE sad2.suppid <> s.suppid)
ORDER BY sad.state, s.suppid;
