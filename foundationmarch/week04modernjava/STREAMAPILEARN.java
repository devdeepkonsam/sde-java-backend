package foundationmarch.week04modernjava;

import java.util.*;
import java.util.stream.Collectors;

public class STREAMAPILEARN {
    public static void main(String[] args){
        streamApiLearn();
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
}
