package review.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {
    public List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] candidates;
    int target;
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates=candidates;
        this.target=target;
        backtracking(0);
        return results;
    }

    private void backtracking(int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
