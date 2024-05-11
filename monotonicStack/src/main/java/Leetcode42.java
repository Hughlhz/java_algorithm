import java.util.LinkedList;

public class Leetcode42 {
    public int trap(int[] height) {
        int volume=0;
        LinkedList<Integer> stack = new LinkedList();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //取出来计算
                //栈里没有比栈顶大的元素，所以栈顶对应的地方没有左壁，接不到雨水
                if (stack.size() == 1) {
                    stack.pop();
                    continue;
                }
                //有左壁
                int temp = stack.pop();
                int width=i-temp;
                int depth = Math.min(height[i], height[stack.peek()]) - height[temp];
                volume = +width * depth;
            }
            stack.push(i);
        }
        return volume;
    }
}
