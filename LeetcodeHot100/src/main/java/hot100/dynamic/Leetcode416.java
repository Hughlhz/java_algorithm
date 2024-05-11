package hot100.dynamic;

import java.util.Arrays;

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

    //优化 上面的思路是看tar的背包能否装到tar
    //还可以 算装满tar背包的方法数
    public boolean canPartitionCount(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int target=sum/2;
        int dp[] = new int[target + 1];
        dp[0]=1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];//这行代码容易出错
            }
        }
        return dp[target]==0?false:true;
    }
    //还可以 直接用boolean数组
    public boolean canPartitionBoolean(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target=sum/2;
        boolean dp[] = new boolean[target + 1];
        dp[0]=true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]] || dp[j];
            }
        }
        return dp[target];

    }
}
