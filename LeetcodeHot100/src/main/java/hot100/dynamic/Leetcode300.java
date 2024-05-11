package hot100.dynamic;

import java.util.Arrays;
import java.util.stream.Stream;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < n + 1; i++) {
            for (int j = i-1; j >= 1; j--) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }
}
