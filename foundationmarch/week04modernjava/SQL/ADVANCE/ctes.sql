/* Common Table Expressions (CTEs) examples (MySQL 8+)
   Path: foundationmarch/week04modernjava/SQL/DDLandDML/advance/ctes.sql
*/

/* 1) Simple CTE: compute total marks per student */
WITH student_totals AS (
  SELECT student_id,
         (english + maths + physics + chemistry + biology) AS total
  FROM marks
)
SELECT s.id, s.name, st.total
FROM students s
JOIN student_totals st ON s.id = st.student_id
ORDER BY st.total DESC;

/* 2) CTE used for filtering: students above average total */
WITH student_totals AS (
  SELECT student_id,
         (english + maths + physics + chemistry + biology) AS total
  FROM marks
), avg_total AS (
  SELECT AVG(total) AS avg_total FROM student_totals
)
SELECT s.id, s.name, st.total
FROM students s
JOIN student_totals st ON s.id = st.student_id
CROSS JOIN avg_total a
WHERE st.total > a.avg_total
ORDER BY st.total DESC;

/* 3) Recursive CTE example (adapt if you have a hierarchical table)
WITH RECURSIVE org AS (
  SELECT id, manager_id, name FROM employees WHERE id = 1 -- root
  UNION ALL
  SELECT e.id, e.manager_id, e.name FROM employees e
  JOIN org o ON e.manager_id = o.id
)
SELECT * FROM org;
*/

/* End CTE examples */
