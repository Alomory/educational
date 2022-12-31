DROP DATABASE IF EXISTS activity1;
CREATE DATABASE activity1;
USE activity1;

CREATE TABLE students (
  student_id VARCHAR(10) PRIMARY KEY,
  student_name VARCHAR(50) NOT NULL,
  student_address VARCHAR(70),
  address_city VARCHAR(25),
  address_state VARCHAR(25),
  phone_number VARCHAR(25),
  student_status INTEGER NOT NULL 
    CHECK (student_status IN (1, 2, 3))
);

CREATE TABLE faculties (
  faculty_id INTEGER PRIMARY KEY,
  faculty_name VARCHAR(50),
  office_no VARCHAR(15),
  contact_person VARCHAR(50)
);

CREATE TABLE courses (
  course_id VARCHAR(15) PRIMARY KEY,
  course_name VARCHAR(50) NOT NULL,
  total_credit INTEGER NOT NULL,
  course_level VARCHAR(15) NOT NULL,
  faculty_id INTEGER NOT NULL,
  FOREIGN KEY (faculty_id) 
    REFERENCES faculties (faculty_id) 
    ON UPDATE CASCADE
);

CREATE TABLE registrations (
  registration_id VARCHAR(15) PRIMARY KEY,
  student_id VARCHAR(10) NOT NULL,
  registration_date DATE NOT NULL,
  payment_status CHAR(1) NOT NULL
    CHECK (payment_status IN ('Y', 'N')),
  FOREIGN KEY (student_id) 
    REFERENCES students (student_id)
    ON UPDATE CASCADE
);

CREATE TABLE course_register (
  registration_id VARCHAR(15) NOT NULL,
  course_id VARCHAR(15) NOT NULL,
  course_status VARCHAR(15),
  price DECIMAL(7,2),
  FOREIGN KEY (registration_id)
    REFERENCES registrations (registration_id)
    ON UPDATE CASCADE,
  FOREIGN KEY (course_id)
    REFERENCES courses (course_id)
    ON UPDATE CASCADE
);

INSERT INTO students (student_id, student_name, student_address, address_city, address_state, phone_number, student_status)
VALUES 
  ('S12001', 'Ahmad Roslan', 'No.45, Presint 7', 'Putrajaya', 'Kuala Lumpur', '013-3841010', 2),
  ('S23008', 'Chan Wee Liew', 'DS-301, Desa Apartment', 'Kepong', 'Kuala Lumpur', '019-3884747', 1),
  ('S23002', 'Rosnah Rahman', 'Lot. 34, Kg. Seberang', 'Marang', 'Terengganu', '011-9957458', 1),
  ('S23037', 'Sri Shanti Devi', 'No. 7, Tmn Perwira', 'Kuantan', 'Pahang', '016-6685650', 1),
  ('S23025', 'Mohamad Ramli', 'No. 212, Jln Matang', 'Kuching', 'Sarawak', '012-8825698', 1);

SELECT * FROM students;

INSERT INTO faculties (faculty_id, faculty_name, office_no, contact_person)
VALUES 
  (100, 'Faculty of Information Technology', '09-7751212', 'Mr. Sabri'),
  (200, 'Faculty of Science', '09-7751010', 'Ms. Ramlah'),
  (300, 'Faculty of Engineering', '09-7755678', 'Mr. Abd Ghani'),
  (400, 'Faculty of Arts', '09-7751312', 'Mr. Eric'),
  (500, 'Faculty of Medicine', '09-7758720', 'Ms. Hamidah');

SELECT * FROM faculties;

INSERT INTO courses (course_id, course_name, total_credit, course_level, faculty_id)
VALUES 
  ('CS100', 'Introduction to Computer', 3, 'Degree', 100),
  ('CS201', 'Basic Programming', 3, 'Degree', 100),
  ('CS345', 'Introduction to Internet of Things', 4, 'Degree', 100),
  ('EG522', 'Engineering Science', 4, 'Master', 300),
  ('BG401', 'Bioinformatics', 3, 'Degree', 200);

SELECT * FROM courses;

INSERT INTO registrations (registration_id, student_id, registration_date, payment_status)
VALUES
  ('R10011', 'S12001', '2015-09-22', 'Y'),
  ('R10122', 'S23002', '2016-02-12', 'N'),
  ('R10025', 'S23037', '2016-02-12', 'N'),
  ('R10035', 'S23008', '2016-02-16', 'Y'),
  ('R10049', 'S23025', '2016-02-26', 'N');

SELECT * FROM registrations;

INSERT INTO course_register (registration_id, course_id, course_status, price)
VALUES ('R10011', 'CS100', 'Active', 450.00),
  ('R10011', 'CS201', 'Active', 450.00),
  ('R10011', 'CS345', 'Active', 450.00),
  ('R10122', 'CS100', 'Active', 450.00),
  ('R10122', 'CS201', 'Active', 450.00),
  ('R10025', 'CS201', 'Active', 450.00),
  ('R10025', 'BG401', 'Active', 450.00),
  ('R10035', 'CS201', 'Active', 450.00),
  ('R10035', 'CS345', 'Active', 450.00),
  ('R10035', 'BG401', 'Active', 450.00),
  ('R10049', 'EG522', 'Active', 600.00);

SELECT * FROM course_register;

\! echo "\nTask 3"
\! echo "You are requested to retrieve registration information such registration number, student id and register date who still do not pay the fees and tranform this records into a new table known as pending_payment. Finally, retrieve all information from pending_payment table.\n"

CREATE TABLE pending_payment AS
SELECT registration_id, student_id, registration_date
FROM registrations
WHERE payment_status = 'N';

SELECT * FROM pending_payment;
