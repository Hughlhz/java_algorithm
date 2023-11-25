import org.junit.Test;

public class LeetcodeTest {
    @Test
    public void leetcode77Test() {
        Leetcode77 leetcode77 = new Leetcode77();
        leetcode77.combine(4,2);
        System.out.println(leetcode77.results);
    }

    @Test
    public void leetcode216Test() {
        Leetcode216 leetcode216 = new Leetcode216();
        leetcode216.combinationSum3(3,7);
        System.out.println(leetcode216.results);
        for (int i = 0; i < leetcode216.results.size(); i++) {
            System.out.println(leetcode216.sum(leetcode216.results.get(i)));
        }

    }
}
