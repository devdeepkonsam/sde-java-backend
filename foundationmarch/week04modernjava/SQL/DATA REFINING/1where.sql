SELECT name,class,age FROM students 
WHERE class = 'A1';

SELECT id,name,address FROM students 
WHERE age BETWEEN 19 AND 21;

SELECT * FROM marks
WHERE english > 80;

SELECT * FROM marks
WHERE maths >= 85 AND physics >= 90;

SELECT student_id,chemistry,biology FROM marks
WHERE chemistry < 90 OR biology < 70;