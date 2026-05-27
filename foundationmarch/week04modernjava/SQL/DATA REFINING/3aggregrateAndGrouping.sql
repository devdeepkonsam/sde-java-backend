SELECT COUNT(*) AS total_student FROM students;

SELECT class, COUNT(*) AS total_students FROM students
GROUP BY class
HAVING COUNT(*) = 9; 

SELECT class, AVG(age) AS average_age FROM students
GROUP BY class; 

SELECT class, SUM(age) AS total_age FROM students
GROUP BY class;

SELECT class, COUNT(*) AS no_of_students, SUM(english) AS english_total, AVG(maths) AS avg_math FROM students,marks
WHERE students.id = marks.student_id
GROUP BY class;
