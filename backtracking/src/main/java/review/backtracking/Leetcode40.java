package review.backtracking;

import annotations.Star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@Star
public class Leetcode40 {
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
//            去重不能放这里，不然会导致下一层也不能用上一层相同的
//            if (i != 0 &&i!=candidates.length-1&& candidates[i] == candidates[i - 1]) {
//                continue;
//            }
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(i+1);
            sum-=candidates[i];
            path.removeLast();
            while (i<candidates.length-1&&candidates[i]==candidates[i+1]) i++;

        }
    }
}
