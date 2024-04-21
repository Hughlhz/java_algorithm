package kama;

import java.util.Scanner;

public class Kama57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] dp = new int[n + 1];
        dp[0]=1;
        for (int j = 1; j < n + 1; j++) {
            for (int i = 0; i < m; i++) {
                    dp[j] = j-i-1>=0?dp[j - i - 1] + dp[j]:dp[j];
                }
            }
        System.out.println(dp[n]);
    }
}
