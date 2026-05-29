/* Transactions examples (MySQL)
   Path: foundationmarch/week04modernjava/SQL/DDLandDML/advance/transactions.sql
*/

/* Notes:
 - AUTOCOMMIT = 1 by default in MySQL. Use START TRANSACTION or setAutoCommit(false) in JDBC.
 - ACID: Atomicity, Consistency, Isolation, Durability.
*/

-- Basic commit
START TRANSACTION;
UPDATE marks SET maths = maths + 5 WHERE student_id = 1;
UPDATE marks SET physics = physics + 3 WHERE student_id = 1;
COMMIT;

-- Rollback on error
START TRANSACTION;
UPDATE marks SET maths = maths + 10 WHERE student_id = 2;
-- simulate an error condition here (e.g. constraint violation)
ROLLBACK; -- undoes the update above

-- Savepoint usage (partial rollback)
START TRANSACTION;
UPDATE marks SET english = english + 2 WHERE student_id = 3;
SAVEPOINT sp_after_english;
UPDATE marks SET maths = maths + 20 WHERE student_id = 3;
ROLLBACK TO SAVEPOINT sp_after_english; -- undo only the maths update
COMMIT;

-- Row-level lock example to prevent lost updates
START TRANSACTION;
SELECT * FROM marks WHERE student_id = 4 FOR UPDATE; -- locks the row(s)
UPDATE marks SET total = english+maths+physics+chemistry+biology WHERE student_id = 4;
COMMIT;

-- Set isolation level for session
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
-- ...work under READ COMMITTED...
COMMIT;

/* End transactions examples */
