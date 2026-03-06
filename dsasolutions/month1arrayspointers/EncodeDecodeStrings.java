package dsasolutions.month1arrayspointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Encode and Decode Strings (Medium) - LeetCode Premium
 * 
 * Design an algorithm to encode a list of strings to a single string,
 * and decode that single string back to the original list.
 * 
 * Approach: Length-based encoding with delimiter
 * - Encode: "length#string" format
 * - Example: ["hello","world"] → "5#hello5#world"
 * 
 * Time: O(n) for both encode and decode
 * Space: O(1) excluding output
 */
public class EncodeDecodeStrings {
    
    void main() {
        List<String> strs = List.of("hello", "world");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
    
    // Encode: Convert list of strings to single string
    public String encode(List<String> strs) {
        // TODO: Implement encoding
        // Format: "length#string" for each string
        return "";
    }
    
    // Decode: Convert single string back to list of strings
    public List<String> decode(String s) {
        // TODO: Implement decoding
        // Parse "length#string" format
        return new ArrayList<>();
    }
}
