package hot100.dynamic;

import annotations.Star;

import java.util.stream.Stream;
@Star("两种限制的01背包，并计算背包装满时的最大数量")
public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            int zeroCount = zeroCount(strs[k]);
            int oneCount = oneCount(strs[k]);
            for (int i = m; i >=zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int oneCount(String str) {
//        return (int)Stream.of(str).filter(ch->ch .equals('1')).count(); 错误写法
        return (int)str.chars().filter(ch -> ch == ('1')).count();
    }

    public int zeroCount(String str) {
        return (int)str.chars().filter(ch -> ch == ('0')).count();
    }
}
