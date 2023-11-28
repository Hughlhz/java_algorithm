import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {
    List<List<Integer>> results = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        results.add(new ArrayList<>());
        return results;
    }

    public void backtracking(int[] nums,int start) {
        if (path.size() >= 1) {
            results.add(new ArrayList<>(path));
        }
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
