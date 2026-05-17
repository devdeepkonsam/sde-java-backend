package CONTEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test{
    public static void main(String[] args) {
    Test t = new Test();

    int[] a1 = {1, 2, 3, 4};
    int[] a2 = {4, 5, 6, 7};
    int[] a3 = {2, 2, 2, 2};

    System.out.println("Input [1,2,3,4] -> Operations: " + t.minOperations(a1.clone()) + " (expected 3)");
    System.out.println("Input [4,5,6,7] -> Operations: " + t.minOperations(a2.clone()) + " (expected 4)");
    System.out.println("Input [2,2,2,2] -> Operations: " + t.minOperations(a3.clone()) + " (expected 4)");
    }


    String trafficLight(int timer){
        if(timer == 0){
            return "Green";
        } else if(timer == 30){
            return "orange";
        } else if(timer > 30 && timer <=90){
            return "Red";
        } else {
            return "invalid";
        }
    }

    int countDigitsOccurrences(int[] nums, int digit){
        int count=0;
        for(int num: nums){
            String numStr = Integer.toString(num);
            for(char c : numStr.toCharArray()){
                if(Character.getNumericValue(c) == digit){
                    count++;
                }
            }
        }
        return digit;
    }

    //minimum operation to transform array into alternating prime 
    //even index should be prime and odd index should be non prime
    //operation is increment of 1 to any element
    //return minimum operation to transform array into alternating prime
    //[1,2,3,4]   = [2,4,3,4] so 3 operation needed 
    int minOperations(int[] nums){
        int operation = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                while(!isPrime(nums[i])){
                    nums[i]++;
                    operation++;
                }
            } else {
                while(isPrime(nums[i])){
                    nums[i]++;
                    operation++;
                }
            }
        }
        return operation;
    }
    boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }





    static final int MOD = 1_000_000_007;

    int maxValue1(int[] num1, int[] num0) {
        int n = num1.length;

        List<String> segments = new ArrayList<>();

        // Step 1: Build segments (1s followed by 0s)
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < num1[i]; j++) sb.append('1');
            for (int j = 0; j < num0[i]; j++) sb.append('0');

            segments.add(sb.toString());
        }

        // Step 2: Sort to maximize concatenation value
        Collections.sort(segments, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Build final binary number with modulo
        long result = 0;

        for (String s : segments) {
            for (char c : s.toCharArray()) {
                result = (result * 2 + (c - '0')) % MOD;
            }
        }

        return (int) result;
    }
}
