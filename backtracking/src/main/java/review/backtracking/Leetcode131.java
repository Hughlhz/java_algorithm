package review.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode131 {
    public List<List<String>> results = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(0,s);
        return results;
    }

    private void backtracking(int start,String s) {
        if (start == s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i+1))) {
                path.add(s.substring(start, i+1));
                backtracking(i + 1, s);
                path.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        for (; i < j; i++, j--) {
            if(s.charAt(i)!=s.charAt(j)) return  false;
        }
        return true;
    }
}
