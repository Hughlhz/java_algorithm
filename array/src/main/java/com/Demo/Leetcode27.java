package com.Demo;

public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++]=nums[fast++];
            }
            while(fast<nums.length&&nums[fast]==val) {
                fast++;
            }
        }
        return slow;
    }
}
