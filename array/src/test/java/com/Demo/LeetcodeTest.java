package com.Demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class LeetcodeTest {
    int nums[] = {1, 2, 3, 4, 4, 4, 5, 4, 10};
    int nums2[] = {-7, -3, 2, 3, 11};
    int nums3[] = {2, 3, 1, 2, 4, 3};
    int val = 4;

    @Test
    public void leetcode27Test() {
        Leetcode27 leetcode27 = new Leetcode27();
        System.out.println(leetcode27.removeElement(nums, val));

    }

    @Test
    public void leetcode977Test() {
        Leetcode977 leetcode977 = new Leetcode977();
        int[] a = leetcode977.sortedSquares(nums2);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void leetcode209Test() {
        Leetcode209 leetcode209 = new Leetcode209();
        System.out.println(leetcode209.minSubArrayLen(7, nums3));
    }

    @Test
    public void leetcode59Test() {
        Leetcode59 leetcode59 = new Leetcode59();
        int[][] ints = leetcode59.generateMatrix(1);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }

    @Test
    public void leetcode844Test() {
        String s = "ab#c";
        String t = "ad#c";
        Leetcode844 leetcode844 = new Leetcode844();
        System.out.println(leetcode844.backspaceCompare(s, t));
    }

    @Test
    public void leetcode26Test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Leetcode26 leetcode26 = new Leetcode26();
        System.out.println(leetcode26.removeDuplicates(nums));
    }

    @Test
    public void leetcode283Test() {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Leetcode283 leetcode283 = new Leetcode283();
        leetcode283.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
        Stream.of(nums).forEach(System.out::println);//注意这里的区别


    }
@Test
    public void streamTest() {
        String[] strings = {"第一", "第二", "第三"};
        Arrays.stream(strings).forEach(System.out::println);
        Stream.of(strings).forEach(System.out::println);
    }
}
