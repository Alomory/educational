USE activity1;

\! echo "There is a two (2) requests from one of the end user to view the students who register the course and to view student information. Based on this request, the management of ABC College will only allow the end user to view information such a registration number, course id and course status from the system. For student information, the end user is applicable to view only student from Kuala Lumpur. As a Database Administrator (DBA) for ABC College, you are requested to complete the request. Subsequenly, verify these requests are created accordingly.\n"

SELECT students.*
FROM students, registrations
WHERE registrations.student_id = students.student_id 
    AND students.address_state = "Kuala Lumpur";