package CONTEST;

import java.util.Arrays;

public class Test2{
    void main(){
        System.out.println(longestBalanced2("0001"));
    }

    int[] findDegrees(int[][] matrix){
        int[] degrees = new int[matrix.length];
        for(int i=0; i<matrix.length; i++){
            int degree = 0;
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    degree++;
                }
            }
            degrees[i] = degree;
        }
        return degrees;
    }

    //determine if there exist a positive area whose three sidees length are given by [] sides 
    // if there exist such a triangle, then return the internal angles of the triangle, otherwise return empty array
    //eg [3,4,5]-> [36.86990, 53.13010, 90.00000]    contraint : sides.length = 3, 1<= sides[i] <= 1000   and angles should be in degree and round to 5 decimal places
    // still it doesnt return in 10^-5 precision, so we can round it to 5 decimal places
    double[] internalAngles(int[] sides){
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        if(a+b>c && a+c>b && b+c>a){
            double A = Math.acos((b*b + c*c - a*a) / (2*b*c)) * 180 / Math.PI;
            double B = Math.acos((a*a + c*c - b*b) / (2*a*c)) * 180 / Math.PI;
            double C = 180 - A - B;
            return new double[]{Math.round(A*100000.0)/100000.0, Math.round(B*100000.0)/100000.0, Math.round(C*100000.0)/100000.0};
        }
        return new double[]{};
    }




    //String s contains binary number 0s and 1s
    //A String is balanced if it contains equal number of 0s and 1s
    //You can perform at most one swap between any two characters in s. Then, you select a balanced substring from s.
    //Return an integer representing the maximum length of the balanced substring you can select.
    // //A substring is a contiguous sequence of characters within a string.
    //input 100001  output will be 4 -> swap second 0 and last 1, then we get 1010 00 so the longest balanced substring is 1010 which has length 4
    //101000 output will be 4:1010 
    //input 111  output will be 0 


    int longestBalanced(String s){
        int count0 = 0;
        int count1 = 0;
        for(char c : s.toCharArray()){
            if(c == '0') count0++;
            else count1++;
        }
        if(count0 == count1) return s.length();
        if(Math.abs(count0 - count1) > 2) return 0;// if the difference is greater than 2, we cannot make it balanced with one swap
        //what is there are 5 0s and 1 1s  then ab(count0 - count1) = 4 > 2 so we cannot make it balanced with one swap but balanced substring can be 10 and 01 which is 2, so we can return 2 in this case
        return Math.min(count0, count1) * 2;
    }

    int longestBalanced2(String s){
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0') count0++;
            else count1++;
        }

        String temp = s;

        int limit = 2 * Math.min(count0, count1);
        if(limit == 0) return 0;

        int max_val = 2 * n +1;
        int[] head = new int[max_val];
        int[] tail = new int[max_val];
        Arrays.fill(head,-1);
        Arrays.fill(tail, -1);

        int[] next = new int[n + 1];
        int[] val = new int[n+1];
        int nodeCount = 0;

        head[n] = nodeCount;
        tail[n] = nodeCount;
        val[nodeCount] = 0;
        next[nodeCount] = -1;
        nodeCount++;

        int current_sum = 0;
        int max_len = 0;
        int[] targets = {-2,0,2};

        for(int i = 1; i <= n; i++){
            char c = temp.charAt(i-1);
            current_sum += (c == '0' ? 1 : -1);

            for(int t : targets){
                int req_sum = current_sum - t;
                int idx = req_sum + n;
                if(idx >= 0 && idx < max_val && head[idx] != -1){
                    while(head[idx] != -1 && val[head[idx]] < i - limit){
                        head[idx] = next[head[idx]];
                    }
                    if(head[idx] != -1){
                        max_len = Math.max(max_len, i - val[head[idx]]);
                    }
                }
            }
            int curr_idx = current_sum+n;
            val[nodeCount] = i;
            next[nodeCount] = -1;

            if(head[curr_idx] == -1){
                head[curr_idx] = nodeCount;
                tail[curr_idx] = nodeCount;
            } else {
                next[tail[curr_idx]] = nodeCount;
                tail[curr_idx] = nodeCount;
            }
            nodeCount++;
        }
        return max_len;
    }

    
}




