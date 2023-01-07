DROP DATABASE IF EXISTS lab5;
CREATE DATABASE lab5;
USE lab5;

CREATE TABLE prodvendor (
    prcode VARCHAR(255) NOT NULL,
    prvendor VARCHAR(255) NOT NULL,
    prpricing DECIMAL(10,2) NOT NULL
);

INSERT INTO prodvendor (prcode, prvendor, prpricing)
VALUES
    ('PW-1001', 'P10', 500.00),
    ('PQ-4570', 'P88', 35.00),
    ('MM-120E', 'P67', 245.00),
    ('MM-F12WR', 'P10', 1210.00),
    ('PW-QZR-09', 'P10', 79.00),
    ('PQ-4570', 'P10', 32.50),
    ('MM-120E', 'P88', 242.00),
    ('PW-1001', 'P45', 550.00),
    ('MM-F12WR', 'P73', 1200.00),
    ('PQ-4570', 'P67', 33.00),
    ('MM-F12WR', 'P35', 1189.00),
    ('PW-1001', 'P23', 510.00),
    ('PQ-4570', 'P35', 36.00),
    ('MM-120E', 'P23', 250.00);

SELECT p1.prcode, p1.prpricing, p1.prvendor
FROM prodvendor p1 
JOIN (
    SELECT prcode 
    FROM prodvendor 
    GROUP BY prcode 
    HAVING COUNT(*) > 1
) p2 
ON p1.prcode = p2.prcode
ORDER BY p1.prcode ASC;
