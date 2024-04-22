public class Leetcode122 {

    //类似单调栈的做法
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int current = prices[0];
        int sum=0;
        for (int i = 1; i < prices.length; i++) {

            if (current < prices[i]) {
                sum+=prices[i]-current;
            }
            current = prices[i];
        }
        return sum;
    }

    //DP做法
    public int maxProfitDP(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}
