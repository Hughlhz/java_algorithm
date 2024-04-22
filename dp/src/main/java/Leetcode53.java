public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0]=0;
        int max = nums[0];
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i] = Math.max(nums[i-1], dp[i - 1] + nums[i-1]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
