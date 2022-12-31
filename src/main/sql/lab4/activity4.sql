CREATE USER user01 IDENTIFIED BY 'user123';

GRANT SELECT ON *.* TO user01;

SHOW GRANTS FOR user01;

DROP USER user01; -- cleanup purposes 
