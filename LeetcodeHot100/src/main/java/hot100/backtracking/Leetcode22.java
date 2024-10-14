package hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode22 {
    List<String> result=new ArrayList<>();
//    List<String> path=new LinkedList<>();
    StringBuilder path = new StringBuilder();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        backtracking(0,0);
        return result;
    }
    void backtracking(int depth,int leftCount){
        if(path.length()==2*n){
            result.add(path.toString());
            return;
        }
            if(leftCount>3||leftCount<depth-leftCount) return;
            if(leftCount>depth-leftCount){
                path.append("(");
                backtracking(depth + 1, leftCount);
                path.deleteCharAt(path.length() - 1);
                path.append(")");
                backtracking(depth + 1, leftCount+1);
                path.deleteCharAt(path.length() - 1);
            }
    }

    class Solution {
        List<String> result=new ArrayList<>();
        StringBuilder path = new StringBuilder();
        public List<String> generateParenthesis(int n) {
            dfs(0, 0,n);
            return result;
        }

        private void dfs(int l, int r,int n) {
            if (l + r == n * 2) {
                result.add(path.toString());
                return;
            }
            char[] candiates=null;
            if(l<n){
                if (l <= r) {
                    candiates = new char[]{'('};
                } else {
                    candiates = new char[]{'(', ')'};
                }
            }else {
                candiates = new char[]{')'};
            }
            for (int i = 0; i < candiates.length; i++) {
                path.append(candiates[i]);
                if(candiates[i]=='(') {
                    dfs(l + 1, r, n);
                    path.deleteCharAt(path.length() - 1);
                }else {
                    dfs(l, r + 1, n);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }
}
