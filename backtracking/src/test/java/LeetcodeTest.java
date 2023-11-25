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

    @Test
    public void leetcode17Test() {
        Leetcode17 leetcode17 = new Leetcode17();
        leetcode17.letterCombinations("");
        System.out.println(leetcode17.results);

    }
    @Test
    public void leetcode39Test() {
        Leetcode39 leetcode39 = new Leetcode39();
        leetcode39.combinationSum(new int[]{2,3,6,7},7);
        System.out.println(leetcode39.results);
        for (int i = 0; i < leetcode39.results.size(); i++) {
            System.out.println(leetcode39.sum(leetcode39.results.get(i)));
        }

    }
}
