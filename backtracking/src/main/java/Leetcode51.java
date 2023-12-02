import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {
    char[][] chessboard;
    List<List<String>> results = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        chessboard=new char[n][n];
        Arrays.stream(chessboard).forEach(v->Arrays.fill(v,'.'));

        backtracking(n,0);
        return results;
    }

    public void backtracking(int n,int depth) {
        if (depth == n) {
            results.add(array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isLegal(chessboard, i, depth)) {
                chessboard[depth][i] = 'Q';
                backtracking(n, depth+1);
                chessboard[depth][i] = '.';
            } else {
                continue;
            }
        }

    }

    boolean isLegal(char[][] chessboard, int x, int y) {
        //约束一：同行不能存在
            //由于是按行遍历 所以不会出现这种情况
        //约束二：同列不能存在
        //约束三：45度角和135度角不能存在
        for (int i = 0; i < y; i++) {
            if (chessboard[i][x] == 'Q'){
                return false;
            }
            // 135度
            if (x-y+i>=0&&x-y+i<chessboard.length&&chessboard[i][x - y + i] == 'Q' ) {
                return false;
            }
            //45度
            if (y+x-i>=0&&y+x-i<chessboard.length&&chessboard[i][y + x - i] == 'Q') {
                return false;
            }
            continue;
        }
        return true;
    }

    public List<String> array2List(char[][] charArray) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            strings.add(new String(charArray[i]));
        }
        return strings;
    }

}
