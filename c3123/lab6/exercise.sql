DROP DATABASE IF EXISTS Lab6;
CREATE DATABASE Lab6;
USE Lab6;

CREATE TABLE Organiser (
  organiser_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  postcode INT NOT NULL,
  state VARCHAR(255) NOT NULL,
  contact_person VARCHAR(255) NOT NULL,
  contact_number VARCHAR(25) NOT NULL,
  email_address VARCHAR(255) NOT NULL
);

DESC Organiser;

CREATE TABLE Venue (
  venue_id INT PRIMARY KEY,
  venue_name VARCHAR(255) NOT NULL,
  street VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  state VARCHAR(255) NOT NULL,
  post_code INT NOT NULL
);

DESC Venue;

CREATE TABLE Conference (
  conference_id VARCHAR(10) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  conference_date DATE NOT NULL,
  year INT NOT NULL,
  conference_theme VARCHAR(255) NOT NULL,
  venue_id INT NOT NULL,
  organiser_id INT NOT NULL,
  FOREIGN KEY (venue_id) 
    REFERENCES Venue(venue_id)
    ON UPDATE CASCADE,
  FOREIGN KEY (organiser_id)
    REFERENCES Organiser(organiser_id)
    ON UPDATE CASCADE
);

DESC Conference;

CREATE TABLE Participant (
  participant_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  designation VARCHAR(255) NOT NULL
    CHECK (designation IN ("professional", "educator", "postgraduate")),
  company VARCHAR(255) NOT NULL,
  fees DECIMAL(9, 2) NOT NULL
    CHECK (fees IN (3000, 2500, 2000)),
  conference_id VARCHAR(10) NOT NULL,
  FOREIGN KEY (conference_id) 
    REFERENCES Conference(conference_id)
    ON UPDATE CASCADE
) AUTO_INCREMENT = 10001;

DESC Participant;

INSERT INTO Organiser (organiser_id, name, address, postcode, state, contact_person, contact_number, email_address)
VALUES 
  (100, 'ABC Research Corporation', '123 Main St', 12345, 'State 1', 'John Smith', '555-555-1212', 'john@example.com'),
  (2, 'XYZ Research Company', '456 Main St', 54321, 'State 2', 'Jane Doe', '555-555-1213', 'jane@example.com'),
  (3, 'Research Company A', '789 Main St', 9876, 'State 3', 'Bob Johnson', '555-555-1214', 'bob@example.com'),
  (4, 'Research Company B', '111 Main St', 11111, 'State 4', 'Carol Williams', '555-555-1215', 'carol@example.com'),
  (5, 'Research Company C', '222 Main St', 22222, 'State 5', 'Fred Thompson', '555-555-1216', 'fred@example.com');

SELECT * FROM Organiser;

INSERT INTO Venue (venue_id, venue_name, street, city, state, post_code)
VALUES
  (1, 'Company 1', '123 Main St', 'City 1', 'Kuala Lumpur', 12345),
  (2, 'Company 2', '456 Main St', 'City 2', 'Langkawi', 54321),
  (3, 'Company 3', '789 Main St', 'City 3', 'Penang', 9876),
  (4, 'Venue D', '999 Main St', 'City 4', 'State 4', 22222),
  (5, 'Venue E', '111 Main St', 'City 5', 'State 5', 33333);

SELECT * FROM Venue;

INSERT INTO Conference (conference_id, name, conference_date, year, conference_theme, venue_id, organiser_id)
VALUES 
  ("1", 'Conference 1', '2008-01-01', 2008, 'Theme 1', 1, 100),
  ("2", 'Conference 2', '2010-01-01', 2010, 'Theme 2', 2, 2),
  ("3", 'Conference 3', '2016-01-01', 2016, 'Theme 3', 3, 3),
  ("DSC2010", 'Conference 4', '2003-01-01', 2003, 'Theme 4', 1, 100),
  ("IOTC2016", 'Conference 5', '2015-01-01', 2015, 'Theme 5', 2, 100);

SELECT * FROM Conference;

INSERT INTO Participant (name, designation, company, fees, conference_id)
VALUES
  ('Alice', 'professional', 'Company A', 3000, "1"),
  ('Bob', 'educator', 'Company B', 2500, "2"),
  ('Charlie', 'postgraduate', 'Company C', 2000, "3"),
  ('David', 'professional', 'Company D', 3000, "DSC2010"),
  ('Eve', 'educator', 'Company E', 2500, "IOTC2016");

SELECT * FROM Participant;

\! echo "summarize the number of participants that attended each conference organized by each organiser"

SELECT o.name AS "Organiser Name", c.conference_id AS "Conference ID", COUNT(p.participant_id) AS "Number of Participants"
FROM Organiser o
INNER JOIN Conference c ON o.organiser_id = c.organiser_id
INNER JOIN Participant p ON c.conference_id = p.conference_id
GROUP BY o.name, c.conference_id
ORDER BY o.name ASC;

\! echo "list the companies and the total fees paid for conferences that took place in years 2008, 2010, and 2016"

SELECT p.company AS "Company", SUM(p.fees) AS "Total Fees Paid"
FROM Participant p
INNER JOIN Conference c ON p.conference_id = c.conference_id
WHERE c.year IN (2008, 2010, 2016)
GROUP BY p.company;

\! echo "find the venues where more than one conference was held"

SELECT v.venue_name AS "Venue Name", COUNT(c.conference_id) AS "Number of Conferences", SUM(p.fees) AS "Total Fees Paid"
FROM Venue v
INNER JOIN Conference c ON v.venue_id = c.venue_id
INNER JOIN Participant p ON c.conference_id = p.conference_id
GROUP BY v.venue_name
HAVING COUNT(c.conference_id) > 1;

\! echo "display conference ID, conference name, conference year, and number of sessions held for all conferences organized by an organizer with ID 100 for conference years 2003 and 2015, grouped by conference ID, conference name, and conference year"

SELECT conference_id, name, year, COUNT(*) as num_conferences
FROM Conference
WHERE organiser_id = 100 AND year IN (2003, 2015)
GROUP BY conference_id, name, year;

\! echo "find the conference ID, name, and maximum fees paid by participants who attend a conference for conference codes DSC2010 and IOTC2016"

SELECT c.conference_id, c.name, MAX(p.fees) as max_fees
FROM Conference c
INNER JOIN Participant p USING (conference_id)
WHERE c.conference_id IN ('DSC2010', 'IOTC2016')
GROUP BY c.conference_id, c.name;

\! echo "display the participant ID, name, and number of conferences attended by participants who attended conferences organized in Kuala Lumpur, Langkawi, and Penang, sorted by the number of conferences attended in descending order"

SELECT p.participant_id, p.name, COUNT(*) as num_conferences
FROM Participant p
INNER JOIN Conference c ON p.conference_id = c.conference_id
INNER JOIN Venue v ON c.venue_id = v.venue_id
WHERE v.state IN ('Kuala Lumpur', 'Langkawi', 'Penang')
GROUP BY p.participant_id, p.name
ORDER BY num_conferences DESC;

