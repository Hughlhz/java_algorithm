import annotations.Star;

@Star("最长回文子序列的长度，可以用二维DP")
public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < n + 1; j++) {
            for (int i = j-1; i >= 1; i--) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (i == j - 1) {
                        dp[i][j]=2;
                    }else {
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][n];
    }
}
