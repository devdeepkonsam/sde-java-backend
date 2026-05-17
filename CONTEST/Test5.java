package CONTEST;

import java.util.Arrays;

public class Test5 {

    void main(){
        // int[] nums = {1};
        // int[] result = countOppositeParity(nums);
        // System.out.println(Arrays.toString(result));

        System.out.println(sumOfPrimesInRange(8));
        int[] nums = {-5,-2,3};
        int[][] queries = {{0,2},{2,0},{1,2}};

        //Input: nums = [0,2,3,9], queries = [[3,0],[1,2],[2,0]]
        int[] nums1 = {0,2,3,9};
        int[][] queries1 = {{3,0},{1,2},{2,0}};

        System.out.println(Arrays.toString(minCost(nums1, queries1)));

        System.out.println(Arrays.toString(minCost1(nums1, queries1)));


    }


    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int oddCount = 0;
        int evenCount = 0;

        for(int i = n-1; i >= 0; i--){
            if(nums[i]%2==0){
                ans[i] = oddCount;
                evenCount++;
            } else {
                ans[i] = evenCount;
                oddCount++;
            }
        }
        return ans;
    }



    public int sumOfPrimesInRange(int n){
        int sum = 0;
        int num = n;
        int reversed = 0;

        while(num > 0){
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        int start = Math.min(n,reversed);
        int end = Math.max(n,reversed);

        for(int i = start; i <= end; i++){
            if(isPrime(i)){
                sum += i;
            }
        }
        return sum;
    }

    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num) ; i++){
            if(num%i ==0){
                return false;
            }
        }
        return true;
    }



    public int[] minCost1(int[] nums, int [][] queries){
        int n = nums.length;
        long[] forward = new long[n];
        long[] backward = new long[n];

        for (int i = 0; i < n - 1; i++) {
            int closestIdx = getClosest(nums, i);
            int cost = (closestIdx == i + 1) ? 1 : Math.abs(nums[i + 1] - nums[i]);
            forward[i + 1] = forward[i] + cost;
        } 
        for (int i = n - 1; i > 0; i--) {
            int closestIdx = getClosest(nums, i);
            int cost = (closestIdx == i - 1) ? 1 : Math.abs(nums[i] - nums[i - 1]);
            backward[i - 1] = backward[i] + cost;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start <= end) {
                ans[i] = (int)(forward[end] - forward[start]);
            } else {
                ans[i] = (int)(backward[end] - backward[start]);
            }
        }
        return ans;
    }

    private int getClosest(int[] nums, int i) {
        int n = nums.length;
        if (i == 0) return 1;
        if (i == n - 1) return n - 2;
        
        int leftDiff = Math.abs(nums[i] - nums[i - 1]);
        int rightDiff = Math.abs(nums[i] - nums[i + 1]);
        
        return (leftDiff <= rightDiff) ? i - 1 : i + 1;
    
    }





/////////////// Brute force approach

     public int[] minCost(int[] nums, int [][] queries) {
        int q = queries.length;
        int[] ans = new int[q];

        for(int i = 0; i < q; i++){
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = calculateCost(nums,li,ri);
        }
        return ans;
    }
    public int calculateCost(int[] nums, int li, int ri){
            int cost = 0;
            int currentIndex = li;
    
            while(currentIndex != ri){
                int closestIndex = findClosest(nums,currentIndex);
                int directCost = Math.abs(nums[currentIndex] - nums[ri]);
    
                if(closestIndex != -1 && 1 + Math.abs(nums[closestIndex] - nums[ri]) < directCost){
                    cost += 1;
                    currentIndex = closestIndex;
                } else {
                    cost += directCost;
                    break;
                }
            }
        return cost;
    }
    public int findClosest(int[] nums, int index){
            int left = index - 1;
            int right = index + 1;
            int closestIndex = -1;
            int minDiff = Integer.MAX_VALUE;

            if(left >= 0){
                int diff = Math.abs(nums[index] - nums[left]);
                if(diff < minDiff){
                    minDiff = diff;
                    closestIndex = left;
                }
            }

            if(right < nums.length){
                int diff = Math.abs(nums[index] - nums[right]);
                if(diff < minDiff){
                    minDiff = diff;
                    closestIndex = right;
                }
            }
            return closestIndex;
    }
    
}
