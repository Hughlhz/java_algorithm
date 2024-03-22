package test.hot100.doublepointer;

import hot100.doublepointer.Leetcode15;
import hot100.doublepointer.Leetcode42;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetcodeTest {
    @Test
    public void leetcode15Test() {
        Leetcode15 leetcode15 = new Leetcode15();
        List<Integer> list = Arrays.asList(-1, 0, 1, 2, -1, -4);
        List<List<Integer>> results = leetcode15.threeSum(list.stream().mapToInt(Integer::intValue).toArray());
        results.stream().forEach(System.out::println);
    }
    @Test
    public void leetcode42Test() {
        Leetcode42 leetcode = new Leetcode42();
//        List<Integer> list = Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1);
        List<Integer> list = Arrays.asList(5,4,1,2);
        int result = leetcode.trap(list.stream().mapToInt(Integer::intValue).toArray());
        System.out.println(result);
    }
}
