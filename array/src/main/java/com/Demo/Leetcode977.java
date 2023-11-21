package com.Demo;

public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int front=0,back=nums.length-1;
        int[] result = new int[nums.length];
        int index=back;
        while (front <=back) {
            if (Math.abs(nums[front]) < Math.abs(nums[back])) {
                result[index]=nums[back]*nums[back];
                back--;
                index--;
            }else{
                result[index]=nums[front]*nums[front];
                front++;
                index--;
            }
        }return  result;
    }
}
