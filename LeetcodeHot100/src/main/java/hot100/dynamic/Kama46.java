package hot100.dynamic;

import java.util.*;

public class Kama46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = scanner.nextInt();
        }
        int[] dp = new int[n + 1];
        for (int j = weight[0]; j < n + 1; j++) {
            dp[j] = value[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = n; j >=0 ; j--) {
                dp[j] = Math.max(dp[j], (j-weight[i]>=0)?dp[j - weight[i]] + value[i]:-1);
            }
        }
        System.out.println(dp[n]);
    }
    public static void main_(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = scanner.nextInt();
        }
        int[][] dp = new int[m][n + 1];
        for (int j = weight[0]; j < n + 1; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (j-weight[i]>=0)?dp[i-1][j - weight[i]] + value[i]:-1);
            }
        }
        System.out.println(dp[m-1][n]);
    }
}
