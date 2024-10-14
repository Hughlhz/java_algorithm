package hot100.dynamic.reviews;

import org.junit.jupiter.api.Test;

public class Leetcode279 {
    class Solution {
        public int numSquares(int n) {
            int sqr = (int)Math.sqrt(n);
            int[][] dp = new int[sqr + 1][n + 1];

            for (int i = 0; i < n+1; i++) {
                dp[0][i] = Integer.MAX_VALUE;
            }
            for (int i = 1; i < sqr + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(j<i*i){
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    }
                    // dp[i][j]=Math.min(dp[i][j-i*i]+1,dp[i-1][j]);
                    dp[i][j]=dp[i-1][j]==Integer.MAX_VALUE?(dp[i][j-i*i]+1):Math.min(dp[i][j-i*i]+1,dp[i-1][j]);
                }
            }
            return dp[sqr][n];

        }

    }
}
