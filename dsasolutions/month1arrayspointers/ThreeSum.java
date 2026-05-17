package dsasolutions.month1arrayspointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    void main() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }


    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { //skip the duplicate element
                continue;
            }
            int strIdx = i+1;
            int endIdx = nums.length-1;

            while (strIdx < endIdx) {
                int sum = nums[i]+nums[strIdx]+nums[endIdx];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[strIdx],nums[endIdx]));
                    strIdx++;
                    endIdx--;

                    while (strIdx < endIdx && nums[strIdx] == nums[strIdx-1]) { //skip the duplicate element
                        strIdx++;
                    }
                    while (strIdx < endIdx && nums[endIdx] == nums[endIdx+1]) { //skip the duplicate element
                        endIdx--;
                    }
                } else if (sum > 0) {
                    endIdx--;
                } else {
                    strIdx++;
                }
            }
        }
        return ans;
    }
}