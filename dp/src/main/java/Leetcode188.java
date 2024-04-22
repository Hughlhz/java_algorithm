public class Leetcode188 {
    public int maxProfit(int k,int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[k * 2 + 1];
        for (int i = 1; i < k * 2+1; i += 2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
//            dp[0] = Math.max(dp[0], 0 - prices[i]);
//            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
//            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
//            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
            for (int j = 1; j < 2 * k+1; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }
        return dp[k * 2];
    }
}
