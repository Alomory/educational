USE activity1;

\! echo "1. Display the student id, name for posses character ‘Ro’."

SELECT student_id, student_name
FROM students
WHERE student_name LIKE '%Ro%';

\! echo "\n2. Retrieve course id, course name and credit hours for course that begin with word as ‘Introduction’."

SELECT course_id, course_name, total_credit
FROM courses
WHERE course_name LIKE 'Introduction%';

\! echo "\n3. Retrieve registration number, student id and registration date for the fifth characters for student id which begin with the character ‘2’."

SELECT registration_id, student_id, registration_date
FROM registrations
WHERE SUBSTR(student_id, 5, 1) = '2';
