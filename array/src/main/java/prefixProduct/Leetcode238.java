package prefixProduct;

import annotations.Star;

import java.util.Arrays;

@Star("前缀积，用左边的累乘乘右边的累乘，所以用两个数组分别存左右累乘即可，下方代码巧妙优化空间复杂度")
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int left=1,right=1;
        for (int i = 0; i < nums.length; i++) {
            result[i]*=left;
            left *= nums[i];
            result[nums.length-i-1]*=right;
            right *= nums[nums.length - i - 1];
        }
        return result;

    }
}
