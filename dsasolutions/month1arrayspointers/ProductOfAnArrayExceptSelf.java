package dsasolutions.month1arrayspointers;

import java.util.Arrays;

public class ProductOfAnArrayExceptSelf {
    void main(){
        int[] nums = {1,2,3,4};
        int[] ans = productExceptSelf(nums);
        int[] ans2 = productExceptSelf2(nums);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans2));
    }

    int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        //for prefix
        //set the prefix[0] 1 
        //and iterate from index 1:  prefix[i]  = nums[i-1] * prefix [i-1]
        //ex : {4,3,2,1}  
        //for prefix[1] = num[1-1] * prefix[1-1] : 4*1 = 4
        //for prefix[2] = num[2-1] * prefix[2-1] : 3*4 = 12  
        //for prefix[3] = num[3-1] * prefix[3-1] : 2*12 = 24
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i-1]*prefix[i-1];
            //suffix[nums.length-1-i] = nums[nums.length-i] * suffix [nums.length-i];
        }

        //for suffix
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        //product prefix and suffix
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }


    int[] productExceptSelf2(int[] nums){
        int[] ans = new int[nums.length];
        int prefix = 1; //set prefix 1
        for (int idx = 0; idx < nums.length; idx++) {
            ans[idx] = prefix; //set the prefix
            prefix *= nums[idx]; //prefix change to curr nums[] for next iteration preffix
        }

        int suffix = 1;
        for (int idx = nums.length-1; idx >= 0; idx--) {
            ans[idx] = suffix  * ans[idx]; //set the suffix and prefix product in ans
            suffix *= nums[idx];
        }
        return ans;
    }
}
