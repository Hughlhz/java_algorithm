package hot100.dynamic;

import java.util.Arrays;

public class Leetcode279 {
        public int numSquares(int n) {
            int m = (int)Math.sqrt(n);
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0]=0;
            for (int i = 0; i <= m; i++) {
                for (int j = i*i; j <n+1 ; j++) {
                    dp[j] = Math.min(dp[j - i * i] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (dp[j - i * i] + 1), dp[j]);
                }
            }
            return dp[n];
        }
}
