package foundationmarch.week04modernjava;

import java.util.*;
import java.util.stream.Collectors;

//StreamAPI, Optional, Method References, and Custom Functional Interface Examples
public class Learning2 {
    
    public static void main(String[] args){
        streamApiLearn();
        optionalAndMethodRefExamples();
        Learning2 obj = new Learning2();
        obj.applyMultifu();
    }

    static void streamApiLearn(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Original Number: "+numbers);

        //Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
        .filter((x)-> x%2==0)
        .toList();
        System.out.println("Even Number: "+evenNumbers);

        //Print even numbers
        numbers.stream()
        .filter(x -> x%2==0)
        .forEach( x -> System.out.println(x));

        //Map to square
        List<Integer> squares = numbers.stream()
        .map(x -> x*x)
        .toList();
        System.out.println("Square: "+squares);

        //Reduce to sum
        int sum = numbers.stream()
        .reduce(0 , (x,y) -> x+y );
        System.out.println("Sum: "+sum);

        //collect to set
        Set<Integer> numberSet = numbers.stream()
        .filter(x -> x%2!= 0)
        .collect(Collectors.toSet());
        System.out.println("Number Set of Odds: "+numberSet);

        //collect to map (with merge function to avoid duplicate-key errors)
        Map<Integer, Integer> numberMap = numbers.stream()
        .filter(x -> x%2 ==0)
        .collect(Collectors.toMap(x -> x, x -> x * x, (existing, replacement) -> existing));

        System.out.println("Number Map of Evens: "+numberMap);

        //flatMap example
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6),
            Arrays.asList(6,7,8)
        );
        List<Integer> flatList = listOfLists.stream()
        .flatMap(x -> x.stream())
        .toList();
        System.out.println("Flat List: "+flatList);

        //distinct example
        List<Integer> distinctNumbers = flatList.stream()
        .distinct()
        .toList();
        System.out.println("Distinct Numbers: "+distinctNumbers);

        //sorted example 
        List<Integer> unsortedNumbers = Arrays.asList(2,6,1,9,4,3);
        List<Integer> sortedNumbers = unsortedNumbers.stream()
        .sorted().toList();
        System.out.println("Sorted Numbers: "+sortedNumbers);

        int[] arr = unsortedNumbers.stream().mapToInt(x -> x).toArray();
        System.out.println("Array: "+Arrays.toString(arr));

        // Parallel stream examples
        System.out.println();
        System.out.println("--- Parallel Stream Examples ---");

        // 1) Parallel reduce (sum) - order of execution may vary but result is same
        int parallelSum = numbers.parallelStream()
            .reduce(0, (x,y) -> x+y);
        System.out.println("Parallel Sum: " + parallelSum);

        // 2) Demonstrate ordering: forEach may be unordered, forEachOrdered preserves encounter order
        System.out.println("Parallel forEach (may be unordered):");
        numbers.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("Parallel forEachOrdered (preserves order):");
        numbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();


        //anyMatch example
        boolean hasEven = numbers.stream()
        .anyMatch(x -> x%2 ==0);
        System.out.println("Has Even: "+hasEven);

        //allMatch example 
        boolean allEven = numbers.stream()
        .allMatch(x -> x%2==0);
        System.out.println("All Even: "+allEven);

        //min and max example depends on the comparator
        Optional<Integer> min = numbers.stream()
        .min((x,y) -> x-y); // can use the same as Integer::compareTo or (x,y) -> Integer.compare(x,y)
        Optional<Integer> max = numbers.stream()
        .max(Integer::compareTo); 
        System.out.println("Min: "+min.orElse(null));
        System.out.println("Max: "+max.orElse(null));

        //count example
        long count = numbers.stream()
        .filter(x -> x >= 5)
        .count();
        System.out.println("Count of numbers greater than 5 or equal to: "+count);

        //findFirst and findAny 
        Optional<Integer> firstEven = numbers.stream()
        .filter(x -> x%2 == 0)
        .findFirst();
        Optional<Integer> anyEven = numbers.stream()
        .filter(x -> x%2 == 0)
        .findAny();
        System.out.println("First Even: "+firstEven.orElse(null));
        System.out.println("Any Even: "+anyEven.orElse(null));

        //groupingBy and partitioningBy example
        Map<String, List<Integer>> groupedByEvenOdd = numbers.stream()
        .collect(Collectors.groupingBy(x -> x%2 == 0 ? "Even" : "Odd"));
        Map<Boolean, List<Integer>> partitionedByEven = numbers.stream() //only two groups true and false
        .collect(Collectors.partitioningBy(x -> x%2 == 0));
        System.out.println("Grouped by Even and Odd: "+groupedByEvenOdd);
        System.out.println("Partitioned by Even: "+partitionedByEven);

    }

    static void optionalAndMethodRefExamples(){
        System.out.println();
        System.out.println("--- Optional & Method References Examples ---");

        // Example 1: Safe uppercase from nullable string
        String maybeName = null; // try with null and with "devdeep"
        String upper = Optional.ofNullable(maybeName)
            .map(String::toUpperCase)
            .orElse("UNKNOWN");
        System.out.println("Uppercase result: " + upper);

        // Example 2: Parse config value safely
        Map<String,String> config = Map.of("timeout", " 30 ", "retries", "3");
        int timeout = Optional.ofNullable(config.get("timeout"))
            .map(String::trim)
            .map(Integer::parseInt)
            .filter(t -> t > 0)
            .orElse(60);
        System.out.println("Parsed timeout: " + timeout);

        // Example 3: Replace lambdas with method references
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        int sumWithMethodRef = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum using Integer::sum: " + sumWithMethodRef);

        System.out.println("Print with method reference (System.out::println):");
        nums.stream().map(n -> n * n).forEach(System.out::println);


        int[] primitive = nums.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Primitive array: " + Arrays.toString(primitive));
    } 

    
    @FunctionalInterface
    interface MultiFunction<A,B,C,D,R>{
        R apply(A a, B b, C c, D d);
    }
    class Student{
        int id;
        String name;
        int score;
        String grade;

        Student(int id, String name, int score, String grade) {
            this.id = id;
            this.name = name;
            this.score = score;
            this.grade = grade;
        }
        
        void display(){
            System.out.printf("ID: %d, Name: %s, Score: %d, Grade: %s\n", id, name, score, grade);
        }
    }
    void applyMultifu() {
        MultiFunction<Integer,String,Integer,String,Student> createStudent = Student::new;
        Student s1 = createStudent.apply(12, "LOGAN", 40, "D");
        s1.display();
    }
}





