package dsasolutions.month1arrayspointers;

public class ContainerWithMostWater {
    void main() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(height);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        int strIdx = 0;
        int endIdx = height.length-1;
        int maxArea = 0;
        while(strIdx < endIdx) {
            maxArea = Math.max(maxArea, Math.min(height[strIdx], height[endIdx]) * (endIdx-strIdx));
            if (height[strIdx] <= height[endIdx]) {
                strIdx++;
            } else {
                endIdx--;
            }
        }
        return maxArea;
    }
}
