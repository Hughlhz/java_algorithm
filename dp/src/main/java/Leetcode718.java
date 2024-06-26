public class Leetcode718 {
    //    输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//    输出：3
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        int max=0;
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max = Math.max(dp[i][j], max);

            }
        }
        return max;

    }
}
