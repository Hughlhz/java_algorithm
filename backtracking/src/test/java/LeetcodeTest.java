import org.junit.Test;
import review.backtracking.Leetcode17;

import java.util.Arrays;
import java.util.List;

public class LeetcodeTest {
    @Test
    public void leetcode77Test() {
        Leetcode77 leetcode77 = new Leetcode77();
        leetcode77.combine(5,2);
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
    public void leetcode17TestReview() {
        Leetcode17 leetcode17 = new Leetcode17();
        leetcode17.letterCombinations("23");
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
    public void leetcode39TestReview() {
        Leetcode39 leetcode39 = new Leetcode39();
        leetcode39.combinationSum(new int[]{2,3,6,7},7);
        System.out.println(leetcode39.results);
//        for (int i = 0; i < leetcode39.results.size(); i++) {
//            System.out.println(leetcode39.sum(leetcode39.results.get(i)));
//        }

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
    public void leetcode131TestReview() {
        review.backtracking.Leetcode131 leetcode131 = new review.backtracking.Leetcode131();
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
        Leetcode90__ leetcode90 = new Leetcode90__();
        leetcode90.subsetsWithDup(new int[]{1,2,2});
        System.out.println(leetcode90.results);
    }
    @Test
    public void leetcode491Test() {
        Leetcode491 leetcode = new Leetcode491();
        leetcode.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        System.out.println(leetcode.results);
    }
    @Test
    public void leetcode46Test() {
        Leetcode46 leetcode = new Leetcode46();
        leetcode.permute(new int[]{1,2,3});
        System.out.println(leetcode.results);
    }
    @Test
    public void leetcode47Test() {
        Leetcode47 leetcode = new Leetcode47();
        leetcode.permuteUnique(new int[]{1,1,3});
        System.out.println(leetcode.results);
    }

    @Test
    public void leetcode332Test() {
        Leetcode332_ leetcode = new Leetcode332_();
        List<List<String>> tickekts = Arrays.asList(
//                Arrays.asList("JFK", "SFO"),
//                Arrays.asList("JFK", "ATL"),
//                Arrays.asList("SFO", "ATL"),
//                Arrays.asList("ATL","JFK"),
//                Arrays.asList("ATL","SFO")
                //
//                Arrays.asList("JFK","KUL"),
//                Arrays.asList("JFK","NRT"),
//                Arrays.asList("NRT","JFK")
                Arrays.asList("EZE","TIA"),
                Arrays.asList("EZE","HBA"),
                Arrays.asList("AXA","TIA"),
                Arrays.asList("JFK","AXA"),
                Arrays.asList("ANU","JFK"),
                Arrays.asList("ADL","ANU"),
                Arrays.asList("TIA","AUA"),
                Arrays.asList("ANU","AUA"),
                Arrays.asList("ADL","EZE"),
                Arrays.asList("ADL","EZE"),
                Arrays.asList("EZE","ADL"),
                Arrays.asList("AXA","EZE"),
                Arrays.asList("AUA","AXA"),
                Arrays.asList("JFK","AXA"),
                Arrays.asList("AXA","AUA"),
                Arrays.asList("AUA","ADL"),
                Arrays.asList("ANU","EZE"),
                Arrays.asList("TIA","ADL"),
                Arrays.asList("EZE","ANU"),
                Arrays.asList("AUA","ANU")

                );

        leetcode.findItinerary(tickekts);
        System.out.println(leetcode.result);
    }

    @Test
    public void leetcode51Test() {
        Leetcode51 leetcode = new Leetcode51();
//        char[][] charArray = {{'1', '2', '3', '4'}, {'1', '2', '3', '4'}, {'1', '2', '3', '4'}, {'1', '2', '3', '4'}};
//        char[][] charArray = new char[4][4];
//        Arrays.stream(charArray).forEach(v->Arrays.fill(v,'.'));
        leetcode.solveNQueens(4);
        System.out.println(leetcode.results);

    }
    @Test
    public void leetcode51_isLegalTest() {
        Leetcode51 leetcode = new Leetcode51();
        char[][] charArray = {{'Q', '.', '.', '.'}, {'.', '.', 'Q', '.'}, {'.', '.', '.', 'Q'}, {'.', '.', '.', '.'}};
//        char[][] charArray = new char[4][4];
//        Arrays.stream(charArray).forEach(v->Arrays.fill(v,'.'));
        System.out.println(leetcode.isLegal(charArray, 3, 2));
    }

    @Test
    public void leetcode37_isLegalTest() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Leetcode37 leetcode37 = new Leetcode37(board);
//        List<String> strings = leetcode37.array2List(board);
//        strings.stream().forEach(System.out::println);
//        System.out.println(leetcode37.isLegal(5, 3, '2'));
        leetcode37.solveSudoku(board);
        List<String> strings = leetcode37.array2List(leetcode37.board);
        strings.stream().forEach(System.out::println);

    }
    @Test
    public void generalTest() {
        System.out.println(1/3);
    }
}
