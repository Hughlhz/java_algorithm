package CSDN10;

import children.CloudService;
import org.junit.Test;

public class LeetcodeTest {
    @Test
    public void leetcode300Test() {
        Leetcode300 leetcode300 = new Leetcode300();
        leetcode300.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

    }

    @Test
    public void leetcode79Test() {
        Leetcode79 leetcode79 = new Leetcode79();
        char[][] board = new char[3][4];
        board[0]="ABCE".toCharArray();
        board[1]="SFCS".toCharArray();
        board[2]="ADEE".toCharArray();
        leetcode79.exist(board,"ABCCED");
    }

}
