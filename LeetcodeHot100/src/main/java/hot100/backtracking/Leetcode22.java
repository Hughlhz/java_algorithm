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
}
