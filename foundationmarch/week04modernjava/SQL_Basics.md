# SQL Basics - Week 4

## Overview
SQL (Structured Query Language) is the standard for interacting with relational databases like MySQL, PostgreSQL, and Oracle.

---

## 1. Basic CRUD Operations

### CREATE (INSERT)
Add new records to a table.

```sql
-- Insert single row
INSERT INTO users (id, name, email, age) 
VALUES (1, 'Alice', 'alice@example.com', 25);

-- Insert multiple rows
INSERT INTO users (id, name, email, age) VALUES 
(2, 'Bob', 'bob@example.com', 30),
(3, 'Charlie', 'charlie@example.com', 28);
```

### READ (SELECT)
Retrieve data from a table.

```sql
-- Select all columns
SELECT * FROM users;

-- Select specific columns
SELECT name, email FROM users;

-- Select with WHERE clause (filter)
SELECT * FROM users WHERE age > 25;
SELECT * FROM users WHERE name = 'Alice';

-- Select with AND/OR
SELECT * FROM users WHERE age > 25 AND email LIKE '%@example.com';
SELECT * FROM users WHERE age < 20 OR age > 30;
```

### UPDATE
Modify existing records.

```sql
-- Update single record
UPDATE users SET age = 26 WHERE id = 1;

-- Update multiple records
UPDATE users SET age = age + 1 WHERE age > 25;
```

### DELETE
Remove records from a table.

```sql
-- Delete single record
DELETE FROM users WHERE id = 1;

-- Delete multiple records
DELETE FROM users WHERE age < 18;
```

---

## 2. Filtering & Ordering

### WHERE Clause
Filter results based on conditions.

```sql
-- Comparison operators: =, !=, <, >, <=, >=
SELECT * FROM users WHERE age >= 25;

-- IN operator (match any value in list)
SELECT * FROM users WHERE name IN ('Alice', 'Bob', 'Charlie');

-- BETWEEN operator (range)
SELECT * FROM users WHERE age BETWEEN 25 AND 30;

-- LIKE operator (pattern matching)
SELECT * FROM users WHERE email LIKE 'alice%';  -- Starts with "alice"
SELECT * FROM users WHERE email LIKE '%@example.com';  -- Ends with "@example.com"
SELECT * FROM users WHERE email LIKE '%exa%';  -- Contains "exa"
```

### ORDER BY
Sort results.

```sql
-- Ascending (default)
SELECT * FROM users ORDER BY age;
SELECT * FROM users ORDER BY name ASC;

-- Descending
SELECT * FROM users ORDER BY age DESC;

-- Multiple columns
SELECT * FROM users ORDER BY age DESC, name ASC;
```

### LIMIT
Limit number of results.

```sql
-- Get first 5 records
SELECT * FROM users LIMIT 5;

-- Get first 5 records starting from offset 10
SELECT * FROM users LIMIT 10, 5;  -- MySQL syntax
SELECT * FROM users LIMIT 5 OFFSET 10;  -- PostgreSQL syntax
```

---

## 3. Aggregation Functions

Perform calculations on data.

```sql
-- COUNT: Number of rows
SELECT COUNT(*) FROM users;
SELECT COUNT(email) FROM users;  -- Count non-NULL values

-- SUM: Total of numeric column
SELECT SUM(age) FROM users;

-- AVG: Average of numeric column
SELECT AVG(age) FROM users;

-- MIN/MAX: Minimum and maximum values
SELECT MIN(age), MAX(age) FROM users;

-- With WHERE clause
SELECT COUNT(*) FROM users WHERE age > 25;
SELECT AVG(age) FROM users WHERE name LIKE '%a%';
```

---

## 4. GROUP BY & HAVING

Group data and perform aggregations on groups.

```sql
-- Group by single column
SELECT age, COUNT(*) as count FROM users GROUP BY age;

-- Group by multiple columns
SELECT age, name, COUNT(*) FROM users GROUP BY age, name;

-- HAVING: Filter groups (like WHERE but for aggregates)
SELECT age, COUNT(*) as count FROM users GROUP BY age HAVING COUNT(*) > 1;
SELECT age, AVG(age) FROM users GROUP BY age HAVING AVG(age) > 25;
```

---

## 5. JOINs (Combining Tables)

Retrieve data from multiple tables.

**Table Setup:**
```sql
-- Users table
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

-- Orders table
CREATE TABLE orders (
    id INT PRIMARY KEY,
    user_id INT,
    product VARCHAR(100),
    amount DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

### INNER JOIN
Returns records that match in both tables.

```sql
SELECT users.name, orders.product, orders.amount
FROM users
INNER JOIN orders ON users.id = orders.user_id;
```

### LEFT JOIN
Returns all records from left table + matching records from right table.

```sql
SELECT users.name, orders.product
FROM users
LEFT JOIN orders ON users.id = orders.user_id;
```

### RIGHT JOIN
Returns all records from right table + matching records from left table.

```sql
SELECT users.name, orders.product
FROM users
RIGHT JOIN orders ON users.id = orders.user_id;
```

### FULL OUTER JOIN
Returns all records from both tables.

```sql
SELECT users.name, orders.product
FROM users
FULL OUTER JOIN orders ON users.id = orders.user_id;
```

---

## 6. DISTINCT & NULL Handling

### DISTINCT
Remove duplicate rows.

```sql
SELECT DISTINCT age FROM users;
SELECT DISTINCT email FROM users;
```

### NULL Handling
Test for NULL values.

```sql
-- IS NULL
SELECT * FROM users WHERE email IS NULL;

-- IS NOT NULL
SELECT * FROM users WHERE email IS NOT NULL;

-- COALESCE: Replace NULL with default value
SELECT name, COALESCE(email, 'no-email') FROM users;
```

---

## 7. Subqueries

Query within a query.

```sql
-- Subquery in WHERE
SELECT * FROM users WHERE age > (SELECT AVG(age) FROM users);

-- Subquery in FROM
SELECT * FROM (SELECT name, age FROM users WHERE age > 25) AS young_users;

-- Subquery with IN
SELECT * FROM users WHERE id IN (SELECT user_id FROM orders);
```

---

## 8. String Functions

Manipulate text data.

```sql
-- UPPER/LOWER: Convert case
SELECT UPPER(name), LOWER(email) FROM users;

-- LENGTH: String length
SELECT name, LENGTH(name) as name_length FROM users;

-- SUBSTRING: Extract part of string
SELECT SUBSTRING(email, 1, 5) FROM users;

-- CONCAT: Combine strings
SELECT CONCAT(name, ' - ', email) FROM users;

-- REPLACE: Replace text
SELECT REPLACE(email, '@example.com', '@newdomain.com') FROM users;

-- TRIM: Remove leading/trailing spaces
SELECT TRIM(name) FROM users;
```

---

## 9. Date Functions

Work with dates.

```sql
-- Current date/time
SELECT CURDATE();      -- Today's date
SELECT CURTIME();      -- Current time
SELECT NOW();          -- Current date and time

-- Date arithmetic
SELECT DATE_ADD(CURDATE(), INTERVAL 7 DAY);   -- 7 days from now
SELECT DATE_SUB(CURDATE(), INTERVAL 1 MONTH); -- 1 month ago

-- Date extraction
SELECT YEAR(created_at), MONTH(created_at), DAY(created_at) FROM users;

-- Date difference
SELECT DATEDIFF(CURDATE(), created_at) FROM users;
```

---

## 10. UNION

Combine results from multiple queries.

```sql
-- Union: Removes duplicates
SELECT name FROM users
UNION
SELECT product FROM orders;

-- Union All: Keeps duplicates
SELECT name FROM users
UNION ALL
SELECT product FROM orders;
```

---

## 11. CREATE & DROP Tables

### CREATE TABLE

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT CHECK (age >= 18),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### DROP TABLE

```sql
-- Drop table
DROP TABLE students;

-- Drop if exists (won't error if table doesn't exist)
DROP TABLE IF EXISTS students;
```

---

## 12. Indexes & Performance

### CREATE INDEX
Speed up queries.

```sql
-- Single column index
CREATE INDEX idx_email ON users(email);

-- Multi-column index
CREATE INDEX idx_age_name ON users(age, name);

-- Unique index
CREATE UNIQUE INDEX idx_unique_email ON users(email);
```

### DROP INDEX

```sql
DROP INDEX idx_email ON users;
```

---

## Practice Queries

Write these queries against a sample database:

1. **Get all users and count their orders**
2. **Find the user who spent the most money**
3. **List all products ordered by users older than 30**
4. **Find users with no orders**
5. **Group orders by month and sum amounts**
6. **Find duplicate email addresses**
7. **Update all user emails to lowercase**
8. **Delete orders older than 1 year**
9. **Get top 5 most expensive orders with user details**
10. **Find average order amount per user**

---

## Key Takeaways
- **SELECT** retrieves data
- **WHERE** filters rows
- **JOIN** combines tables
- **GROUP BY** aggregates data
- **ORDER BY** sorts results
- **LIMIT** restricts output
- **INDEX** improves performance
- Always use **WHERE** to filter, not retrieve all data
