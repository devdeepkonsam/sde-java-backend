SELECT name,age FROM students
WHERE class = 'A1'
ORDER BY age DESC;


SELECT id,name,english FROM  students,marks
WHERE students.id = marks.student_id
ORDER BY english
LIMIT 5;