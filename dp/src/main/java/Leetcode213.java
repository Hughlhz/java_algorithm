import java.util.Arrays;

public class Leetcode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int _nums[] = Arrays.copyOfRange(nums, 1, nums.length);
        int nums_[] = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(robLine(_nums), robLine(nums_));

    }
    public int robLine(int[] nums) {
        if (nums.length ==1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
