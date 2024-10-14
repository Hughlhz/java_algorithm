package hot100.skill;

import java.nio.IntBuffer;

public class Leetcode287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            //[1,3,4,2,2]
            int index = nums[0];
            while (nums[index] != nums[0]) {
                swap(nums, 0, index);
                index = nums[0];
            }
            return nums[0];

        }

        public void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j]=tmp;
        }
    }
}
