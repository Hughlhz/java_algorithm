package hot100.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length <= 1) {
            return nums.length;
        }
        int head =nums[0];
        int expected=head+1;
        map.put(head, 1);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]) continue;
            if (nums[i] == expected) {
                expected++;
                map.computeIfPresent(head, (k,v) -> v + 1);
                continue;
            }
            head = nums[i];
            expected=head+1;
            map.put(head, 1);

        }
//        return map.values().stream().max(Integer::compareTo).get();
        //关于流的用法还有很多种
        //比如
        IntSummaryStatistics intSummaryStatistics = map.values().stream().mapToInt((x) -> x).summaryStatistics();
        return intSummaryStatistics.getMax();
    }

}
