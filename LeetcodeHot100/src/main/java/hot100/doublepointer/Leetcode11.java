package hot100.doublepointer;

import annotations.Star;

@Star("经典的双指针题，注意指针如何移动，来减少时间复杂度")
public class Leetcode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area;
        int max=0;
        while (left <= right) {
            area = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(max, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
