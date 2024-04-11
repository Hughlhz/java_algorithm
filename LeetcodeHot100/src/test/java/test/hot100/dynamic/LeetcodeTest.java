package test.hot100.dynamic;

import hot100.dynamic.*;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

public class LeetcodeTest {
    @Test
    public void leetcode198() {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.rob(new int[]{2, 1, 1, 2}));
    }

    @Test
    public void leetcode700() {
        Leetcode700 leetcode700 = new Leetcode700();
        leetcode700.numTrees(4);
    }

    @Test
    public void leetcode416() {
        Leetcode416 leetcode416 = new Leetcode416();
        leetcode416.canPartition(new int[]{1, 5, 11, 5});
    }

    @Test
    public void leetcode474() {
        Leetcode474 leetcode474 = new Leetcode474();
        System.out.println(leetcode474.oneCount("00111"));
        System.out.println(leetcode474.zeroCount("00111"));

    }

    @Test
    public void leetcode322() {
        Leetcode322 leetcode322 = new Leetcode322();
        leetcode322.coinChange(new int[]{ 2}, 3);
    }
}
