/* Window Functions examples (MySQL 8+)
   Path: foundationmarch/week04modernjava/SQL/DDLandDML/advance/window_functions.sql
*/

/* 1) Rank students by total (global ranking) */
WITH student_totals AS (
  SELECT student_id,
         (english + maths + physics + chemistry + biology) AS total
  FROM marks
)
SELECT s.id, s.name, st.total,
       ROW_NUMBER() OVER (ORDER BY st.total DESC) AS rn,
       RANK()      OVER (ORDER BY st.total DESC) AS rnk,
       DENSE_RANK() OVER (ORDER BY st.total DESC) AS drnk
FROM students s
JOIN student_totals st ON s.id = st.student_id
ORDER BY st.total DESC;

/* 2) Partitioned window: rank students within each class */
WITH student_totals AS (
  SELECT s.id AS student_id, s.name, s.class,
         (m.english + m.maths + m.physics + m.chemistry + m.biology) AS total
  FROM students s
  JOIN marks m ON s.id = m.student_id
)
SELECT student_id, name, class, total,
       ROW_NUMBER() OVER (PARTITION BY class ORDER BY total DESC) AS row_in_class,
       SUM(total) OVER (PARTITION BY class) AS class_sum,
       AVG(total) OVER (PARTITION BY class) AS class_avg
FROM student_totals
ORDER BY class, total DESC;

/* 3) Sliding / cumulative window: running total by class ordered by total */
WITH student_totals AS (
  SELECT s.id AS student_id, s.name, s.class,
         (m.english + m.maths + m.physics + m.chemistry + m.biology) AS total
  FROM students s
  JOIN marks m ON s.id = m.student_id
)
SELECT student_id, name, class, total,
       SUM(total) OVER (PARTITION BY class ORDER BY total DESC
                         ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS running_total
FROM student_totals
ORDER BY class, total DESC;

/* End window function examples */
