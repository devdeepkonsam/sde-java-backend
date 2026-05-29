/* Index examples for students and marks tables */

/* 1) Create single-column indexes */
CREATE INDEX idx_students_name ON students(name);
CREATE INDEX idx_students_class ON students(class);

/* 2) Composite index for common multi-column filters (left-most prefix rule) */
CREATE INDEX idx_students_class_age ON students(class, age);

/* 3) Ensure marks.student_id is a foreign key (it is already PRIMARY KEY in current schema).
   If you allow multiple marks rows per student, convert primary key appropriately and add FK + index: */
ALTER TABLE marks
  ADD CONSTRAINT fk_marks_student FOREIGN KEY (student_id) REFERENCES students(id);

/* 4) Add a stored generated column for total and index it (useful if you query by total frequently) */
ALTER TABLE marks
  ADD COLUMN total INT GENERATED ALWAYS AS (english + maths + physics + chemistry + biology) STORED;
CREATE INDEX idx_marks_total ON marks(total);

/* 5) Drop an index (MySQL syntax) */
DROP INDEX idx_students_name ON students;

/* 6) EXPLAIN samples to validate index usage */
EXPLAIN SELECT * FROM students WHERE name = 'Alice';
EXPLAIN SELECT * FROM students WHERE class = '10' AND age > 15;
EXPLAIN SELECT s.name, m.total
FROM students s
JOIN marks m ON s.id = m.student_id
WHERE m.total > 400
ORDER BY m.total DESC;

/* Notes:
 - Primary keys are indexed automatically.
 - Prefer indexing columns used in WHERE, JOIN, ORDER BY, GROUP BY.
 - Avoid indexing very low-cardinality columns alone (e.g., boolean).
 - Each index speeds reads but slows INSERT/UPDATE/DELETE and uses storage.
*/
