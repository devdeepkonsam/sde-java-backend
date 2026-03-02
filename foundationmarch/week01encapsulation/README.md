# Week 1: Encapsulation & Arrays/Hashing

**Dates**: March 3-9, 2026

## Learning Goals
- ✅ Understand the principle of encapsulation
- ✅ Master array and hash table algorithms
- ✅ Learn JVM memory architecture

---

## DSA Problems (Arrays & Hashing)

### Problem List
1. [ ] [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
2. [ ] [Valid Anagram](https://leetcode.com/problems/valid-anagram/)
3. [ ] [Two Sum](https://leetcode.com/problems/two-sum/)
4. [ ] [Group Anagrams](https://leetcode.com/problems/group-anagrams/)
5. [ ] [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
6. [ ] [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
7. [ ] [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)
8. [ ] [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/)
9. [ ] [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
10. [ ] [3Sum](https://leetcode.com/problems/3sum/)

### Notes
- Store your solutions in this folder: `ContainsDuplicate.java`, `TwoSum.java`, etc.
- Add comments explaining time/space complexity

---

## Java Task: User Class with Encapsulation

### Requirements
Create a `User.java` class demonstrating encapsulation:

```java
public class User {
    private String name;
    private String email;
    private String password;
    
    // Constructor, getters, setters
    // Validation logic in setters
    // Override toString()
}
```

### Key Concepts
- **Private fields**: Prevent direct access
- **Public methods**: Controlled access through getters/setters
- **Validation**: Email format, password strength
- **Immutability**: Consider making certain fields final

---

## Theory: JVM Architecture

### Topics to Study
1. **JVM Components**
   - Class Loader
   - Runtime Data Areas (Heap, Stack, Method Area)
   - Execution Engine

2. **Memory Management**
   - Heap vs Stack
   - Garbage Collection basics
   - Object lifecycle

3. **Pass by Value vs Pass by Reference**

### Create a Document
Add `JVM-Notes.md` in this folder with diagrams and explanations.

---

## Tools Setup
- [ ] Install JDK 21 (verify with `java -version`)
- [ ] Install IntelliJ IDEA Community Edition
- [ ] Configure Git (`git config --global user.name "Your Name"`)

---

## Reflection Questions
1. Why is encapsulation important in large codebases?
2. When would you use a HashMap vs TreeMap?
3. How does the JVM manage memory automatically?

**Document your answers in `reflections.md`**
