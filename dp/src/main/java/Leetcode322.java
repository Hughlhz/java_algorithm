import java.util.Arrays;
import java.util.Map;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount==0) return 0;
        if(amount<coins[0]) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[coins[0]]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j - coins[i]]==Integer.MAX_VALUE?Integer.MAX_VALUE:(dp[j - coins[i]] + 1), dp[j]);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];

    }
}
