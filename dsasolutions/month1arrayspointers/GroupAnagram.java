package dsasolutions.month1arrayspointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    void main(){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>(); //create a hashmap k:sortedString v:List of anagrams
        for (String s : strs) { //iterate through each string in strs
            char[] ch = s.toCharArray(); //convert str to char array
            Arrays.sort(ch); //sort the char array
            String sortedString = new String(ch); //make a sortedString 
            if (!map.containsKey(sortedString)) { //if sortedString<key> is not present create a list for it
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(s); //add the original strings to the Arraylist created for each sortedString
        }
        return new ArrayList<>(map.values());
    }
}


//List
//1:first find whether the string is present in that hashamp if not
//2:add the str in the list then find its anagram if present add in that list ,add the strings to the hasmap,if not add those list inside the outer list :
//3:then iternate move to next if present move to next if not do the step 2 again until u reach end of strings