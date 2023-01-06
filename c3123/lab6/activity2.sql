USE activity1;

\! echo "find the number of airports that originated from Malaysia"

SELECT COUNT(*) AS TotalMalaysiaAirport
FROM airport
WHERE country = 'Malaysia';

\! echo "find the number of AirAsia flights with a booking status of 'Confirmed' that depart between 05 June 2016 and 15 August 2016"

SELECT COUNT(*)
FROM booking b
JOIN flight f ON b.flightno = f.flightno
JOIN airplane a ON f.airplanecode = a.airplanecode
WHERE b.bookingstatus = 'Confirmed' AND a.airlinename = 'AirAsia' AND b.departuredate BETWEEN '2016-06-05' AND '2016-08-15';

\! echo "display the maximum and minimum ticket prices for Malaysia Airlines flights booked between 01 April and 15 September 2016"

SELECT MAX(f.ticketprice) AS MaxPrice, MIN(f.ticketprice) AS MinPrice
FROM flightdetails f, booking b, airport a
WHERE (b.bookingdate BETWEEN '2016-04-01' AND '2016-09-15') AND a.country = 'Malaysia';
