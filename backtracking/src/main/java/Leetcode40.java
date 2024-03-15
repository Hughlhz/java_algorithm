import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Leetcode40 {
    List<List<Integer>> results = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtracking(candidates, 0);
        return results;
    }

    public void backtracking(int[] candidates, int start) {
        if (sum(path) == target)
            results.add(new ArrayList(path));
        if (sum(path) > target)
            return;
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, i + 1);
            path.removeLast();
            while (i<candidates.length-1&&candidates[i]==candidates[i+1]) i++;
        }
    }

    public int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
