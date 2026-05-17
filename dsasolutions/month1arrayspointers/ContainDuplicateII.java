package dsasolutions.month1arrayspointers;

import java.util.HashSet;

public class ContainDuplicateII {
    void main() {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsDuplicate(nums, k));
    }

    boolean containsDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j) <= k) {
                    return true;
                }
            }
        }
        ///time complexity O(n*n) space complexity O(1)




        if (k <= 0) {
            return false;
        }

        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Keep only last k elements in the window.
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
