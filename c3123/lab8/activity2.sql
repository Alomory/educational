USE Lab8;

\! echo "1. Retrieve employee number, employee name and charge amount for employee who involve in project 10002. In your output, concatenate employee number and employee with separator ‘ - ‘ and rename it as Employee_Details."
SELECT 
    CONCAT(employee_id, " - ", employee_name) AS employee_detail,
    charge_amount
FROM EmployeeWork
JOIN Employee USING (employee_id)
WHERE work_id IN (
    SELECT work_id 
    FROM Work 
    WHERE project_id = 10002
); 
-- WHERE work_id = 'W2002'; 

\! echo ""
\! echo "2. Retrieve employee name and the first twelve (12) characters job description for employee number range from 101 and 114. Rename job description as Roles."
SELECT 
    employee_name, 
    SUBSTRING(job_description, 1, 12) AS roles
FROM Employee
JOIN Job USING (job_id)
WHERE employee_id 
    BETWEEN 101 AND 114;

\! echo ""
\! echo "3. Display the employee number, employee first name and work hour for those working hour is more than 50 hours and working with project 10006."

SELECT
    employee_id,
    SUBSTRING(employee_name, 1, LOCATE(' ', employee_name)) AS first_name,
    work_hour
FROM EmployeeWork
JOIN Employee USING (employee_id)
JOIN Work USING (work_id)
WHERE work_hour > 50 
    AND project_id = 10006;

\! echo ""
\! echo "4. Retrieve employee name and total charge amount for employee who working as ‘System Developer’. Rename total charge amount as Amount_Accumulate and remove any decimal places."

SELECT
    employee_name,
    ROUND(SUM(charge_amount)) AS accumulate_amount
FROM EmployeeWork
JOIN Employee USING (employee_id)
JOIN Job USING (job_id) 
WHERE job_description = 'System Developer'
GROUP BY employee_name;

\! echo ""
\! echo "5. Find employee name, job description and number of service for the employee."

SELECT
    employee_name,
    MAX(job_description) AS job_description,
    COUNT(work_id) AS services
FROM Employee
JOIN Job USING (job_id)
JOIN EmployeeWork USING (employee_id)
JOIN Work USING (work_id)
GROUP BY employee_name;

\! echo ""
\! echo "6. Retrieve project number, project name, employee name and assign date who involve in project 10006. You should format the assign date as ‘dd-mm-yyyy’."

SELECT 
    project_id, 
    project_name, 
    employee_name, 
    DATE_FORMAT(Work.assign_date, '%d-%m-%Y') as assign_date
FROM EmployeeWork
JOIN Employee USING (employee_id) 
JOIN Work USING (work_id) 
JOIN Project USING (project_id)
WHERE project_id = 10006;
