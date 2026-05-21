<Add array study guide content>

# Arrays — Quick Codeforces Study Guide

Concise topics and small Java examples to practice for array problems on Codeforces.

## 1. Basics (traversal, sum, min/max)
Simple scans, accumulation, and basic stats.

```java
int[] a = {3,1,4,1,5};
int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
for (int v : a) { sum += v; max = Math.max(max, v); min = Math.min(min, v); }
System.out.println("sum="+sum+" max="+max+" min="+min);
```

## 2. Two-pointers (sorted arrays)
Useful for pair-sum, remove duplicates in-place, or merging.

```java
int[] a = {1,2,3,4,6};
int target = 8;
int l=0, r=a.length-1;
while (l<r) {
	int s = a[l]+a[r];
	if (s==target) { System.out.println("found: "+l+","+r); break; }
	else if (s<target) l++; else r--;
}
```

## 3. Sliding-window (fixed or variable length)
Common for sums, counts, and longest/shortest subarray with constraints.

```java
int[] a = {2,1,5,1,3,2};
int k=3, sum=0, max=0;
for (int i=0;i<a.length;i++){
	sum += a[i];
	if (i>=k) sum -= a[i-k];
	if (i>=k-1) max = Math.max(max, sum);
}
System.out.println(max);
```

## 4. Prefix sums & range queries
Precompute cumulative sums to answer O(1) range queries.

```java
int[] a = {1,2,3,4};
int n=a.length; int[] pref = new int[n+1];
for (int i=0;i<n;i++) pref[i+1]=pref[i]+a[i];
// sum of a[l..r]
int l=1, r=3; // 0-based
int rangeSum = pref[r+1]-pref[l];
System.out.println(rangeSum);
```

## 5. Difference array (range add updates)
Apply many range additions in O(1) each, finalize with a prefix pass.

```java
int n=5; int[] diff = new int[n+1];
// add val to [l..r]
int l=1, r=3, val=5; diff[l]+=val; if (r+1<diff.length) diff[r+1]-=val;
for (int i=1;i<n;i++) diff[i]+=diff[i-1];
System.out.println(Arrays.toString(Arrays.copyOf(diff,n)));
```

## 6. Hashing & frequency maps (expanded)
Hashing is central to many array tasks: counting, existence checks, pair/subarray problems.

- Frequency array (fast when values are small/non-negative). O(n + R) time, O(R) space where R is value range.

```java
int[] a = {1,2,2,3,1};
int maxVal = 3; int[] freq = new int[maxVal+1];
for (int v : a) freq[v]++;
for (int v=0; v<freq.length; v++) if (freq[v]>0) System.out.println(v+":"+freq[v]);
```

- HashMap for unsorted pair-sum (two-sum) or indexing. Average O(n) time.

```java
int[] a = {2,7,11,15}; int target = 9;
Map<Integer,Integer> idx = new HashMap<>();
for (int i=0;i<a.length;i++){
	int need = target - a[i];
	if (idx.containsKey(need)) { System.out.println(idx.get(need)+","+i); break; }
	idx.put(a[i], i);
}
```

- Prefix-sum + HashMap: count number of subarrays with sum == K (classic CF/LeetCode problem).

```java
int[] a = {1,1,1}; int K = 2;
Map<Integer,Integer> count = new HashMap<>();
count.put(0,1);
int pref = 0, ans = 0;
for (int v : a) {
	pref += v;
	ans += count.getOrDefault(pref - K, 0);
	count.put(pref, count.getOrDefault(pref,0) + 1);
}
System.out.println(ans); // number of subarrays summing to K
```

- Use HashSet for quick membership (e.g., detect duplicates or find complement existence).

```java
int[] a = {3,1,4,1,5};
Set<Integer> seen = new HashSet<>();
boolean dup=false;
for (int v: a) { if (!seen.add(v)) { dup=true; break; } }
System.out.println("hasDuplicate="+dup);
```

Notes:
- HashMaps/HashSets provide average O(1) lookups; watch out for worst-case attacks but fine for CF problems.  
- When values are small and dense, prefer frequency arrays for speed and simplicity.  
- Combine prefix sums + maps for many subarray counting problems (equal sum, sum modulo m, etc.).

## 7. Sorting & binary search
Sort then use binary search or greedy selection; also binary-search-on-answer.

```java
int[] a = {5,1,3,4};
Arrays.sort(a); // {1,3,4,5}
int x = 4; int pos = Arrays.binarySearch(a, x);
if (pos<0) pos = -pos-1; // insertion (lower_bound)
System.out.println(pos);
```

## 8. Kadane's algorithm (maximum subarray)
Classic O(n) max contiguous subarray sum.

```java
int[] a = {-2,1,-3,4,-1,2,1,-5,4};
int maxSoFar=a[0], cur=a[0];
for (int i=1;i<a.length;i++){
	cur = Math.max(a[i], cur + a[i]);
	maxSoFar = Math.max(maxSoFar, cur);
}
System.out.println(maxSoFar);
```

## 9. Common Codeforces patterns
- Permutations & visited arrays (cycle detection).  
- Greedy after sorting.  
- Two-pointers for contiguous constraints.  
- Hash + prefix sums for subarray count problems.  
- Binary search on answer with linear feasibility check.

## 10. Quick practice list (select 6–8)
- Easy: Two Sum (hash), Best Time to Buy and Sell Stock (one-pass), Rotate Array (in-place).  
- Medium: Subarray Sum Equals K (prefix+map), Longest subarray with sum ≤ S (two-pointers), Permutation reconstruction.  
- CF staples: range add queries (difference array), minimal maximum partition (binary search on answer).

Study advice: warm-up 15m on easy scans and sorts, 30–45m practicing target patterns (two-pointers, sliding-window, prefix/hash), then 15m reviewing mistakes.

