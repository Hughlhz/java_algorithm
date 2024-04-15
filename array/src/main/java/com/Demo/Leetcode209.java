package com.Demo;

import annotations.Star;
import org.junit.Test;

import java.net.Inet4Address;

@Star("注意Integer.MAX_VALUE的使用，以及使用滑动窗口来减少计算次数")
public class Leetcode209 {
    @Test
    public int minSubArrayLen(int s, int[] nums) {
        int fast=0,slow=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for (; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= s) {
                result = Math.min(result, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
