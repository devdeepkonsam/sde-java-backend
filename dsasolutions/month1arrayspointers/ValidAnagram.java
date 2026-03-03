package dsasolutions.month1arrayspointers;

public class ValidAnagram {
    void main() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    //approach
    //count[26] store alphabetically 0-a 1-b
    //iterate through each element in string s, increment for alphabet present in count
    //iterate through each element in string t, decrement for alphabet present in count
    //if the count contain 0 in all index meaning anagram if not meaning there are some mixmatch word
    //bruteforce approach 
    //Time Complexity O(n)
    //Space O(1)

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        int index;
        for(int i = 0; i<s.length();i++){
            index = s.charAt(i)-'a';
            count[index] += 1;
        }

        for(int i = 0; i<t.length();i++){
            index = t.charAt(i)-'a';
            count[index] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;   
    }
}
