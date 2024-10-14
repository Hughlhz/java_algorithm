package hot100.skill;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Leetcode31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            //[1,2,4,6,5,4,3,2]
            //[1,2,3]
            int i=nums.length-1;
            while (i > 0 && nums[i] < nums[i - 1]) {
                i--;
            }
            int smaller=i-1;
            if(smaller==-1){
                Arrays.sort(nums);
                return;
            }
            int greater=-1;
            for (int j = nums.length - 1; j > smaller; j--) {
                if (nums[j] > nums[smaller]) {
                    greater = j;
                    break;
                }
            }
            swap(nums, smaller, greater);
            reverse(nums, smaller+1);
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start < end) {
                swap(nums,start++,end--);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    @Test
    public void test() {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1, 2, 3});

    }
}
