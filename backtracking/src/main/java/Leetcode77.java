import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {


        backtracking(n,k,1);
        return results;
    }

    private void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i <= n; i++) {
            if(k-path.size()>n-i+1) return;//剪枝优化，可以直接优化为循环提前结束
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
