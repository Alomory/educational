DROP DATABASE IF EXISTS activity1;
CREATE DATABASE activity1;
USE activity1;

CREATE TABLE Branch (
    branch_number INT PRIMARY KEY AUTO_INCREMENT,
    branch_name VARCHAR(255) NOT NULL,
    office_number VARCHAR(25) NOT NULL,
    contact_person VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 10;

CREATE TABLE Driver (
  driver_number INT PRIMARY KEY AUTO_INCREMENT,
  driver_name VARCHAR(255) NOT NULL,
  joined_date DATE NOT NULL,
  branch_number INT,
  FOREIGN KEY (branch_number) REFERENCES Branch (branch_number)
) AUTO_INCREMENT = 1001;

CREATE TABLE Vehicle (
  vehicle_number INT PRIMARY KEY AUTO_INCREMENT,
  plate_number VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  vehicle_year INT NOT NULL,
  last_fleet_maintenance DATE NOT NULL
) AUTO_INCREMENT = 200001;

CREATE TABLE Fleet (
  fleet_number INT PRIMARY KEY AUTO_INCREMENT,
  driver_number INT NOT NULL,
  vehicle_number INT NOT NULL,
  fleet_date DATE NOT NULL,
  fleet_type CHAR(2) NOT NULL
    CHECK (fleet_type IN ("01", "02")),
  fleet_status VARCHAR(255) NOT NULL,
  FOREIGN KEY (driver_number) 
    REFERENCES Driver (driver_number),
  FOREIGN KEY (vehicle_number) 
    REFERENCES Vehicle (vehicle_number)
) AUTO_INCREMENT = 9000001;

CREATE TABLE Job (
  job_id VARCHAR(255) PRIMARY KEY,
  job_description VARCHAR(255) NOT NULL,
  service_charge DECIMAL(10,2) NOT NULL,
  part_charge DECIMAL(10,2) NOT NULL,
  unit VARCHAR(255) NOT NULL
);

CREATE TABLE FleetDetails (
  fleet_number INT NOT NULL,
  job_id VARCHAR(255),
  quantity INT NOT NULL,
  charge_amount DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (job_id) REFERENCES Job (job_id)
);
