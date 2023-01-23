DROP DATABASE IF EXISTS Lab8;
CREATE DATABASE Lab8;
USE Lab8;

-- CREATE TABLE Project (
--     workNo VARCHAR(20),
--     projectNo VARCHAR(20),
--     projectName VARCHAR(255),
--     assignDate DATE,
--     empNo VARCHAR(20),
--     empName VARCHAR(255),
--     joinDate DATE,
--     jobId VARCHAR(20),
--     jobDescription VARCHAR(255),
--     rateHour DECIMAL(10,2),
--     workHour INT,
--     chargeAmount DECIMAL(10,2)
-- );

CREATE TABLE Job (
    job_id VARCHAR(20) 
        PRIMARY KEY,
    job_description VARCHAR(255),
    rate_hour DECIMAL(10,2)
);

CREATE TABLE Employee (
    employee_id INT 
        PRIMARY KEY,
    job_id VARCHAR(20)
        NOT NULL,
    employee_name VARCHAR(255),
    join_date DATE,
    FOREIGN KEY (job_id) 
        REFERENCES Job(job_id)
        ON UPDATE CASCADE
);

CREATE TABLE Project (
    project_id INT 
        PRIMARY KEY,
    project_name VARCHAR(255)
);

CREATE TABLE Work (
    work_id VARCHAR(20) 
        PRIMARY KEY,
    project_id INT 
        NOT NULL,
    assign_date DATE,
    FOREIGN KEY (project_id) 
        REFERENCES Project(project_id)
        ON UPDATE CASCADE
);

-- CREATE TABLE BadSchema (
CREATE TABLE EmployeeWork (
    id INT
        PRIMARY KEY 
        AUTO_INCREMENT,
    employee_id INT,
    work_id VARCHAR(20),
    work_hour INT,
    charge_amount DECIMAL(10,2),
    FOREIGN KEY (employee_id)
        REFERENCES Employee(employee_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (work_id)
        REFERENCES Work(work_id)
        ON UPDATE CASCADE
);

INSERT INTO Project (project_id, project_name) 
VALUES 
    (10002, 'Oracle data migration'),
    (10006, 'eProduction Development');

INSERT INTO Work (work_id, project_id, assign_date) 
VALUES 
    ('W2002', 10002, '2016-10-12'),
    ('W3044', 10006, '2016-10-18');

INSERT INTO Job (job_id, job_description, rate_hour) 
VALUES
    ('J05', 'Project Manager', 200.00),
    ('J08', 'Database Admin', 100.00),
    ('J12', 'System Analyst', 120.00),
    ('J31', 'System Developer', 50.00),
    ('J25', 'Senior System Developer', 80.00);

INSERT INTO Employee (employee_id, employee_name, job_id, join_date) 
VALUES
    (101, 'Abdul Fahmi Razak', 'J05', '2009-02-03'),
    (107, 'Meor Hashim Meor Ngah', 'J08', '2010-05-20'),
    (112, 'Mohamad Azami Daud', 'J12', '2010-05-28'),
    (118, 'Ramli Azman', 'J31', '2011-06-22'),
    (120, 'Anita Jusoh', 'J31', '2011-12-02'),
    (102, 'Fridaus Othman', 'J05', '2009-03-17'),
    (114, 'Asma Che Amin', 'J12', '2010-06-15'),
    (123, 'Fahmi Abdullah', 'J25', '2012-03-01'),
    (124, 'Nuridzuan Ahmad', 'J31', '2012-03-15');

INSERT INTO EmployeeWork (employee_id, work_id, work_hour, charge_amount) 
VALUES 
    (101, 'W2002', 24, 4800.00),
    (107, 'W2002', 32, 3200.00),
    (112, 'W2002', 32, 3840.00),
    (118, 'W2002', 160, 8000.00),
    (120, 'W2002', 160, 8000.00),
    (102, 'W3044', 80, 16000.00),
    (107, 'W3044', 15, 1500.00),
    (114, 'W3044', 120, 12000.00),
    (123, 'W3044', 160, 12800.00),
    (124, 'W3044', 160, 8000.00);
