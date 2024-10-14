package hot100.backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Leetcode40 {
    class Solution{
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            boolean[] used = new boolean[candidates.length];
            dfs(0, 0, target,candidates,used);
            return result;
        }

        private void dfs(int start, int sum, int target,int[] candidates,boolean[] used) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1]&&!used[i-1]) {
                    continue;
                }
                path.add(candidates[i]);
                sum += candidates[i];

                used[i]=true;
                dfs(i+1, sum, target, candidates,used);
                used[i]=false;
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }
}
