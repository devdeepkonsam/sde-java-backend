package dsasolutions.month1arrayspointers;

import java.util.Arrays;

public class TwoSumII {
    void main() {
        // Test case 1: Basic case
        int[] nums1 = {2,7,11,15}; 
        System.out.println("Test 1: " + Arrays.toString(twoSum(nums1, 9)));
        
        // Test case 2: Different pair
        int[] nums2 = {2,3,4};
        System.out.println("Test 2: " + Arrays.toString(twoSum(nums2, 6)));
        
        // Test case 3: Negative numbers
        int[] nums3 = {-1,0};
        System.out.println("Test 3: " + Arrays.toString(twoSum(nums3, -1)));
        
        // Test case 4: Larger array
        int[] nums4 = {1,2,3,4,5,6,7,8};
        System.out.println("Test 4: " + Arrays.toString(twoSum(nums4, 15)));
    }


    int[] twoSum(int[] nums, int target){
        //int[] ans = new int[2];
        int strIdx = 0;
        int endIdx = nums.length-1;

        while (strIdx < endIdx) {
            if (nums[strIdx]+nums[endIdx] == target) { //return index if valid two sum
                //ans[0] = strIdx;
                //ans[1] = endIdx;
                //return ans;
                return new int[]{strIdx+1,endIdx+1};
            } else if (nums[strIdx]+nums[endIdx] > target) { //if sum is higher than target decrement the endIdx
                endIdx--;
            } else {
                strIdx++; //increment strIdx if sum is less than target
            }
        }
        return new int[]{};
    }
}
