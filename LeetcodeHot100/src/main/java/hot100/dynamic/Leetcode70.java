package hot100.dynamic;

import java.util.Scanner;

public class Leetcode70 {


    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 0; j < n + 1; j++) {
            for (int i = 0; i < m; i++) {
                dp[j] += (j - i - 1 >= 0) ? dp[j - i - 1] : 0;

            }
        }
        System.out.println(dp[n]);
    }


}
