package hot100.dynamic;

import annotations.Star;

import java.util.Scanner;
@Star("多重背包问题，将遍历物品的顺序变成正序即可，归纳的公式不变")
public class Kama52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
//        for (int j = weight[0]; j < m + 1; j++) {
//            dp[j]=
//        }
        dp[weight[0]] = value[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[j] = Math.max(dp[j], (j - weight[i] >= 0) ? dp[j - weight[i]]+value[i] : -1);
            }
        }
        System.out.println(dp[m]);

    }
}
