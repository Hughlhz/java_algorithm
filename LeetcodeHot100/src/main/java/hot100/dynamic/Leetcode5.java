package hot100.dynamic;

public class Leetcode5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n+1][n+1];

        int maxLen=1;
        String res = s.substring(0, 1);
        for (int i = 1; i < n + 1; i++) {
            dp[i][i]=true;
        }
        for (int j = 1; j < n+1; j++) {
            for (int i = 1; i < j; i++) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    if(i==j-1) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if(dp[i][j]){
                        int temp = maxLen;
                        maxLen = Math.max(maxLen, j - i + 1);
                        if (maxLen != temp) {
                            res = s.substring(i-1, j );
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        leetcode5.longestPalindrome("cbbd");
    }

}
