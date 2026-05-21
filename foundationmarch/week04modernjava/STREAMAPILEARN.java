package foundationmarch.week04modernjava;

import java.util.*;

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

        //Reduct to sum
        int sum = numbers.stream()
        .reduce(0 , (x,y) -> x+y );
        System.out.println("Sum: "+sum);
    }
}
