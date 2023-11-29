

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Leetcode47 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean used[];

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return results;
    }

    public void backtracking(int[] nums, int start) {
        HashSet<Integer> used_set = new HashSet<>();
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] == true || used_set.contains(nums[i])) {
                continue;
            }
            used_set.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, start);
            path.removeLast();
            used[i] = false;
        }
    }

}

