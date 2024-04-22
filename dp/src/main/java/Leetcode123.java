import java.util.ArrayList;

public class Leetcode123 {
    public int Wrong__maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int current = prices[0];
        int sum=0;
        int perBill=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < prices.length; i++) {

            if (current < prices[i]) {
                perBill=prices[i]-current;
                list.add(perBill);
                sum+=perBill;
            }
            current = prices[i];
        }
        int result=0;
        return list.stream().sorted((a, b) -> b.compareTo(a)).limit(3).reduce(0, Integer::sum);
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], 0 - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
