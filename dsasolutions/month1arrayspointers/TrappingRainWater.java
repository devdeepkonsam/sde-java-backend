package dsasolutions.month1arrayspointers;

public class TrappingRainWater {
    void main() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Test 1: " + trap(height));


    }

    int trap(int[] height){
        int strIdx = 0;
        int endIdx = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (strIdx <= endIdx) {
            if (height[strIdx] <= height[endIdx]) { //if left height is smaller than right height
                if (height[strIdx] >= leftMax) { //if current left height is greater than left max then update the left max
                    leftMax = height[strIdx];
                } else {
                    ans += leftMax - height[strIdx]; //if current left height is smaller than left max then we can trap water and add to ans
                }
                strIdx++; //move the left pointer
            } else {
                if (height[endIdx] >= rightMax) { //if current right height is greater than right max then update the right max
                    rightMax = height[endIdx];
                } else {
                    ans += rightMax - height[endIdx]; //if current right height is smaller than right max then we can trap water and add to ans
                }
                endIdx--; //move the right pointer
            }
        }

        return ans;
    }
}