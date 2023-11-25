import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode17 {
    List<String> results = new ArrayList<>();
    StringBuilder path=new StringBuilder();
    HashMap<Integer, String> digit_map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        digit_map.put(2,"abc");
        digit_map.put(3,"def");
        digit_map.put(4,"ghi");
        digit_map.put(5,"jkl");
        digit_map.put(6,"mno");
        digit_map.put(7,"pqrs");
        digit_map.put(8,"tuv");
        digit_map.put(9,"wxyz");
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        backtracking(digits,0,0);
        return  results;

    }

    void backtracking(String  digits, int start,int depth) {
        if (path.length() == digits.length()) {
            results.add(new String(path));
            return;
        }
        for(int i=start;i<digit_map.get(Character.getNumericValue(digits.charAt(depth))).length();i++){
            path.append(digit_map.get(Character.getNumericValue(digits.charAt(depth))).charAt(i));

            backtracking(digits,0,depth+1);
            path.deleteCharAt(path.length()-1);

        }


    }
}
