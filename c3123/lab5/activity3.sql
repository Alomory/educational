USE lab5;

SELECT j.job_id, j.job_description, fd.fleet_number
    FROM Job j
    LEFT JOIN FleetDetails fd ON j.job_id = fd.job_id;

SELECT v.vehicle_number, v.plate_number, f.fleet_number
    FROM Vehicle v
    RIGHT JOIN Fleet f ON v.vehicle_number = f.vehicle_number
    WHERE f.fleet_type = '02';
