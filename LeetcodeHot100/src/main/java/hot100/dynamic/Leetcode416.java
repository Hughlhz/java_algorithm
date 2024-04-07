package hot100.dynamic;

public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target=sum/2;
        int dp[] = new int[target + 1];
        for (int j = nums[0]; j< dp.length; j++) {
            dp[j] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                dp[j] = Math.max(dp[j], (j-nums[i]>=0)?dp[j - nums[i]] + nums[i]:-1);
            }
        }
        return dp[target]==target?true:false;
    }
}
