USE activity1;


\! echo 'Retrieve customer code, name, state and contact number for all records';
SELECT cust_number, cust_name, state, contact_no FROM Customer;


\! echo 'Retrieve customer information who originated from ‘Selangor’';
SELECT * FROM Customer
WHERE state = 'Selangor';


\! echo 'Retrieve invoice number, customer code, date of invoice and amount where these invoices shipped using operator known as ‘GDex’';
SELECT inv_number, inv_date, cust_number, inv_amount FROM Invoice
WHERE shipped_by = 'GDex';


\! echo 'Modify the description of the product from ‘TV LCD 4 inch’ to ‘TV LCD Plasma 4 inch’ for product code ‘AW-1001’';
SELECT * FROM Product;

UPDATE Product 
SET prod_desc = 'TV LCD Plasma 4 inch'
WHERE prod_code = 'AW-1001';

SELECT * FROM Product;


\! echo 'Retrieve information that consists of invoice number, date, customer number and amount for invoice date from 22 August 2016 to 25 August 2016';
SELECT inv_number, inv_date, cust_number, inv_amount FROM Invoice
WHERE inv_date BETWEEN '2016-08-22' AND '2016-08-25';


\! echo 'Insert the records into tables';
SELECT * FROM Product;

INSERT INTO Product (prod_code, prod_desc, unit, sales_price)
VALUES ('AC-5510', 'Panasonic air-cond 1.5 Hose Power ECO', 'Box', 2300.00);

SELECT * FROM Product;

-- Invoice
SELECT * FROM Invoice;

INSERT INTO Invoice (inv_number, inv_date, cust_number, inv_amount, shipped_by, ship_trackingno)
VALUES ('10006', '2016-08-28', 'C0001', 2300.00, 'DHL', 'DHL/2145-004');

SELECT * FROM Invoice;

-- Invoice Line
SELECT * FROM Invoice_line;

INSERT INTO Invoice_line (inv_number, prod_code, quantity, sales_price, total_sales)
VALUES ('10006', 'AC-5510', 1, 2300.00, 2300.00);

SELECT * FROM Invoice_line;


\! echo 'Update product code for product AC-5510 to AC-5587';
UPDATE Product 
SET prod_code = 'AC-5187'
WHERE prod_code = 'AC-5510';

SELECT * FROM Product;
SELECT * FROM Invoice;
SELECT * FROM Invoice_line;


\! echo 'Display the description of product and price for product that having sales price is less than 2000.00';
SELECT prod_desc FROM Product
WHERE sales_price < 2000.00;


\! echo 'Change the contact number for customer ‘C1003’ to 016-5585050';
SELECT * FROM Customer
WHERE cust_number = 'C1003';

UPDATE Customer 
SET contact_no = '016-5585050'
WHERE cust_number = 'C1003';

SELECT * FROM Customer
WHERE cust_number = 'C1003';


\! echo 'Retrieve customer information and sort the record by state in ascending order';
SELECT * FROM Customer
ORDER BY state ASC;


\! echo 'Retrieve invoice number, customer code, date of invoice, amount and shipped by for invoice date after 22 August 2016 and sort the records by invoice date in descending order';
SELECT inv_number, inv_date, cust_number, inv_amount FROM Invoice
WHERE inv_date > '2016-08-22'
ORDER BY inv_date DESC;
