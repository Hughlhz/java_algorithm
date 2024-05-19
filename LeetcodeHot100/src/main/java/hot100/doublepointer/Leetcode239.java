package hot100.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList();
        ArrayList<Integer> result = new ArrayList<>();
        int n=nums.length;
        if (k > n) {
            return new int[0];
        }
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        result.add(queue.getFirst());
        int fast=k,slow=0;
        while (fast < n) {
            if(nums[slow++]==queue.getFirst()) queue.removeFirst();
            while (!queue.isEmpty() && queue.getLast() < nums[fast]) {
                queue.removeLast();
            }
            queue.add(nums[fast]);
            result.add(queue.getFirst());
            fast++;
        }
        return result.stream().mapToInt(e -> e).toArray();
    }
}
