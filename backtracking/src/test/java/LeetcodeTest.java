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

    @Test
    public void leetcode40Test() {
        Leetcode40 leetcode40 = new Leetcode40();
        leetcode40.combinationSum2(new int[]{1,1,2,5,6,7,7},8);
        for (int i = 0; i < leetcode40.results.size(); i++) {
            System.out.println(leetcode40.results.get(i));
        }
    }

    @Test
    public void leetcode131Test() {
        Leetcode131 leetcode131 = new Leetcode131();
        leetcode131.partition("aab");
        System.out.println(leetcode131.results);
    }

    @Test
    public void leetcode93Test() {
        Leetcode93 leetcode93 = new Leetcode93();
        leetcode93.restoreIpAddresses("25525511135");
        System.out.println(leetcode93.final_results);
    }

    @Test
    public void IPTest() {
        Leetcode93 leetcode93 = new Leetcode93();
        System.out.println(leetcode93.isSubIP("01"));
    }
    @Test
    public void leetcode78Test() {
        Leetcode78 leetcode78 = new Leetcode78();
        leetcode78.subsets(new int[]{1,2,3});
        System.out.println(leetcode78.results);
    }
    @Test
    public void leetcode90Test() {
        Leetcode90 leetcode90 = new Leetcode90();
        leetcode90.subsetsWithDup(new int[]{1,2,2});
        System.out.println(leetcode90.results);
    }
}
