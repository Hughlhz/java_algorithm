package CSDN10;

import annotations.Star;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Star("涉及到(x,y)这种值对时，可以自定义一个Pair类")
public class Leetcode79 {
    LinkedList<Pair> path = new LinkedList<>();
    boolean flag=false;
    String word;
    int m;
    int n;
    char[][] board;
    boolean[][] used ;

    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        this .m=board.length;
        this. n=board[0].length;
        this.used = new boolean[m][n];
        if (m == 1 && n == 1) {
            return word.length()==1&&board[0][0] == word.toCharArray()[0];
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if( backtracking(new Pair(i,j)) ){
                    return true;
                }
            }
        }
        return flag;
    }
    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean backtracking(Pair p) {
        if (path.size() == word.length()) {
            flag=true;
            return true;
        }
        for (Pair pair : adj(p)){
            if(board[pair.x][pair.y]==word.charAt(path.size())){
                path.add(pair);
                used[pair.x][pair.y]=true;

                if(backtracking(pair)) return true;
                path.removeLast();
                used[pair.x][pair.y]=false;
            }
        }
        return false;


    }

    private List<Pair> adj(Pair pair) {
        //找邻近且没到过的 坐标对
        ArrayList<Pair> pairs = new ArrayList<>();
        if(pair.x-1>=0&&!used[pair.x-1][pair.y]){
            pairs.add(new Pair(pair.x-1,pair.y));
        }
        if(pair.y-1>=0&&!used[pair.x][pair.y-1]){
            pairs.add(new Pair(pair.x,pair.y-1));

        }
        if(pair.x+1<m&&!used[pair.x+1][pair.y]){
            pairs.add(new Pair(pair.x+1,pair.y));
        }
        if(pair.y+1<n&&!used[pair.x][pair.y+1]){
            pairs.add(new Pair(pair.x,pair.y+1));
        }
        return pairs;
    }
}
