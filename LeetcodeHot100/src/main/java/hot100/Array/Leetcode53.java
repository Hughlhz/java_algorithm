package hot100.Array;

import java.util.Arrays;

public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[]dp =new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[1]=nums[0];
        for(int i=2;i<n+1;i++){
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
