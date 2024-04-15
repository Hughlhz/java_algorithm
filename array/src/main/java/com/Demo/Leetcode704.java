package com.Demo;
import annotations.Star;
import org.junit.Test;

@Star("注意while循环的条件")
public class Leetcode704 {
    public Leetcode704() {
    }

    public int search(int[] nums, int target) {
        int front = 0, back = nums.length - 1;
        int mid;
        while (front <= back) {
            mid=(front+back)/2;
            if(target<nums[mid])
                back=mid-1;
            else if (target > nums[mid]) {
                front=mid+1;
            }else return mid;
        }
        return -1;
    }
}
