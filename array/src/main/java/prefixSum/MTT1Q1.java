package prefixSum;

import annotations.Star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Star("前缀和减少重复计算")
public class MTT1Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // 注意 hasNext 和 hasNextLine 的区别
        int n = Integer.valueOf(br.readLine());
        int [][]nums = new int[n][n];
        int[][] sum = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
//                nums[i][j] = Integer.valueOf(s.charAt(j));
                nums[i][j] = s.charAt(j)-'0';

            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }

        for (int i = 0; i < n; i ++) {
            if (i % 2 == 0) {
                System.out.println(0);
                continue;
            }
            int count=0;
            for (int j = 0; j < n - i; j++) {
                for (int k = 0; k < n - i; k++) {
                    int temp = sum[j + i + 1][k + i + 1] + sum[j][k] - sum[j][k + i + 1] - sum[j + i + 1][k];
                    if (temp == (i + 1) * (i + 1)/2) {
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
}
