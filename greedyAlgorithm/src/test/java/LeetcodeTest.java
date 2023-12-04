import org.junit.Test;

public class LeetcodeTest {
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
}
