import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Leetcode216 {
    List<List<Integer>> results=new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return results;
    }

    public int sum(List<Integer> list) {
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }

    // 总结：循环是用来做横向，递归用来做纵向
    public void backtracking(int k, int n,int start) {
        if (path.size() == k && sum(path) == n) {
            results.add(new ArrayList<>(path));
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtracking(k, n, i + 1);
            path.removeLast();
        }
    }

}
