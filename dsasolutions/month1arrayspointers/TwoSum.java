package dsasolutions.month1arrayspointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    void main(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));

    }

    public int[] twoSum(int[] nums, int target) {
        //apprach bruteforce time complexity O(n*n) and space complexity O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i]+nums[j]==target) {
        //             return new int[]{i,j};
        //         }
        //     }
        // }

        //approach find the complement of the current number if it is present then return the complement index and current index 
        //if not then put the current index in hashmap and move to next element
        //time complexity O(n), Space O(n)

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i]; //find the complement for current
            if (map.containsKey(complement)) { //if it contain then return the current index and index of complement one
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i); //if not present put the current number 
        }

        return new int[]{};

    }
}
