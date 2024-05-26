import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode200 {
    static char[][] grid;
    static boolean[][] visited ;

    public static int numIslands(char[][] grid) {
        Leetcode200.grid=grid;
        Leetcode200.visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j]=true;
                    count++;
//                    dfs(i, j);
                    bfs(i, j);
                }
            }
        }
        return count;
    }
    static class Pair{
        //Pair类可以直接用数组代替，传递一个数组保存二元组
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void bfs(int i, int j) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            visited[p.x][p.y]=true;
            for (int k = 0; k < 4; k++) {
                int nextX = p.x + dir[k][0];
                int nextY = p.y + dir[k][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length||visited[nextX][nextY]||grid[nextX][nextY]=='0') continue;
                queue.add(new Pair(nextX, nextY));
                visited[nextX][nextY]=true;//要立刻标记成true，因为进入队列一定会访问
            }
        }
    }

    static int  dir[][] = new int[][]{{0, 1},{ 1, 0}, {-1, 0}, {0, -1}};//java 初始化 不要给长度和宽度

    //两种dfs都可以处理当前节点或者只处理子节点
    private static void dfs(int i, int j) {
//        if (visited[i][j] || grid[i][j] == '0') {
//            return;
//        }
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int x = i + dir[k][0];
            int y = i + dir[k][1];
            if(x<0||x>=grid.length||y<0||y>=grid[0].length||visited[x][y]||grid[x][y]=='0')continue;
            visited[x][y]=true;
            dfs(x, y);
        }
    }



}
