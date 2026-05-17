package foundationmarch.week04modernjava;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.io.PrintStream;

/**
 * Modern Java 8+ Features Playground
 * Topics: Lambdas, Streams, Optional, Functional Interfaces, Exception Handling
 */
public class ModernJavaPlayground {

    // === 1. FUNCTIONAL INTERFACES & LAMBDAS ===
    @FunctionalInterface
    interface Greeting {
        void greet(String name);
    }

    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    @FunctionalInterface
    interface Transformer {
        String transform(String input);
    }

    // === 2. STUDENT CLASS FOR EXAMPLES ===
    static class Student {
        String name;
        int score;
        String grade;

        Student(String name, int score, String grade) {
            this.name = name;
            this.score = score;
            this.grade = grade;
        }

        public String toString() {
            return String.format("%s (Score: %d, Grade: %s)", name, score, grade);
        }

        public int getScore() { return score; }
        public String getName() { return name; }
        public String getGrade() { return grade; }
    }

    public static void main(String[] args) {
        System.out.println("===== MODERN JAVA 8+ FEATURES =====\n");

        // 1. Lambda Expressions
        System.out.println("1. LAMBDA EXPRESSIONS & FUNCTIONAL INTERFACES");
        lambdaExamples();

        System.out.println("\n2. PREDICATE, FUNCTION, CONSUMER, SUPPLIER");
        functionalInterfacesExamples();

        System.out.println("\n3. STREAM API");
        streamAPIExamples();

        System.out.println("\n4. OPTIONAL<T>");
        optionalExamples();

        System.out.println("\n5. EXCEPTION HANDLING");
        exceptionHandlingExamples();

        System.out.println("\n6. METHOD REFERENCES");
        methodReferencesExamples();

        System.out.println("\n7. MULTITHREADING BASICS");
        multithreadingExamples();
    }

    // ===== 1. LAMBDA EXPRESSIONS =====
    static void lambdaExamples() {
        // Example 1: Simple lambda with functional interface
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");
        greeting.greet("Alice");

        // Example 2: Lambda for calculation
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 * 5 = " + multiply.calculate(10, 5));

        // Example 3: Multi-line lambda
        Transformer transformer = (input) -> {
            String trimmed = input.trim();
            String uppercase = trimmed.toUpperCase();
            return uppercase.replace(" ", "_");
        };
        System.out.println("Transformed: " + transformer.transform("  hello world  "));

        // Example 4: Anonymous inner class vs Lambda (OLD vs NEW)
        System.out.println("\nOld way (Anonymous inner class):");
        Greeting oldWay = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("  Welcome, " + name);
            }
        };
        oldWay.greet("Bob");

        System.out.println("New way (Lambda):");
        Greeting newWay = name -> System.out.println("  Welcome, " + name);
        newWay.greet("Bob");
    }

    // ===== 2. PREDICATE, FUNCTION, CONSUMER, SUPPLIER =====
    static void functionalInterfacesExamples() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Predicate: boolean test(T t)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Even numbers: " + numbers.stream().filter(isEven).collect(Collectors.toList()));

        // Function: R apply(T t)
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Squares: " + numbers.stream().map(square).collect(Collectors.toList()));

        // Consumer: void accept(T t)
        Consumer<Integer> printWithPrefix = n -> System.out.print("Num: " + n + " | ");
        System.out.print("Consuming: ");
        numbers.forEach(printWithPrefix);
        System.out.println();

        // Supplier: T get()
        Supplier<String> randomGreeting = () -> {
            String[] greetings = {"Hi", "Hello", "Hey"};
            return greetings[new Random().nextInt(3)];
        };
        System.out.println("Random greeting: " + randomGreeting.get());
    }

    // ===== 3. STREAM API =====
    static void streamAPIExamples() {
        List<Student> students = Arrays.asList(
                new Student("Alice", 85, "A"),
                new Student("Bob", 72, "B"),
                new Student("Charlie", 90, "A"),
                new Student("Diana", 65, "C"),
                new Student("Eve", 78, "B"),
                new Student("Frank", 55, "F")
        );

        // Stream 1: Filter + Map + Collect
        System.out.println("Students with score > 70:");
        students.stream()
                .filter(s -> s.getScore() > 70)
                .map(Student::getName)
                .forEach(name -> System.out.println("  - " + name));

        // Stream 2: Sorted
        System.out.println("\nTop 3 scorers:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .limit(3)
                .forEach(s -> System.out.println("  - " + s));

        // Stream 3: Reduce (aggregate)
        int totalScore = students.stream()
                .map(Student::getScore)
                .reduce(0, Integer::sum);
        double avgScore = (double) totalScore / students.size();
        System.out.println("Total score: " + totalScore + ", Avg: " + String.format("%.2f", avgScore));

        // Stream 4: Group by
        Map<String, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("Grouped by grade: " + byGrade);

        // Stream 5: Count, anyMatch, allMatch, noneMatch
        long passCount = students.stream().filter(s -> s.getScore() >= 60).count();
        boolean hasTopper = students.stream().anyMatch(s -> s.getScore() >= 90);
        boolean allPassed = students.stream().allMatch(s -> s.getScore() >= 60);
        System.out.println("Pass count: " + passCount + ", Has topper: " + hasTopper + ", All passed: " + allPassed);
    }

    // ===== 4. OPTIONAL<T> =====
    static void optionalExamples() {
        // Optional: Safe null handling
        Optional<String> name = Optional.of("Alice");
        Optional<String> empty = Optional.empty();

        // isPresent() and get()
        if (name.isPresent()) {
            System.out.println("Name is present: " + name.get());
        }

        // ifPresentOrElse()
        name.ifPresentOrElse(
                n -> System.out.println("Found: " + n),
                () -> System.out.println("Name not found")
        );

        empty.ifPresentOrElse(
                n -> System.out.println("Found: " + n),
                () -> System.out.println("Name not found (empty)")
        );

        // orElse() and orElseGet()
        String result1 = empty.orElse("Default Name");
        String result2 = empty.orElseGet(() -> "Generated Default");
        System.out.println("Empty with orElse: " + result1);
        System.out.println("Empty with orElseGet: " + result2);

        // map() and flatMap()
        Optional<Integer> age = Optional.of(25);
        Optional<Integer> doubled = age.map(a -> a * 2);
        System.out.println("Age doubled: " + doubled.get());

        // filter()
        Optional<Integer> filtered = age.filter(a -> a > 20);
        System.out.println("Age > 20: " + filtered.isPresent());
    }

    // ===== 5. EXCEPTION HANDLING =====
    static void exceptionHandlingExamples() {
        // Try-Catch-Finally
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        System.out.println();

        // Try-Catch with multiple exceptions
        try {
            String str = null;
            int len = str.length(); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general Exception: " + e.getMessage());
        }

        System.out.println();

        // Try-with-resources (auto-close)
        try (Scanner scanner = new Scanner("Line1\nLine2")) {
            while (scanner.hasNextLine()) {
                System.out.println("Read: " + scanner.nextLine());
            }
        } // Auto-closed
    }

    static int divideNumbers(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // ===== 6. METHOD REFERENCES =====
    static void methodReferencesExamples() {
        List<String> words = Arrays.asList("hello", "world", "java", "streams");

        // Method reference: Class::staticMethod
        System.out.println("Using String::valueOf (static method reference):");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Method reference: instance::method
        System.out.println("Using instance::method:");
        PrintStream out = System.out;
        words.stream().forEach(out::println);

        // Method reference: Class::instanceMethod
        System.out.println("Using Comparator.comparing (instance method reference):");
        List<Student> students = Arrays.asList(
                new Student("Alice", 85, "A"),
                new Student("Bob", 72, "B"),
                new Student("Charlie", 90, "A")
        );
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);

        // Method reference: Class::new (constructor reference)
        System.out.println("Using Constructor reference:");
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        // Can be used with Function: Function<Integer, String> f = String::valueOf;
    }

    // ===== 7. MULTITHREADING BASICS =====
    static void multithreadingExamples() {
        // Thread 1: Using Runnable (Recommended)
        System.out.println("Starting threads...");
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1 - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("  Thread 2 - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads completed");
    }
}
