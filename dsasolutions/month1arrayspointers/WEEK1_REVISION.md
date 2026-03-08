# Week 1: Arrays & Hashing - Complete Revision Guide

**Duration:** March 3-8, 2026  
**Progress:** 7/9 Problems Completed (77.8%)  
**Status:** Excellent Progress! 🎉

---

## 📊 Problems Completed

### ✅ 1. Contains Duplicate (Easy) - Rating: 9/10
**Problem:** Check if array has any duplicate values.

**Solution:** HashSet for O(1) lookups
```java
HashSet<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (seen.contains(num)) return true;
    seen.add(num);
}
return false;
```

**Key Learning:**
- HashSet.contains() is O(1) - instant lookup
- Better than nested loops O(n²) or sorting O(n log n)

**Complexity:**
- Time: O(n)
- Space: O(n)

---

### ✅ 2. Valid Anagram (Easy) - Rating: 9.5/10
**Problem:** Check if two strings are anagrams.

**Solution:** Character frequency counting with array
```java
int[] count = new int[26];
for (char c : s.toCharArray()) {
    count[c - 'a']++;
}
for (char c : t.toCharArray()) {
    count[c - 'a']--;
}
// Check if all zeros
```

**Key Learning:**
- Array counting for lowercase letters: O(1) space (fixed size 26)
- Increment for first string, decrement for second
- Alternative: Sort both strings and compare

**Complexity:**
- Time: O(n)
- Space: O(1) - array size is constant (26)

---

### ✅ 3. Two Sum (Easy) - Rating: 9/10
**Problem:** Find two indices where nums[i] + nums[j] = target.

**Solution:** HashMap for complement search
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }
    map.put(nums[i], i);
}
```

**Key Learning:**
- Store value → index mapping
- Search for complement (target - current)
- One-pass solution possible!

**Complexity:**
- Time: O(n)
- Space: O(n)

**Common Mistake Fixed:**
- Index order matters: [map.get(complement), i] not [i, map.get(complement)]

---

### ✅ 4. Group Anagrams (Medium) - Rating: 10/10
**Problem:** Group strings that are anagrams together.

**Solution:** Sorted string as HashMap key
```java
HashMap<String, List<String>> map = new HashMap<>();
for (String str : strs) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    String sortedKey = new String(chars);
    
    map.putIfAbsent(sortedKey, new ArrayList<>());
    map.get(sortedKey).add(str);
}
return new ArrayList<>(map.values());
```

**Key Learning:**
- Anagrams have the same sorted form
- Use sorted string as HashMap key
- Group all original strings under same key

**Complexity:**
- Time: O(n × k log k) where k = max string length
- Space: O(n × k)

---

### ✅ 5. Top K Frequent Elements (Medium) - Rating: 10/10
**Problem:** Find k most frequent elements in array.

**Solution 1:** Sorting approach (simpler)
```java
// Step 1: Count frequencies
HashMap<Integer, Integer> count = new HashMap<>();
for (int n : nums) {
    count.put(n, count.getOrDefault(n, 0) + 1);
}

// Step 2: Sort by frequency (descending)
List<Integer> sortedList = new ArrayList<>(count.keySet());
sortedList.sort((a, b) -> count.get(b) - count.get(a));

// Step 3: Take first k elements
for (int i = 0; i < k; i++) {
    ans[i] = sortedList.get(i);
}
```

**Complexity:** O(n log n) time, O(n) space

**Solution 2:** Bucket sort (optimal)
```java
// Step 1: Count frequencies
HashMap<Integer, Integer> count = new HashMap<>();

// Step 2: Create buckets (index = frequency)
List<Integer>[] bucket = new List[nums.length + 1];
for (int key : count.keySet()) {
    int freq = count.get(key);
    if (bucket[freq] == null) {
        bucket[freq] = new ArrayList<>();
    }
    bucket[freq].add(key);
}

// Step 3: Collect k elements from high to low frequency
for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
    if (bucket[i] != null) {
        for (int num : bucket[i]) {
            ans[index++] = num;
        }
    }
}
```

**Complexity:** O(n) time, O(n) space ⚡

**Key Learning:**
- Bucket sort: Create array where index = frequency
- Max frequency in array of length n is n
- Traverse buckets backwards (high to low frequency)

**Comparator Logic:**
```java
(a, b) -> count.get(a) - count.get(b)  // Ascending
(a, b) -> count.get(b) - count.get(a)  // Descending ✅
```
- Negative result → a before b
- Positive result → b before a

---

### ✅ 6. Product of Array Except Self (Medium) - Rating: 10/10
**Problem:** Return array where answer[i] = product of all elements except nums[i], without division.

**Solution 1:** Prefix & Suffix arrays
```java
int[] prefix = new int[n];
int[] suffix = new int[n];

// Build prefix products
prefix[0] = 1;
for (int i = 1; i < n; i++) {
    prefix[i] = nums[i-1] * prefix[i-1];
}

// Build suffix products
suffix[n-1] = 1;
for (int i = n-2; i >= 0; i--) {
    suffix[i] = nums[i+1] * suffix[i+1];
}

// Multiply prefix and suffix
for (int i = 0; i < n; i++) {
    ans[i] = prefix[i] * suffix[i];
}
```

**Complexity:** O(n) time, O(n) space

**Solution 2:** Optimized O(1) space
```java
// Pass 1: Build prefix in ans array
int prefix = 1;
for (int i = 0; i < n; i++) {
    ans[i] = prefix;
    prefix *= nums[i];
}

// Pass 2: Multiply suffix on-the-fly
int suffix = 1;
for (int i = n-1; i >= 0; i--) {
    ans[i] *= suffix;
    suffix *= nums[i];
}
```

**Complexity:** O(n) time, O(1) space ⚡

**Key Learning:**
- Product except self = prefix product × suffix product
- Can optimize space by building directly in ans array
- Two-pass solution eliminates extra arrays

---

### ✅ 7. Longest Consecutive Sequence (Medium) - Rating: 10/10
**Problem:** Find length of longest consecutive sequence in unsorted array.

**Solution 1:** TreeSet (works but not optimal)
```java
TreeSet<Integer> sortedSet = new TreeSet<>();
for (int num : nums) {
    sortedSet.add(num);
}
// Check consecutive...
```

**Complexity:** O(n log n) time ❌

**Solution 2:** HashSet with predecessor check (optimal)
```java
HashSet<Integer> set = new HashSet<>();
for (int num : nums) {
    set.add(num);
}

int maxLength = 0;
for (int num : set) {
    // Only start if this is a sequence start
    if (!set.contains(num - 1)) {
        int currentNum = num;
        int length = 1;
        
        while (set.contains(currentNum + 1)) {
            currentNum++;
            length++;
        }
        
        maxLength = Math.max(maxLength, length);
    }
}
```

**Complexity:** O(n) time, O(n) space ⚡

**Key Learning - The Genius Optimization:**
- `if (!set.contains(num - 1))` ensures we only start from sequence beginnings
- Without this check: O(n²) - count from every number
- With this check: O(n) - each number visited at most twice
- Even though there's a nested loop, total operations ≈ 2n

**Why it's O(n):**
- Each number checked once in outer loop
- Each number counted once in while loop (only from sequence start)
- Total: ~2n operations = O(n)

**Example:** `[1,2,3,4]`
```
Check 1: no 0? → START! Count 1→2→3→4 (4 ops)
Check 2: has 1? → SKIP
Check 3: has 2? → SKIP  
Check 4: has 3? → SKIP
Total: 8 ops = 2n ✅
```

---

## 🎓 Key Concepts Mastered

### 1. HashSet vs TreeSet

| Feature | HashSet | TreeSet |
|---------|---------|---------|
| **Internal Structure** | Hash Table | Red-Black Tree |
| **add()** | O(1) | O(log n) |
| **contains()** | O(1) | O(log n) |
| **Ordering** | No order | Sorted order |
| **When to Use** | Need fast lookup | Need sorted data |

**Critical Insight:** HashSet's O(1) operations make O(n) algorithms possible!

---

### 2. HashMap Patterns

#### Pattern 1: Frequency Counting
```java
HashMap<Integer, Integer> count = new HashMap<>();
for (int num : nums) {
    count.put(num, count.getOrDefault(num, 0) + 1);
}
```

#### Pattern 2: Complement Search (Two Sum)
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        // Found pair!
    }
    map.put(nums[i], i);
}
```

#### Pattern 3: Grouping with Key (Group Anagrams)
```java
HashMap<String, List<String>> map = new HashMap<>();
for (String str : strs) {
    String key = computeKey(str);  // e.g., sorted string
    map.putIfAbsent(key, new ArrayList<>());
    map.get(key).add(str);
}
```

---

### 3. Array Counting Technique

For **fixed-range** data (like lowercase letters):
```java
int[] count = new int[26];  // a-z
for (char c : s.toCharArray()) {
    count[c - 'a']++;
}
```

**Benefits:**
- O(1) space (constant size)
- Faster than HashMap for small ranges
- Perfect for character counting

---

### 4. Bucket Sort Pattern

When frequencies are bounded by n:
```java
List<Integer>[] bucket = new List[n + 1];
// index = frequency, value = list of elements
```

**Use case:** Finding top k frequent elements in O(n)

---

### 5. Prefix/Suffix Product Pattern

```java
prefix[i] = product of all elements before i
suffix[i] = product of all elements after i
answer[i] = prefix[i] × suffix[i]
```

**Space optimization:** Build directly in answer array!

---

### 6. Predecessor Check Optimization

Pattern for avoiding O(n²) in sequences:
```java
if (!set.contains(element - 1)) {
    // This is a sequence start, process it
}
```

**Why it works:** Ensures each sequence processed only once

---

## 🧮 Complexity Analysis Cheat Sheet

| Operation | Best | Common | Notes |
|-----------|------|--------|-------|
| HashMap.get/put | O(1) avg | O(n) worst | Hash collision |
| HashSet.contains/add | O(1) avg | O(n) worst | Hash collision |
| TreeSet.contains/add | O(log n) | O(log n) | Balanced tree |
| Array access | O(1) | O(1) | Direct indexing |
| Arrays.sort() | O(n log n) | O(n log n) | For primitives |
| String.toCharArray() | O(n) | O(n) | n = string length |

---

## 🎯 Problem-Solving Strategies Learned

### Strategy 1: Need fast lookup?
→ Use **HashSet** or **HashMap**

### Strategy 2: Need to count frequencies?
→ Use **HashMap** (or array for fixed range)

### Strategy 3: Need to group items?
→ Use **HashMap<Key, List<Value>>**

### Strategy 4: Need sorted order?
→ Use **TreeSet** or sort array (but costs O(log n) per op)

### Strategy 5: Optimization opportunity?
→ Look for:
- Can I eliminate extra passes?
- Can I build directly in output array?
- Can I skip redundant work?

### Strategy 6: Nested loops making O(n²)?
→ Ask: Can I use a set/map to make lookups O(1)?

---

## 💡 Common Patterns Recognition

### You'll know to use HashMap when you see:
- "Find pair that sums to target"
- "Count frequencies"
- "Group by some criteria"
- "Find complement/matching element"

### You'll know to use HashSet when you see:
- "Check for duplicates"
- "Find if element exists"
- "Find consecutive sequence"
- "Need O(1) lookup, no value needed"

### You'll know to use Array Counting when you see:
- "Only lowercase letters"
- "Small fixed range (0-9, a-z)"
- "Need O(1) space"

---

## 🚀 Performance Insights

### Why HashSet beats sorting:
```
Sorting:     O(n log n)
HashSet:     O(n)

For n = 1M:
Sort:        ~20M operations
HashSet:     ~1M operations
→ 20x faster!
```

### Why predecessor check matters:
```
Without check: O(n²)
With check:    O(n)

For n = 1000:
Without:      ~1M operations
With:         ~2K operations  
→ 500x faster!
```

---

## ✅ Revision Checklist

Before moving to Week 2, make sure you can:

**Conceptual Understanding:**
- [ ] Explain why HashSet.contains() is O(1)
- [ ] Explain why TreeSet.contains() is O(log n)
- [ ] Draw the 3×3 box indices for Sudoku (0-8)
- [ ] Explain prefix/suffix product concept
- [ ] Explain why predecessor check avoids O(n²)

**Pattern Recognition:**
- [ ] Identify when to use HashMap vs HashSet
- [ ] Recognize frequency counting problems
- [ ] Recognize complement search problems
- [ ] Spot opportunities for bucket sort

**Implementation Skills:**
- [ ] Write HashMap frequency counter from scratch
- [ ] Write HashSet duplicate checker from scratch
- [ ] Implement custom comparator for sorting
- [ ] Use getOrDefault() correctly

**Complexity Analysis:**
- [ ] Calculate time complexity of nested loops with HashSet
- [ ] Identify when nested loops are actually O(n)
- [ ] Compare space complexity of different approaches

---

## 📝 Problems Remaining

### 8. Encode and Decode Strings (Premium)
- Status: Placeholder created
- Optional: Can implement for practice

### 9. Valid Sudoku
- Status: Paused (need more time on box indexing)
- Can revisit when ready
- Key concept: `boxIndex = (row/3)*3 + (col/3)`

---

## 🎉 Week 1 Achievements

✅ **7/9 problems completed** - 77.8% success rate!  
✅ **Perfect 10/10** on 4 problems!  
✅ **Mastered both O(n log n) and O(n) solutions**  
✅ **Learned HashSet vs TreeSet tradeoffs**  
✅ **Understood advanced optimization techniques**  
✅ **Maintained daily coding streak!** 🔥

---

## 🔜 Next Steps

**Week 2: Two Pointers**
- Coming up in your curriculum
- Will build on array manipulation skills
- New patterns to learn!

**Before Week 2:**
- Review this document
- Revisit any confusing problems
- Practice explaining concepts out loud
- Try Valid Sudoku when ready

---

**Keep up the excellent work! You're building strong foundations! 💪🚀**

*Generated: March 8, 2026*
