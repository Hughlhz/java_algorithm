package CSDN10;

import annotations.Star;

import java.util.ArrayList;
import java.util.Arrays;
@Star("重写比较方法")
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = String.valueOf(nums[i]);

        Arrays.sort(ss, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        String result = String.join("", ss);
        return result.charAt(0) == '0' ? "0" : result;
    }
}
