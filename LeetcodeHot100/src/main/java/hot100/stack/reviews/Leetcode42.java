package hot100.stack.reviews;

import java.util.LinkedList;

public class Leetcode42 {
    public static int trap(int[] height) {
        LinkedList<Integer> stack=new LinkedList<>();
        int volume=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int low=stack.pop();
                if(!stack.isEmpty()){
                    int high=Math.min(height[i],height[stack.peek()]);
                    int width=i-stack.peek()-1;
                    volume+=(high-height[low])*width;
                }
            }
            stack.push(i);
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 0,1, 3, 2, 1, 2, 1};
        trap(nums);
    }
}
