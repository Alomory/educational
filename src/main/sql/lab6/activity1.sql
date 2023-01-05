DROP DATABASE IF EXISTS activity1;
CREATE DATABASE activity1;
USE activity1;

CREATE TABLE profile (
  prfid VARCHAR(30) PRIMARY KEY,
  loginid VARCHAR(15) UNIQUE NOT NULL,
  prfname VARCHAR(55) NOT NULL,
  prfdob VARCHAR(55) NOT NULL,
  prfaddr1 VARCHAR(55),
  prfaddr2 VARCHAR(55),
  prfstate VARCHAR(30),
  prfpostcode INT(5),
  prfHPNo VARCHAR(15) NOT NULL,
  prfPassportNo VARCHAR(20),
  prfemail VARCHAR(30) NOT NULL,
  prfpwd VARCHAR(12) NOT NULL
);

DESC profile;

CREATE TABLE airport (
  airportcode VARCHAR(10) PRIMARY KEY,
  airportname VARCHAR(45) NOT NULL,
  city VARCHAR(30),
  country VARCHAR(30)
);

DESC airport;

CREATE TABLE airplane (
  airplanecode VARCHAR(30) PRIMARY KEY,
  airlinename VARCHAR(50) NOT NULL,
  manufactured VARCHAR(50),
  seatcapacity INT(30),
  airportcode VARCHAR(10) NOT NULL,
  FOREIGN KEY (airportcode) 
    REFERENCES airport(airportcode)
    ON UPDATE CASCADE
);

DESC airplane;

CREATE TABLE flight (
  flightno VARCHAR(15) PRIMARY KEY,
  airportcode VARCHAR(10) NOT NULL,
  departfrom VARCHAR(30),
  arrivalto VARCHAR(30),
  airplanecode VARCHAR(30) NOT NULL,
  FOREIGN KEY (airportcode) 
    REFERENCES airport(airportcode)
    ON UPDATE CASCADE,
  FOREIGN KEY (airplanecode) 
    REFERENCES airplane(airplanecode)
    ON UPDATE CASCADE
);

DESC flight;

CREATE TABLE flightdetails (
  flightno VARCHAR(15) NOT NULL,
  departuredate DATE NOT NULL,
  ticketprice DECIMAL(9,2),
  departtime TIME,
  arrivaltime TIME,
  duration INT,
  seatavailability INT,
  FOREIGN KEY (flightno) 
    REFERENCES flight(flightno)
    ON UPDATE CASCADE
);

DESC flightdetails;

CREATE TABLE booking (
  bookingid VARCHAR(15) PRIMARY KEY,
  prfid VARCHAR(30) NOT NULL,
  flightno VARCHAR(15) NOT NULL,
  bookingdate DATE,
  departuredate DATE NOT NULL,
  bookingstatus VARCHAR(30),
  FOREIGN KEY (prfid) 
    REFERENCES profile(prfid)
    ON UPDATE CASCADE,
  FOREIGN KEY (flightno) 
    REFERENCES flight(flightno)
);

DESC booking;

INSERT INTO airport (airportcode, airportname, city, country)
VALUES
  ('KUL', 'Kuala Lumpur Airport', 'Kuala Lumpur', 'Malaysia'),
  ('TGG', 'Sultan Mahmud KT Airport', 'Kuala Terengganu', 'Malaysia'),
  ('DMK', 'Suvarnabhumi Airport', 'Bangkok', 'Thailand'),
  ('CGK', 'Jakarta Soekarno-Hatta Int. Airport', 'Jakarta', 'Indonesia'),
  ('PEN', 'Penang Int. Airport', 'Penang', 'Malaysia'),
  ('SGN', 'Ho Chi Minh Airport', 'Ho Chi Minh', 'Vietnam'),
  ('SIN', 'Changi Int. Airport', 'Changi', 'Singapore'),
  ('KBR', 'Kota Bahru Airport', 'Kota Bahru', 'Malaysia'),
  ('LGK', 'Langkawi Int. Airport', 'Langkawi', 'Malaysia'),
  ('SYD', 'Sydney Int. Airport', 'Sydney', 'Australia'),
  ('KIX', 'Osaka Int. Airport', 'Osaka', 'Japan');

SELECT * FROM airport;

INSERT INTO airplane (airplanecode, airlinename, manufactured, seatcapacity, airportcode)
VALUES
  ('BFT125QR', 'Malaysia Airlines', 'Boeing', 155, 'KUL'),
  ('QZB34THY', 'AirAsia', 'Airbus', 135, 'KUL'),
  ('SFT5267U', 'Singapore Airlines', 'Airbus', 155, 'SIN'),
  ('PV178WE', 'AirAsia', 'Airbus', 135, 'KUL'),
  ('TH61GH8', 'Thai Airways', 'Boeing', 180, 'DMK'),
  ('HQA782K', 'Malaysia Airlines', 'Boeing', 155, 'KUL'),
  ('ZJK8286P', 'Malaysia Airlines', 'Boeing', 155, 'KUL'),
  ('KDK234Y', 'AirAsia', 'Airbus', 190, 'KUL'),
  ('SDH529H', 'AirAsia', 'Airbus', 155, 'CGK'),
  ('SRF458U', 'Singapore Airlines', 'Airbus', 190, 'SIN');

SELECT * FROM airplane;

INSERT INTO flight (flightno, airportcode, departfrom, arrivalto, airplanecode)
VALUES
  ('MH1130', 'KUL', 'KUL', 'KBR', 'BFT125QR'),
  ('MH1131', 'KUL', 'KBR', 'KUL', 'BFT125QR'),
  ('AK3522', 'KUL', 'KUL', 'SGN', 'QZB34THY'),
  ('AK2010', 'KUL', 'TGG', 'KUL', 'QZB34THY'),
  ('SQ106', 'SIN', 'SIN', 'KUL', 'SFT5267U'),
  ('SQ231', 'SIN', 'SIN', 'SYD', 'SFT5267U'),
  ('AK6322', 'KUL', 'KUL', 'LGK', 'PV178WE'),
  ('TG001', 'DMK', 'DMK', 'KUL', 'TH61GH8'),
  ('MH1326', 'KUL', 'KUL', 'TGG', 'HQA782K'),
  ('D7532', 'KUL', 'KUL', 'KIX', 'KDK234Y'),
  ('QZ200', 'CGK', 'CGK', 'KUL', 'SDH529H'),
  ('SQ552', 'SIN', 'SIN', 'KIX', 'SRF458U'),
  ('MH1450', 'KUL', 'KUL', 'PEN', 'ZJK8286P');

SELECT * FROM flight;

INSERT INTO profile (prfid, loginid, prfname, prfdob, prfaddr1, prfaddr2, prfstate, prfpostcode, prfHPNo, prfPassportNo, prfemail, prfpwd)
VALUES
  ('811201101002', 'user1', 'Nur Aznah Ibrahim', '01-12-1981', 'No. 5, Taman Pasir Putih', 'Pasir Puteh', 'Kelantan', 16800, '011-8802142', 'C3341298', 'aznah@gmail.com', 'user001'),
  ('830712074120', 'user2', 'Mohamad Rosli ALi', '12-07-1983', 'No. 3, Blok A1-2', 'Taman Perda', 'P. Pinang', 13800, '012-5541289', 'C0083487', 'rosli@yahoo.com.my', 'user002'),
  ('910215083021', 'user3', 'Ramlah Azman', '15-02-1991', '167, Tmn Alam Megah', 'Shah Alam', 'Selangor', 42300, '019-3329034', 'C5412123', 'ram@gmail.com', 'user003'),
  ('790516092123', 'user4', 'Angeline Lee', '16-05-1976', '6789, Astana Kondominium', 'Johor Bahru', 'Johor', 80300, '013-7783457', 'C1274589', 'angeline@gmail.com', 'user004'),
  ('890812071267', 'user5', 'Ahmad Yunos Azmi', '12-08-1989', 'Lot 16, Tmn Gong Badak', 'Kuala Terengganu', 'Terengganu', 21030, '016-9928927', 'C2204517', 'yunos@gmail.com', 'user005'),
  ('870412113245', 'user6', 'Abdul Rahman Ismail', '12-04-1987', 'Lot. 145, Kg. Tok Molor', 'Kuala Terengganu', 'Terengganu', 21070, '013-9982325', 'C1245689', 'ar@yahoo.com', 'user006'),
  ('841207110923', 'user7', 'Zainal Mokhtar', '07-12-1984', 'B123, Feringgi Apartment', 'Batu Ferringi', 'Penang', 11100, '019-5519729', 'C1547567', 'zainal@yahoo.com', 'user007'),
  ('FS-1001-200', 'user8', 'Steven Darren', '10-08-1982', 'A-102, Geylang Park', 'Geylang', 'Singapore', 388264, '+65-6681010', 'SG200100-10', 'darren@yahoo.com.sg', 'user008'),
  ('870910119034', 'user9', 'Nurwani Hashim', '10-09-1987', '12, Taman ketereh', 'Kota Bahru', 'Kelantan', 15200, '019-9961278', 'C7123789', 'wani@gmail.com', 'user009'),
  ('850918103698', 'user10', 'Wan Azman', '18-09-1985', 'No.2, Tmn Setia Alam', 'Klang', 'Selangor', 42400, '012-3353660', 'C5183672', 'wan@yahoo.com', 'user010');

SELECT * FROM profile;

INSERT INTO flightdetails (flightno, departuredate, ticketprice, departtime, arrivaltime, duration, seatavailability)
VALUES
  ('MH1130', '2016-08-12', 560.00, '9:50', '10:45', 50, 20),
  ('MH1131', '2016-08-12', 480.00, '11:30', '12:20', 50, 70),
  ('AK3522', '2016-08-13', 550.00, '13:15', '14:35', 90, 55),
  ('AK3522', '2016-08-18', 490.00, '16:30', '17:30', 90, 78),
  ('AK2010', '2016-08-14', 189.00, '20:05', '21:00', 55, 15),
  ('SQ106', '2016-08-15', 890.00, '9:00', '10:00', 60, 10),
  ('SQ231', '2016-08-20', 1890.00, '00:30', '06:30', 360, 35),
  ('AK6322', '2016-08-22', 220.00, '11:35', '12:20', 45, 10),
  ('TG001', '2016-08-16', 1400.00, '9:00', '11:15', 135, 80),
  ('MH1326', '2016-08-28', 460.00, '9:15', '10:10', 55, 45),
  ('D7532', '2016-09-05', 1900.00, '14:30', '21:30', 420, 60),
  ('QZ200', '2016-09-07', 380.00, '10:00', '11:15', 75, 20),
  ('SQ552', '2016-09-07', 2300.00, '9:00', '16:00', 420, 60),
  ('MH1450', '2016-09-05', 110.00, '15:00', '15:50', 50, 5);

SELECT * FROM flightdetails;

INSERT INTO booking (bookingid, prfid, flightno, bookingdate, departuredate, bookingstatus)
VALUES
  ('PQ36TY', '811201101002', 'AK3522', '2016-07-07', '2016-08-13', 'Confirmed'),
  ('ZY78UJ', '790516092123', 'SQ106', '2016-07-25', '2016-08-15', 'Confirmed'),
  ('G34ERU', '870412113245', 'AK6322', '2016-06-15', '2016-08-22', 'Confirmed'),
  ('MA5RT7', '830712074120', 'AK2010', '2016-07-01', '2016-08-14', 'Confirmed'),
  ('PD63TJ', '841207110923', 'AK3522', '2016-07-15', '2016-08-18', 'Confirmed'),
  ('LF34FB7', '910215083021', 'MH1450', '2016-07-11', '2016-09-05', 'Confirmed'),
  ('BZ59YUK', '890812071267', 'D7532', '2016-08-15', '2016-09-05', 'Booking'),
  ('N5GH78', 'FS-1001-200', 'TG001', '2016-04-12', '2016-08-16', 'Confirmed'),
  ('A45F6Y', '811201101002', 'MH1130', '2016-07-02', '2016-08-12', 'Confirmed'),
  ('QK52TG', '870910119034', 'QZ200', '2016-05-18', '2016-09-07', 'Confirmed'),
  ('BNPYK3', '870412113245', 'AK2010', '2016-06-10', '2016-08-14', 'Confirmed'),
  ('TK43FK', '790516092123', 'SQ106', '2016-07-05', '2016-08-15', 'Confirmed'),
  ('P43ERF', '890812071267', 'AK6322', '2016-07-28', '2016-08-22', 'Confirmed'),
  ('8R421G', '830712074120', 'SQ231', '2016-05-10', '2016-08-20', 'Confirmed'),
  ('S45NB6', 'FS-1001-200', 'MH1131', '2016-08-01', '2016-08-12', 'Confirmed'),
  ('D2KYUT', '790516092123', 'SQ552', '2016-04-04', '2016-09-07', 'Confirmed'),
  ('ZB52FD', '841207110923', 'MH1326', '2016-07-22', '2016-08-28', 'Confirmed'),
  ('RS40TG2', '850918103698', 'AK6322', '2015-06-03', '2016-08-22', 'Confirmed'),
  ('AG47Y8', '870910119034', 'MH1450', '2016-07-12', '2016-09-05', 'Booking');
  
SELECT * FROM booking;
