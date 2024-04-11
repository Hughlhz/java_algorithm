package hot100.dynamic;

import annotations.Star;

@Star("注意在算排列数时，递推公式会受到j-nums[i] 实际意义的限制")
public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < target + 1; j++) {
            for (int i = 0; i < nums.length; i++) {
                dp[j] += (j-nums[i]>=0)?dp[j - nums[i]]:0;
            }
        }
        return dp[target];
    }
}
