import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        return results;
    }

    public int sum(List<Integer> list) {
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }
    public void backtracking(int[] candidates, int target,int start) {
        if (sum(path) == target) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (sum(path) > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(sum(path)+candidates[i]>target) break;
            path.add(candidates[i]);
            backtracking(candidates, target, i);
            path.removeLast();
        }
    }
}
