package hot100.doublepointer;

import annotations.Star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Star("三数之和：循环+双指针+去重是重点")
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left;
        int right=nums.length-1;
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        int sum=0;
        ArrayList<Integer> path = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left= i+1;
            right=nums.length-1;
            while (left < right) {
                sum=nums[i] + nums[left] + nums[right];
                if ( sum == 0) {
                    results.add(new ArrayList<>(Arrays.asList(nums[i],nums[left] , nums[right])));
                    while (right>left&&nums[right]==nums[right-1]) right--;
                    while (right>left&&nums[left]==nums[left+1]) left++;
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }

        }
        return results;
    }
}
