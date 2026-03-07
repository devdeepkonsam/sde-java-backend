package dsasolutions.month1arrayspointers;

import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    void main() {
        int[] nums = {100,4,101,103,1,3,2,104,102};
        int lcs = longestConsecutiveseQuence(nums);
        IO.println(lcs);
    }


    @SuppressWarnings("unused")
    // this approach takes O(n log n ) althrough this gives answer but we need optimal one
    int longestConsecutiveSequence(int[] nums){
        int ans = 0;
        int temp = 0;
        TreeSet<Integer> sortedList = new TreeSet<>();
        for (int num : nums) {
            sortedList.add(num);
        }

        for(Integer num: sortedList){
            if (sortedList.contains(num+1)) {
                temp++;
            } else {
                temp++;
                ans = Math.max(ans, temp);
                temp = 0;
            }
        }

        return ans;
    }

    //approach 
    int longestConsecutiveseQuence(int[] nums){
        int maxLength = 0;
        HashSet<Integer> list = new HashSet<>();
        for (int num : nums) {
            list.add(num);
        }

        for (Integer integer : list) {
            if (!list.contains(integer-1)) {
                int currNum = integer;
                int consecutive = 1;

                while(list.contains(currNum+1)){
                    currNum++;
                    consecutive++;
                }
                maxLength = Math.max(consecutive, maxLength);
            }
        }
        return maxLength;
    }
}
