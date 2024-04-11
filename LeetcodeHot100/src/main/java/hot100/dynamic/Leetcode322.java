package hot100.dynamic;

import java.util.Arrays;
import java.util.EnumSet;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        if (coins[0] > amount) {
            return -1;
        }
        dp[0]=0;
        dp[coins[0]]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] = dp[j - coins[i]]==Integer.MAX_VALUE?dp[j]:Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        } else return  -1;
    }
}
