package hot100.stack;

import annotations.Star;

import java.util.LinkedList;
import java.util.List;

@Star("单调栈最经典的应用:注意1、下标入栈 2、何时入栈何时出栈3、出栈时如何计算")
public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //计算
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
    public int[] dailyTemperatures_(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int lens=temperatures.length;
        int[] res = new int[lens];
        stack.push(0);
        for (int i = 1; i < lens; i++) {
            //如果小于等于栈顶元素，入栈
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            }else {
            //重复判断：如果大于栈顶元素，出栈并计算；
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

}
