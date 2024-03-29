package hot100.stack;

import annotations.Star;

import java.util.LinkedList;

@Star("单调栈的思路错了==1、栈里存的是下标2、注意何时出栈何时入栈3、注意计算时需要用到上一个元素作为墙壁来计算h")
public class Leetcode42 {
    public int trap(int[] height) {
        //[0,1,0,2,1,0,1,3,2,1,2,1]==>6
        LinkedList<Integer> stack = new LinkedList<>();
        int volume=0;
        int w,h;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //计算
                int mid = stack.peek();
                stack.pop();
                if (!stack.isEmpty()) {
                    h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    w=i-stack.peek()-1;
                    volume += h * w;
                }
            }
            stack.push(i);

        }
        return volume;

    }
}
