package hot100.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Leetcode347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int topK) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] result = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(topK).mapToInt(o -> o.getKey()).toArray();
            return result;
        }
    }
}
