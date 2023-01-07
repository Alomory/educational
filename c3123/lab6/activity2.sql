USE Lab6;

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

\! echo "To retrieve the information you've requested, you can use the following queries: Retrieve airport code, airport name, number of flight and average flight duration for all airport order by airport name in ascending order."

SELECT airportcode, airportname, COUNT(flightno) AS num_flights, AVG(duration) AS avg_duration
FROM airport
JOIN flight ON airport.airportcode = flight.airportcode
JOIN flightdetails ON flight.flightno = flightdetails.flightno
GROUP BY airport.airportcode
ORDER BY airportname ASC;

\! echo "Display profile id, profile name, his state and the frequent passenger flies for passenger who make more than one booking."

SELECT profile.prfid, prfname, prfstate, COUNT(booking.prfid) AS num_bookings
FROM profile
JOIN booking ON profile.prfid = booking.prfid
GROUP BY profile.prfid
HAVING COUNT(booking.prfid) > 1;

\! echo "Display passenger id, name, total amount ticket price booked by every passenger where the total amount of ticket price is exceeded the average ticket price offered by Air Asia airlines."

SELECT profile.prfid, prfname, SUM(flightdetails.ticketprice) AS total_ticket_price
FROM profile
JOIN booking ON profile.prfid = booking.prfid
JOIN flightdetails ON booking.flightno = flightdetails.flightno
GROUP BY profile.prfid
HAVING SUM(flightdetails.ticketprice) > (SELECT AVG(ticketprice) FROM flightdetails);
