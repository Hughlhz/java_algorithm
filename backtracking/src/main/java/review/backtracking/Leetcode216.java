package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode216 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum=0;
    


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return results;
    }

    private void backtracking(int k, int n, int start) {
        if (sum == n && path.size()==k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum+=i;
            backtracking(k, n, i + 1);
            sum-=i;
            path.removeLast();
        }
    }
}
