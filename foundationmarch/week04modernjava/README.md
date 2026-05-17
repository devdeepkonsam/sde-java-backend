# Week 4: Modern Java & SQL Basics - Complete README

**Phase**: Foundation (March)  
**Focus**: Java 8+ features, functional programming, database connectivity

---

## 📚 Topics Covered

### Core Java 8+ Features
1. **Lambdas & Functional Interfaces** - Write concise, functional code
2. **Stream API** - Process collections declaratively
3. **Optional<T>** - Eliminate null pointer exceptions
4. **Method References** - Shorthand for lambdas
5. **Exception Handling** - Robust error management
6. **Multithreading Basics** - Concurrent execution
7. **JDBC** - Connect Java to databases
8. **SQL Fundamentals** - Query and manipulate data

---

## 📂 File Structure

```
week04modernjava/
├── ModernJavaPlayground.java     # All Java 8+ examples (runnable)
├── JDBCExample.java              # Database connectivity examples
├── Learning.md                   # Comprehensive notes
├── SQL_Basics.md                 # SQL queries & fundamentals
├── README.md                     # Weekly plan (THIS FILE)
├── Test.java                     # Simple lambda examples
└── Learning.java                 # Original functional interface demo
```

---

## 🎯 Learning Path

### Day 1: Lambdas & Functional Interfaces
**Goal**: Understand lambdas as replacements for anonymous classes

**Learn**:
- What is a functional interface?
- Lambda syntax: `(params) -> body`
- Built-in interfaces: Predicate, Function, Consumer, Supplier

**Practice**:
- Run `ModernJavaPlayground.lambdaExamples()`
- Modify examples to create custom functional interfaces

---

### Day 2: Predicate, Function, Consumer, Supplier
**Goal**: Master built-in functional interfaces

**Learn**:
- `Predicate<T>`: Test a condition → boolean
- `Function<T, R>`: Transform input → output
- `Consumer<T>`: Perform action → void
- `Supplier<T>`: Generate/supply value → T

**Practice**:
- Run `ModernJavaPlayground.functionalInterfacesExamples()`
- Create your own predicates for filtering lists

---

### Day 3: Stream API
**Goal**: Process collections with streams

**Learn**:
- Intermediate operations: filter, map, sorted, distinct, limit, skip
- Terminal operations: collect, reduce, forEach, count, findFirst, anyMatch
- Collectors: toList, toSet, groupingBy, summarizing

**Practice**:
- Run `ModernJavaPlayground.streamAPIExamples()`
- Process the Student list to find top scorers, group by grade, calculate stats

---

### Day 4: Optional<T>
**Goal**: Safely handle null values

**Learn**:
- Create Optional: of(), empty(), ofNullable()
- Operations: isPresent(), get(), ifPresent(), ifPresentOrElse()
- Functional methods: map(), filter(), flatMap()
- Defaults: orElse(), orElseGet(), orElseThrow()

**Practice**:
- Run `ModernJavaPlayground.optionalExamples()`
- Replace null checks with Optional throughout code

---

### Day 5: Method References & Exception Handling
**Goal**: Simplify code with method references; handle errors properly

**Learn**:
- Static method reference: `ClassName::staticMethod`
- Instance method reference: `instance::method`
- Class method reference: `ClassName::instanceMethod`
- Constructor reference: `ClassName::new`
- Try-catch-finally, try-with-resources
- Custom exceptions

**Practice**:
- Run `ModernJavaPlayground.methodReferencesExamples()`
- Run `ModernJavaPlayground.exceptionHandlingExamples()`

---

### Day 6: Multithreading & JDBC
**Goal**: Execute tasks concurrently; connect to databases

**Learn**:
- Thread creation with Runnable
- Thread lifecycle: start(), join(), sleep()
- Synchronized methods & blocks
- JDBC setup: Connection, Statement, ResultSet
- PreparedStatement for security

**Practice**:
- Run `ModernJavaPlayground.multithreadingExamples()`
- Set up MySQL database and run `JDBCExample.java`

---

### Day 7: SQL Practice
**Goal**: Write SQL queries for common scenarios

**Learn** (from `SQL_Basics.md`):
- SELECT, INSERT, UPDATE, DELETE
- WHERE, ORDER BY, LIMIT
- Aggregation: COUNT, SUM, AVG, MIN, MAX
- GROUP BY & HAVING
- JOINs: INNER, LEFT, RIGHT, FULL OUTER
- Subqueries, UNION, DISTINCT

**Practice**:
- Write 10 SQL queries against sample data
- Examples from `SQL_Basics.md` - Practice Queries section

---

## 🚀 Quick Start

### Run All Examples
```bash
# Compile
javac ModernJavaPlayground.java

# Run
java ModernJavaPlayground
```

---

## ✅ Checklist: Mastery Criteria

- [ ] **Lambdas**: Can write lambda for any functional interface
- [ ] **Streams**: Can chain filter, map, collect operations
- [ ] **Optional**: Replace all null checks with Optional
- [ ] **Exception Handling**: Use try-with-resources properly
- [ ] **Multithreading**: Understand Thread.start() vs run()
- [ ] **JDBC**: Successfully connect to MySQL database
- [ ] **SQL**: Write SELECT, JOIN, GROUP BY, aggregation queries
- [ ] **Integration**: Combine Streams + Optional in real code

---

## 📖 Resources

- [Oracle Java 8 Docs](https://docs.oracle.com/javase/8/docs/)
- [Java Streams Tutorial](https://www.baeldung.com/java-streams)
- [JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/)
- [W3Schools SQL Reference](https://www.w3schools.com/sql/)

---

## 🎓 Next Steps

**After completing Week 4**, you're ready for:
- ✅ **Phase 2 (April)**: Spring Boot & REST APIs
- ✅ Building production-grade backend services
- ✅ Database integration with JPA/Hibernate

---

## 💡 Key Takeaways

| Topic | Key Insight |
|-------|------------|
| **Lambdas** | Replaces anonymous classes with concise syntax |
| **Streams** | Declarative data processing (vs imperative loops) |
| **Optional** | Safe null handling without `if (x != null)` checks |
| **Exceptions** | Use try-with-resources for auto-cleanup |
| **Threads** | Call `start()` not `run()` to create new thread |
| **JDBC** | Always use PreparedStatement to prevent SQL injection |
| **SQL** | Master SELECT, JOINs, and GROUP BY first |
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
