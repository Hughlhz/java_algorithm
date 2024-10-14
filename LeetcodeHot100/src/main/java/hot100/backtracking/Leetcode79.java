package hot100.backtracking;


public class Leetcode79 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[3][];
        board[0] = "ABCE".toCharArray();
        board[1] = "SFCS".toCharArray();
        board[2] = "ADEE".toCharArray();
        solution.exist(board,"ABCCED");

    }
    static class Solution {
        StringBuilder path = new StringBuilder();
        public boolean exist(char[][] board, String word) {
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(board[i][j]==word.charAt(0)){
                        used[i][j]=true;
                        path.append(board[i][j]);
                        if (dfs(board, i, j, used, word)) {
                            return true;
                        }
                        path.deleteCharAt(path.length() - 1);
                        used[i][j]=false;
                    }
                }
            }
            return false;
        }

        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private boolean dfs(char[][] board, int i, int j, boolean[][] used, String word) {
            if (path.length() == word.length()) {
                return true;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + dir[k][0];
                int y = j + dir[k][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(path.length()) && !used[x][y]) {
                    used[x][y]=true;
                    path.append(board[x][y]);
                    if (dfs(board, x, y, used, word)) {
                        return true;
                    }
                    path.deleteCharAt(path.length() - 1);
                    used[x][y]=false;
                }
            }
            return false;


        }
    }
}
