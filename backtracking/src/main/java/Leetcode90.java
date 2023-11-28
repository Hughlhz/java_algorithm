import java.util.*;

public class Leetcode90 {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return results;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() >= 0) {
            results.add(new ArrayList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}


// 用集合完成去重  树层去重的话，注意定义集合得在backtracking方法中
class Leetcode90_ {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return results;
    }

    public void backtracking(int[] nums, int start) {
        HashSet<Integer> used = new HashSet<>();
        if (path.size() >= 0) {
            results.add(new ArrayList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                path.add(nums[i]);
                used.add(nums[i]);
            } else continue;
            backtracking(nums, i + 1);
            path.removeLast();
//            while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
        }
    }
}

//使用全局used数组进行去重 前提是排序了
// 利用used[]可以区分树枝上和树层上去重
class Leetcode90__ {
    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean used[];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return results;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() >= 0) {
            results.add(new ArrayList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            } else {
                path.add(nums[i]);
                used[i] = true;
            }
            backtracking(nums, i + 1);
            path.removeLast();
            used[i]=false;
//            while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
        }
    }
}


