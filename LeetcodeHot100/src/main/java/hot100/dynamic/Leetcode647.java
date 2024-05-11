package hot100.dynamic;

public class Leetcode647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < n + 1; j++) {
            for (int i = j-1; i >= 1; i--) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if(i==j-1){
                        dp[i][j]=3;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1]+3;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[1][n];

    }

    public static void main(String[] args) {
        Leetcode647 leetcode647 = new Leetcode647();
        System.out.println(leetcode647.countSubstrings("aaa"));
    }
}
