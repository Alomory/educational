DROP DATABASE IF EXISTS exercise;
CREATE DATABASE exercise;
USE exercise;

CREATE TABLE Branch (
  branch_id INT(3) PRIMARY KEY,
  branch_name VARCHAR(50) NOT NULL,
  branch_city VARCHAR(30),
  branch_state VARCHAR(30)
);

DESC Branch;

CREATE TABLE Salesman (
  salesman_id INT(5) PRIMARY KEY AUTO_INCREMENT,
  salesman_name VARCHAR(50) NOT NULL,
  salesman_birthdate DATE,
  salesman_branch INT(3) NOT NULL,
  FOREIGN KEY (salesman_branch) 
    REFERENCES Branch(branch_id) 
    ON UPDATE CASCADE
) AUTO_INCREMENT = 2000;

DESC Salesman;

CREATE TABLE Sales (
  sales_reference INT(8) PRIMARY KEY AUTO_INCREMENT,
  sales_date DATE NOT NULL,
  sales_amount DECIMAL(9,2),
  salesman_id INT(5) NOT NULL,
  FOREIGN KEY (salesman_id) 
    REFERENCES Salesman(salesman_id)
    ON UPDATE CASCADE
) AUTO_INCREMENT = 900000;

DESC Sales;

INSERT INTO Branch (branch_id, branch_name, branch_city, branch_state)
VALUES 
  (1, 'Branch 1', 'City 1', 'Kuala Lumpur'),
  (2, 'Branch 2', 'City 2', 'State 2'),
  (3, 'Branch 3', 'City 3', 'Kuala Lumpur'),
  (4, 'Branch 4', 'City 4', 'Kuala Lumpur'),
  (5, 'Branch 5', 'City 5', 'State 5'),
  (6, 'Branch 6', 'City 6', 'State 6'),
  (7, 'Branch 7', 'City 7', 'Kuala Lumpur'),
  (112, 'Branch 8', 'City 8', 'State 8'),
  (9, 'Branch 9', 'City 9', 'State 9'),
  (10, 'Branch 10', 'City 10', 'State 10');

SELECT * FROM Branch;

INSERT INTO Salesman (
    salesman_name, salesman_birthdate, salesman_branch)
VALUES 
  ('Salesman 1', '2000-01-01', 1),
  ('Salesman 2', '2001-01-01', 2),
  ('Salesman 3', '2002-01-01', 3),
  ('Salesman 4', '2003-01-01', 4),
  ('Salesman Mohd 5', '2004-01-01', 5),
  ('Salesman 6', '2005-01-01', 6),
  ('Salesman 7', '2006-01-01', 7),
  ('Salesman Mohd 8', '2007-01-01', 112),
  ('Salesman Mohd 9', '2008-01-01', 9),
  ('Salesman 10', '2009-01-01', 10);

SELECT * FROM Salesman;

INSERT INTO Sales (sales_date, sales_amount, salesman_id)
VALUES
  ('2015-11-25', 12345.67, 2001),
  ('2015-11-25', 23456.78, 2002),
  ('2015-12-25', 34567.89, 2003),
  ('2015-11-26', 45678.90, 2004),
  ('2015-11-27', 56789.01, 2005),
  ('2015-11-27', 67890.12, 2006),
  ('2015-11-27', 78901.23, 2007),
  ('2015-11-28', 89012.34, 2008),
  ('2015-11-28', 90123.45, 2009),
  ('2015-12-29', 12345.56, 2000);

SELECT * FROM Sales;

\! echo "\nRetrieve a list of sales with a selling date of 28 November 2015 and a selling price greater than 75K"

SELECT s.sales_reference, s.sales_date, s.sales_amount
FROM Sales s
WHERE s.sales_date = '2015-11-28' AND s.sales_amount > 75000;

\! echo "\nCreate a new table called KLBranch and include all branch information except the state for all Kuala Lumpur branches"

CREATE TABLE KLBranch AS
SELECT branch_id, branch_name, branch_city
FROM Branch
WHERE branch_state = 'Kuala Lumpur';

SELECT * FROM KLBranch;

\! echo "\nCreate a new index called salesman_name_index on the Salesman table to improve the performance of queries that retrieve specific salesmen"

CREATE INDEX salesman_name_index ON Salesman (salesman_name);

SHOW INDEX FROM Salesman;

\! echo "\nProvide sales information to all salesmen across Malaysia without exposing the sales reference number and sales amount for each sale, you can create a new view called SalesmanSalesInfo that only includes the relevant information."

CREATE VIEW SalesmanSalesInfo AS
  SELECT s.salesman_id, s.salesman_name, COUNT(*) as total_sales
  FROM Salesman s
  INNER JOIN Sales sa ON s.salesman_id = sa.salesman_id
  GROUP BY s.salesman_id, s.salesman_name;

SELECT * FROM SalesmanSalesInfo;

\! echo "\nDisplay the sales_id, sales_name, and sales_branch columns for salesmen whose names contain the string 'Mohd'"

SELECT s.salesman_id, s.salesman_name, s.salesman_branch
FROM Salesman s
WHERE s.salesman_name LIKE '%Mohd%';

\! echo "\nDisplay the branch_code, branch_name, and branch_city columns for branches whose city names begin with the letter 'K'"

SELECT b.branch_id, b.branch_name, b.branch_city
FROM Branch b
WHERE b.branch_city LIKE 'K%';

\! echo "\nUpdate the sales_name column to 'Fairuz Nasaruddin' for the salesman with sales_id 2007 and sales_branch 112"

UPDATE Salesman
SET salesman_name = 'Fairuz Nasaruddin'
WHERE salesman_id = 2007 AND salesman_branch = 112;

SELECT * FROM Salesman
WHERE salesman_id = 2007 AND salesman_branch = 112;

\! echo "\nCreate a user user04 with password 'u04@ser' and grant the SELECT role on the Sales table"

CREATE USER user04 IDENTIFIED BY 'u04@ser';
GRANT SELECT ON Sales TO user04;

SHOW GRANTS FOR user04;

\! echo "\nAs user user04, update selling price for a sale with sales_reference 900006 using UPDATE statement:\n"

\! mysql -u user04 -pu04@ser -D exercise -e "UPDATE Sales SET sales_amount = 55000 WHERE sales_reference = 900006"

\! echo "\nReceived an error message indicating that user04 do not have the necessary privileges to update the Sales table since they only has the SELECT privilege on the Sales table."

DROP USER user04; -- cleanup

\! echo "\nRetrieve the sales_reference, sales_date, and sales_amount columns for sales that occurred in December"

SELECT s.sales_reference, s.sales_date, s.sales_amount
FROM Sales s
WHERE s.sales_date LIKE '%-12-%';
