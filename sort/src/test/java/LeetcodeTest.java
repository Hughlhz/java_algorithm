import org.junit.Test;

import java.util.Arrays;

public class LeetcodeTest {
    @Test
    public void leetcode912Test() {
        int[] nums={5,1,1,2,0,0};
        Leetcode912 leetcode = new Leetcode912();
        int sorted[]=leetcode.sortArray(nums);
        Arrays.stream(sorted).asLongStream().forEach(System.out::println);

    }
}
