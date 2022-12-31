USE activity1;

CREATE INDEX reg_studid_ind ON registrations (student_id);
CREATE UNIQUE INDEX student_ind ON students (student_name, student_status);
CREATE INDEX crs_crsname_ind ON courses (course_name);

SHOW INDEX FROM registrations;
SHOW INDEX FROM students;
SHOW INDEX FROM courses;

DROP INDEX crs_crsname_ind ON courses;