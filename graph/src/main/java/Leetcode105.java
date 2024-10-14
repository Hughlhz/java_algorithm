import java.util.ArrayList;

public class Leetcode105 {
    int [][]grid;
    boolean[][] visited;
    int count;
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
         m=grid.length;
         n=grid[0].length;
        visited=new boolean[m][n];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count=0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        return result.stream().max(((o1, o2) -> o1-o2)).orElse(0);
    }

    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int i, int j) {
        visited[i][j]=true;
        count++;
        for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1&&visited[x][y]==false){
                dfs(x,y);
            }
        }

    }
}
