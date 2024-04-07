package test.hot100.dynamic;

import hot100.dynamic.Leetcode198;
import hot100.dynamic.Leetcode700;
import org.junit.Test;

public class LeetcodeTest {
    @Test
    public void leetcode198() {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.rob(new int[]{2,1,1, 2}));
    }

    @Test
    public void leetcode700() {
        Leetcode700 leetcode700 = new Leetcode700();
        leetcode700.numTrees(4);
    }
}
