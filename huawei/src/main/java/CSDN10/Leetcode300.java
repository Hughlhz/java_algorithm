package CSDN10;

import java.util.Arrays;
import java.util.OptionalInt;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
//            if(nums[i]<=nums[i-1]) dp[i] = dp[i - 1];
             {
                int max=0;

                for (int j = 0; j < i; j++) {
                    if(nums[i]>nums[j]){
                        max=Math.max(max,dp[j]);
                    }

                }
                dp[i]=max+1;
            }
        }
        return Arrays.stream(dp).max().orElse(1);

    }
}
