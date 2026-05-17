package CONTEST;

import java.util.*;

public class Test4{
    void main() {
        System.out.println(sortVowelsByFrequency("aeiaaioooa"));
        int[] input = {5,1,2,3};
        System.out.println(minOperations(input));
    }


    public List<Integer>  findValidElements(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==0 || i==nums.length-1){
                ans.add(nums[i]);
            }else{
                boolean left = true;
                boolean right = true;
                for(int j=0;j<i;j++){
                    if(nums[j]>=nums[i]){
                        left=false;
                        break;
                    }
                }
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]>=nums[i]){
                        right=false;
                        break;
                    }
                }
                if(left || right){
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }



    public String sortVowels(String s){
        String ans = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
            List<Character> list = new ArrayList<>(map.keySet());
            list.sort((a,b)->{
                if(map.get(a)==map.get(b)){
                    return s.indexOf(a)-s.indexOf(b);
                }else{
                    return map.get(b)-map.get(a);
                }
            });
            int index = 0;
            System.out.println(list);
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    ans+=list.get(index);
                    if(map.get(list.get(index))==1){
                        index++;
                    }else{
                        map.put(list.get(index),map.get(list.get(index))-1);
                    }
                }else{
                    ans += c;
                }
            }

        return ans;
    }


    public String sortVowelsByFrequency(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstOcc = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowelSet.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                firstOcc.putIfAbsent(c, i); 
            }
        }
        
        List<Character> foundVowels = new ArrayList<>(freq.keySet());
        
        foundVowels.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return Integer.compare(freq.get(b), freq.get(a));
            }
            return Integer.compare(firstOcc.get(a), firstOcc.get(b));
        });

        StringBuilder sortedVowels = new StringBuilder();
        for (char c : foundVowels) {
            int count = freq.get(c);
            for (int k = 0; k < count; k++) {
                sortedVowels.append(c);
            }
        }
        char[] result = s.toCharArray();
        int j = 0;
        for (int i = 0; i < result.length; i++) {
            if (vowelSet.contains(result[i])) {
                result[i] = sortedVowels.charAt(j++);
            }
        }
        
        return new String(result);
    }




    public long minOperations(int[] nums) {
        long totalOperations = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                totalOperations += (nums[i] - nums[i + 1]);
            }
        }
        
        return totalOperations;
    }

}



