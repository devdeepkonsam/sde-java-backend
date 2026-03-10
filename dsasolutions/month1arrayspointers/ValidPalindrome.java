package dsasolutions.month1arrayspointers;

public class ValidPalindrome {
    void main(){
        // Test cases
        System.out.println("Test 1: " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Test 2: " + isPalindrome("race a car"));
        System.out.println("Test 3: " + isPalindrome(" "));
        System.out.println("Test 4: " + isPalindrome("0P"));
        System.out.println("Test 5: " + isPalindrome("a1b2c2b1a"));
    }

    boolean isPalindrome(String s) {
        //s = s.toLowerCase();
        //use two opposite pointer
        int strIdx = 0; 
        int endIdx = s.length()-1;

        while (strIdx <= endIdx) {//run the loop until startindex is =< endindex
            //skip if a non-alphanumeric character is found
            if (!Character.isLetterOrDigit(s.charAt(strIdx))) { //in-built Character method to check validalphanumeric
                strIdx++;
            } else if (!Character.isLetterOrDigit(s.charAt(endIdx))) {
                endIdx--;
            } else {
                if (Character.toLowerCase(s.charAt(strIdx)) != Character.toLowerCase(s.charAt(endIdx))) {
                    return false;  
                }
                //if both Character are same then move the pointer
                strIdx++; 
                endIdx--;
            }
        }
        return true;
    }
}
