package hot100.doublepointer;

import annotations.Star;

@Star("注意这种情况下循环的用法")
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int slow=0,fast=0;
        if (nums.length <= 1) {
            return;
        }
        while (fast<nums.length&&slow<nums.length)
        {
            while (slow < nums.length && nums[slow] != 0) {
                slow++;
            }
            fast=slow;
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            if (fast < nums.length) {
                swap(nums,slow, fast);
            }
        }
        return;
    }

    private void swap(int[] nums, int slow, int fast) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }


}
