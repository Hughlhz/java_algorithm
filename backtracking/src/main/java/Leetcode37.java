import java.util.ArrayList;
import java.util.List;

public class Leetcode37 {
    char[][] board;

    public Leetcode37(char[][] board) {
        this.board = board;
    }

    public void solveSudoku(char[][] board) {
        this.board=board;
        backtracking();
    }

    public boolean backtracking() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isLegal(j, i, ch)) {
                        board[i][j]=ch;
                        if (backtracking()) {
                            return true;
                        }
                        board[i][j]='.';
                    }else continue;
                }
                return false;
            }
        }
        return true;
    }

    boolean isLegal(int x, int y, char ch) {
        for (int i = 0; i < 9; i++) {
            if(board[y][i]==ch&&i!=x) return false;
        }
        for (int i = 0; i < 9; i++) {
            if(board[i][x]==ch&&i!=y) return false;
        }
        int block_x=(x/3)*3,block_y=(y/3)*3;
        for (int i = block_x; i < block_x + 3; i++) {
            for (int j = block_y; j < block_y + 3; j++) {
                if(board[j][i]==ch&&i!=x&&j!=y) return false;
            }
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
