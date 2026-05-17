# Modern Java 8+ Features - Complete Guide

## Topics Covered
1. **Lambdas & Functional Interfaces**
2. **Stream API**
3. **Optional<T>**
4. **Method References**
5. **Exception Handling**
6. **Multithreading Basics**
7. **JDBC & Database Connectivity**
8. **SQL Fundamentals**

---

## 1. LAMBDAS & FUNCTIONAL INTERFACES

### What is a Functional Interface?
- An interface with **exactly ONE abstract method**
- Can have multiple default/static methods
- Annotated with `@FunctionalInterface` (optional but recommended)

```java
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);  // Single abstract method
}
```

### Lambda Expression Syntax
Replaces anonymous inner classes with concise syntax.

```java
// Old way (Anonymous inner class)
Calculator add = new Calculator() {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
};

// New way (Lambda)
Calculator add = (a, b) -> a + b;
```

---

## 2. PREDICATE, FUNCTION, CONSUMER, SUPPLIER

Built-in functional interfaces in `java.util.function`.

### Predicate<T>
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream().filter(isEven).forEach(System.out::println);  // 2, 4
```

### Function<T, R>
```java
Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("Hello"));  // 5
```

### Consumer<T>
```java
Consumer<String> print = s -> System.out.println(s);
List<String> names = Arrays.asList("Alice", "Bob");
names.forEach(print);  // Alice, Bob
```

### Supplier<T>
```java
Supplier<String> randomName = () -> "Random Name";
System.out.println(randomName.get());
```

---

## 3. STREAM API

### Intermediate Operations (return Stream)
- **filter(Predicate)** - Keep elements matching condition
- **map(Function)** - Transform each element
- **sorted()** - Sort elements
- **limit(n)** - Keep first n elements
- **skip(n)** - Skip first n elements
- **distinct()** - Remove duplicates
- **flatMap(Function)** - Flatten nested streams

### Terminal Operations (trigger computation)
- **forEach(Consumer)** - Execute action for each element
- **collect(Collector)** - Gather results
- **reduce(BinaryOperator)** - Aggregate to single value
- **count()** - Count elements
- **findFirst()** - Get first element
- **anyMatch/allMatch/noneMatch(Predicate)** - Check condition

### Example
```java
List<Student> students = Arrays.asList(
    new Student("Alice", 85),
    new Student("Bob", 72),
    new Student("Charlie", 90)
);

// Get top scorers
List<String> topStudents = students.stream()
    .filter(s -> s.getScore() > 75)
    .map(Student::getName)
    .sorted()
    .collect(Collectors.toList());
```

---

## 4. OPTIONAL<T>

### Problem: Null Pointer Exceptions
```java
// Old way - always check for null
String name = getName();
if (name != null) {
    System.out.println(name.toUpperCase());
}
```

### Solution: Optional<T>
```java
Optional<String> name = Optional.of("Alice");
Optional<String> empty = Optional.empty();
Optional<String> nullable = Optional.ofNullable(getName());
```

### Operations
```java
Optional<String> name = Optional.of("Alice");

// Basic checks
name.ifPresent(n -> System.out.println(n));
String result = name.orElse("Unknown");

// Functional operations
Optional<Integer> length = name.map(String::length);
Optional<String> filtered = name.filter(n -> n.length() > 3);
```

---

## 5. METHOD REFERENCES

Shorthand syntax for lambdas that call a single method.

```java
// Static method reference
Function<String, Integer> parse = Integer::parseInt;

// Instance method reference
List<String> names = Arrays.asList("alice", "bob");
names.stream().map(String::toUpperCase).forEach(System.out::println);

// Constructor reference
Supplier<ArrayList> supplier = ArrayList::new;
```

---

## 6. EXCEPTION HANDLING

### Try-Catch-Finally
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Cleanup");
}
```

### Try-With-Resources (Auto-close)
```java
try (Scanner scanner = new Scanner("data.txt")) {
    while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
}  // Auto-closed
```

### Custom Exceptions
```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

---

## 7. MULTITHREADING

### Creating Threads with Runnable
```java
Thread thread = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        System.out.println("Count: " + i);
        Thread.sleep(1000);
    }
});
thread.start();  // Must call start(), not run()!
```

### Thread Synchronization
```java
class Counter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
}
```

---

## 8. JDBC & SQL

### Basic JDBC Steps
```java
String url = "jdbc:mysql://localhost:3306/mydb";
Connection conn = DriverManager.getConnection(url, user, password);

// INSERT with PreparedStatement
String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "Alice");
pstmt.setInt(2, 25);
pstmt.executeUpdate();

// SELECT
sql = "SELECT * FROM users WHERE age > ?";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, 20);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
```

### SQL Fundamentals
- **SELECT** - Retrieve data
- **INSERT** - Add data
- **UPDATE** - Modify data
- **DELETE** - Remove data
- **WHERE** - Filter rows
- **ORDER BY** - Sort results
- **GROUP BY** - Aggregate data
- **JOIN** - Combine tables

---

## Key Takeaways

✅ Lambdas simplify functional programming  
✅ Streams process data declaratively  
✅ Optional eliminates null checks  
✅ Method references shorten lambda code  
✅ Exception handling makes code robust  
✅ Multithreading enables concurrent tasks  
✅ JDBC connects Java to databases  
✅ SQL queries retrieve and manipulate data  

---

## Next Steps
Run all examples in `ModernJavaPlayground.java` and `JDBCExample.java`! 