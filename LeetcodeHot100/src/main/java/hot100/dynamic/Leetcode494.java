package hot100.dynamic;

import annotations.Star;

import java.util.Arrays;

@Star("计算装满背包方法的组合数")
public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int bag = (target + sum) / 2;
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int[] dp = new int[bag + 1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >=nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
                // 或者写成
//                dp[j] = dp[j] + dp[j - nums[i]];
//                这样可以理解为，装满j时 不选物品i的组合数+选i的组合数
            }
        }
        return dp[dp.length - 1];

    }
}
