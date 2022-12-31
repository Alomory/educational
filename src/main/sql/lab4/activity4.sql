DROP USER IF EXISTS user01;

CREATE USER user01 
    IDENTIFIED BY 'user123';

GRANT SELECT ON *.* TO 'user01'@'%';

SELECT * FROM mysql.user;

DROP USER user01; -- cleanup purposes 
