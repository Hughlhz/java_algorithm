package hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Leetcode70 {
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0);
            return results;
        }

        private void dfs(int[] nums, int start) {
            results.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
