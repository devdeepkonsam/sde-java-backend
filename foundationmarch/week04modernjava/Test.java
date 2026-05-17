package foundationmarch.week04modernjava;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Test file for Modern Java 8+ features
 * Quick examples and experiments
 */
public class Test {

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String toString() {
            return name + " (" + score + ")";
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== MODERN JAVA QUICK TESTS =====\n");

        // Test 1: Lambdas
        System.out.println("1. LAMBDAS:");
        Learning learning = (name) -> System.out.println("Learning: " + name);
        learning.display("Java");

        Learning learning1 = (name) -> System.out.println("Lambda: " + name);
        learning1.display("Java 8+");

        // Test 2: Function Interface
        System.out.println("\n2. CALCULATOR:");
        numTwo add = (a, b) -> a + b;
        numTwo subtract = (a, b) -> a - b;
        System.out.println("10 + 5 = " + add.cal(10, 5));
        System.out.println("10 - 5 = " + subtract.cal(10, 5));

        // Test 3: Streams & Filtering
        System.out.println("\n3. STREAM FILTERING:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);

        // Test 4: Stream Mapping
        System.out.println("\n4. STREAM MAPPING:");
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared: " + squared);

        // Test 5: Stream Reduction
        System.out.println("\n5. STREAM REDUCTION:");
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);

        // Test 6: Student Stream Operations
        System.out.println("\n6. STUDENT OPERATIONS:");
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 72),
                new Student("Charlie", 90),
                new Student("Diana", 65),
                new Student("Eve", 78)
        );

        // Top scorers
        System.out.println("Top 3 scorers:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .limit(3)
                .forEach(s -> System.out.println("  - " + s));

        // Passed students (score >= 70)
        System.out.println("Passed students:");
        students.stream()
                .filter(s -> s.getScore() >= 70)
                .map(s -> s.name)
                .forEach(name -> System.out.println("  - " + name));

        // Test 7: Optional
        System.out.println("\n7. OPTIONAL:");
        Optional<String> name = Optional.of("Alice");
        name.ifPresent(n -> System.out.println("Name found: " + n));

        Optional<String> empty = Optional.empty();
        String result = empty.orElse("Default");
        System.out.println("Empty optional result: " + result);

        // Test 8: Method References
        System.out.println("\n8. METHOD REFERENCES:");
        List<String> words = Arrays.asList("hello", "world", "java");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Test 9: Exception Handling
        System.out.println("\n9. EXCEPTION HANDLING:");
        try {
            int result1 = divideNumbers(10, 2);
            System.out.println("10 / 2 = " + result1);
            
            int result2 = divideNumbers(10, 0);  // Will throw
            System.out.println("10 / 0 = " + result2);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Exception handling complete");
        }

        // Test 10: Predicate & Consumer
        System.out.println("\n10. PREDICATE & CONSUMER:");
        Predicate<Integer> isPositive = n -> n > 0;
        Consumer<Integer> printIfPositive = n -> {
            if (isPositive.test(n)) {
                System.out.println("  Positive: " + n);
            }
        };
        Arrays.asList(-1, 5, 0, 10, -3).forEach(printIfPositive);

        System.out.println("\n===== TESTS COMPLETED =====");
    }

    static int divideNumbers(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

// Functional Interface
@FunctionalInterface
interface numTwo {
    int cal(int a, int b);
}

