DROP DATABASE IF EXISTS activity5;
CREATE DATABASE activity5;
USE activity5;

CREATE TABLE course (
    courseID VARCHAR(10),
    courseName VARCHAR(50)
);

INSERT INTO course (courseID, courseName)
VALUES
    ("CS1001", "Programming"),
    ("CS2001", "Programming But Better"),
    ("CS3001", "Machine Don't Learn");

SELECT * FROM course;

DELETE FROM course;

SELECT * FROM course;

DESCRIBE course;
