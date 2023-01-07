DROP DATABASE IF EXISTS lab5;
CREATE DATABASE lab5;
USE lab5;

CREATE TABLE Branch (
  branch_number INT PRIMARY KEY AUTO_INCREMENT,
  branch_name VARCHAR(255) NOT NULL,
  office_number VARCHAR(25) NOT NULL,
  contact_person VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 10;

DESC Branch;

CREATE TABLE Driver (
  driver_number INT PRIMARY KEY AUTO_INCREMENT,
  driver_name VARCHAR(255) NOT NULL,
  joined_date DATE NOT NULL,
  branch_number INT,
  FOREIGN KEY (branch_number) 
    REFERENCES Branch (branch_number)
    ON UPDATE CASCADE
) AUTO_INCREMENT = 1001;

DESC Driver;

CREATE TABLE Vehicle (
  vehicle_number INT PRIMARY KEY AUTO_INCREMENT,
  plate_number VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  vehicle_year INT NOT NULL,
  last_fleet_maintenance DATE NOT NULL
) AUTO_INCREMENT = 200001;

DESC Vehicle;

CREATE TABLE Fleet (
  fleet_number INT PRIMARY KEY AUTO_INCREMENT,
  driver_number INT NOT NULL,
  vehicle_number INT NOT NULL,
  fleet_date DATE NOT NULL,
  fleet_type CHAR(2) NOT NULL
    CHECK (fleet_type IN ("01", "02")),
  fleet_status VARCHAR(255) NOT NULL,
  FOREIGN KEY (driver_number) 
    REFERENCES Driver (driver_number)
    ON UPDATE CASCADE,
  FOREIGN KEY (vehicle_number) 
    REFERENCES Vehicle (vehicle_number)
    ON UPDATE CASCADE
) AUTO_INCREMENT = 9000001;

DESC Fleet;

CREATE TABLE Job (
  job_id VARCHAR(255) PRIMARY KEY,
  job_description VARCHAR(255) NOT NULL,
  service_charge DECIMAL(10,2) NOT NULL,
  part_charge DECIMAL(10,2) NOT NULL,
  unit VARCHAR(255) NOT NULL
);

DESC Job;

CREATE TABLE FleetDetails (
  fleet_number INT NOT NULL,
  job_id VARCHAR(255),
  quantity INT NOT NULL,
  charge_amount DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (job_id) 
    REFERENCES Job (job_id)
    ON UPDATE CASCADE
);

DESC FleetDetails;

CREATE TABLE Billing (
  billing_number INT PRIMARY KEY AUTO_INCREMENT,
  fleet_number INT NOT NULL,
  payment_type VARCHAR(255) NOT NULL,
  payment_date DATE NOT NULL,
  payment_amount DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (fleet_number) 
    REFERENCES Fleet (fleet_number)
);

DESC Billing;

INSERT INTO Branch (branch_name, office_number, contact_person)
VALUES
  ('Kuala Terengganu', '09-6671020', 'Amri Aziz'),
  ('Kemaman', '09-6951234', 'Sharifah Syed Ali'),
  ('Besut', '09-6973490', 'Rohaiza Rahmad');

SELECT * FROM Branch;

INSERT INTO Driver (driver_name, joined_date, branch_number)
VALUES
  ('Mohd Hashim Ali', '2015-09-12', 10),
  ('Hamzah Razali', '2015-10-14', 11),
  ('Arif Fadillah', '2015-10-15', 12),
  ('Wan Haizan Wan Omar', '2015-11-02', 10),
  ('Badrulhisham Mokhtar', '2016-01-15', 11);

SELECT * FROM Driver;

INSERT INTO Vehicle (plate_number, model, vehicle_year, last_fleet_maintenance)
VALUES
  ('TBS1234', 'MAN SE', 2015, '2016-01-17'),
  ('TBS2021', 'MAN SE', 2015, '2016-01-04'),
  ('TBU5912', 'Hino Motors', 2015, '2016-01-15'),
  ('TBU9890', 'Isuzu Motors', 2016, '2016-01-15'),
  ('TBV2000', 'Hino Motors', 2016, '2016-02-26'),
  ('TBW7878', 'Hino Motors', 2016, '2015-12-02');

SELECT * FROM Vehicle;

INSERT INTO Fleet (driver_number, vehicle_number, fleet_date, fleet_type, fleet_status)
VALUES
  (1001, 200001, '2015-10-10', '01', 'Closed'),
  (1002, 200002, '2015-11-05', '01', 'Closed'),
  (1004, 200003, '2015-11-17', '01', 'Closed'),
  (1001, 200001, '2015-11-21', '02', 'WIP'),
  (1003, 200004, '2015-11-25', '01', 'Closed'),
  (1005, 200005, '2015-12-14', '01', 'Closed'),
  (1001, 200006, '2015-12-16', '01', 'Closed'),
  (1004, 200002, '2016-01-04', '01', 'Closed'),
  (1005, 200003, '2016-01-15', '01', 'WIP'),
  (1003, 200004, '2016-01-15', '02', 'WIP'),
  (1001, 200001, '2016-01-17', '01', 'Open'),
  (1002, 200005, '2016-02-26', '01', 'Open');

SELECT * FROM Fleet;

INSERT INTO Job (job_id, job_description, service_charge, part_charge, unit)
VALUES
  ('Lub-01', 'Lubricant Minor Svs', 100.00, 500.00, '1 unit'),
  ('Lub-02', 'Lubricant Major Svs', 200.00, 800.00, '1 unit'),
  ('Lub-03', 'Lubricant Major Svs + Break Lubricant', 500.00, 1200.00, '1 unit'),
  ('Part-01', 'Spare Part Service Minor', 300.00, 600.00, '1 unit'),
  ('Part-02', 'Spare Part Service Major', 300.00, 1400.00, '1 unit'),
  ('Part-03', 'Spare Part Service Overhaul', 1200.00, 8000.00, '1 unit'),
  ('AirC-01', 'Air-Cond Minor Maintenance', 400.00, 600.00, '1 unit'),
  ('AirC-02', 'Air-Cond Major Maintenance', 700.00, 1500.00, '1 unit'),
  ('AirC-03', 'Air-Cond Replacement', 600.00, 6000.00, '1 unit'),
  ('BA-01', 'Balancing & Alignment', 300.00, 100.00, '1 unit'),
  ('Tyre-01', 'Rotation', 150.00, 0.00, 'N.A'),
  ('Tyre-02', 'Tyres Replacement', 60.00, 1000.00, '1 unit'),
  ('WTY-01', 'Warranty Minor', 0.00, 0.00, '1 unit'),
  ('WTY-02', 'Warranty Major', 0.00, 0.00, '1 unit');

SELECT * FROM Job;

INSERT INTO FleetDetails (fleet_number, job_id, quantity, charge_amount)
VALUES
  (9000001, 'Lub-01', 1, 600.00),
  (9000001, 'Part-01', 1, 900.00),
  (9000002, 'Lub-01', 1, 600.00),
  (9000002, 'Part-01', 1, 900.00),
  (9000002, 'AirC-01', 1, 1000.00),
  (9000003, 'Lub-02', 1, 1000.00),
  (9000003, 'Part-02', 2, 3400.00),
  (9000003, 'BA-01', 1, 400.00),
  (9000004, 'AirC-03', 1, 0.00),
  (9000005, 'Lub-03', 1, 1700.00),
  (9000006, 'Lub-01', 1, 600.00),
  (9000006, 'Part-01', 1, 900.00),
  (9000007, 'Lub-02', 1, 1000.00),
  (9000007, 'Part-02', 1, 3400.00),
  (9000007, 'Tyre-02', 2, 2120.00),
  (9000008, 'Lub-01', 1, 600.00),
  (9000008, 'Part-01', 1, 900.00),
  (9000009, 'Lub-03', 1, 1700.00),
  (9000009, 'Part-02', 1, 3400.00),
  (9000009, 'AirC-01', 1, 1000.00),
  (9000009, 'Tyre-01', 1, 150.00),
  (9000010, 'AirC-03', 1, 0.00),
  (9000010, 'Part-02', 1, 0.00),
  (9000011, 'Lub-01', 1, 600.00),
  (9000011, 'Part-01', 1, 900.00),
  (9000011, 'AirC-01', 1, 1000.00),
  (9000012, 'Lub-03', 1, 1700.00),
  (9000012, 'Part-02', 1, 3400.00),
  (9000012, 'BA-01', 1, 400.00);

SELECT * FROM FleetDetails;

INSERT INTO Billing (billing_number, fleet_number, payment_type, payment_date, payment_amount)
VALUES
  (88000001, 9000001, 'Credit', '2015-10-10', 1500.00),
  (88000002, 9000002, 'Credit', '2015-11-05', 2500.00),
  (88000003, 9000003, 'Credit', '2015-11-17', 4800.00),
  (88000004, 9000004, 'Wty Credit', '2015-11-21', 0.00),
  (88000005, 9000005, 'Credit', '2015-11-25', 1700.00),
  (88000006, 9000006, 'Credit', '2015-12-14', 1500.00),
  (88000007, 9000007, 'Cash', '2015-12-02', 6520.00),
  (88000008, 9000008, 'Credit', '2016-01-04', 1500.00),
  (88000009, 9000009, 'Credit', '2016-01-15', 6250.00),
  (88000010, 9000010, 'Wty Credit', '2016-01-15', 0.00),
  (88000011, 9000011, 'Credit', '2016-01-17', 2500.00),
  (88000012, 9000012, 'Credit', '2016-02-26', 5500.00);

SELECT * FROM Billing;
