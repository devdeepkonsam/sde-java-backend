# Week 4: Modern Java & SQL Basics

**Dates**: May 1 - May 30, 2026

## Learning Goals
- Use Lambda expressions and functional interfaces
- Write clean Stream API pipelines
- Handle null safety with Optional
- Understand checked vs unchecked exceptions
- Learn basics of multithreading and concurrency
- Connect Java to a database with JDBC

---

## Week Plan

### Day 1: Lambdas + Functional Interfaces
- Write `ModernJavaPlayground.java`
- Practice `Predicate`, `Function`, and `Consumer`

### Day 2: Stream API
- Map, filter, sort, collect
- Solve small list-processing tasks

### Day 3: Optional + Exception Handling
- Replace manual null checks with `Optional`
- Handle exceptions using `try/catch/finally` and custom exceptions

### Day 4: Multithreading Basics
- `Runnable`, `Thread`, and synchronization basics
- Understand race conditions

### Day 5: Concurrency + JDBC Intro
- `ExecutorService` and task submission
- JDBC connection, query, and result mapping

### Day 6: SQL Basics Practice
- SELECT, WHERE, ORDER BY, GROUP BY, JOIN
- Write 10 basic SQL queries

### Day 7: Revision + Mini Task
- Combine Streams + Optional + exception handling
- Write reflection notes

---

## Java Practice Tasks (This Week)
1. Build a student score processor with streams (avg, top scorer, failed list)
2. Build safe parser utility using `Optional`
3. Create a tiny multi-threaded counter demo
4. Write a JDBC program to fetch users from a table

---

## Starter Run Command
From repo root:

```bash
javac foundationmarch/week04modernjava/ModernJavaPlayground.java
java -cp foundationmarch/week04modernjava ModernJavaPlayground
```

---

## Reflection Questions
1. Why are Streams often cleaner than loops?
2. When should you avoid `Optional`?
3. What problems does `ExecutorService` solve compared to raw `Thread`?
