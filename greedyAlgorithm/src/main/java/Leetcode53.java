public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int result=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
//            if (result < sum) {
//                result=sum;
//            }
            result = Math.max(result, sum);
            if (sum <= 0) {
                sum=0;
            }

        }
        return result;
    }
}
