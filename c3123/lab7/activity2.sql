USE Lab7;

\! echo ""
\! echo "1. Find customer name, order number and order amount if order amount is greater than average sales amount of the customers and sort the record by customer name."

SELECT Customer.name, Orders.order_no, OrderDetails.amount
FROM Customer
JOIN OrderDetails USING (customer_code)
JOIN Orders USING (order_no)
WHERE OrderDetails.amount > (SELECT AVG(amount) FROM OrderDetails)
ORDER BY Customer.name;

\! echo ""
\! echo "2. By using subquery, display orderno, item code, description and the amount for customer ‘CS30120’."

SELECT Orders.order_no, OrderDetails.item_code, OrderDetails.item_description, OrderDetails.amount
FROM OrderDetails
JOIN Orders USING (order_no)
WHERE OrderDetails.customer_code = "CS30120";

\! echo ""
\! echo "3. Display customer code and name that does not make an order for item code ‘Nike-101’ that representing ‘Dwi Layer Running Shoes’. Sort your result by customer code."

SELECT customer_code, name
FROM Customer
WHERE customer_code NOT IN (
    SELECT customer_code 
    FROM OrderDetails
    WHERE item_code = 'Nike-101' 
)
ORDER BY customer_code;

\! echo ""
\! echo "4. Retrieve order no, order date, customer code and total sales amount for order type ‘Company Order’ and the total sales amount exceeded each sales amount for customer code ‘CS21578’"

SELECT Orders.order_no, Orders.order_date, customer_code, amount
FROM OrderDetails
JOIN Orders USING (order_no)
WHERE Orders.order_type = 'Company Order'
AND amount > ALL (
    SELECT amount
    FROM OrderDetails
    JOIN Orders USING (order_no)
    WHERE customer_code = 'CS21578'
);

\! echo ""
\! echo "5. Find the salemancode and name that received the order from customer which the delivery date for the items is before the delivery date for order placed by customer ‘CS30287’."

SELECT Salesman.salesman_id, Salesman.name 
FROM Salesman
INNER JOIN Customer ON Salesman.salesman_id = Customer.salesman_id
JOIN OrderDetails USING (customer_code)
JOIN Orders USING (order_no)
WHERE Orders.delivery_date < (
    SELECT MAX(delivery_date) 
    FROM Orders
    JOIN OrderDetails USING (order_no)
    WHERE customer_code = 'CS30287'
);

\! echo ""
\! echo "6. Retrieve a list of item code and decription that do not purchased by customer code ‘CS21578’ and ‘CS30120’."

SELECT item_code, item_description 
FROM OrderDetails
WHERE item_code NOT IN (SELECT item_code FROM OrderDetails WHERE customer_code IN ('CS21578', 'CS30120'));
