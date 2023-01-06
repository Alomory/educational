-- Task 1
USE activity3;

\! echo 'srvservice (old)';
DESCRIBE srvservice;

ALTER TABLE srvservice
ADD FOREIGN KEY (custCode) REFERENCES srvcustomer(custCode);

ALTER TABLE srvservice
ADD FOREIGN KEY (vecNo) REFERENCES srvvehicle(vecNo);

\! echo 'srvservice';
DESCRIBE srvservice;

-- Task 2
DROP DATABASE IF EXISTS activity4; 
CREATE DATABASE activity4;
USE activity4;

CREATE TABLE Student (
    stuID VARCHAR(6) PRIMARY KEY,
    stuName VARCHAR(50),
    gender CHAR(1),
    program VARCHAR(70),
    intake INT(4),
    CONSTRAINT chk_gender CHECK( 
        gender IN ('M', 'F') 
    )
);

\! echo 'Student (old)';
DESCRIBE Student;

INSERT INTO Student (stuID, stuName, gender, program, intake) 
VALUES 
    ('A10023', 'Nelo Crutzz', 'M', 'Software Engineering', 2014),
    ('A20106', 'Aqib Franco', 'M', 'Informatics', 2015),
    ('A30078', 'Ameerah Bradshaw', 'F', 'Networking', 2016);

ALTER TABLE Student
MODIFY COLUMN stuName VARCHAR(10);

\! echo 'Student';
DESCRIBE Student;

SELECT * FROM Student;
