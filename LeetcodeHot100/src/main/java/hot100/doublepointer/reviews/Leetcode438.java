package hot100.doublepointer.reviews;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] map = new int[128];
            for (int i = 0; i < p.length(); i++) {
                map[i]++;
            }
            int count = p.length();
            int fast = 0, slow = 0;
            List<Integer> result = new ArrayList<>();
            while (fast < s.length()) {
                if (map[s.charAt(fast)] > 0) {
                    map[s.charAt(fast++)]--;
                    if (fast - slow == s.length()) {
                        result.add(slow);
                    }
                }
                while (map[fast] <= 0) {
                    map[s.charAt(slow++)]++;
                }

            }
            return result;
        }
    }
}
