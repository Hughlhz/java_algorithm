package com.Demo;

public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int fast=0,slow=0;
        for (;fast<nums.length;fast++){
            while (fast<nums.length-1&&nums[fast]==nums[fast+1])
                fast++;
            nums[slow++] = nums[fast];
        }
        return slow;
    }
}
