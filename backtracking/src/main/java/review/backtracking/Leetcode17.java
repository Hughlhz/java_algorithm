package review.backtracking;

import java.util.*;

public class Leetcode17 {
    Map<Character, String> digits_map = new HashMap<>();
    public List<String> results = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        digits_map.put('2', "abc");
        digits_map.put('3', "def");
        digits_map.put('4', "ghi");
        digits_map.put('5', "jkl");
        digits_map.put('6', "mno");
        digits_map.put('7', "pqrs");
        digits_map.put('8', "tuv");
        digits_map.put('9', "wxyz");
        backtracking(digits, 0);
        return results;
    }

    private void backtracking(String digits, int depth) {
        if (path.length() == digits.length()) {
            results.add(new String(path));
            return;
        }
        for (int i = 0; i <digits_map.get(digits.charAt(depth)).length() ; i++) {
            path.append(digits_map.get(digits.charAt(depth)).charAt(i));
            backtracking(digits, depth+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
