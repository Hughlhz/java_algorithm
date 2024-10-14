package hot100.stack.reviews;

import java.util.LinkedList;

public class Leetcode42R {
    class Solution {
        public int trap(int[] height) {
            LinkedList<Integer> stack = new LinkedList<>();
            int volume=0;
            for (int i = 0; i < height.length; i++) {
                if (stack.isEmpty() || height[stack.peek()] > height[i]) {
                    stack.push(i);
                    continue;
                }
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    Integer cur = stack.pop();
                    if(!stack.isEmpty()) {
                        int w = i - stack.peek() - 1;
                        int h = Math.min(height[stack.peek()], height[i]) - height[cur];
                        volume += w * h;
                    }
                }
                stack.push(i);
            }
            return volume;
        }
    }
}
