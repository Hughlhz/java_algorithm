package hot100.dynamic;

import java.util.Arrays;

public class Leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target=sum/2;
        int[] dp = new int[target + 1];
        for (int j = stones[0]; j < dp.length; j++) {
            dp[j] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                dp[j] = Math.max(dp[j], j - stones[i] >= 0 ? dp[j - stones[i]] + stones[i] : -1);
            }
        }
        return sum - dp[dp.length - 1] * 2;
    }
}
