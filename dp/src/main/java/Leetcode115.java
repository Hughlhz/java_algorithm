public class Leetcode115 {
    public int numDistinct(String s, String t) {
        if (s.equals("")) {
            return 0;
        }
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len2 + 1][len1 + 1];
        int count=0;
        for (int i = 1; i < len2 + 1; i++) {
            char ch = t.charAt(i - 1);
            for (int j = 1; j < len1 + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] == t.length()) {
                    count++;
                }
            }
        }
        return count;
    }
}
