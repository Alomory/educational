DROP DATABASE IF EXISTS Lab5;
CREATE DATABASE Lab5;
USE Lab5;

CREATE TABLE Student (
    student_id VARCHAR(10) PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    contact_number VARCHAR(25),
    student_grade DECIMAL(5, 2)
);

CREATE TABLE Course (
    course_id VARCHAR(15) PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    faculty VARCHAR(25) NOT NULL,
    credit INT
);

CREATE TABLE Enrollment (
    student_id VARCHAR(10) NOT NULL,
    course_id VARCHAR(15) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    result INT,
    grade VARCHAR(5),
    FOREIGN KEY (student_id) 
        REFERENCES Student(student_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (course_id)
        REFERENCES Course(course_id)
        ON UPDATE CASCADE
);

INSERT INTO Student (student_id, student_name, contact_number, student_grade)
VALUES 
    ('S001', 'John Smith', '555-555-1212', 3.87),
    ('S002', 'Jane Doe', '555-555-2345', 3.67),
    ('S003', 'Tom Jones', '555-555-4567', 3.97),
    ('S004', 'Samantha Johnson', '555-555-6789', 3.77),
    ('S005', 'Richard Anderson', '555-555-8901', 3.95);

INSERT INTO Course (course_id, course_name, faculty, credit)
VALUES 
    ('CSF3402', 'Computer Science 101', 'IT', 3),
    ('C002', 'Mathematics 101', 'FDM', 3),
    ('C003', 'Physics 101', 'SCI', 4),
    ('C004', 'Chemistry 101', 'SCI', 3),
    ('C005', 'Biology 101', 'BIO', 4);

INSERT INTO Enrollment (student_id, course_id, semester, result, grade)
VALUES 
    ('S001', 'CSF3402', 'Fall 2020', 80, 'A'),
    ('S002', 'C002', 'Fall 2020', 75, 'B'),
    ('S003', 'C003', 'Fall 2020', 96, 'A'),
    ('S004', 'C004', 'Winter 2021', 73, 'B'),
    ('S005', 'C005', 'Winter 2021', 87, 'A'),
    ('S003', 'CSF3402', 'Winter 2021', 60, 'C');

SELECT student_id, student_name, course_id, course_name
FROM Student
JOIN Enrollment USING (student_id)
JOIN Course c USING (course_id)
WHERE c.course_id = 'CSF3402';
