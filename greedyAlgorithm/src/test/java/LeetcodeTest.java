import org.junit.Test;

public class LeetcodeTest {
    @Test
    public void leetcode53Test() {
        Leetcode53 leetcode = new Leetcode53();
        System.out.println(leetcode.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    @Test
    public void leetcode455Test() {
        Leetcode455 leetcode = new Leetcode455();
        int[] g = {1, 2, 3};
        int[] s = {1, 2};
        System.out.println(leetcode.findContentChildren(g,s));
    }
    @Test
    public void leetcode376Test() {
        Leetcode376 leetcode = new Leetcode376();
        System.out.println(leetcode.wiggleMaxLength(new int[]{3,3,3,2,5}));

    }
    @Test
    public void leetcode122Test() {
        Leetcode122 leetcode = new Leetcode122();
        System.out.println(leetcode.maxProfit(new int[]{1,2,3,4,5}));
    }
    @Test
    public void leetcode55Test() {
        Leetcode55 leetcode = new Leetcode55();
        System.out.println(leetcode.canJump(new int[]{3,2,1,0,4}));

    }
    @Test
    public void leetcode45Test() {
        Leetcode45 leetcode = new Leetcode45();
        System.out.println(leetcode.jump(new int[]{2,3,1,1,4}));

    }
}
