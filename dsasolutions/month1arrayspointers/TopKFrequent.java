package dsasolutions.month1arrayspointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {
    void main(){
        int[] num = {1,2,1,2,1,3,1};
        int k = 2;
        int[] ans = topKFrequent(num, k);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    @SuppressWarnings("unchecked")
    int[] topKFrequent(int[] nums, int k){
        //Approach time: O(n log n) Space O(n)
        //iternate through each number 
        //if not present put it default 0 if present get the value and add 1
        // add all the keys inside the list
        //comparator : (a,b) -> if value of the comparison is positive meaning b is high and it will go front else vice versa
        // add all the keys inside the list
        //now add the top k frequent number
        int[] ans = new int[k];
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n,count.getOrDefault(n, 0)+1); 
        }
        List<Integer> sortedList = new ArrayList<>(count.keySet()); 
        sortedList.sort((a,b)-> count.get(b)- count.get(a)); 
        for (int i = 0; i < k; i++) { 
            ans[i] = sortedList.get(i); 
        }



        //Approach bucket sorting
        //Create a Hashmap with key and their frequency
        //Create a arrayList of bucket each indices representing frequency 
        //add the key in their respective frequency
        //iterate from the back and add k number of element to the ans array
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key: count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq]==null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int index = 0;
        for(int i = bucket.length-1; i>=0  ;i--){
            if (bucket[i]!=null) {
                for (int number : bucket[i]) {
                    ans[index++] = number;
                    if (index == k) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
    
}
