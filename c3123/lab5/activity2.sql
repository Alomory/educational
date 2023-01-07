USE lab5;

SELECT d.driver_number, d.driver_name, d.joined_date
    FROM Driver d
    INNER JOIN Branch b ON d.branch_number = b.branch_number
    WHERE b.branch_name = 'Kuala Terengganu';

SELECT j.job_description, fd.charge_amount
    FROM FleetDetails fd
    INNER JOIN Job j ON fd.job_id = j.job_id
    WHERE fd.fleet_number = 9000003;

SELECT f.driver_number, d.driver_name, f.fleet_number, f.fleet_status, v.plate_number
    FROM Fleet f
    INNER JOIN Driver d ON f.driver_number = d.driver_number
    INNER JOIN Vehicle v ON f.vehicle_number = v.vehicle_number
    WHERE f.fleet_date = '2016-01-15'
    AND f.fleet_type = '01';

SELECT f.fleet_number, d.driver_name, fd.job_id
    FROM Fleet f
    JOIN Driver d ON f.driver_number = d.driver_number
    JOIN FleetDetails fd ON f.fleet_number = fd.fleet_number
    JOIN Branch b ON d.branch_number = b.branch_number
    WHERE f.fleet_type = '02' AND b.branch_name = 'Besut';
