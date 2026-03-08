package dsasolutions.month1arrayspointers;

import java.util.HashSet;

public class ContainsDuplicate {
    void main(){
        int[] nums = {1,1};
        System.out.println(containsduplicate(nums));
    }


    //here we need to return true if duplicate element is present,false if 1 element for each
    //approach 
    //iternate through each number if the number is already present(dulplicate) in the hashmap/hashset return true
    //else put/add that number in the data.
    //after iteration if no duplicate was found return false.

    public boolean containsduplicate(int[] nums){
        // if (nums.length <= 1) {
        //     return true;
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 1;
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if (count>=2) {
        //         return true;
        //     }
        // }
        //
        // HashMap<Integer, Integer> count = new HashMap<>();
        // for(int num : nums){
        //     if(count.containsKey(num)){
        //         return true;
        //     }
        //     count.put(num, 1);
        // }
        // return false;

        //time complexity O(n) space complexity O(n)

        HashSet<Integer> duplicate = new HashSet<>();
        for(int number : nums){
            if (duplicate.contains(number)) {
                return true;
            }
            duplicate.add(number);
        }


        //optimal 
        HashSet<Integer> dup = new HashSet<>();
        for (int num : nums) {
            if (!dup.add(num)) {
                return true;
            }
        }
        return false;
    }
}
