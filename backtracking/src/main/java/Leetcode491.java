import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Leetcode491 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return results;
    }

    public void backtracking(int[] nums, int start) {
        HashSet<Integer> used = new HashSet<Integer>();

        if (path.size() >= 2) {
            results.add(new ArrayList<>(path));
        }
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
//            if ((path.size()==0 || nums[i] >= path.get(path.size() - 1)) && !used.contains(nums[i])) {
            if(!used.contains(nums[i]) && (path.size()==0 || nums[i] >= path.get(path.size() - 1))){
                path.add(nums[i]);
                used.add(nums[i]);
            }else continue;
            backtracking(nums,i+1);
            path.removeLast();

        }

    }
}
