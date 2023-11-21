package com.Demo;

import org.junit.Test;

import java.net.Inet4Address;

public class Leetcode209 {
    //    public int minSubArrayLen(int s, int[] nums) {
//        int front = 0, back = 0;
//        int result = Integer.MAX_VALUE;
//        int sum = 0;
//        for (; back < nums.length; back++) {
//
//            sum += nums[back];
//            while (sum >= s) {
//                sum -= nums[front];
//                front++;
//                if (sum < s)
//                    result = back - front + 2;
//            }
//
//
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }
    @Test
    public int minSubArrayLen(int s, int[] nums) {
        int front = 0, back = 0;
        int sum = 0;
        int result=Integer.MAX_VALUE;
        int temp=0;
        for (; back < nums.length; back++) {
            sum += nums[back];
            while (sum >= s) {
                sum -= nums[front];
                temp=back-front+1;
                front++;
                if(result>temp) result=temp;
            }

        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
