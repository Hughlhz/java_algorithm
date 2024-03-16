import org.junit.Test;

public class LeetcodeTest {
    @Test
    public void leetcode509Test() {
        Leetcode509 leetcode509 = new Leetcode509();

        System.out.println(leetcode509.Fib(4));
    }

    @Test
    public void leetcode746Test() {
        Leetcode746 leetcode746 = new Leetcode746();
        int[] cost=new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(leetcode746.minCostClimbingStairs(cost));
    }

    @Test
    public void leetcode62Test() {
        Leetcode62 leetcode62 = new Leetcode62();
        System.out.println(leetcode62.uniquePaths(3, 8));
    }

}
