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

## 6. Hashing & frequency maps
Count occurrences, solve two-sum for unsorted arrays, subarray-sum-k with prefix map.

```java
int[] a = {2,7,11,15}; int target = 9;
Map<Integer,Integer> idx = new HashMap<>();
for (int i=0;i<a.length;i++){
	int need = target - a[i];
	if (idx.containsKey(need)) { System.out.println(idx.get(need)+","+i); break; }
	idx.put(a[i], i);
}
```

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

