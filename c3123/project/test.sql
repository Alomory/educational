USE Project;

\! echo "vendor create info"

INSERT INTO Vendor (vendor_id, vendor_name, contact_name, vendor_email, vendor_phone)
VALUES (115, 'I Sell Something', 'Someone', 'someone@somwhere.someplace', '0123456789');

SELECT * 
FROM Vendor 
WHERE vendor_id = 115;

\! echo ""
\! echo "vendor update info"

UPDATE Vendor
SET vendor_name = "I Sell Someone"
WHERE vendor_id = 115;

SELECT * 
FROM Vendor 
WHERE vendor_id = 115;

\! echo ""
\! echo "vendor delete info"

DELETE
FROM Vendor
WHERE vendor_id = 115;

SELECT * 
FROM Vendor;

\! echo ""
\! echo "vendor get orders"

-- SELECT * 
-- FROM VendorOrder 
-- WHERE vendor = 110
-- ORDER BY datetime;

\! mysql -u vendor -ppassword -D Project -e "SELECT * FROM VendorOrder WHERE vendor = 110 ORDER BY datetime"
\! echo "if try to execute as customer (impossible but still)"
\! mysql -u customer -ppassword -D Project -e "SELECT * FROM VendorOrder WHERE vendor = 110 ORDER BY datetime"

\! echo ""
\! echo "vendor get customer info"

-- SELECT * 
-- FROM CustomerInfo
-- WHERE id IN (
--     SELECT customer
--     FROM VendorOrder 
--     WHERE vendor = 110
-- );

\! mysql -u vendor -ppassword -D Project -e "SELECT * FROM CustomerInfo WHERE id IN (SELECT customer FROM VendorOrder WHERE vendor = 110)"

\! echo ""
\! echo "customer create info"

INSERT INTO Customer (first_name, last_name, customer_email, customer_phone)
VALUES ('John', 'Doe', 'johndoe@email.com', '555-555-5555');

SELECT * 
FROM Customer
WHERE customer_id = 105;

\! echo ""
\! echo "customer update info"

UPDATE Customer
SET first_name = 'Jane', last_name = 'Diu', customer_email = 'janediu@email.com'
WHERE customer_id = 105;

SELECT * 
FROM Customer
WHERE customer_id = 105;

\! echo ""
\! echo "customer delete info"

DELETE FROM Customer
WHERE customer_id = 106;

SELECT * 
FROM Customer;

\! echo ""
\! echo "customer get orders"

INSERT INTO Orders (customer_id, product_id, vendor_id, quantity, order_total, order_status) 
VALUES (100, 119, 110, 4, 80.00, 'Pending');

-- SELECT *
-- FROM CustomerOrder
-- WHERE customer = 100
-- ORDER BY datetime;

\! mysql -u customer -ppassword -D Project -e "SELECT * FROM CustomerOrder WHERE customer = 100 ORDER BY datetime"

\! echo ""
\! echo "customer get vendors"

-- SELECT * 
-- FROM VendorInfo
-- WHERE id IN (
--     SELECT vendor
--     FROM CustomerOrder
--     WHERE customer = 100
-- );

\! mysql -u customer -ppassword -D Project -e "SELECT * FROM VendorInfo WHERE id IN (SELECT vendor FROM CustomerOrder WHERE customer = 100)"

\! echo ""
\! echo "update order status"

SELECT * 
FROM Orders
WHERE order_id = 6;

-- CALL UpdateOrderStatus(6, "Delivered");

\! mysql -u customer -ppassword -D Project -e "CALL UpdateOrderStatus(6, 'Delivered')"

SELECT * 
FROM Orders
WHERE order_id = 6;

\! echo ""
\! echo "create note"

-- CALL CreateNote(1, "Better quality pls");

\! mysql -u customer -ppassword -D Project -e "CALL CreateNote(1, 'Better quality pls')"

SELECT * 
FROM Note
WHERE order_id = 1;

\! echo ""
\! echo "update note"

-- CALL UpdateNote(126, "No actually, give me the best one");

\! mysql -u customer -ppassword -D Project -e "CALL UpdateNote(126, 'No actually, give me the best one')"

SELECT * 
FROM Note
WHERE order_id = 1;

\! echo ""
\! echo "delete note"

-- CALL DeleteNote(126);

\! mysql -u customer -ppassword -D Project -e "CALL DeleteNote(126)"

SELECT * 
FROM Note
WHERE order_id = 1;

\! echo ""
\! echo "system list top 3 product"

SELECT product_id, product_name, count(order_id)
FROM Product 
RIGHT JOIN Orders USING (product_id)
GROUP BY product_id 
ORDER BY product_name
LIMIT 3;
