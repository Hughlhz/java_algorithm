package hot100.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int fast=0,slow=0;
        int[] cnt = new int[128];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i)]++;
        }
        while (fast < s.length()) {
            if (cnt[s.charAt(fast)] > 0) {
                cnt[s.charAt(fast++)]--;
                if (fast - slow == p.length()) {
                    result.add(slow);
                }
            }else {
                cnt[s.charAt(slow++)]++;
            }
        }
        return  result;
    }
}
