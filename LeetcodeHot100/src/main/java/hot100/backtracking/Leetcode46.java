package hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {
    class Solution{
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            dfs(nums,used);
            return result;
        }
        private void dfs(int [] nums,boolean [] used) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i]=true;
                dfs(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
