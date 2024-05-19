package hot100.Array;

import java.util.Arrays;

public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        r( nums, 0, nums.length - 1);
        r(nums, 0, k-1);
        r(nums, k, nums.length - 1);
    }

    private void r(int[] nums, int start, int end) {
        int k=(end-start+1)/2;
        while (k-- > 0) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
