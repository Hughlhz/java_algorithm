package hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode131 {
    class Solution{
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        public List<List<String>> partition(String s) {
            dfs(s, 0,0);
            return result;

        }

        private void dfs(String s, int start, int count) {
            if (count == s.length()) {
                result.add(new ArrayList<>(path));
            }
            for (int i = start; i < s.length(); i++) {
                if (isABA(s, start, i)) {
                    path.add(s.substring(start, i+1));
                    count+=i+1-start;
                    dfs(s,i+1,count);
                    count-=i+1-start;
                    path.removeLast();
                }
            }
        }

        private boolean isABA(String s, int start, int end) {
            while (end > start) {
                if(s.charAt(end--)!=s.charAt(start++)){
                    return false;
                }
            }
            return true;
        }
    }
}
