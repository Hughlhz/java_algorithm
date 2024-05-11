package hot100.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;//相当于地图的入口 其他都是边界，无穷大
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m][n];
    }

}
