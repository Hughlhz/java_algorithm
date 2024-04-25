import java.util.Arrays;

public class Leetcode674 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i]=dp[i-1]+1;
            }
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i]=Math.max(dp[j]+1,dp[i]);
//                }
//            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
