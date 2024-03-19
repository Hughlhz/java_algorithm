import annotations.Star;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Leetcode349 {
    @Star

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Object> results = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                results.add(nums2[i]);
            }
        }
        return results.stream().mapToInt(x -> (int) x).toArray();

    }
}
