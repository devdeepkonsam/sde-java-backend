package dsasolutions.month2stacklinkedlists;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String t1 = "()[]{}";
        String t2 = "(]";
        String t3 = "([])";
        String t4 = "([)]";


        System.out.println("Test 1: " + isValid(t1));
        System.out.println("Test 2: " + isValid(t2));
        System.out.println("Test 3: " + isValid(t3));
        System.out.println("Test 4: " + isValid(t4));
    }

    //bruteforce approach not efficient but works
    /* first check the current element and next element is same bracket  or not
        if yes move +2 if index is in limit if not then its true
        second if same bracket is not present current element push to stack and move +1 
        now if current and next is same move +2 
        if current element is close one check whether the top most in stack is open for it if yes +1 
        atlast if stack is empty then true or else false 
     */

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> s1 = new Stack<>();
        HashMap<Character,Character> bracketOC = new HashMap<>();
        bracketOC.put(']', '[');
        bracketOC.put('}', '{');
        bracketOC.put(')', '('); 
        for (Character character : s.toCharArray()) {
            if ( character == '[' || character == '{' || character == '(') {
                s1.push(character);
            } else {
                if (s1.isEmpty()) {
                    return false;
                }
                char c = bracketOC.get(character);
                if (c != s1.pop()) {
                    return false;
                }
            }
        }

        return s1.isEmpty();
    }
}