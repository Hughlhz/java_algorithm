package com.Demo;

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int front = 0, back = 0;
        for (; back < nums.length; back++) {
            if (nums[back] != 0) {
                nums[front++] = nums[back];
            }
        }
        while (front < back) {
            nums[front++]=0;
        }
    }
}
