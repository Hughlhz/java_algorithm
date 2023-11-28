import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode131 {
    List<List<String>> results = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return results;
    }

    public void backtracking(String s, int start) {
        if (start >= s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                path.add(s.substring(start,i+1));
            }else continue;
            backtracking(s, i + 1);
            path.removeLast();
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
